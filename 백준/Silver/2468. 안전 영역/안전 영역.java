import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N;
	static int[][] map, copy;
	static int max,min;
	static int maxValue;
	public static void main(String[] args) {
		Scanner scann=new Scanner(System.in);
		N=scann.nextInt();
		map=new int[N][N];
		max=-200;
		min=200;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j]=scann.nextInt();
				max=Math.max(max, map[i][j]);
				min=Math.min(min, map[i][j]);
			}
		}// 읽기
		maxValue=-2000;
		for (int k = 0; k <max+1; k++) {
			
			copy=new int[N][N];
			for (int i = 0; i < N; i++) {
				System.arraycopy(map[i], 0, copy[i], 0, N);
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(map[i][j]>k) {
						copy[i][j]=1;
					}else {
						copy[i][j]=0;
					}
				}
			}//물 높이 표시
			int group=0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j <N; j++) {
					if(copy[i][j]==1) {  
						group++;
						dfs(i,j,group+1,copy); 
					}
				}
			}
			maxValue=Math.max(maxValue, group);
		}
		System.out.println(maxValue);
		
	}
	static int[] dr= {-1,0,1,0};
	static int[] dc= {0,1,0,-1};
	private static void dfs(int r, int c,  int g, int[][]map) {
		map[r][c]=g;
		for (int d = 0; d < 4; d++) {
			int nr=r+dr[d];
			int nc=c+dc[d];
			if(!check(nr,nc))continue;
			if(map[nr][nc]==1) {// 같은색
				dfs(nr,nc,g,map);
			}
		}
	}
	private static boolean check(int r, int c) {
		return r>=0 && r<N && c>=0 && c<N;
	}

}