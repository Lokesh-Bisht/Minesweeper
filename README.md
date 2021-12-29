# Minesweeper 🎮

## About

There aren't many Gen-Y people who hadn't played the Minesweepeer game. This project is the terminal implementaion of the famous minesweeper game.
For now you can play this game on a 9 * 9 grid. But this can always be updated to a bigger grid like 16 * 16.

</br>

## Getting started

**Terminlogies:**

<table> 
<tr> <th>Keyword</th> <th>Meaning</th>  </tr>
<tr> <td>Unmarked cells</td> <td>The cells that haven't been explored yet.</td> </tr>
<tr> <td>Marked cells</td> <td>Explored cells</td> </tr>
<tr> <td>Safe cell</td> <td>Cell that is empty / don't contain a mine.</td> </tr>
<tr> <td>Clue</td> <td>Explored free cells with 1 to 8 mines around them. Shown to help the user.</td> </tr>
</table>

</br>

**Symbols:** </br>
<b>.</b> &nbsp; --> &nbsp; unmarked cell </br>
<b>/</b> &nbsp; --> &nbsp; safe cell </br>
<b>*</b> &nbsp; --> &nbsp; may be a mine (marked cell) </br>
<b>X</b> &nbsp; --> &nbsp; mine </br>
<b>1</b> &nbsp; --> &nbsp; clue </br>

</br>

**How to play?**
1. Enter the number of mines to begin the game. 
2. Once the game is started the game can only be finished if:
   <ul>
   <li>You step on a mine. Game Over! 👎😑</li>
   <li>You found all the mines or explored all the safe cells! You win 😁✌🏆</li>
   <li> Safe cells: Cells that don't contains a mine.</li>
   </ul>
3. At each step you will asked to either mark/unmark a cell as mine or
4. claim a cell as free.
7. If the cell that you claimed as free contains a mine. Then the game is over!
8. Otherwise, the game will continue until you find all the mines or explore all the safe cells.

</br>

Below is a gif that will show you how to help the gmae:


</br>

## Installation

**From IDE:**

1. Download the project.
2. Unzip it.
3. Open the project in a IDE like JetBrains IDEA.
4. Build the project.
5. Run
