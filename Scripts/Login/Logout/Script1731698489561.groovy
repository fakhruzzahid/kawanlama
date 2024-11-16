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

// Test Case: Logout
WebUI.openBrowser('')

WebUI.navigateToUrl('https://katalon-demo-cura.herokuapp.com/')

WebUI.click(findTestObject('Login Page/main_menu_toggle'))

WebUI.click(findTestObject('Login Page/login_menu'))

WebUI.setText(findTestObject('Login Page/input_username'), findTestData('Login User').getValue(1, 1 // Replace with valid username
        ))

WebUI.setText(findTestObject('Login Page/input_password'), findTestData('Login User').getValue(2, 1 // Replace with valid password
        ))

WebUI.click(findTestObject('Login Page/button_Login'))

// Verify successful login
WebUI.verifyElementPresent(findTestObject('Login Page/title_make_appointment'), 10)

WebUI.click(findTestObject('Login Page/main_menu_toggle'))

WebUI.click(findTestObject('Login Page/logout_button'))

WebUI.verifyElementPresent(findTestObject('Login Page/main_page_verify'), 10 // Login button should be visible again
    )

WebUI.closeBrowser()

