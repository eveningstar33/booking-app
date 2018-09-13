package com.dgs.bookingapp.dao;

import com.dgs.bookingapp.model.Hotels;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<Hotels, Long> {

    List<Hotels> findByPricePerNightLessThan(double price);
}
