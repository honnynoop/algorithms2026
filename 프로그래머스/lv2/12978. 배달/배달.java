import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {


	
	static int [] distance;
	static int V, E;
	
	static class Edge implements Comparable<Edge>{
		int v;
		int w;
		public Edge(int v, int w) {
			super();
			this.v = v;
			this.w = w;
		}
		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.w, o.w);
		}
	}
	static List<Edge>[] adj;
	static int MM=Integer.MAX_VALUE/1000;
	static boolean [] checked;
	
	static PriorityQueue<Edge> points;
	
	private static int cnt;
	
    public int solution(int N, int[][] road, int K) {

        cnt = 0;
        V=N;
        E=road.length;
        
        adj=new ArrayList[V];
		for (int i = 0; i < V; i++) {
			adj[i]=new ArrayList<>();
		}
		for (int i = 0; i < E; i++) {
			int s=road[i][0];
			int e=road[i][1];
			int w=road[i][2];
			adj[s-1].add(new Edge(e-1, w));
			adj[e-1].add(new Edge(s-1, w));
		}
		points=new PriorityQueue<>();
		points.offer(new Edge(0, 0));
		distance=new int[V];
		Arrays.fill(distance, MM);
		
		checked=new boolean[V];
		distance[0]=0;

		while(!points.isEmpty()) {
			Edge cur=points.poll();
			if(checked[cur.v]) continue;
			checked[cur.v]=true;
			for (Edge next:  adj[cur.v]) {
				if(checked[next.v]) continue;
				if(distance[next.v]>distance[cur.v]+next.w) {
					distance[next.v]=distance[cur.v]+next.w;
					points.offer(new Edge(next.v, distance[next.v]));
				}
			}
		}
		// 시작 k-> i 최소 거리합 distance[i]
		for (int i = 0; i < V; i++) {
			if(distance[i]<=K) {
				cnt++;
			}
		}
		
        int answer = cnt;
        return answer;
    }
 
}
