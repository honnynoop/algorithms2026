import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

	static class NN implements Comparable<NN>{
		long x;

		public NN(long x) {
			this.x = x;
		}

		@Override
		public int compareTo(NN nn) {
			int r=Long.compare(Math.abs(x), Math.abs(nn.x));
			if(r==0) {
				return Long.compare(x, nn.x);
			}
			else return r;
		}
		
	}
	static int N;
	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(
				new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		PriorityQueue<NN> pq=new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			long x=Long.parseLong(br.readLine());
			if(x==0) {
				if(pq.size()==0) {
					System.out.println(0);
				}else {
					NN tt=pq.poll();
					System.out.println(tt.x);
				}
			}else {
				pq.offer(new NN(x));
			}
		}
	}

}