import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	static double[][] map;
	static int N;
	static double min;
	static double MM= 0.0f+Integer.MAX_VALUE;
	static class Edge implements Comparable<Edge>{
		int x;
		int y;
		double w;
		public Edge(int x, int y, double w) {
			super();
			this.x = x;
			this.y = y;
			this.w = w;
		}
		@Override
		public int compareTo(Edge o) {
			return Double.compare(this.w, o.w);
		}
	}
	static int [] p;
	static int [] r;
	static double result;
	static PriorityQueue<Edge> points;
	public static void main(String[] args) {
		Scanner scann=new Scanner(System.in);
		N=scann.nextInt();
		map=new double[N][2];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j <2; j++) {
				map[i][j]=scann.nextDouble();
			}
		}
		points=new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			for (int j = i+1; j <N; j++) {
				points.offer(new Edge(i, j, distance(i,j)));
			}
		}
		p=new int[N];
		r=new int[N];
		makeSet();
		int cnt=0;
		result=0;
		while(cnt!=N-1) {
			Edge edge=points.poll();
			if(union(edge.x, edge.y)) {
				cnt++;
				result+=edge.w;
			}
		}
		System.out.println(String.format("%.2f", result));
	}
	private static boolean union(int x, int y) {
		x=find(x);
		y=find(y);
		if(x==y)return false;
		if(r[x]<r[y]) {
			r[y]+=r[x];
			p[x]=y;
		}else {
			r[x]+=r[y];
			p[y]=x;
		}
		return true;
	}
	static int find(int x) {
		if(x==p[x]) return x;
		else return p[x]=find(p[x]);
	}
	static void makeSet() {
		for (int i = 0; i < N; i++) {
			p[i]=i;
			r[i]=1;
		}
	}
	static double distance(int i, int j) {
		return Math.sqrt((map[i][0]-map[j][0])*(map[i][0]-map[j][0])+
				(map[i][1]-map[j][1])*(map[i][1]-map[j][1]));
	}
}