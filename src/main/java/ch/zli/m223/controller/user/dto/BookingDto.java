package ch.zli.m223.controller.user.dto;

import ch.zli.m223.model.Booking;

public class BookingDto {

    private String bookingDate;
    private Booking.Duration duration;

    public BookingDto() {}

    public BookingDto(String bookingDate, Booking.Duration duration) {
        this.bookingDate = bookingDate;
        this.duration = duration;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    public Booking.Duration getDuration() {
        return duration;
    }

    public void setDuration(Booking.Duration duration) {
        this.duration = duration;
    }
}
