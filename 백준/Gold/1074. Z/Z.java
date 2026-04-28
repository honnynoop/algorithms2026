
import java.util.Scanner;

public class Main {

	static int N, r, c, cnt;
	
	public static void main(String[] args) {
		Scanner scann=new Scanner(System.in);
		N=scann.nextInt();
		r=scann.nextInt();
		c=scann.nextInt();
		cnt=0;
		//로직
		z(0,0,1<<N);
		//출력
		//System.out.println(cnt);
	}

	static void z(int rr, int cc, int width) {
		if(rr==r && cc==c) {
			System.out.println(cnt);
			return ;
		}
		if(r>=rr && r<rr+width && c>=cc && c<cc+width ) {
			int w=width/2;
			z(rr,cc,w);      //11
			z(rr,cc+w,w);    //1
			z(rr+w,cc,w);    //7
			z(rr+w,cc+w,w);  //5 
		}else cnt+=width*width;
		
	}

}





