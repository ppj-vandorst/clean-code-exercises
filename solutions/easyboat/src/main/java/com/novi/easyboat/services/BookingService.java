package com.novi.easyboat.services;

import com.novi.easyboat.model.Booking;

import java.time.LocalDateTime;
import java.util.List;

public interface BookingService {
    List<Booking> getBookingsBetweenDates(LocalDateTime start, LocalDateTime end);

    List<Booking> getBookingsForBoat(Long boatId);

    List<Booking> getBookingsForCustomer(Long customerId);

    void planBooking(Long boatId, Long customerId, LocalDateTime plannedStartTime, LocalDateTime plannedEndTime);

    Booking completeBooking(Long bookingId, LocalDateTime actualStartTime, LocalDateTime actualEndTime);
}
