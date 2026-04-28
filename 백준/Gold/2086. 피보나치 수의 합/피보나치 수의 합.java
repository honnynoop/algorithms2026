import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static long T=1000000000L;
    static int P=2;
    static long A, B;
    // 0 1 1 2 3 5 8 13 21 34 55 89 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());
        long result=0L;
        long[][] aresult=matrix(A+1L);
        long[][] bresult=matrix(B+2L);
        result=(bresult[1][0]-aresult[1][0]);
        result=(result+T)%T;
        System.out.println(result);
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