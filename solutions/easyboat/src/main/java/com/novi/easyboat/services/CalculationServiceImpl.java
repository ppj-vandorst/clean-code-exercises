package com.novi.easyboat.services;

import com.novi.easyboat.exceptions.InvalidBookingException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Service
public class CalculationServiceImpl implements CalculationService {

    /**
     * Calculates the base charge a customer has to pay for a booking
     *
     * @param actualStartTime The actual start time of the trip
     * @param actualEndTime   The actual end time of the trip
     * @return The amount the customer will have to pay for his trip
     */
    @Override
    public double calculateCharge(LocalDateTime actualStartTime, LocalDateTime actualEndTime) {
        var bookingDurationInHours = actualStartTime.until(actualEndTime, ChronoUnit.HOURS);

        // Validate the booking
        if (bookingDurationInHours == 0) {
            throw new InvalidBookingException("Invalid booking: duration in hours can not be 0");
        } else if (bookingDurationInHours > 24) {
            throw new InvalidBookingException("Invalid booking: duration can not exceed 24 hours");
        }

        return bookingDurationInHours * 50;
    }

    /**
     * Calculates the discount amount for a given booking
     *
     * @param bookingCharge The amount charged for the booking (minus discounts)
     * @param discountCode  The discountCode supplied by the customer
     * @return The discount amount which should be deducted from the charge
     */
    @Override
    public double calculateDiscount(double bookingCharge, String discountCode) {
        if (discountCode == null) {
            return 0;
        } else if (discountCode.equals("EZBOAT2021")) {
            return 100;
        } else if (discountCode.equals("EZ2021")) {
            return bookingCharge / 100 * 20;
        }

        throw new InvalidBookingException("Invalid booking: Encountered an invalid discountCode");
    }
}
