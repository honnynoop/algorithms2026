
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main{

	static int M, N,H;
	static int [][][] map;
	static int [][][] visited;
	static int[] dr={-1,0,1, 0,0,0};
	static int[] dc={ 0,1,0,-1,0,0};
	static int[] dz={0,0,0,0,1,-1};
	static int day;
	public static void main(String[] args) {
		
		Scanner scann=new Scanner(System.in);
		M=scann.nextInt();
		N=scann.nextInt();
		H=scann.nextInt();
		map=new int[H][N][M];
		visited=new int[H][N][M];
		Queue<int[]> que=new LinkedList<int[]>();
		for (int k = H-1; k >=0; k--) {
			for (int i = 0; i <N; i++) {
				for (int j = 0; j < M; j++) {
					map[k][i][j]=scann.nextInt();
					if(map[k][i][j]==1){
						que.offer(new int[]{k,i,j});//좌표
					}
				}
			}
		}
		day=tomato(que);
		System.out.println(day);
	}
	static int tomato(Queue<int[]> que) {
		
		while(!que.isEmpty()){  //1 익은 토마토
			int[] cur=que.poll();
			int cz=cur[0];
			int cr=cur[1];
			int cc=cur[2];
			
			for (int d = 0; d < 6; d++) {
				int nr=cr+dr[d];
				int nc=cc+dc[d];
				int nz=cz+dz[d];
				if(!check(nr,nc,nz))continue; 
				// 온적없고 안익은 토마토
				if(visited[nz][nr][nc]==0 && map[nz][nr][nc]==0){ 
					que.offer(new int[]{nz,nr,nc});//좌표
					map[nz][nr][nc]=1;
					visited[nz][nr][nc]=visited[cz][cr][cc]+1;
				}
			}
		}
		
		if(!isZero()){ //0이 없어
			return max();
		}else{
			return -1;
		}
		
	}
	static int max() {
		int max=Integer.MIN_VALUE;
		for (int k = 0; k < H; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					max=Math.max(max, visited[k][i][j]);
				}
			}
		}
		return max;
	}
	static boolean isZero() {
		for (int k = 0; k < H; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(map[k][i][j]==0){
						return true;
					}
				}
			}
		}
		return false;
	}
	static boolean check(int r, int c, int z) {
		return r>=0 && r<N && c>=0 && c<M && z>=0 && z<H ;
	}

}
