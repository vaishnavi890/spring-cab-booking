package com.vaishnavi.cab.booking;

import com.vaishnavi.cab.booking.controller.*;
import com.vaishnavi.cab.booking.model.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");

        // Fetch all controllers from Spring
        UserController userController = context.getBean("userController", UserController.class);
        DriverController driverController = context.getBean("driverController", DriverController.class);
        RideController rideController = context.getBean("rideController", RideController.class);
        PaymentController paymentController = context.getBean("paymentController", PaymentController.class);
        RatingController ratingController = context.getBean("ratingController", RatingController.class);

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=== Cab Order Management System ===");
            System.out.println("1. Register User");
            System.out.println("2. List Users");
            System.out.println("3. Add Driver");
            System.out.println("4. List Drivers");
            System.out.println("5. Book Ride");
            System.out.println("6. List Rides");
            System.out.println("7. Make Payment");
            System.out.println("8. List Payments");
            System.out.println("9. Rate Driver");
            System.out.println("10. List Ratings");
            System.out.println("11. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1: // Register User
                    System.out.print("Enter User ID: ");
                    int userId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Name: ");
                    String userName = scanner.nextLine();
                    System.out.print("Enter Email: ");
                    String userEmail = scanner.nextLine();
                    System.out.print("Enter Phone: ");
                    String userPhone = scanner.nextLine();
                    User user = new User(userId, userName, userEmail, userPhone);
                    userController.createUser(user);
                    break;

                case 2: // List Users
                    userController.listAllUsers();
                    break;

                case 3: // Add Driver
                    System.out.print("Enter Driver ID: ");
                    int driverId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Name: ");
                    String driverName = scanner.nextLine();
                    System.out.print("Enter Email: ");
                    String driverEmail = scanner.nextLine();
                    System.out.print("Enter Phone: ");
                    String driverPhone = scanner.nextLine();
                    System.out.print("Enter Cab Details: ");
                    String cabDetails = scanner.nextLine();
                    Driver driver = new Driver(driverId, driverName, driverEmail, driverPhone, cabDetails);
                    driverController.addDriver(driver);
                    break;

                case 4: // List Drivers
                    driverController.listAllDrivers();
                    break;

                case 5: // Book Ride
                    System.out.print("Enter User ID: ");
                    int rideUserId = scanner.nextInt();
                    System.out.print("Enter Driver ID: ");
                    int rideDriverId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Pickup Location: ");
                    String pickup = scanner.nextLine();
                    System.out.print("Enter Dropoff Location: ");
                    String dropoff = scanner.nextLine();
                    rideController.createRide(rideUserId, rideDriverId, pickup, dropoff);
                    break;

                case 6: // List Rides
                    rideController.listAllRides();
                    break;

                case 7: // Make Payment
                    System.out.print("Enter Payment ID: ");
                    int paymentId = scanner.nextInt();
                    System.out.print("Enter Ride ID: ");
                    int rideId = scanner.nextInt();
                    System.out.print("Enter User ID: ");
                    int paymentUserId = scanner.nextInt();
                    System.out.print("Enter Amount: ");
                    double amount = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Enter Payment Method: ");
                    String method = scanner.nextLine();
                    Payment payment = new Payment(paymentId, rideId, paymentUserId, amount, method, "Paid");
                    paymentController.makePayment(payment);
                    break;

                case 8: // List Payments
                    paymentController.listAllPayments();
                    break;

                case 9: // Rate Driver
                    System.out.print("Enter Rating ID: ");
                    int ratingId = scanner.nextInt();
                    System.out.print("Enter Ride ID: ");
                    int rRideId = scanner.nextInt();
                    System.out.print("Enter User ID: ");
                    int rUserId = scanner.nextInt();
                    System.out.print("Enter Driver ID: ");
                    int rDriverId = scanner.nextInt();
                    System.out.print("Enter Rating (1-5): ");
                    int ratingVal = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter Review: ");
                    String review = scanner.nextLine();
                    Rating rating = new Rating(ratingId, rRideId, rUserId, rDriverId, ratingVal, review);
                    ratingController.addRating(rating);
                    break;

                case 10: // List Ratings
                    ratingController.listAllRatings();
                    break;

                case 11:
                    System.out.println("Exiting system...");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 11);

        scanner.close();
    }
}
