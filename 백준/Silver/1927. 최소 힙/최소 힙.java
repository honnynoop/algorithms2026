import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

	static class NNN implements Comparable<NNN>{
		int x;

		public NNN(int x) {
			this.x = x;
		}

		@Override
		public int compareTo(NNN nn) {
			int r=Integer.compare(x, nn.x);
			return r;
		}
		
	}
	static int N;
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(
				new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		PriorityQueue<NNN> pq=new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			int x=Integer.parseInt(br.readLine());
			if(x==0) {
				if(pq.size()==0) {
					System.out.println(0);
				}else {
					NNN tt=pq.poll();
					System.out.println(tt.x);
				}
			}else {
				pq.offer(new NNN(x));
			}
		}
	}

}