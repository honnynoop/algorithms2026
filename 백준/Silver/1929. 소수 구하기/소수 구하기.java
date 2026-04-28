import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scann=new Scanner(System.in);
		int M=scann.nextInt();
		int N=scann.nextInt();
		for (int i = M; i < N+1; i++) {
			if(isP(i)){
				System.out.println(i);
			}
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