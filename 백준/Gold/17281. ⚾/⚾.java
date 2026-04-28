
import java.util.Scanner;
// 111 321
// 안타   ( 111<<1 | 1 ) & 111 결과 -> 1111 & 111     1111 & 1000 !=0 점수1+ 
// 2안타   ( 111<<2 | 10 ) & 111 결과 -> 11110 & 111 =>110    11110 & 1000 !=0 점수1+ 
//                                                        11110 & 10000 !=0 점수1+
//  1111 & 1000 !=0  1111 & 10000  1111 & 100000
//  111<<4 |  1000000 11110000
public class Main {
	static int N;
	static int [][] hitter;
	static int M=9; //9명 
	static int [] p= {2,3,4,5,6,7,8,9};
	static int base;
	static int ONE=0b1;
	static int TWO=0b10;
	static int THR=0b100;
	static int BM1=0b1000;
	static int BM2=0b10000;
	static int BM3=0b100000;
	static int max;
	public static void main(String[] args)  {
		Scanner scann=new Scanner(System.in);
		N=scann.nextInt();   // inning
		hitter=new int[N][M];// M 타자수 9명 
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				hitter[i][j]=scann.nextInt();
			}
		}
		max=-1;
		do {
			base=0;
			int [] player=new int[M];
			for (int i = 0; i < M; i++) {
				if(i<3) {
					player[i]=p[i];
				}else if(i==3) {
					player[i]=1;
				}else if(i>=4) {
					player[i]=p[i-1];
				}
			}
			int tot=0;
			int index=0;
			int out=0;
			for (int i = 0; i < N; i++) {
				aa: while(out!=3) {
					for (int j = (index)%9; j < 9; j++) {
						if(hitter[i][player[j]-1]==0) {
							out++;
						}else if(hitter[i][player[j]-1]==4) {
							for (int k = 0; k < 3; k++) {
								if((base & 1<<k)!=0) {
									tot++;
								}
							}
							tot++;                // 자신
							base=0;
						}else { //1 2 3루타
							int hit=hitter[i][player[j]-1]; //1 2 3 
							int result=((base<<hit) | (1<<(hit-1)));
							base=result & (0b111);
							for (int k = 3; k < 6; k++) {
								if((result & 1<<k)!=0) {
									tot++;
								}
							}
						}
						if(out==3) {
							index=j+1;        // 번호 연결해서
							out=0;
							base=0;  // 매 이닝마다 베이스 초기화
							break aa;
						}else if(out<3){
							index=j+1;        // 번호 연결해서
						}
					}
				}
			}
			max=Math.max(max, tot);
		} while (np(M-2));
		System.out.println(max);
	}
	static boolean np(int size) {
		int i=size;
		while(i>0 && p[i-1]>=p[i]) i--;
		if(i==0) return false;
		int j=size;
		while(p[i-1]>=p[j]) j--;
		int temp=p[i-1];
		p[i-1]=p[j];
		p[j]=temp;
		int k=size;
		while(i<k) {
			temp=p[i];
			p[i]=p[k];
			p[k]=temp;
			i++;
			k--;
		}
		return true;
	}

}
