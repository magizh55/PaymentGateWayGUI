# Payment Gateway Simulation using Strategy Pattern

A Java-based GUI application that simulates multiple payment methods using the **Strategy Design Pattern**.
This project is developed for **CCS356 – Object Oriented Software Engineering** and aligned with **SDG 8: Decent Work and Economic Growth**.

---

## Project Overview

This project demonstrates the implementation of the **Strategy Design Pattern** in a real-world payment gateway simulation.

The application is developed using **Java Swing GUI**, allowing users to:

* Select a payment method
* Enter the payment amount
* Process the payment
* View payment status instantly

### Supported Payment Methods

* Credit Card
* UPI
* Wallet

Each payment method is implemented as a separate strategy class, making the project scalable and easy to maintain.

---

## Design Pattern Used

### Strategy Pattern

The **Strategy Pattern** is a behavioral design pattern that allows selecting different algorithms or methods at runtime.

### Classes Used

* `PaymentStrategy` → Interface
* `CreditCardPayment` → Strategy
* `UPIPayment` → Strategy
* `WalletPayment` → Strategy
* `PaymentGateway` → Context Class
* `PaymentGatewayGUI` → Main GUI Class

---

## Technologies Used

* Java
* Java Swing
* Object Oriented Programming
* Strategy Design Pattern

---

## Features

* Professional GUI design
* Multiple payment methods
* Input validation
* Payment success popup
* Easy-to-use interface
* Clean OOP structure

---

## UI Look Output

```text
--------------------------------------------------
         Payment Gateway Simulation
--------------------------------------------------

Select Payment Method:   [ UPI ▼ ]

Enter Amount:            [ 5000 ]

            [ Process Payment ]

--------------------------------------------------
 Payment Status
 Payment of Rs. 5000 successful via UPI
--------------------------------------------------
```

---

## Sample Output

```text
Payment of Rs. 5000 successful via UPI
```

---

## How to Run

1. Open the project in **Eclipse / IntelliJ / NetBeans**
2. Compile `PaymentGatewayGUI.java`
3. Run the program
4. Select payment method
5. Enter amount
6. Click **Process Payment**

---

## SDG Goal

### SDG 8 – Decent Work and Economic Growth

This project supports modern digital payment solutions that contribute to:

* Cashless economy
* Financial technology innovation
* Secure business transactions
* Economic growth

---

## Author

Magizh P
