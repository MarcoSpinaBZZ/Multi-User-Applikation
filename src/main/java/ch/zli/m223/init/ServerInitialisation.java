package ch.zli.m223.init;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import ch.zli.m223.repository.RoleRepository;
import ch.zli.m223.roles.UserRoles;
import ch.zli.m223.service.user.BookingService;
import ch.zli.m223.service.user.UserService;
import lombok.RequiredArgsConstructor;
import ch.zli.m223.model.Booking;

@Component
@RequiredArgsConstructor
public class ServerInitialisation implements ApplicationRunner {

    private final UserService userService;
    private final RoleRepository roleRepository;
    private final BookingService bookingService;

    @Value("${test.data.create.user:false}")
    private boolean createTestDataForUser;
    

    @Override
    public void run(ApplicationArguments args) throws Exception {
        if (createTestDataForUser) {
            roleRepository.addRole(UserRoles.member);
            roleRepository.addRole(UserRoles.admin);
            
            userService.addUser("admin", "admin", "admin@admin.com", "admin");
            userService.addUser("Rolf", "Wolf", "rolf@wolf.com", "rolfwolf");
            userService.addUser("Johan", "Steiner", "johan@steiner.com", "joahnsteiner");

            bookingService.addBooking(1L, "2024-07-21", Booking.Duration.FULL_DAY);
            bookingService.addBooking(1L, "2024-07-22", Booking.Duration.MORNING);
            bookingService.addBooking(1L, "2024-07-22", Booking.Duration.AFTERNOON);
            bookingService.addBooking(2L, "2024-07-23", Booking.Duration.FULL_DAY);
            bookingService.addBooking(2L, "2024-07-24", Booking.Duration.MORNING);
        }

    }
    
}
