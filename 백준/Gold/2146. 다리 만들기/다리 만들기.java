import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static int[] dr={-1,1,0,0};// 상하좌우
	static int[] dc={0,0,-1,1};
	
	static int N;
	static int [][] map;
	static int cnt;
	static int rmin=Integer.MAX_VALUE;
	public static void main(String[] args) {
		Scanner scann=new Scanner(System.in);
		N=scann.nextInt();
		map=new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j]=scann.nextInt();
			}
		}
		// 섬들 FF
		cnt=0;
		for (int i = 0; i < N; i++) {
			for (int j= 0; j < N; j++) {
				if(map[i][j]==1){
					cnt++;
					ff(i,j,cnt+1);
				}
			}
		}
		rmin=Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			for (int j= 0; j < N; j++) {
				if(map[i][j]>1) {
					int count=bfs(i,j,map[i][j]);
					rmin=Math.min(rmin, count);
				}
			}
		}
		
		System.out.println(rmin==Integer.MAX_VALUE?-1:(rmin));
		
		
	}
	
	// bfs 거리 공식
	static int bfs(int r1, int c1, int g) {
		int[][] visited=new int[N][N];
		Queue<int[]> que=new LinkedList<int[]>();
		que.offer(new int[]{r1,c1,0});
		visited[r1][c1]=1;
		while(!que.isEmpty()){
			int [] cur=que.poll();
			int cr=cur[0];
			int cc=cur[1];
			int cnt=cur[2];

			for (int d = 0; d < 4; d++) {
				int nr=cr+dr[d];
				int nc=cc+dc[d];
				if(!check(nr,nc))continue;
				if(visited[nr][nc]==1) continue;
				if(map[nr][nc]==g) continue;// 나하고 같은 group
				if(map[nr][nc]>0 && map[nr][nc]!=g && visited[nr][nc]==0){
					return cnt;
				}
				if(map[nr][nc]==0){ // 다른 
					que.offer(new int[]{nr,nc,cnt+1});
					visited[nr][nc]=1;
				}
			}
		}
		return Integer.MAX_VALUE;
	}
	static void ff(int r, int c, int g) {
		int[][] visited=new int[N][N];
		Queue<int[]> que=new LinkedList<int[]>();
		que.offer(new int[]{r,c});
		map[r][c]=g;
		visited[r][c]=1;
		while(!que.isEmpty()){
			int[] cur=que.poll();
			int cr=cur[0];
			int cc=cur[1];
			for (int d = 0; d < 4; d++) {
				int nr=cr+dr[d];
				int nc=cc+dc[d];
				if(!check(nr,nc))continue;
				if(visited[nr][nc]==0 && map[nr][nc]==1){
					que.offer(new int[]{nr,nc});
					map[nr][nc]=g;
					visited[nr][nc]=1;
				}
			}
		}
	}
	static boolean check(int r, int c) {
		return r>=0 && r<N && c>=0 && c<N;
	}
}


/*
[2, 2, 2, 0, 0, 0, 0, 3, 3, 3]
[2, 2, 2, 2, 0, 0, 0, 0, 3, 3]
[2, 0, 2, 2, 0, 0, 0, 0, 3, 3]
[0, 0, 2, 2, 2, 0, 0, 0, 0, 3]
[0, 0, 0, 2, 0, 0, 0, 0, 0, 3]
[0, 0, 0, 0, 0, 0, 0, 0, 0, 3]
[0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
[0, 0, 0, 0, 4, 4, 0, 0, 0, 0]
[0, 0, 0, 0, 4, 4, 4, 0, 0, 0]
[0, 0, 0, 0, 0, 0, 0, 0, 0, 0]

*/