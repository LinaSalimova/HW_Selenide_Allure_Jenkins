package tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class TestFormForRegistration extends TestBase {
    @Tag("remote")
    @Test
    void studentRegistrationForm() {
        step("Open form", () -> {
            open("/automation-practice-form");
            $(".main-header").shouldHave(text("Practice Form"));
            executeJavaScript("$('#fixedban').remove()");
            executeJavaScript("$('footer').remove()");
        });
        step("Fill form", () -> {
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
        $("#uploadPicture").uploadFromClasspath("images/" + pictureFIleName);
        $("#currentAddress").setValue(currentAddress);
        $("#state").click();
        $("#stateCity-wrapper").$(byText("Haryana")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Karnal")).click();;
        $("#submit").click();
        });
        step("Verify results", () -> {
        $(".modal-content").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").$(byText("Student Name")).parent().shouldHave(text(fullName));
        $(".table-responsive").$(byText("Student Email")).parent().shouldHave(text(email));
        $(".table-responsive").$(byText("Gender")).parent().shouldHave(text(gender));
        $(".table-responsive").$(byText("Mobile")).parent().shouldHave(text(phoneNumber));
        $(".table-responsive").$(byText("Date of Birth")).parent().shouldHave(text(birthDate));
        $(".table-responsive").$(byText("Subjects")).parent().shouldHave(text(subject));
        $(".table-responsive").$(byText("Hobbies")).parent().shouldHave(text(hobby));
        $(".table-responsive").$(byText("Picture")).parent().shouldHave(text(("images/file.png")));
        $(".table-responsive").$(byText("Address")).parent().shouldHave(text(currentAddress));
        $(".table-responsive").$(byText("State and City")).parent().shouldHave(text(stateAndCity));
        });
    }
}
