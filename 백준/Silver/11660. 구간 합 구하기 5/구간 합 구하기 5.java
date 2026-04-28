import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] sums = new int[n+1][n+1];
		
		for(int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=n; j++) {
				sums[i][j] = 
						Integer.parseInt(st.nextToken()) 
						+ sums[i-1][j]
						+ sums[i][j-1] 
						- sums[i-1][j-1];
				
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			int a = sums[x1-1][y2];
			int b = sums[x2][y1-1] ;
			int c = sums[x1-1][y1-1];
			
			int answer = sums[x2][y2] - (a + b - c); 
			sb.append(answer);
			sb.append('\n');
			
		}
		System.out.println(sb);
		
		
	}

}