import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	static int T, N,M;
	static boolean[][] isVisit;
	static int ans;
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		T=Integer.parseInt(br.readLine().trim());
		for (int t = 1; t <= T; t++) {
			N=Integer.parseInt(br.readLine().trim());
			M=Integer.parseInt(br.readLine().trim());
			isVisit = new boolean[N + 1][N + 1];
			StringTokenizer st=null;
			for (int i = 0; i < M; i++) {
				st=new StringTokenizer(br.readLine());
				int s=Integer.parseInt(st.nextToken());
				int e=Integer.parseInt(st.nextToken());
				isVisit[s][e]=true;
			}
			
			for (int k = 1; k <= N; k++) {
	            for (int i = 1; i <= N; i++) {
	                for (int j = 1; j <= N; j++) {
	                    isVisit[i][j] = (isVisit[i][j] || (isVisit[i][k] && isVisit[k][j]));
	                }
	            }
	        }
			ans=0;
	        for (int i = 1; i <= N; i++) {
	            if(isKnow(i)) ans++;
	        }
	        System.out.println("#"+t+" "+ans);
	    }
	}
	    
    static boolean isKnow(int x){
        for(int i = 1; i <= N; i++){
            if(!isVisit[i][x] && !isVisit[x][i] && i != x) return false;
        }
        return true;
    }
}
