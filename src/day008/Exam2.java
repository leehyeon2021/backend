package day008;

// 디자인 패턴

public class Exam2 {
    public static void main(String[] args) {

        /*
        1. 싱글톤
        : 프로그램 내 단 하나의 인스턴스(객체) 갖는 설계 구조
        2. 싱글톤 생성 (아래 Controller의 instance)
        3. 다른 클래스에서 싱글톤 호출 , 클래스명.getInstance()        */
        Controller.getInstance(); // == Controller 의 getInstance라는 함수(소괄호있으면함수)의 instance(리턴값) <-찾는법
        Controller controller1 = Controller.getInstance();                  // 여기는 인스턴스 생성 아님.
        Controller controller2 = Controller.getInstance();
        View view1 = new View();                                            // 여기가 102번지
        View view2 = new View();                                            // 여기가 103번지
        System.out.println("controller1 = " + controller1);     // 주소값 얘랑
        System.out.println("controller2 = " + controller2);     // 주소값 얘랑 같음.
        System.out.println("view1 = " + view1);                 // 주소값 다름
        System.out.println("view2 = " + view2);                 // 주소값 다름

        /*
        2. MVC 패턴
        : 세 가지 주요 역할을 분리해서 설계. 코드의 모듈화와 유지보수 높임. (파일 나누기)
        - 장점: 유지보수, 모듈화, 단일기능책임, 효율성 굿 / 단점: 분리함에 따라 관리 복잡도 높다.
            - 예) 직원별로 서빙, 요리, 재료손질 역할이 나뉜다. 담당자에게 빠른 처리 요규 가능. / 혼자 하면 규모 커졌을 때 감당 안 됨.
        - Spring에서 권장하는 패턴.
        - 세 가지 계층
            1. V(view): 입출력 담당.
                - 프론트엔드. HTML/CSS/JS/JSP/REACT/플러터. 비즈니스 코드 들어가면 안 됨.
            2. C(controller): model과 view 사이의 제어/전달/유효성검사/로직 담당
                - 백엔드. JAVA/PYTHON/NODE.JS
                    - MVC1 패턴: JSP(controller+view), model
                    - MVC2 패턴: controller, view, model
                    - MVC2 패턴 3티어(Spring): controller, service, view, model
            3. M(model): 데이터 담당.
                - 백엔드. JAVA/PYTHON/NODE.JS
                - 데이터베이스 상호작용
                    - DAO( data access object ) : 데이터에 접근 객체. view한테 직접 가면 안 됨. ex] 물류 센터에서 짐 싣는. 센터는 하나.
                    - DTO( data transfer object ) : 데이터를 이동 객체. DAO에서 controller으로, Controller에서 View로 이동시켜줌. ex] 택시 기사가 짐 이동하는. 택시 기사는 여러 명. 자료가 하나가 되면 안 됨. 여러 자료들의 모델이기 때문에 싱글톤 안 씀,
                    - VO( value Object ) : 읽기전용 객체.  싱글톤 안 씀
                - 관례적인 규칙: DTO 에는 데이터모델 이므로 싱글톤을 사용하지 않는다.
        - 사용법: 패키지명은 소문자, 클래스명은 대문자 시작.


        1. 요구사항(기획서)작성: 주제, 기능, 목적, 기술스택 등
        2. 프로토타입(피그마): 만들고자 하는 결과의 청사진
        3. 데이터모델: 영구적으로 남길 데이터 테이블 하나가 ArrayList, 한 행이 객체/dto/레코드 하나.
        4. API(기능)명세서 모델: 프론트엔드 개발자와 백엔드 개발자 통신 방법 정의. == 컨트롤러 메소드 설계.
                                - 순번 / 담당자 / 기능이름 / 기능설명 / 매개변수 샘플(서버에 전달할 값)(실무에선잘안함) / 반환 타입 / 반환샘플(클라이언트에게 반환할 값)
        5. 프로젝트/폴더 세팅: 패키지: controller , model(dao,dto), view
                            클래스: 패키지 안에. 그리고 AppStart도.
        6. 싱글톤 구성: view , controller , dao에만 구성. (dto(여러 자료들의 모델)는 싱글톤을 하지 않는다.)
            - 싱글톤 호출의 원칙: view -> controller -> dao.
                - ! dao -> controller는 안 됨! view -> dao 이런 건 원칙 위반!
        */

    }
}

class Controller{ //해당 클래스에 싱글톤 패턴 적용해보기
    // 1. 생성자를 private로 한다. 생성자를 잠근다.
    private Controller(){} // 다른 클래스에서 new 못한다. -> 객체 생성 불가능.
    // 2. 단 하나의 객체를 생성하여 상수(static final)에 저장한다. -> 싱글톤 생성
    private static final Controller instance = new Controller();            // new 하나당 인스턴스 하나 생성. 여기는 101번지
    // 3. 해당 싱글톤(객체)를 다른 클래스에서 간접 사용(공유) 하도록 getter를 만든다.
    public static Controller getInstance(){
        return instance; // 2번에서 생성한 싱글톤(객체) 반환한다.
    }
    // 싱글톤을 직접 만드는 경우는 많지 않다.
}

class View{}