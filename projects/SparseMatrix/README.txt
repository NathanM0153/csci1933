• Group member’s names and x500s 

Nathan Michel, MICHE570

• How to compile and run your program 

This program does not run.

• Any known bugs or defects in the program 

I don't have a damn clue how linked lists work beyond the abstract and nothing online, 
from my friends, or from the TAs (with their limited time) could help me implement them. 
Every other part of the project should be roughly correct, however I cannot test it for
obvious reasons.

• Any outside sources (aside from course resources) consulted for ideas used in the project, in 
the format: 

- Xander Clinton - help explaining linked lists and Part V space logic
- William Anderson - help explaining what project wanted, helped me not overthink constructor in MatrixEntry
- Ethan Zmuda - help explaining linked lists


Part V - Analysis and Comparison of Space Efficiency of your SparseIntMatrix class 

a. 
For an NxN matrix, there is a space requirement of 5*m for the SparseIntMatrix implementation.
(Justification: "Assume that for the MatrixEntry class, each of the following require 1 memory unit: row label,
column label, matrix element data, link to next row element, link to next column element")
For a standard 2D array implementation, there is a space requirement of N^2

b. 
At N = 100,000 and m = 1,000,000, SparseIntMatrix implementation has a space requirement of 5e6.
2D array implementation has a space requirement of 1e10. 
S.I.M implementation is faster by a factor of 2,000, or 9.995e9 units.

2D array implementation is more efficient when m < N^2 < 5m. In this case, any m value > 2e9 and <= 1e10.
Note that m > N^2 would cause an array OoB exception and thus is not functionally possible, thus the limitation.



I certify that the information contained in this README file is 
complete and accurate. I have both read and followed the course policies in the ‘Academic 
Integrity - Course Policy’ section of the course syllabus.” and type your name underneath.  

Nathan Michel


