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
			<td>The Actor craete a new List</td>
		</tr>
		<tr>
			<td><b>Actor:</b></td>
			<td>User</td>
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
					<li>The user logs into apps</li>
					<li>The app authenticates the user</li>
					<li>The user chooses "create new list"</li>
					<li>The user enters the name of the new list</li>
					<li>The app acknowledges the list is created</li>
					<li>The app redirects the user to the main page</li>
				</ol>
			</td>
		</tr>
		<tr>
			<td><b>Exception</b></td>
			<td>Ex1 App determines if the name of the new list has been used
				<ol>
					<li>inform user that the name has been used</li>
					<li>return to Normal Course step 4</li>
				</ol>
				Ex2 user logs off
				<ol>
					<li>return to Normal Course step 1</li>
				</ol>
				Ex3  The name the user enters contains a symbol<br>
				<ol>
					<li>informs user that there are no symbols in name of list</li>
					<li>return Normal Course step 4</li>
				</ol>
				Ex4 app fails to authenticate the user
				<ol>
					<li>inform user and redirect to log in page</li>
				</ol>
				Ex5 fail to create list
				<ol>
					<li>inform user that an error has occured</li>
					<li>return Normal Course Step3</li>
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
					<li>The user chooses "delete list"</li>
					<li>The user selects one or more lists</li>
					<li>The app prompts user to comfirm</li>
					<li>The app acknowledges that the list is deleted</li>
					<li>The app redirects user to the main page</li>
				</ol>
			</td>
		</tr>
		<tr>
			<td><b>Alternate Courses</b></td>
			<td>
				AC1 delete List inside the List
				<ol>
					<li>The user logs into app</li>
					<li>The app authenticates the user</li>
					<li>The user get into a list</li>
					<li>The user chooses "delete list"</li>
					<li>The app prompts user to comfirm</li>
					<li>The app acknowledges that the list deleted</li>
					<li>The apps redirects user to the main page</li>
				</ol>
			</td>
		</tr>
		<tr>
			<td><b>Exception</b></td>
			<td>Ex1 user doesn't select any lists
				<ol>
					<li>The app redirects user to main page</li>
				</ol>
				Ex2 user logs off
				<ol>
					<li>return to Normal Course step 1</li>
				</ol>
				Ex3 app fails to authenticate the user
				<ol>
					<li>inform user and redirect to log in page</li>
				</ol>
				Ex4 fail to delete list
				<ol>
					<li>inform user that an error has occured</li>
					<li>return Normal Course Step3</li>
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
					<li>The user logs into apps</li>
					<li>The app authenticates the actor</li>
					<li>The user select  a list</li>
					<li>The user select the name of list and rename it</li>
					<li>The app acknowledges that list deleted</li>
					<li>The app redirect user to main page</li>
				</ol>
			</td>
		</tr>
		<tr>
			<td><b>Exception</b></td>
			<td>Ex1 Apps determines the new name of list has been used
				<ol>
					<li>inform user that the name has been used</li>
					<li>return to Normal Course step 4</li>
				</ol>
				Ex2 user logs off
				<ol>
					<li>return to Normal Course step 1</li>
				</ol>
				Ex3  The name user enter containing symbol<br>
				<ol>
					<li>inform user that there is no symbol in name of list</li>
					<li>return Normal Course step 4</li>
				</ol>
				Ex4 app fails to authenticate the user
				<ol>
					<li>inform user and redirect to log in page</li>
				</ol>
				Ex5 fail to rename list
				<ol>
					<li>inform user that an error has occured</li>
					<li>return Normal Course Step3</li>
				</ol>
			</td>
		</tr>
	</tbody>
</table>


<!-- 4 -->

<table>
	<thead>
		<tr>
			<th colspan="3"><b>Add item</b></th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td><b>Brief description:</b></td>
			<td>The user add item to the List</td>
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
			<td>new item is added to the list</td>
		</tr>
		<tr>
			<td><b>Normal Course:</b></td>
			<td>
				<ol>
					<li>The user logs into apps</li>
					<li>The app authenticates the actor</li>
					<li>The user select a list</li>
					<li>The user search item by name or by item type</li>
					<li>The user select the item</li>
					<li>The app prompts user for amount</li>
					<li>The app acknowledges that the item is added</li>
					<li>The app redirects user to the search page</li>
				</ol>
			</td>
		</tr>
		<tr>
			<td><b>Exception</b></td>
			<td>
				Ex1 Actor logs off
				<ol>
					<li>return to Normal Course step 1</li>
				</ol>
				Ex2 app fails to authenticate the user
				<ol>
					<li>inform user and redirect to log in page</li>
				</ol>
				Ex3 item not found
				<ol>
					<li>See "NewItem" Use Case</li>
				</ol>
				Ex4 fail to add item
				<ol>
					<li>inform user that an error has occured</li>
					<li>return Normal Course Step4</li>
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
			<td>The user delete item in the List</td>
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
			<td>new item is deleted in the list</td>
		</tr>
		<tr>
			<td><b>Normal Course:</b></td>
			<td>
				<ol>
					<li>The user logs into apps</li>
					<li>The app authenticates the actor</li>
					<li>The user select a list</li>
					<li>The user choose "delete item"</li>
					<li>The user select one or more item</li>
					<li>The app prompts user to comfirm</li>
					<li>The app acknowledges that the item is deleted</li>
					<li>The app redirects user to the item list page</li>
				</ol>
			</td>
		</tr>
		<tr>
			<td><b>Exception</b></td>
			<td>
				Ex1 Actor logs off
				<ol>
					<li>return to Normal Course step 1</li>
				</ol>
				Ex2 app fails to authenticate the user
				<ol>
					<li>inform user and redirect to log in page</li>
				</ol>
				Ex4 fail to delete item
				<ol>
					<li>inform user that an error has occured</li>
					<li>return Normal Course Step4</li>
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
			<td>The user change the amount of item in the List</td>
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
			<td>the amount of item is changed</td>
		</tr>
		<tr>
			<td><b>Normal Course:</b></td>
			<td>
				<ol>
					<li>The user logs into apps</li>
					<li>The app authenticates the actor</li>
					<li>The user select a list</li>
					<li>The user select one item</li>
					<li>The user change the amount</li>
					<li>The app acknowledges that the amount is changed</li>
					<li>The app redirects user to the item list page</li>
				</ol>
			</td>
		</tr>
		<tr>
			<td><b>Exception</b></td>
			<td>
				Ex1 Actor logs off
				<ol>
					<li>return to Normal Course step 1</li>
				</ol>
				Ex2 app fails to authenticate the user
				<ol>
					<li>inform user and redirect to log in page</li>
				</ol>
				Ex3 user doesn't enter any amount
				<ol>
					<li>inform user to enter a valid number</li>
					<li>return Normal Course Step 5</li>
				</ol>
				Ex4 fail to change quantity of item
				<ol>
					<li>inform user that an error has occured</li>
					<li>return Normal Course Step4</li>
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
			<td>The user remove all items in the List</td>
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
			<td>the list is empty</td>
		</tr>
		<tr>
			<td><b>Normal Course:</b></td>
			<td>
				<ol>
					<li>The user logs into apps</li>
					<li>The app authenticates the actor</li>
					<li>The user select a list</li>
					<li>The user choose "clear list"</li>
					<li>The app prompts user to comfirm</li>
					<li>The app acknowledges the list is cleared</li>
					<li>The app redirects user to the item list page</li>
				</ol>
			</td>
		</tr>
		<tr>
			<td><b>Exception</b></td>
			<td>
				Ex1 Actor logs off
				<ol>
					<li>return to Normal Course step 1</li>
				</ol>
				Ex2 app fails to authenticate the user
				<ol>
					<li>inform user and redirect to log in page</li>
				</ol>
				Ex3 fail to clear list
				<ol>
					<li>inform user that an error has occured</li>
					<li>return Normal Course Step4</li>
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
			<td>The user reorder the list</td>
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
					<li>There must be at least two list</li>
				</ol>
			</td>
		</tr>
		<tr>
			<td><b>Post-conditions:</b></td>
			<td>order of list is change</td>
		</tr>
		<tr>
			<td><b>Normal Course:</b></td>
			<td>
				<ol>
					<li>The user logs into apps</li>
					<li>The app authenticates the actor</li>
					<li>The user choose "modify list"</li>
					<li>The user select two list</li>
					<li>The app prompts user to comfirm</li>
					<li>The app acknowledges order of list is changed</li>
					<li>The app redirects user to the  list page</li>
				</ol>
			</td>
		</tr>
		<tr>
			<td><b>Exception</b></td>
			<td>
				Ex1 Actor logs off
				<ol>
					<li>return to Normal Course step 1</li>
				</ol>
				Ex2 app fails to authenticate the user
				<ol>
					<li>inform user and redirect to log in page</li>
				</ol>
				Ex3 lists don't swap
				<ol>
					<li>inform user that an error has occured</li>
					<li>return Normal Course step 3</li>
				</ol>
			</td>
		</tr>
	</tbody>
</table>
<!-- 9 -->
<table>
	<thead>
		<tr>
			<th colspan="3"><b>CheckOff </b></th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td><b>Brief description:</b></td>
			<td>The user check off item or remove check off from item</td>
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
					<li>There is at least one item in list</li>
				</ol>
			</td>
		</tr>
		<tr>
			<td><b>Post-conditions:</b></td>
			<td>item  with check off or without check off</td>
		</tr>
		<tr>
			<td><b>Normal Course:</b></td>
			<td>
				<ol>
					<li>The user logs into apps</li>
					<li>The app authenticates the actor</li>
					<li>The user select list</li>
					<li>The user check off item or remove check off from item</li>
					<li>The user select item</li>
				</ol>
			</td>
		</tr>
		<tr>
			<td><b>Exception</b></td>
			<td>
				Ex1 Actor logs off
				<ol>
					<li>return to Normal Course step 1</li>
				</ol>
				Ex2 app fails to authenticate the user
				<ol>
					<li>inform user and redirect to log in page</li>
				</ol>
				Ex3 cannot not check off or remove check off
				<ol>
					<li>inform user that an error has occured</li>
					<li>return Normal Course step 3</li>
				</ol>
			</td>
		</tr>
	</tbody>
</table>
<!-- 10 -->
<table>
	<thead>
		<tr>
			<th colspan="3"><b>clearCheckOff </b></th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td><b>Brief description:</b></td>
			<td>The user check off from all items</td>
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
					<li>There is at least one item in list and has been checked off</li>
				</ol>
			</td>
		</tr>
		<tr>
			<td><b>Post-conditions:</b></td>
			<td>item  without check off </td>
		</tr>
		<tr>
			<td><b>Normal Course:</b></td>
			<td>
				<ol>
					<li>The user logs into apps</li>
					<li>The app authenticates the actor</li>
					<li>The user select list</li>
					<li>The user choose "clear check off"</li>
					<li>The app acknowledges check off is cleared</li>
					<li>The app redirects user to the item list page</li>
				</ol>
			</td>
		</tr>
		<tr>
			<td><b>Exception</b></td>
			<td>
				Ex1 Actor logs off
				<ol>
					<li>return to Normal Course step 1</li>
				</ol>
				Ex2 app fails to authenticate the user
				<ol>
					<li>inform user and redirect to log in page</li>
				</ol>
				Ex3 cannot not remove check off
				<ol>
					<li>inform user that an error has occured</li>
					<li>return Normal Course step 4</li>
				</ol>
			</td>
		</tr>
	</tbody>
</table>
<!-- 11 -->
