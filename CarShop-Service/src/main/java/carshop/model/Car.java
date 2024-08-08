package carshop.model;

public class Car {
    private String brand;
    private String model;
    private int year;
    private double price;
    private CarCondition condition;
    private boolean sold;

    public Car(String brand, String model, int year, double price, CarCondition condition) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.price = price;
        this.condition = condition;
        this.sold = false;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public CarCondition getCondition() {
        return condition;
    }

    public void setCondition(CarCondition condition) {
        this.condition = condition;
    }

    public void setSold(boolean sold) {
        this.sold = sold;
    }

    public String toString() {
        return "Марка: " + brand + ", модель: " + model + ", год выпуска: " + year + "г., цена: " + price +
                "р., состояние: " + condition + " , начилие: " + (sold ? "продано." : "есть в наличии.");
    }

    public boolean isSold() {
        return sold;
    }

    public void sell() {
        this.sold = true;
    }
}
