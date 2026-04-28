
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static int[] dr={-1,1,0,0};// 상하좌우
	static int[] dc={0,0,-1,1};
	
	static int N, M;
	static int [][] map;
	static int [][] copy;
	static int max;
	static ArrayList<int[]> lists=new ArrayList<>();
	public static void main(String[] args) {
		Scanner scann=new Scanner(System.in);
		N=scann.nextInt();
		M=scann.nextInt();
		map=new int[N][M];
		copy=new int[N][M];
		lists.clear();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j]=scann.nextInt();
				if(map[i][j]==0){
					lists.add(new int[]{i,j});
				}
			}
		}
		// 3곳
		max=-100000;
		int size=lists.size();
		nCr(size,0,0, new boolean[size]);
		System.out.println(max);
	}
	static void nCr(int n, int start, int count, boolean[] v) {
		if(count==3){
			for (int i = 0; i < N; i++) {
				System.arraycopy(map[i], 0, copy[i], 0, M);
			}
			for (int i = 0; i < n; i++) {
				if(v[i]){
					int[] tcr=lists.get(i);
					copy[tcr[0]][tcr[1]]=1;
				}
			}
			go();
			return ;
		}
		for (int i = start; i <n; i++) {
			v[i]=true;
			nCr(n,i+1, count+1,v);
			v[i]=false;
		}
		
	}
	static void go() {
		int cnt=0;
		for (int i = 0; i < N; i++) {
			for (int j= 0; j < M; j++) {
				if(copy[i][j]==2){
					cnt++;
					bfs(i,j,cnt+2);
				}
			}
		}
		int sum=0;
		for (int i = 0; i < N; i++) {
			for (int j= 0; j < M; j++) {
				if(copy[i][j]==0){
					sum++;
				}
			}
		}
		max=Math.max(max,sum);
	}
	static void bfs(int r, int c, int g) {
		int[][] visited=new int[N][M];
		Queue<int[]> que=new LinkedList<int[]>();
		que.offer(new int[]{r,c});
		copy[r][c]=g;
		visited[r][c]=1;
		while(!que.isEmpty()){
			int[] cur=que.poll();
			int cr=cur[0];
			int cc=cur[1];
			for (int d = 0; d < 4; d++) {
				int nr=cr+dr[d];
				int nc=cc+dc[d];
				if(!check(nr,nc))continue;
				if(visited[nr][nc]==0 && copy[nr][nc]==0){
					que.offer(new int[]{nr,nc});
					copy[nr][nc]=g;
					visited[nr][nc]=1;
				}
			}
		}
	}
	static boolean check(int r, int c) {
		return r>=0 && r<N && c>=0 && c<M;
	}
}
