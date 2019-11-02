
public class LAB3_Q1 {
	
	public static int[][] map;
	public static double east = 0.25;
	public static double west = 0.25;
	public static double south = 0.25;
	public static double north = 0.25;
	
	public static double visit(int x, int y, int n) {
		
		if ( map[x][y] == 1 ) return 0; //bound
		
		if ( n == 0 ) return 1;
		
		map[x][y] = 1;
		
		//branch
		double ret = visit(x+1, y, n-1) * east;
		ret = ret + visit(x-1, y, n-1) * west;
		ret = ret + visit(x, y+1, n-1) * north;
		ret = ret + visit(x, y-1, n-1) * south;
		
		map[x][y] = 0;
		
		return ret;
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		map = new int[21][];
		for(int i = 0; i < map.length; i++) 
			map[i] = new int[21];
		for(int i = 0; i < map.length; i++) 
			for(int j = 0; j < map[i].length; j++)
				map[i][j] = 0;
		
		System.out.println( visit(10, 10, 2) );
	}

}
