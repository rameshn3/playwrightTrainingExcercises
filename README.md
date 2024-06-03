# playwrightTrainingExcercises
Challenge 1:
go to https://testsheepnz.github.io/BasicCalculator.html
enter the data in first and second fields 
then select different options using label, value and index
clickon calculate
then get the text from answer field

Challenge 2:
select an option from Jquery Drop Down with Disabled values using java playwright
Initialize Playwright: Create an instance of Playwright and launch a browser.
Navigate to the URL:"https://www.lambdatest.com/selenium-playground/jquery-dropdown-search-demo"
Open the Dropdown: Use page.click to open the specific dropdown for "Drop Down with Disabled values".The selector is more specific to target this particular dropdown.
Wait for Options to Load: Ensure the dropdown options are loaded by using page.waitForSelector.
Select the desired value by clicking on it. Ensure you select a non-disabled option, e.g., "American Samoa"


challenge3:
Initialize Playwright: Create an instance of Playwright and launch a browser.
Navigate to the URL: "https://www.lambdatest.com/selenium-playground/jquery-dropdown-search-demo"
Open the Dropdown: Use page.click to open the dropdown by clicking on the dropdown's selector.
Wait for Options to Load: Ensure the dropdown options are loaded by using page.waitForSelector.
Select the Value: Use page.click to select the desired value from the dropdown by its text.
This example demonstrates selecting the value "India"  and "Australia" from the dropdown. 


challenge 4:
Initialize Playwright: Create an instance of Playwright and launch a browser.
Navigate to the URL:"https://www.lambdatest.com/selenium-playground/select-dropdown-demo"
select an option by label, value and index from day dropdown
and assert the selected option is present in the text or not

challenge 5:
Initialize Playwright: Create an instance of Playwright and launch a browser.
Navigate to the URL:"https://www.lambdatest.com/selenium-playground/select-dropdown-demo"
select multiple options from states dropdown
and print all the dropdown options texts

challenge 6:
Initialize Playwright: Create an instance of Playwright and launch a browser.
Navigate to the URL:"https://www.lambdatest.com/selenium-playground/simple-form-demo"
type the value using type()
get the text of the typed one using textContext()

challenge 7:
Initialize Playwright: Create an instance of Playwright and launch a browser.
Navigate to the URL:"https://www.lambdatest.com/selenium-playground/generate-file-to-download-demo"
type the value using fill()
get the text of the typed one using textContext()

challenge 8:
Initialize Playwright: Create an instance of Playwright and launch a browser.
Navigate to the URL:"https://letcode.in/edit"
get the input field data using inputValue()
get the palceholder value using getAttribute()
clear the content in clearme editbox

challenge 9:
Initialize Playwright: Create an instance of Playwright and launch a browser.
Navigate to the URL:"https://www.lambdatest.com/selenium-playground/checkbox-demo"
Click on check box under Single Checkbox Demo

challenge 10:
Initialize Playwright: Create an instance of Playwright and launch a browser.
Navigate to the URL: "https://www.lambdatest.com/selenium-playground/checkbox-demo".
Check the Checkboxes: Use page.check to check the checkboxes. 
The check method ensures the checkbox is checked, and if it is already checked, it does nothing.
Assertions:
Use page.isChecked to verify that each checkbox is indeed checked.
Print a success message if all assertions pass.