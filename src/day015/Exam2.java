package day015;

import java.util.*;

public class Exam2 {
    public static void main(String[] args) {
        /* ***
        ## 컬렉션 프레임 워크
        ***
        ### 1️⃣ 컬렉션 프레임 워크

        1. 정의
        : 자료들을 수집/저장하는 방법들을 미리 만들어둔 인터페이스/클래스.

        2. 목적
        : 복잡한 자료 구조를 제공받아 편리하게 데이터 관리하기
           - 자료구조란?
           : 컴퓨터가 자료들을 효율적으로 저장하는 방법/구조
              예) 리스트 , 해시, 큐, 스택 , 트리 등등

        3. 종류
           - 인터페이스    구현체
             List         ArrayList , Vector , LinkedList , Stack 등
             Set          HashSet , TreeSet 등
             Map          HashMap , HashTable , TreeMap 등
              - +) 인터페이스 (추상)
                : 서로 다른 클래스/타입들의 기능을 통합한 것.
        ***
        ### List 타입
        ```        */
        ArrayList< String > list1 = new ArrayList<>();
        List< String > list2 = new ArrayList<>();
        /*```
        - List 주요 메소드
           1. .add( )
        ```*/
        list2.add( "이황" );
        list2.add( "이황" ); // -> 중복 허용
        list2.add( 0, "심사임당"); // -> 특정 인덱스 추가하기
        System.out.println("list2 = " + list2); // -> 'list2 = [심사임당, 이황, 이황]'
        /*```
           2. .set( )
        ```*/
        list2.set( 0 , "심사임당2" );
        System.out.println("list2 = " + list2); // -> 'list2 = [ 심사임당2 , 이황 , 이황 ]'
        /*```
           3. .get( )
        ``` */
        System.out.println("list2.get( 1 ) = " + list2.get(1)); // -> '이황'
        /*```
           4. .size( )
        ``` */
        System.out.println("list2.size() = " + list2.size()); // -> '3'
        /*```
           5. .contains( ) , .indexOf( )
        ``` */
        boolean result1 = list2.contains( "심사임당2" );
        int result2 = list2.indexOf( "심사임당2" );
        /*```
           6. .remove( )
        ``` */
        list2.remove( "심사임당2" );
        System.out.println("list2 = " + list2); // ->'list2 = [이황, 이황]'
        /*```
           7. .isEmpty( )
        ``` */
        System.out.println("list2.size() = " + list2.size()); // -> 'list2.size() = 2'
        /*```
           8. .clear( )
        ```
        list2.clear();
        ```

        >***
        >- List 타입과 반복문
        >   1. 일반 for문
        >```
        >for( int index = 0 ; index <= list2.size()-1 ; index++ ){
        >    System.out.println( list2. get( index ) );
        >}
        >```
        >   2. 향상된 for문
        >```
        >for( String str : list2 ){
        >    System.out.println( str );
        >}
        >```
        >   3. forEach문 ⭐
        >: 리스트 내 요소(값)들을 하나씩 순서대로 반복변수에 대입하여 반복실행한다.
        >      - `변수명.forEach( ( 반복변수 ) -> { 실행문; } );`
        >         - '람다 표현식'이라고 한다. (저번에 재미나이가 알려준 함수 축약? 그런 건가 봄)
        >         - Spring에서 이거 사용한대
        >```
        >list2.forEach( (반복변수명) -> { System.out.println( 반복변수명 ); } );
        >```
        >***

        ### List 구현체들
        - 구현체
        : 인터헤이스의 추상메소드를 구현(오버라이딩)한 클래스/객체
        - 공통
        : 여러 요소(값)들을 순서대로(인덱스) 저장하는 **배열** 구조
        ``` */
        List< Integer > list ; // -> 일단 인터페이스 타입 넣음
        /*```
           1. `ArrayList<>()`
           : 싱글스레드 사용. 비동기화 메소드.
             중간 삽입/삭제 시 다른 데이터들의 이동이 발생한다.
              - 배열. 차곡차곡 저장.
              - `LinkedList<>()`와 비교
              : 3 삭제하면 4->3 , 5->4 이렇게 되면서 2 번의 이동이 생김.
                 - `ArrayList<>()`는 상대적으로 중간 삽입/삭제가 느리다. 다만 뒤에 추가가 빠르다.
        ``` */
        list = new ArrayList<>();   // -> 싱글스레드 사용. 비동기화 메소드.
        /*```
           2. `Vector<>()`
           : 멀티스레드 사용. 동기화(synchronized) 메소드. 멀티스레드 사용할 때는 무조건 Vector.
              - 안전하지만 다만 좀 느리다. 그래도 안전해서 실무에서는 Vector 사용.
        ``` */
        list = new Vector<>();      // -> 멀티스레드 사용. 동기화(synchronized) 메소드.
        /*```
           3. `LinkedList<>()` (PPT 사진 참고)
           : 싱글스레드 사용. **링크** 구조. 구조체!
             중간 삽입/삭제 시 다른 데이터들의 이동이 발생하지 않는다.
             중간 삽입/삭제가 많을 때 `LinkedList<>()`사용!
              - 헤드 Address가 전 값 주소값 가지고 있음.
              - 꼬리 Address가 다음 값 주소값 가지고 있음.
              - `ArrayList<>()`와 비교
              : 3 삭제하면 2의 꼬리와 4의 헤드 값만 바꾸면 된다. 이동 없음.
                 - `LinkedList<>()`는 상대적으로 중간 삽입/삭제가 빠르다. 다만 뒤에 추가가 느리다.
        ``` */
        list = new LinkedList<>();  // -> 싱글스레드 사용. **링크** 구조
        list.add( 3, 100 );
        /*```
           4. `Stack<>()` (내가 아는 그 스택(/큐))... 푸시 팝 이자식! 푸시푸시 팝 푸시팝 푸시푸시팝
           : push와 pop을 사용하기 위해 Stack 사용.
              - 스택 자료 구조 LIFO(Last In First Out) (FILO(First In Last Out))
              : 입구와 출구가 하나라서 먼저 들어온 값이 나중에 나간다.
                 - 예) 프링글스 통, 동전 케이스, ctrl+z(뒤로가기) 등.
              - `Stack<>()`은 `Stack<>` 타입이 따로 있어서 붙여줘야 한다.
        ``` */
        Stack< String > stack = new Stack<>();
        stack.push( "가나디" );      // 값 추가 : push
        stack.push( "농담곰" );      // 값 추가 : push
        System.out.println( stack.pop() );  // 값 제거 : pop
        System.out.println( stack.pop() );  // 값 제거 : pop
        /*```


        */





    }
}
