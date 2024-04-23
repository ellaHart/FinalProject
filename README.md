# FinalProject


The Canadian Forest Service wants to do a simple simulation of the growth and pruning of forests. Each forest has a name and an arbitrary number of trees that are automatically indexed starting at 0 (hint: use an ArrayList). The trees are planted when they are 10' to 20' tall, and each tree has a individual growth rate of 10%-20% per year. A forest is reaped (by lumberjacks) on demand - all trees above a specifed height are cut down and replaced with new trees. The program must must hold the following information about each tree:

The species of tree - birch, maple, or fir (hint: use an enum)
The year of planting (hint: choose a suitable data type)
The height in feet (hint: use a double)
The growth rate per year (hint: use a double)
The forests to be simulated are provided to the program on the command line as forest names, such as Montane and Acadian. For each forest there should be a corresponding Comma Separated Values file in the current directory, such as Montane.csv and Acadian.csv (if a file is missing, the program reports and error and moves on to the next forest). For each forest the user interface to the simulation must allow the user to:
Print the current forest (tree heights with 2 decimal places, growth rates as percentages with 1 decimal place).
Add a new randomly generated tree
Cut down a tree by index.
Simulate a year's growth in the current forest.
Reap the current forest of trees over a user specified height, replacing the reaped trees with random new trees at the same index.
Save the forest (serialized) to a .db file named after the forest.
Load a different named forest from its .db file.
Move on to the next forest in the simulation.
Exit the program (ignoring any unprocessed forests)
The user interface must deal with invalid user input in a graceful way.
Here's what a sample run should look like (with the keyboard input shown in italics). The command line is Montane Acadian.

Welcome to the Forestry Simulation
----------------------------------
Initializing from Montane

(P)rint, (A)dd, (C)ut, (G)row, (R)eap, (S)ave, (L)oad, (N)ext, e(X)it : p

Forest name: Montane
     0 MAPLE   2012   80.00'  10.3%
     1 FIR     2020   12.00'  15.0%
     2 FIR     2024   22.00'  20.8%
     3 BIRCH   2000   99.00'  18.5%
     4 MAPLE   2005   77.00'   4.0%
There are 5 trees, with an average height of 58.00

(P)rint, (A)dd, (C)ut, (G)row, (R)eap, (S)ave, (L)oad, (N)ext, e(X)it : a

(P)rint, (A)dd, (C)ut, (G)row, (R)eap, (S)ave, (L)oad, (N)ext, e(X)it : P

Forest name: Montane
     0 MAPLE   2012   80.00'  10.3%
     1 FIR     2020   12.00'  15.0%
     2 FIR     2024   22.00'  20.8%
     3 BIRCH   2000   99.00'  18.5%
     4 MAPLE   2005   77.00'   4.0%
     5 MAPLE   2010   14.90'  14.4%
There are 6 trees, with an average height of 50.82

(P)rint, (A)dd, (C)ut, (G)row, (R)eap, (S)ave, (L)oad, (N)ext, e(X)it : c
Tree number to cut down: 3

(P)rint, (A)dd, (C)ut, (G)row, (R)eap, (S)ave, (L)oad, (N)ext, e(X)it : p

Forest name: Montane
     0 MAPLE   2012   80.00'  10.3%
     1 FIR     2020   12.00'  15.0%
     2 FIR     2024   22.00'  20.8%
     3 MAPLE   2005   77.00'   4.0%
     4 MAPLE   2010   14.91'  14.4%
There are 5 trees, with an average height of 41.18

(P)rint, (A)dd, (C)ut, (G)row, (R)eap, (S)ave, (L)oad, (N)ext, e(X)it : g

(P)rint, (A)dd, (C)ut, (G)row, (R)eap, (S)ave, (L)oad, (N)ext, e(X)it : p

Forest name: Montane
     0 MAPLE   2012   88.24'  10.3%
     1 FIR     2020   13.80'  15.0%
     2 FIR     2024   26.58'  20.8%
     3 MAPLE   2005   80.08'   4.0%
     4 MAPLE   2010   17.12'  14.4%
There are 5 trees, with an average height of 45.15

(P)rint, (A)dd, (C)ut, (G)row, (R)eap, (S)ave, (L)oad, (N)ext, e(X)it : r
Height to reap from: 75
Reaping the tall tree  MAPLE   2012   88.24'  10.3%
Replaced with new tree FIR     2015   11.87'  13.0%
Reaping the tall tree  MAPLE   2005   80.08'   4.0%
Replaced with new tree FIR     2015   19.63'  12.0%

(P)rint, (A)dd, (C)ut, (G)row, (R)eap, (S)ave, (L)oad, (N)ext, e(X)it : p

Forest name: Montane
     0 FIR     2015   11.87'  13.0%
     1 FIR     2020   13.80'  15.0%
     2 FIR     2024   26.58'  20.8%
     3 FIR     2015   19.63'  12.0%
     4 MAPLE   2010   17.12'  14.4%
There are 5 trees, with an average height of 17.78

(P)rint, (A)dd, (C)ut, (G)row, (R)eap, (S)ave, (L)oad, (N)ext, e(X)it : s

(P)rint, (A)dd, (C)ut, (G)row, (R)eap, (S)ave, (L)oad, (N)ext, e(X)it : n
Moving to the next forest
Initializing from Acadian

(P)rint, (A)dd, (C)ut, (G)row, (R)eap, (S)ave, (L)oad, (N)ext, e(X)it : p

Forest name: Acadian
     0 BIRCH   2014   72.00'  11.1%
     1 FIR     2017   15.00'  15.5%
     2 MAPLE   2023   32.00'  20.0%
     3 FIR     2001   95.00'  19.9%
     4 MAPLE   2005   67.00'   3.9%
There are 5 trees, with an average height of 56.20

(P)rint, (A)dd, (C)ut, (G)row, (R)eap, (S)ave, (L)oad, (N)ext, e(X)it : l
Enter forest name: Montane

(P)rint, (A)dd, (C)ut, (G)row, (R)eap, (S)ave, (L)oad, (N)ext, e(X)it : p

Forest name: Montane
     0 FIR     2015   11.87'  13.0%
     1 FIR     2020   13.80'  15.0%
     2 FIR     2024   26.58'  20.8%
     3 FIR     2015   19.63'  12.0%
     4 MAPLE   2010   17.12'  14.4%
There are 5 trees, with an average height of 17.78

(P)rint, (A)dd, (C)ut, (G)row, (R)eap, (S)ave, (L)oad, (N)ext, e(X)it : x

Exiting the Forestry Simulation
Here's a sample run testing errors (with the keyboard input shown in italics) ...
Welcome to the Forestry Simulation
----------------------------------
Initializing from Montane

(P)rint, (A)dd, (C)ut, (G)row, (R)eap, (S)ave, (L)oad, (N)ext, e(X)it : Z
Invalid menu option, try again
(P)rint, (A)dd, (C)ut, (G)row, (R)eap, (S)ave, (L)oad, (N)ext, e(X)it : p

Forest name: Montane
     0 MAPLE   2012  80.00'  10.3%
     1 FIR     2020  12.00'  15.0%
     2 FIR     2024  22.00'  20.8%
     3 BIRCH   2000  99.00'  18.5%
     4 MAPLE   2005  77.00'   4.0%
There are 5 trees, with an average height of 58.00

(P)rint, (A)dd, (C)ut, (G)row, (R)eap, (S)ave, (L)oad, (N)ext, e(X)it : c
Tree number to cut down: three
That is not an integer
Tree number to cut down: 27
Tree number 27 does not exist

(P)rint, (A)dd, (C)ut, (G)row, (R)eap, (S)ave, (L)oad, (N)ext, e(X)it : r
Height to reap from: ninety
That is not an integer
Height to reap from: 20
Reaping the tall tree  MAPLE   2012  80.00'  10.3%
Replaced with new tree MAPLE   2003  11.72'  16.3%
Reaping the tall tree  FIR     2024  22.00'  20.8%
Replaced with new tree BIRCH   2000  12.43'  14.8%
Reaping the tall tree  BIRCH   2000  99.00'  18.5%
Replaced with new tree FIR     2016  16.14'  15.6%
Reaping the tall tree  MAPLE   2005  77.00'   4.0%
Replaced with new tree FIR     2003  15.75'  15.8%

(P)rint, (A)dd, (C)ut, (G)row, (R)eap, (S)ave, (L)oad, (N)ext, e(X)it : n
Moving to the next forest
Initializing from NonExistent
Error opening/reading NonExistent.csv
Initializing from Acadian

(P)rint, (A)dd, (C)ut, (G)row, (R)eap, (S)ave, (L)oad, (N)ext, e(X)it : p

Forest name: Acadian
     0 BIRCH   2014  72.00'  11.1%
     1 FIR     2017  15.00'  15.5%
     2 MAPLE   2023  32.00'  20.0%
     3 FIR     2001  95.00'  19.9%
     4 MAPLE   2005  67.00'   3.9%
There are 5 trees, with an average height of 56.20

(P)rint, (A)dd, (C)ut, (G)row, (R)eap, (S)ave, (L)oad, (N)ext, e(X)it : l
Enter forest name: LostInThe
Error opening/reading LostInThe.db
Old forest retained

(P)rint, (A)dd, (C)ut, (G)row, (R)eap, (S)ave, (L)oad, (N)ext, e(X)it : x

Exiting the Forestry Simulation
You must ...
Do an object oriented analysis and design (no marks for a structure chart or algorithm design, but if you are smart you'll do that to help you produce your code).
After you have completed your analysis and design, implement the program in stylish Java (including Javadoc documentation). Your program must reflect your design. Your program must do what the "hint"s say. Restriction: Only the class containing the main method may have a Scanner object (the keyboard variable).
Keep everything in a GitHub repository.
Your must submit in Blackboard:
Object-oriented analysis and design documents.
A .zip of your project.
You must sit with the TA when (s)he runs your program in the lab session so you can see together how well it works.
Your program will be assessed on:

Stored in GitHub - 1%
OO Analysis and Design - 2%
Performance to specification - 11%
Use of classes and files - 3%
Programming style - 3%
... using this marking scheme.
Please review the policies on assessment in the administration document.

The project is due at the start of your lab session on 29th April (for those with a lab on Tuesday, attend any lab that Monday). If you plan to be away on the 29th April then demonstrate it in your lab of the week starting 22nd April. No Zoom demonstrations. No extensions after the 29th. Get it done by the 22nd in case you get sick, have a family emergency, your computer dies, anything. No extensions. I don't care if you have a Zulu spear piercing your chest. No extensions.
