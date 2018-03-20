## Grocery List Manager Design Information

Requirements:
1.	A grocery list consists of items the users want to buy at a grocery store. The application must allow users to add items to a list, delete items from a list, and change the quantity of items in the list (e.g., change from one to two pounds of apples).
To realize this requirement, I added to the design a class List with attributes listName, and itemName. In class List there are methods addToList(), deleteFromlist(), and updateQuantity().
2.	The application must contain a database (DB) of items and corresponding item types.  
Added class ItemInventory with attributes itemType and itemName.
3.	Users must be able to add items to a list by picking them from a hierarchical list, where the first level is the item type (e.g., cereal), and the second level is the name of the  
actual item (e.g., shredded wheat). After adding an item, users must be able to specify a 
quantity for that item.
Will add itemType Node and itemName Node.
4.	Users must also be able to specify an item by typing its name. In this case, the  application must look in its DB for items with similar names and ask the users, for each of them, whether that is the item they intended to add. If a match cannot be found, the application must ask the user to select a type for the item and then save the new item, together with its type, in its DB.  
Added method itemSearch() and attribute isCorrectItem to class Item.
5.	Lists must be saved automatically and immediately after they are modified.  
Will be implemented in class List.
6.	Users must be able to check off items in a list (without deleting them).
Will be implemented with object-oriented code.
7.	Users must also be able to clear all the check-off marks in a list at once.
Will be implemented with object-oriented code.
8.	Check-off marks for a list are persistent and must also be saved immediately.
Will be implemented in class List.
9.	The application must present the items in a list grouped by type, so as to allow users to shop for a specific type of products at once (i.e., without having to go back and forth  between aisles).
Added method sortItems() to class ItemInventory.
10.	The application must support multiple lists at a time (e.g., “weekly grocery list”, “monthly  farmer’s market list”). Therefore, the application must provide the users with the ability to create, (re)name, select, and delete lists.
Added class ListManager with attributes listID and listName along with methods createList(), renameList(), selectList(), and deleteList().
11.	The User Interface (UI) must be intuitive and responsive.  
Not considered because it does not affect the design directly.
