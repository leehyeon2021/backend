package day011;

// DB 연동 세팅

// sql 할 때는 sql import 하기~
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Exam3 {
    public static void main(String[] args) {

        // [ JDBC ] : 자바 데이터베이스 연동 라이브러리
            // mysql-connector-j-9.6.0.jar 파일 준비한다.
            // 준비된 .jar 파일을 프로젝트 폴더에 넣어준다.
            // .jar 파일 오른쪽 클릭 -> 하단에 [라이브러리로 추가]
            // * 프로젝트마다 한 번씩 해야 한다.

        // 1. 연동(1) (외우지말고때마다찾아보기) * SQL 회사마다 다르다.
            // : `Class.forName("패키지명.JDBC클래스명");`
            // : 일반예외 무조건 발생
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); //forName 빨간줄 때문에 try catch 해줘야 함

            // -> 해당 클래스가 존재하면 동적으로 객체를 생성해준다. (동적할당: 눈에 안 보임.)

        // 2. 연동(2) : DB서버 계정정보
            // : `String url = "jdbc:회사명://ip주소:port번호/데이터베이스명";`
            //   `String user = "root";`
            //   `1`String password = "1234";`
            String url = "jdbc:mysql://localhost:3306/mydb0205"; // localhost
            String user = "root"; //워크밴치 들어가면 보이는 거
            String password = "1234";

        // 3. 연동(3) : 연동 인터페이스 구현
            // Connection(I) java.sql 패키지                          +) 자동완성 시 인터페이스로 된 거 고르기. (import 참고)
            // DriverManager.getConnection( C ) 구현(객)체
            Connection conn = DriverManager.getConnection( url , user , password ); // <-- 또 빨간줄(일반예외) 떠서
            System.out.println("============= 연동 성공 =============");

        // 4. 연동 이후 DML( select insert update delete ) 실행하기
            String sql = "insert into buy value( null , 'BLK' , '지갑' , null , 30 , 10 )"; // 실행할 sql문법 문자열로 작성한다. (근데 자동완성 안 되기 때문에 mysql에서 하고 이쪽으로 가져오는 것이 낫다.)
            PreparedStatement ps = conn.prepareStatement( sql ); // .prepareStatement( sql ); conn(connect된곳)에 sql 기재
            int count = ps.executeUpdate(); // 기재된 sql 실행 후 반영된 레코드 수 반환     // ctrl + enter 대신에 실행 메소드 사용
            System.out.println("등록된 레코드는: "+count+"개 입니다.");

        }catch ( ClassNotFoundException e ){
            System.out.println("JDBC 클래스 호출 실패: "+e);
        }catch ( SQLException e ){                                                  // <-- SQLException 캐치
            System.out.println("등록된 DB 서버로 연동 실패: "+e);
        }

    }
}
