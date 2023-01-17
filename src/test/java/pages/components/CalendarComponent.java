package pages.components;
import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {
    public void setData(String day, String month, String year){
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("November");
        $(".react-datepicker__year-select").selectOption("1995");
        $(".react-datepicker__day--0" +day).click();
    }
}
