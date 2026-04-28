import java.util.Scanner;
public class Main {

	static int N, K;
	static int min;
	static int distance[] = new int[100001]; 
	public static void main(String[] args) {
		Scanner scann=new Scanner(System.in);
		N=scann.nextInt();
		K=scann.nextInt();
		if(N >= K) {
			System.out.println(N-K);
			return;
		}
		
		for(int i=0; i<N; i++) {
			distance[i] = N-i;
		}
		
		DP();
		System.out.print(distance[K]);
	} 
	
	private static void DP() {
		for(int i=N+1; i<=K; i++) {
			int min;
			
			if(i % 2 == 0) {
				min = distance[i/2] + 1;
			}
			else {				
				min = Math.min(distance[(i+1)/2], distance[(i-1)/2]) +2;
			}
			
			distance[i] = Math.min(min,  distance[i-1]+1);
		}
	}
}