import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	static int [] dr={0,-1,1,0, 0};  // 이동없음 포함
	static int [] dc={0, 0,0,1,-1};
	// (r, c)는 상어의 위치, s는 속력, d는 이동 방향, z는 크기이다. 
	// d가 1인 경우는 위, 2인 경우는 아래, 3인 경우는 오른쪽, 4인 경우는 왼쪽을 
	static class Shark {
		int r;
		int c;
		int s;
		int d;// 1~4 
		int z;
		public Shark(int r, int c, int s, int d, int z) {
			super();
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
		}
	}
	static int R,C, M;
	static Shark[][] map;
	static int cnt;
	
	// 상어이동 추적용
	static ArrayList<Shark> sharks=new ArrayList<>();
	
	public static void main(String[] args) {
		Scanner scann=new Scanner(System.in);
		R=scann.nextInt();
		C=scann.nextInt();
		M=scann.nextInt();
		map=new Shark[R+1][C+1];

		for (int i = 0; i < M; i++) {
			int r=scann.nextInt();
			int c=scann.nextInt();
			int s=scann.nextInt();
			int d=scann.nextInt();
			int z=scann.nextInt();
			// 한 상어를 생성해서 맵과 리스트에 저장
			Shark sf =new Shark(r, c, s, d, z);
			sharks.add(sf);
			map[r][c]=sf;
		}
		cnt=0;
		// 
		for (int i = 1; i < C+1; i++) {
			if(sharks.size()==0){ break ;}
			fishing(i);       // i column에서 상어 낚시
			sharkmoving();    // 상어 이동
			// sharks에서 상어이동 -> map에서 상어가 있는 곳에 상어가 이동될 경우 
			// map에서 상어가 없으면 null -> 상어이동
			// 작은 상어 제거 , 여러 상어가 같은 위치 작은 상어들 제거
			sharkremoving(); 
		}
		System.out.println(cnt);
	}
	// sharks에서 삭제한 것은 같은 주소로 만들어진 map에서도 삭제
	// map의 값을 수정하면 sharks에 있는 것이 수정 
	private static void sharkremoving() {
		// 이동은 sharks에서 이미 이동 처리가 다 되어있고 ->이동안한 상어가 없습니다. 
		// map에는 지금 반영하려고 합니다. 
		map=new Shark[R+1][C+1];  // 비어있는 것 만들기 -> 트릭 sharks에 있으니까
		
		int size=sharks.size();
		// 숫자가 고정될때 앞에서 , 숫자가 줄어들수 있을 때 뒤어서부터 제거!!!!!!
		for (int i = size-1; i>=0;  i--) {// !!!!!!중요한 로직 뒤에서 부터 찾자!!!!
			Shark now=sharks.get(i);
			// 이동했는데 상어가 없어
			if(map[now.r][now.c]==null){
				map[now.r][now.c]=now;
			}
			// 이동 했는데 상어기 이미 있어  
			//   -> 이미 있는 상어가 커? 아니면 이미 있는 상어가 작아?
			else {
				if(map[now.r][now.c].z>now.z){
					sharks.remove(now);
				}else{
					sharks.remove(map[now.r][now.c]);
					map[now.r][now.c]=now;
				}
			}
		}
	}
	// sharks에 있는 모든 상어를 이동시킨다. 
	// map은 여기서 신경 안쓴다. 
	private static void sharkmoving() {
		// 현재위치 임시저장
		// 이동위치가 경계 밖이면 , 현재위치에서 방향을 바꾼후 이동
		// sharks에서만 이동
		for (Shark curshark: sharks) {
			int cr=curshark.r;
			int cc=curshark.c;
			int cs=curshark.s; //speed
			int cd=curshark.d; //direction
			int cz=curshark.z; //size 크기
			int nr=cr;
			int nc=cc;
			for (int j = 0; j < cs; j++) {
				int tempr=nr;
				int tempc=nc;
				nr=nr+dr[cd];
				nc=nc+dc[cd];
				if(!check(nr,nc)){// 밖으로 나갔으면 
					cd=turn(cd); //방향돌려
					nr=tempr+dr[cd];
					nc=tempc+dc[cd];
				}
			}
			curshark.r=nr;
			curshark.c=nc;
			curshark.s=cs;
			curshark.d=cd; 
			curshark.z=cz; 
		}
	}
	private static int turn(int d) {
		if(d==1) return 2;
		else if(d==2) return 1;
		else if(d==3) return 4;
		else if(d==4) return 3;
		else return 0;
	}
	private static boolean check(int r, int c) {
		return r>=1 && r<R+1 && c>=1 && c<C+1;
	}
	//c열 첫 상어 낚시
	private static void fishing(int c) {
		for (int r = 1; r < R+1; r++) {
			if(map[r][c]==null) continue;
			if(map[r][c]!=null){
				cnt+=map[r][c].z;
				// 낚시질된 상어 제거됨  shark,map
				sharks.remove(map[r][c]);
				break;
			}
		}
	}
	
}