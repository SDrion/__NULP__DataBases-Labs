package view;

import controller.implementation.*;
import model.implementation.*;
import org.apache.commons.codec.digest.DigestUtils;

import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class MainView {
    private final StationController stationController = new StationController();
    private final CarController carController = new CarController();
    private final RentController rentController = new RentController();
    private final UserController userController = new UserController();
    private final FineController fineController = new FineController();

    private final Map<String, String> menu;
    private final Map<String, Printable> methodsMenu;
    private static final Scanner INPUT = new Scanner(System.in);

    public MainView() {
        menu = new LinkedHashMap<>();
        methodsMenu = new LinkedHashMap<>();

        menu.put("11", "11 - Get all stations");
        menu.put("12", "12 - Get station by ID");
        menu.put("13", "13 - Create new station");
        menu.put("14", "14 - Delete station by ID");
        menu.put("15", "15 - Update station by ID\n");

        menu.put("21", "21 - Get all cars");
        menu.put("22", "22 - Get car by ID");
        menu.put("23", "23 - Create car");
        menu.put("24", "24 - Delete car by ID");
        menu.put("25", "25 - Update car by ID\n");

        menu.put("31", "31 - Get all rents");
        menu.put("32", "32 - Get rent by ID");
        menu.put("33", "33 - Create rent");
        menu.put("34", "34 - Delete rent by ID");
        menu.put("35", "35 - Update rent by ID\n");

        menu.put("41", "41 - Get all users");
        menu.put("42", "42 - Get user by ID");
        menu.put("43", "43 - Create user");
        menu.put("44", "44 - Delete user by ID");
        menu.put("45", "45 - Update user by ID\n");

        menu.put("51", "51 - Get all fines");
        menu.put("52", "52 - Get fine by ID");
        menu.put("53", "53 - Create fine");
        menu.put("54", "54 - Delete fine by ID");
        menu.put("55", "55 - Update fine by ID");

        methodsMenu.put("11", this::getAllStations);
        methodsMenu.put("12", this::getStationById);
        methodsMenu.put("13", this::createStation);
        methodsMenu.put("14", this::deleteStationById);
        methodsMenu.put("15", this::updateStationById);

        methodsMenu.put("21", this::getAllCars);
        methodsMenu.put("22", this::getCarById);
        methodsMenu.put("23", this::createCar);
        methodsMenu.put("24", this::deleteCarById);
        methodsMenu.put("25", this::updateCarById);

        methodsMenu.put("31", this::getAllRents);
        methodsMenu.put("32", this::getRentById);
        methodsMenu.put("33", this::createRent);
        methodsMenu.put("34", this::deleteRentById);
        methodsMenu.put("35", this::updateRentById);

        methodsMenu.put("41", this::getAllUsers);
        methodsMenu.put("42", this::getUserById);
        methodsMenu.put("43", this::createUser);
        methodsMenu.put("44", this::deleteUserById);
        methodsMenu.put("45", this::updateUserById);

        methodsMenu.put("51", this::getAllFines);
        methodsMenu.put("52", this::getFineById);
        methodsMenu.put("53", this::createFine);
        methodsMenu.put("55", this::updateFineById);
    }



    private void getAllStations() throws SQLException {
        System.out.println("\nTable: station");
        stationController.getAll();
    }

    private void getAllCars() throws SQLException {
        System.out.println("\nTable: car");
        carController.getAll();
    }

    private void getAllRents() throws SQLException {
        System.out.println("\nTable: rent");
        rentController.getAll();
    }

    private void getAllUsers() throws SQLException {
        System.out.println("\nTable: user");
        userController.getAll();
    }

    private void getAllFines() throws SQLException {
        System.out.println("\nTable: fine");
        fineController.getAll();
    }



    private void getStationById() throws SQLException {
        System.out.println("Enter ID of Station: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        stationController.getById(id);
    }

    private void getCarById() throws SQLException {
        System.out.println("Enter ID of Car: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        carController.getById(id);
    }

    private void getRentById() throws SQLException {
        System.out.println("Enter ID of Rent: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        rentController.getById(id);
    }

    private void getUserById() throws SQLException {
        System.out.println("Enter ID of User: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        userController.getById(id);
    }

    private void getFineById() throws SQLException {
        System.out.println("Enter ID of Fine: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        fineController.getById(id);
    }



    private void createStation() throws SQLException {
        System.out.println("Enter station name: ");
        String name = INPUT.nextLine();
        System.out.println("Enter station address: ");
        String address = INPUT.nextLine();
        System.out.println("Enter station city: ");
        String city = INPUT.nextLine();

        Station station = new Station(0, name, address, city);
        stationController.create(station);
    }

    private void createCar() throws SQLException {
        System.out.println("Enter car brand: ");
        String brand = INPUT.nextLine();
        System.out.println("Enter car model: ");
        String model = INPUT.nextLine();
        System.out.println("Enter car year: ");
        Integer year = INPUT.nextInt();
        System.out.println("Enter car plate number: ");
        String plateNumber = INPUT.nextLine();
        System.out.println("Enter car VIN: ");
        String vin = INPUT.nextLine();
        System.out.println("Enter car status: ");
        String status = INPUT.nextLine();
        System.out.println("Enter car station id: ");
        Integer stationId = INPUT.nextInt();

        Car car = new Car(0, brand, model, year, plateNumber, vin, status, stationId);
        carController.create(car);
    }

    private void createRent() throws SQLException {
        System.out.println("Enter rent price: ");
        Float price = INPUT.nextFloat();
        System.out.println("Enter rent status: ");
        String status = "finished";
        System.out.println("Enter rent car id: ");
        Integer carId = INPUT.nextInt();
        System.out.println("Enter rent user id: ");
        Integer userId = INPUT.nextInt();

        Rent rent = new Rent(0, price, status, carId, userId);
        rentController.create(rent);
    }

    private void createUser() throws SQLException {
        System.out.println("Enter user first name: ");
        String fname = INPUT.nextLine();
        System.out.println("Enter user last name: ");
        String lname = INPUT.nextLine();
        System.out.println("Enter user phone number: ");
        String pnumber = INPUT.nextLine();
        System.out.println("Enter user email: ");
        String email = INPUT.nextLine();
        System.out.println("Enter user passport number: ");
        String passNumb = INPUT.nextLine();
        System.out.println("Enter user drivers license number: ");
        String dlicense = INPUT.nextLine();
        System.out.println("Enter user status: ");
        String status = INPUT.nextLine();
        System.out.println("Enter user password: ");
        String password = DigestUtils.sha256Hex(INPUT.nextLine());

        User user = new User(0, fname, lname, pnumber, email, passNumb, dlicense,
                status, password);
        userController.create(user);
    }

    private void createFine() throws SQLException {
        System.out.println("Enter fine payment due: ");
        Float payDue = INPUT.nextFloat();
        System.out.println("Enter fine status: ");
        String status = "active";
        System.out.println("Enter fine user id: ");
        Integer userId = INPUT.nextInt();

        Fine fine = new Fine(0, payDue, status, userId);
        fineController.create(fine);
    }



    private void deleteStationById() throws SQLException {
        System.out.println("Enter station ID to delete: ");
        int id = INPUT.nextInt();
        stationController.delete(id);
    }

    private void deleteCarById() throws SQLException {
        System.out.println("Enter car ID to delete: ");
        int id = INPUT.nextInt();
        carController.delete(id);
    }

    private void deleteRentById() throws SQLException {
        System.out.println("Enter rent ID to delete: ");
        int id = INPUT.nextInt();
        rentController.delete(id);
    }

    private void deleteUserById() throws SQLException {
        System.out.println("Enter user ID to delete: ");
        int id = INPUT.nextInt();
        userController.delete(id);
    }

    private void deleteFineById() throws SQLException {
        System.out.println("Enter fine ID to delete: ");
        int id = INPUT.nextInt();
        fineController.delete(id);
    }



    private void updateStationById() throws SQLException {
        System.out.println("Enter station id: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        Station stationToUpdate = stationController.getService().getById(id);

        System.out.println("Enter station name: ");
        String name = INPUT.nextLine();
        System.out.println("Enter station address: ");
        String address = INPUT.nextLine();
        System.out.println("Enter station city: ");
        String city = INPUT.nextLine();

        String newName = name.equals("") ? stationToUpdate.getName() : name;
        String newAddress = address.equals("") ? stationToUpdate.getAddress() : address;
        String newCity = city.equals("") ? stationToUpdate.getCity() : city;

        Station entity = new Station(id, newName, newAddress, newCity);
        stationController.update(entity);
    }

    private void updateCarById() throws SQLException {
        System.out.println("Enter car id: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        Car carToUpdate = carController.getService().getById(id);

        System.out.println("Enter car brand: ");
        String brand = INPUT.nextLine();
        System.out.println("Enter car model: ");
        String model = INPUT.nextLine();
        System.out.println("Enter car year: ");
        Integer year = INPUT.nextInt();
        INPUT.nextLine();
        System.out.println("Enter car plate number: ");
        String plateNumber = INPUT.nextLine();
        System.out.println("Enter car vin number: ");
        String vinNumber = INPUT.nextLine();
        System.out.println("Enter car status: ");
        String status = INPUT.nextLine();
        System.out.println("Enter station id: ");
        Integer stationId = INPUT.nextInt();
        INPUT.nextLine();

        String newBrand = brand.equals("") ? carToUpdate.getBrand() : brand;
        String newModel = model.equals("") ? carToUpdate.getModel() : model;
        Integer newYear = year < 0 ? carToUpdate.getYear() : year;
        String newPlateNumber = plateNumber.equals("") ? carToUpdate.getPlate_number() : plateNumber;
        String newVinNumber = vinNumber.equals("") ? carToUpdate.getVin_number() : vinNumber;
        String newStatus = status.equals("") ? carToUpdate.getStatus() : status;
        Integer newStationId = stationId < 0 ? carToUpdate.getStation_id() : stationId;

        Car entity = new Car(id, newBrand, newModel, newYear, newPlateNumber, newVinNumber, newStatus, newStationId);
        carController.update(entity);
    }

    private void updateRentById() throws SQLException {
        System.out.println("Enter rent id: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        Rent rentToUpdate = rentController.getService().getById(id);

        System.out.println("Enter rent price: ");
        Float price = INPUT.nextFloat();
        INPUT.nextLine();
        System.out.println("Enter rent status: ");
        String status = INPUT.nextLine();
        System.out.println("Enter car id: ");
        Integer carId = INPUT.nextInt();
        System.out.println("Enter user id: ");
        Integer userId = INPUT.nextInt();

        Float newPrice = price < 0 ? rentToUpdate.getPrice() : price;
        String newStatus = status.equals("") ? rentToUpdate.getStatus() : status;
        Integer newCarId = carId < 0 ? rentToUpdate.getCar_id() : carId;
        Integer newUserId = userId < 0 ? rentToUpdate.getUser_id() : userId;

        Rent entity = new Rent(id, newPrice, newStatus, newCarId, newUserId);
        rentController.update(entity);
    }

    private void updateUserById() throws SQLException {
        System.out.println("Enter user id: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        User userToUpdate = userController.getService().getById(id);

        System.out.println("Enter user first name: ");
        String firstName = INPUT.nextLine();
        System.out.println("Enter user last name: ");
        String lastName = INPUT.nextLine();
        System.out.println("Enter user phone number: ");
        String phoneNumber = INPUT.nextLine();
        System.out.println("Enter user email: ");
        String email = INPUT.nextLine();
        System.out.println("Enter user passport number: ");
        String passportNumber = INPUT.nextLine();
        System.out.println("Enter user drivers license number: ");
        String dlNumber = INPUT.nextLine();
        System.out.println("Enter user status: ");
        String status = INPUT.nextLine();
        System.out.println("Enter user password: ");
        String password = INPUT.nextLine();

        String newFirstName = firstName.equals("") ? userToUpdate.getFirst_name() : firstName;
        String newLastName = lastName.equals("") ? userToUpdate.getLast_name() : lastName;
        String newPhoneNumber = phoneNumber.equals("") ? userToUpdate.getPhone_number() : phoneNumber;
        String newEmail = email.equals("") ? userToUpdate.getEmail() : email;
        String newPasNum = passportNumber.equals("") ? userToUpdate.getPassport_number() : passportNumber;
        String newDlNumber = dlNumber.equals("") ? userToUpdate.getDrivers_license_number() : dlNumber;
        String newStatus = status.equals("") ? userToUpdate.getStatus() : status;
        String newPassword = password.equals("") ? userToUpdate.getPassword() : DigestUtils.sha256Hex(password);;

        User entity = new User(id, newFirstName, newLastName, newPhoneNumber, newEmail, newPasNum,
                newDlNumber, newStatus, newPassword);
        userController.update(entity);
    }

    private void updateFineById() throws SQLException {
        System.out.println("Enter fine id: ");
        int id = INPUT.nextInt();
        INPUT.nextLine();
        Fine fineToUpdate = fineController.getService().getById(id);

        System.out.println("Enter fine payment due: ");
        Float paymentDue = INPUT.nextFloat();
        INPUT.nextLine();
        System.out.println("Enter fine status: ");
        String status = INPUT.nextLine();
        System.out.println("Enter user id: ");
        Integer userId = INPUT.nextInt();

        Float newPayment = paymentDue < 0 ? fineToUpdate.getPaymant_due() : paymentDue;
        String newStatus = status.equals("") ? fineToUpdate.getStatus() : status;
        Integer newUserId = userId < 0 ? fineToUpdate.getUser_id() : userId;

        Fine entity = new Fine(id, newPayment, newStatus, newUserId);
        fineController.update(entity);
    }

    private void outputMenu() {
        System.out.println("\nMENU:");
        for (String str : menu.values()) {
            System.out.println(str);
        }
    }

    public final void show() {
        String keyMenu;
        do {
            outputMenu();
            System.out.println("Please, select menu point.");
            keyMenu = INPUT.nextLine().toUpperCase();
            try {
                methodsMenu.get(keyMenu).print();
            } catch (Exception ignored) { }
        } while (!keyMenu.equals("Q"));
    }
}
