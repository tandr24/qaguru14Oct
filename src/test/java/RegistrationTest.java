import data.TestData;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.component.CheckComponent;


public class RegistrationTest extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    CheckComponent checkComponent = new CheckComponent();

    // @Test
    @RepeatedTest(10)

    void formTest() {
        registrationPage
                .openSite("/automation-practice-form")
                .setFirstName(TestData.firstName)
                .setLastName(TestData.lastName)
                .setUserEmail(TestData.email)
                .setGender(TestData.gender)
                .setNumber(TestData.phone)
                .setDateOfBirth(TestData.day, TestData.month, TestData.year)
                .setRandomSubject(TestData.subject)
                .setRandomHobbies(TestData.hobbies)
                .setPicture(TestData.img)
                .setAddress(TestData.address)
                .setState(TestData.state)
                .setCity(TestData.city)
                .submitForm();

        checkComponent.haveResultPhrase()
                .checkResult(TestData.firstName + " " + TestData.lastName)
                .checkResult(TestData.email)
                .checkResult(TestData.gender)
                .checkResult(TestData.phone)
                .checkResult(TestData.day + " " + TestData.month + "," + TestData.year)
                .checkResult(TestData.randomSubject)
                .checkResult(TestData.randomHobbies)
                .checkResult(TestData.img)
                .checkResult(TestData.address)
               .checkResult(TestData.state + " " + TestData.city);
    }
}
