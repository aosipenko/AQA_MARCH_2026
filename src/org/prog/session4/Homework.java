package org.prog.session4;

class Phone {
    public String brand;
    public String color;

    public void ring() {
        System.out.println("Phone " + brand + " color " + color + " is ringing!");
    }
}

class PhoneShop {
    public Phone buyPhone(String brand, String color) {
        if (brand.equalsIgnoreCase("iphone") && color.equalsIgnoreCase("black")) {
            System.out.println("Error: black iphones are not available");
            return null;
        }
        Phone phone = new Phone();
        phone.brand = brand;
        phone.color = color;
        return phone;
    }
}

public class Homework {
    public static void main(String[] args) {
        PhoneShop shop = new PhoneShop();


        shop.buyPhone("iphone", "black");


        Phone myPhone = shop.buyPhone("iphone", "white");
        if (myPhone != null) {
            myPhone.ring();
        }
    }
}
