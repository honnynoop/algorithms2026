import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int status;
	static Queue<Pos> q;
	static PriorityQueue<X> qq;
	static int contain;
	static int not_contain;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		q = new LinkedList<>();
		qq = new PriorityQueue<>();
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			q.add(new Pos(x, y));
		}
		while(q.peek().y>0) q.add(q.poll());
		q.add(q.peek());
		status = -1;
		int start_x = 0;
		int end_x = 0;
		while(!q.isEmpty()) {
			Pos p = q.poll();
			if(status==-1 && p.y>0) {
				start_x = p.x;
				status = 1;
			}else if(status==1 && p.y<0) {
				end_x = p.x;
				qq.add(new X(Math.min(start_x, end_x), true));
				qq.add(new X(Math.max(start_x, end_x), false));
				status = -1;
			}
		}
		contain = 0;
		not_contain = 0;
		int cnt = 0;
		while(!qq.isEmpty()) {
			X p = qq.poll();
			if(p.isStart) {
				cnt++;
				if(cnt==1) {
					contain++;
				}
				if(!qq.peek().isStart)not_contain++;
			}else cnt--;
		}
		System.out.println(contain+" "+not_contain);
	}
	
	static class X implements Comparable<X>{
		int x;
		boolean isStart;
		
		X(int x, boolean isStart){
			this.x = x;
			this.isStart = isStart;
		}

		@Override
		public int compareTo(X o) {
			return Integer.compare(x, o.x);
		}
		
	}
	
	static class Pos{
		int x;
		int y;
		Pos(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
}