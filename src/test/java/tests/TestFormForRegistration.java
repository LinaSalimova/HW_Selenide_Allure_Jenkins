package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class TestFormForRegistration extends TestBase {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void studentRegistrationForm() {

        open("/automation-practice-form");
        $(".main-header").shouldHave(text("Practice Form"));
        $("#firstName ").setValue(name);
        $("#lastName ").setValue(lastName);
        $("#userEmail ").setValue(email);
        //gender
        $("#gender-radio-1").parent().click();
        $("#userNumber ").setValue(phoneNumber);
        //Date of Birth
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(birthMonth);
        $(".react-datepicker__year-select").selectOption(birthYear);
        $(".react-datepicker__day--0" + birthDay + ":not(.react-datepicker__day--outside-month)").click();
        //Subjects
        $("#subjectsInput ").setValue(subject).pressTab().click();
        //Hobbies
        $("#hobbiesWrapper").$(byText(hobby)).click();
        //Picture
        $("#uploadPicture").uploadFromClasspath(("img\\1.pmg"));
        $("#currentAddress").setValue(currentAddress);
        //State and City
        $("#state").click();
        $("#stateCity-wrapper").$(byText(state)).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText(city)).click();
        $("#submit").click();
        $(".modal-content").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text(fullName));
        $(".table-responsive").$(byText("Student Email")).parent().shouldHave(text(email));
        $(".table-responsive").$(byText("Gender")).parent().shouldHave(text(gender));
        $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text(phoneNumber));
        $(".table-responsive").$(byText("Date of Birth")).parent().shouldHave(text(birthDate));
        $(".table-responsive").$(byText("Subjects")).parent().shouldHave(text(subject));
        $(".table-responsive").$(byText("Hobbies")).parent().shouldHave(text(hobby));
        $(".table-responsive").$(byText("Picture")).parent().shouldHave(text(("img\\1.pmg")));
        $(".table-responsive").$(byText("Address")).parent().shouldHave(text(currentAddress));
        $(".table-responsive").$(byText("State and City")).parent().shouldHave(text(stateAndCity));
    }
}
