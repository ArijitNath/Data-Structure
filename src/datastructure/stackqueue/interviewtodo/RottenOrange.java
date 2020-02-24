package datastructure.stackqueue.interviewtodo;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOrange {

	public static void main(String[] args) {
		int[][] grid = {
							{2, 1, 0, 2, 1},
							{1, 0, 1, 2, 1},
							{1, 0, 0, 2, 1}
					   };
		
		RottenOrangeImpl ro = new RottenOrangeImpl(grid);
		System.out.println(ro.check());
	}
}

class RottenOrangeImpl {
	private int[][] grid;
	private Queue<Orange> queue;
	
	public RottenOrangeImpl(int[][] grid) {
		this.grid = grid;
		queue = new LinkedList<>();
	}
	
	public int check() {
		
		int gridLayer = 0;
		
		for(int i = 0; i < grid.length; i++) {
			for(int j = 0; j < grid[0].length; j++) {
				if(grid[i][j] == 2) {
					queue.add(new Orange(i, j, 0));
				}
			}
		}
		
		while( !queue.isEmpty() ) {
			Orange rottenOrange = queue.peek();
			
			if( rottenOrange.getLayer() == gridLayer ) {
				this.makeAdjacentRotten(rottenOrange.getX(), rottenOrange.getY(), rottenOrange.getLayer());
			}
			else if( rottenOrange.getLayer() > gridLayer ) {
				gridLayer++;
				continue;
			}
			
			queue.poll();
		}
		
		for(int []row : grid) {
			for(int col : row) {
				if( col == 1)
					return -1;
			}
		}
		
		return gridLayer;
	}
	
	private void makeAdjacentRotten(int i, int j, int layer) {
		int iPlusOne = i + 1;
		int iMinusOne = i - 1;
		int jPlusOne = j + 1;
		int jMinusOne = j - 1;
		
		if( iMinusOne >= 0 ) {
			if( grid[iMinusOne][j] == 1 ) {
				grid[iMinusOne][j] = 2;
				queue.add(new Orange(iMinusOne, j, layer + 1));
			}
		}
		
		if( iPlusOne < grid.length ) {
			if( grid[iPlusOne][j] == 1 ) {
				grid[iPlusOne][j] = 2;
				queue.add(new Orange(iPlusOne, j, layer + 1));
			}
		}
		
		if( jMinusOne >= 0) {
			if( grid[i][jMinusOne] == 1 ) {
				grid[i][jMinusOne] = 2;
				queue.add(new Orange(i, jMinusOne, layer + 1));
			}
		}
		
		if( jPlusOne < grid[0].length ) {
			if( grid[i][jPlusOne] == 1 ) {
				grid[i][jPlusOne] = 2;
				queue.add(new Orange(i, jPlusOne, layer + 1));
			}
		}
	}
	
	class Orange {
		private int x;
		private int y;
		private int layer;
		
		public Orange(int x, int y, int layer) {
			super();
			this.x = x;
			this.y = y;
			this.layer = layer;
		}

		public int getX() { return x; }
		public void setX(int x) { this.x = x; }
		public int getY() { return y; }
		public void setY(int y) { this.y = y; }
		public int getLayer() {	return layer; }
		public void setLayer(int layer) { this.layer = layer; }	
	}
	
}