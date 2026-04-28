import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N,M, K=8;
	static int[][] map;
	static int min;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		map=new int[N][M];
		for (int i = 0; i < N; i++) {
			char[] cs=br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				if(cs[j]=='B') {
					map[i][j]=0;
				}else {
					map[i][j]=1;
				}
			}
		}
		min=Integer.MAX_VALUE;
		//로직
		for (int i = 0; i < N-K+1; i++) {
			for (int j = 0; j < M-K+1; j++) {
				min=Math.min(min, go(i,j));
			}
		}
		System.out.println(min);
	}
	private static int go(int r, int c) {
		int bcnt=0;
		int wcnt=0;
		for (int i = r; i < r+K; i++) {
			for (int j = c; j < c+K; j++) {
				if(map[r][c]==0) {//b
					if((i%2==0 && j%2==0)||(i%2==1 && j%2==1)) {
						if(map[i][j]==1) {//w
							bcnt++;
						}
					}else {//w
						if(map[i][j]==0) {
							wcnt++;
						}
					}
				}else if(map[r][c]==1) {//w
					if((i%2==0 && j%2==0)||(i%2==1 && j%2==1)) { //w
						if(map[i][j]==0) {//b
							wcnt++;
						}
					}else {               //b
						if(map[i][j]==1) {//w
							bcnt++;
						}
					}
				}
			}
		}
		
		return Math.min(64-(bcnt+wcnt), (bcnt+wcnt));
	}

}