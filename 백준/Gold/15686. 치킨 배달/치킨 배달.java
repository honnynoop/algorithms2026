import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	static class L{
		int r;
		int c;
		public L(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		public L() {
		}
	}
	static int cal(L l1, L l2){
		return Math.abs(l1.r-l2.r)+Math.abs(l1.c-l2.c);
	}
	static int N,M;
	static int [][] map;
	static int []select;
	static int [][] dist; 
	static int result;
	static ArrayList<L> chickens;
	static ArrayList<L> homes;
	public static void main(String[] args) {
		
		Scanner scann=new Scanner(System.in);
		dist=new int[14][101];  // [chick][home]
		N=scann.nextInt();
		M=scann.nextInt();
		map=new int[N][N];
		chickens=new ArrayList<>();
		homes=new ArrayList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j]=scann.nextInt();
				if(map[i][j]==1){
					homes.add(new L(i,j));
				}else if(map[i][j]==2){
					chickens.add(new L(i,j));
				}
			}
		}
		select=new int[M+1];
		// chick-> home 
		for (int i = 0; i < chickens.size(); i++) {
			for (int j = 0; j <homes.size(); j++) {
				dist[i][j]=cal(chickens.get(i), homes.get(j));
			}
		}
		result = Integer.MAX_VALUE;
		nCr(0,0);
		System.out.println(result);
	}
	public static void nCr(int start, int cnt) {
		
		if(cnt==M){
			result=Math.min(result, solve());
			return;
		}
		
		for (int i = start; i < chickens.size() ; i++) {
			select[cnt]=i;
			nCr(i+1, cnt+1);
			//select[cnt]=0;
		}
	}
	public static int solve() {
		int res=0;
		for (int i = 0; i < homes.size(); i++) {
			int min=Integer.MAX_VALUE;
			for (int j = 0; j < M; j++) {
				min=Math.min(min, dist[select[j]][i]);
			}
			res+=min;
		}
		
		return res;
	}
}