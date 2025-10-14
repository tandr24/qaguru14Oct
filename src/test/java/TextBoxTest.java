import org.junit.jupiter.api.Test;
import pages.TextBoxPage;

import pages.component.CheckComponentForTextBox;


public class TextBoxTest extends TestBase {
    TextBoxPage textBoxPage = new TextBoxPage();
    CheckComponentForTextBox checkComponentForTextBox = new CheckComponentForTextBox();

    @Test
    void textBoxTest() {
        textBoxPage.openSite("/text-box")
                .setFirstName("Name")
                .setEmail("user@mail.com")
                .setPermanentAddress("Permanent Address")
                .setCurrentAddress("Current Address")
                .setSubmit();

        checkComponentForTextBox.checkResult("Name")
                .checkResult("user@mail.com")
                .checkResult("Permanent Address")
                .checkResult("Current Address");
    }

}
