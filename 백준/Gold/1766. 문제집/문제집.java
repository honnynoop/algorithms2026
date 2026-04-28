import java.util.*;
import java.io.*;
 
public class Main {
    static int V;   // Vertex
    static int E;   // Edge
 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
 
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        //진입차수
        int[] indegree = new int[V+1];
 
        for(int i=0; i<V+1; i++)
            list.add(new ArrayList<Integer>());
 
        for(int i=0; i<E; i++) {
            st = new StringTokenizer(br.readLine());
            // fromV -> inV
            int fromV = Integer.parseInt(st.nextToken());
            int inV = Integer.parseInt(st.nextToken());
            // inV 진입
            list.get(fromV).add(inV);
            // 진입차수를 증가시킨다. 
            indegree[inV]++;
        }
 
        topologicalSort(indegree, list);        
    }
 
    // 쉬운 문제를 먼저 풀기 위해서 우선순위 큐에 넣자
    static void topologicalSort(int[] indegree, List<List<Integer>> list) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
 
        for(int i=1; i<=V; i++) {
        	//진입차수가 0인것을 찾는다. 
            if(indegree[i] == 0)
                pq.offer(i);
        }
 
        while(!pq.isEmpty()) {
        	//진입차수가 0인곳을 찾아서 
            int cInv = pq.poll();
 
            for(int i : list.get(cInv)) {
            	// 진입차수가 0인것과 연결된 리스트의 진입차수를 감소
                indegree[i]--;
                // 다시 진입차수가 0인곳 찾기
                if(indegree[i] == 0)
                    pq.offer(i);
            }
 
            System.out.print(cInv + " ");
        }
    }
}