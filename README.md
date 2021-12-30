# <p align="center">Welcome to Minesweeper 🎮 👋</p>

<blockquote>
There aren't many Gen-Y people who hadn't played the Minesweeper game. This project is the terminal implementation of the famous minesweeper game.
For now, you can play this game on a 9 * 9 grid. But the grid size can be easily be updated to a bigger grid-like 16 * 16.
</blockquote>

<br/>

## Getting started

**Terminologies:**

<table> 
<tr> <th>Keyword</th> <th>Meaning</th>  </tr>
<tr> <td>Unmarked cells</td> <td>Cells that haven't been explored yet.</td> </tr>
<tr> <td>Marked cells</td> <td>Explored cells</td> </tr>
<tr> <td>Safe cell</td> <td>Cell that is empty / doesn't contain a mine.</td> </tr>
<tr> <td>Clue</td> <td>Explored free cells with 1 to 8 mines around them. Shown to help the user.</td> </tr>
</table>

<br/>

**Symbols:** </br>
<b>.</b> &nbsp; --> &nbsp; unmarked cell </br>
<b>/</b> &nbsp; --> &nbsp; safe cell </br>
<b>*</b> &nbsp; --> &nbsp; may be a mine (marked cell) </br>
<b>X</b> &nbsp; --> &nbsp; mine </br>
<b>1</b> &nbsp; --> &nbsp; clue </br>

<br/>

**How to play?**
1. Enter the number of mines to begin the game. 
2. Once the game gets started, it will finish only if:
   <ul>
   <li>You step on a mine. Game Over! 👎😑</li>
   <li>You found all the mines or explored all the safe cells. You win! 😁✌️</li>
   <li> Safe cells: Cells that don't contain a mine.</li>
   </ul>
3. At each step in the game. The game asks you to either mark/unmark a cell as mine (you think a mine can be present here.) or;
4. Claim a cell as free.
7. If a cell that you claimed as free contains a mine. Then the game is over!
8. Otherwise, the game will continue until you find all the mines in the grid or explore all the safe cells.

<br/>

## ✨Demo

![Minesweeper demo gif.](https://github.com/lowkey96/Minesweeper/blob/master/MinesweeperDemo.gif)


## Installation

**From IDE:**

1. Download the project.
2. Unzip it.
3. Open the project in an IDE like IntelliJ IDEA, Microsoft Visual Studio or Eclipse.
4. Build the project.
5. Run the main file.

<br/>

**From terminal:**
1. Open the project directory on terminal/command prompt.
2. Use the **javac Main.java** command to compile the project.
3. Use the **java Main** command to run the game.

<br/>

**Note:** You need to have Java on your system to run this game.
