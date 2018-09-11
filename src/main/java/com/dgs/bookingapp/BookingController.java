package com.dgs.bookingapp;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/bookings")
public class BookingController {

    private List<HotelBooking> bookings;

    public BookingController() {
        bookings = new ArrayList<>();
        bookings.add(new HotelBooking("Marriot", 200.50, 3));
        bookings.add(new HotelBooking("Ibis", 90, 4));
        bookings.add(new HotelBooking("Novotel", 140.74, 1));
    }

    @GetMapping("/all")
    public List<HotelBooking> getALl() {

        return bookings;
    }

    @GetMapping("/affordable/{price}")
    public List<HotelBooking> getAffordable(@PathVariable double price) {

        return bookings.stream()
                       .filter(x -> x.getPricePerNight() <= price)
                       .collect(Collectors.toList());
    }

    @PostMapping("/create")
    public List<HotelBooking> create(@RequestBody HotelBooking hotelBooking) {

        bookings.add(hotelBooking);

        return bookings;
    }

}
