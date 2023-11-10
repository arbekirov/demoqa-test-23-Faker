package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static tests.TestData.*;

public class TextBoxTests extends TestBase{

    RegistrationPage registrationPage = new RegistrationPage();
    TestData testData = new TestData();
    @Test
    void formCreateStudent() {
        registrationPage.openPage()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setEmail("arb@sink.com")
                .setGender("Male")
                .setUserNumber("8989777777")
                .setDateOfBirth("15", "May","1996")
                .setSubject("History")
                .setHobbiesWrapper("Sports")
                .setUploadPicture("photography.png")
                .setAddress("street road")
                .setStateAndCity("NCR","Delhi");


        registrationPage.checkResult("Student Name",testData.firstName)
                .checkResult("Student Name",testData.lastName)
                .checkResult("Student Email", "arb@sink.com")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "8989777777")
                .checkResult("Date of Birth", "15 May,1996")
                .checkResult("Subjects", "History")
                .checkResult("Hobbies", "Sports")
                .checkResult("Picture", "photography.png")
                .checkResult("Address", "street road")
                .checkResult("State and City", "NCR Delhi");
    }
    @Test
    void formCreateStudentMinimal() {
        registrationPage.openPage()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setGender("Male")
                .setUserNumber("8989777777")
                .setSubmitForm();



        registrationPage.checkResultMinimum("Student Name",testData.firstName)
                .checkResultMinimum("Student Name",testData.lastName)
                .checkResultMinimum("Gender", "Male")
                .checkResultMinimum("Mobile","8989777777");

    }
    @Test
    void formNoCreateStudent() {
        registrationPage.openPage()
                .setSubmitForm();



        registrationPage.checkInputInvalidBorderColor("border-color","rgb(220, 53, 69)")
                .checkRadioInvalidBorderColor("border-color","rgb(220, 53, 69)");
    }
}
