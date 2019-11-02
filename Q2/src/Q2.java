import java.util.*;

public class Q2 {
	
	public static int reverse(int n) {
		int n1 = 0;
		
		while( n != 0 ) {
			n1 = n1*10 + n%10;
			n /= 10;
		}
		
		return n1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int n1 = reverse( n );
		int cnt = 0;
		
		while( n != n1 ){
			n = n + n1;
			n1 = reverse( n );
			cnt++;
		}
		
		System.out.println( cnt + " " + n );
	}

}
