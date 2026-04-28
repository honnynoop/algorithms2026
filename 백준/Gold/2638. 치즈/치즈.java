import java.util.Scanner;
public class Main {

	static int N,M;
	static int [][] map;
	static int [][] copy;
	static int[] dy={-1,0,1,0};
	static int[] dx={0,1,0,-1}; // 상우하좌
	
	public static void main(String[] args) {
		
		Scanner scann=new Scanner(System.in);
		N=scann.nextInt();
		M=scann.nextInt();
		map=new int[N][M];
		copy=new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j]=scann.nextInt();
			}
		}
		int checking=0;
	    while(counting(map)!=0){
	    	checking++;
	    	copyto(map,copy);
	    	boundary(0,0,2);
	    	//print(copy);
	    	for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(map[i][j]==1){
						go(i,j);
					}else continue;
				}
			}
	    	eat(map);
	    }
		System.out.println(checking);
	}
	private static void go(int y, int x) {
		if(!check(y, x)){ return ; }
		int tot=0;
		for (int d = 0; d < 4; d++) {
			int ny=y+dy[d];
			int nx=x+dx[d];
			if(!check(ny, nx)){continue; }
			if(copy[ny][nx]==2){
				tot++;
			}
		}
		map[y][x]=tot>=2?3:1;
	}
	public static void eat(int [][]m) {
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				if(m[i][j]==3){
					m[i][j]=0;
				}
			}
		}
	}
	private static void copyto(int [][] ma, int[][] co){
		for (int i = 0; i < N; i++) {
			System.arraycopy(ma[i], 0, co[i], 0, M);
		}
	}
	private static void boundary(int y, int x,int c ) {
		
		copy[y][x]=c;
		for (int d = 0; d < 4; d++) {
			int ny=y+dy[d];
			int nx=x+dx[d];
			if(!check(ny, nx)){continue; }
			if(copy[ny][nx]==0 ){ // 아직 방문안함
				boundary(ny,nx,c);
			}
		}
	}
	private static boolean check(int ty, int tx) {
		if(ty>=0 && ty<N && tx>=0 && tx<M) {
			return true;
		}else return false;
	}
	public static int counting(int [][]m) {
		int tot=0;
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				if(m[i][j]==1){
					tot++;
				}
			}
		}
		return tot;
	}
}
