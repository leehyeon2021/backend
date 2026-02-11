package day013;

import java.util.Arrays;

public class Exam2 {
    public static void main(String[] args) {

        /* '미리 태어난 사람'이 정한 것 ㅋㅋㅋㅋ 넘 웃기다
        String 클래스
        1. 문자열 표현 방법    */
        char str1 = '유'; // char는 한 글자만 저장 가능.
        char[] str2 = { '유', '재', '석'}; /* char타입 배열이 문자열의 시초. 원래는 char로 하나하나 나열했어야 했는데 String 클래스로 편하게 문자열 표현 가능.

        2. 문자 변환
           - 아스키코드(C언어): 7비트, 128문자.
             유니코드(자바): 전세계 표준 문자 부호     */
        char str3 = 65;     System.out.println("str3 = " + str3); // A
        char[] str4 = {74,65,86,65};        System.out.println("str4 = " + Arrays.toString(str4)); // str4 = [J, A, V, A]
        char str5 = '김';        System.out.println("(int)str5 = " + (int)str5); /* (int)str5 = 44608

        3. 문자열 생성        */
        String str6 = "유재석"; // 문자 리터럴 형식                       // 얘랑
        String str7 = "유재석"; // 문자 리터럴 형식 vs.                   // 얘는 같은데
        String str8 = new String("유재석"); // 문자 객체 형식     // 얘는 다른 거. 문자는 같으나 객체는 다른 애인가봄
        System.out.println( str6 == str7 );     //true
        System.out.println( str6 == str8 );     //false
        System.out.println( str6.equals(str8) ); /*true
        -> 유재석이라는 문자는 하나. 리터럴 유재석은 하나. 랩핑한 객체(str8)랑 날 것의 객체는 다름.
            그냥 "유재석"과 new String("유재석")은 다르다. 전자는 그냥 문자 객체 형식, 후자는 객체{"유재석"} 형식.

        4. 주요 문자열 연결 기능/메소드
        : **문자는 불변한다.** 리터럴 값은 변하지 않는다. 다 새롭게 생성되는 것(주소값이 다르다는 뜻).
         주의: StringBuilder는 주소값을 유지한다.
           1. `.concat("새로운문자")`
           `"문자열".concat("새로운문자")`
           : 문자열에 새로운 문자열 연결하여 **(새로운)** 반환하는 함수
           ('새로운': 기존 거 수정한 게 아니고 새로운 문자열을 만들었다는 것. 애초에 리터럴(상수)인데 어떻게 수정함!)*/
        String str9 = "자바"; // str9 주소값
        System.out.println("str9.concat( \"프로그래밍\" ) = " + str9.concat("프로그래밍")); // 자바프로그래밍
        String str10 = str9.concat( "프로그래밍" ); /* str10 주소값
           2. `+` 연결연산자
           `"문자열" + "새로운문자열"`
           : 연결된 문자열이 반환된다.
           `3 + 3` -> `6`        */
        String str11 = str9 + "프로그래밍"; /*
           3. `StringBuilder` 클래스 `.append`
           `.append` 함수 이용하여 문자열 연결하는 객체
           : 연결된 문자열에 따른 **주소값** 유지. (속도 빠름?)                    */
        StringBuilder builder = new StringBuilder();
        builder.append(str9);
        builder.append("프로그래밍");
        System.out.println( builder ); /* 자바프로그래밍
           4. `String.format( "%" , "문자열" )        */
        String str12 = String.format( "%s%s" , str9 , "프로그래밍");
        System.out.println("str12 = " + str12); /* 자바 프로그래밍
           5. `""" """`
             : 자동 줄바꿈 표현하는 문자열 (8버전에선 안 됨)
             `/n`과 비슷. 선택 사용.
             - 활용: JDBC SQL*/
        String str13 = """
                자바
                프로그래밍
                """; // """ """ <- 이렇게 한 줄로 하면 안 됨.
            System.out.println("str13 = " + str13);
        /* 활용처
        String sql1 = "insert into table(name)values("+name+")"; //예시.
        String sql1 = "insert into table(name)values(".concat(name+")"); //예시.
        String sql3 = String.format("insert into table(name) values(%s)",name);
        StringBuilder sql4 = new StringBuilder();
        sql4.append( "insert into table(name)" );
        sql4.append("value(");
        sql4.append(name);
        sql4.append(")"); */
        String sql5 = "insert into table(name) values (?)"; /* 그냥 와일드카드(?) 사용하는 것이 낫다. format 사용하는 사람도 잇음.(ps.set 안 해도 돼서.)
           6. .charAt( 인덱스 )
           : 문자열 내 지정한 인덱스 번호의 문자 1개 추출/반환      */
        char gender = "012345-1230123".charAt( 7 );
        System.out.println("gender = " + gender); /*
           7. .length()
           : 문자열 내 문자 개수/길이 반환      */
        System.out.println( "012345-1230123".length() ); /*
           8. `.replace( 기존문자 , 새로운문자 )`
           : 문자열 내 기존문자가 존재하면 새로운문자로 치환하여 문자열 반환.
           이것도 새로운 문자열이라서 주소값 바뀜.   */
        String str14 = "자바프로그래밍".replace("자바", "JAVA");
        System.out.println("str14 = " + str14); /* JAVA프로그래밍
             - 활용: HTML ( 데이터 수집 과정 정체/정리)       */
        String html = "<div>유재석</div><br/><div>강호동</div><br/>";        System.out.println(html);
        System.out.println( html.replaceAll("<br/>", "\n" ));
          /* - HTMl 줄바꿈을 java 줄바꿈으로 치환하는 것.
               외부 데이터 가지고 올 때 불필요한 자료들을 정제하는 과정에서 치환한다.
           9. `.substring( 시작 , [끝] )`
           : 시작 부터 끝 인덱스까지 문자열 추출/반환             */
        String str15 = "012345-1230123".substring( 0 , 6 );
        System.out.println("str15 = " + str15); /* str15 = 012345
           10. `.split( "구분문자" )`
           : 구분문자 기준으로 잘라서 배열로 반환. (반환타입을 배열로 해야 한다.)
             - 활용처: 날짜/시간 , CSV, 데이터정리 등    */
        String[] str16 = "012345-1230123".split( "-");
        System.out.println("str16[0] = " + str16[0]); //str16[0] = 012345
        System.out.println("str16[1] = " + str16[1]); /*str16[1] = 1230123
           11. .indexOf( "찾을문자" )
           : 찾을 문자가 존재하면 찾은 인덱스번호 반환, 아니면 -1 반환.
             - 활용처: 검색
           12. .contains( "찾을문자" )
           : 찾을 문자가 존재하면 true 반환, 아니면 false 반환.        */
        System.out.println( "자바 프로그래밍 언어".indexOf("프로") ); // 3 (인덱스 번호. 앞 시작자리만 나오나봄...)
        System.out.println( "자바 프로그래밍 언어".contains("프로") ); /* true
           13. byte를 문자열로, 문자열을 byte로
           `.getBytes()`
           : 문자열을 byte배열[]로 반환/추출
             문자열 -> byte배열                                       */
        byte[] str17 = "ABC".getBytes();
        System.out.println( Arrays.toString( str17 ) );        /*-> byte 유니코드 나옴: [65, 66, 67]. 한국어는 바이트로 표현이 안 되기 때문에 넘침.[-17]이렇게.
             +) new String( 문자열바이트 )
                : byte배열 -> 문자열 타입으로 바꿔줌.
                활용: 네트워크, 파일처리 등. 데이터 다룰 때    */
        String str18 = new String( str17 );
        System.out.println("str18 = " + str18); // str18 = ABC

    }// main end
}// class end
