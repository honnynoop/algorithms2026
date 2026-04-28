import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int[] dy={-1,0,1,0};
	static int[] dx={0,1,0,-1}; // 상우하좌
	static int M,N, K;
	static int[][]map;
	static int cnt;
	static int [] count;
	public static void main(String[] args) {
		Scanner scann=new Scanner(System.in);
		M=scann.nextInt();
		N=scann.nextInt();
		K=scann.nextInt();
		map=new int[M][N];
		for (int i = 0; i < K; i++) {
			int sx=scann.nextInt();
			int sy=scann.nextInt();
			int ex=scann.nextInt();
			int ey=scann.nextInt();
			for (int j = sx; j < ex; j++) {
				for (int k = sy; k < ey; k++) {
					map[k][j]=1;
				}
			}
		}
		cnt=0;
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j]==0){
					cnt++;
					bfs(i,j ,cnt+1);
				}
			}
		}
		count=new int[cnt+1];
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 1; k <= cnt; k++) {
					if(map[i][j]==(k+1)){
						count[k]++;
					}
				}
			}
		}
		Arrays.sort(count);
		System.out.println(cnt);
		for (int i = 1; i <= cnt; i++) {
			System.out.print(count[i]+" ");
		}
		System.out.println();
		//print(map);
	}
	private static void bfs(int y, int x, int c) {
		Queue<int[]> que=new LinkedList<int[]>();
		que.offer(new int[]{y,x});
		map[y][x]=c;
		while(!que.isEmpty()){
			int[] curr=que.poll();
			int cy=curr[0];
			int cx=curr[1];
			for (int d = 0; d < 4; d++) {
				int ny=cy+dy[d];
				int nx=cx+dx[d];
				if(!check(ny, nx)){continue; }
				if(map[ny][nx]==0){
					map[ny][nx]=c;
					que.offer(new int[]{ny,nx});
				}
			}
		}
	}
	private static boolean check(int ty, int tx) {
		if(ty>=0 && ty<M && tx>=0 && tx<N) {
			return true;
		}else return false;
	}
	public static void print(int [][]m) {
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				System.out.print(m[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("--------------------");
	}
}
/*
5 7 3
0 2 4 4
1 1 2 5
4 0 6 2

*/