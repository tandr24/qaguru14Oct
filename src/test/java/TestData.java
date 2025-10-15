import com.github.javafaker.Faker;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

public class TestData {

    static Faker faker = new Faker(new Locale("en"));
    static Date date = faker.date().birthday(0, 99);
    public static String firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = faker.internet().emailAddress(),
            phone = faker.number().digits(10),
            gender = faker.options().option("Female", "Male", "Other"),
            hobbies = faker.options().option("Sports", "Reading", "Music"),
            address = faker.address().fullAddress(),
            subject = faker.options().option("Math", "Chemistry", "Hindi", "English"),
            img = faker.options().option("img.png"),
            state = faker.options().option("NCR", "Uttar Pradesh", "Rajasthan", "Haryana"),
            city = getCityFromState(state);


    static LocalDate localDate = Instant.ofEpochMilli(date.getTime())
            .atZone(ZoneId.systemDefault())
            .toLocalDate();

    static String day = localDate.format(DateTimeFormatter.ofPattern("dd")),
            month = localDate.format(DateTimeFormatter.ofPattern("MMMM")),
            year = localDate.format(DateTimeFormatter.ofPattern("yyyy"));

    static String getCityFromState(String state) {
        String value = switch (state) {
            case "NCR" -> faker.options().option("Delhi", "Gurgaon", "Noida");
            case "Uttar Pradesh" -> faker.options().option("Agra", "Lucknow", "Merrut");
            case "Rajasthan" -> faker.options().option("Karnal", "Panipat");
            case "Haryana" -> faker.options().option("Jaipur", "Jaiselmer");
            default -> "null";
        };
        return value;
    }

}
