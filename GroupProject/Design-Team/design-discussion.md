# Team 5 Design Discussion

## Section 1: Individual Designs
Design 1: [370Spring18 Etanyuah](https://github.com/qc-se-spring2018/370Spring18Team5/blob/master/GroupProject/Design-Individual/370Spring18%20Etanyauh/design.PNG)

![Etanyuah](https://github.com/qc-se-spring2018/370Spring18Team5/blob/master/GroupProject/Design-Individual/370Spring18%20Etanyauh/design.PNG)

Pros:  
* Classes are structured and methods are defined.
* Followed protocol for Assignment 5.
* Class relationships are visible.

Cons:
* Some required class objects may be missing.
* Detailed lists may be missing.

Design 2: [370Spring18jrtapang](https://github.com/qc-se-spring2018/370Spring18Team5/blob/master/GroupProject/Design-Individual/370Spring18jrtapang/design.pdf)

![jrtapang](https://github.com/qc-se-spring2018/370Spring18Team5/blob/master/GroupProject/Design-Individual/370Spring18jrtapang/design.jpg)

Pros:
* Followed Assignment 5 protocol for design.
* Defined class association.

Cons:
* GroceryDB may not be needed for actual implementation of project.
* Some methods in design are not needed.
* Design implementation may be convoluted.
* Class associations are missing.

Design 3: [370Spring18sasad](https://github.com/qc-se-spring2018/370Spring18Team5/blob/master/GroupProject/Design-Individual/370Spring18sasad/design.pdf)

![sasad](https://github.com/qc-se-spring2018/370Spring18Team5/blob/master/GroupProject/Design-Individual/370Spring18sasad/design.jpg)

Pros:

* Assignment 5 protocol was followed.
* Class name and associations are defined.

Cons:

* Some methods and class objects may not be needed.
* No class associations.

Design 4: [370Spring18swli](https://github.com/qc-se-spring2018/370Spring18Team5/blob/master/GroupProject/Design-Individual/370Spring18swli/design.pdf)

![swli](https://github.com/qc-se-spring2018/370Spring18Team5/blob/master/GroupProject/Design-Individual/370Spring18swli/design.jpg)

Pros:

* Detailed class objects and functions.
* Class associations are visible.
* Protocol for Assignment 5 followed.

Cons:

* Some object and/or fucntions may not be needed.

Design 5: [370Spring18tchu](https://github.com/qc-se-spring2018/370Spring18Team5/blob/master/GroupProject/Design-Individual/370Spring18tchu/design.pdf)

![tchu](https://github.com/qc-se-spring2018/370Spring18Team5/blob/master/GroupProject/Design-Individual/370Spring18tchu/design.jpg)

Pros:

* Clear definition of classes.
* Class associations are visible.
* Assignment 5 protocol followed.

Cons:
* Design may be too simple.
* Additional methods and objects may be needed.

Design 6: [370Spring18tjesus](https://github.com/qc-se-spring2018/370Spring18Team5/blob/master/GroupProject/Design-Individual/370Spring18tjesus/design.pdf)

![tjesus](https://github.com/qc-se-spring2018/370Spring18Team5/blob/master/GroupProject/Design-Individual/370Spring18tjesus/design.jpeg)

Pros:
* Has three important classes: List, Item, ManageList(User).
* Has some of the important methods for the classes.

Cons:
* Associations not defined.
* Should have a different class for Item Type.
* Not all attributes have a type defined.
* Missing some required methods and attributes.

## Section 2: Team Design

![Team design JPEG](https://github.com/qc-se-spring2018/370Spring18Team5/blob/master/GroupProject/Design-Team/Grocery%20List%201.1.jpeg)

Design-Team | Design 1 | Design 2 | Design 3 | Design 4 | Design 5 | Design 6
:-- | :--: | :--: | :--: | :--: | :--: | :--:
class User | [ ] | [ ] | [ ] | [ ] | [ ] | [x] **Note:** class name: ManageList
username | [ ] | [ ] | [ ] | [ ] | [ ] | [ ]
address | [ ] | [ ] | [ ] | [ ] | [ ] | [ ]
accountBalance | [ ] | [ ] | [ ] | [ ] | [ ] | [ ]
arrayList<list> | [ ] | [ ] | [ ] | [ ] | [ ] | [ ]
updateProfile() | [ ] | [ ] | [ ] | [ ] | [ ] | [ ]
addNewList() | [ ] | [ ] | [ ] | [x] | [ ] | [ ]
deleteList() | [ ] | [ ] | [ ] | [x] | [ ] | [x] **Note:** method name: createList()
renameList() | [ ] | [ ] | [ ] | [x] | [ ] | [x]
selectList() | [ ] | [ ] | [ ] | [x] | [ ] | [x]

Design-Team | Design 1 | Design 2 | Design 3 | Design 4 | Design 5 | Design 6
:-- | :--: | :--: | :--: | :--: | :--: | :--:
class List | [ ] | [ ] | [ ] | [x] | [ ] | [x]
arrayList<item> | [ ] | [ ] | [ ] | [ ] | [ ] | [ ]
changeQuantity() | [ ] | [ ] | [ ] | [x] | [ ] | [x] **Note:** method name: updateQuantity
saveList() | [ ] | [ ] | [ ] | [ ] | [ ] | [ ]
modifyList() | [ ] | [ ] | [ ] | [ ] | [ ] | [ ]
clearList() | [ ] | [ ] | [ ] | [ ] | [ ] | [ ]
showList() | [ ] | [ ] | [ ] | [ ] | [ ] | [ ]
addItem() | [ ] | [ ] | [ ] | [x] | [ ] | [x] **Note:** part of class ItemInventory
deleteItem() | [ ] | [ ] | [ ] | [x] | [ ] | [x] **Note:** part of class ItemInventory
search() | [ ] | [ ] | [ ] | [x] | [ ] | [ ]
checkOff() | [ ] | [ ] | [ ] | [x] | [ ] | [ ]
clearCheckOff() | [ ] | [ ] | [ ] | [x] | [ ] | [ ]

Design-Team | Design 1 | Design 2 | Design 3 | Design 4 | Design 5 | Design 6
:-- | :--: | :--: | :--: | :--: | :--: | :--:
class Item | [ ] | [ ] | [ ] | [x] | [ ] | [x] **Note:** class name: ItemInventory
itemName | [ ] | [ ] | [ ] | [x] | [ ] | [x]
itemID | [ ] | [ ] | [ ] | [x] | [ ] | [x]
Quantity | [ ] | [ ] | [ ] | [x] | [ ] | [x]
checkOff | [ ] | [ ] | [ ] | [x] | [ ] | [ ]
addItem() | [ ] | [ ] | [ ] | [x] | [ ] | [x]
deleteItem() | [ ] | [ ] | [ ] | [ ] | [ ] | [x]
searchItem() | [ ] | [ ] | [ ] | [ ] | [ ] | [ ]

Design-Team | Design 1 | Design 2 | Design 3 | Design 4 | Design 5 | Design 6
:-- | :--: | :--: | :--: | :--: | :--: | :--:
class ItemType | [ ] | [ ] | [ ] | [x] | [ ] | [ ]
typeName | [ ] | [ ] | [ ] | [x] | [ ] | [x] **Note:** part of class List and ItemInventory; attribute name: ItemType
typeID  | [ ] | [ ] | [ ] | [x] | [ ] | [ ]
addnewType() | [ ] | [ ] | [ ] | [ ] | [ ] | [ ]

## Section 3: Summary
As a group, we were able to communicate which individual design was appropriate for this assignment and chose "the best" one.  We looked into the different UML diagram submissions and pointed out some of the flaws and redundancies in each individual submission. Taking in to account the different perpectives of our members on how the grocery app should look like, we checked if the submissions met this assignment's requirements. The team decided to go with the pros and cons approach and made notes of them in this md file (written below each submission).  

Based on the different designs, the group agreed to use tchu's design foundation. Though it still lacked some objects and required editing, we worked together to achieve the final design which is embedded in this md file with a copy placed in the team's group folder.  
