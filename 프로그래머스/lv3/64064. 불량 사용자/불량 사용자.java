import java.util.Arrays;
import java.util.HashSet;


public class Solution{
	
	
	
    static boolean[] check;
    static HashSet<String> set;
    
	public static int solution(String[] userid, String[] banid) {
        check = new boolean[userid.length];
        set = new HashSet<String>();
        
        dfs(0,"",banid,userid);
        
		return set.size();
	}
	/**
	 * 당첨된 아이디 중 제외 되어야할 아이디 목록 경우의 수 구하기
	 * @param depth 현재 선택한 제대 아이디 개수
	 * @param res 선택한 아이디로 누적한 문자열
	 * @param banid 제재 아이디 목록
	 * @param userid 유저 아이디 목록
	 */
	public static void dfs(int depth, String res, String[] banid, String[] userid) {
		if(depth==banid.length) { //제재 아이디 길이만큼 모두 타고왔다면
			String[] arr = res.split(" ");
			Arrays.sort(arr); //알파벳 순서대로 정렬 (일관성 있게 구성하기 위해서)
							//아이디 목록 구성이 동일하면 순서 상관 없이 동일한 경우이기 때문
			
			String str="";
			for(String s:arr) str+=s; //하나의 문자열로 만들기
			set.add(str); //set에 추가 (중복 제거 효과)
			
			return;
		}
		//지금 찾으려는 제재 아이디 패턴과 일치하는 아이디 찾기
		for(int i=0; i<userid.length; i++) {
			//선택되지 않은 아이디면서, 제재 아이디와 일치하는 아이디인지 확인
			if(check[i] || !check(userid[i], banid[depth])) continue;			
			check[i]=true; //사용 체크
			dfs(depth+1,userid[i]+" "+res,banid,userid); //다음 제재 아이디 찾으러 가기
			check[i]=false; //미사용으로 바꾸기
		}
	}
	
	public static boolean check(String userId, String banId) {
		if(userId.length()==banId.length()) {
			char[] user = userId.toCharArray();
			char[] ban = banId.toCharArray();
			for (int i = 0; i < ban.length; i++) {
				if(user[i]==ban[i]||ban[i]=='*')
					continue;
				return false;
			}
			return true;
		}
		return false;
	}
}