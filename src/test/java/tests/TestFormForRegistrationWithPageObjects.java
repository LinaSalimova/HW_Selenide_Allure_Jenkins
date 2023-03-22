package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;


public class TestFormForRegistrationWithPageObjects extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void studentRegistrationForm() {
        registrationPage
                .openPage()
                .setFirstName(name)
                .setLastName(lastName)
                .setEmail(email)
                .setGender(gender)
                .setUserNumber(phoneNumber)
                .setDate("06", "November", "1995")
                .setSubjects(subject)
                .setHobbies(hobby)
                .setPicture(fIleName)
                .setAddress(currentAddress)
                .setState("Haryana", "Karnal")
                .pressSubmit();

        registrationPage.verifyResultsModalAppears()
                .verifyResults("Student Name", fullName)
                .verifyResults("Student Email", email)
                .verifyResults("Gender", gender)
                .verifyResults("Mobile", phoneNumber)
                .verifyResults("Date of Birth", birthDate)
                .verifyResults("Subjects", subject)
                .verifyResults("Hobbies", hobby)
                .verifyResults("Picture", pictureFIleName)
                .verifyResults("Address", currentAddress)
                .verifyResults("State and City", stateAndCity);
    }
}
