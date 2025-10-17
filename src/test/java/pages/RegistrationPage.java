package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import data.TestData;
import pages.component.CalendarComponent;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class RegistrationPage {
    private final SelenideElement firstNameInput = $("#firstName");
    private final SelenideElement lastNameInput = $("#lastName");
    private final SelenideElement userEmailInput = $("#userEmail");
    private final SelenideElement genderInput = $("#genterWrapper");
    private final SelenideElement numberInput = $("#userNumber");
    private final SelenideElement dateOfBirthInput = $("#dateOfBirthInput");
    private final SelenideElement subjectsInput = $("#subjectsInput");
    private final SelenideElement hobbiesWrapperInput = $("#hobbiesWrapper");
    private final SelenideElement uploadPictureInput = $("#uploadPicture");
    private final SelenideElement statefieldInput = $("#state");
    private final SelenideElement stateInput = $("#react-select-3-input");
    private final SelenideElement cityfieldInput = $("#city");
    private final SelenideElement cityInput = $("#react-select-4-input");
    private final SelenideElement addressInput = $("#currentAddress");
    private final SelenideElement submitInput = $("#submit");
    public static List <String> randomSubject = new ArrayList<>();
    public static List <String> randomHobbies= new ArrayList<>();

    private final Random random = new Random();

    CalendarComponent calendarComponent = new CalendarComponent();

    public RegistrationPage openSite(String value) {
        Selenide.open(value);
        System.out.println("open broweser");
        return this;

    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);
        System.out.println("set name" + value);
        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);
        System.out.println("set surname" + value);
        return this;
    }

    public RegistrationPage setUserEmail(String value) {
        userEmailInput.setValue(value);
        System.out.println("set email" + value);
        return this;
    }

    public RegistrationPage setGender(String value) {
        genderInput.$(byText(value)).click();
        System.out.println("set gender" + value);
        return this;
    }

    public RegistrationPage setNumber(String value) {
        numberInput.setValue(value);
        System.out.println("set number" + value);
        return this;
    }

    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        dateOfBirthInput.scrollIntoCenter().click();
        calendarComponent.setDate(day, month, year);
        System.out.println("set date" + day + " " + month + year);
        return this;
    }

    public RegistrationPage setSubject(String value) {
        subjectsInput.setValue(value).pressEnter();
        return this;
    }


    public RegistrationPage setHobbies(String value) {
        hobbiesWrapperInput.$(byText(value)).click();
        return this;
    }

    public RegistrationPage setRandomHobbies(boolean decision) {
        if (decision) {
            int max = TestData.valueOfHobbies.size();
            int q = 1 + random.nextInt(max - 1);
            Collections.shuffle(TestData.valueOfHobbies);
            for (int i = 0; i < q; i++) {
                    randomHobbies.add(TestData.valueOfHobbies.get(i));
            }
            for (int i = 0; i < q; i++) {
                hobbiesWrapperInput.scrollIntoCenter().$(byText(randomHobbies.get(i))).click();
                System.out.println("hobby" + randomHobbies.get(i));
            }
        }
        return this;
    }

    public RegistrationPage setRandomSubject(int num) {

        Collections.shuffle(TestData.valueOfSubject);
        for (int i = 0; i < num; i++) {
            randomSubject.add(TestData.valueOfSubject.get(i));
        }

        for (int i = 0; i < num; i++) {
            subjectsInput.setValue(randomSubject.get(i));
            System.out.println("num" + randomSubject.get(i));
            subjectsInput.pressEnter();
            System.out.println("enter from num");
        }
        return this;
    }


    public RegistrationPage setPicture(String value) {
        uploadPictureInput.scrollIntoCenter().uploadFromClasspath(value);
        return this;
    }

    public RegistrationPage setAddress(String value) {
        addressInput.setValue(value);
        System.out.println("set address" + value);
        return this;
    }

    public RegistrationPage setState(String value) {
        statefieldInput.scrollIntoCenter();
        stateInput.setValue(value);
        long start = System.nanoTime();
        System.out.println("set state " + value + " execution time in nanos: " + (System.nanoTime() - start));
        stateInput.pressEnter();
        System.out.println("enter from state");
        return this;
    }

    public RegistrationPage setCity(String value) {
        cityInput.setValue(value);
        System.out.println("set city" + value);
        cityInput.pressEnter();
        System.out.println("enter from city");
        return this;
    }

    public RegistrationPage submitForm() {
        submitInput.scrollIntoCenter().click();
        return this;
    }

}