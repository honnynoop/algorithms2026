class Solution {
    static int N; //4<=N<=12
		static int[] cols;
		static int[] dia;
		static int[] undia;
		static int nums;
		public int solution(int n) {
			N=n;
			cols=new int[N+1];
			dia=new int[2*N+1];
			undia=new int[2*N+1];
			nums=0;
			dfs(1); //1행부터 시작
	        return nums;
	    }
		private  void dfs(int row) {
			//basecase
			if(row==N+1){
				nums++;
				return ;
			}
			//고 칼럼시작
			for (int col = 1; col <= N; col++) {
				// 퀸이 이동한 적이없다면
				if((cols[col]==1 || dia[row+col]==1 ||  
	                       undia[N+(row-col)+1]==1) ) continue ;
					cols[col]=1;
					dia[row+col]=1;
					undia[N+(row-col)+1]=1;
					dfs(row+1);
					cols[col]=0;
					dia[row+col]=0;
					undia[N+(row-col)+1]=0;
			}
		}
}