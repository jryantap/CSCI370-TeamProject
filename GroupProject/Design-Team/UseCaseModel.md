# Use Case Model

**Author**: \<Team5\>

## 1 Use Case Diagram

![userCaseDiagram](https://github.com/qc-se-spring2018/370Spring18Team5/blob/master/GroupProject/Design-Team/Use%20Case.jpg)

## 2 Use Case Descriptions

*For each use case in the use case diagram, this section should contain a description, with the following elements:*

- *Requirements: High-level description of what the use case must allow the user to do.*
- *Pre-conditions: Conditions that must be true before the use case is run.*
- *Post-conditions Conditions that must be true once the use case is run.*
- *Scenarios: Sequence of events that characterize the use case. This part may include multiple scenarios, for normal, alternate, and exceptional event sequences. These scenarios may be expressed as a list of steps in natural language or as sequence diagrams.*

<!-- 1 -->
<table>
	<thead>
		<tr>
			<th colspan="3"><b>Creates List</b></th>
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
					<li>The Actor logs into apps</li>
					<li>The app authenticates the Actor</li>
					<li>The Actor chooses to create a new list</li>
					<li>The Actor enters the name of the new list</li>
					<li>The app acknowledges the list is created</li>
					<li>The app redirects the user to the main page</li>
				</ol>
			</td>
		</tr>
		<tr>
			<td><b>Exception</b></td>
			<td>Ex1 App determines if the name of the new list has been used
				<ol>
					<li>inform Actor that the name has been used</li>
					<li>return to Normal Course step 4</li>
				</ol>
				Ex2 Actor logs off
				<ol>
					<li>return to Normal Course step 1</li>
				</ol>
				Ex3  The name the Actor enters contains a symbol<br>
				<ol>
					<li>informs Actor that there are no symbols in name of list</li>
					<li>return Normal Course step 4</li>
				</ol>
			</td>
		</tr>
	</tbody>
</table>
<!-- 2 -->
<table>
	<thead>
		<tr>
			<th colspan="3"><b>Delete List</b></th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td><b>Brief description:</b></td>
			<td>The Actor deletes a List</td>
		</tr>
		<tr>
			<td><b>Actor:</b></td>
			<td>Grocery Manager</td>
		</tr>
		<tr>
			<td><b>Pre-conditions:</b></td>
			<td>
				<ol>
					<li>The Actor must log into the app</li>
					<li>The List must be created</li>
				</ol>
			</td>
		</tr>
		<tr>
			<td><b>Post-conditions:</b></td>
			<td>List is deleted</td>
		</tr>
		<tr>
			<td><b>Normal Course:</b></td>
			<td>
				<ol>
					<li>The Actor logs into app</li>
					<li>The app authenticates the actor</li>
					<li>The Actor chooses to delete a list</li>
					<li>The Actor selects one or more lists</li>
					<li>The app prompts actor to comfirm</li>
					<li>The app acknowledges that the list is deleted</li>
					<li>The apps redirects user to the main page</li>
				</ol>
			</td>
		</tr>
		<tr>
			<td><b>Alternate Courses</b></td>
			<td>
				AC1 delete List inside the List
				<ol>
					<li>The Actor logs into app</li>
					<li>The app authenticates the Actor</li>
					<li>The Actor gets into a list</li>
					<li>The Actor chooses to delete the list</li>
					<li>The app prompts user to comfirm</li>
					<li>The app acknowledges that the list deleted</li>
					<li>The actor leaves the app</li>
				</ol>
			</td>
		</tr>
		<tr>
			<td><b>Exception</b></td>
			<td>Ex1 Actor doesn't select any lists
				<ol>
					<li>The app redirects user to main page</li>
				</ol>
				Ex2 Actor logs off
				<ol>
					<li>return to Normal Course step 1</li>
				</ol>
			</td>
		</tr>
	</tbody>
</table>

<!-- 3 -->

<table>
	<thead>
		<tr>
			<th colspan="3"><b>Rename List</b></th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td><b>Brief description:</b></td>
			<td>The Actor renames a List</td>
		</tr>
		<tr>
			<td><b>Actor:</b></td>
			<td>Grocery Manager</td>
		</tr>
		<tr>
			<td><b>Pre-conditions:</b></td>
			<td>
				<ol>
					<li>The user must log into the app</li>
					<li>The List must be created</li>
				</ol>
			</td>
		</tr>
		<tr>
			<td><b>Post-conditions:</b></td>
			<td>List is renamed</td>
		</tr>
		<tr>
			<td><b>Normal Course:</b></td>
			<td>
				<ol>
				<ol>
					<li>The user logs into app</li>
					<li>The app authenticates the actor</li>
					<li>The user selecs a list</li>
					<li>The user selects the name of the list and renames it</li>
					<li>The app acknowledges that the list is deleted</li>
					<li>The app redirects user to main page</li>
				</ol>
				</ol>
			</td>
		</tr>

