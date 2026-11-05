package com.S16JAVA;
import java.util.ArrayList;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;
class Movie {
    private int movieId;
    private String movieName;
    private String genre;
    private String language;
    private int duration;
    public Movie(int movieId, String movieName, String genre,String language, int duration) {
        this.movieId = movieId;
        this.movieName = movieName;
        this.genre = genre;
        this.language = language;
        this.duration = duration;
    }
    public int getMovieId() {
        return movieId;
    }
    public String getMovieName() {
        return movieName;
    }
    public String getGenre() {
        return genre;
    }
    public String getLanguage() {
        return language;
    }
    public int getDuration() {
        return duration;
    }
    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }
    public void setLanguage(String language) {
        this.language = language;
    }
    public void setDuration(int duration) {
        this.duration = duration;
    }
    public static Movie findMovieById(ArrayList<Movie> movies, int id) {
        for (Movie movie : movies) {
            if (movie.getMovieId() == id) {
                return movie;
            }
        }
        return null;
    }
    public static Movie findMovieByName(ArrayList<Movie> movies, String name) {
        for (Movie movie : movies) {
            if (movie.getMovieName().equalsIgnoreCase(name)) {
                return movie;
            }
        }
        return null;
    }
    public static void displayMovies(ArrayList<Movie> movies) {
        if (movies.isEmpty()) {
            System.out.println("\nNo movies available.");
            return;
        }
        System.out.println("\n================ MOVIES ================");
        for (Movie movie : movies) {
            System.out.println("Movie ID  : " + movie.getMovieId());
            System.out.println("Name      : " + movie.getMovieName());
            System.out.println("Genre     : " + movie.getGenre());
            System.out.println("Language  : " + movie.getLanguage());
            System.out.println("Duration  : " + movie.getDuration() + " minutes");
            System.out.println("----------------------------------------");
        }
    }
    public static void addMovie(ArrayList<Movie> movies) {
        System.out.println("\n========== ADD MOVIE ==========");
        int id = CinemaBook.readInt("Enter Movie ID: ");
        if (findMovieById(movies, id) != null) {
            System.out.println("Movie ID already exists.");
            return;
        }
        String name = CinemaBook.readLine("Enter Movie Name: ");
        String genre = CinemaBook.readLine("Enter Genre: ");
        String language = CinemaBook.readLine("Enter Language: ");
        int duration = CinemaBook.readInt("Enter Duration in minutes: ");
        if (duration <= 0) {
            System.out.println("Duration must be greater than zero.");
            return;
        }
        movies.add(new Movie(id, name, genre, language, duration));
        System.out.println("Movie added successfully.");
    }
    public static void updateMovie(ArrayList<Movie> movies) {
        System.out.println("\n========== UPDATE MOVIE ==========");
        int id = CinemaBook.readInt("Enter Movie ID: ");
        Movie movie = findMovieById(movies, id);
        if (movie == null) {
            System.out.println("Movie not found.");
            return;
        }
        System.out.println("Current Movie Name: " + movie.getMovieName());

        String name = CinemaBook.readLine("Enter New Movie Name: ");
        String genre = CinemaBook.readLine("Enter New Genre: ");
        String language = CinemaBook.readLine("Enter New Language: ");
        int duration = CinemaBook.readInt("Enter New Duration: ");
        if (duration <= 0) {
            System.out.println("Duration must be greater than zero.");
            return;
        }
        movie.setMovieName(name);
        movie.setGenre(genre);
        movie.setLanguage(language);
        movie.setDuration(duration);
        System.out.println("Movie updated successfully.");
    }
}

class Screen {
    private int screenId;
    private String screenType;
    private int totalSeats;
    private String showTime;
    public Screen(int screenId, String screenType,int totalSeats, String showTime) {
        this.screenId = screenId;
        this.screenType = screenType;
        this.totalSeats = totalSeats;
        this.showTime = showTime;
    }
    public int getScreenId() {
        return screenId;
    }
    public String getScreenType() {
        return screenType;
    }
    public int getTotalSeats() {
        return totalSeats;
    }
    public String getShowTime() {
        return showTime;
    }
    public void setScreenType(String screenType) {
        this.screenType = screenType;
    }
    public void setTotalSeats(int totalSeats) {
        this.totalSeats = totalSeats;
    }
    public void setShowTime(String showTime) {
        this.showTime = showTime;
    }
    public static Screen findScreenById(ArrayList<Screen> screens,int id) {
        for (Screen screen : screens) {
            if (screen.getScreenId() == id) {
                return screen;
            }
        }
        return null;
    }
    public static Screen findScreenByName(ArrayList<Screen> screens, String name) {
        for (Screen screen : screens) {
            if (screen.getScreenType().equalsIgnoreCase(name)) {
                return screen;
            }
        }
        return null;
    }
    public static void displayScreens(ArrayList<Screen> screens) {
        if (screens.isEmpty()) {
            System.out.println("\nNo screens available.");
            return;
        }
        System.out.println("\n================ SCREENS ================");
        for (Screen screen : screens) {
            System.out.println("Screen ID   : " + screen.getScreenId());
            System.out.println("Screen Type : " + screen.getScreenType());
            System.out.println("Total Seats : " + screen.getTotalSeats());
            System.out.println("Show Time   : " + screen.getShowTime());
            System.out.println("------------------------------------------");
        }
    }
    public static void addScreen(ArrayList<Screen> screens) {
        System.out.println("\n========== ADD SCREEN ==========");
        int id = CinemaBook.readInt("Enter Screen ID: ");
        if (findScreenById(screens, id) != null) {
            System.out.println("Screen ID already exists.");
            return;
        }
        String type = CinemaBook.readLine("Enter Screen Type: ");
        int seats = CinemaBook.readInt("Enter Total Seats: ");
        String time = CinemaBook.readLine("Enter Show Time: ");
        if (seats <= 0) {
            System.out.println("Number of seats must be greater than zero.");
            return;
        }
        screens.add(new Screen(id, type, seats, time));
        System.out.println("Screen added successfully.");
    }
    public static void updateScreen(ArrayList<Screen> screens) {
        System.out.println("\n========== UPDATE SCREEN ==========");
        int id = CinemaBook.readInt("Enter Screen ID: ");
        Screen screen = findScreenById(screens, id);
        if (screen == null) {
            System.out.println("Screen not found.");
            return;
        }
        String type = CinemaBook.readLine("Enter New Screen Type: ");
        int seats = CinemaBook.readInt("Enter New Total Seats: ");
        String time = CinemaBook.readLine("Enter New Show Time: ");
        if (seats <= 0) {
            System.out.println("Number of seats must be greater than zero.");
            return;
        }
        screen.setScreenType(type);
        screen.setTotalSeats(seats);
        screen.setShowTime(time);

        System.out.println("Screen updated successfully.");
    }
    public static void checkAvailability(
            ArrayList<Screen> screens,
            ArrayList<Booking> bookings) {
        System.out.println("\n========== SCREEN AVAILABILITY ==========");
        if (screens.isEmpty()) {
            System.out.println("No screens available.");
            return;
        }
        for (Screen screen : screens) {
            long bookedSeats = bookings.stream().filter(b -> b.getScreenName().equalsIgnoreCase(screen.getScreenType())).filter(b -> !b.getStatus().equalsIgnoreCase("Cancelled")).count();
            int availableSeats =screen.getTotalSeats() - (int) bookedSeats;
            if (availableSeats < 0) {
                availableSeats = 0;
            }
            System.out.println(screen.getScreenType()+ " | Total Seats: "+ screen.getTotalSeats()+ " | Booked: "+ bookedSeats+ " | Available: "+ availableSeats);
        }
    }
}

class Customer {
    private int customerId;
    private String name;
    private String mobile;
    private String email;
    public Customer(int customerId, String name,String mobile, String email) {
        this.customerId = customerId;
        this.name = name;
        this.mobile = mobile;
        this.email = email;
    }
    public int getCustomerId() {
        return customerId;
    }
    public String getName() {
        return name;
    }
    public String getMobile() {
        return mobile;
    }
    public String getEmail() {
        return email;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public static Customer findCustomerById(
            ArrayList<Customer> customers, int id) {
        for (Customer customer : customers) {
            if (customer.getCustomerId() == id) {
                return customer;
            }
        }
        return null;
    }
    public static Customer findCustomerByName(
            ArrayList<Customer> customers, String name) {
        for (Customer customer : customers) {
            if (customer.getName().equalsIgnoreCase(name)) {
                return customer;
            }
        }
        return null;
    }
    public static int generateCustomerId(
            ArrayList<Customer> customers) {
        Random random = new Random();
        int id;
        do {
            id = 1000 + random.nextInt(9000);
        } while (findCustomerById(customers, id) != null);
        return id;
    }
    public static void registerCustomer(
            ArrayList<Customer> customers) {
        System.out.println("\n========== CUSTOMER REGISTRATION ==========");
        String name = CinemaBook.readLine("Enter Name: ");
        String mobile = CinemaBook.readLine("Enter Mobile Number: ");
        String email = CinemaBook.readLine("Enter Email: ");
        if (!ValidateService.validateMobile(mobile)) {
            System.out.println("Invalid mobile number.");
            return;
        }
        if (!ValidateService.validateEmail(email)) {
            System.out.println("Invalid email address.");
            return;
        }
        if (findCustomerByName(customers, name) != null) {
            System.out.println("A customer with this name already exists.");
            return;
        }
        int id = generateCustomerId(customers);
        Customer customer =new Customer(id, name, mobile, email);
        customers.add(customer);
        System.out.println("\nCustomer registered successfully.");
        System.out.println("Your Customer ID is: " + id);
        System.out.println("Please keep this ID for your records.");
    }
    public static void updateProfile(
            ArrayList<Customer> customers) {
        System.out.println("\n========== UPDATE PROFILE ==========");
        String name = CinemaBook.readLine("Enter Your Name: ");
        Customer customer = findCustomerByName(customers, name);
        if (customer == null) {
            System.out.println("Customer not found.");
            return;
        }
        String newName =
                CinemaBook.readLine("Enter New Name: ");
        String newMobile =
                CinemaBook.readLine("Enter New Mobile Number: ");
        String newEmail =
                CinemaBook.readLine("Enter New Email: ");
        if (!ValidateService.validateMobile(newMobile)) {
            System.out.println("Invalid mobile number.");
            return;
        }
        if (!ValidateService.validateEmail(newEmail)) {
            System.out.println("Invalid email address.");
            return;
        }
        customer.setName(newName);
        customer.setMobile(newMobile);
        customer.setEmail(newEmail);
        System.out.println("Profile updated successfully.");
    }
    public static void viewProfile(
            ArrayList<Customer> customers) {
        System.out.println("\n========== VIEW PROFILE ==========");
        String name = CinemaBook.readLine("Enter Your Name: ");
        Customer customer =findCustomerByName(customers, name);
        if (customer == null) {
            System.out.println("Customer not found.");
            return;
        }
        System.out.println("\nCustomer ID : "+ customer.getCustomerId());
        System.out.println("Name        : "+ customer.getName());
        System.out.println("Mobile      : "+ customer.getMobile());
        System.out.println("Email       : "+ customer.getEmail());
    }
}

class Booking {
    private int bookingId;
    private String customerName;
    private String movieName;
    private String screenName;
    private String seatNumber;
    private String bookingDate;
    private String status;
    public Booking(int bookingId,String customerName,String movieName,String screenName, String seatNumber,String bookingDate,String status) {
        this.bookingId = bookingId;
        this.customerName = customerName;
        this.movieName = movieName;
        this.screenName = screenName;
        this.seatNumber = seatNumber;
        this.bookingDate = bookingDate;
        this.status = status;
    }
    public int getBookingId() {
        return bookingId;
    }
    public String getCustomerName() {
        return customerName;
    }
    public String getMovieName() {
        return movieName;
    }
    public String getScreenName() {
        return screenName;
    }
    public String getSeatNumber() {
        return seatNumber;
    }
    public String getBookingDate() {
        return bookingDate;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public static Booking findBookingById(ArrayList<Booking> bookings, int id) {
        for (Booking booking : bookings) {
            if (booking.getBookingId() == id) {
                return booking;
            }
        }
        return null;
    }
    public static int generateBookingId(
            ArrayList<Booking> bookings) {
        Random random = new Random();
        int id;
        do {
            id = 1000 + random.nextInt(9000);
        } while (findBookingById(bookings, id) != null);
        return id;
    }
    public static boolean isSeatBooked(
            ArrayList<Booking> bookings,
            String screenName,
            String seatNumber) {
        for (Booking booking : bookings) {
            if (booking.getScreenName().equalsIgnoreCase(screenName)&& booking.getSeatNumber().equalsIgnoreCase(seatNumber)&& !booking.getStatus().equalsIgnoreCase("Cancelled")) {
                return true;
            }
        }
        return false;
    }
    public static void bookTicket(
            ArrayList<Movie> movies,
            ArrayList<Screen> screens,
            ArrayList<Customer> customers,
            ArrayList<Booking> bookings) {
        System.out.println("\n========== BOOK TICKET ==========");
        if (movies.isEmpty()) {
            System.out.println("No movies available.");
            return;
        }
        if (screens.isEmpty()) {
            System.out.println("No screens available.");
            return;
        }
        if (customers.isEmpty()) {
            System.out.println("Please register as a customer first.");
            return;
        }
        String customerName =CinemaBook.readLine("Enter Customer Name: ");
        Customer customer =Customer.findCustomerByName(customers, customerName);
        if (customer == null) {
            System.out.println("Customer not found.");
            return;
        }
        Movie.displayMovies(movies);
        String movieName =CinemaBook.readLine("\nEnter Movie Name: ");
        Movie movie =Movie.findMovieByName(movies, movieName);
        if (movie == null) {
            System.out.println("Movie not found.");
            return;
        }
        Screen.displayScreens(screens);
        String screenName =CinemaBook.readLine("\nEnter Screen Type: ");
        Screen screen =Screen.findScreenByName(screens, screenName);
        if (screen == null) {
            System.out.println("Screen not found.");
            return;
        }
        String seat =CinemaBook.readLine("Enter Seat Number: ");
        if (seat.trim().isEmpty()) {
            System.out.println("Seat number cannot be empty.");
            return;
        }
        if (isSeatBooked(bookings, screenName, seat)) {
            System.out.println("This seat is already booked.");
            return;
        }
        int bookingId =generateBookingId(bookings);
        String date =java.time.LocalDate.now().toString();
        Booking booking =new Booking(bookingId,customer.getName(),movie.getMovieName(),screen.getScreenType(),seat,date,"Confirmed");
        bookings.add(booking);
        System.out.println("\nBooking successful!");
        System.out.println("Booking ID : " + bookingId);
        System.out.println("Customer   : " + customer.getName());
        System.out.println("Movie      : " + movie.getMovieName());
        System.out.println("Screen     : " + screen.getScreenType());
        System.out.println("Seat       : " + seat);
        System.out.println("Date       : " + date);
        System.out.println("Status     : Confirmed");
        System.out.println("Ticket Price: ₹250");
    }
    public static void viewBooking(ArrayList<Booking> bookings) {
        System.out.println("\n========== VIEW BOOKING ==========");
        int id =CinemaBook.readInt("Enter Booking ID: ");
        Booking booking =findBookingById(bookings, id);
        if (booking == null) {
            System.out.println("Booking not found.");
            return;
        }
        displayBooking(booking);
    }
    public static void displayBooking(Booking booking) {
        System.out.println("\nBooking ID   : "+ booking.getBookingId());
        System.out.println("Customer     : "+ booking.getCustomerName());
        System.out.println("Movie        : "+ booking.getMovieName());
        System.out.println("Screen       : "+ booking.getScreenName());
        System.out.println("Seat         : "+ booking.getSeatNumber());
        System.out.println("Booking Date : "+ booking.getBookingDate());
        System.out.println("Status       : "+ booking.getStatus());
    }
    public static void cancelBooking(ArrayList<Booking> bookings) {
        System.out.println("\n========== CANCEL BOOKING ==========");
        int id =CinemaBook.readInt("Enter Booking ID: ");
        Booking booking =
                findBookingById(bookings, id);
        if (booking == null) {
            System.out.println("Booking not found.");
            return;
        }
        if (booking.getStatus()
                .equalsIgnoreCase("Cancelled")) {
            System.out.println("Booking is already cancelled.");
            return;
        }
        booking.setStatus("Cancelled");
        System.out.println("Booking cancelled successfully.");
    }
}

class Payment {
    private int paymentId;
    private int bookingId;
    private double amount;
    private String paymentMethod;
    private String paymentStatus;
    public Payment(int paymentId,int bookingId,double amount,String paymentMethod,String paymentStatus) {
        this.paymentId = paymentId;
        this.bookingId = bookingId;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.paymentStatus = paymentStatus;
    }
    public int getPaymentId() {
        return paymentId;
    }
    public int getBookingId() {
        return bookingId;
    }
    public double getAmount() {
        return amount;
    }
    public String getPaymentMethod() {
        return paymentMethod;
    }
    public String getPaymentStatus() {
        return paymentStatus;
    }
    public static Payment findPaymentById(
            ArrayList<Payment> payments, int id) {
        for (Payment payment : payments) {
            if (payment.getPaymentId() == id) {
                return payment;
            }
        }
        return null;
    }
    public static int generatePaymentId(
            ArrayList<Payment> payments) {
        Random random = new Random();
        int id;
        do {
            id = 1000 + random.nextInt(9000);
        } while (findPaymentById(payments, id) != null);
        return id;
    }
    public static void makePayment(
            ArrayList<Booking> bookings,
            ArrayList<Payment> payments) {
        System.out.println("\n========== MAKE PAYMENT ==========");
        int bookingId =
                CinemaBook.readInt("Enter Booking ID: ");
        Booking booking =
                Booking.findBookingById(
                        bookings, bookingId);
        if (booking == null) {
            System.out.println("Booking not found.");
            return;
        }
        if (booking.getStatus()
                .equalsIgnoreCase("Cancelled")) {
            System.out.println(
                    "Cannot make payment for a cancelled booking.");
            return;
        }
        for (Payment payment : payments) {
            if (payment.getBookingId() == bookingId) {
                System.out.println("Payment already exists for this booking.");
                System.out.println("Payment ID: "+ payment.getPaymentId());
                return;
            }
        }
        double amount = 250.00;
        System.out.println("\nPayment Amount: ₹" + amount);
        System.out.println("\nPayment Methods");
        System.out.println("1. Card");
        System.out.println("2. Net Banking");
        System.out.println("3. UPI");
        int choice =
                CinemaBook.readInt("Choose Payment Method: ");
        String method;
        switch (choice) {
            case 1:
                method = "Card";
                break;
            case 2:
                method = "Net Banking";
                break;
            case 3:
                method = "UPI";
                break;
            default:
                System.out.println(
                        "Invalid payment method.");
                return;
        }
        int paymentId =generatePaymentId(payments);
        Payment payment = new Payment( paymentId,bookingId, amount, method,"Paid");
        payments.add(payment);
        System.out.println("\nPayment successful!");
        System.out.println("Payment ID : " + paymentId);
        System.out.println("Booking ID : " + bookingId);
        System.out.println("Amount     : ₹" + amount);
        System.out.println("Method     : " + method);
        System.out.println("Status     : Paid");
    }
    public static void viewPayment(
            ArrayList<Payment> payments) {
        System.out.println("\n========== VIEW PAYMENT ==========");
        int id =CinemaBook.readInt("Enter Payment ID: ");
        Payment payment =findPaymentById(payments, id);
        if (payment == null) {
            System.out.println("Payment not found.");
            return;
        }
        System.out.println("\nPayment ID     : "+ payment.getPaymentId());

        System.out.println("Booking ID     : "+ payment.getBookingId());

        System.out.println("Amount         : ₹"+ payment.getAmount());

        System.out.println("Payment Method : "+ payment.getPaymentMethod());

        System.out.println("Payment Status : "+ payment.getPaymentStatus());
    }
}

class ValidateService {
    public static boolean validateMobile(String mobile) {
        return mobile != null && mobile.matches("[0-9]{10}");
    }
    public static boolean validateEmail(String email) {
        return email != null && email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
    }
    public static boolean validateAmount(double amount) {
        return amount > 0;
    }
}

class SearchService {
    public static void searchMovie(ArrayList<Movie> movies) {
        System.out.println("\n========== SEARCH MOVIE ==========");
        String keyword =CinemaBook.readLine("Enter Movie Name or Genre: ");
        boolean found = false;
        for (Movie movie : movies) {
            if (movie.getMovieName()
                    .toLowerCase()
                    .contains(keyword.toLowerCase())
                    || movie.getGenre()
                    .toLowerCase()
                    .contains(keyword.toLowerCase())) {
                System.out.println(movie.getMovieId()+ " | "+ movie.getMovieName()+ " | "+ movie.getGenre()+ " | "+ movie.getLanguage());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No matching movie found.");
        }
    }
    public static void searchCustomer(
            ArrayList<Customer> customers) {
        System.out.println("\n========== SEARCH CUSTOMER ==========");
        String keyword =CinemaBook.readLine("Enter Customer Name: ");
        boolean found = false;
        for (Customer customer : customers) {
            if (customer.getName()
                    .toLowerCase()
                    .contains(keyword.toLowerCase())) {
                System.out.println("Customer ID: "+ customer.getCustomerId());
                System.out.println("Name: "+ customer.getName());
                System.out.println("Mobile: "+ customer.getMobile());
                System.out.println("Email: "+ customer.getEmail());
                System.out.println("--------------------------------");
                found = true;
            }
        }
        if (!found) {
            System.out.println("No customer found.");
        }
    }
    public static void searchScreen(
            ArrayList<Screen> screens) {
        System.out.println("\n========== SEARCH SCREEN ==========");
        String keyword =CinemaBook.readLine("Enter Screen Type: ");
        boolean found = false;
        for (Screen screen : screens) {
            if (screen.getScreenType()
                    .toLowerCase()
                    .contains(keyword.toLowerCase())) {
                System.out.println(screen.getScreenId()+ " | "+ screen.getScreenType()+ " | Seats: "+ screen.getTotalSeats()+ " | "+ screen.getShowTime());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No screen found.");
        }
    }
    public static void searchBooking(
            ArrayList<Booking> bookings) {
        System.out.println("\n========== SEARCH BOOKING ==========");
        String keyword =CinemaBook.readLine("Enter Customer Name or Movie Name: ");
        boolean found = false;
        for (Booking booking : bookings) {
            if (booking.getCustomerName()
                    .toLowerCase()
                    .contains(keyword.toLowerCase())
                    || booking.getMovieName()
                    .toLowerCase()
                    .contains(keyword.toLowerCase())) {
                Booking.displayBooking(booking);
                System.out.println("--------------------------------");
                found = true;
            }
        }
        if (!found) {
            System.out.println("No booking found.");
        }
    }
}

class ReportGenerationService {
    public static void movieReport(
            ArrayList<Movie> movies) {
        System.out.println("\n========== MOVIE REPORT ==========");
        if (movies.isEmpty()) {
            System.out.println("No movie data available.");
            return;
        }
        movies.forEach(movie -> {
            System.out.println(movie.getMovieId()+ " | "+ movie.getMovieName()+ " | "+ movie.getGenre()+ " | "+ movie.getLanguage()+ " | "+ movie.getDuration()+ " minutes");
            });
    }
    public static void bookingReport(
            ArrayList<Booking> bookings) {
        System.out.println("\n========== BOOKING REPORT ==========");
        if (bookings.isEmpty()) {
            System.out.println("No bookings available.");
            return;
        }
        bookings.forEach(Booking::displayBooking);
    }
    public static void paymentReport(
            ArrayList<Payment> payments) {
        System.out.println("\n========== PAYMENT REPORT ==========");
        if (payments.isEmpty()) {
            System.out.println("No payment data available.");
            return;
        }
        payments.forEach(payment -> {
            System.out.println("Payment ID: "+ payment.getPaymentId()+ " | Booking ID: "+ payment.getBookingId()+ " | Amount: ₹"+ payment.getAmount()+ " | Method: "+ payment.getPaymentMethod()+ " | Status: "+ payment.getPaymentStatus());
        });
    }
    public static void occupancyReport(
            ArrayList<Screen> screens,
            ArrayList<Booking> bookings) {
        System.out.println("\n========== OCCUPANCY REPORT ==========");
        if (screens.isEmpty()) {
            System.out.println("No screen data available.");
            return;
        }
        for (Screen screen : screens) {
            long booked =
                    bookings.stream()
                            .filter(b ->b.getScreenName().equalsIgnoreCase(screen.getScreenType()))
                            .filter(b ->!b.getStatus().equalsIgnoreCase("Cancelled"))
                            .count();
            double occupancy = 0;
            if (screen.getTotalSeats() > 0) {
                occupancy =((double) booked/ screen.getTotalSeats())* 100;
            }
            System.out.printf(
                    "%s | Booked: %d | Total: %d | Occupancy: %.2f%%%n",
                    screen.getScreenType(),
                    booked,
                    screen.getTotalSeats(),
                    occupancy);
        }
    }
}

class AnalysisService {
    public static void totalRevenue(
            ArrayList<Payment> payments) {
        double revenue =payments.stream()
                        .filter(p ->p.getPaymentStatus().equalsIgnoreCase("Paid"))
                        .mapToDouble(Payment::getAmount)
                        .sum();
        System.out.println("\n========== TOTAL REVENUE ==========");
        System.out.println("Total Revenue: ₹" + revenue);
    }
    public static void mostBookedMovie(
            ArrayList<Booking> bookings) {
        System.out.println("\n========== MOST BOOKED MOVIE ==========");
        if (bookings.isEmpty()) {
            System.out.println("No booking data available.");
            return;
        }
        String result =bookings.stream()
                        .filter(b ->!b.getStatus()
                                        .equalsIgnoreCase("Cancelled"))
                        .collect(java.util.stream.Collectors.groupingBy(Booking::getMovieName,java.util.stream.Collectors.counting()))
                        .entrySet()
                        .stream()
                        .max(java.util.Map.Entry.comparingByValue())
                        .map(java.util.Map.Entry::getKey)
                        .orElse("No bookings");
        System.out.println("Most Booked Movie: " + result);
    }
    public static void occupancyAnalysis(
            ArrayList<Screen> screens,
            ArrayList<Booking> bookings) {
        System.out.println("\n========== OCCUPANCY ANALYSIS ==========");
        if (screens.isEmpty()) {
            System.out.println("No screen data available.");
            return;
        }
        for (Screen screen : screens) {
            long booked =bookings.stream()
                            .filter(b ->b.getScreenName().equalsIgnoreCase(screen.getScreenType()))
                            .filter(b ->!b.getStatus().equalsIgnoreCase("Cancelled"))
                            .count();
            double percentage = 0;
            if (screen.getTotalSeats() > 0) {
                percentage =((double) booked/ screen.getTotalSeats())* 100;
            }
            System.out.printf("%s -> %.2f%%%n",screen.getScreenType(),percentage);
        }
    }
    public static void overallSummary(
            ArrayList<Movie> movies,
            ArrayList<Screen> screens,
            ArrayList<Customer> customers,
            ArrayList<Booking> bookings,
            ArrayList<Payment> payments) {
        System.out.println("\n========== CINEMA SUMMARY ==========");
        long activeBookings =bookings.stream()
                        .filter(b ->!b.getStatus().equalsIgnoreCase("Cancelled"))
                        .count();
        double revenue =payments.stream()
                        .filter(p ->p.getPaymentStatus().equalsIgnoreCase("Paid"))
                        .mapToDouble(Payment::getAmount)
                        .sum();
        System.out.println("Total Movies       : " + movies.size());
        System.out.println("Total Screens      : " + screens.size());
        System.out.println("Total Customers    : " + customers.size());
        System.out.println("Total Bookings     : " + bookings.size());
        System.out.println("Active Bookings    : " + activeBookings);
        System.out.println("Total Payments     : " + payments.size());
        System.out.println("Total Revenue      : ₹" + revenue);
    }
}

public class CinemaBook {
    static Scanner sc = new Scanner(System.in);
    static final String ADMIN_PASSWORD = "admin123";
    static ArrayList<Movie> movieList =
            new ArrayList<>();
    static ArrayList<Screen> screenList =
            new ArrayList<>();
    static ArrayList<Customer> customerList =
            new ArrayList<>();
    static ArrayList<Booking> bookingList =
            new ArrayList<>();
    static ArrayList<Payment> paymentList =
            new ArrayList<>();
    public static String readLine(String message) {
        System.out.print(message);
        return sc.nextLine().trim();
    }
    public static int readInt(String message) {
        while (true) {
            try {
                System.out.print(message);
                return Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }
    public static void loadInitialData() {
        movieList.add(new Movie(101,"Avengers: Endgame","Action","English",181));
        movieList.add(new Movie(102,"Kalki 2898 AD","Sci-Fi","Telugu",180));
        movieList.add(new Movie(103,"Pushpa 2","Action","Telugu",200));
        movieList.add(new Movie(104,"3 Idiots","Comedy","Hindi",170));
        movieList.add(new Movie(105,"Interstellar","Sci-Fi","English",169));
        screenList.add(new Screen(101,"Extra Large",50,"Morning 8:00 AM"));
        screenList.add(new Screen(102,"Large",100,"Morning 11:00 AM"));
        screenList.add(new Screen(103,"Medium",150,"Afternoon 3:00 PM"));
        screenList.add(new Screen(104,"Small",300,"Evening 6:00 PM"));
        screenList.add(new Screen(105,"Very Small",500,"Midnight 12:00 AM"));
    }
    public static void main(String[] args) {
        loadInitialData();
        System.out.println("==============================================");
        System.out.println("       CINEMA SEAT BOOKING SYSTEM             ");
        System.out.println("==============================================");
        boolean running = true;
        while (running) {
            System.out.println("\n============== MAIN MENU ==============");
            System.out.println("1. Customer Portal");
            System.out.println("2. Administrator Portal");
            System.out.println("3. Exit");
            int choice =readInt("Enter your choice: ");
            switch (choice) {
                case 1:
                    customerPortal();
                    break;
                case 2:
                    administratorLogin();
                    break;
                case 3:
                    running = false;
                    System.out.println("\nThank you for using the Cinema Seat Booking System.");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
        sc.close();
    }
    public static void customerPortal() {
        boolean back = false;
        while (!back) {
            System.out.println("\n========== CUSTOMER PORTAL ==========");
            System.out.println("1. Customer Profile");
            System.out.println("2. Movies");
            System.out.println("3. Booking");
            System.out.println("4. Payment");
            System.out.println("5. Back");
            int choice =readInt("Enter your choice: ");
            switch (choice) {
                case 1:
                    customerProfileMenu();
                    break;
                case 2:
                    customerMovieMenu();
                    break;
                case 3:
                    customerBookingMenu();
                    break;
                case 4:
                    customerPaymentMenu();
                    break;
                case 5:
                    back = true;
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
    public static void customerProfileMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("\n========== CUSTOMER PROFILE ==========");
            System.out.println("1. Register Customer");
            System.out.println("2. Update Profile");
            System.out.println("3. View Profile");
            System.out.println("4. Back");
            int choice =readInt("Enter your choice: ");
            switch (choice) {
                case 1:
                    Customer.registerCustomer(customerList);
                    break;
                case 2:
                    Customer.updateProfile(customerList);
                    break;
                case 3:
                    Customer.viewProfile(customerList);
                    break;
                case 4:
                    back = true;
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
    public static void customerMovieMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("\n========== MOVIES ==========");
            System.out.println("1. View Movies");
            System.out.println("2. Search Movie");
            System.out.println("3. Back");
            int choice =readInt("Enter your choice: ");
            switch (choice) {
                case 1:
                    Movie.displayMovies(movieList);
                    break;
                case 2:
                    SearchService.searchMovie(movieList);
                    break;
                case 3:
                    back = true;
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
    public static void customerBookingMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("\n========== BOOKING ==========");
            System.out.println("1. Book Ticket");
            System.out.println("2. View Booking");
            System.out.println("3. Cancel Booking");
            System.out.println("4. Back");
            int choice =readInt("Enter your choice: ");
            switch (choice) {
                case 1:
                    Booking.bookTicket(movieList,screenList,customerList,bookingList);
                    break;
                case 2:
                    Booking.viewBooking(bookingList);
                    break;
                case 3:
                    Booking.cancelBooking(bookingList);
                    break;
                case 4:
                    back = true;
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
    public static void customerPaymentMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("\n========== PAYMENT ==========");
            System.out.println("1. Make Payment");
            System.out.println("2. View Payment");
            System.out.println("3. Back");
            int choice =readInt("Enter your choice: ");
            switch (choice) {
                case 1:
                    Payment.makePayment(bookingList,paymentList);
                    break;
                case 2:
                    Payment.viewPayment(paymentList);
                    break;
                case 3:
                    back = true;
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
    public static void administratorLogin() {
        System.out.println("\n========== ADMINISTRATOR LOGIN ==========");
        String password =readLine("Enter Administrator Password: ");
        if (ADMIN_PASSWORD.equals(password)) {
            System.out.println("Login successful.");
            administratorPortal();
        } else {
            System.out.println("Incorrect password. Access denied.");
        }
    }
    public static void administratorPortal() {
        boolean logout = false;
        while (!logout) {
            System.out.println("\n========== ADMINISTRATOR PORTAL ==========");
            System.out.println("1. Movie Management");
            System.out.println("2. Screen Management");
            System.out.println("3. Customer & Booking");
            System.out.println("4. Reports & Analysis");
            System.out.println("5. Logout");
            int choice =readInt("Enter your choice: ");
            switch (choice) {
                case 1:
                    movieManagementMenu();
                    break;
                case 2:
                    screenManagementMenu();
                    break;
                case 3:
                    customerBookingAdminMenu();
                    break;
                case 4:
                    reportsAnalysisMenu();
                    break;
                case 5:
                    logout = true;
                    System.out.println("Administrator logged out.");
                    break;
                default: System.out.println("Invalid choice.");
            }
        }
    }
    public static void movieManagementMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("\n========== MOVIE MANAGEMENT ==========");
            System.out.println("1. Add Movie");
            System.out.println("2. Update Movie");
            System.out.println("3. View Movies");
            System.out.println("4. Search Movie");
            System.out.println("5. Back");
            int choice =readInt("Enter your choice: ");
            switch (choice) {
                case 1:
                    Movie.addMovie(movieList);
                    break;
                case 2:
                    Movie.updateMovie(movieList);
                    break;
                case 3:
                    Movie.displayMovies(movieList);
                    break;
                case 4:
                    SearchService.searchMovie(movieList);
                    break;
                case 5:
                    back = true;
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
    public static void screenManagementMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("\n========== SCREEN MANAGEMENT ==========");
            System.out.println("1. Add Screen");
            System.out.println("2. Update Screen");
            System.out.println("3. View Screens");
            System.out.println("4. Check Availability");
            System.out.println("5. Back");
            int choice =readInt("Enter your choice: ");
            switch (choice) {
                case 1:
                    Screen.addScreen(screenList);
                    break;
                case 2:
                    Screen.updateScreen(screenList);
                    break;
                case 3:
                    Screen.displayScreens(screenList);
                    break;
                case 4:
                    Screen.checkAvailability(screenList,bookingList);
                    break;
                case 5:
                    back = true;
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
    public static void customerBookingAdminMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("\n========== CUSTOMER & BOOKING ==========");
            System.out.println("1. Search Customer");
            System.out.println("2. Search Booking");
            System.out.println("3. View All Bookings");
            System.out.println("4. Back");
            int choice =readInt("Enter your choice: ");
            switch (choice) {
                case 1:
                    SearchService.searchCustomer(customerList);
                    break;
                case 2:
                    SearchService.searchBooking(bookingList);
                    break;
                case 3:
                    ReportGenerationService.bookingReport(bookingList);
                    break;
                case 4:
                    back = true;
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
    public static void reportsAnalysisMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("\n========== REPORTS & ANALYSIS ==========");
            System.out.println("1. Movie Report");
            System.out.println("2. Booking Report");
            System.out.println("3. Payment Report");
            System.out.println("4. Occupancy Report");
            System.out.println("5. Cinema Analysis");
            System.out.println("6. Back");
            int choice =readInt("Enter your choice: ");
            switch (choice) {
                case 1:
                    ReportGenerationService.movieReport(movieList);
                    break;
                case 2:
                    ReportGenerationService.bookingReport(bookingList);
                    break;
                case 3:
                    ReportGenerationService.paymentReport(paymentList);
                    break;
                case 4:
                    ReportGenerationService.occupancyReport(screenList,bookingList);
                    break;
                case 5:
                    cinemaAnalysisMenu();
                    break;
                case 6:
                    back = true;
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
    public static void cinemaAnalysisMenu() {
        boolean back = false;
        while (!back) {
            System.out.println("\n========== CINEMA ANALYSIS ==========");
            System.out.println("1. Total Revenue");
            System.out.println("2. Most Booked Movie");
            System.out.println("3. Occupancy Analysis");
            System.out.println("4. Overall Summary");
            System.out.println("5. Back");
            int choice =readInt("Enter your choice: ");
            switch (choice) {
                case 1:
                    AnalysisService.totalRevenue(paymentList);
                    break;
                case 2:
                    AnalysisService.mostBookedMovie(bookingList);
                    break;
                case 3:
                    AnalysisService.occupancyAnalysis(screenList,bookingList);
                    break;
                case 4:
                    AnalysisService.overallSummary(movieList,screenList,customerList,bookingList,paymentList);
                    break;
                case 5: 
                	back = true;
                    break;
                default: System.out.println("Invalid choice.");
            }
        }
    }
}