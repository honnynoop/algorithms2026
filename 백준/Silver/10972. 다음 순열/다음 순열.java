import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[] p;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br=new BufferedReader(
				new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		p=new int[N];
		StringTokenizer st=new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			p[i]=Integer.parseInt(st.nextToken());
		}
		boolean isS=np(N-1);
		if(isS) { // 다음것 
			for (int i = 0; i < N; i++) {
				System.out.print(p[i]+" ");
			}
			System.out.println();
		}else { //다음것 없음
			System.out.println("-1");
		}
		
	}
	private static boolean np(int size) {
		int i=size;
		while(i>0 && p[i-1]>p[i]) i--;
		if(i==0) return false;
		int j=size;
		while(p[i-1]>p[j]) j--;
		int temp=p[i-1];
		p[i-1]=p[j];
		p[j]=temp;
		int k=size;
		while(i < k) {
			temp=p[i];
			p[i]=p[k];
			p[k]=temp;
			i++;
			k--;
		}
		return true;
	}
}
