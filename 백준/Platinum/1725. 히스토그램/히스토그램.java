import java.util.Scanner;
import java.util.Stack;
public class Main {
	static int N;
	static int[]map;
	public static void main(String[] args) {
		Scanner scann=new Scanner(System.in);
		N=scann.nextInt();
		map=new int[N+1];
		for (int i = 0; i <N; i++) {
			map[i]=scann.nextInt();
		}
		Stack<Integer> st=new Stack<>();
		long max=0;
		int top=0;
		for(int i = 0; i <N+1; i++) {
	        while(!st.empty() && map[st.peek()] > map[i]) {
	            int width=0;
	            top = st.pop();
	            if(st.empty()) width= i;
	            else width = i - st.peek()-1;
	            max = Math.max(max, map[top] * width);
	        }
	        st.push(i);
	    }
		System.out.println(max);
	}
}