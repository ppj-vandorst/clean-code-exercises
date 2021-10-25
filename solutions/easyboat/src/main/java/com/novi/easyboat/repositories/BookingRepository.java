package com.novi.easyboat.repositories;

import com.novi.easyboat.model.Boat;
import com.novi.easyboat.model.Booking;
import com.novi.easyboat.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findByPlannedStartTimeBetween(LocalDateTime start, LocalDateTime end);

    List<Booking> findByCustomer(Customer customer);

    List<Booking> findByBoat(Boat boat);

    List<Booking> findByPlannedStartTimeBetweenAndBoat(LocalDateTime start, LocalDateTime end, Boat boat);

    List<Booking> findByPlannedEndTimeBetweenAndBoat(LocalDateTime start, LocalDateTime end, Boat boat);
}
