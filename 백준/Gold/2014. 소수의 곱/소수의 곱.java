import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scann=new Scanner(System.in);
		int K=scann.nextInt();
		int N=scann.nextInt();
		long[] P=new long[K];
		PriorityQueue<Long> pq=new PriorityQueue<>();
		for (int i = 0; i < K; i++) {
			P[i]=scann.nextInt();
			pq.offer(P[i]);
		}
        //읽기 end
		long h=0;
		for (int i = 0; i < N; i++) {
			h=pq.poll();  //가장 작은 수 빼기
			for (int j = 0; j <K; j++) {
				long v=h*P[j];
				pq.offer(v);
				if(h%P[j]==0){ break; }
			}
		}
		System.out.println(h);
	}

}