import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scann=new Scanner(System.in);
		int M=scann.nextInt();
		int N=scann.nextInt();
		long sum=0L;
		boolean isF=false;
		int first=0;
		for (int i = M; i < N+1; i++) {
			if(isP(i)){
				sum+= (0L+i);
				if(!isF) {
					first=i;
					isF=true;
				}
			}
		}
		if(sum==0){
			System.out.println(-1);
		}else{
			System.out.println(sum);
			System.out.println(first);
		}
	}
	public static boolean isP(int n){
		if(n==1){ return false; 
		}else {
			for (int i = 2; i <= (int)(Math.sqrt(n)); i++) {
				if(n%i==0) return false;
			}
			return true;
		}
	}
}