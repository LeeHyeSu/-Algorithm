import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Student20160989 {
	
	static final int MOD = 987654321;
    static long[] dp = new long[10005];
    
    public static long solve(int N) {

        if (N == 0) {

            return 1;
        }

        if (N == 2) {

            return dp[2] = 1;
        }

        if (dp[N] > 0) {

            return dp[N];
        }

        long ret = 0;

        for (int i = 1; i < N; i += 2) {

            ret += solve(i - 1) * solve(N - (i + 1));
            ret %= MOD;
        }

        return dp[N] = ret;
        
	}

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        System.out.println(solve(N));
    }

}
