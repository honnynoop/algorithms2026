import java.util.Scanner;
/*
 * 그리디 전략 5 2 4 3 1
 *         -> 값을 index v로 받음 
 *         0 1 2 3 4 5
 *                   1 0+1
 *             1       0+1
 *                 1   0+1
 *               2     1+1
 *           1         0+1
 *     --> 1증가하는 것 2개       
 *     1 5 2 4 3 
 *     1 5 2 3 4
 *     1 2 3 4 5
 *     5-2 =3
 */
public class Main {
	 public static void main(String args[]) {
	        Scanner sc = new Scanner(System.in);
	        int N = sc.nextInt();
            int[] line = new int[N+1];
            int ans = 0;
            for(int i = 0; i < N; i++) {
                int v = sc.nextInt();
                line[v] = line[v-1] + 1;
                if(ans < line[v]) {
                    ans = line[v];
                }
            }
            System.out.println((N-ans));
	    }
}