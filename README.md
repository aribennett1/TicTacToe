# Tic Tac Toe Game with Aspect-Oriented Programming
This is a simple Tic Tac Toe game implemented in Java, showcasing the usage of aspect-oriented programming (AOP) to manage game rules and flow using an AspectJ aspect.

## Compilation
Compile the program using the AspectJ compiler. Make sure you have AspectJ installed and added to your system's PATH environment variable.
```
ajc -cp . TicTacToeGame.java Board.java Referee.aj
```
Running the Game
Run the compiled program using the Java Virtual Machine.
```
java TicTacToeGame
```
Follow the on-screen prompts to make your moves. The game will display the current state of the board after each move and inform you of the game outcome.
## Features
- The game supports two players: Player X and Player O.
- Players take turns making moves by entering row and column numbers.
- The Referee aspect handles game rules and flow, including checking move validity and determining game outcomes.
- The game ends when one player wins by forming a line of their symbols (X or O) or when the board is full, resulting in a draw.
## Aspect-Oriented Programming
Aspect-Oriented Programming (AOP) is a programming paradigm that focuses on modularizing cross-cutting concerns, such as logging, security, and performance monitoring, by separating them from the core business logic. In this Tic Tac Toe implementation, the Referee aspect manages game rules and flow, reducing the coupling between the game logic and the validation and outcome checks.

