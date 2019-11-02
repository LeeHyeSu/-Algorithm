import java.util.*;

public class Q3 {
	
	public static boolean hasAllOnes(int n) {
		while( n != 0) {
			int t = n%10;
			if ( t != 1 ) return false;
			n = n/10;
		}
		return true;
	}
	
	public static int countOnes(int n) {
		int ret = 0;
		while( n != 0 ) {
			ret++;
			n /= 10;
		}
		return ret;
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int c = 1;
		int t = n;
		
		while( !hasAllOnes( t ) ) {
			c++;
			t = n*c;
		}
		
		System.out.println( countOnes(t) );
	}

}
