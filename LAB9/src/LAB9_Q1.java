
public class LAB9_Q1 {
	static int [][]map = {
		{1,1,1,1,1,1,1,1},
		{1,1,1,1,1,1,1,1},
		{1,1,1,1,1,1,1,1},
		{1,1,1,1,1,1,1,1},
		{1,1,1,1,1,1,1,1},
		{1,1,1,1,1,1,1,1},
		{1,1,1,1,1,1,1,2},
		{1,1,1,1,1,1,2,1}
	};
	
	public static boolean find(int x, int y) {
		
		if( x >= map.length ) return false;
		if( y >= map.length ) return false;
		
		if( x == map.length-1 && y == map.length-1 ) return true;
		
		if( find(x, y+map[x][y]) )
			return true;
		if( find(x+map[x][y], y) ) return true;
		return false;
	}
	
	static int[][] memo;
	public static boolean find_memo(int x, int y) {
		
		if( x >= map.length ) return false;
		if( y >= map.length ) return false;
		
		if( x == map.length-1 && y == map.length-1 ) return true;
		
		if( memo[x][y] != -1 ) return memo[x][y] == 1;
		memo[x][y] = 0;
		if( find(x, y+map[x][y]) ) {
			memo[x][y] = 1;
			return true;
		}
		if( find(x+map[x][y], y) ) { 
			memo[x][y] = 1;
			return true;
		}
		return false;
	}
	
	public static boolean find_dp(int x, int y) {
		
		int[][] dp = new int[map.length][map.length];
		for(int i = 0; i < map.length; i++)
			for(int j = 0; j < map.length; j++) 
				dp[i][j] = 0;
		
		dp[0][0] = 1;
		for(int i = 0; i < map.length; i++)
			for(int j = 0; j < map.length; j++) {
				if( dp[i][j] == 1) {
					if( i + map[i][j] < map.length )
						dp[i + map[i][j]][j] = 1;
					if( j + map[i][j] < map.length ) 
						dp[i][j + map[i][j]] = 1;
				}
			}
		
		return dp[map.length-1][map.length-1] == 1;
	}
	
	public static void main(String[] args) throws Exception {
		memo = new int[map.length][map.length];
		for(int i = 0; i < map.length; i++)
			for(int j = 0; j < map.length; j++)
				memo[i][j] = -1;
		
		System.out.println(find(0,0));
		System.out.println(find_memo(0,0));
		System.out.println(find_dp(0,0));
	}

}
