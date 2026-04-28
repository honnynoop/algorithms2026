import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	static int N,K;
	//static int[] divide;
	static List<Integer> divides;
	//10000*4=40KB
	public static void main(String[] args) {
		
		Scanner scann=new Scanner(System.in);
		N=scann.nextInt();
		K=scann.nextInt();
		//divide=new int[N+1];
		divides=new ArrayList<>();
		for (int i = 1; i < N+1; i++) {
			if(N%i==0) {
				divides.add(i);
			}
		}
		// 1 5 25 k=4
		if(K>divides.size()) {
			System.out.println(0);
		}else {
			System.out.println(divides.get(K-1));
		}
		
	}

}