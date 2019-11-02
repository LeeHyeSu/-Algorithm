import java.util.Scanner;

public class Student20160989Q3 {
	
	public static boolean hasAllOnes(String s) {
		char[] arr = s.toCharArray();
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] != '1') return false; 
		}
		return true;
	}
	
	public static int countOnes(String s) {
		return s.length();
	}
	
	public static String multi(String s, int c) {
		char[] ch_arr = s.toCharArray();
		int len = ch_arr.length;
		int[] arr = new int[len];
		int carry = 0;
		String[] st_arr = new String[len];
		String ret = "";
		
		for(int i = 0; i < len; i++) {
			arr[i] = carry + (ch_arr[len-i-1] - '0') * c;
		
			if(arr[i] > 9 && i != len-1) {
				carry = arr[i] / 10;
				arr[i] = arr[i] % 10;
			}
			else {
				carry = 0;
			}
		}
		
		for(int i = 0; i < len; i++) {
			st_arr[i] = String.valueOf(arr[len-i-1]);
			ret += st_arr[i];
		}
		
		return ret;
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		int c = 1;
		String t = s;

		while( !hasAllOnes( t ) ) {
			c++;
			t = multi(s, c);
		}
		
		System.out.println( countOnes(t) );
	}

}
