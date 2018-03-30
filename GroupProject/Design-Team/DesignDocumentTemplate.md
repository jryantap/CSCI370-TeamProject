# Design Document

*This is the template for your design document. The parts in italics are concise explanations of what should go in the corresponding sections and should not appear in the final document.*

**Author**: **Jherico-Ryan Tapang and Sayem Asad**

## 1 Design Considerations

*The subsections below describe the issues that need to be addressed or resolved prior to or while completing the design, as well as issues that may influence the design process.*

### 1.1 Assumptions

- We assume that the app is published on Google Play so the user can download it.  Or, the user can install the .apk on an android device that have at least 100MB of space with at least API version of 21 (Lollipop).   

### 1.2 Constraints

- The app data base is local.  Any info the user enters in the app is saved locally.  When the user deletes the app, his or her info is also deleted.
- User data is cannot be transferred to other mobile devices. As per first contraint.

### 1.3 System Environment

- The application is going to run on Android with a required system version (API) of 21: Lollipop.

## 2 Architectural Design

*The architecture provides the high-level design view of a system and provides a basis for more detailed design work. These subsections describe the top-level components of the system you are building and their relationships.*

### 2.1 Component Diagram

*This section should provide and describe a diagram that shows the various components and how they are connected. This diagram shows the logical/functional components of the system, where each component represents a cluster of related functionality. In the case of simple systems, where there is a single component, this diagram may be unnecessary; in these cases, simply state so and concisely state why.*

### 2.2 Deployment Diagram

- The app is simple and will run on Android devices.  It will use a local database - a much needed component in this project.  

## 3 Low-Level Design

*Describe the low-level design for each of the system components identified in the previous section. For each component, you should provide details in the following UML diagrams to show its internal structure.*

### 3.1 Class Diagram

![Thomas Chu Diagram]<img src ="https://github.com/qc-se-spring2018/370Spring18Team5/blob/master/GroupProject/Design-Team/Grocery%20List%201.1.jpeg" width="500" height="500">

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


<img src="https://github.com/qc-se-spring2018/370Spring18Team5/blob/master/GroupProject/Design-Team/GroceryApp_1.PNG" width="500" height="500" >
