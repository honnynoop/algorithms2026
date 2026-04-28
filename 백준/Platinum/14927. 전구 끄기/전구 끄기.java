import java.util.Scanner;

public class Main {

	static int N;
	static int [][] map;
	static int [][] nmap;
	static int[] dy={0,-1,1,0,0};
	static int[] dx={0,0,0,-1,1};
	static int[] bulb;
	static int[] simulation;
	public static void main(String[] args) {
		
		Scanner scann=new Scanner(System.in);
		N=scann.nextInt();
		map=new int[N][N];
		nmap=new int[N][N];
		bulb=new int[N];
		simulation=new int[N];
		for (int i = 0; i < N; i++){
			for (int j = N - 1; j >= 0; j--){
                 int temp=scann.nextInt();
                 if (temp!=0) bulb[i] |= 1 << j;
            }
		}
		int result = Integer.MAX_VALUE;
		for (int candidate = (1 << N) - 1; candidate >= 0; candidate--){
                 int press = 0;
                 for (int i = 0; i < N; i++)simulation[i] = bulb[i];
                 //첫 x 2 ^ N의 경우 모두 확인
                 for (int x = 0; x < N; x++){
                         if ((candidate & (1 << x) )!=0) {
                                 pressSwitch(0, x);
                                 press++;
                         }
                 }
                 //이후에 (y - 1)행들의 전구를 다 끄기 위해
                 for (int y = 1; y < N; y++){
                         for (int x = 0; x < N; x++)
                                 if ((simulation[y - 1] & (1 << (N - x - 1)))!=0){
                                          pressSwitch(y, x);
                                          press++;
                                 }
                 }
                 //N-2행까지의 전구를 모두 껐으므로 N-1행의 전구들이 다 꺼져있으면 전부 꺼져있다.
/*                 for (int i = 0; i < N; i++) {
                 	System.out.print(simulation[i]+" ");
                 }    
                 System.out.println("------------------------");*/
                 if (simulation[N - 1] == 0){
                         result = Math.min(result, press);
                         //break;
                 }
        }
		if (result == Integer.MAX_VALUE)
			System.out.println("-1");
		else System.out.println(result);
	}
	static void pressSwitch(int y, int x){
	        //자기 자신
	        simulation[y] ^= (1 << (N - x - 1));
	        //위
	        if (y>0) simulation[y - 1] ^= (1 << (N - x - 1));
	        //아래
	        if (y != N - 1) simulation[y + 1] ^= (1 << (N - x - 1));
	        //왼
	        if (x>0) simulation[y] ^= (1 << (N - x));
	        //오
	        if (x != N - 1) simulation[y] ^= (1 << (N - x - 2));
	}
}