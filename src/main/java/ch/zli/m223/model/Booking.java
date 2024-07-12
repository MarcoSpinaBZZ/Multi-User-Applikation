package ch.zli.m223.model;


public interface Booking {
        public Long getId();
        public Long getUserId();
        public String getDate();
        public Duration getDuration();
        public BookingStatus getStatus();

        public void setUserId(Long userId);
        public void setDate(String bookingDate);
        public void setDuration(Duration duration);
        public void setStatus(BookingStatus bookingStatus);

        enum BookingStatus {
            PENDING,
            CONFIRMED,
            REJECTED
        }

        enum Duration {
                MORNING,
                AFTERNOON,
                FULL_DAY
        }

}