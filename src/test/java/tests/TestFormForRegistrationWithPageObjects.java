package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;


public class TestFormForRegistrationWithPageObjects extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();
    @Test
    void studentRegistrationForm() {
        registrationPage
                .openPage()
                .setFirstName("Pavel")
                .setLastName("Lepet")
                .setEmail("pavellepet@gmail.com")
                .setGender("Male")
                .setUserNumber("8455345245")
                .setDate("06", "November", "1995")
                .setSubjects("English")
                .setHobbies("Sports")
                .setAddress("2600 North Military Trail West Palm Beach FL 33409-0000 USA")
                .setPicture("img\\1.pmg")
                .setState("Haryana","Karnal")
                .pressSubmit();

        registrationPage.verifyResultsModalAppears()
                .verifyResults("Student Name", fullName)
                .verifyResults("Student Email", email)
                .verifyResults("Gender", gender)
                .verifyResults("Mobile", phoneNumber)
                .verifyResults("Date of Birth", birthDate)
                .verifyResults("Subjects", subject)
                .verifyResults("Hobbies", hobby)
                .verifyResults("Picture", "img\\1.pmg")
                .verifyResults("Address", currentAddress)
                .verifyResults("State and City", stateAndCity);
    }
}
