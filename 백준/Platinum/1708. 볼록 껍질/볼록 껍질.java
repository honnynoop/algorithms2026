

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Stack;

public class Main {

	static class L{
		long x;
		long y;
		public L(long x, long y) {
			super();
			this.x = x;
			this.y = y;
		}
		@Override
		public String toString() {
			return "L [x=" + x + ", y=" + y + "]";
		}
		
	}
	static class LC implements Comparator<L>{

		@Override
		public int compare(L p1, L p2) {
			int re=Long.compare(p1.y, p2.y);
			if(re==0) {
				return Long.compare(p1.x, p2.x);
			}else {
				return re;
			}
		}
		
	}
	static class LTC implements Comparator<L>{

		L p0;
		public LTC(L p0) {
			this.p0 = p0;
		}

		@Override
		public int compare(L p1, L p2) {
			long re=ccw(p0,p1,p2);
			if(re==0) {
				long distance1 = dist(p0, p1);
                long distance2 = dist(p0, p2);

                if (distance1 > distance2) {    // 거리가 더 가까운 순으로 정렬
                    return 1;
                }else return -1;
			}else {
				return re>0 ? -1:1;// 앞에가 크면 뒤집어 -> ASC 각도순으로 첫 좌표에서
			}
		}
		
	}
	static int N;
	public static void main(String[] args) {
		Scanner scann=new Scanner(System.in);
		N=scann.nextInt();
		ArrayList<L> points=new ArrayList<>();
		Stack<L> hull=new Stack<>();
		for (int i = 0; i < N; i++) {
			long x=scann.nextLong();
			long y=scann.nextLong();
			points.add(new L(x,y));
		}
		points.sort(new LC());
		L p0=points.remove(0);
		hull.push(p0);
		points.sort(new LTC(p0));
		L p1=points.remove(0);
		hull.push(p1);
		for (int i = 0; i < N-2; i++) {
			L b=points.get(i);
			while(hull.size()>=2) {// 두개이상
				L a=hull.pop();   //위의것이 뒤에 들어간것.
				L p=hull.peek();  //먼저 들어간것
				
				long ccwvalue=ccw(p,a,b);
				if(ccwvalue>0) {
					hull.push(a);
					break;
				}
			}
			hull.push(b);
		}
		System.out.println(hull.size());
/*		int size=hull.size();
		for (int i = 0; i < size; i++) {
			L a=hull.pop();
			System.out.println(a.x+" "+a.y);
		}*/
	}

	static long ccw(L p, L a, L b) {
		return cross(vec(p,a),vec(a,b));
	}
	static long cross(L a, L b) {
		return a.x*b.y-a.y*b.x;
	}
	//ab-> ob-oa 상대벡터
	static L vec(L a, L b) {
		long x=b.x-a.x;
		long y=b.y-a.y;
		return new L(x,y);
	}
	static long dist(L p1, L p2) {
        return (p2.x - p1.x) * (p2.x - p1.x) + (p2.y - p1.y) * (p2.y - p1.y);
    }
}
