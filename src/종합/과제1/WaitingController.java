package 종합.과제1;

// 대기 명단 데이터를 직접 관리하고 처리하는 클래스
public class WaitingController {

    // 멤버변수
    Waiting[] waitings = new Waiting[100];

    // 대기 등록 기능 메소드
    boolean addWaiting( String phone , int count ){
        // 객체 생성
        Waiting waiting = new Waiting();
        // 객체의 멤버변수에 저장
        waiting.phone = phone;
        waiting.count = count;
        // 배열의 빈 공간 찾아 생성된 객체 저장
        for(int i = 0 ; i <= waitings.length-1 ; i++){
            if(waitings[i]==null){
                waitings[i]=waiting;
                return true;
            }
        }//for end
        return false;
    }//addWaiting end

    Waiting[] getWaitingList(){
        return waitings;
    }

}

//각 대기 팀의 데이터를 담는 클래스
class Waiting{
    // 멤버변수
    String phone;  // 전화번호
    int count;     // 인원 수
}
