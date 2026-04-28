import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {

	static int N;
	static class  P implements Comparable<P>{
		int x;
		int y;
		public P(int r, int c) {
			super();
			this.x = r;
			this.y = c;
		}
		@Override
		public int compareTo(P p) {
			int rx=x-p.x;
			int ry=y-p.y;
			if(rx>0 && ry>0) {
				return -1;
			}
			else if(rx<0 && ry<0) {
				return  1;
			}
			else return 0;
		}
	}
	static int max;
	public static void main(String[] args) {
		Scanner scann=new Scanner(System.in);
		N=scann.nextInt();
		List<P> que=new LinkedList<>();
		for (int i = 0; i < N; i++) {
			que.add(new P(scann.nextInt(),scann.nextInt()));
		}
		for (int i = 0; i <N; i++) {
			int cnt=1;
			for (int j = 0; j <N; j++) {
				if((que.get(i)).compareTo(que.get(j))>0) {
					cnt++;
				}
			}
			System.out.print(cnt+" ");
		}
		System.out.println();
	}
}