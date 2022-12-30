## Object Oriented Programing - task 1
------------

##### in this task we were asked to implement the principle of **Observer Design Pattern**

------------
- ### GroupAdmin.java - *observer*
- ### ConcreteMember.java - *observable*

------------

### GroupAdmin
implement Sender (observer) interface
handle two data members
1. `UndoableStringBuilder`
(a StringBuilder with Undo operation)

2. `List <Member>`

in the list we keep all the Members that needed to be notified about every
change in our UndoableStringBuilder object.

------------

### ConcreteMember
implement  Member (observable) interface
handle 4 data members

1. `UndoableStringBuilder`
(a shallow copy from the GroupAdmin)

2. `int - push`
(count the numbers of the updates that we didnt read yet)

3. `boolean - register`

4. `Qeueu <Strings> - allUpdates`
(where we keep all the changes that the GroupAdmin did in the StringBuilder)

### unic functions

    public void watchAllUpdates()
printed to the console all the latest updates in order from the 
oldest to the newest

    public void watchFirstUpdate()
printed to the console the first update we didnt see yet





