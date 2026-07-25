
abstract class Vehicle {

    public abstract void start();
    public abstract void stop();
}

interface FuelEfficiency {

    void calculateMileage();
}

class Car extends Vehicle implements FuelEfficiency {
    private String model;

    public Car(String model) {
        this.model = model;
    }

    @Override
    public void start() {
        System.out.println(model + " Car engine started with keyless push button.");
    }

    @Override
    public void stop() {
        System.out.println(model + " Car engine stopped. Disc brakes applied safely.");
    }

    @Override
    public void calculateMileage() {
        System.out.println(model + " Car Mileage: 15.5 km per liter.");
    }
}

class Bike extends Vehicle implements FuelEfficiency {
    private String type;

    public Bike(String type) {
        this.type = type;
    }

    @Override
    public void start() {
        System.out.println(type + " Bike started using self-start switch.");
    }

    @Override
    public void stop() {
        System.out.println(type + " Bike stopped using hand and foot brakes.");
    }

    @Override
    public void calculateMileage() {
        System.out.println(type + " Bike Mileage: 45.2 km per liter.");
    }
}

class VehicleTask {
    public static void main(String[] args) {
        
        System.out.println("====== Testing Car Object ======");

        Car myCar = new Car("Sedan");
        myCar.start();
        myCar.calculateMileage();
        myCar.stop();
        System.out.println("================================\n");

        System.out.println("====== Testing Bike Object ======");

        Bike myBike = new Bike("Sports");
        myBike.start();
        myBike.calculateMileage();
        myBike.stop();
        System.out.println("=================================");
    }
}