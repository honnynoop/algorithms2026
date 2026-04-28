import java.util.Scanner;
public class Main {

	static int N;
	static long[] A;
	static G [] GM;
	public static void main(String[] args) {
		Scanner scann=new Scanner(System.in);
		N=scann.nextInt();
		A=new long[N+1];
		GM=new G[N+1];
		for (int i = 1; i < N+1; i++) {
			A[i]=scann.nextInt();
			GM[i]=new G(A[i],1);
		}
	
		if(N==2){
			G aG=rev(addG(GM[1],GM[2]));
			G bG=minus(new G(1,1), aG);
			System.out.printf("%d %d\n",bG.A,bG.B);
		}else{
			for (int i = N-1; i >=1; i--) {
				G g=addG(GM[i],GM[i+1]);
				GM[i]=g;
			}
			G bG=minus(new G(1,1), rev(GM[1]));
			System.out.printf("%d %d\n",bG.A,bG.B);
		}
	}
	public static G add(G ga, G gb){
		return new G(ga.A*gb.B+ gb.A*ga.B, ga.B*gb.B);
	}
	public static G minus(G ga, G gb){
		return new G(ga.A*gb.B- gb.A*ga.B, ga.B*gb.B);
	}
	public static G rev(G ga){
		return new G(ga.B,ga.A);
	}
	public static G mul(G ga, G gb){
		return new G(ga.A*gb.A, ga.B*gb.B);
	}
	public static G addG(G ga, G gb){
		return add(ga, rev(gb));
	}
	static class G{
		long A;
		long B;
		public G(long a, long b) {
			super();
			A = a/gcd(a,b);
			B = b/gcd(a,b);;
		}
		@Override
		public String toString() {
			return A + "/" + B;
		}
		
	}
	public static long gcd(long a, long b){
		if(a==b || b==0L){
			return a;
		}else if(a>b){ return gcd(b,a%b);}
		else { return gcd(a,b%a);}
	}

}
/*
4
2 7 1 8

 */