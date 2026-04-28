import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static char[] p;
	static int N;
	static int cnt;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br=new BufferedReader(
				new InputStreamReader(System.in));
		String msg="";
		while((msg=br.readLine())!=null) {
			StringTokenizer st=new StringTokenizer(msg);
			p=st.nextToken().toCharArray();
			N=Integer.parseInt(st.nextToken());
			cnt=0;
			do {
				cnt++;
				if(cnt==N) {
					System.out.println(msg+" = "+ new String(p));
					break;
				}
				
			} while (np(p.length-1));
			if(cnt<N) {
				System.out.println(msg+" = "+ "No permutation");
			}
		}//while
	}//main

	private static boolean np(int size) {
		//1.피크 
		int i=size;
		while(i>0 && p[i-1]>p[i]) i--;
		if(i==0) return false;
		//2 피크왼쪽 < p[j]
		int j=size;
		while(p[i-1]>p[j]) j--;
		char temp=p[i-1];
		p[i-1]=p[j];
		p[j]=temp;
		//3. 피크 i 오른쪽 k 스왑
		int k=size;
		while(i<k) {
			temp=p[i];
			p[i]=p[k];
			p[k]=temp;
			i++;
			k--;
		}
		return true;
	}
	
	
}