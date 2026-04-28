import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, K;
	static int [][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		map=new int[N+1][N+1];
		map[0][0]=1;
		map[1][0]=1;
		map[1][1]=1;
		for (int i = 2; i < N+1; i++) {
			map[i][0]=1;
			map[i][i]=1;
			for (int j = 1; j < i; j++) {
				map[i][j]=map[i-1][j-1]+map[i-1][j];
			}
		}
		System.out.println(map[N-1][K-1]);
	}

}