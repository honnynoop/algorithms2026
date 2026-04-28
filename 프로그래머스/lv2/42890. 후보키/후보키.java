import java.util.*;

/**
 * 부분집합
 */
public class Solution{
	
		/**
		 * 학생들의 인적사항이 주어졌을 때, 후보 키의 최대 개수
		 * 
		 */
        List<Integer> answer = new ArrayList<>();//후보키 목록을 담을 list
        public int solution(String[][] relation) {
            int n = relation.length; //학생 수
            int m = relation[0].length; //인적사항 개수

            //인적사항 목록을 조합하여 나올 수 있는 후보키 만들기 : 부분집합
            for (int i = 1; i < 1 << m; i++) {
                Set<String> set = new HashSet<>();
                for(int j = 0; j < n; j++){
                    String temp = "";
                    for(int k = 0; k < m; k++){
                        if((i & 1 << k) > 0){ //현재 부분집합에 포함되는지 확인
                            temp += (relation[j][k]+" "); //부분집합에 포함된 인적사항을 합쳐 문자열로 만들기
                        }
                    }
                    set.add(temp); //set을 활용하여 중복 없이 넣을 수 있도록 저장
                }
                //중복된 데이터가 있는 경우 set에 저장된 데이터의 개수는 n개보다 작음 : 후보키 될 수 없음
                // 현재 만들어진 부분집합이 기존 포함된 부분집합에 포함되는지 확인 
                /*
111000 -> 8+16+32=56 를 i로 => i  & j!=0이면 이미 복합키로 사용하고 있다. -> minimality
111010  : 1 3 4 5 
111011  : 0 1 3 4 5 
111100  : 2 3 4 5 
111101  : 0 2 3 4 5 
111110  : 1 2 3 4 5 
                 */
                if(set.size() == n && check(i)){
                    answer.add(i);
                }
            }
            return answer.size();
        }
        
        boolean check(int i) {    // 
            for (int j : answer) {
                if ((i & j) == j) return false;
            }
            return true;
        }
    }