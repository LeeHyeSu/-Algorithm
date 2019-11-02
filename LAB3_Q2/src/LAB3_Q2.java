
public class LAB3_Q2 {

	public static void main(String[] args) {

		// TODO Auto-generated method stub
		
		int [] items = {1,-1};
		int target = 7;
		int k = 1;

		while (sum(k) < target)
			k++;

		while (true)	{
			int bucket[] = new int[k];
			if (sol(items, bucket, k, target))
				break;
			k++;
		}
	}

	public static int sum(int n)	{
		
		return n*(n+1)/2;
	}

	public static boolean sol(int []items, int []bucket, int k, int target)	{

		if (k == 0)	{
			int sum = 0;
			for (int i = 0; i < bucket.length; i++)
				sum += bucket[i] * (i+1);

			if (target == sum)	{
				for (int i = 0; i < bucket.length; i++)	{
					if (bucket[i] == 1)
						System.out.print("+");
					else
						System.out.print("-");
					System.out.print(i+1);
				}

				System.out.println();
				return true;
			}

			return false;
		}

		int lastIndex = bucket.length - k - 1;
		boolean ret = false;

		for (int i = 0; i < items.length; i++)	{
			bucket[lastIndex+1] = items[i];
			ret = sol(items, bucket, k-1,target) || ret;
			//한번이라도 true가 되면 ret은 true
			//누적해서 or연산자로 비교(순서바뀌면 결과 다름 주의)
			//앞에 것이 true이면 뒤에 결과는 보지않기 때문이다.
		}
		
		return ret;
	}

}
