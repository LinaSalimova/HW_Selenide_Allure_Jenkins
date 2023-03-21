package pages.components;

import com.codeborne.selenide.SelenideElement;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {
    CalendarComponent calendarComponent = new CalendarComponent();
    RegistrationsResultsModal registrationsResultsModal = new RegistrationsResultsModal();
    private String TITLE_TEXT = "Practice Form";
    private SelenideElement lastNameInput = $("#lastName ");
    private SelenideElement firstNameInput = $("#firstName ");
    private SelenideElement header = $(".main-header");
    private SelenideElement email = $("#userEmail ");
    private SelenideElement gender = $("#genterWrapper");
    private SelenideElement userNumber = $("#userNumber ");
    private SelenideElement birthInput = $("#dateOfBirthInput");
    private SelenideElement setSubjects = $("#subjectsInput");
    private SelenideElement hobbies = $("#hobbiesWrapper");
    private SelenideElement address = $("#currentAddress");
    private SelenideElement stateCity = $("#stateCity-wrapper");
    private SelenideElement picture = $("input#uploadPicture");
    private SelenideElement state = $("#state");
    private SelenideElement city = $("#city");
    private SelenideElement submit = $("#submit");


    public RegistrationPage openPage() {
        open("/automation-practice-form");
        header.shouldHave(text(TITLE_TEXT));

        return this;
    }

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setEmail(String value) {
        email.setValue(value);

        return this;
    }

    public RegistrationPage setGender(String value) {
        gender.$(byText(value)).click();
        return this;
    }

    public RegistrationPage setUserNumber(String value) {
        userNumber.setValue(value);

        return this;
    }

    public RegistrationPage setDate(String day, String month, String year) {
        birthInput.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public RegistrationPage setSubjects(String subject) {
        setSubjects.setValue(subject).pressTab().click();
        ;
        return this;
    }

    public RegistrationPage setHobbies(String value) {
        hobbies.$(byText(value)).click();
        return this;
    }

    public RegistrationPage setAddress(String value) {
        address.setValue(value);

        return this;
    }

    public RegistrationPage setPicture(String value) {
        picture.uploadFile(new File("src/test/resources/" + value));
        return this;
    }

    public RegistrationPage setState(String value_1, String value_2) {
        state.click();
        stateCity.$(byText(value_1)).click();
        city.click();
        stateCity.$(byText(value_2)).click();

        return this;
    }

    public RegistrationPage pressSubmit() {
        submit.click();
        return this;
    }

    public RegistrationPage verifyResults(String key, String value) {
        registrationsResultsModal.verifyResult(key, value);

        return this;
    }

    public RegistrationPage verifyResultsModalAppears() {
        registrationsResultsModal.verifyModalAppears();
        return this;
    }
}
