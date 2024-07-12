package ch.zli.m223.service.user.impl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ch.zli.m223.model.AppUser;
import ch.zli.m223.model.Booking;
import ch.zli.m223.model.impl.BookingImpl;
import ch.zli.m223.repository.BookingRepository;
import ch.zli.m223.repository.UserRepository;
import ch.zli.m223.service.user.BookingService;
import ch.zli.m223.service.user.exception.BookingNotFoundException;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private UserRepository userRepository;

    public BookingServiceImpl(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @Override
    public List<Booking> getBookingList(String email) {
        AppUser user = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("User not found"));
        ch.zli.m223.model.Role roleFromEmail = user.getRole();
        if ("admin".equals(roleFromEmail.getRole())) {
            return new ArrayList<>(bookingRepository.findAll());
        } else {
            return new ArrayList<>(bookingRepository.findByUserId(user.getId()));
        }
    }

    @Override
    public Booking getBooking(String email, Long id) {
        AppUser user = userRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("User not found"));
        ch.zli.m223.model.Role roleFromEmail = user.getRole();
        if ("admin".equals(roleFromEmail.getRole())) {
            return bookingRepository.findById(id).orElseThrow(() -> new BookingNotFoundException());
        } else {
            Booking booking = bookingRepository.findById(id).orElseThrow(() -> new BookingNotFoundException());
            if (!booking.getUserId().equals(user.getId())) {
                throw new BookingNotFoundException();
            }
            return booking;
        }
    }

    @Override
    public List<BookingImpl> getDate(String date) {
        return bookingRepository.findByBookingDate(date);
    }

    @Override
    public List<BookingImpl> getUserId(Long userId) {
        return bookingRepository.findByUserId(userId);
    }

    @Override
    public BookingImpl addBooking(Long userId, String bookingDate, Booking.Duration duration) {
        if (bookingDate == null || bookingDate.isEmpty()) {
            throw new IllegalArgumentException("Booking date cannot be null or empty");
        }
        BookingImpl booking = new BookingImpl(userId, bookingDate, duration, Booking.BookingStatus.PENDING);
        return bookingRepository.save(booking);
    }

    @Override
    public Booking addBookingWithStatus(Long userId, String bookingDate, Booking.Duration duration, Booking.BookingStatus status) {
        if (bookingDate == null || bookingDate.isEmpty()) {
            throw new IllegalArgumentException("Booking date cannot be null or empty");
        }
        BookingImpl booking = new BookingImpl(userId, bookingDate, duration, status);
        return bookingRepository.save(booking);
    }

    @Override
    public BookingImpl updateBookingStatus(Long id, Booking.BookingStatus status) {
        BookingImpl booking = bookingRepository.findById(id).orElseThrow(() -> new RuntimeException("Booking not found"));
        booking.setStatus(status);
        return bookingRepository.save(booking);
    }

    @Override
    public void deleteBooking(Long id) {
        bookingRepository.deleteById(id);
    }

    @Override
    public void deleteBooking(Long bookingId, Long userId) {
        BookingImpl booking = bookingRepository.findById(bookingId).orElseThrow(() -> new RuntimeException("Booking not found"));
        if (!booking.getUserId().equals(userId)) {
            throw new RuntimeException("You can only delete your own bookings.");
        }
        bookingRepository.deleteById(bookingId);
    }
}
