import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class carRentalSystem {

    
    private static class Car {
        private String id;
        private String model;
        private String make;
        private boolean isAvailable;

        public Car(String id, String model, String make) {
            this.id = id;
            this.model = model;
            this.make = make;
            this.isAvailable = true;
        }

        public String getId() {
            return id;
        }

        public String getModel() {
            return model;
        }

        public String getMake() {
            return make;
        }

        public boolean isAvailable() {
            return isAvailable;
        }

        public void setAvailable(boolean available) {
            isAvailable = available;
        }

        @Override
        public String toString() {
            return "Car ID: " + id + ", Model: " + model + ", Make: " + make + ", Available: " + isAvailable;
        }
    }

   
    private static class Customer {
        private String id;
        private String name;
        private String phoneNumber;

        public Customer(String id, String name, String phoneNumber) {
            this.id = id;
            this.name = name;
            this.phoneNumber = phoneNumber;
        }

        public String getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        @Override
        public String toString() {
            return "Customer ID: " + id + ", Name: " + name + ", Phone Number: " + phoneNumber;
        }
    }

    
    private static class Rental {
        private Car car;
        private Customer customer;
        private String rentalDate;
        private String returnDate;

        public Rental(Car car, Customer customer, String rentalDate) {
            this.car = car;
            this.customer = customer;
            this.rentalDate = rentalDate;
            this.returnDate = null;
        }

        public void setReturnDate(String returnDate) {
            this.returnDate = returnDate;
            car.setAvailable(true);  // Mark car as available when returned
        }

        @Override
        public String toString() {
            return "Rental - Car: " + car.getModel() + ", Customer: " + customer.getName() +
                   ", Rental Date: " + rentalDate + ", Return Date: " + (returnDate == null ? "Not returned" : returnDate);
        }
    }

    
    private List<Car> cars;
    private List<Customer> customers;
    private List<Rental> rentals;

    public carRentalSystem() {
        cars = new ArrayList<>();
        customers = new ArrayList<>();
        rentals = new ArrayList<>();
    }

    
    private void addSampleData() {
        cars.add(new Car("1", "Punch", "Tata"));
        cars.add(new Car("2", "Civic", "Honda"));
        cars.add(new Car("3", "Swift", "Maruti Suzuki"));
        cars.add(new Car("4", "Scorpio", "Mahindra"));
        cars.add(new Car("5", "Innova Crysta", "Toyota"));
        customers.add(new Customer("C1", "mohan", "1234567890"));
        customers.add(new Customer("C2", "rohan", "0987654321"));
    }

    
    private void addCar(String id, String model, String make) {
        cars.add(new Car(id, model, make));
    }

    private void addCustomer(String id, String name, String phoneNumber) {
        customers.add(new Customer(id, name, phoneNumber));
    }

    private Car findAvailableCar(String model) {
        for (Car car : cars) {
            if (car.getModel().equalsIgnoreCase(model) && car.isAvailable()) {
                return car;
            }
        }
        return null;
    }

    private Customer findCustomerByName(String name) {
        for (Customer customer : customers) {
            if (customer.getName().equalsIgnoreCase(name)) {
                return customer;
            }
        }
        return null;
    }

    private void rentCar(String customerName, String carModel, String rentalDate) {
        
        Customer customer = findCustomerByName(customerName);
        if (customer == null) {
           
            String newCustomerId = "C" + (customers.size() + 1);
            Scanner scanner = new Scanner(System.in);
            System.out.print("New customer detected. Enter phone number for " + customerName + ": ");
            String phoneNumber = scanner.nextLine();
            customer = new Customer(newCustomerId, customerName, phoneNumber);
            customers.add(customer);
            System.out.println("New customer " + customerName + " added successfully!");
        }

       
        Car car = findAvailableCar(carModel);
        if (car != null) {
            car.setAvailable(false);
            rentals.add(new Rental(car, customer, rentalDate));
            System.out.println("Car rented successfully!");
        } else {
            System.out.println("Car model " + carModel + " is not available or does not exist.");
        }
    }

    private void viewCars() {
        System.out.println("Cars in the system:");
        for (Car car : cars) {
            System.out.println(car);
        }
    }

    private void viewCustomers() {
        System.out.println("Customers in the system:");
        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }

    private void viewRentals() {
        System.out.println("Rentals in the system:");
        for (Rental rental : rentals) {
            System.out.println(rental);
        }
    }

    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        carRentalSystem system = new carRentalSystem();
        system.addSampleData();  // Add some initial data

        while (true) {
            System.out.println("\n--- Car Rental System Menu ---");
            System.out.println("1. View Cars");
            System.out.println("2. View Customers");
            System.out.println("3. View Rentals");
            System.out.println("4. Rent a Car");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    system.viewCars();
                    break;
                case 2:
                    system.viewCustomers();
                    break;
                case 3:
                    system.viewRentals();
                    break;
                case 4:
                    System.out.print("Enter your name: ");
                    String customerName = scanner.nextLine();
                    System.out.print("Enter car model to rent: ");
                    String carModel = scanner.nextLine();
                    System.out.print("Enter rental date (YYYY-MM-DD): ");
                    String rentalDate = scanner.nextLine();
                    system.rentCar(customerName, carModel, rentalDate);
                    break;
                case 5:
                    System.out.println("Exiting the system. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}