import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static int [] p;
    static int [] r;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(
				new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		p=new int[N+1];
		r=new int[N+1];
		init();
		for (int i = 0; i < M; i++) {
			st=new StringTokenizer(br.readLine());
			int opp=Integer.parseInt(st.nextToken());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			if(opp==0) {
				union(a, b);
			}else {
				int f1=find(a);
				int f2=find(b);
				if(f1==f2) {
					System.out.println("YES");
				}else {
					System.out.println("NO");
				}
			}
		}
	}
	private static void union(int x, int y) {
		x=find(x);
		y=find(y);
		if(x==y) return ;
		if(r[x]<r[y]) {
			r[y]+=r[x];
			p[x]=y;
		}else {
			r[x]+=r[y];
			p[y]=x;
		}
	}
	private static int  find(int x) {
		if(x==p[x]) return p[x];
		else return p[x]=find(p[x]);
	}
	private static void init() {
		for (int i = 0; i < N+1; i++) {
			p[i]=i;
		}
		for (int i = 0; i < N+1; i++) {
			r[i]=1;
		}
	}
}