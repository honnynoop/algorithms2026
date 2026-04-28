import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
//[0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610, 987, 1597, 2584,
// 4181, 6765, 10946, 17711, 28657, 46368, 75025, 121393, 196418, 317811, 514229,
// 832040, 1346269, 2178309, 3524578, 5702887, 9227465, 14930352, 24157817, 
// 39088169, 63245986, 102334155, 165580141, 267914296, 433494437, 701408733, 1134903170]

public class Main {

	static int N;
	static int T;
	static int[] pivos;
	static List<Integer> result;
	static int count=44;
	public static void main(String[] args) {
		
		pivos=new int[46];
		pivos[1]=1;
		pivos[2]=1;
		for (int i = 3; i < 46; i++) {
			pivos[i]=pivos[i-1]+pivos[i-2];
		}
		Scanner scann=new Scanner(System.in);
		T=scann.nextInt();
		for (int i = 1; i <=T; i++) {
			result=new ArrayList<>();
			N=scann.nextInt();
			if(N==1 || N==2) {
				System.out.println(N);
			}else {
				int k=45;// 1000000000보다 작은 
				for (int j = 1; j < 46; j++) {
					if(N<= pivos[j] &&  N> pivos[j-1]) {
						k=j;
						break;
					}
				}
				while(true) {
					if( N>pivos[k]) {
						result.add(pivos[k]);
						N=N-pivos[k];
						k--;
					}else if(N>0 && N<pivos[k]) {
						k--;
					}else if(N==pivos[k]) {
						result.add(pivos[k]);
						break;
					}
				}
				Collections.sort(result);
				StringBuilder sb=new StringBuilder();
				for (int a: result) {
					sb.append(a+" ");
				}
				System.out.println(sb.toString().trim());
			}
		}
		
	}
}