
public class Q14889 {
	
	public static void solution(int[] items, int[] bucket, int k) {
		if (k == 0) {
			int[] oppTeam = new int[bucket.length];
			int j = 0; int i = 0; int l = 0;
			for (i = 0; i < items.length; i++) {
				if (j < bucket.length && items[i] < bucket[j]) 
					oppTeam[l++] = items[i];
				else if (j == bucket.length)
					oppTeam[l++] = items[i];
				else
					j++;
			}
			System.out.print("[ ");
			for(i = 0; i < bucket.length; i++) 
				System.out.print(bucket[i] + " ");
			System.out.print("]");
			System.out.print("[ ");
			for(i = 0; i < oppTeam.length; i++)
				System.out.print(oppTeam[i] + " ");
			System.out.println("]");
			return;
		}
		int lastIndex = bucket.length - k - 1;
		
		for (int i = 0; i < items.length; i++) {
			if (lastIndex == -1) 
				bucket[lastIndex+1] = i;
			else if (bucket[lastIndex] < items[i])
				bucket[lastIndex+1] = i;
			else 
				continue;
			solution(items, bucket, k - 1);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 6;
		
		int[] players = new int[n];
		for (int i = 0; i < n; i++) 
			players[i] = i;
		int[] bucket = new int[n/2];
		bucket[0] = 0;
		solution(players, bucket, n/2 - 1);
	}

}
