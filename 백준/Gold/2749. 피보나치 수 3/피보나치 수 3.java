import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static long N;
    static int T=1000000;
    static int P=2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Long.parseLong(br.readLine());
        long[][] result=matrix(N);
    	System.out.println(result[1][0]);
    }

    public static long[][] matrix(long y) {
    	long[][] r=new long[][] {
			{1,0},
			{0,1}};
		long[][] m=new long[][] {
			{1,1},
			{1,0}};
		
		while(y>0L){
			if(y%2L==1L){
				r=mul(r,m);
			}
			y=y/2L;
			m=mul(m,m);
		}
		return r;
	}
	public static long[][] mul(long[][] r, long[][] x) {
		long[][] res=new long[P][P];
		
		for (int i = 0; i < P; i++) {
			for (int j = 0; j < P; j++) {
				long t=0;
				for (int k = 0; k < P; k++) {
					t=(t%T+(r[i][k]*x[k][j])%T)%T;
				}
				res[i][j]=t%T;
			}
		}
		return res;
	}
}