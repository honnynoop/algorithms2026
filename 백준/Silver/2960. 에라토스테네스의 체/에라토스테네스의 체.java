import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int N,K;
	static int[]aris;
	public static void main(String[] args) {
		Scanner scann=new Scanner(System.in);
		N=scann.nextInt();
		K=scann.nextInt();
		aris=new int[N+1];
		int p=2;
		int cnt=0;
		Queue<Integer> nums=new LinkedList<>();
		Queue<Integer> other=new LinkedList<>();
		for (int j = 2; j < N+1; j++) {
			nums.offer(j);
		}
		
		int t=0;
		aa: while(true) {
			int size=nums.size();
			for (int i = 0; i < size ; i++) {
				int n=nums.poll();
				if(n%p==0) {
					cnt++;
				}else {
					other.offer(n);
				}
				if(cnt==K) { 
					t=n;
					break aa;
				}
			}
			nums=other;
			p=nums.peek();
			other=new LinkedList<>();
		}
		System.out.println(t);
	}
}