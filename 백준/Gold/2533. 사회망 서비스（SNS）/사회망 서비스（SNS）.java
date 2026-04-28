
import java.util.*;
import java.io.*;

public class Main {
	private static int N;
	private static List<Integer>[] arr;
	private static int answer;

	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("Test4.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		
		arr = new ArrayList[N + 1];
		for(int i = 1; i <= N; i++) {
			arr[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			arr[x].add(y);
			arr[y].add(x);
		}
		dfs(1, new boolean[N + 1]);
		System.out.println(answer);
	}
	
	private static boolean dfs(int node, boolean[] visited) {
		visited[node] = true;
		
		int count = 0;
		int lightCount = 0;
		
		for(int next : arr[node]) {
			if(visited[next]) continue;
			count++;
			
			if(dfs(next, visited)) {
				lightCount++;
			}
		}
		
		if(count != lightCount) {
			answer++;
			return true;
		}
		return false;
	}
}
