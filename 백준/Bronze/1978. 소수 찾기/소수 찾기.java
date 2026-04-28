import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scann=new Scanner(System.in);
		int N=scann.nextInt();
		int cnt=0;
		for (int i = 0; i < N; i++) {
			if(isP(scann.nextInt())){
				cnt++;
			}
		}
		System.out.println(cnt);
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