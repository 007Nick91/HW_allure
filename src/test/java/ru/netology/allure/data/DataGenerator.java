package ru.netology.allure.data;

import com.github.javafaker.Faker;
import lombok.Value;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;

public class DataGenerator {
    private DataGenerator() {
    }

    public static String generateDate(int addDay) {
        return LocalDate.now().plusDays(addDay).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    }


    public static String generateCity(String locale) {
        var cities = new String[]{"Челябинск", "Краснодар","Тюмень","Москва", "Казань"};
        return cities[new Random().nextInt(cities.length)];
    }


    public static String generateName(String locale) {
        var faker = new Faker(new Locale("ru"));
        return faker.name().lastName() +" " + faker.name().firstName();
    }


    public static String generatePhone(String locale) {
        Faker faker = new Faker(new Locale("ru"));
        return faker.phoneNumber().phoneNumber();
    }


    public static class Registration {
        private Registration() {
        }

        public static UserInfo generateUser(String locale) {
            return new UserInfo(generateCity(locale), generateName(locale), generatePhone(locale));


        }

    }

    @Value
    public static class UserInfo {
        String city;
        String name;
        String phone;
    }


}