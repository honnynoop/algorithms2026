
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	static int N,M;
	static int[][] map;
	static int min;
	static int [] dr= {-1,0,1, 0};
	static int [] dc= { 0,1,0,-1};
	static int[] dcctv= {0,4,2,4,4,1};
	// type 1,2,3,4,5
	static int [][][] cctvtypes= {
			{{0}},
			{{0},{1},{2},{3}},
			{{0,2},{1,3}},
			{{0,1},{1,2},{2,3},{3,0}},
			{{3,0,1},{0,1,2},{1,2,3},{2,3,0}},
			{{0,1,2,3}}
	};
	static class CCTV{
		int r;
		int c;
		int type;
		public CCTV(int r, int c, int t) {
			this.r = r;
			this.c = c;
			this.type = t;
		}
	}
	static List<CCTV> cctvs;
	static boolean [] visited;
	static int cctvsize;
	public static void main(String[] args) {
		
		Scanner scann=new Scanner(System.in);
		N=scann.nextInt();
		M=scann.nextInt();
		cctvs=new ArrayList<>();
		map=new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j]=scann.nextInt();
				if(map[i][j]!=0 && map[i][j]!=6) {
					cctvs.add(new CCTV(i, j, map[i][j]));
				}
			}
		}// 읽기
		min=Integer.MAX_VALUE;
		cctvsize=cctvs.size();
		dfs(0,map);  // cctvsize 깊이 만큼 들어가보자.
		System.out.println(min==Integer.MAX_VALUE?0:min);
	}
	private static void dfs(int cnt, int[][] map2) {
		
		if(cnt==cctvsize) {
			//모든 cctv 방문 
			min=Math.min(min, countZero(map2));
			return ;
		}
		
		CCTV cctv=cctvs.get(cnt); //cnt번째 cctv를 가져와서
		int r=cctv.r;
		int c=cctv.c;
		int type=cctv.type;
		//지도를 수정해야 하기 때문에 복사한다.
		int[][] copy=new int[N][M];
		// 타입에 따라
		for (int i = 0; i < dcctv[type]; i++) { // cnt번째 cctv의 타입별로 비추는 방향
			for (int j = 0; j < N; j++) {
				System.arraycopy(map2[j], 0, copy[j], 0, M);
			}
			// 타입별로 한 번에 볼수 있는 d를 모두 본다. <-- -->면 2방향으로 진행한다.
			for (int j = 0; j < cctvtypes[type][i].length; j++) {
				gosharp(r,c,cctvtypes[type][i][j],copy);// type 종류에 따라 방향을 돌려본다. 
			}
			dfs(cnt+1,copy);
		}
		
	}
	private static int countZero(int[][] map2) {
		int cnt=0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map2[i][j]==0 ) {
					cnt++;
				}
			}
		}// 읽기
		return cnt;
	}
	private static void gosharp(int r, int c, int d, int[][] copy) {
		//한 방향으로 체크
		while(true) { //벽이나 밖으로 나갈때 까지
			int nr=r+dr[d];
			int nc=c+dc[d];
			if(!check(nr,nc)) break; //밖으로 나가면 끝
			if(copy[nr][nc]==6) break; //6벽
			if(copy[nr][nc]==0) copy[nr][nc]=9; //9 #표시
			r=nr;
			c=nc;
		}
	}
	private static boolean check(int r, int c) {
		return r>=0 && r<N && c>=0 && c<M;
	}

}
