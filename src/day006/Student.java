package day006;

public class Student { //학생에게 이름과 도시락 있음
    // 1. 속성 = 멤버변수 = 객체들 간의 공유 안 함. 객체마다 각각 사용. -> 동적 메모리에 저장
    String name;
    String lunchBox;

    // 2. 기능 = 메소드 = 객체들 간의 공통/공유 이벤트 -> 정적 메모리에 저장
    void 밥먹기(){
        System.out.println( this.lunchBox + "먹는다." );  // this를 써도 되고 안 써도 된다고 하시는데 this가 뭐여
                                                         // this: 해당 메소드 호출한 대상/객체 지정? 이걸 누가 실행했냐.
        System.out.println( lunchBox + "먹는다." );
    }

}
