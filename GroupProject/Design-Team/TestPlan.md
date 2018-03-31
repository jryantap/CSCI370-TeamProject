# Test Plan






****Author****:  Team 5



## 1 Testing Strategy



### 1.1 Overall strategy



*_This section should provide details about your unit-, integration-, system-, and regression-testing strategies. In particular, it should discuss which activities you will perform as part of your testing process, and who will perform such activities._*



### 1.2 Test Selection



*_Here you should discuss how you are going to select your test cases, that is, which black-box and/or white-box techniques you will use. If you plan to use different techniques at different testing levels (e.g., unit and system), you should clarify that._*



### 1.3 Adequacy Criterion



*_Define how you are going to assess the quality of your test cases. Typically, this involves some form of functional or structural coverage. If you plan to use different techniques at different testing levels (e.g., unit and system), you should clarify that._*



### 1.4 Bug Tracking



*_Describe how bugs and enhancement requests will be tracked._*



### 1.5 Technology



*_Describe any testing technology you intend to use or build (e.g., JUnit, Selenium)._*



## 2 Test Cases




| Test Case ID | Test Case Summary | Precondition |Test Procedure | Test Data | Expected Result | Actual Result | Pass/Fail | Created By | Date of Creation | Executed By | Date of Execution | Test Environment
| :-- | :-- | :-- | :-- | :-- | :-- | :-- | :-- | :-- | :-- | :-- | :-- |:--
| TC01 | Successful login to app. | 1. A valid user account to login. | 1. Open App. <br> 2. Enter UserID. <br> 3. Enter password. 4. Click "Login". | UserID = tjesus, Password = 370Spring18 | User is logged in successfully.
| TC02 | Error message on unsuccessful login. | 1. A valid user name to login. | 1. Open app. <br> 2. Enter UserID. <br> 3. Enter password. <br> 4. Click "Login". | UserID = tjesus, Password = 30Spring18 | Error message is displayed and user is not logged in.
| TC03 | Successful creation of new list. | 1. User must be logged in. | 1. Select "Create New List". <br> 2. Enter the name of the list. <br> 3. Select "Create List". | List name = Grocery List | User successfully creates a new list named "Grocery List".
| TC04 | Error message on attempting to create a new list with a list name already in use. | 1. User must be logged in. <br> 2. Lists are already created. | 1. Select "Create New List" <br> 2. Enter the name of the list <br> 3. Select "Create List" | List name = Grocery List | Error message is displayed and the user has not created a new list.
| TC05 | Successful addition of an item to a list from the item database. | 1. User must be logged in. <br> 2. User created a list. <br> 3. User selected a list. <br> 4. Item exists in the database. <br> 5. Item being added is not on the selected list. | 1. User searches for the item name or item type in the space provided. <br> 2. User selects the item from the item database. <br> 3. User clicks "Add Item" or double clicks the item name. | List name = Grocery List, Item name = milk | Item "milk" is successfully added to the list named "Grocery List".
| TC06 | Error message on attempting to add an item already on a list from the item database. | 1. User must be logged in. <br> 2. User created a list. <br> 3. User selected a list. <br> 4. User added items to a list. | 1. User searches for the item name or item type in the space provided. <br> 2. User selects the item from the item database. <br> 3. User clicks "Add Item" or double clicks the item name. | List name = Grocery List, Item name = milk | Error message is displayed and item milk is not added.
| TC07 | Successful deletion of an item from a list. | 1. User must be logged in. <br> 2. User has created a list. <br> 3. User has items on a list. | 1. User selects a list to delete an item from. <br> 2. User selects item to delete. <br> 3. User selects "Delete Item". | List name = Grocery, Item name = milk | Item "milk" is successfully deleted from list "Grocery list".
| TC08 | Error message on attempting to delete an item from a list without selecting an item. | 1. User must be logged in. <br> 2. User has created a list. <br> 3. User has items on a list. | 1. User selects a list to delete an item from. <br> 2. User selects "Delete Item". | Error message is displayed and no deletion occurs.
| TC09 | Successful update to an item's quantity. | 1. User must be logged in. <br> 2. User has created a list. <br> 3. User has items on a list. | 1. User selects a list. <br> 2. User selects an item. <br> 3. User enters quantity amount in the space provided and presses "Enter". | List name = Grocery List, item name = milk, quantity = 2 | Item "milk" has its quantity updated from "1" to "2" in list "Grocery List".
| TC10 | Successful addition of an item to a list without searching the item database. | 1. User must be logged in. <br> 2. User has created a list. | 1. User selects a list. <br> 2. User types item name in space provided. <br> 3. User clicks "Add Item". | List name = Grocery List, item name = eggs | Item "eggs" is added to list "Grocery List".
| TC11 | User searches for an item not found in the database.
| TC12 | Successful item check-off in a list. | 1. User must be logged in <br> 2. User has created a list. <br> 3. User has items on a list. <br> 4. Box next to item to be checked-off is empty. | 1. User selects a list. <br> 2. User clicks on an empty box next to an item. | List name = "Grocery List" | Check-off mark appears in the box next to the item.
| TC13 | Successfully clear one check-off mark from a list. | 1. User must be logged in <br> 2. User has created a list. <br> 3. User has items on a list. <br> 4. Box next to item has a check-off mark. | 1. User selects a list. <br> 2. User clicks on a box with a check-off mark. | Check-off mark is cleared and the box is now empty.
| TC14 | Successfully clear all check-off marks from a list at once. | 1. User must be logged in <br> 2. User has created a list. <br> 3. User has items on a list. <br> 4. One or more items are checked-off. | 1. User selects a list. <br> 2. User clicks on "Clear All Check-Off Marks". | List name = Grocery List. | All check-off marks have been cleared and items still remain in the list.
| TC15 | Successfully calculate the total balance. | 1. User must be logged in. <br> 2. User has created a list. | 1. Check the list contain at least zero or more item. <br> 2. Check are there any duplicate items. <br> 3. Cost of each item.| Item Name = "blah"<br> ItemCost = 3.2 <br> ItemNumber = 5 | Total Balance of the list |
| TC16 | Successfully check the cost of an item. | 1. Have an item. | Check database for cost of the item. | ItemName="blah" | Positive float number |
| TC17 | Error message on an invalid item number(count). | Have an Item | Open app and check the number of Item in the list | ItemName="blah" <br> ItemNumber = a | Item Number must be zero or more integer |
