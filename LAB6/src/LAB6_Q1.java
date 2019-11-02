
public class LAB6_Q1 {
	
	static String org[] = {
			"NYYNN",
			"NNNNN",
			"NNNYY",
			"NYNNN",
			"NNNNN"
	};
	
	public static int getSalary(int eid, int[] memo) {
		if (memo[eid] != 0) return memo[eid];
		int ret = 0;
		char p[] = org[eid].toCharArray();
		for (int i = 0; i< p.length; i++) {
			if (i != eid && p[i] == 'Y')
				ret = ret + getSalary(i, memo);
		}
		ret = ret == 0? 1:ret;
		memo[eid] = ret;
		return ret;
	}
	
	public static int getSalary() {
		int[] memo = new int[org.length];
		int total = 0;
		for (int i = 0; i < memo.length; i++)
			memo[i] = 0;
		for (int i = 0; i < org.length; i++)
			total = total + getSalary(i, memo);
		return total;
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		int total = getSalary();
		System.out.println(total);
	}

}
