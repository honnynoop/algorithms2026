import java.util.Scanner;

public class Main {

	static int N ,cnt;
	static int[][] map;
	static StringBuilder sb;
	public static void main(String[] args) {
		Scanner scann=new Scanner(System.in);
		N=scann.nextInt();
		map=new int[N][N];
		for (int i = 0; i < N; i++) {
			char [] cs=scann.next().toCharArray();
			for (int j = 0; j < N; j++) {
				map[i][j]=cs[j]-'0';
			}
		}
		sb=new StringBuilder();
		divideAndConquer(0,0,N);
		System.out.println(sb.toString());
	}
	public static boolean check(int r, int c, int width){
		for (int i = r; i <r+width; i++) {
			for (int j = c; j <c+width; j++) {
				if(map[i][j]!=map[r][c]){
					return false;
				}
			}
		}
		return true;
	}
	public static void divideAndConquer(int nr, int nc, int width) {
		if(check(nr, nc, width)){
			sb.append(map[nr][nc]);
		}else{
			//큰 부분에서 작은 부분이 시작할 때 (
			sb.append("(");
			int w=width/2;
			divideAndConquer(nr,nc,w);     //11
			divideAndConquer(nr,nc+w,w);   //1
			divideAndConquer(nr+w,nc,w);   //7
			divideAndConquer(nr+w,nc+w,w); //5
			sb.append(")");
		}
		
	}
	
}