package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

    public class TestFormForRegistration {
        @BeforeAll
        static void beforeAll() {
            Configuration.browserSize = "1920x1080";
            Configuration.baseUrl = "https://demoqa.com";
        }
       @Test
      void studentRegistrationForm() {
        String name = "Pavel";
        String lastName = "Lepet";
        String email = "pavellepet@gmail.com";
        String phoneNumber = "8455345245";
        String subject = "English";
        String currentAddress = "2600 North Military Trail West Palm Beach FL 33409-0000 USA";

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
        $(".react-datepicker__month-select").selectOption("November");
        $(".react-datepicker__year-select").selectOption("1995");
        $(".react-datepicker__day--06" ).click();
        //Subjects
       $("#subjectsInput ").setValue(subject).pressTab().click();
       //Hobbies
       $("#hobbiesWrapper").$(byText("Sports")).click();
       //Picture
       $("#uploadPicture").uploadFromClasspath("img\\1.pmg");
       $("#currentAddress").setValue(currentAddress);
       //State and City
       $("#state").click();
       $("#stateCity-wrapper").$(byText("Haryana")).click();
       $ ("#city").click();
       $("#stateCity-wrapper").$(byText("Karnal")).click();
       $("#submit").shouldHave(text("Submit")).pressEnter();
       $(".modal-content").should(appear);
       $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
    }
}
