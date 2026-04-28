import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
	static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        if(N==0) {
        	System.out.println(0);
        }else if(N==1){
        	System.out.println(1);
        }else {
        	BigInteger [] big=new BigInteger[N+1];
            big[0]=new BigInteger("0");
            big[1]=new BigInteger("1");
            
            for (int i = 2; i < N+1; i++) {
            	big[i]=big[i-1].add(big[i-2]);
    		}
            System.out.println(big[N]);
        }
        
       
        
    }
}