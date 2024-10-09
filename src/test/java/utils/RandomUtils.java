package utils;

import com.github.javafaker.Faker;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {
    Random random = new Random();
    private final Faker faker;
    public RandomUtils() {
        this.faker = new Faker();
    }
    public String getFirstName(){
        return faker.name().firstName();
    }
    public String getLastName(){
        return faker.name().lastName();
    }
    public String getUserEmail(){
        return faker.internet().emailAddress();
    }
    public  String getRandomGender() {
        String[] genders = {"Male", "Female", "Other"};
        return getRandomItemFromArray(genders);
    }
    public  int getRandomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }
    public  String getRandomItemFromArray(String[] array) {
        int index = getRandomInt(0, array.length - 1);
        return array[index];
    }
    public String getUserNumber(){
       return faker.phoneNumber().subscriberNumber(10);
    }
    public String getSubjects() {
        String[] subjects = {
                "Arts", "History", "English", "Chemistry",
                "Computer Science", "Commerce", "Economics", "Maths",
                "Social Studies", "Accounting", "Physics", "Biology",
                "Hindi", "Civics"
        };
        return getRandomItemFromArray(subjects);
    }
    public String getHobbies() {
        String[] hobbies = {
                "Sports", "Reading", "Music"
        };
        return getRandomItemFromArray(hobbies);
    }
    public String getRandomFile() {
        String[] files = {"test.png", "test1.jpg", "test2.jpg"};
        return faker.options().option(files);
    }
    public String getCurrentAddress(){
        return faker.address().fullAddress();
    }

    public String getMonths() {
        String[] months = {
                "January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"
        };
        return faker.options().option(months);
    }
    public int getDay(){
        String[] months = {
                "January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"
        };
        String randomMonth = faker.options().option(months);
        int daysInMonth;
        switch (randomMonth) {
            case "February":
                daysInMonth = random.nextBoolean() ? 28 : 29;
                break;
            case "April":
            case "June":
            case "September":
            case "November":
                daysInMonth = 30;
                break;
            default:
                daysInMonth = 31;
        }
        int day = random.nextInt(daysInMonth) + 1;
        return day;
    }
    public String getYear(){
        return String.valueOf(faker.number().numberBetween(1990, 2023));
    }

    public String getState() {
        String[] states  = {
                "NCR", "Uttar Pradesh", "Haryana", "Rajasthan"
        };
        return getRandomItemFromArray(states);
    }
    public String getCity(String state) {
        String[] cities;
        switch (state) {
            case "NCR":
                cities = new String[]{"Delhi", "Gurgaon", "Noida"};
                break;
            case "Uttar Pradesh":
                cities = new String[]{"Agra", "Lucknow", "Merrut"};
                break;
            case "Haryana":
                cities = new String[]{"Karnal", "Panipat"};
                break;
            case "Rajasthan":
                cities = new String[]{"Jaipur", "Jaiselmer"};
                break;
            default:
                cities = new String[]{};
        }
        return faker.options().option(cities);
    }
}
