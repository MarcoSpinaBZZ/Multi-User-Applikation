package ch.zli.m223.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ch.zli.m223.model.impl.BookingImpl;

public interface BookingRepository extends JpaRepository<BookingImpl, Long>{
    List<BookingImpl> findByUserId(Long userId);
    List<BookingImpl> findByBookingDate(String bookingDate);
}