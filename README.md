# **TTTGame**

The project is based on the game of Tic Tac Toe, contains 2 game options - the classic one and 9 in 1 variation:
- user-friendly interface built with Java Swing
- HashMap to store players' nicknames and scores, all the data saved in a dat.txt file
- single and two-player modes with 3 difficulty levels.

It is my first java project fully written by me. I'm pretty proud despite *of course* it is not perfect ;)

### Main objectives:
- to create a game, using Java Swing graphics library
- to use file handling, all nicknames and scores are saved in a dat.txt file and updated everytime the user plays
- to broad my Java knowledge without starting from basics.

### Description:
1. First window - the login window (Login class), where user can pick their in-game name and confirm their choice by clicking the button:
- if the chosen nick is used the first time in the game, it is added to the dat.txt and the starting number of points equals to 0
- if the chosen nick exists in the dat.txt file, points gained in the current session are added to the points collected by this player before
- implements ActionListener (to open the menu window when pressing the button)
- implements MouseListener (when the mouse enters the button its colors invert)
- used Swing components: JFrame, JButton, JTextField, JLabel, ImageIcon to build the window
- there are some rules the nickname should fit in - cannot be longer than 20 characters and cannot contain ";" character (it is used in the dat.txt to separate the data)
- the user has to put in the correct nickname, otherwise they aren't allowed to open the menu.
2. Data class - 

### Solutions I am proud of:
- adding the buttons' colors invertion when mouse enters them
- personalized buttons which aren't focusable and don't have any weird, old-fashioned borders
- clearly made, user-friendly interface with self-designed appearance
- refreshing system to have the ranking frame up-to-date after every game

### Things to work on:
- of course, the game is not perfect starting from the appearance design, ending of its functionality, but the project is working well, it is finished and abled to be used
- 