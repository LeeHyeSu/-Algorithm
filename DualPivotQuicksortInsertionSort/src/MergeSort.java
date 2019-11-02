import java.util.Random;

public class MergeSort {
	static int length = 6400000;
	public static int[] sorted = new int[length];
	 
    public static void mergeSort(int[] arr, int m, int n) {
        int middle;
        if (m < n) {
            middle = (m + n) / 2;
            mergeSort(arr, m, middle);
            mergeSort(arr, middle + 1, n);
            merge(arr, m, middle, n);
        }
    }
 
    public static void merge(int[] arr, int m, int middle, int n) {
        int i, j, k, t;
 
        i = m;
        j = middle + 1;
        k = m;
 
        while (i <= middle && j <= n) {
            if (arr[i] <= arr[j])
                sorted[k] = arr[i++];
            else
                sorted[k] = arr[j++];
            k++;
        }
 
        if (i > middle) {
            for (t = j; t <= n; t++, k++)
                sorted[k] = arr[t];
        } else {
            for (t = i; t <= middle; t++, k++)
                sorted[k] = arr[t];
        }
 
        for (t = m; t <= n; t++)
            arr[t] = sorted[t];
 
    }

    public static void main(String[] args) {                      
    	Random r = new Random();
		int[] arr = new int[length];
		
		for(int i = 0; i < arr.length; i++) {
			arr[i] = r.nextInt(1000);
		}
		
		long start = System.currentTimeMillis();
        MergeSort.mergeSort(arr, 0, arr.length - 1);
        long end = System.currentTimeMillis(); //프로그램이 끝나는 시점 계산
		System.out.println( "실행 시간 : " + ( end - start )/1000.0 +"초"); //실행 시간 계산 및 출력
      
    }

}
