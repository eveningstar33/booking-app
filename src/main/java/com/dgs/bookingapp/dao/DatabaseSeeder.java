package com.dgs.bookingapp.dao;

import com.dgs.bookingapp.dao.BookingRepository;
import com.dgs.bookingapp.model.HotelBooking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/*
After the app starts up, after all the beans are created, after the app context is created,
all the classes that implement CommandLineRunner are executed. This makes them perfectly
for initializing things within our app and I'm going to use it to create a database seeder,
so after the app starts will populate our database with some data and then we can use the
data inside our booking controller.
*/

@Component
public class DatabaseSeeder implements CommandLineRunner {

    private BookingRepository bookingRepository;

    @Autowired
    public DatabaseSeeder(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        List<HotelBooking> bookings = new ArrayList<>();

        bookings.add(new HotelBooking("Marriot", 200.50, 3));
        bookings.add(new HotelBooking("Ibis", 90, 4));
        bookings.add(new HotelBooking("Novotel", 140.74, 1));

        bookingRepository.saveAll(bookings);
    }


}
