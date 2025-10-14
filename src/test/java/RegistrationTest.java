import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.component.CheckComponent;

import static com.codeborne.selenide.Selenide.*;

public class RegistrationTest extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    CheckComponent checkComponent = new CheckComponent();

    @Test
    void formTest() {
        registrationPage.openSite("/automation-practice-form")
                .setFirstName("Name")
                .setLastName("Surname")
                .setUserEmail("email@mail.com")
                .setGender("Female")
                .setNumber("0123456789")
                .setDateOfBirth("19", "May", "1998")
                .setSubject("Math")
                .setSubject("Ch")
                .setHobbies("Music")
                .setHobbies("Reading")
                .setPicture("img.png")
                .setAddress("Address")
                .setSate("NCR")
                .setCity("Delhi")
                .submitForm();

        checkComponent.haveResultPhrase()
                .checkResult("Name Surname")
                .checkResult("email@mail.com")
                .checkResult("Female")
                .checkResult("0123456789")
                .checkResult("19 May,1998")
                .checkResult("Maths, Chemistry")
                .checkResult("Music, Reading")
                .checkResult("img.png")
                .checkResult("Address")
                .checkResult("NCR Delhi");

    }

    @Test
    void minimalFormTest() {
        registrationPage.openSite("/automation-practice-form")
                .setFirstName("Name")
                .setLastName("Surname")
                .setUserEmail("email@mail.com")
                .setGender("Female")
                .setNumber("0123456789")
                .setDateOfBirth("19", "May", "1998")
                .submitForm();

        checkComponent.haveResultPhrase()
                .checkResult("Name Surname")
                .checkResult("email@mail.com")
                .checkResult("Female")
                .checkResult("0123456789")
                .checkResult("19 May,1998");
    }

    @Test
    void negativeFormTest() {
        registrationPage.openSite("/automation-practice-form")
                .setFirstName("Name")
                .setLastName("Surname")
                .setUserEmail("email@mail")
                .submitForm();

        checkComponent.notHaveResultPhrase();
    }


}