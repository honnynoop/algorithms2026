import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static List<Integer>[] links;
    static int[] cnt;
    static boolean[] visited;
    static int max;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        // 그래프 초기화
        links = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            links[i] = new ArrayList<Integer>();
        }
        
        // 간선 정보 입력
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken()) - 1;
            int e = Integer.parseInt(st.nextToken()) - 1;
            links[s].add(e);
        }

        // 각 정점에서 DFS 수행
        max = -1;
        cnt = new int[N];
        for (int i = 0; i < N; i++) {
            visited = new boolean[N];
            dfs(i);
        }

        // 최대값 찾기
        for (int i = 0; i < N; i++) {
            max = Math.max(max, cnt[i]);
        }

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            if (max == cnt[i]) {
                sb.append(i + 1).append(" ");
            }
        }
        System.out.println(sb.toString());
    }

    static void dfs(int current) {
        visited[current] = true;
        
        for (int next : links[current]) {
            if (!visited[next]) {
                cnt[next]++;
                dfs(next);
            }
        }
    }
}