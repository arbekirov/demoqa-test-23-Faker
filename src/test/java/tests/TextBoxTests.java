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
                .setEmail(testData.email)
                .setGender(testData.gender)
                .setUserNumber(testData.phoneNumber)
                .setDateOfBirth(testData.yearBirth, testData.monthBirth, testData.dayOfBirth)
                .setSubject(testData.subjects)
                .setHobbiesWrapper(testData.hobbies)
                .setUploadPicture("photography.png")
                .setAddress(testData.address)
                .setStateAndCity(testData.state, testData.city);


        registrationPage.checkResult("Student Name",testData.firstName)
                .checkResult("Student Name",testData.lastName)
                .checkResult("Student Email", testData.email)
                .checkResult("Gender", testData.gender)
                .checkResult("Mobile", testData.phoneNumber)
                .checkResult("Date of Birth",testData.yearBirth)
                .checkResult("Date of Birth", testData.monthBirth)
                .checkResult("Date of Birth", testData.dayOfBirth)
                .checkResult("Subjects", testData.subjects)
                .checkResult("Hobbies", testData.hobbies)
                .checkResult("Picture", "photography.png")
                .checkResult("Address", testData.address)
                .checkResult("State and City",testData.state)
                .checkResult("State and City",testData.city);
    }
    @Test
    void formCreateStudentMinimal() {
        registrationPage.openPage()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setGender(testData.gender)
                .setUserNumber(testData.phoneNumber)
                .setSubmitForm();



        registrationPage.checkResultMinimum("Student Name",testData.firstName)
                .checkResultMinimum("Student Name",testData.lastName)
                .checkResultMinimum("Gender", testData.gender)
                .checkResultMinimum("Mobile", testData.phoneNumber);

    }
    @Test
    void formNoCreateStudent() {
        registrationPage.openPage()
                .setSubmitForm();



        registrationPage.checkInputInvalidBorderColor("border-color",testData.borderColorInput)
                .checkRadioInvalidBorderColor("border-color", testData.borderColorRadio);
    }
}
