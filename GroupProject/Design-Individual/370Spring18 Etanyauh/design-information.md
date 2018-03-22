Joseph Huaynate
===========

Customer Class
----------------
-createList(): allows the user to create a new list

-deleteList(listID): allows the user to delete the list
	Param: listID, int

- renameList(listID): allwos user to the rename the list
	Param: listID, int

-sameListName(listName): searches DB to see if there is another list of the same name
	Param: listName, string

Item Class
==========
-checkOff(): once the item is placed, it will be checked off the list

<Item Name>: String

List Class
===========
-addItem(listId): adds the item to the list
	Param:

-deleteItem(listId): deletes the item off the list
	Param:

-updateQuantity(itmQuant, qtyInt): If the user wants to update quantity, change the number of quantities of item 
	Param: itmQuant, int
               qtyInt, int

-clearCheckedOff():when the item is placed into list, mark the it as checked and take off list

-groupItemsByType(): sort the item by types