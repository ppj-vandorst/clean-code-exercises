package com.novi.easyboat.services;

import com.novi.easyboat.exceptions.InvalidBookingException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculationServiceTest {
    private CalculationService calculationService;

    @BeforeEach
    public void beforeEach() {
        calculationService = new CalculationServiceImpl();
    }

    // CalculateDiscount

    @Test
    void CalculateDiscountWhenIPutInNoDiscountCode0IsReturned() {
        var discount = calculationService.calculateDiscount(200, null);

        assertThat(discount).isEqualTo(0);
    }

    @Test
    void CalculateDiscountWhenIPutInEZBOAT2021_100IsReturned() {
        var discount = calculationService.calculateDiscount(200, "EZBOAT2021");

        assertThat(discount).isEqualTo(100);
    }

    @Test
    void CalculateDiscountWhenIPutInEZ2021_20PercentOfChargeIsReturned() {
        var discount = calculationService.calculateDiscount(200, "EZ2021");

        assertThat(discount).isEqualTo(40);
    }

    @Test
    void CalculateDiscountWhenIPutInAnInvalidDiscountCodeAnExceptionIsThrown() {
        assertThrows(InvalidBookingException.class, () -> calculationService.calculateDiscount(200, "INVALID"));
    }

    // CalculateCharge
    @Test
    void CalculateChargeWhenIPutInAValidStartAndEndTimeACorrectChargeIsReturned() {
        var result = calculationService.calculateCharge(LocalDateTime.parse("2021-01-01T12:00:00"), LocalDateTime.parse("2021-01-01T14:00:00"));
        assertThat(result).isEqualTo(100);
    }

    @Test
    void CalculateChargeWhenIPutInAStartAndEndTimeWithDuration0AnExceptionIsThrown() {
        assertThrows(InvalidBookingException.class, () -> calculationService.calculateCharge(LocalDateTime.parse("2021-01-01T12:00:00"), LocalDateTime.parse("2021-01-01T12:00:00")));
    }

    @Test
    void CalculateChargeWhenIPutInAStartAndEndTimeWithADurationOver24HoursAnExceptionIsThrown() {
        assertThrows(InvalidBookingException.class, () -> calculationService.calculateCharge(LocalDateTime.parse("2021-01-01T12:00:00"), LocalDateTime.parse("2021-01-03T12:00:00")));
    }

}
