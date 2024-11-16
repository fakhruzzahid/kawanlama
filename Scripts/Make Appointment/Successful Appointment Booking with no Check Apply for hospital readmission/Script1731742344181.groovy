import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

// Test Case: Successful Appointment Booking
WebUI.openBrowser('')

WebUI.navigateToUrl('https://katalon-demo-cura.herokuapp.com/')

WebUI.click(findTestObject('Login Page/main_menu_toggle'))

WebUI.click(findTestObject('Login Page/login_menu'))

WebUI.setText(findTestObject('Login Page/input_username'), findTestData('Login User').getValue(1, 1 // Replace with valid username
        ))

WebUI.setText(findTestObject('Login Page/input_password'), findTestData('Login User').getValue(2, 1 // Replace with valid password
        ))

WebUI.click(findTestObject('Login Page/button_Login'))

// Complete appointment form
WebUI.selectOptionByValue(findTestObject('Make Appointment Page/select_facility'), findTestData('Make Appointment').getValue(
        1, 1), true // Example
    )

WebUI.check(findTestObject('Make Appointment Page/radio_program_medicare'))

WebUI.setText(findTestObject('Make Appointment Page/input_visit_date'), findTestData('Make Appointment').getValue(2, 1))

WebUI.setText(findTestObject('Make Appointment Page/textarea_comment'), findTestData('Make Appointment').getValue(3, 1))

WebUI.click(findTestObject('Make Appointment Page/button_Book Appointment'))

// Verify successful appointment booking
WebUI.verifyElementText(findTestObject('Make Appointment Page/verify_facility'), findTestData('Make Appointment').getValue(
        1, 1))

WebUI.verifyElementText(findTestObject('Make Appointment Page/verify_apply_hospital'), 'No')

WebUI.verifyElementText(findTestObject('Make Appointment Page/verify_program'), findTestData('Make Appointment').getValue(
        4, 1))

WebUI.verifyElementText(findTestObject('Make Appointment Page/verify_visit_date'), findTestData('Make Appointment').getValue(
        2, 1))

WebUI.verifyElementText(findTestObject('Make Appointment Page/verify_comments'), findTestData('Make Appointment').getValue(
        3, 1))

WebUI.closeBrowser()

