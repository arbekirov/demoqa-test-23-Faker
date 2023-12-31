package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.ResultTableComponent;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPage {

    public RegistrationPage openPage(){
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        return this;
    }

    private SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            UserEmailInput = $("#userEmail"),
            genderWrapperInput = $("#genterWrapper"),
            radioGenderInput = $(".custom-control-label"),
            UserNumberInput = $("#userNumber"),
            CalendarInput = $("#dateOfBirthInput"),
            SubjectsInput = $("#subjectsInput"),
            HobbiesWrapperInput = $("#hobbiesWrapper"),
            UploadPictureInput = $("#uploadPicture"),
            AdressInput = $("#currentAddress"),
            stateDropdown = $("#state"),
            cityDropdown = $("#city"),
            stateInput = $("#react-select-3-input"),
            cityInput = $("#react-select-4-input"),
            submitFormInput = $("#submit"),
            CheckResultInput = $(".table-responsive");

    CalendarComponent calendarComponent = new CalendarComponent();
    ResultTableComponent resultTableComponent = new ResultTableComponent();

    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationPage setEmail(String value) {
        UserEmailInput.setValue(value);

        return this;

    }

    public RegistrationPage setGender(String value) {
        genderWrapperInput.$(byText(value)).click();

        return this;

    }
    public RegistrationPage setUserNumber(String value) {
        UserNumberInput.setValue(value);

        return this;

    }
    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        CalendarInput.click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    public RegistrationPage setSubject(String value) {
        SubjectsInput.val(value).pressEnter();
        return this;
    }

    public RegistrationPage setHobbiesWrapper(String value) {
        HobbiesWrapperInput.$(byText(value)).click();

        return this;

    }
    public RegistrationPage  setUploadPicture(String value) {
        UploadPictureInput.uploadFromClasspath(value);

        return this;

    }
    public RegistrationPage setAddress(String value) {
        AdressInput.setValue(value);

        return this;

    }

    public void setStateAndCity(String state, String city) {
        stateDropdown.scrollTo().click();
        stateInput.val(state).pressEnter();
        cityDropdown.click();
        cityInput.val(city).pressEnter().pressTab().pressEnter();

    }

    public void setSubmitForm() {
        submitFormInput.click();

    }

    public RegistrationPage checkResult(String key, String value) {
        CheckResultInput.$(byText(key)).parent().shouldHave(text(value));
        resultTableComponent.checkKeyValue(key, value);


        return this;
    }
    public RegistrationPage checkResultMinimum(String key, String value)  {
        CheckResultInput.$(byText(key)).parent()
                .shouldHave(text(value));

        return this;
    }
    public RegistrationPage checkInputInvalidBorderColor(String cssName, String cssValue) {
        firstNameInput.shouldHave(cssValue(cssName, cssValue));
        lastNameInput.shouldHave(cssValue(cssName, cssValue));
        UserNumberInput.shouldHave(cssValue(cssName, cssValue));

        return this;
    }

    public void checkRadioInvalidBorderColor(String cssName, String cssValue) {
        radioGenderInput.shouldHave(cssValue(cssName, cssValue));
        radioGenderInput.shouldHave(pseudo(":before", cssName, cssValue));


    }
}
