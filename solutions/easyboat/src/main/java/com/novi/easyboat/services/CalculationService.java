package com.novi.easyboat.services;


import java.time.LocalDateTime;

public interface CalculationService {
    double calculateCharge(LocalDateTime actualStartTime, LocalDateTime actualEndTime);
    double calculateDiscount(double bookingCharge, String discountCode);
}
