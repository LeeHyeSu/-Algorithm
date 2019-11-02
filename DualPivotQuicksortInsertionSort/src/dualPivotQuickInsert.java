import java.util.Random;

public class dualPivotQuickInsert {
	
	static int value = 17;
	static int length = 10000;
	
	public static void dualPivotQuickSort(int[] arr, int p, int r) {
		if(p < r) {
			if((r-p) < value) insertionSort(arr, p, r); 
			
			if(arr[p] > arr[r]) swap(arr, p, r);
			
			int n = p + 1, m = r - 1, k = n;
			while (k <= m) {
				if(arr[k] < arr[p]) {
					swap(arr, k, n);
					++n;
				} else if (arr[k] >= arr[r]) {
					while (arr[m] > arr[r] && k < m) --m;
					swap(arr, k, m);
					--m;
					if(arr[k] < arr[p]) {
						swap(arr, k, n);
						++n;
					}
				}
				++k;
			}
			--n; ++m;
			
			swap(arr, p, n); swap(arr, r, m);
			
			dualPivotQuickSort(arr, p, n - 1);
			dualPivotQuickSort(arr, n + 1, m - 1);
			dualPivotQuickSort(arr, m + 1, r);
		}
	}
	
	public static void insertionSort(int[] arr, int p, int r) {
		int temp = 0;
		int j = 0;
		
		for(int i = p; i < r; i++) {
			temp = arr[i];
			j = i;
			
			while(j > 0 && temp < arr[j-1]) {
				arr[j] = arr[j-1];
				j--;
			}
			arr[j] = temp;
		}
	}
	
	public static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Random r = new Random();
		int[] arr = new int[length];
		
		for(int i = 0; i < arr.length; i++) {
			arr[i] = r.nextInt();
		}
		
		long start = System.currentTimeMillis();
		dualPivotQuickSort(arr, 0, arr.length-1);
		long end = System.currentTimeMillis(); //프로그램이 끝나는 시점 계산
		System.out.println( "실행 시간 : " + ( end - start )/1000.0 +"초"); //실행 시간 계산 및 출력
	}

}
