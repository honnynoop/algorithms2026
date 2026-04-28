import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static class Node implements Comparable<Node>{
		int v;
		long w;
		public Node(int v, long w) {
			super();
			this.v = v;
			this.w = w;
		}
		@Override
		public String toString() {
			return "Node [v=" + v + ", w=" + w + "]";
		}
		@Override
		public int compareTo(Node o) {
			return Long.compare(w, o.w);
		}
		
	}
	static int N,M;
	static long K;
	static int[] stones;
	static long[] dp;
	static boolean [] disconn;
	static List<Node>[] edges;
	static boolean [] visited;
	static long min;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		K=Long.parseLong(st.nextToken());
		if(M<=1) {
			System.out.println("YES");
		}else {
			//adjacent list
			edges=new ArrayList[N+1];
			for (int i = 0; i < N+1; i++) {
				edges[i]=new ArrayList<>();
			}
			
			stones=new int[N+1];
			st=new StringTokenizer(br.readLine());
			for (int i = 1; i < N+1; i++) {
				stones[i]=Integer.parseInt(st.nextToken());
				edges[0].add(new Node(i, 0L+stones[i]));
				edges[i].add(new Node(0, 0L+stones[i]));
			}
			disconn=new boolean[N+1];
			for (int i = 1; i < M+1; i++) {
				st=new StringTokenizer(br.readLine());
				int s=Integer.parseInt(st.nextToken());
				int e=Integer.parseInt(st.nextToken());
				int s1=Math.min(s, e);
				int e1=Math.max(s, e);
				if(s1==1 && e1==N) {
					disconn[e1]=true;
				}else {
					disconn[s1]=true;
				}
				
			}
			for (int i = 1; i < N; i++) {
				if(!disconn[i]) {
					edges[i].add(new Node((i+1), 0L));
					edges[(i+1)].add(new Node(i, 0L));
				}
			}  
			if(!disconn[N]) {
				edges[1].add(new Node(N, 0L));
				edges[N].add(new Node(1, 0L));
			}
			min=0L;
			visited=new boolean[N+1];
			dp=new long[N+1];
			Arrays.fill(dp, Long.MAX_VALUE/100);
			dp[0]=0L;
			PriorityQueue<Node> pq=new PriorityQueue<>();
			pq.offer(new Node(0,0L));
			int cnt=0;
			while(!pq.isEmpty()) {
				Node cur=pq.poll();
				int v=cur.v;
				long w=cur.w;
				if(visited[v]) continue;
				visited[v]=true;
				min+=w;
				dp[v]=w;
				if(++cnt==N+1) break;
				for (int i = 0; i <edges[v].size() ; i++) {
					Node next=edges[v].get(i);
					if(visited[next.v]) continue;
					pq.offer(next);
				}
			}
			if(min<=K) {
				System.out.println("YES");
			}else {
				System.out.println("NO");
			}
		}
	}
	static boolean isConn(long[] dp2) {
		for (int i = 0; i < dp2.length; i++) {
			if(dp2[i]>=Long.MAX_VALUE/100) return false;
		}
		return true;
	}
	
}