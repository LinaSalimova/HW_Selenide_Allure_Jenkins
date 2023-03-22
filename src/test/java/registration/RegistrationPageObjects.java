package registration;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.TestBase;

import static io.qameta.allure.Allure.step;
import static registration.RandomUtils.randomInt;

public class RegistrationPageObjects extends TestBase {
    Faker faker = new Faker();

    @Test
    @Tag("faker")
    void studentRegistrationFormTest() {
        String name = faker.name().firstName(),
                lastName = faker.name().lastName(),
                email = faker.internet().emailAddress(),
                phoneNumber = String.valueOf(randomInt(5, 11)),
                currentAddress = faker.address().streetAddress(),
                gender = "Male",
                dateOfBirth = "6 November,1995",
                subject = "English",
                hobbies = "Sports",
                pictureFIleName = "file.png",
                pictureSource = "images/file.png",
                stateAndCity = "Haryana, Karnal";
        step("Заполнить поля формы и нажать кнопку", () -> {
        registrationPage.openPage()
                .setFirstName(name)
                .setLastName(lastName)
                .setEmail(email)
                .setGender(gender)
                .setUserNumber(phoneNumber)
                .setDate("06", "November", "1995")
                .setSubjects(subject)
                .setHobbies(hobbies)
                .setPicture(pictureSource)
                .setAddress(currentAddress)
                .setState("Haryana", "Karnal")
                .pressSubmit();
        });
        step("Проверить корректность заполнения данных в таблице", () -> {
        registrationPage.verifyResultsModalAppears()
                .verifyResults("Student Name", name + " " + lastName)
                .verifyResults("Student Email", email)
                .verifyResults("Gender", gender)
                .verifyResults("Mobile", phoneNumber)
                .verifyResults("Date of Birth", dateOfBirth)
                .verifyResults("Address", currentAddress)
                .verifyResults("Subjects", subject)
                .verifyResults("Hobbies", hobbies)
                .verifyResults("Picture", pictureFIleName)
                .verifyResults("State and City", stateAndCity);
        });
    }
}
