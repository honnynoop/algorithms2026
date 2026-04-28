import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int T;
	static int N;
	static int Sr, Sc, Er, Ec;
	static int [][] map;
	static int[] dr= {-2,-2, 1,-1, 1,-1, 2, 2};
	static int[] dc= { 1,-1, 2, 2,-2,-2, 1,-1};
	static int count;
	public static void main(String[] args) {
		Scanner scann=new Scanner(System.in);
		T=scann.nextInt();
		for (int t = 1; t <= T; t++) {
			N=scann.nextInt();
			Sr=scann.nextInt();
			Sc=scann.nextInt();
			Er=scann.nextInt();
			Ec=scann.nextInt();
			map=new int[N][N];
			
			count=0;
			Queue<int[]> que=new LinkedList<int[]>();
			que.offer(new int[] {Sr, Sc, 1});
			map[Sr][Sc]=1;
			while(!que.isEmpty()) {
				int [] cur=que.poll();
				int r=cur[0];
				int c=cur[1];
				int dist=cur[2];
				if(r==Er && c==Ec) {
					count=dist-1;
					break;
				}
				for (int d = 0; d < 8; d++) {
					int nr=r+dr[d];
					int nc=c+dc[d];
					if(!check(nr,nc)) continue;
					if(map[nr][nc]!=0) continue;
					que.offer(new int[] {nr, nc, dist+1});
					map[nr][nc]=dist+1;
				}
			}
			System.out.println(count);
		}

	}
	static boolean check(int r, int c) {
		return r>=0 && r<N && c>=0 && c<N;
	}

}