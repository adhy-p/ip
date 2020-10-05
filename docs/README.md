# The Duke Project User Guide
Duke is a command line interface (CLI) application written in Java. This desktop application allows users to keep track manage their tasks. Users can add, mark as done, find, and delete tasks by just typing one line of command. 

## Table of Content
- [About](#about-this-user-guide)
- [Getting Started](#getting-started)
- [Commands](#commands)

## About this User Guide
This user guide provides a brief documentation on how to install and use Duke project to help you manage your tasks

## Getting started
Before we start, make sure that you have Java 11 or later installed on your computer. If you don't have Java installed, please install it first [here](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)

Download the .jar file from the repository by clicking this [link](https://github.com/adhy-p/ip/releases/download/A-UserGuide/ip.jar). After you've downloaded the jar file, 
1. Open a new terminal (or command prompt in Windows) 
2. Move to the directory of the .jar file by using `cd`
3. Start the program by typing `java -jar ip.jar`
4. Type the command in the terminal and press `Enter` to execute it. Refer to the **Commands** below for the list of commands and the details of each command.

## Commands

### `todo` - Add todo task to the tasks list
This command adds a todo task, a task without information on when it should be done

Format:

`todo DESCRIPTION`

Example of usage: 

`todo eat breakfast`

Expected outcome:

```
Got it. I've added this task:
[T][X] eat breakfast
Now you have 1 tasks in the list.
```
***
### `deadline` - Add a deadline to the tasks list
This command adds a deadline, a task with a specific time when it should be done by

Format:

`deadline DESCRIPTION /by YYYY-MM-DD HHmm`

Example of usage: 

`deadline projects /by 2020-12-25 1200`

Expected outcome:

```
Got it. I've added this task:
[D][X] projects (by: 25 Dec 2020 12:00)
Now you have 2 tasks in the list.
```
***
### `event` - Add an event to the tasks list
This command adds an event task, a task with a specific time when it should be attended

Format:

`event DESCRIPTION /at YYYY-MM-DD HHmm`

Example of usage: 

`event projects /at 2020-12-25 1200`

Expected outcome:

```
Got it. I've added this task:
[E][X] projects (by: 25 Dec 2020 12:00)
Now you have 3 tasks in the list.
```
***
### `list` - Print all tasks in the list
This command prints all tasks that are currently in the list

Format:

`list`

Example of usage: 

`list`

Expected outcome:

```
1. [T][X] eat breakfast
2. [D][X] projects (by: 25 Dec 2020 12:00)
3. [E][X] projects (at: 25 Dec 2020 12:00)
```
***
### `done` - Mark a task as done
This command marks one task as done

Format:

`done INDEX`

Example of usage: 

`done 1`

Expected outcome:

```
Nice! I've marked this task as done:
[V] [T][V] eat breakfast
```
***
### `delete` - Delete tasks from the list
This command deletes one task from the task list

Format:

`delete INDEX`

Example of usage: 

`delete 2`

Expected outcome:

```
Got it! I've removed this task:
[D][X] projects (by: 25 Dec 2020 12:00)
Now you have 2 tasks in the list.
```
***
### `find` - Find tasks based on keywords
This command filters the tasks and prints only the tasks with description containing the keyword

Format:

`find KEYWORD`

Example of usage: 

`find pro`

Expected outcome:

```
1. [E][X] projects (at: 25 Dec 2020 12:00)
```
***
### `bye` - Exit
This command saves all data and stop the application

Format:

`bye`

Example of usage: 

`bye`

Expected outcome:

```
Bye. Hope to see you soon!
```
