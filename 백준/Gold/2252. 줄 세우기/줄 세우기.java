import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

	static int N,M;
	static List<Integer>[] list;
	static int[] inderee;
	public static void main(String[] args) {
		
		Scanner scann=new Scanner(System.in);
		// N 1~N번
		N=scann.nextInt();
		// M개 연결
		M=scann.nextInt();
		inderee=new int[N+1];
		list=new ArrayList[N+1];
		for (int i = 0; i < N+1; i++) {
			list[i]=new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			int fromV=scann.nextInt();
			int inV=scann.nextInt();
			list[fromV].add(inV);
			inderee[inV]++;
		}
		tp(inderee,list);
		//System.out.println(Arrays.toString(inderee));
	}
	static void tp(int[] inderee2, List<Integer>[] list2) {
		PriorityQueue<Integer> pq=new PriorityQueue<>();
		for (int i = 1; i < inderee2.length; i++) {
			if(inderee2[i]==0){
				pq.offer(i);
			}
		}
		while(!pq.isEmpty()){
			int indegreeZero=pq.poll();
			
			List<Integer> vertexts=list2[indegreeZero];
			for (int i = 0; i < vertexts.size(); i++) {
				int no=vertexts.get(i);
				inderee2[no]--;
				if(inderee2[no]==0){
					pq.offer(no);
				}
			}
			System.out.print(indegreeZero+" ");
		}
	}

}
