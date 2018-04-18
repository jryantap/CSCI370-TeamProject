# Design Document

**Author**: **Jherico-Ryan Tapang**

## 1 Design Considerations

*The subsections below describe the issues that need to be addressed or resolved prior to or while completing the design, as well as issues that may influence the design process.*

### 1.1 Assumptions

- We assume that the app is published on Google Play so the user can download it.  Or, the user can install the .apk directly on an android device that have at least 100MB of space with at least API version of 21 (Lollipop).   

### 1.2 Constraints

- The app data base is local.  Any info the user enters in the app is saved locally.  When the user deletes the app, his or her Grocerly List(s) is also deleted.
- User data cannot be transferred to other mobile devices. As per first contraint.

### 1.3 System Environment

- The application is going to run on Android with a required system version (API) of 21: Lollipop.

## 2 Architectural Design

*The architecture provides the high-level design view of a system and provides a basis for more detailed design work. These subsections describe the top-level components of the system you are building and their relationships.*

### 2.1 Component Diagram

- Since this is a static app, there is no need for a back end to store user data.  It just uses regular components included in the android development environment.  

### 2.2 Deployment Diagram

- The app is simple and will run on Android devices.  It will use a local database - a much needed component in this project.  

## 3 Low-Level Design

*Describe the low-level design for each of the system components identified in the previous section. For each component, you should provide details in the following UML diagrams to show its internal structure.*

### 3.1 Class Diagram
![alt text](https://i.imgur.com/qrFEjjv.jpg)

### 3.2 Other Diagrams

*<u>Optionally</u>, you can decide to describe some dynamic aspects of your system using one or more behavioral diagrams, such as sequence and state diagrams.*

## 4 User Interface Design
*Preliminary User Interface of the system.  (Update 1 - mockups)*

1. When the user launches the app on their android device, the user is taken to the log in menu (stil debatable if the team is going to implement a log in menu).  

2. With the correct user info, the *Grocery List* launches.  This is where the user can go to the *Weekly List or Monthly list* menu. In this menu, the user can delete a list or add list using the corresponding buttons. 

3. In the *Weekly list menu*, the user is able to click and select which item needs updating.  In this menu, the user can add a new list weekly list item or if the using clicks on the check box, the user has the option to delete an item on my weekly list.

4. **From** the Weekly List menu, if the user selects on of the item, the user is taken to a more detailed menu about the item on the list.  In this *Detailed List Menu*, up on item quantity, add item or delete item buttons are available to be used whichever the user needs.

5.  When the user closes the app, it should log the user off automatically to make the user's list more private and accessible to the user.  

**NOTE:**  If the user clicks on the *Monthly List* button, same interface will be available and UI will look like from above design. 
![alt text](https://i.imgur.com/88sRaem.png)

## Update 2

1.  The team decided use this app, under the GroceryList folder project, because it more stable and has the features needed for the project.

### Screenshots:
![alt text](https://i.imgur.com/sqUJBBh.png)
![alt text](https://i.imgur.com/wioDi9B.png)
![alt text](https://i.imgur.com/sDg3yis.png)
![alt text](https://i.imgur.com/pcoIGxd.png)
![alt text](https://i.imgur.com/4OsPWLH.png)
![alt text](https://i.imgur.com/N4rpPA8.png)
![alt text](https://i.imgur.com/TFvIEeo.png)
![alt text](https://i.imgur.com/uAxS5yS.png)
![alt text](https://i.imgur.com/42A5J5b.png)
![alt text](https://i.imgur.com/zDNl1tX.png)
![alt text](https://i.imgur.com/QD3I4Kw.png)
![alt text](https://i.imgur.com/DxQfb4L.png)
![alt text](https://i.imgur.com/gHJD2Ia.png)

### Usage:




