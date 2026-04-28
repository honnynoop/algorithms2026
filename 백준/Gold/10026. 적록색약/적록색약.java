import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int N;
	static int[][] normap;
	static int[][] irrmap;
	public static void main(String[] args) {
		Scanner scann=new Scanner(System.in);
		N=scann.nextInt();
		normap=new int[N][N];
		irrmap=new int[N][N];
		for (int i = 0; i < N; i++) {
			char[] rgb=scann.next().toCharArray();
			for (int j = 0; j < N; j++) {
				if(rgb[j]=='R') {
					normap[i][j]=-1;
					irrmap[i][j]=-1;
				}else if(rgb[j]=='G') {
					normap[i][j]=0;
					irrmap[i][j]=-1;
				}else if(rgb[j]=='B') {
					normap[i][j]=1;
					irrmap[i][j]=1;
				}
			}
		}// 읽기
		int group=0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j <N; j++) {
				if(normap[i][j]==-1 
						|| normap[i][j]==0
						|| normap[i][j]==1) {
					group++;
					dfs(i,j,normap[i][j],group+1,normap);  //2group
				}
			}
		}
		System.out.print(group+" ");
		group=0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j <N; j++) {
				if(irrmap[i][j]==-1 
						|| irrmap[i][j]==1) {
					group++;
					dfs(i,j,irrmap[i][j],group+1,irrmap);  //2group
				}
			}
		}
		System.out.println(group);
	}
	static int[] dr= {-1,0,1,0};
	static int[] dc= {0,1,0,-1};
	private static void dfs(int r, int c, int color, int g, int[][]map) {
		map[r][c]=g;
		for (int d = 0; d < 4; d++) {
			int nr=r+dr[d];
			int nc=c+dc[d];
			if(!check(nr,nc))continue;
			if(map[nr][nc]==color) {// 같은색
				dfs(nr,nc,color,g,map);
			}
		}
	}
	private static boolean check(int r, int c) {
		return r>=0 && r<N && c>=0 && c<N;
	}

}