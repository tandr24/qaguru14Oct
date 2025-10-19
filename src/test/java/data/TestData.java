package data;

import com.github.javafaker.Faker;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class TestData {
    static Faker faker = new Faker(new Locale("en"));
    static Date date = faker.date().birthday(0, 99);
    public String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = faker.internet().emailAddress(),
            phone = faker.number().digits(10),
            gender = faker.options().option("Female", "Male", "Other"),
            address = faker.address().fullAddress(),
            img = faker.options().option("img.png"),
            state = faker.options().option("NCR", "Uttar Pradesh", "Rajasthan", "Haryana"),
            city = getCityFromState(state);

    public List<String> valueOfHobbies = new ArrayList<>(Arrays.asList("Sports", "Reading", "Music"));
    public List<String> valueOfSubject = new ArrayList<>(Arrays.asList("English", "Maths", "Chemistry", "Hindi", "Economics", "Biology"));
    public int numOfHobbies = faker.random().nextInt(1, (valueOfHobbies.size() - 1));
    public int numOfSubject = faker.random().nextInt(1, (valueOfSubject.size() - 1));

    LocalDate localDate = Instant.ofEpochMilli(date.getTime())
            .atZone(ZoneId.systemDefault())
            .toLocalDate();

    public String day = localDate.format(DateTimeFormatter.ofPattern("dd"));
    public String month = localDate.format(DateTimeFormatter.ofPattern("MMMM"));
    public String year = localDate.format(DateTimeFormatter.ofPattern("yyyy"));

    String getCityFromState(String state) {
        return switch (state) {
            case "NCR" -> faker.options().option("Delhi", "Gurgaon", "Noida");
            case "Uttar Pradesh" -> faker.options().option("Agra", "Lucknow", "Merrut");
            case "Rajasthan" -> faker.options().option("Jaipur", "Jaiselmer");
            case "Haryana" -> faker.options().option("Karnal", "Panipat");
            default -> "null";
        };
    }


}
