
public class Q14890 {
	
	public static int solution(int[][] matrix, int N, int L) {
		int ret = 0;
		
		for (int i = 0; i < N; i++) {
			int prev_h = matrix[i][0];
			int prev_c = 1;
			boolean flag = true;
			
			for(int j = 1; j < N; j++) {
				if (prev_h == matrix[i][j])
					prev_c += 1;
				if (prev_h + 1 < matrix[i][j] ||
						prev_h -1 > matrix[i][j]) {
					flag = false;
					break;
				}
				if (prev_h + 1 == matrix[i][j]) {
					if (prev_c < L) {
						flag = false;
						break;
					}
					prev_h = matrix[i][j];
					prev_c = 1;
				}
				else {
					int t_cnt = 0;
					int t_h = matrix[i][j];
					for ( ; j < N; j++) {
						if (t_h != matrix[i][j]) break;
						t_cnt++;
						if (t_cnt == L) break;
					}
					if (t_cnt == L) {
						prev_h = matrix[i][j];
						prev_c = 0;
						continue;
					}
					flag = false;
					break;
				}
			}
			if (flag)
				ret++;
		}
		
		return ret;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
