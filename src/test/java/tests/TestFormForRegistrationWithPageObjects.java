package tests;

import org.junit.jupiter.api.Test;
import pages.components.RegistrationPage;

import static com.codeborne.selenide.Selenide.executeJavaScript;
import static io.qameta.allure.Allure.step;


public class TestFormForRegistrationWithPageObjects extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void studentRegistrationForm() {
        step("Close banner", () -> {
            executeJavaScript("$('#fixedban').remove()");
            executeJavaScript("$('footer').remove()");
        });
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
                .setPicture(pictureSource)
                .setAddress(currentAddress)
                .setStateCity("Haryana", "Karnal")
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
