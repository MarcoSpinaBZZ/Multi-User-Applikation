package ch.zli.m223.controller.booking;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import ch.zli.m223.controller.user.dto.BookingDto;
import ch.zli.m223.model.AppUser;
import ch.zli.m223.model.Booking;
import ch.zli.m223.model.impl.BookingImpl;
import ch.zli.m223.service.user.BookingService;
import ch.zli.m223.service.user.UserService;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@RestController
@RequestMapping("/api/v1/member/bookings")
@RequiredArgsConstructor
public class BookingMemberController {

    @Autowired
    private BookingService bookingService;

    @Autowired
    private UserService userService;

    @GetMapping
    List<Booking> getBookingList(Principal principal){
        return bookingService.getBookingList(principal.getName());
    }

    @GetMapping("/{bookingId}")
    Booking getBookingByBookingId(Principal principal, @PathVariable("bookingId") Long bookingId){
        return bookingService.getBooking(principal.getName(), bookingId);
    }

    @GetMapping("/user/{userId}")
    List<BookingImpl> getBookingByUserId(@PathVariable("userId") Long userId){
        return bookingService.getUserId(userId);
    }

    @PostMapping("")
    public BookingImpl createBooking(@RequestBody BookingDto bookingDto, Principal principal) {
        AppUser user = userService.getUserByName(principal.getName());
        return bookingService.addBooking(user.getId(), bookingDto.getBookingDate(), bookingDto.getDuration());
    }

    @DeleteMapping("/{id}")
    public void deleteBooking(@PathVariable Long id, Principal principal) {
        AppUser user = userService.getUserByName(principal.getName());
        bookingService.deleteBooking(id, user.getId());
    }
    
}