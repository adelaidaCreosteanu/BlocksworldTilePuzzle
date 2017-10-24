# BlocksworldTilePuzzle
My solution to intelligent systems coursework (semester 1 of year 2).


This program implements the following types of search: breadth-first, depth-first, iterative deepening, A* heuristic. The problem to solve
has similar mechanics to the 8-puzzle game:

On a board of size n, there are n-1 letter blocks (A,B,C,D...), an agent and the rest are empty tiles. The agent can move one tile at a 
time. When the agent moves on a tile, the tile that they move onto slides under them into the position that they just came from.
Their goal is to get all the letter blocks in an ordered tower on the bottom of the board.

This program will be used to study the performance of different search methods when varying problem difficulty.
