import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import javax.swing.*;

public class MazeGridPanel extends JPanel{
	private int rows;
	private int cols;
	private Cell[][] maze;



	// extra credit
	public void genDFSMaze() {
		boolean[][] visited;
		Stack<Cell> stack  = new Stack<Cell>();
		Cell start = maze[0][0];
		stack.push(start);
	}

	//homework
	public void solveMaze() {
		Stack<Cell> stack  = new Stack<Cell>();
		Cell start = maze[0][0];
		start.setBackground(Color.GREEN);
		Cell finish = maze[rows-1][cols-1];
		finish.setBackground(Color.RED);
		stack.push(start);
		while (stack.peek() != finish && !stack.isEmpty()) {
			Cell current = stack.peek();
			if(!current.northWall && !visited(current.row-1,current.col)){
				current.setBackground(Color.BLUE);
				stack.push(maze[current.row-1][current.col]);
			}else if (!current.southWall && !visited(current.row+1,current.col)){
				current.setBackground(Color.BLUE);
				stack.push(maze[current.row+1][current.col]);


			} else if (!current.westWall && !visited(current.row,current.col-1)){
				current.setBackground(Color.BLUE);
				stack.push(maze[current.row][current.col-1]);


			}else if (!current.eastWall && !visited(current.row,current.col+1)){
				current.setBackground(Color.BLUE);
				stack.push(maze[current.row][current.col+1]);


			}

			else{
				current.setBackground(Color.GRAY);
				stack.pop();

			}

		}

		//

			//for (int i = 0; i < 3 ; i++) {
			//Cell current = stack.peek();
			//current.setBackground(Color.GREEN);
			//stack.push(maze[current.row][current.col+1]);


		//}
		//for (int i = 0; i < 13 ; i++) {
		//	Cell current = stack.peek();
		//	current.setBackground(Color.GRAY);
		//	stack.push(maze[current.row+1][current.col+1]);


			}







	

	


	public boolean visited(int row, int col) {
		Cell c = maze[row][col];
		Color status = c.getBackground();
		if(status.equals(Color.WHITE)  || status.equals(Color.RED)  ) {
			return false;
		}


		return true;


	}


	public void genNWMaze() {
		
		for(int row = 0; row  < rows; row++) {
			for(int col = 0; col < cols; col++) {

				if(row == 0 && col ==0) {
					continue;
				}

				else if(row ==0) {
					maze[row][col].westWall = false;
					maze[row][col-1].eastWall = false;
				} else if(col == 0) {
					maze[row][col].northWall = false;
					maze[row-1][col].southWall = false;
				}else {
					boolean north = Math.random()  < 0.5;
					if(north ) {
						maze[row][col].northWall = false;
						maze[row-1][col].southWall = false;
					} else {  // remove west
						maze[row][col].westWall = false;
						maze[row][col-1].eastWall = false;
					}
					maze[row][col].repaint();
				}
			}
		}
		this.repaint();
		
	}

	public MazeGridPanel(int rows, int cols) {
		this.setPreferredSize(new Dimension(800,800));
		this.rows = rows;
		this.cols = cols;
		this.setLayout(new GridLayout(rows,cols));
		this.maze =  new Cell[rows][cols];
		for(int row = 0 ; row  < rows ; row++) {
			for(int col = 0; col < cols; col++) {

				maze[row][col] = new Cell(row,col);

				this.add(maze[row][col]);
			}

		}


		this.genNWMaze();
		this.solveMaze();
		
	}




}
