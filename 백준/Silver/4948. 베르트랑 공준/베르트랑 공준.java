import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static int N,M;
	static int[] prim;
	static int[] bert;
	public static void main(String[] args) {
		
		Scanner scann=new Scanner(System.in);
		M=123456;
		//M=20;
		prim=new int[2*M+1];
		bert=new int[2*M+1];
		for (int i = 2; i <2*M+1 ; i++) {
			if(isPrim(i)) {
				prim[i]=1;
			}
			bert[i]=bert[i-1]+prim[i];
		}
		//System.out.println(Arrays.toString(prim));
		//System.out.println(Arrays.toString(bert));
		StringBuilder sb=new StringBuilder();
		while(true) {
			N=scann.nextInt();
			if(N==0)break;
			sb.append((bert[2*N]-bert[N]));
			sb.append("\n");
		}
		System.out.print(sb.toString());
	}

	static boolean isPrim(int n) {
		for (int i = 2; i <=(int)(Math.sqrt(n)); i++) {
			if(n%i==0) { return false ;}
		}
		return true;
	}

}