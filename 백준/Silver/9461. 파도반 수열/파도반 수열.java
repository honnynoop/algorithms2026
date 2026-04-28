import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static long[] map;
    static int N;
    static int T;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        map=new long[101];
        map[1]=1L;
        map[2]=1L;
        map[3]=1L;
        map[4]=2L;
        map[5]=2L;
        for (int i = 6; i < 101; i++) {
			map[i]=map[i-5]+map[i-1];
		}
        for (int t = 1; t <= T; t++) {
        	N = Integer.parseInt(br.readLine());
        	System.out.println(map[N]);
		}
        
    }
}