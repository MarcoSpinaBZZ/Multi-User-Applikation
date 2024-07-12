package ch.zli.m223.model.impl;

import ch.zli.m223.model.Booking;
import jakarta.persistence.*;

@Entity(name = "Booking")
public class BookingImpl implements Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "user_id")
    private Long userId;

    @Column(nullable = false, name = "date_of_booking")
    private String bookingDate;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, name = "type_of_booking")
    private Duration duration;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, name = "booking_status")
    private BookingStatus bookingStatus;

    public BookingImpl() {}

    public BookingImpl(Long userId, String bookingDate, Duration duration, BookingStatus bookingStatus) {
        this.userId = userId;
        this.bookingDate = bookingDate;
        this.duration = duration;
        this.bookingStatus = bookingStatus;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public Long getUserId() {
        return userId;
    }

    @Override
    public String getDate() {
        return bookingDate;
    }

    @Override
    public Duration getDuration() {
        return duration;
    }

    @Override
    public BookingStatus getStatus() {
        return bookingStatus;
    }

    @Override
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public void setDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    @Override
    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    @Override
    public void setStatus(BookingStatus bookingStatus) {
        this.bookingStatus = bookingStatus;
    }
}
