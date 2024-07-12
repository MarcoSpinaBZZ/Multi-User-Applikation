package ch.zli.m223.controller.booking;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ch.zli.m223.controller.user.dto.BookingAdminDto;
import ch.zli.m223.controller.user.dto.StatusUpdateDto;
import ch.zli.m223.model.AppUser;
import ch.zli.m223.model.Booking;
import ch.zli.m223.model.impl.BookingImpl;
import ch.zli.m223.service.user.UserService;



@RestController
@RequestMapping("/api/v1/admin/bookings")
public class bookingAdminController {
    
    @Autowired
    private ch.zli.m223.service.user.BookingService bookingService;

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
    public List<BookingImpl> getBookingByUserId(@PathVariable Long userId) {
        List<BookingImpl> bookings = bookingService.getUserId(userId);
        if (bookings != null) {
            return bookings;
        } else {
            return new ArrayList<>();
        }
    }


    @GetMapping("/date/{date}")
    List<BookingImpl> getBookingByDate(@PathVariable("date") String date){
        return bookingService.getDate(date);
    }
    
    @PostMapping("")
    public BookingImpl addBooking(@RequestBody BookingAdminDto bookingDto, Principal principal){
        AppUser user = userService.getUserByName(principal.getName());
        return bookingService.addBooking(user.getId(), bookingDto.bookingDate, bookingDto.duration);
    }

    @PatchMapping("/{id}")
    public BookingImpl update(@PathVariable Long id, @RequestBody StatusUpdateDto status){

        return bookingService.updateBookingStatus(id, status.status);
    }

    @DeleteMapping("/{id}")
    public void deleteBooking(@PathVariable("id") Long id){
        bookingService.deleteBooking(id);
    }
}