import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner scann=new Scanner(System.in);
		while(true){
			
			double [][] num=new double[6][2];
			for (int i = 0; i < 6; i++) {
				num[i][0]=scann.nextDouble();
				num[i][1]=scann.nextDouble();
			}
			boolean isS=true;
			for (int i = 0; i < 6; i++) {
				if(num[i][0]==0.0 && num[i][1]==0.0){
					isS= isS && true;
				}else{
					isS= isS && false;
				}
			}
			if(isS) break ;
			
			double S= 0.5* calculate(num[3][0],num[3][1],
					num[4][0],num[4][1], num[5][0],num[5][1]);
			//System.out.println(S);
			double L=-100000.0;
			double R=100000.0;
			double t=(L+R)/2.0;
			while(true){
				double X=num[0][0]-t*(num[0][0]-num[2][0]);
				double Y=num[0][1]-t*(num[0][1]-num[2][1]);
				double T=calculate(num[0][0],num[0][1],
						num[1][0],num[1][1], X,Y);
				if(Math.abs(S-T) <= 1.0E-6) break;
				if(S-T>0){
					L=t;
					t=(L+R)/2.0;
				}else{
					R=t;
					t=(L+R)/2.0;
				}
			}
			double X=num[0][0]-t*(num[0][0]-num[2][0]);
			double Y=num[0][1]-t*(num[0][1]-num[2][1]);
			double X4=X-num[0][0]+num[1][0];
			double Y4=Y-num[0][1]+num[1][1];
			System.out.printf("%.3f %.3f %.3f %.3f\n",
					X4,Y4,X,Y);
		}
	}

	static double calculate(double x1, double y1, double x2, double y2, double x3, double y3) {
		return Math.abs(x1*y2+x2*y3+x3*y1-x2*y1-x3*y2-x1*y3);
	}

}
