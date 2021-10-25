package com.novi.easyboat.services;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorServiceTest {

    @Test
    public void testAddAddsValues() {
        CalculatorService service = new CalculatorService();

        int result = service.add(5, 10);

        assertThat(result).isEqualTo(15);
    }

    @Test
    public void testMinusSubtractsValues() {
        CalculatorService service = new CalculatorService();

        int result = service.minus(5, 10);

        assertThat(result).isEqualTo(-5);
    }

    @Test
    public void testConcatConcatenatesStrings() {
        CalculatorService service = new CalculatorService();

        String result = service.concat("string 1", "string 2");

        assertThat(result).isEqualTo("string 1 - string 2");
    }

    @Test
    public void testMultiplyNonZeroValuesReturnsCorrectResult() {
        CalculatorService service = new CalculatorService();

        int result = service.multiply(2, 5);

        assertThat(result).isEqualTo(10);
    }

    @Test
    public void testMultiplyWithFirstValueZeroShouldThrowException() {
        CalculatorService service = new CalculatorService();

        assertThrows(RuntimeException.class, () -> service.multiply(0, 5));
    }

    @Test
    public void testMultiplyWithSecondValueZeroShouldThrowException() {
        CalculatorService service = new CalculatorService();

        assertThrows(RuntimeException.class, () -> service.multiply(5, 0));
    }
}
