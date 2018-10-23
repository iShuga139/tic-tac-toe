TICA TAC TOE V2
===============

Tic Tac Toe game designed for three players with a minimum playfield of 3x3 to a maximum playfield of 10x10.


Design decisions
----------------
- I took the decision to create a Maven Java project.
- I created a "Player" Business Object (bo) to define the properties that the player contains.
- I defined a Business Services (bs) layer to define all the logic of the game.

```
  1. There are "Services" that implement the rules of the game and the decisions that CPU should consider.
  2. These services have "Helper" objects to provide idiomatic and clean code.
  3. Unfortunately for me, I did not have time to finish the CPU logic.
```
 
- I defined a resource file to retrieve the configuration for the game.

```
  1. This file has the format key-value, so the application expects something like this: e.g. playfield=5
  2. The App expects that the file does not contain blank spaces between the "=" symbol.
```

- I defined a CLI layer which is in charge to display the board status to the console.
- The CPUService tries to simulate the status for the CPU movements to provide what is the best movement to do. 
- This App uses JUnit to do tests over the code. 


Building and Runing Tests
-------------------------
- Apache Maven is required
- Go to the root of this project
- Clean, Compile and Run Tests with the following command

```java
  mvn install
```

 How to run it
-------------
- Go to the root of this project.
- Compile the project with the following command

```
  mvn compile
```
- Then to start the app, run the following command

```
  mvn exec:java -Dexec.mainClass="com.metronom.tictactoe.Application"
```
	
