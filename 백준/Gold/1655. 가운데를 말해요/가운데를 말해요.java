import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(
				new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pqmin=new PriorityQueue<>();
		PriorityQueue<Integer> pqmax=new PriorityQueue<>(( o1,  o2)-> -(o1-o2));
		StringBuilder sb=new StringBuilder();
		for (int i = 0; i < N; i++) {
			int x=Integer.parseInt(br.readLine());
			if(pqmin.size()==pqmax.size()) {
				pqmax.offer(x);
			}else {
				pqmin.offer(x);
			}
			if(!pqmin.isEmpty() && !pqmax.isEmpty()) {
				if(pqmin.peek()<pqmax.peek()) {
					int temp=pqmin.poll();
					int temp2=pqmax.poll();
					pqmin.offer(temp2);
					pqmax.offer(temp);
				}
			}
			sb.append(pqmax.peek()).append("\n");
			//System.out.println(pqmax.peek());
		}
		System.out.println(sb.toString());
	}

}