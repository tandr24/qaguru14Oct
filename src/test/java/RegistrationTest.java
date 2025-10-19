import data.TestData;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.components.CheckComponent;

public class RegistrationTest extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();
    CheckComponent checkComponent = new CheckComponent();

    @Test

    void formTest() {
        TestData testData = new TestData();
        registrationPage
                .openSite("/automation-practice-form")
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setUserEmail(testData.email)
                .setGender(testData.gender)
                .setNumber(testData.phone)
                .setDateOfBirth(testData.day, testData.month, testData.year)
                .setRandomSubject(testData.valueOfSubject, testData.numOfSubject)
                .setRandomHobbies(testData.valueOfHobbies, testData.numOfHobbies)
                .setPicture(testData.img)
                .setAddress(testData.address)
                .setState(testData.state)
                .setCity(testData.city)
                .submitForm();

        checkComponent.haveResultPhrase()
                .checkResult(testData.firstName + " " + testData.lastName)
                .checkResult(testData.email)
                .checkResult(testData.gender)
                .checkResult(testData.phone)
                .checkResult(testData.day + " " + testData.month + "," + testData.year)
                .checkResult(testData.valueOfSubject, testData.numOfSubject)
                .checkResult(testData.valueOfHobbies, testData.numOfHobbies)
                .checkResult(testData.img)
                .checkResult(testData.address)
                .checkResult(testData.state + " " + testData.city);
    }
}
