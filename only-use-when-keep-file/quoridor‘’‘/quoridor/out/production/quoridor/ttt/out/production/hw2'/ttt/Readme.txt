# CS611-Assignment 1
## Tictactoe and Orderandchaos and SuperTictactoe
---------------------------------------------------------------------------
Name:Yifei Zhou
Email:joeyifei@bu.edu
Student ID:U25549843

## Files
---------------------------------------------------------------------------

Main.java:main 
Menu.java:guide the player to choose the game they whant to play
Generalboardgame.java:some basic function of board game,such as init board or print
Orderandchaosgame.java:oac game class
Tictactoegame.java:ttt game class
Pieces.java:some function about setting pieces
Playe.java:some function about setting player information
board.java:contain n*m cell
cell.java:contain pieces
superboard.java:contain n*m supercell
supercell.java:each supercell can contain a game of tictactoe
supertictactoe.java:sttt game class

Example.java: This class provides an example to the student.

## Notes
---------------------------------------------------------------------------
record how many time win for every player

set color of pieces

superttt can play default size or you can set N and M for bigboard&smallboard

Generalboardgame is a Super class which contain general attribute of board game and function needed by boardgame,such as init and print board.
Orderandchaosgame and Tictactoegame is extended from Generalboardgame.

For the Tictactoegame,the board can be extend from 3 x 3 to 10 x 10, for example 4 x 4 or 6 x6 is allowed.However any input >10 or <3 or any character or symbol will be invalid and this game will ask player to set the size again.
For Orderandchaosgame,board are fixed as 6 x 6
Because of the rules of two game are different,the function to decide whether a player can win is differrent,which is written saperately in these two class

After program find a winner in every round,the program will ask whather we want to begin a new game,so you can play new game infinitely,or you can just choose exit to exit the program after each game(for select game,the program will also check the validation of input,can't be character or something)

Players:There are two player for every game,we can name the players as anyname we want,number or symbol can be contained in name
Pieces:For each player ,they can choose any symbol(a char) as their Pieces,but the program will ask them to use two different symbol as the pieces 

For everytime time player enter a coordinate of the pieces,program will check if the coordinate legal,which means input can't be symbol or character,and after this,program check if the coordinate is on board and vacant 

## How to compile and run
---------------------------------------------------------------------------
run the following in hw2 folder.

mkdir bin
javac *.java -d bin
java -cp ./bin ttt.Main

The mkdir bin makes a folder called bin
javac compiles all of the files with a .java extension and puts the output in the bin folder
java runs the code. It looks in the ./bin folder and runs the Main class inside of the ttt package.

## Input/Output Example
---------------------------------------------------------------------------
Output:

Welcome ot board game,you can play all king of board game here.
Firstly,let us set players information
hi, player1
please enter your name:
1
hi, player2
please enter your name:
2
OK,set up

set piece for 1
enter a symbol as a piece:  3sefefe
invalid,enter again:  1
what color of piece 1 want?(-1_default,0_red,1_yellow,2_blue)
2
set up
set piece for 2
enter a symbol as a piece:  2
what color of piece of player 1 want?(-1_default,0_red,1_yellow,2_blue)
0
set up!!
Please choose a game
enter 1 for TicTacToe
enter 2 for OrderAndChaos:
enter 3 for SuperTictactoe
enter 4 for exit game
1
Hello,welcome to TicTacToe
set N,please enter a number(from 3 to 10):
3
set M,please enter a number(from 3 to 10):
3
[ ]1[ ]2[ ]3
[ ]4[ ]5[ ]6
[ ]7[ ]8[ ]9
set win_condition,it should <= Shortest length of board
3
win_condition set up,win if 3 pieces in a line
Start play!!
[ ]1[ ]2[ ]3
[ ]4[ ]5[ ]6
[ ]7[ ]8[ ]9
1,please enter a cell:
1
[1]1[ ]2[ ]3
[ ]4[ ]5[ ]6
[ ]7[ ]8[ ]9
2,please enter a cell:
2
[1]1[2]2[ ]3
[ ]4[ ]5[ ]6
[ ]7[ ]8[ ]9
1,please enter a cell:
3
[1]1[2]2[1]3
[ ]4[ ]5[ ]6
[ ]7[ ]8[ ]9
2,please enter a cell:
4
[1]1[2]2[1]3
[2]4[ ]5[ ]6
[ ]7[ ]8[ ]9
1,please enter a cell:
5
[1]1[2]2[1]3
[2]4[1]5[ ]6
[ ]7[ ]8[ ]9
2,please enter a cell:
6
[1]1[2]2[1]3
[2]4[1]5[2]6
[ ]7[ ]8[ ]9
1,please enter a cell:
9
[1]1[2]2[1]3
[2]4[1]5[2]6
[ ]7[ ]8[1]9
player 1 win
Totally win :1 times
 
 
Do you want to play again?
enter 1 for TicTacToe
enter 2 for OrderAndChaos:
enter 3 for SuperTictactoe
enter 4 for exit game
kd;lak
please enter a valid number
enter 1 for TicTacToe
enter 2 for OrderAndChaos:
enter 3 for SuperTictactoe
enter 4 for exit game
0
please enter a valid number
enter 1 for TicTacToe
enter 2 for OrderAndChaos:
enter 3 for SuperTictactoe
enter 4 for exit game
5321
please enter a valid number
enter 1 for TicTacToe
enter 2 for OrderAndChaos:
enter 3 for SuperTictactoe
enter 4 for exit game
3
Hello,welcome to SuperTictactoe
the inner and outer size will default by 3x3 and 3x3,
enter 0 to use the default rule(both big and small board are 3x3,win_condition both=3) ,
enter 1 to set the size by yourself:
2
no valid
0
Start play!!
[ ] [ ] [ ]         [ ] [ ] [ ]         [ ] [ ] [ ]         
[ ] [ ] [ ]         [ ] [ ] [ ]         [ ] [ ] [ ]         
[ ] [ ] [ ]board 1  [ ] [ ] [ ]board 2  [ ] [ ] [ ]board 3  

[ ] [ ] [ ]         [ ] [ ] [ ]         [ ] [ ] [ ]         
[ ] [ ] [ ]         [ ] [ ] [ ]         [ ] [ ] [ ]         
[ ] [ ] [ ]board 4  [ ] [ ] [ ]board 5  [ ] [ ] [ ]board 6  

[ ] [ ] [ ]         [ ] [ ] [ ]         [ ] [ ] [ ]         
[ ] [ ] [ ]         [ ] [ ] [ ]         [ ] [ ] [ ]         
[ ] [ ] [ ]board 7  [ ] [ ] [ ]board 8  [ ] [ ] [ ]board 9  


1,enter which board
0
no valid
5
[ ]1[ ]2[ ]3
[ ]4[ ]5[ ]6
[ ]7[ ]8[ ]9
1,please enter a cell
(0 back to big board,-1 quit the game):
5
[ ] [ ] [ ]         [ ] [ ] [ ]         [ ] [ ] [ ]         
[ ] [ ] [ ]         [ ] [ ] [ ]         [ ] [ ] [ ]         
[ ] [ ] [ ]board 1  [ ] [ ] [ ]board 2  [ ] [ ] [ ]board 3  

[ ] [ ] [ ]         [ ] [ ] [ ]         [ ] [ ] [ ]         
[ ] [ ] [ ]         [ ] [1] [ ]         [ ] [ ] [ ]         
[ ] [ ] [ ]board 4  [ ] [ ] [ ]board 5  [ ] [ ] [ ]board 6  

[ ] [ ] [ ]         [ ] [ ] [ ]         [ ] [ ] [ ]         
[ ] [ ] [ ]         [ ] [ ] [ ]         [ ] [ ] [ ]         
[ ] [ ] [ ]board 7  [ ] [ ] [ ]board 8  [ ] [ ] [ ]board 9  


2,enter which board
10
no valid
5
[ ]1[ ]2[ ]3
[ ]4[1]5[ ]6
[ ]7[ ]8[ ]9
2,please enter a cell
(0 back to big board,-1 quit the game):
7
[ ] [ ] [ ]         [ ] [ ] [ ]         [ ] [ ] [ ]         
[ ] [ ] [ ]         [ ] [ ] [ ]         [ ] [ ] [ ]         
[ ] [ ] [ ]board 1  [ ] [ ] [ ]board 2  [ ] [ ] [ ]board 3  

[ ] [ ] [ ]         [ ] [ ] [ ]         [ ] [ ] [ ]         
[ ] [ ] [ ]         [ ] [1] [ ]         [ ] [ ] [ ]         
[ ] [ ] [ ]board 4  [2] [ ] [ ]board 5  [ ] [ ] [ ]board 6  

[ ] [ ] [ ]         [ ] [ ] [ ]         [ ] [ ] [ ]         
[ ] [ ] [ ]         [ ] [ ] [ ]         [ ] [ ] [ ]         
[ ] [ ] [ ]board 7  [ ] [ ] [ ]board 8  [ ] [ ] [ ]board 9  


1,enter which board
5
[ ]1[ ]2[ ]3
[ ]4[1]5[ ]6
[2]7[ ]8[ ]9
1,please enter a cell
(0 back to big board,-1 quit the game):
10
no valid
8
[ ] [ ] [ ]         [ ] [ ] [ ]         [ ] [ ] [ ]         
[ ] [ ] [ ]         [ ] [ ] [ ]         [ ] [ ] [ ]         
[ ] [ ] [ ]board 1  [ ] [ ] [ ]board 2  [ ] [ ] [ ]board 3  

[ ] [ ] [ ]         [ ] [ ] [ ]         [ ] [ ] [ ]         
[ ] [ ] [ ]         [ ] [1] [ ]         [ ] [ ] [ ]         
[ ] [ ] [ ]board 4  [2] [1] [ ]board 5  [ ] [ ] [ ]board 6  

[ ] [ ] [ ]         [ ] [ ] [ ]         [ ] [ ] [ ]         
[ ] [ ] [ ]         [ ] [ ] [ ]         [ ] [ ] [ ]         
[ ] [ ] [ ]board 7  [ ] [ ] [ ]board 8  [ ] [ ] [ ]board 9  


2,enter which board
5
[ ]1[ ]2[ ]3
[ ]4[1]5[ ]6
[2]7[1]8[ ]9
2,please enter a cell
(0 back to big board,-1 quit the game):
2
[ ] [ ] [ ]         [ ] [ ] [ ]         [ ] [ ] [ ]         
[ ] [ ] [ ]         [ ] [ ] [ ]         [ ] [ ] [ ]         
[ ] [ ] [ ]board 1  [ ] [ ] [ ]board 2  [ ] [ ] [ ]board 3  

[ ] [ ] [ ]         [ ] [2] [ ]         [ ] [ ] [ ]         
[ ] [ ] [ ]         [ ] [1] [ ]         [ ] [ ] [ ]         
[ ] [ ] [ ]board 4  [2] [1] [ ]board 5  [ ] [ ] [ ]board 6  

[ ] [ ] [ ]         [ ] [ ] [ ]         [ ] [ ] [ ]         
[ ] [ ] [ ]         [ ] [ ] [ ]         [ ] [ ] [ ]         
[ ] [ ] [ ]board 7  [ ] [ ] [ ]board 8  [ ] [ ] [ ]board 9  


1,enter which board
5
[ ]1[2]2[ ]3
[ ]4[1]5[ ]6
[2]7[1]8[ ]9
1,please enter a cell
(0 back to big board,-1 quit the game):

no valid
9
[ ] [ ] [ ]         [ ] [ ] [ ]         [ ] [ ] [ ]         
[ ] [ ] [ ]         [ ] [ ] [ ]         [ ] [ ] [ ]         
[ ] [ ] [ ]board 1  [ ] [ ] [ ]board 2  [ ] [ ] [ ]board 3  

[ ] [ ] [ ]         [ ] [2] [ ]         [ ] [ ] [ ]         
[ ] [ ] [ ]         [ ] [1] [ ]         [ ] [ ] [ ]         
[ ] [ ] [ ]board 4  [2] [1] [1]board 5  [ ] [ ] [ ]board 6  

[ ] [ ] [ ]         [ ] [ ] [ ]         [ ] [ ] [ ]         
[ ] [ ] [ ]         [ ] [ ] [ ]         [ ] [ ] [ ]         
[ ] [ ] [ ]board 7  [ ] [ ] [ ]board 8  [ ] [ ] [ ]board 9  


2,enter which board
5
[ ]1[2]2[ ]3
[ ]4[1]5[ ]6
[2]7[1]8[1]9
2,please enter a cell
(0 back to big board,-1 quit the game):
1
[ ] [ ] [ ]         [ ] [ ] [ ]         [ ] [ ] [ ]         
[ ] [ ] [ ]         [ ] [ ] [ ]         [ ] [ ] [ ]         
[ ] [ ] [ ]board 1  [ ] [ ] [ ]board 2  [ ] [ ] [ ]board 3  

[ ] [ ] [ ]         [2] [2] [ ]         [ ] [ ] [ ]         
[ ] [ ] [ ]         [ ] [1] [ ]         [ ] [ ] [ ]         
[ ] [ ] [ ]board 4  [2] [1] [1]board 5  [ ] [ ] [ ]board 6  

[ ] [ ] [ ]         [ ] [ ] [ ]         [ ] [ ] [ ]         
[ ] [ ] [ ]         [ ] [ ] [ ]         [ ] [ ] [ ]         
[ ] [ ] [ ]board 7  [ ] [ ] [ ]board 8  [ ] [ ] [ ]board 9  


1,enter which board
5
[2]1[2]2[ ]3
[ ]4[1]5[ ]6
[2]7[1]8[1]9
1,please enter a cell
(0 back to big board,-1 quit the game):
4
[ ] [ ] [ ]         [ ] [ ] [ ]         [ ] [ ] [ ]         
[ ] [ ] [ ]         [ ] [ ] [ ]         [ ] [ ] [ ]         
[ ] [ ] [ ]board 1  [ ] [ ] [ ]board 2  [ ] [ ] [ ]board 3  

[ ] [ ] [ ]         [2] [2] [ ]         [ ] [ ] [ ]         
[ ] [ ] [ ]         [1] [1] [ ]         [ ] [ ] [ ]         
[ ] [ ] [ ]board 4  [2] [1] [1]board 5  [ ] [ ] [ ]board 6  

[ ] [ ] [ ]         [ ] [ ] [ ]         [ ] [ ] [ ]         
[ ] [ ] [ ]         [ ] [ ] [ ]         [ ] [ ] [ ]         
[ ] [ ] [ ]board 7  [ ] [ ] [ ]board 8  [ ] [ ] [ ]board 9  


2,enter which board
5
[2]1[2]2[ ]3
[1]4[1]5[ ]6
[2]7[1]8[1]9
2,please enter a cell
(0 back to big board,-1 quit the game):
3
this board has winner,now it is a big 2
[ ] [ ] [ ]         [ ] [ ] [ ]         [ ] [ ] [ ]         
[ ] [ ] [ ]         [ ] [ ] [ ]         [ ] [ ] [ ]         
[ ] [ ] [ ]board 1  [ ] [ ] [ ]board 2  [ ] [ ] [ ]board 3  

[ ] [ ] [ ]         [2] [ ] [ ]         [ ] [ ] [ ]         
[ ] [ ] [ ]         [ ] [ ] [ ]         [ ] [ ] [ ]         
[ ] [ ] [ ]board 4  [ ] [ ] [ ]board 5  [ ] [ ] [ ]board 6  

[ ] [ ] [ ]         [ ] [ ] [ ]         [ ] [ ] [ ]         
[ ] [ ] [ ]         [ ] [ ] [ ]         [ ] [ ] [ ]         
[ ] [ ] [ ]board 7  [ ] [ ] [ ]board 8  [ ] [ ] [ ]board 9  


1,enter which board
5
this cell is filled,pleas enter again
1,enter which board
5
this cell is filled,pleas enter again
1,enter which board
5
this cell is filled,pleas enter again
1,enter which board
5
this cell is filled,pleas enter again
1,enter which board
5
this cell is filled,pleas enter again
1,enter which board
5
this cell is filled,pleas enter again
1,enter which board
4
[ ]1[ ]2[ ]3
[ ]4[ ]5[ ]6
[ ]7[ ]8[ ]9
1,please enter a cell
(0 back to big board,-1 quit the game):
1
[ ] [ ] [ ]         [ ] [ ] [ ]         [ ] [ ] [ ]         
[ ] [ ] [ ]         [ ] [ ] [ ]         [ ] [ ] [ ]         
[ ] [ ] [ ]board 1  [ ] [ ] [ ]board 2  [ ] [ ] [ ]board 3  

[1] [ ] [ ]         [2] [ ] [ ]         [ ] [ ] [ ]         
[ ] [ ] [ ]         [ ] [ ] [ ]         [ ] [ ] [ ]         
[ ] [ ] [ ]board 4  [ ] [ ] [ ]board 5  [ ] [ ] [ ]board 6  

[ ] [ ] [ ]         [ ] [ ] [ ]         [ ] [ ] [ ]         
[ ] [ ] [ ]         [ ] [ ] [ ]         [ ] [ ] [ ]         
[ ] [ ] [ ]board 7  [ ] [ ] [ ]board 8  [ ] [ ] [ ]board 9  


2,enter which board
4
[1]1[ ]2[ ]3
[ ]4[ ]5[ ]6
[ ]7[ ]8[ ]9
2,please enter a cell
(0 back to big board,-1 quit the game):
5
[ ] [ ] [ ]         [ ] [ ] [ ]         [ ] [ ] [ ]         
[ ] [ ] [ ]         [ ] [ ] [ ]         [ ] [ ] [ ]         
[ ] [ ] [ ]board 1  [ ] [ ] [ ]board 2  [ ] [ ] [ ]board 3  

[1] [ ] [ ]         [2] [ ] [ ]         [ ] [ ] [ ]         
[ ] [2] [ ]         [ ] [ ] [ ]         [ ] [ ] [ ]         
[ ] [ ] [ ]board 4  [ ] [ ] [ ]board 5  [ ] [ ] [ ]board 6  

[ ] [ ] [ ]         [ ] [ ] [ ]         [ ] [ ] [ ]         
[ ] [ ] [ ]         [ ] [ ] [ ]         [ ] [ ] [ ]         
[ ] [ ] [ ]board 7  [ ] [ ] [ ]board 8  [ ] [ ] [ ]board 9  


1,enter which board
4
[1]1[ ]2[ ]3
[ ]4[2]5[ ]6
[ ]7[ ]8[ ]9
1,please enter a cell
(0 back to big board,-1 quit the game):
9
[ ] [ ] [ ]         [ ] [ ] [ ]         [ ] [ ] [ ]         
[ ] [ ] [ ]         [ ] [ ] [ ]         [ ] [ ] [ ]         
[ ] [ ] [ ]board 1  [ ] [ ] [ ]board 2  [ ] [ ] [ ]board 3  

[1] [ ] [ ]         [2] [ ] [ ]         [ ] [ ] [ ]         
[ ] [2] [ ]         [ ] [ ] [ ]         [ ] [ ] [ ]         
[ ] [ ] [1]board 4  [ ] [ ] [ ]board 5  [ ] [ ] [ ]board 6  

[ ] [ ] [ ]         [ ] [ ] [ ]         [ ] [ ] [ ]         
[ ] [ ] [ ]         [ ] [ ] [ ]         [ ] [ ] [ ]         
[ ] [ ] [ ]board 7  [ ] [ ] [ ]board 8  [ ] [ ] [ ]board 9  


2,enter which board
4
[1]1[ ]2[ ]3
[ ]4[2]5[ ]6
[ ]7[ ]8[1]9
2,please enter a cell
(0 back to big board,-1 quit the game):
4
[ ] [ ] [ ]         [ ] [ ] [ ]         [ ] [ ] [ ]         
[ ] [ ] [ ]         [ ] [ ] [ ]         [ ] [ ] [ ]         
[ ] [ ] [ ]board 1  [ ] [ ] [ ]board 2  [ ] [ ] [ ]board 3  

[1] [ ] [ ]         [2] [ ] [ ]         [ ] [ ] [ ]         
[2] [2] [ ]         [ ] [ ] [ ]         [ ] [ ] [ ]         
[ ] [ ] [1]board 4  [ ] [ ] [ ]board 5  [ ] [ ] [ ]board 6  

[ ] [ ] [ ]         [ ] [ ] [ ]         [ ] [ ] [ ]         
[ ] [ ] [ ]         [ ] [ ] [ ]         [ ] [ ] [ ]         
[ ] [ ] [ ]board 7  [ ] [ ] [ ]board 8  [ ] [ ] [ ]board 9  


1,enter which board
4
[1]1[ ]2[ ]3
[2]4[2]5[ ]6
[ ]7[ ]8[1]9
1,please enter a cell
(0 back to big board,-1 quit the game):
2
[ ] [ ] [ ]         [ ] [ ] [ ]         [ ] [ ] [ ]         
[ ] [ ] [ ]         [ ] [ ] [ ]         [ ] [ ] [ ]         
[ ] [ ] [ ]board 1  [ ] [ ] [ ]board 2  [ ] [ ] [ ]board 3  

[1] [1] [ ]         [2] [ ] [ ]         [ ] [ ] [ ]         
[2] [2] [ ]         [ ] [ ] [ ]         [ ] [ ] [ ]         
[ ] [ ] [1]board 4  [ ] [ ] [ ]board 5  [ ] [ ] [ ]board 6  

[ ] [ ] [ ]         [ ] [ ] [ ]         [ ] [ ] [ ]         
[ ] [ ] [ ]         [ ] [ ] [ ]         [ ] [ ] [ ]         
[ ] [ ] [ ]board 7  [ ] [ ] [ ]board 8  [ ] [ ] [ ]board 9  


2,enter which board
4
[1]1[1]2[ ]3
[2]4[2]5[ ]6
[ ]7[ ]8[1]9
2,please enter a cell
(0 back to big board,-1 quit the game):
6
this board has winner,now it is a big 2
[ ] [ ] [ ]         [ ] [ ] [ ]         [ ] [ ] [ ]         
[ ] [ ] [ ]         [ ] [ ] [ ]         [ ] [ ] [ ]         
[ ] [ ] [ ]board 1  [ ] [ ] [ ]board 2  [ ] [ ] [ ]board 3  

[2] [ ] [ ]         [2] [ ] [ ]         [ ] [ ] [ ]         
[ ] [ ] [ ]         [ ] [ ] [ ]         [ ] [ ] [ ]         
[ ] [ ] [ ]board 4  [ ] [ ] [ ]board 5  [ ] [ ] [ ]board 6  

[ ] [ ] [ ]         [ ] [ ] [ ]         [ ] [ ] [ ]         
[ ] [ ] [ ]         [ ] [ ] [ ]         [ ] [ ] [ ]         
[ ] [ ] [ ]board 7  [ ] [ ] [ ]board 8  [ ] [ ] [ ]board 9  


1,enter which board
6
[ ]1[ ]2[ ]3
[ ]4[ ]5[ ]6
[ ]7[ ]8[ ]9
1,please enter a cell
(0 back to big board,-1 quit the game):
1
[ ] [ ] [ ]         [ ] [ ] [ ]         [ ] [ ] [ ]         
[ ] [ ] [ ]         [ ] [ ] [ ]         [ ] [ ] [ ]         
[ ] [ ] [ ]board 1  [ ] [ ] [ ]board 2  [ ] [ ] [ ]board 3  

[2] [ ] [ ]         [2] [ ] [ ]         [1] [ ] [ ]         
[ ] [ ] [ ]         [ ] [ ] [ ]         [ ] [ ] [ ]         
[ ] [ ] [ ]board 4  [ ] [ ] [ ]board 5  [ ] [ ] [ ]board 6  

[ ] [ ] [ ]         [ ] [ ] [ ]         [ ] [ ] [ ]         
[ ] [ ] [ ]         [ ] [ ] [ ]         [ ] [ ] [ ]         
[ ] [ ] [ ]board 7  [ ] [ ] [ ]board 8  [ ] [ ] [ ]board 9  


2,enter which board
6
[1]1[ ]2[ ]3
[ ]4[ ]5[ ]6
[ ]7[ ]8[ ]9
2,please enter a cell
(0 back to big board,-1 quit the game):
5
[ ] [ ] [ ]         [ ] [ ] [ ]         [ ] [ ] [ ]         
[ ] [ ] [ ]         [ ] [ ] [ ]         [ ] [ ] [ ]         
[ ] [ ] [ ]board 1  [ ] [ ] [ ]board 2  [ ] [ ] [ ]board 3  

[2] [ ] [ ]         [2] [ ] [ ]         [1] [ ] [ ]         
[ ] [ ] [ ]         [ ] [ ] [ ]         [ ] [2] [ ]         
[ ] [ ] [ ]board 4  [ ] [ ] [ ]board 5  [ ] [ ] [ ]board 6  

[ ] [ ] [ ]         [ ] [ ] [ ]         [ ] [ ] [ ]         
[ ] [ ] [ ]         [ ] [ ] [ ]         [ ] [ ] [ ]         
[ ] [ ] [ ]board 7  [ ] [ ] [ ]board 8  [ ] [ ] [ ]board 9  


1,enter which board
6
[1]1[ ]2[ ]3
[ ]4[2]5[ ]6
[ ]7[ ]8[ ]9
1,please enter a cell
(0 back to big board,-1 quit the game):
2
[ ] [ ] [ ]         [ ] [ ] [ ]         [ ] [ ] [ ]         
[ ] [ ] [ ]         [ ] [ ] [ ]         [ ] [ ] [ ]         
[ ] [ ] [ ]board 1  [ ] [ ] [ ]board 2  [ ] [ ] [ ]board 3  

[2] [ ] [ ]         [2] [ ] [ ]         [1] [1] [ ]         
[ ] [ ] [ ]         [ ] [ ] [ ]         [ ] [2] [ ]         
[ ] [ ] [ ]board 4  [ ] [ ] [ ]board 5  [ ] [ ] [ ]board 6  

[ ] [ ] [ ]         [ ] [ ] [ ]         [ ] [ ] [ ]         
[ ] [ ] [ ]         [ ] [ ] [ ]         [ ] [ ] [ ]         
[ ] [ ] [ ]board 7  [ ] [ ] [ ]board 8  [ ] [ ] [ ]board 9  


2,enter which board
6
[1]1[1]2[ ]3
[ ]4[2]5[ ]6
[ ]7[ ]8[ ]9
2,please enter a cell
(0 back to big board,-1 quit the game):
4
[ ] [ ] [ ]         [ ] [ ] [ ]         [ ] [ ] [ ]         
[ ] [ ] [ ]         [ ] [ ] [ ]         [ ] [ ] [ ]         
[ ] [ ] [ ]board 1  [ ] [ ] [ ]board 2  [ ] [ ] [ ]board 3  

[2] [ ] [ ]         [2] [ ] [ ]         [1] [1] [ ]         
[ ] [ ] [ ]         [ ] [ ] [ ]         [2] [2] [ ]         
[ ] [ ] [ ]board 4  [ ] [ ] [ ]board 5  [ ] [ ] [ ]board 6  

[ ] [ ] [ ]         [ ] [ ] [ ]         [ ] [ ] [ ]         
[ ] [ ] [ ]         [ ] [ ] [ ]         [ ] [ ] [ ]         
[ ] [ ] [ ]board 7  [ ] [ ] [ ]board 8  [ ] [ ] [ ]board 9  


1,enter which board
6
[1]1[1]2[ ]3
[2]4[2]5[ ]6
[ ]7[ ]8[ ]9
1,please enter a cell
(0 back to big board,-1 quit the game):
8
[ ] [ ] [ ]         [ ] [ ] [ ]         [ ] [ ] [ ]         
[ ] [ ] [ ]         [ ] [ ] [ ]         [ ] [ ] [ ]         
[ ] [ ] [ ]board 1  [ ] [ ] [ ]board 2  [ ] [ ] [ ]board 3  

[2] [ ] [ ]         [2] [ ] [ ]         [1] [1] [ ]         
[ ] [ ] [ ]         [ ] [ ] [ ]         [2] [2] [ ]         
[ ] [ ] [ ]board 4  [ ] [ ] [ ]board 5  [ ] [1] [ ]board 6  

[ ] [ ] [ ]         [ ] [ ] [ ]         [ ] [ ] [ ]         
[ ] [ ] [ ]         [ ] [ ] [ ]         [ ] [ ] [ ]         
[ ] [ ] [ ]board 7  [ ] [ ] [ ]board 8  [ ] [ ] [ ]board 9  


2,enter which board
6
[1]1[1]2[ ]3
[2]4[2]5[ ]6
[ ]7[1]8[ ]9
2,please enter a cell
(0 back to big board,-1 quit the game):
6
this board has winner,now it is a big 2
[ ] [ ] [ ]         [ ] [ ] [ ]         [ ] [ ] [ ]         
[ ] [ ] [ ]         [ ] [ ] [ ]         [ ] [ ] [ ]         
[ ] [ ] [ ]board 1  [ ] [ ] [ ]board 2  [ ] [ ] [ ]board 3  

[2] [ ] [ ]         [2] [ ] [ ]         [2] [ ] [ ]         
[ ] [ ] [ ]         [ ] [ ] [ ]         [ ] [ ] [ ]         
[ ] [ ] [ ]board 4  [ ] [ ] [ ]board 5  [ ] [ ] [ ]board 6  

[ ] [ ] [ ]         [ ] [ ] [ ]         [ ] [ ] [ ]         
[ ] [ ] [ ]         [ ] [ ] [ ]         [ ] [ ] [ ]         
[ ] [ ] [ ]board 7  [ ] [ ] [ ]board 8  [ ] [ ] [ ]board 9  


player 2 win
Totally win :1 times
 
 
Do you want to play again?
enter 1 for TicTacToe
enter 2 for OrderAndChaos:
enter 3 for SuperTictactoe
enter 4 for exit game
4
bye-bye
Player : 1
Totally win :1 times
Player : 2
Totally win :1 times

Process finished with exit code 0

