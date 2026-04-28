import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int [] distance;
	static int V, E, K;
	
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
	
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(
				new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		V=Integer.parseInt(st.nextToken());
		E=Integer.parseInt(st.nextToken());
		st=new StringTokenizer(br.readLine());
		K=Integer.parseInt(st.nextToken());
		adj=new ArrayList[V];
		for (int i = 0; i < V; i++) {
			adj[i]=new ArrayList<>();
		}
		for (int i = 0; i < E; i++) {
			st=new StringTokenizer(br.readLine());
			int s=Integer.parseInt(st.nextToken());
			int e=Integer.parseInt(st.nextToken());
			int w=Integer.parseInt(st.nextToken());
			adj[s-1].add(new Edge(e-1, w));
		}
		points=new PriorityQueue<>();
		points.offer(new Edge(K-1, 0));
		distance=new int[V];
		Arrays.fill(distance, MM);
		checked=new boolean[V];
		distance[K-1]=0;
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
			if(distance[i]>=MM) {
				System.out.println("INF");
			}else {
				System.out.println(distance[i]);
			}
		}
	}

}