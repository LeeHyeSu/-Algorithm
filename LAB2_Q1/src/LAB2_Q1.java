import java.util.Scanner;

public class LAB2_Q1 {

	public static int getEncodedNumber_opt(int arr[]) {
		int max = 1;
		int min_idx = 0;
		
		for(int i = 0; i < arr.length; i++) {
			if(arr[min_idx] > arr[i]) 
				min_idx = i;
		}
		
		arr[min_idx]++;
		for(int i = 0; i < arr.length; i++) {
			max = max * arr[i];
		}
		arr[min_idx]--;
		return max;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int size = 3;
		int arr[] = new int[size];
		
		for(int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		
		System.out.println(getEncodedNumber_opt(arr));
	}

}
