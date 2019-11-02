
public class Test {
	
	static void solve(int[] items, int[] bucket, int k) {
		if(k == 0) {
			for(int i = 0; i < bucket.length; i++) {
				System.out.print(bucket[i]);
			}
			System.out.println();
			return;
		}
		
		int lastIndex = bucket.length - k - 1;
		
		for(int i = 0; i < items.length; i++) {
			if(bucket.length == k) {
				bucket[0] = items[i];
				solve(items, bucket, k-1);
			} else if(bucket[lastIndex] < items[i]) {
				bucket[lastIndex+1] = items[i];
				solve(items, bucket, k-1);
			}
		}
	}

	public static void main(String[] args) {
		int[] items = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
		int[] bucket = new int[3];
		
		
		solve(items, bucket, bucket.length);
	}

}
