import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Handshaking {
	
    static long[] dp = null;
    
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        dp = new long[N+1];
        
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= N; i += 2) {
            for (int j = 1; j < i; j += 2) {
                dp[i] += dp[j-1] * dp[i - (j + 1)];
            }
        }

        System.out.println(dp[N]);

	}

}
