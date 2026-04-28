import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static class Cell implements Comparable<Cell>{
		int r;
		int c;
		int cost;
		public Cell() {}
		public Cell(int r, int c, int cost) {
			super();
			this.r = r;
			this.c = c;
			this.cost = cost;
		}
		@Override
		public int compareTo(Cell outer) {  //증가순 정렬
			return Integer.compare(this.cost, outer.cost);
		}
		
	}
	static int N;
	static int[][] map;
	static int[][] cost;
	static int[] dr={-1,1,0,0};
	static int[] dc={0,0,-1,1};
	
	public static void main(String[] args) {
		Scanner scann=new Scanner(System.in);
		int cnt=1;
		while(true){
			N=scann.nextInt();
			if(N==0){break ;}
			map=new int[N][N];
			cost=new int[N][N];
			for (int i = 0; i < N; i++) {
				Arrays.fill(cost[i], Integer.MAX_VALUE/100);
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j]=scann.nextInt();
				}
			}
			int result=bfs();
			System.out.println("Problem "+(cnt++)+": "+result);
		}

	}
	
	static int bfs() {
		PriorityQueue<Cell> que= new PriorityQueue<>();
		que.offer(new Cell(0,0,map[0][0]));
		cost[0][0]=map[0][0];
		while(!que.isEmpty()){
			Cell cur=que.poll();
			int cr=cur.r;
			int cc=cur.c;
			for (int d = 0; d < 4; d++) {
				int nr=cr+dr[d];
				int nc=cc+dc[d];
				if(!check(nr,nc))continue;
				if(cost[nr][nc]>cost[cr][cc]+map[nr][nc]){
					//작은값으로 갱신
					cost[nr][nc]=cost[cr][cc]+map[nr][nc];
					que.offer(new Cell(nr,nc,cost[nr][nc]));
				}
				
			}
		}
		return cost[N-1][N-1];
	}

	static boolean check(int nr, int nc) {
		return nr>=0 && nr<N && nc>=0 && nc<N;
	}

	
}
