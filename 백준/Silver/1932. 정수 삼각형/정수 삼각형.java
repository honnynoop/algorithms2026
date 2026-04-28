import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st=new StringTokenizer(br.readLine());
            for (int j = 1; j <= i; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 2; i <= N; i++) {
        	map[i][1]+=map[i-1][1];
        	map[i][i]+=map[i-1][i];
            for (int j = 2; j <= i; j++) {
                map[i][j] += Math.max(map[i-1][j-1], map[i-1][j]);
            }
        }
      /*  for (int i = 1; i <= N; i++) {
            System.out.println(Arrays.toString(map[i]));
        }*/
        Arrays.sort(map[N]);
        System.out.println(map[N][N]);
    }
}
