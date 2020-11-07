package com.example.custompeoplelist;

import java.util.Comparator;

public class Human {

    private int id;
    private String name;
    private int age;
    private String phoneNumber;
    private  String email;
    private String image;

    public Human(int id, String name, int age,
                 String phoneNumber, String email,
                 String image) {

        this.id = id;
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public static Comparator<Human> humanNameAZCompare = new Comparator<Human>() {
        @Override
        public int compare(Human h1, Human h2) {

            // Compare human contacts by name alphabetical order
            return h1.getName().compareTo(h2.getName());
        }
    };
    public static Comparator<Human> humanNameZACompare = new Comparator<Human>() {
        @Override
        public int compare(Human h1, Human h2) {

            // Compare human contacts by name reverse alphabetical order
            return h2.getName().compareTo(h1.getName());
        }
    };
    public static Comparator<Human> humanAgeAscendingCompare = new Comparator<Human>() {
        @Override
        public int compare(Human h1, Human h2) {

            // Compare two human contacts by age ascending order
            return h1.getAge() - h2.getAge();
        }
    };
    public static Comparator<Human> humanAgeDescendingCompare = new Comparator<Human>() {
        @Override
        public int compare(Human h1, Human h2) {

            // Compare two human contacts by age descending order
            return h2.getAge() - h1.getAge();
        }
    };

    @Override
    public String toString() {
        return "People{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
