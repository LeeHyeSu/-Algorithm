import java.util.*;

public class Student20160989 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		double n = sc.nextDouble();
		double m = sc.nextDouble();
		
		String path = "";
		double a = 0, b = 0, c = 0, d = 0;
		
		if(n != m && n != 0 && m != 0 ) {
			if(n < m) {
				a = 0; b = 1; c = 1; d = 1;
				path += "L";
			}
			else if (n > m) {
				a = 1; b = 1; c = 1; d = 0;
				path += "R";
			}
		
			while(n/m != (a+c)/(b+d)) {
				if(n/m < (a+c)/(b+d)) {
					c = a+c;
					d = b+d;
					path += "L";
				}
				else {
					a = a+c;
					b = b+d;
					path += "R";
				}
			}
		}
		
		System.out.println(path);
	}

}
