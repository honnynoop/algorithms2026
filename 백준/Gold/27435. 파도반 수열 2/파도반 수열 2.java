import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static long N;
    static int M;
    static int T=998244353;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        M = Integer.parseInt(br.readLine());
        for (int t = 1; t <= M; t++) {
        	N = Long.parseLong(br.readLine());
        	long[][] result=matrix(N+4L);
        	System.out.println(result[0][0]);
		}
    }

    public static long[][] matrix(long y) {
    	long[][] r=new long[3][3];
		for (int i = 0; i < 3; i++) {
			r[i][i]=1;
		}
		long[][] m=new long[3][3];
		m[0]= new long[]{0,1,0};
		m[1]= new long[]{0,0,1};
		m[2]= new long[]{1,1,0};
		
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
		long[][] res=new long[3][3];
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				long t=0;
				for (int k = 0; k < 3; k++) {
					t=(t%T+(r[i][k]*x[k][j])%T)%T;
				}
				res[i][j]=t%T;
			}
		}
		return res;
	}
}