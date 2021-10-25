package com.novi.easyboat.controllers.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.novi.easyboat.model.Booking;

import java.time.LocalDateTime;

public class BookingDto {
    @JsonSerialize
    Long id;

    @JsonSerialize
    BoatDto boat;

    @JsonSerialize
    CustomerDto customer;

    @JsonSerialize(using = LocalDateTimeSerializer.class)
    LocalDateTime startTime;

    @JsonSerialize(using = LocalDateTimeSerializer.class)
    LocalDateTime endTime;

    public static BookingDto fromBooking(Booking booking) {
        var dto = new BookingDto();
        dto.id = booking.getId();
        dto.boat = BoatDto.fromBoat(booking.getBoat());
        dto.customer = CustomerDto.fromCustomer(booking.getCustomer());
        dto.startTime = booking.getPlannedStartTime();
        dto.endTime = booking.getPlannedEndTime();
        return dto;
    }
}
