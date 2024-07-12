package ch.zli.m223.service.user;

import ch.zli.m223.model.Booking;
import ch.zli.m223.model.impl.BookingImpl;

import java.util.List;

public interface BookingService {
    List<Booking> getBookingList(String email);
    Booking getBooking(String email, Long id);
    List<BookingImpl> getDate(String date);
    List<BookingImpl> getUserId(Long userId);
    BookingImpl addBooking(Long userId, String bookingDate, Booking.Duration duration);
    Booking addBookingWithStatus(Long userId, String bookingDate, Booking.Duration duration, Booking.BookingStatus status);
    BookingImpl updateBookingStatus(Long id, Booking.BookingStatus status);
    void deleteBooking(Long id);
    void deleteBooking(Long bookingId, Long userId);
}
