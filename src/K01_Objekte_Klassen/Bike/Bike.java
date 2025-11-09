package K01_Objekte_Klassen.Bike;

class Bike {
    int frameNr;
    String manufacturer;
    float price;    // in €
    int wheelSize;  // in inches
    Date whenProduced;
}

class Date {
    int day;
    int month;
    int year;
}

class Main {
    public static void main(String[] args) {
        
        // Generate a new object of class Bike.
        Bike myBike = new Bike();
        
        // Initialize myBike's attributes.
        myBike.frameNr = 12345678;
        myBike.manufacturer = "SuperBikes Inc.";
        myBike.price = 1599.00f;
        myBike.wheelSize = 29;

        Date date = new Date();
        date.day = 1;
        date.month = 4;
        date.year = 2025;
        myBike.whenProduced = date;
        
        // More bikes...
        Bike secondBike = new Bike();
        Date secondDate = new Date();
        // ... here, the attributes for secondBike could be set.
    }
}