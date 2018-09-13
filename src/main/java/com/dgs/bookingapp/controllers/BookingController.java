package com.dgs.bookingapp.controllers;

import com.dgs.bookingapp.dao.BookingRepository;
import com.dgs.bookingapp.model.HotelBooking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookingController {

    private BookingRepository bookingRepository;

    @Autowired
    public BookingController(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @GetMapping("/all")
    public List<HotelBooking> getALl() {

        return bookingRepository.findAll();
    }

    @GetMapping("/affordable/{price}")
    public List<HotelBooking> getAffordable(@PathVariable double price) {

        return bookingRepository.findByPricePerNightLessThan(price);
    }

    @PostMapping("/create")
    public HotelBooking create(@RequestBody HotelBooking hotelBooking) {

        return bookingRepository.save(hotelBooking);
    }

    @PutMapping("/update")
    public HotelBooking update(@RequestBody HotelBooking hotelBooking) {

        return bookingRepository.save(hotelBooking);
    }

    @DeleteMapping("/delete/{id}")
    public List<HotelBooking> remove(@PathVariable long id) {
        bookingRepository.deleteById(id);

        return bookingRepository.findAll();
    }
}
