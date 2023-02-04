package tests;
import org.junit.jupiter.api.Test;


public class TestFormForRegistrationWithPageObjects extends TestBase {
    @Test
    void studentRegistrationForm() {
        registrationPage
                .openPage()
                .setFirstName("Pavel")
                .setLastName("Lepet")
                .setEmail("pavellepet@gmail.com")
                .setGender("Male")
                .setUserNumber("8455345245")
                .setBirthDate("6", "Jul", "1995")
                .setAddress("2600 North Military Trail West Palm Beach FL 33409-0000 USA")
                .setHobbies("Sports")
                .setPicture("img\\1.pmg")
                .setState("Haryana", "Karnal")
                .pressSubmit("Submit");

        registrationPage.verifyResultsModalAppears()
                .verifyResults(" Student Name", "Pavel Lepet")
                .verifyResults(" Student Email", "pavellepet@gmail.com")
                .verifyResults(" Mobile", "8455345245");
    }
}
