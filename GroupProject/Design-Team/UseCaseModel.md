# Use Case Model

*This is the template for your use case model. The parts in italics are concise explanations of what should go in the corresponding sections and should not appear in the final document.*

**Author**: \<team5\>

## 1 Use Case Diagram

![userCaseDiagram](https://github.com/qc-se-spring2018/370Spring18Team5/blob/master/GroupProject/Design-Team/userCase.pdf)

## 2 Use Case Descriptions

*For each use case in the use case diagram, this section should contain a description, with the following elements:*

- *Requirements: High-level description of what the use case must allow the user to do.*
- *Pre-conditions: Conditions that must be true before the use case is run.*
- *Post-conditions Conditions that must be true once the use case is run.*
- *Scenarios: Sequence of events that characterize the use case. This part may include multiple scenarios, for normal, alternate, and exceptional event sequences. These scenarios may be expressed as a list of steps in natural language or as sequence diagrams.*

__Create List__ |
:-- | 
__Brief description:__|The Actor craete a new List|
__Actor:__|Grocery Manager|
__Preconditions:__|The actor must logs into the apps|
__Post-conditions:__|New List is create|
__Normal Course:__|
...1.The actor logs into apps
...2.The apps authenticates the actor
...3.The actor chooses to create a new list
...4.The actor is guided by the apps to enter the name of new list
...5.The apps acknowledges that list created
...6.The actor leaves the apps|

__Exception__|
Ex1 Apps determines the name of new list has been used
...1.inform user that the name has been used|
...2.return to Normal Course step 4|

Ex2 Actor logs off
...1.return to Normal Course step 1|

Ex3  The name user enter containing symbol
...1.inform user that there is no symbol in name of list
...2.return Normal Course step 4|



__Create List__ |
:-- | 
__Brief description:__| |
__Actor:__| |
__Preconditions:__| |
__Post-conditions:__|
__Normal:__|
__Alternate:__|
__Exception__|

