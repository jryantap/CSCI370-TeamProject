
# Use Case Model

**Author**: \<Sai Wai Li\>

## 1 Use Case Diagram

![userCaseDiagram](https://github.com/qc-se-spring2018/370Spring18Team5/blob/master/GroupProject/Design-Team/Use%20Case.jpg)

## 2 Use Case Descriptions


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
			<td>The Actor creates a new List</td>
		</tr>
		<tr>
			<td><b>Actor:</b></td>
			<td>User</td>
		</tr>
		<tr>
			<td><b>Pre-conditions:</b></td>
			<td>The Actor must log into the app</td>
		</tr>
		<tr>
			<td><b>Post-conditions:</b></td>
			<td>New List is created</td>
		</tr>
		<tr>
			<td><b>Normal Course:</b></td>
			<td>
				<ol>
					<li>The user logs into app</li>
					<li>The app authenticates the user</li>
					<li>The user chooses "Create New List"</li>
					<li>The user enters the name of the new list</li>
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
					<li>Return to Normal Course Step 4</li>
				</ol>
				Ex2: User logs off
				<ol>
					<li>Return to Normal Course Step 1</li>
				</ol>
				Ex3:  The name the user enters contains a symbol<br>
				<ol>
					<li>Informs user that there are no symbols in name of list</li>
					<li>Return to Normal Course Step 4</li>
				</ol>
				Ex4: App fails to authenticate the user
				<ol>
					<li>Inform user and redirect to log in page</li>
				</ol>
				Ex5: Fail to create list
				<ol>
					<li>Inform user that an error has occurred</li>
					<li>Return to Normal Course Step 3</li>
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
					<li>The user logs into app</li>
					<li>The app authenticates the user</li>
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
					<li>The user logs into app</li>
					<li>The app authenticates the user</li>
					<li>The user gets into a list</li>
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
				Ex2: User logs off
				<ol>
					<li>Return to Normal Course Step 1</li>
				</ol>
				Ex3: App fails to authenticate the user
				<ol>
					<li>Inform user and redirect to log in page</li>
				</ol>
				Ex4: Fail to delete list
				<ol>
					<li>Inform user that an error has occurred</li>
					<li>Return to Normal Course Step 3</li>
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
			<td>User</td>
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
					<li>The user logs into app</li>
					<li>The app authenticates the user</li>
					<li>The user selects a list</li>
					<li>The user selects the name of the list and renames it</li>
					<li>The app acknowledges that the list has been renamed</li>
					<li>The app redirects user to main page</li>
				</ol>
			</td>
		</tr>
		<tr>
			<td><b>Exception</b></td>
			<td>Ex1: App determines the new name of the list has been used
				<ol>
					<li>Inform user that the name has been used</li>
					<li>Return to Normal Course step 4</li>
				</ol>
				Ex2: User logs off
				<ol>
					<li>Return to Normal Course Step 1</li>
				</ol>
				Ex3: The name user enters contains symbols<br>
				<ol>
					<li>Inform user that symbols are not allowed</li>
					<li>Return to Normal Course step 4</li>
				</ol>
				Ex4: App fails to authenticate the user
				<ol>
					<li>Inform user and redirect to log in page</li>
				</ol>
				Ex5: Fail to rename list
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
					<li>The user must log into the app</li>
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
					<li>The user logs into app</li>
					<li>The app authenticates the user</li>
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
				Ex1: User logs off
				<ol>
					<li>Return to Normal Course step 1</li>
				</ol>
				Ex2: App fails to authenticate the user
				<ol>
					<li>Inform user and redirect to log in page</li>
				</ol>
				Ex3: Item not found
				<ol>
					<li>See "New Item" Use Case</li>
				</ol>
				Ex4: Fail to add item
				<ol>
					<li>Inform user that an error has occurred</li>
					<li>Return to Normal Course Step 4</li>
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
					<li>The user must log into the app</li>
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
					<li>The user logs into app</li>
					<li>The app authenticates the user</li>
					<li>The user selects a list</li>
					<li>The user chooses "Delete Item"</li>
					<li>The user selects one or more item</li>
					<li>The app prompts user to comfirm</li>
					<li>The app acknowledges that the item has been deleted</li>
					<li>The app redirects user to the item list page</li>
				</ol>
			</td>
		</tr>
		<tr>
			<td><b>Exception</b></td>
			<td>
				Ex1: User logs off
				<ol>
					<li>Return to Normal Course Step 1</li>
				</ol>
				Ex2: App fails to authenticate the user
				<ol>
					<li>Inform user and redirect to log in page</li>
				</ol>
				Ex3: Fail to delete item
				<ol>
					<li>Inform user that an error has occurred</li>
					<li>Return to Normal Course Step 4</li>
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
					<li>The user must log into the app</li>
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
					<li>The user logs into app</li>
					<li>The app authenticates the user</li>
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
				Ex1: User logs off
				<ol>
					<li>Return to Normal Course Step 1</li>
				</ol>
				Ex2: App fails to authenticate the user
				<ol>
					<li>Inform user and redirect to log in page</li>
				</ol>
				Ex3: User doesn't enter any amount
				<ol>
					<li>Inform user to enter a valid number</li>
					<li>Return to Normal Course Step 5</li>
				</ol>
				Ex4: Fail to change quantity of item
				<ol>
					<li>Inform user that an error has occurred</li>
					<li>Return to Normal Course Step 4</li>
				</ol>
			</td>
		</tr>
	</tbody>
</table>
<!-- 7 -->
<table>
	<thead>
		<tr>
			<th colspan="3"><b>Clear List</b></th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td><b>Brief description:</b></td>
			<td>The user removes all items in the List</td>
		</tr>
		<tr>
			<td><b>Actor:</b></td>
			<td>User</td>
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
			<td>The list is empty</td>
		</tr>
		<tr>
			<td><b>Normal Course:</b></td>
			<td>
				<ol>
					<li>The user logs into app</li>
					<li>The app authenticates the user</li>
					<li>The user selects a list</li>
					<li>The user chooses "Clear List"</li>
					<li>The app prompts user to comfirm</li>
					<li>The app acknowledges the list has been cleared</li>
					<li>The app redirects user to the item list page</li>
				</ol>
			</td>
		</tr>
		<tr>
			<td><b>Exception</b></td>
			<td>
				Ex1: User logs off
				<ol>
					<li>Return to Normal Course Step 1</li>
				</ol>
				Ex2: App fails to authenticate the user
				<ol>
					<li>Inform user and redirect to log in page</li>
				</ol>
				Ex3: Fail to clear list
				<ol>
					<li>Inform user that an error has occurred</li>
					<li>Return to Normal Course Step 4</li>
				</ol>
			</td>
		</tr>
	</tbody>
</table>
<!-- 8 -->
<table>
	<thead>
		<tr>
			<th colspan="3"><b>Modify List</b></th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td><b>Brief description:</b></td>
			<td>The user changes the order of the list</td>
		</tr>
		<tr>
			<td><b>Actor:</b></td>
			<td>User</td>
		</tr>
		<tr>
			<td><b>Pre-conditions:</b></td>
			<td>
				<ol>
					<li>The user must log into the app</li>
					<li>There must be at least two lists</li>
				</ol>
			</td>
		</tr>
		<tr>
			<td><b>Post-conditions:</b></td>
			<td>Order of list changes</td>
		</tr>
		<tr>
			<td><b>Normal Course:</b></td>
			<td>
				<ol>
					<li>The user logs into app</li>
					<li>The app authenticates the user</li>
					<li>The user choose "Modify List"</li>
					<li>The user selects two lists</li>
					<li>The app prompts user to comfirm</li>
					<li>The app acknowledges order of list has been changed</li>
					<li>The app redirects user to the list page</li>
				</ol>
			</td>
		</tr>
		<tr>
			<td><b>Exception</b></td>
			<td>
				Ex1: User logs off
				<ol>
					<li>Return to Normal Course Step 1</li>
				</ol>
				Ex2: App fails to authenticate the user
				<ol>
					<li>Inform user and redirect to log in page</li>
				</ol>
				Ex3: Lists do not swap
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
			<th colspan="3"><b>Check Off </b></th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td><b>Brief description:</b></td>
			<td>The user checks off item or removes check off mark from item</td>
		</tr>
		<tr>
			<td><b>Actor:</b></td>
			<td>User</td>
		</tr>
		<tr>
			<td><b>Pre-conditions:</b></td>
			<td>
				<ol>
					<li>The user must log into the app</li>
					<li>There is at least one item in the list</li>
				</ol>
			</td>
		</tr>
		<tr>
			<td><b>Post-conditions:</b></td>
			<td>Item has a check off mark or check off mark has been removed</td>
		</tr>
		<tr>
			<td><b>Normal Course:</b></td>
			<td>
				<ol>
					<li>The user logs into app</li>
					<li>The app authenticates the user</li>
					<li>The user selects lists</li>
					<li>The user checks off item or removes check off mark from item</li>
					<li>The user selects item</li>
				</ol>
			</td>
		</tr>
		<tr>
			<td><b>Exception</b></td>
			<td>
				Ex1: User logs off
				<ol>
					<li>Return to Normal Course Step 1</li>
				</ol>
				Ex2: App fails to authenticate the user
				<ol>
					<li>Inform user and redirect to log in page</li>
				</ol>
				Ex3: Cannot check off or remove check off mark
				<ol>
					<li>Inform user that an error has occurred</li>
					<li>Return to Normal Course Step 3</li>
				</ol>
			</td>
		</tr>
	</tbody>
</table>
<!-- 10 -->
<table>
	<thead>
		<tr>
			<th colspan="3"><b>Clear Check Off Mark</b></th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td><b>Brief description:</b></td>
			<td>The user clears check off marks from all items</td>
		</tr>
		<tr>
			<td><b>Actor:</b></td>
			<td>User</td>
		</tr>
		<tr>
			<td><b>Pre-conditions:</b></td>
			<td>
				<ol>
					<li>The user must log into the app</li>
					<li>There is at least one item in the list and it has been checked off</li>
				</ol>
			</td>
		</tr>
		<tr>
			<td><b>Post-conditions:</b></td>
			<td>Item(s) will no longer have check off marks </td>
		</tr>
		<tr>
			<td><b>Normal Course:</b></td>
			<td>
				<ol>
					<li>The user logs into app</li>
					<li>The app authenticates the user</li>
					<li>The user selects list</li>
					<li>The user choose "Clear Check Off Marks"</li>
					<li>The app acknowledges check off marks have been cleared</li>
					<li>The app redirects user to the item list page</li>
				</ol>
			</td>
		</tr>
		<tr>
			<td><b>Exception</b></td>
			<td>
				Ex1: User logs off
				<ol>
					<li>Return to Normal Course Step 1</li>
				</ol>
				Ex2: App fails to authenticate the user
				<ol>
					<li>Inform user and redirect to log in page</li>
				</ol>
				Ex3: Cannot not remove check off mark
				<ol>
					<li>Inform user that an error has occurred</li>
					<li>Return to Normal Course Step 4</li>
				</ol>
			</td>
		</tr>
	</tbody>
</table>
<!-- 11 -->
<table>
	<thead>
		<tr>
			<th colspan="3"><b>Register </b></th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td><b>Brief description:</b></td>
			<td>The user registers a new account for the app</td>
		</tr>
		<tr>
			<td><b>Actor:</b></td>
			<td>User</td>
		</tr>
		<tr>
			<td><b>Pre-conditions:</b></td>
			<td>
				none
			</td>
		</tr>
		<tr>
			<td><b>Post-conditions:</b></td>
			<td>New account is created</td>
		</tr>
		<tr>
			<td><b>Normal Course:</b></td>
			<td>
				<ol>
					<li>The user chooses "Register"</li>
					<li>The app requests the username and password</li>
					<li>The user enters username and password</li>
					<li>The app validates the entered name and password and creates a new account</li>
					<li>The app redirects user to log in page</li>
				</ol>
			</td>
		</tr>
		<tr>
			<td><b>Exception</b></td>
			<td>
				Ex1: The username and password are not valid
				<ol>
					<li>Inform user of the constraint for user and password</li>
					<li>Return to Normal Course Step 2</li>
				</ol>
				Ex2: Cannot register
				<ol>
					<li>Inform user that an error has occurred</li>
					<li>Return to Normal Course Step 1</li>
				</ol>
			</td>
		</tr>
	</tbody>
</table>
<!-- 12 -->
<table>
	<thead>
		<tr>
			<th colspan="3"><b>Login</b></th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td><b>Brief description:</b></td>
			<td>The user logs into the app</td>
		</tr>
		<tr>
			<td><b>Actor:</b></td>
			<td>User</td>
		</tr>
		<tr>
			<td><b>Pre-conditions:</b></td>
			<td>
				none
			</td>
		</tr>
		<tr>
			<td><b>Post-conditions:</b></td>
			<td>The user is logged into the app</td>
		</tr>
		<tr>
			<td><b>Normal Course:</b></td>
			<td>
				<ol>
					<li>The app requests the username and password</li>
					<li>The user enters username and password</li>
					<li>The app validates the entered name and password</li>
					<li>The app redirects user to the list page</li>
				</ol>
			</td>
		</tr>
		<tr>
			<td><b>Exception</b></td>
			<td>
				Ex1: The username and password are not valid
				<ol>
					<li>Inform user of the constraint for user and password</li>
					<li>Return to Normal Course Step 2</li>
				</ol>
			</td>
		</tr>
	</tbody>
</table>
<!-- 13 -->
<table>
	<thead>
		<tr>
			<th colspan="3"><b>Update Profile</b></th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td><b>Brief description:</b></td>
			<td>The user changes account information</td>
		</tr>
		<tr>
			<td><b>Actor:</b></td>
			<td>User</td>
		</tr>
		<tr>
			<td><b>Pre-conditions:</b></td>
			<td>
				The user must log into the app
			</td>
		</tr>
		<tr>
			<td><b>Post-conditions:</b></td>
			<td>The account information is changed</td>
		</tr>
		<tr>
			<td><b>Normal Course:</b></td>
			<td>
				<ol>
					<li>The user logs into app</li>
					<li>The app authenticates the user</li>
					<li>The user choose "Update"</li>
					<li>The user updates account information</li>
					<li>The app acknowledges the account information has been changed</li>
					<li>The app redirects user to the list page</li>
				</ol>
			</td>
		</tr>
		<tr>
			<td><b>Exception</b></td>
			<td>
				Ex1: User logs off
				<ol>
					<li>Return to Normal Course Step 1</li>
				</ol>
				Ex2: App fails to authenticate the user
				<ol>
					<li>Inform user and redirects to log in page</li>
				</ol>
				Ex3: Cannot update information
				<ol>
					<li>Inform user that an error has occurred</li>
					<li>Return to Normal Course Step 3</li>
				</ol>
			</td>
		</tr>
	</tbody>
</table>
