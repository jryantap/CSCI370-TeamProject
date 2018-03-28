# Use Case Model

*This is the template for your use case model. The parts in italics are concise explanations of what should go in the corresponding sections and should not appear in the final document.*

**Author**: \<team5\>

## 1 Use Case Diagram

![userCaseDiagram](https://github.com/qc-se-spring2018/370Spring18Team5/blob/master/GroupProject/Design-Team/Use%20Case.jpg)

## 2 Use Case Descriptions

*For each use case in the use case diagram, this section should contain a description, with the following elements:*

- *Requirements: High-level description of what the use case must allow the user to do.*
- *Pre-conditions: Conditions that must be true before the use case is run.*
- *Post-conditions Conditions that must be true once the use case is run.*
- *Scenarios: Sequence of events that characterize the use case. This part may include multiple scenarios, for normal, alternate, and exceptional event sequences. These scenarios may be expressed as a list of steps in natural language or as sequence diagrams.*


<table>
	<thead>
		<tr>
			<th><b>Create List</b></th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td><b>Brief description:</b></td>
			<td>The Actor craete a new List</td>
		</tr>
		<tr>
			<td><b>Actor:</b></td>
			<td>Grocery Manager</td>
		</tr>
		<tr>
			<td><b>Pre-conditions:</b></td>
			<td>The actor must logs into the apps</td>
		</tr>
		<tr>
			<td><b>Post-conditions:</b></td>
			<td>New List is create</td>
		</tr>
		<tr>
			<td><b>Normal Course:</b></td>
			<td>
				<ol>
					<li>The actor logs into apps</li>
					<li>The apps authenticates the actor</li>
					<li>The actor chooses to create a new list</li>
					<li>The actor is guided by the apps to enter the name of new list</li>
					<li>The apps acknowledges that list created</li>
					<li>The actor leaves the apps|</li>
				</ol>
			</td>
		</tr>
		<tr>
			<td><b>Exception</b></td>
			<td>Ex1 Apps determines the name of new list has been used
				<ol>
					<li>inform user that the name has been used</li>
					<li>return to Normal Course step 4</li>
				</ol>
				Ex2 Actor logs off
				<ol>
					<li>return to Normal Course step 1</li>
				</ol>
				Ex3  The name user enter containing symbol<br>
				<ol>
					<li>inform user that there is no symbol in name of list</li>
					<li>return Normal Course step 4</li>
				</ol>
			</td>
		</tr>
	</tbody>
</table>




