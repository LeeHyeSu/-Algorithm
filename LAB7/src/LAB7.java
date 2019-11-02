import java.util.Scanner;

public class LAB7 {
	
	//1-1
	static int max_sum_BF(int[] A) {
		int max = A[0];
		for (int i = 0; i < A.length; i++) {
			int local_max = A[i];
			int sum = A[i];
			for (int j = i+1; j < A.length; i++) {
				sum += A[j];
				if (local_max < sum) local_max = sum;
			}
			if (max < local_max) max = local_max;
		}
		return max;
	}
	
	//1-2
	static int max_sum_DC(int[] A, int l, int r) {
		int m = (l+r)/2;
		if (l == r) return A[l];
		int max = 0;
		int lv = max_sum_DC(A, l, m);
		int rv = max_sum_DC(A, m+1, r);
		max = lv > rv? lv:rv;
		int cv = 0;
		int local_max = A[m+1];
		int local_sum = 0;
		for (int i = m+1; i <= r; i++) {
			local_sum += A[i];
			if (local_max < local_sum) local_max = local_sum;
		}
		cv += local_max;
		local_max = A[m];
		local_sum = 0;
		for (int i = m; i >= l; i--) {
			local_sum += A[i];
			if (local_max < local_sum) local_max = local_sum;
		}
		cv += local_max;
		max = max > cv? max:cv;
		return max;
	}
	
	//1-3
	static int max_sum_DP(int[] A) {
		int[] maxEndsAt = new int[A.length];
		maxEndsAt[0] = A[0];
		int max = maxEndsAt[0];
		for (int i = 1; i < A.length; i++) {
			maxEndsAt[i] = maxEndsAt[i-1] + A[i];
			maxEndsAt[i] = maxEndsAt[i] > A[i]? maxEndsAt[i]:A[i];
			max = max > maxEndsAt[i]? max:maxEndsAt[i];
		}
		return max;
	}
	
	static long handshaking(int n) {
		long hand[] = new long[n+1];
		
		hand[0] = 1;
		hand[2] = 1;
		
		for (int i = 4; i <= n; i = i + 2) {
			long sum = 0;
			for (int j = 0; j < i; j = j + 2) 
				sum = sum + hand[j] * hand[i-j-2];
			hand[i] = sum;
		}
		return hand[n];
	}
	
	static long handshaking_r(int n) {
		if (n == 0 || n == 2) return 1;
		long sum = 0;
		for (int i = 0; i < n; i = i + 2) {
			sum = sum + handshaking_r(i) * handshaking_r(n-i-2);
		}
		return sum;
	}
	
	//2
	static long handshaking_memo(int n, long[] memo) {
		if (memo[n] != 0) return memo[n];
		if (n == 0 || n == 2) return 1;
		long sum = 0;
		for (int i = 0; i < n; i = i + 2) {
			sum = sum + handshaking_memo(i, memo) * handshaking_memo(n-i-2, memo);
		}
		memo[n] = sum;
		return memo[n];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int input;
		long[] memo;
		Scanner scan = new Scanner(System.in);
		input = scan.nextInt();
		
		memo = new long[input+1];
		for (int i = 0; i < input+1; i++)
			memo[i] = 0;
		
		System.out.println(handshaking(input));
		System.out.println(handshaking_r(input));
		System.out.println(handshaking_memo(input, memo));
	}

}
