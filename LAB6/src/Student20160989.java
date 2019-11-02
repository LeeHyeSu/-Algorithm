import java.util.Scanner;

public class Student20160989 {
	static int MAX_CLOCK = 16;
	static int MAX_SWITCH = 10;
	static int MAX_REACTION = 10;
	static int[] clock = new int[MAX_CLOCK];
	static int[][] syncSwitch = new int[MAX_SWITCH][MAX_REACTION];

	static boolean isAllNoon() {
		for(int i = 0; i < clock.length; i++) {
			if(clock[i] != 12) return false;
		}
		return true;
	}
	
	static void pushSwitch(int switchNum) {
		for(int i = 0; i < MAX_REACTION; i++) {
			if(syncSwitch[switchNum][i] >= 0) {
				clock[syncSwitch[switchNum][i]] += 3;
				if(clock[syncSwitch[switchNum][i]] > 12) {
					clock[syncSwitch[switchNum][i]] = 3;
				}
			}
		}
	}
	
	static int solve(int[] items, int[] bucket, int k) {
		int count = 9999;
		if(k == 0) {
			if(isAllNoon()) {
				count = 0;

				for(int i = 0; i < bucket.length - k; i++) {
					count += bucket[i];
				}
			}
			return count;
		}
		
		int lastIndex = bucket.length - k - 1;

		for(int i = 0; i < items.length; i++) {
			bucket[lastIndex+1] = items[i];
			count = Math.min(count, solve(items, bucket, k-1));
			pushSwitch(lastIndex+1);
		}
		
		return count;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner sc = new Scanner(System.in);
		 int[] items = {0, 1, 2, 3};
		 int[] bucket = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		 
		 for(int i = 0; i < 10; i++) {
			 int n = sc.nextInt();
			 int c = sc.nextInt();
			 for(int j = 0; j < c; j++) {
				 syncSwitch[n][j] = sc.nextInt();
			 }
			 for(int k = c; k < MAX_REACTION; k++) {
				 syncSwitch[n][k] = -1;
			 }
		 }

		 for(int i = 0; i < MAX_CLOCK; i++) {
			 clock[i] = sc.nextInt();
		 }

		 System.out.println(solve(items, bucket, 10));
	}

}
