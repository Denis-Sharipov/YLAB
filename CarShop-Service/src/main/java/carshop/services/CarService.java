package carshop.services;

import carshop.model.Car;
import carshop.model.CarCondition;

import java.util.ArrayList;
import java.util.List;

public class CarService {
    private final List<Car> cars;


    public CarService() {
        this.cars = new ArrayList<>();
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public List<Car> getAllCars() {
        return cars;
    }

    public List<Car> getAvailableForSaleCars() {
        return getCarsBySold(false);
    }

    public void sellCar(Car car) {
        car.sell();
    }

    public void removeCar(Car car) {
        cars.remove(car);
    }

    public List<Car> getCarsByBrand(String brand){
        List<Car> carsByBrand = new ArrayList<>();
        for (Car car : cars){
            if (car.getBrand().equals(brand)){
                carsByBrand.add(car);
            }
        }
        return carsByBrand;
    }

    public List<Car> getCarsByModel(String model){
        List<Car> carsByModel = new ArrayList<>();
        for (Car car : cars){
            if (car.getModel().equals(model)){
                carsByModel.add(car);
            }
        }
        return carsByModel;
    }

    public List<Car> getCarsByYear(int year){
        List<Car> carsByYear = new ArrayList<>();
        for (Car car : cars){
            if (car.getYear() == year){
                carsByYear.add(car);
            }
        }
        return carsByYear;
    }

    public List<Car> getCarsByPrice(int price){
        List<Car> carsByPrice = new ArrayList<>();
        for (Car car : cars){
            if (car.getPrice() == price){
                carsByPrice.add(car);
            }
        }
        return carsByPrice;
    }

    public List<Car> getCarsByCondition(CarCondition condition){
        List<Car> carsByCondition = new ArrayList<>();
        for (Car car : cars){
            if (car.getCondition().equals(condition)){
                carsByCondition.add(car);
            }
        }
        return carsByCondition;
    }

    public List<Car> getCarsBySold(boolean isSold){
        List<Car> carsBySold = new ArrayList<>();
        for (Car car : cars){
            if (car.isSold() == isSold){
                carsBySold.add(car);
            }
        }
        return carsBySold;
    }

    public void updateCarBrand(Car car, String brand){
        car.setBrand(brand);
    }

    public void updateCarModel(Car car, String model){
        car.setModel(model);
    }

    public void updateCarYear(Car car, int year){
        car.setYear(year);
    }

    public void updateCarPrice(Car car, int price){
        car.setPrice(price);
    }

    public void updateCarCondition(Car car, CarCondition condition) {
        car.setCondition(condition);
    }

    public void updateCarSold(Car car, boolean sold){
        car.setSold(sold);
    }

}
