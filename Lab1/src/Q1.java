import java.util.*;

public class Q1 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int carry = 0;
		int cnt = 0;
		
		while( a != 0 || b != 0) {
			int s = a % 10;
			int t = b % 10;
			
			carry = (s + t + carry) / 10;
			
			if ( carry == 1 ) cnt++;
			
			a = a/10;
			b = b/10;
		}
		System.out.println( cnt ); 
		sc.close();
	}

}
