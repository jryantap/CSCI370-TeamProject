## Design Information

**User class** basically consist of the user interface.  A user will have to log on to access his or her shopping list.  User name and password are store on a local db.

**GroceryDB** class has all the methods that are needed to access the local database.  With the correct user info, the user is given access to the *User_grocery_List*.  

**User_Grocery_List** categorizes all of the said user’s grocery list and its description.  The method *display_category()* will show all the list.  User should also be able to delete a list and add a new list with the use of this class.

Clicking on a **User_Grocery_list** will call the Grocery_List_Items.  The class lists specific items, quantity of the user’s grocery list.  Methods like *check_list(), unCheck_list()* give enables the activity to have uncheck on check in a UI.  User should be able to update item quantity, delete items and add items in the specific list.  
