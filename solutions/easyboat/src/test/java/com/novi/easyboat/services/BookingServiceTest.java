package com.novi.easyboat.services;

import com.novi.easyboat.model.Boat;
import com.novi.easyboat.model.Booking;
import com.novi.easyboat.model.BookingStatus;
import com.novi.easyboat.model.Customer;
import com.novi.easyboat.repositories.BoatRepository;
import com.novi.easyboat.repositories.BookingRepository;
import com.novi.easyboat.repositories.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BookingServiceTest {

    @Mock
    CustomerRepository customerRepository;

    @Mock
    BoatRepository boatRepository;

    @Mock
    BookingRepository bookingRepository;

    @InjectMocks
    private BookingServiceImpl bookingService;

    @Captor
    ArgumentCaptor<Booking> bookingCaptor;

    @Test
    public void planBookingTest() {
        Boat boat = new Boat();
        boat.setName("test");
        when(boatRepository.findById(1L)).thenReturn(Optional.empty());

        Customer customer = new Customer();
        customer.setFirstname("Henk");
        when(customerRepository.findById(1L)).thenReturn(Optional.of(customer));

        bookingService.planBooking(1L, 1L, LocalDateTime.parse("2021-01-01T12:00:00"), LocalDateTime.parse("2021-01-01T14:00:00"));

        verify(bookingRepository).save(bookingCaptor.capture());

        Booking booking = bookingCaptor.getValue();
        assertThat(booking.getStatus()).isEqualTo(BookingStatus.PLANNED);
        assertThat(booking.getCustomer()).isEqualTo(customer);
    }

    @Test
    public void planBookingShouldCorrectlyPlanAValidBooking() {
        var testBoat = new Boat();
        testBoat.setId(1L);
        testBoat.setName("Test boat");

        var testCustomer = new Customer();
        testCustomer.setId(1L);
        testCustomer.setFirstname("Henk");

        when(boatRepository.findById(1L)).thenReturn(Optional.of(testBoat));
        when(customerRepository.findById(1L)).thenReturn(Optional.of(testCustomer));

        bookingService.planBooking(1L, 1L, LocalDateTime.parse("2021-01-01T12:00:00"),
                LocalDateTime.parse("2021-01-01T16:00:00"));

        verify(bookingRepository, times(1)).save(bookingCaptor.capture());
        var booking = bookingCaptor.getValue();

        assertThat(booking.getStatus()).isEqualTo(BookingStatus.PLANNED);
        assertThat(booking.getBoat().getName()).isEqualTo("Test boat");
        assertThat(booking.getCustomer().getFirstname()).isEqualTo("Henk");
    }
}
