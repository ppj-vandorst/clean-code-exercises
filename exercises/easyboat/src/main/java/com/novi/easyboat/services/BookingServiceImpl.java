package com.novi.easyboat.services;

import com.novi.easyboat.exceptions.BadRequestException;
import com.novi.easyboat.exceptions.NotFoundException;
import com.novi.easyboat.model.Boat;
import com.novi.easyboat.model.Booking;
import com.novi.easyboat.model.BookingStatus;
import com.novi.easyboat.repositories.BoatRepository;
import com.novi.easyboat.repositories.BookingRepository;
import com.novi.easyboat.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {
    private BookingRepository bookingRepository;
    private BoatRepository boatRepository;
    private CustomerRepository customerRepository;
    private CalculationService calculationService;

    @Autowired
    public BookingServiceImpl(BookingRepository bookingRepository, BoatRepository boatRepository,
                              CustomerRepository customerRepository, CalculationService calculationService) {
        this.bookingRepository = bookingRepository;
        this.boatRepository = boatRepository;
        this.customerRepository = customerRepository;
        this.calculationService = calculationService;
    }

    @Override
    public List<Booking> getBookingsBetweenDates(LocalDateTime start, LocalDateTime end) {
        return bookingRepository.findByPlannedStartTimeBetween(start, end);
    }

    @Override
    public List<Booking> getBookingsForBoat(Long boatId) {
        var optionalBoat = boatRepository.findById(boatId);

        if (optionalBoat.isPresent()) {
            var boat = optionalBoat.get();
            return bookingRepository.findByBoat(boat);
        } else {
            throw new NotFoundException();
        }
    }

    @Override
    public List<Booking> getBookingsForCustomer(Long customerId) {
        var optionalCustomer = customerRepository.findById(customerId);

        if (optionalCustomer.isPresent()) {
            var customer = optionalCustomer.get();
            return bookingRepository.findByCustomer(customer);
        } else {
            throw new NotFoundException();
        }
    }

    @Override
    public void planBooking(Long boatId, Long customerId, LocalDateTime plannedStartTime, LocalDateTime plannedEndTime) {
        var optionalCustomer = customerRepository.findById(customerId);
        var optionalBoat = boatRepository.findById(boatId);

        // If either the customer or boat does not exist, we throw an exception
        if (optionalCustomer.isEmpty() || optionalBoat.isEmpty()) {
            throw new NotFoundException();
        }

        var customer = optionalCustomer.get();
        var boat = optionalBoat.get();

        // Checks whether there is an overlap in the schedule, if there is an overlap it throws an exception
        validateBookingSlotIsFree(plannedStartTime, plannedEndTime, boat);

        // The booking details are valid, we create it and store it in the database
        var booking = new Booking();
        booking.setCustomer(customer);
        booking.setBoat(boat);
        booking.setPlannedStartTime(plannedStartTime);
        booking.setPlannedEndTime(plannedEndTime);
        booking.setStatus(BookingStatus.PLANNED);

        bookingRepository.save(booking);
    }

    private void validateBookingSlotIsFree(LocalDateTime startTime, LocalDateTime endTime, Boat boat) {
        var overlappingStartBookings = bookingRepository.findByPlannedStartTimeBetweenAndBoat(startTime,
                endTime, boat);
        var overlappingEndBookings = bookingRepository.findByPlannedEndTimeBetweenAndBoat(startTime,
                endTime, boat);
        if (overlappingStartBookings.size() > 0 || overlappingEndBookings.size() > 0) {
            throw new BadRequestException();
        }
    }

    @Override
    public Booking completeBooking(Long bookingId, LocalDateTime actualStartTime, LocalDateTime actualEndTime) {
        var optionalBooking = bookingRepository.findById(bookingId);

        if (optionalBooking.isEmpty()) {
            throw new NotFoundException();
        }
        var booking = optionalBooking.get();

        // Calculate the booking charge
        var baseCharge = calculationService.calculateCharge(actualStartTime, actualEndTime);
        var discount = calculationService.calculateDiscount(baseCharge, booking.getDiscountCode());
        var charge = baseCharge - discount;

        // Update and save the booking
        booking.setActualStartTime(actualStartTime);
        booking.setActualEndTime(actualEndTime);
        booking.setStatus(BookingStatus.INVOICED);
        booking.setCharge(charge);

        return bookingRepository.save(booking);
    }
}
