
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {

	static int V, E;
	static class Edge implements Comparable<Edge>{
		int v;
		int weight;
		public Edge(int v, int weight) {
			this.v = v;
			this.weight = weight;
		}
		@Override
		public int compareTo(Edge e) {
			return Integer.compare(this.weight, e.weight);
		}
	}
	static List<Edge> [] adj;

    public int solution(int n, int[][] costs) {
        V=n;
        E=costs.length;
        adj=new ArrayList[V];
		for (int i = 0; i < V; i++) {
			adj[i]=new ArrayList<>();
		}
		
		for (int i = 0; i < E; i++) {
			int s=costs[i][0];
			int e=costs[i][1];
			int w=costs[i][2];
			adj[s].add(new Edge(e, w));
			adj[e].add(new Edge(s, w));
		}// 읽기
    	int total=prim();
        return total;
    }
    private static int prim() {
		int min=0;
		boolean [] visited=new boolean[V+1];
		PriorityQueue<Edge> points=new PriorityQueue<>();
		points.offer(new Edge(0, 0));
		int cnt=0;
		while(!points.isEmpty()) {
			Edge edge=points.poll(); 
			if(visited[edge.v]) continue;
			min+=edge.weight;
			visited[edge.v]=true;
			if(++cnt==V) return min;  //10 간선 20 
			for (int i = 0; i < adj[edge.v].size(); i++) {
				Edge next=adj[edge.v].get(i);
				if(visited[next.v]) continue;
				points.offer(next);
			}
		}
		return min;
	}
    
}
