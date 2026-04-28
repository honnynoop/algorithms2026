import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    static int N,M,T;
    static int [] p;
    static int [] r;
    static List<List<Integer>> people;
    static List<Integer> truse;
    static int result;
	public static void main(String[] args) {
		
		Scanner scann=new Scanner(System.in);
		N=scann.nextInt();
		M=scann.nextInt();
		truse=new ArrayList<>();
		p=new int[N+1];
		r=new int[N+1];
		T=scann.nextInt();
		if(T!=0) {
			for (int i = 0; i < T; i++) {
				truse.add(scann.nextInt());
			}
		}
		people=new ArrayList();
		for (int i = 0; i < M; i++) {
			List<Integer> pe=new ArrayList<>();
			int k=scann.nextInt();
			for (int j = 0;  j < k; j++) {
				int tt=scann.nextInt();
				pe.add(tt);
			}
			people.add(pe);
		}//읽기
		//로직
		init();
		//진실을 알고 있는사람 미리 연결
		ready();
		// 파티연결시작
		go();
		// 계산
		result=0;
		calc();
		System.out.println(result);
	}
	private static void calc() {
		int s=0;
		int f1=find(s);
		for (int i = 0; i <people.size(); i++) {
			int tt=people.get(i).get(0);
			int f2=find(tt);
			if(f1!=f2) {
				result++;
			}
		}
	}
	private static void go() {
		for (int i = 0; i <people.size(); i++) {
			int size=people.get(i).size();
			if(size>=2) {
				int s=people.get(i).get(0);
				for (int j = 1; j < size; j++) {
					int e=people.get(i).get(j);
					union(s,e);
					s=e;
				}
			}
		}
	}
	private static void ready() {
		int s=0;
		for (int i = 0; i < truse.size(); i++) {
			int e=truse.get(i);
			//System.out.println(s+" "+e);
			union(s,e);
			s=e;
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