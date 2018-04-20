# Test Plan



******Author******:  Thom De Jesus, Thomas Chu

Version 4.0

Summary of Changes:

Version 4.0:
* Added additional test cases due to extended deliverable release date.

Version 3.0:
* Unable to implement necessary test cases for deliverable 4 due to time constraints. Still require more test cases along with revisions to existing test cases to reflect deliverable 4 changes.

Version 2.0:
* Added notes to test cases that were no longer valid.
* Revised test cases to reflect app implementation changes. (Removed login screen; Added floating action button)
* Added test case TC18 implementing floating action button on main screen.
* Added test case TC19 for deleting entire list(s).

## 1 Testing Strategy



### 1.1 Overall strategy



* Unit Testing (To be performed by Dev and QA team)
    * The methods of the app's code will be tested, focusing on the tests that impact the behavior of the system.
    * Before a defect is fixed, a test exposing the defect will be written in case the defect was not properly fixed.
    * All paths through the unit will be tested.
    * Test cases will also be written to ensure performance of the code.
* Integration Testing (To be performed by Dev and QA team)
    * *_Big Bang Approach_* will be utilized, as in the testing of all or most of the units at one time.
    * Testing will be done according to the design document which contain the clear definitions of interactions between each unit.
    * Each unit will be tested individually prior to integration testing.
* System Testing (To be performed by QA team)
    * Testing will be performed after the Unit and Integration Testing levels.
    * The app as a whole will be tested.
* Acceptance Testing (To be performed by all not involved prior testing)
    * Testing will be performed after completion of the System Testing level and prior to release.



### 1.2 Test Selection



The test cases will be selected depending on whether we are testing the app's requirement specifications or its design details. The white-box techniques will be utilized in testing the design details, to be performed at the Unit and Integration Testing levels, which are mainly applicable to the lower levels of testing. The black-box techniques will be utilized in testing the requirement specifications, which will mainly be applicable to the higher levels of testing. These will be performed at the Acceptance and System Testing levels.



### 1.3 Adequacy Criterion



The quality of the test cases will be assessed by utilizing condition/decision coverage with an intermediate goal of 80% - 90% coverage before release as to not expend a lot of effort attempting to attain a 100% coverage initially.



### 1.4 Bug Tracking



Bug and enhancement requests will be tracked by utilizing open source bug tracking such as Sentry.



### 1.5 Technology




The testing technology intended to be utilized in this project will mainly consist of JUnit, Selenium, and Sentry.




## 2 Test Cases




| Test Case ID | Test Case Summary | Precondition | Test Procedure | Test Data | Expected Result | Actual Result | Pass/Fail | Created By | Date of Creation | Executed By | Date of Execution | Test Environment | Notes
| :-- | :-- | :-- | :-- | :-- | :-- | :-- | :-- | :-- | :-- | :-- | :-- | :-- | :--
| TC01 | Successful login to app. | 1. A valid user account to login. | 1. Open App. <br> 2. Enter UserID. <br> 3. Enter password. 4. Click "Login". | UserID = tjesus, Password = 370Spring18 | User is logged in successfully. | N/A | Fail | Thom De Jesus | N/A | N/A | N/A | Android Studio | Test Case not valid. Login screen not yet implemented.
| TC02 | Error message on unsuccessful login. | 1. A valid user name to login. | 1. Open app. <br> 2. Enter UserID. <br> 3. Enter password. <br> 4. Click "Login". | UserID = tjesus, Password = 30Spring18 | Error message is displayed and user is not logged in. | N/A | Fail | Thom De Jesus | N/A | N/A | N/A | Android Studio | Test Case not valid. Login screen not yet implemented.
| TC03 | Successful creation of new list. | None | 1. Open app. <br> 2. Click "+" button on top of screen. <br> 3. Enter the name of the list. <br> 4. Click "SUBMIT" when done. | List name = weekly | User successfully creates a new list named "weekly". | N/A | N/A | Thom De Jesus | N/A | N/A | N/A | Android Studio | N/A
| TC04 | Error message on attempting to create a new list with a list name already in use. | 1. App is open. <br> 2. Lists are already created. | 1. Click "+" button on top of screen. <br> 2. Enter the name of the list. | List name = weekly | Error message is displayed and the user has not created a new list. | N/A | N/A | Thom De Jesus | N/A | N/A | N/A | Android Studio | N/A
| TC05 | Successful addition of an item to a list from the item database. | 1. User created a list. <br> 2. User selected a list. <br> 3. Item exists in the database. <br> 4. Item being added is not on the selected list. | 1. User searches for the item name or item type in the space provided. <br> 2. User selects the item from the item database. <br> 3. User double clicks the item name. <br> 4. User enters quantity and clicks "OK". | List name = weekly, Item name = apple, quantity = 2 | Item "apple" with quanitity "2" is successfully added to the list named "weekly". | N/A | N/A | Thom De Jesus | N/A | N/A | N/A | Android Studio | N/A
| TC06 | Error message on attempting to add an item already on a list from the item database. | 1. User created a list. <br> 2. User selected a list. <br> 3. User added items to the list. | 1. User searches for the item name or item type in the space provided. <br> 2. User selects the item from the item database. <br> 3. User clicks "Add Item" or double clicks the item name. | List name = weekly, Item name = apple | Error message is displayed and item milk is not added. | N/A | N/A | Thom De Jesus | N/A | N/A | N/A | Android Studio | N/A
| TC07 | Successful deletion of an item from a list. | 1. User has created a list. <br> 2. User has items in a list. | 1. User selects a list to delete an item from. <br> 2. User selects an item in the list to delete by clicking the check box to the right of the item. <br> 3. User clicks on the trash icon at the top of the screen. <br> 4. User confirms deletiong. | List name = weekly, Item name = apple | Item "apple" is successfully deleted from list "weekly".| N/A | N/A | Thom De Jesus | N/A | N/A | N/A | Android Studio | N/A
| TC08 | Error message on attempting to delete an item from a list without selecting an item. | 1. User has created a list. <br> 2. User has items on a list. | 1. User selects a list to delete an item from. <br> 2. User clicks on the trash icon at the top of the screen. | Error message is displayed and no deletion occurs. | N/A | N/A | Thom De Jesus | N/A | N/A | N/A | Android Studio | N/A
| TC09 | Successful update to an item's quantity. | 1. User has created a list. <br> 2. User has items on a list. | 1. User selects a list. <br> 2. User selects an item in the list. <br> 3. User enters quantity amount in the space provided and clicks "OK". | List name = weekly, item name = apple, quantity = 3 | Item "apple" has its quantity updated from "2" to "3" in list "weekly". | N/A | N/A | Thom De Jesus | N/A | N/A | N/A | Android Studio | N/A
| TC10 | Successful addition of an item to a list without searching the item database. | 1. User has created a list. | 1. User selects a list. <br> 2. User types item name in space provided. <br> 3. User clicks "Add Item". | List name = Grocery List, item name = eggs | Item "eggs" is added to list "Grocery List". | N/A | N/A | Thom De Jesus | N/A | N/A | N/A | Android Studio | Test not valid for latest version of app. Must search for item first.
| TC11 | User successfully adds item for an item not found in the database. | 1. User has created a list. | 1. User selects a list. <br> 2. User clicks on magnifying glass icon. <br> 3. User types in item name and clicks "SEARCH". <br> 4. User clicks "CREATE NEW ITEM". <br> 5. User enters "Item Name", "Type", and "Quantity" and clicks "CREATE". | List name = weekly, item name = milk, item type = dairy, quantity = 1 | Item "milk" is successfully added to database under type dairy and to list with quantity 1.
| TC12 | Successful item check-off in a list. | 1. User has created a list. <br> 2. User has items on a list. <br> 3. Box next to item to be checked-off is empty. | 1. User selects a list. <br> 2. User clicks on an empty box next to an item. | List name = weekly, item name = apple, box = empty | Check-off mark appears in the box next to the item named "apple" in list "weekly". | N/A | N/A | Thom De Jesus | N/A | N/A | N/A | Android Studio | N/A
| TC13 | Successfully clear one check-off mark from a list. | 1. User has created a list. <br> 2. User has items on a list. <br> 3. Box next to item has a check-off mark. | 1. User selects a list. <br> 2. User clicks on a box with a check-off mark. | List name = weekly, item name = apple, box = checked-off | Check-off mark is cleared next to item "apple" and the box is now empty. | N/A | N/A | Thom De Jesus | N/A | N/A | N/A | Android Studio | N/A
| TC14 | Successfully clear all check-off marks from a list at once. | 1. User has created a list. <br> 2. User has items on a list. <br> 3. One or more items are checked-off. | 1. User selects a list. <br> 2. User clicks on the 3 vertical dots and selects "clearCheck". | List name = weekly | All check-off marks have been cleared and items still remain in the list. | N/A | N/A | Thom De Jesus | N/A | N/A | N/A | Android Studio | N/A
| TC15 | Successfully calculate the total balance. | 1. User has created a list. | 1. Check the list contain at least zero or more item. <br> 2. Check are there any duplicate items. <br> 3. Cost of each item.| Item name = blah, Item cost = 3.2, Item number = 5 | Total Balance of the list is successfully calculated. | N/A | N/A | Thomas Chu | N/A | N/A | N/A | Android Studio | Test case not valid. Item cost and balance not yet implemented.
| TC16 | Successfully check the cost of an item. | 1. Have an item. | 1. Check database for cost of the item. | Item name = blah | Correct cost of item will successfully appear. | N/A | N/A | Thomas Chu | N/A | N/A | N/A | Android Studio | Test case not valid. Item cost and balance not yet implemented.
| TC17 | Error message on an invalid item number (count). | 1.  Have an Item | 1. Check the number of Item in the list | Item name = blah, Item number = a | Error message is displayed. | N/A | N/A | Thomas Chu | N/A | N/A | N/A | Android Studio | Test case not valid. Item number input not implemented.
| TC18 | "+" button successfully brings user to "Add New List" interface. | 1. App is open. | 1. Click on "+" icon at the top of the screen. | N/A | User is brought to "Add New List" interface. | N/A | N/A | Thom De Jesus | N/A | N/A | N/A | Android Studio | N/A
| TC19 | Successful deletion of a list. | 1. User opens app. <br> 2. User has created a list. | 1. User chooses a list or lists to delete by clicking on empty check box to the right of list name. <br> 2. User clicks on trash icon. <br> 3. User confirms list(s) deletion by clicking "OK". | List name = weekly | List named "weekly" is successfully deleted. | N/A | N/A | Thom De Jesus | N/A | N/A | N/A | Android Studio | N/A
| TC20 | Back button successfully brings user to the previous interface.
| TC21 | Cancel button successfully cancels user's action.
| TC22 | Created item is successfully added in the database under correct item type.
| TC23 | Lists and items are successfully saved to app after exiting.
| TC24 | Clicking an item type succesfully opens a list of items of that type.
| TC25 | App successfully restricts usage of special characters or capital letters in list and item names. | Thomas Chu
| TC26 | Error message on attempting to search for an item without entering an input. | Thomas Chu
| TC27 | Item quantity only accepts integer input. | Thomas Chu
