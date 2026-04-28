import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int L, R, TL;
	static int N;
	static int[] loc;
	static int TK; //동근
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		L=Integer.parseInt(st.nextToken());
		R=Integer.parseInt(st.nextToken());
		N=Integer.parseInt(br.readLine());
		TL=2*(L+R);          // 상자 둘레길이
		loc=new int[N];
		for (int i = 0; i < N; i++) {
			st=new StringTokenizer(br.readLine());
			int w=Integer.parseInt(st.nextToken());
			int x=Integer.parseInt(st.nextToken());
			loc[i]=toLeng(w,x);
			//System.out.println(loc[i]);
		}
		st=new StringTokenizer(br.readLine());
		int tw=Integer.parseInt(st.nextToken());
		int tx=Integer.parseInt(st.nextToken());
		TK=toLeng(tw,tx);
		//System.out.println(TK);
		int tot=0;
		for (int i = 0; i < N; i++) {
			tot+=mins(TK,loc[i]);
		}
		System.out.println(tot);
	}
	static int mins(int tk, int len) {
		int temp=Math.abs(tk-len);
		return Math.min(temp, TL-temp);
	}
	private static int toLeng(int w, int x) {
		int tot=0;
		switch (w) {
			case 1:
				tot=x;
				break;
			case 2:
				tot=TL-(R+x);
				break;
			case 3:
				tot=TL-x;
				break;
			case 4:
				tot=L+x;
				break;
		}
		return tot;
	}

}