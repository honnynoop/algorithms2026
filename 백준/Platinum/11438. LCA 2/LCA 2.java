import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main{
    
    static int N, M;
    static List<Integer>[] adjList;
    static int[] depth;           // 각 노드의 깊이
    static int[][] parent;        // parent[i][j]: 노드 i의 2^j번째 조상
    static int maxLog;            // log2(N)의 올림값
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        // 최대 로그 값 계산
        maxLog = (int) Math.ceil(Math.log(N) / Math.log(2));
        
        // 초기화
        adjList = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList<>();
        }
        
        depth = new int[N+1];
        parent = new int[N+1][maxLog+1];
        
        // 간선 정보 입력
        StringTokenizer st;
        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adjList[a].add(b);
            adjList[b].add(a);
        }
        
        // DFS로 깊이와 직계 부모 계산
        dfs(1, 0, 0);
        
        // 바이너리 리프팅 테이블 채우기
        fillParentTable();
        
        // 쿼리 처리
        M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            System.out.println(lca(u, v));
        }
    }
    
    // DFS로 깊이와 직계 부모 계산
    static void dfs(int current, int prev, int currentDepth) {
        depth[current] = currentDepth;
        parent[current][0] = prev;  // 직계 부모 저장
        
        for (int next : adjList[current]) {
            if (next != prev) {
                dfs(next, current, currentDepth + 1);
            }
        }
    }
    
    // 바이너리 리프팅 테이블 채우기
    static void fillParentTable() {
        for (int j = 1; j <= maxLog; j++) {
            for (int i = 1; i <= N; i++) {
                // parent[i][j]: i의 2^j번째 조상은 i의 2^(j-1)번째 조상의 2^(j-1)번째 조상
                if (parent[i][j-1] != 0) {
                    parent[i][j] = parent[parent[i][j-1]][j-1];
                }
            }
        }
    }
    
    // 두 노드의 LCA 찾기
    static int lca(int u, int v) {
        // 항상 u의 깊이가 더 깊거나 같게 만들기
        if (depth[u] < depth[v]) {
            int temp = u;
            u = v;
            v = temp;
        }
        
        // u를 v와 같은 깊이로 올리기
        int diff = depth[u] - depth[v];
        for (int j = maxLog; j >= 0; j--) {
            if ((diff & (1 << j)) != 0) {
                u = parent[u][j];
            }
        }
        
        // u와 v가 같다면 그게 LCA
        if (u == v) return u;
        
        // 같이 올라가며 LCA 바로 아래까지 이동
        for (int j = maxLog; j >= 0; j--) {
            if (parent[u][j] != parent[v][j]) {
                u = parent[u][j];
                v = parent[v][j];
            }
        }
        
        // LCA는 바로 위 부모
        return parent[u][0];
    }
}