import java.util.*;

public class RentalAgency {
    private List<Car> cars = new ArrayList<>();
    private List<Customer> customers = new ArrayList<>();

    public void addCar(Car car) {
        cars.add(car);
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public void rentCar(String licensePlate, String customerId) {
        Car car = findCar(licensePlate);
        Customer customer = findCustomer(customerId);

        if (car != null && customer != null && car.isAvailable()) {
            car.rentOut();
            System.out.println(customer.getName() + " has rented " + car.getModel());
        } else {
            System.out.println("Rental failed. Car may be unavailable or customer not found.");
        }
    }

    public void returnCar(String licensePlate) {
        Car car = findCar(licensePlate);
        if (car != null && !car.isAvailable()) {
            car.returnCar();
            System.out.println("Car " + car.getModel() + " returned successfully.");
        } else {
            System.out.println("Return failed. Car not found or already available.");
        }
    }

    private Car findCar(String licensePlate) {
        for (Car car : cars) {
            if (car.getLicensePlate().equalsIgnoreCase(licensePlate)) {
                return car;
            }
        }
        return null;
    }

    private Customer findCustomer(String id) {
        for (Customer customer : customers) {
            if (customer.getId().equalsIgnoreCase(id)) {
                return customer;
            }
        }
        return null;
    }

    public void showAvailableCars() {
        for (Car car : cars) {
            if (car.isAvailable()) {
                System.out.println(car);
            }
        }
    }
}