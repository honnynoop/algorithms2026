import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
		static int count = 0;
		static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st1.nextToken());
		int S = Integer.parseInt(st1.nextToken());
		int M = Integer.parseInt(st1.nextToken());
		for (int i = 0; i < N; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());		
			int A = Integer.parseInt(st2.nextToken());
			int B = Integer.parseInt(st2.nextToken());
			int C = Integer.parseInt(st2.nextToken());
			if(A+B+C>=S && A>=M && B>=M && C>=M) {
				count++;
				sb = sb.append(A+" "+B+" "+C+" ");
			}
		}
		System.out.println(count);
		System.out.println(sb);
		

	}

}