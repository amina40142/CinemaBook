# The CinemaBook
## Overview
```
The CinemaBook – Cinema Seat Booking System is a Java-based application developed to automate movie
ticket booking operations in cinema theatres. The system manages movie details, theatre screens, customer
information, seat availability, ticket booking, payments, validations, searching, report generation,
and cinema analytics. The application enables customers to view available movies, select seats,
reserve tickets, make payments, and generate booking details. Theatre administrators can manage
movies, screens, and analyze booking trends. The system is designed using Object-Oriented Programming
concepts such as classes, objects, inheritance, encapsulation, polymorphism, Java Collections,
Exception Handling, Lambda Expressions, and Stream API.

 ```
```mermaid
flowchart TD
    Start([Start]) --> Init[/"Initialize system data<br>(movies, screens, customers,<br>bookings, payments)"/]
    Init --> DisplayMenu[/"Display Main Menu<br>1. Customer Portal<br>2. Administrator Portal<br>3. Exit"/]
    
    DisplayMenu --> Choice{User choice?}
    
    %% Customer Portal Branch
    Choice -->|1. Customer Portal| PerformCust["Perform selected<br>customer operation<br>(Profile / Movies / Booking /<br>Payment)"]
    PerformCust --> BookingSel{"Booking<br>selected?"}
    BookingSel -->|No| ReturnMain1[/"Return to Main Menu"/] --> DisplayMenu
    
    BookingSel -->|Yes| SubBooking[Booking Process]
    SubBooking --> SelectMovie[/"Select movie / screen / seat"/]
    SelectMovie --> SeatAvail{"Seat<br>available?"}
    
    SeatAvail -->|Yes| ConfirmBook["Confirm booking<br>(generate booking ID)"]
    SeatAvail -->|No| DisplayUnavail["Display<br>&quot;Seat unavailable&quot;"]
    
    ConfirmBook --> PayDetails[/"Payment details<br>(Booking ID, amount,<br>payment method)"/]
    DisplayUnavail --> PayDetails
    
    PayDetails --> RecordPay["Record payment<br>(generate payment ID)"]
    RecordPay --> ReturnCust[/"Return to Main Menu"/] --> DisplayMenu
    
    %% Administrator Portal Branch
    Choice -->|2. Administrator Portal| ValAdmin[Validate admin password]
    ValAdmin --> PassValid{"Password<br>valid?"}
    
    PassValid -->|No| ReturnAdmin1[/"Return to Main Menu"/] --> DisplayMenu
    PassValid -->|Yes| AdminOps["Admin Operations<br>1. Movie Management<br>2. Screen Management<br>3. Customer & Booking<br>4. Reports & Analysis"]
    
    AdminOps --> ReturnAdmin2[/"Return to Main Menu"/] --> DisplayMenu
    
    %% Exit Branch
    Choice -->|3. Exit| DisplayThank[/"Display<br>&quot;Thank you&quot;"/] --> Stop([Stop])
```
