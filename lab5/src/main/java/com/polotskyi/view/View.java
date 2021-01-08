package com.polotskyi.view;

import com.polotskyi.controller.*;
import com.polotskyi.model.entity.*;

import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class View {
    private final Map<String, Printable> menu;
    private static final Scanner input = new Scanner(System.in, StandardCharsets.UTF_8);

    private final StationController stationController = new StationController();
    private final CarController carController = new CarController();
    private final UserController userController = new UserController();
    private final FineController fineController = new FineController();
    private final RentController rentController = new RentController();

    public final void show() {
        String keyMenu = "";
        while (!keyMenu.equals("Q")) {
            displayMenu();
            System.out.println("Please, select menu point.");
            keyMenu = input.nextLine().toUpperCase();
            try {
                menu.get(keyMenu).print();
            } catch (Exception ignored) {

            }
        }
    }

    private void displayMenu() {
        System.out.println(" ---------------------------------------- ");
        System.out.println("|                     |                    |");
        System.out.println("|       TABLES        |       METHODS      |");
        System.out.println("|                     |                    |");
        System.out.println(" ---------------------------------------- ");
        System.out.println("|  1 - Station        |  1 - get all       |");
        System.out.println("|  2 - Car            |  2 - get by id     |");
        System.out.println("|  3 - Rent           |  3 - create        |");
        System.out.println("|  4 - User           |  4 - update        |");
        System.out.println("|  5 - Fine           |  5 - delete        |");
        System.out.println(" ------------------------------------------ ");
        System.out.println("|                  Q - exit                |");
        System.out.println(" ------------------------------------------ ");
    }

    public View() {
        menu = new LinkedHashMap<>();

        menu.put("11", this::findAllStations);
        menu.put("12", this::findStationById);
        menu.put("13", this::createStation);
        menu.put("14", this::updateStation);
        menu.put("15", this::deleteStation);

        menu.put("21", this::findAllCars);
        menu.put("22", this::findCarById);
        menu.put("23", this::createCar);
        menu.put("24", this::updateCar);
        menu.put("25", this::deleteCar);

        menu.put("31", this::findAllRents);
        menu.put("32", this::findRentById);
        menu.put("33", this::createRent);
        menu.put("34", this::updateRent);
        menu.put("35", this::deleteRent);

        menu.put("41", this::findAllUsers);
        menu.put("42", this::findUserById);
        menu.put("43", this::createUser);
        menu.put("44", this::updateUser);
        menu.put("45", this::deleteUser);

        menu.put("51", this::findAllFines);
        menu.put("52", this::findFineById);
        menu.put("53", this::createFine);
        menu.put("54", this::updateFine);
        menu.put("55", this::deleteFine);
    }

    /* --------- Station --------- */

    private void findAllStations() {
        System.out.println("\nStations");
        System.out.println(stationController.findAll());
    }

    private void findStationById() {
        System.out.println("Enter station id: ");
        Integer id = input.nextInt();
        input.nextLine();
        System.out.println(stationController.find(id));
    }

    private Station getStationData() {
        System.out.println("Enter station name: ");
        String name = input.next();
        System.out.println("Enter station address: ");
        String address = input.next();
        System.out.println("Enter station city: ");
        String city = input.next();
        return new Station(name, address, city);
    }

    private void createStation() throws SQLException {
        System.out.println("<- Station creating ->\n");
        Station station = getStationData();
        stationController.create(station);
        System.out.println("Created successfully");
    }

    private void updateStation() throws SQLException {
        System.out.println("<- Station updating ->\n");
        System.out.println("Input id to update: ");
        Integer id = input.nextInt();
        Station station = getStationData();
        station.setId(id);
        stationController.update(station.getId(), station);
        System.out.println("Station has been updated!");
    }

    private void deleteStation() {
        System.out.println("<- Station deleting ->\n");
        System.out.println("Enter id to delete");
        Integer id = input.nextInt();
        stationController.delete(id);
        System.out.println("Station has been deleted!");
    }

    /* --------- Car --------- */

    private void findAllCars() {
        System.out.println("\nCars");
        System.out.println(carController.findAll());
    }

    private void findCarById() {
        System.out.println("Enter car id: ");
        Integer id = input.nextInt();
        input.nextLine();
        System.out.println(carController.find(id));
    }

    private Car getCarData() {
        System.out.println("Enter car brand: ");
        String brand = input.next();
        System.out.println("Enter car model: ");
        String model = input.next();
        System.out.println("Enter car year: ");
        Integer year = input.nextInt();
        System.out.println("Enter car plate number: ");
        String plateNumber = input.next();
        System.out.println("Enter car vin number: ");
        String vinNumber = input.next();
        System.out.println("Enter car status: ");
        String status = input.next();
        System.out.println("Enter car station's id: ");
        Integer stationId = input.nextInt();

        Station station = stationController.find(stationId);

        return new Car(brand, model, year, plateNumber, vinNumber, status, station);
    }

    private void createCar() throws SQLException {
        System.out.println("<- Car creating ->\n");
        Car car = getCarData();
        carController.create(car);
        System.out.println("Created successfully");
    }

    private void updateCar() throws SQLException {
        System.out.println("<- Car updating ->\n");
        System.out.println("Input id to update: ");
        Integer id = input.nextInt();
        Car car = getCarData();
        car.setId(id);
        carController.update(car.getId(), car);
        System.out.println("Car has been updated!");
    }

    private void deleteCar() {
        System.out.println("<- Car deleting ->\n");
        System.out.println("Enter id to delete");
        Integer id = input.nextInt();
        carController.delete(id);
        System.out.println("Car has been deleted!");
    }

    /* --------- User --------- */

    private void findAllUsers() {
        System.out.println("\nUsers");
        System.out.println(userController.findAll());
    }

    private void findUserById() {
        System.out.println("Enter user id: ");
        Integer id = input.nextInt();
        input.nextLine();
        System.out.println(userController.find(id));
    }

    private User getUserData() {
        System.out.println("Enter first name: ");
        String firstName = input.next();
        System.out.println("Enter last name: ");
        String lastName = input.next();
        System.out.println("Enter phone number: ");
        String phoneNumber = input.next();
        System.out.println("Enter email: ");
        String email = input.next();
        System.out.println("Enter passport number: ");
        String passportNumber = input.next();
        System.out.println("Enter driver license number: ");
        String driverLicenseNumber = input.next();
        System.out.println("Enter status: ");
        String status = input.next();
        System.out.println("Enter password: ");
        String passwordSha256 = input.next();

        return new User(firstName, lastName, phoneNumber, email, passportNumber, driverLicenseNumber, status, passwordSha256);
    }

    private void createUser() throws SQLException {
        System.out.println("<- User creating ->\n");
        User user = getUserData();
        userController.create(user);
        System.out.println("Created successfully");
    }

    private void updateUser() throws SQLException {
        System.out.println("<- User updating ->\n");
        System.out.println("Input id to update: ");
        Integer id = input.nextInt();
        User user = getUserData();
        user.setId(id);
        userController.update(user.getId(), user);
        System.out.println("Station has been updated!");
    }

    private void deleteUser() {
        System.out.println("<- User deleting ->\n");
        System.out.println("Enter id to delete");
        Integer id = input.nextInt();
        userController.delete(id);
        System.out.println("User has been deleted!");
    }

    /* --------- Fine --------- */

    private void findAllFines() {
        System.out.println("\nFines");
        System.out.println(fineController.findAll());
    }

    private void findFineById() {
        System.out.println("Enter fine id: ");
        Integer id = input.nextInt();
        input.nextLine();
        System.out.println(fineController.find(id));
    }

    private Fine getFineData() {
        System.out.println("Enter payment due: ");
        BigDecimal paymentDue = input.nextBigDecimal();
        System.out.println("Enter status: ");
        String status = input.next();
        System.out.println("Enter user_id: ");
        Integer userId = input.nextInt();

        User user = userController.find(userId);


        return new Fine(paymentDue, status, user);
    }

    private void createFine() throws SQLException {
        System.out.println("<- Fine creating ->\n");
        Fine fine = getFineData();
        fineController.create(fine);
        System.out.println("Created successfully");
    }

    private void updateFine() throws SQLException {
        System.out.println("<- Fine updating ->\n");
        System.out.println("Input id to update: ");
        Integer id = input.nextInt();
        Fine fine = getFineData();
        fine.setId(id);
        fineController.update(fine.getId(), fine);
        System.out.println("Fine has been updated!");
    }

    private void deleteFine() {
        System.out.println("<- Fine deleting ->\n");
        System.out.println("Enter id to delete");
        Integer id = input.nextInt();
        fineController.delete(id);
        System.out.println("Fine has been deleted!");
    }

    /* --------- Rent --------- */

    private void findAllRents() {
        System.out.println("\nRents");
        System.out.println(rentController.findAll());
    }

    private void findRentById() {
        System.out.println("Enter rent id: ");
        Integer id = input.nextInt();
        input.nextLine();
        System.out.println(rentController.find(id));
    }

    private Rent getRentData() {
        System.out.println("Enter price: ");
        BigDecimal price = input.nextBigDecimal();
        System.out.println("Enter status: ");
        String status = input.next();
        System.out.println("Enter car_id: ");
        Integer carId = input.nextInt();
        System.out.println("Enter user_id: ");
        Integer userId = input.nextInt();

        Car car = carController.find(carId);
        User user = userController.find(userId);

        return new Rent(price, status, car, user);
    }

    private void createRent() throws SQLException {
        System.out.println("<- Rent creating ->\n");
        Rent rent = getRentData();
        rentController.create(rent);
        System.out.println("Created successfully");
    }

    private void updateRent() throws SQLException {
        System.out.println("<- Rent updating ->\n");
        System.out.println("Input id to update: ");
        Integer id = input.nextInt();
        Rent rent = getRentData();
        rent.setId(id);
        rentController.update(rent.getId(), rent);
        System.out.println("Rent has been updated!");
    }

    private void deleteRent() {
        System.out.println("<- Rent deleting ->\n");
        System.out.println("Enter id to delete");
        Integer id = input.nextInt();
        rentController.delete(id);
        System.out.println("Rent has been deleted!");
    }

}