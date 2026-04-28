import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int[][] taste;
	
	static int diff;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		taste = new int[n][2];
		
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			taste[i][0] = Integer.parseInt(st.nextToken());
			taste[i][1] = Integer.parseInt(st.nextToken());
		}
		
		
		diff = Integer.MAX_VALUE;
		//subset은 포함된다 안된다
		subset(0,1,0);
		System.out.println(diff);
		
		
	}

	public static void subset(int cnt, int s, int b) {
		
		if(cnt == n) {
			if(b== 0) return;
			diff = (int) Math.min(diff, Math.abs(s-b));
			return;
		}
		
		subset(cnt+1, s*taste[cnt][0], b+taste[cnt][1]);
		subset(cnt+1, s, b);
	}
}