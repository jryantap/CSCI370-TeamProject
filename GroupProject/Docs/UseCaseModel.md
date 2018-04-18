
# Use Case Model

**Author**: \<Sai Wai Li\>

Version 2.0

Summary of Changes:

Version 2.0:
- Removed use cases associated with user login.
- Revised use cases to reflect app implementation changes. 

## 1 Use Case Diagram

![userCaseDiagram](https://github.com/qc-se-spring2018/370Spring18Team5/blob/master/GroupProject/Docs/Use%20Case.jpg)

## 2 Use Case Descriptions


<!-- 1 -->
<table>
	<thead>
		<tr>
			<th colspan="3"><b>Create List</b></th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td><b>Brief description:</b></td>
			<td>The Actor creates a new List</td>
		</tr>
		<tr>
			<td><b>Actor:</b></td>
			<td>User</td>
		</tr>
		<tr>
			<td><b>Pre-conditions:</b></td>
			<td>None</td>
		</tr>
		<tr>
			<td><b>Post-conditions:</b></td>
			<td>New List is created</td>
		</tr>
		<tr>
			<td><b>Normal Course:</b></td>
			<td>
				<ol>
					<li>The user opens the apps</li>
					<li>The user chooses "+" button on the top right corner to create new list</li>
					<li>The user enters the name of the new list</li>
					<li>The user clicks the check mark.
					<li>The app acknowledges the list is created</li>
					<li>The app redirects the user to the main page</li>
				</ol>
			</td>
		</tr>
		<tr>
			<td><b>Exception</b></td>
			<td>Ex1: App determines if the name of the new list has been used
				<ol>
					<li>Inform user that the name has been used</li>
					<li>Return to Normal Course Step 3</li>
				</ol>
				Ex2: User closes app
				<ol>
					<li>Return to Normal Course Step 1</li>
				</ol>
				Ex3: The name the user enters contains a symbol<br>
				<ol>
					<li>Informs user that there are no symbols allowed in the list name</li>
					<li>Return to Normal Course Step 3</li>
				</ol>
				Ex4: Fail to create list
				<ol>
					<li>Inform user that an error has occurred</li>
					<li>Return to Normal Course Step 2</li>
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
			<td>User</td>
		</tr>
		<tr>
			<td><b>Pre-conditions:</b></td>
			<td>
				<ol>
					<li>The Actor must open the app</li>
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
					<li>The user opens the app</li>
					<li>The user chooses "Delete List"</li>
					<li>The user selects one or more lists</li>
					<li>The app prompts user to comfirm</li>
					<li>The app acknowledges that the list has been deleted</li>
					<li>The app redirects user to the main page</li>
				</ol>
			</td>
		</tr>
		<tr>
			<td><b>Alternate Courses</b></td>
			<td>
				AC1: Delete List inside the List
				<ol>
					<li>The user opens the app</li>
					<li>The user opens a list</li>
					<li>The user chooses "Delete List"</li>
					<li>The app prompts user to comfirm</li>
					<li>The app acknowledges that the list has been deleted</li>
					<li>The apps redirects user to the main page</li>
				</ol>
			</td>
		</tr>
		<tr>
			<td><b>Exception</b></td>
			<td>Ex1: User doesn't select any lists
				<ol>
					<li>The app redirects user to main page</li>
				</ol>
				Ex2: User closes app
				<ol>
					<li>Return to Normal Course Step 1</li>
				</ol>
				Ex3: User fails to delete list
				<ol>
					<li>Inform user that an error has occurred</li>
					<li>Return to Normal Course Step 3</li>
				</ol>
			</td>
		</tr>
	</tbody>
</table>


<!-- 4 -->

<table>
	<thead>
		<tr>
			<th colspan="3"><b>Add Item</b></th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td><b>Brief description:</b></td>
			<td>The user adds an item to the list</td>
		</tr>
		<tr>
			<td><b>Actor:</b></td>
			<td>User</td>
		</tr>
		<tr>
			<td><b>Pre-conditions:</b></td>
			<td>
				<ol>
					<li>The user must open the app</li>
					<li>The list must be created</li>
				</ol>
			</td>
		</tr>
		<tr>
			<td><b>Post-conditions:</b></td>
			<td>New item is added to the list</td>
		</tr>
		<tr>
			<td><b>Normal Course:</b></td>
			<td>
				<ol>
					<li>The user opens the app</li>
					<li>The user selects a list</li>
					<li>The user searches item by name or by item type</li>
					<li>The user selects the item</li>
					<li>The app prompts user for quantity</li>
					<li>The app acknowledges that the item is added</li>
					<li>The app redirects user to the search page</li>
				</ol>
			</td>
		</tr>
		<tr>
			<td><b>Exception</b></td>
			<td>
				Ex1: User closes app
				<ol>
					<li>Return to Normal Course step 1</li>
				</ol>
				Ex2: Item not found
				<ol>
					<li>See "New Item" Use Case</li>
				</ol>
				Ex3: User fails to add item
				<ol>
					<li>Inform user that an error has occurred</li>
					<li>Return to Normal Course Step 3</li>
				</ol>
			</td>
		</tr>
	</tbody>
</table>

<!-- 5 -->

<table>
	<thead>
		<tr>
			<th colspan="3"><b>Delete item</b></th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td><b>Brief description:</b></td>
			<td>The user deletes item from the List</td>
		</tr>
		<tr>
			<td><b>Actor:</b></td>
			<td>User</td>
		</tr>
		<tr>
			<td><b>Pre-conditions:</b></td>
			<td>
				<ol>
					<li>The user must open the app</li>
					<li>The List must be created</li>
					<li>The item is added to the list</li>
				</ol>
			</td>
		</tr>
		<tr>
			<td><b>Post-conditions:</b></td>
			<td>New item is deleted from the list</td>
		</tr>
		<tr>
			<td><b>Normal Course:</b></td>
			<td>
				<ol>
					<li>The user opens the app</li>
					<li>The user selects a list</li>
					<li>The user chooses "Delete Item"</li>
					<li>The user selects one or more item</li>
					<li>The app prompts user to comfirm</li>
					<li>The app acknowledges that the item(s) has been deleted</li>
					<li>The app redirects user to the item list page</li>
				</ol>
			</td>
		</tr>
		<tr>
			<td><b>Exception</b></td>
			<td>
				Ex1: User closes app
				<ol>
					<li>Return to Normal Course Step 1</li>
				</ol>
				Ex3: Fail to delete item
				<ol>
					<li>Inform user that an error has occurred</li>
					<li>Return to Normal Course Step 3</li>
				</ol>
			</td>
		</tr>
	</tbody>
</table>
<!-- 6 -->
<table>
	<thead>
		<tr>
			<th colspan="3"><b>Change Quantity</b></th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td><b>Brief description:</b></td>
			<td>The user changes the quantity of an item in the List</td>
		</tr>
		<tr>
			<td><b>Actor:</b></td>
			<td>User</td>
		</tr>
		<tr>
			<td><b>Pre-conditions:</b></td>
			<td>
				<ol>
					<li>The user must open the app</li>
					<li>The List must be created</li>
					<li>The item is added to the list</li>
				</ol>
			</td>
		</tr>
		<tr>
			<td><b>Post-conditions:</b></td>
			<td>The quantity of the item is changed</td>
		</tr>
		<tr>
			<td><b>Normal Course:</b></td>
			<td>
				<ol>
					<li>The user opens the app</li>
					<li>The user selects a list</li>
					<li>The user selects one item</li>
					<li>The user changes the quantity</li>
					<li>The app acknowledges that the quantity is changed</li>
					<li>The app redirects user to the item list page</li>
				</ol>
			</td>
		</tr>
		<tr>
			<td><b>Exception</b></td>
			<td>
				Ex1: User closes the app
				<ol>
					<li>Return to Normal Course Step 1</li>
				</ol>
				Ex2: User doesn't enter an amount or valid input
				<ol>
					<li>Inform user to enter a valid number</li>
					<li>Return to Normal Course Step 4</li>
				</ol>
				Ex4: Fail to change quantity of item
				<ol>
					<li>Inform user that an error has occurred</li>
					<li>Return to Normal Course Step 3</li>
				</ol>
			</td>
		</tr>
	</tbody>
</table>
<!-- 9 -->
<table>
	<thead>
		<tr>
			<th colspan="3"><b>Check-Off </b></th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td><b>Brief description:</b></td>
			<td>The user checks off item or removes check-off mark from item</td>
		</tr>
		<tr>
			<td><b>Actor:</b></td>
			<td>User</td>
		</tr>
		<tr>
			<td><b>Pre-conditions:</b></td>
			<td>
				<ol>
					<li>The user must open the app</li>
					<li>There is at least one item in the list</li>
				</ol>
			</td>
		</tr>
		<tr>
			<td><b>Post-conditions:</b></td>
			<td>Item has a check-off mark or check-off mark has been removed</td>
		</tr>
		<tr>
			<td><b>Normal Course:</b></td>
			<td>
				<ol>
					<li>The user opens the app</li>
					<li>The user selects a list</li>
					<li>The user checks off item or removes check-off mark from item</li>
				</ol>
			</td>
		</tr>
		<tr>
			<td><b>Exception</b></td>
			<td>
				Ex1: User closes app
				<ol>
					<li>Return to Normal Course Step 1</li>
				</ol>
				Ex2: Cannot check-off or remove check-off mark
				<ol>
					<li>Inform user that an error has occurred</li>
					<li>Return to Normal Course Step 2</li>
				</ol>
			</td>
		</tr>
	</tbody>
</table>
<!-- 10 -->
<table>
	<thead>
		<tr>
			<th colspan="3"><b>Clear Check-Off Mark</b></th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td><b>Brief description:</b></td>
			<td>The user clears check-off marks from all items</td>
		</tr>
		<tr>
			<td><b>Actor:</b></td>
			<td>User</td>
		</tr>
		<tr>
			<td><b>Pre-conditions:</b></td>
			<td>
				<ol>
					<li>The user must open the app</li>
					<li>There is at least one item in the list and it has been checked off</li>
				</ol>
			</td>
		</tr>
		<tr>
			<td><b>Post-conditions:</b></td>
			<td>Item(s) will no longer have check-off marks </td>
		</tr>
		<tr>
			<td><b>Normal Course:</b></td>
			<td>
				<ol>
					<li>The user opens the app</li>
					<li>The user selects a list</li>
					<li>The user chooses "Clear Check-Off Marks"</li>
					<li>The app acknowledges check-off marks have been cleared</li>
					<li>The app redirects user to the item list page</li>
				</ol>
			</td>
		</tr>
		<tr>
			<td><b>Exception</b></td>
			<td>
				Ex1: User closes app
				<ol>
					<li>Return to Normal Course Step 1</li>
				</ol>
				Ex2: Cannot remove check-off mark
				<ol>
					<li>Inform user that an error has occurred</li>
					<li>Return to Normal Course Step 2</li>
				</ol>
			</td>
		</tr>
	</tbody>
</table>
