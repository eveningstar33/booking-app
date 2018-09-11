package com.dgs.bookingapp.dao;

import com.dgs.bookingapp.model.HotelBooking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<HotelBooking, Long> {

    List<HotelBooking> findByPricePerNightLessThan(double price);
}
