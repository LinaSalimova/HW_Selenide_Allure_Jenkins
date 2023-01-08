import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

    public class TestFormForRegistration {
       @Test
      void studentRegistrationForm() {
       open("https://demoqa.com/automation-practice-form");
       $(".main-header").shouldHave(text("Practice Form"));
       $("#firstName ").setValue("Pavel");
       $("#lastName ").setValue("Lepet");
       $("#userEmail ").setValue("pavellepet@gmail.com");
       //gender
       $("#gender-radio-1").shouldHave(text("Male")).click();
       $("#userNumber ").setValue("8455345245");
       //Date of Birth
       $("#dateOfBirthInput ").click();
       $(".react-datepicker__header").click();
       $(byText("2023")).hover();
       $(byText("1995")).click();

       $("#subjectsContainer ").setValue("History");
       //Hobbies
       //Picture
       $("#currentAddress").setValue("2600 North Military Trail West Palm Beach FL 33409-0000 USA");
       //State and City
       $("#submit").shouldHave(text("Submit")).click();
       sleep(500);
       $("#output").shouldBe(visible);
       $("#output #email").shouldHave(text("pavellepet@gmail.com"));
    }
}
