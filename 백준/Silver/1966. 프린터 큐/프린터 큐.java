
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

	static class NM{
		int index;
		int value;
		public NM(int index, int value) {
			this.index = index;
			this.value = value;
		}
	}
	static int T;
	static int N,M;
	static List<NM> list;
	static List<NM> move;
	public static void main(String[] args) {
		Scanner scann=new  Scanner(System.in);
		T=scann.nextInt();
		for (int t = 1; t <= T; t++) {
			N=scann.nextInt();
			M=scann.nextInt();
			list=new ArrayList<>();
			move=new ArrayList<>();
			for (int i = 0; i < N; i++) {
				list.add(new NM(i,scann.nextInt()));
			}
			while(list.size()>0) {
				gomove();
			}
			//System.out.println(Arrays.toString(move.toArray()));
			//System.out.println(move.get(M).index);
			int cnt=0;
			for (NM mm : move) {
				cnt++;
				if(mm.index==M) {
					System.out.println(cnt);
					break;
				}
				
			}
		}

	}
	private static void gomove() {
		NM nm=list.remove(0);
		boolean isS=false;
		for (NM s: list) {
			if(nm.value<s.value) {
				isS=true;
				break;
			}
		}
		if(isS) {
			list.add(nm);
		}else {
			move.add(nm);
		}
		
	}

}
