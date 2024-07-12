package ch.zli.m223.controller.user.dto;

import ch.zli.m223.model.Booking;

public class BookingAdminDto {
    public String bookingDate;
    public Booking.Duration duration;
    public Booking.BookingStatus status;

    public String getDate() {
        return bookingDate;
    }

    public void setDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    public Booking.Duration getDuration() {
        return duration;
    }

    public void setDuration(Booking.Duration duration) {
        this.duration = duration;
    }

    public Booking.BookingStatus getStatus() {
        return status;
    }

    public void setStatus(Booking.BookingStatus status) {
        this.status = status;
    }
    
}