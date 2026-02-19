package day015;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Exam3 {
    public static void main(String[] args) {
        /*
        ***
        ### 3️⃣ Set 인터페이스
        : 순서(인덱스) 없는 저장 -> 중복 불가능.
        ``` */
        Set< String > set1 = new HashSet<>();
        /*```
        1. Set 주요 메소드
           1. `.add( 새로운값 );`
           : 요소 추가
        ``` */
        set1.add( "가나다" ); set1.add( "가나다" ); // -> 중복 불가능.
        set1.add( "라마바" );
        System.out.println("set1 = " + set1); // -> `set1 = [라마바, 가나다]`
        /*```
              - 인덱스가 없으므로 .set( ) , .get( ) , .indexOf( ) 메소드 없음.
           2. `.size( )`
           : 전체 요소 개수
        ``` */
        System.out.println("set1.size() = " + set1.size());
        /*
           3. `.contains( 같을값 )`
           : 같을 값이 존재하면 true/false
        ``` */
        boolean result1 = set1.contains( "가나다" );
        /*```
           4. `.remove( 삭제할값 )`
           : 삭제할 값이 존재하면 삭제.
        ``` */
        set1.remove( "가나다" );
        /*```
           5. `isEmpty( )`
           : 요소가 한 개도 없으면 true. 있으면 false.
        ``` */
        System.out.println("set1.isEmpty()  = " + set1.isEmpty());
        /*```
           6. `.clear( )`
           : 모든 요소 삭제
        ```
        set1.clear( );
        ```
           7. `.iterator( )` ⭐
           : 집합(SET. 순서 없음.) 요소들을 반복할 수 있도록 인터페이스 반환.
           순서 없는 애를 반복하기 위해 `.hasNext()`(다음 요소가 존재하면 이동) 필요.
        ```
        Iterator<String> iterator = set1.iterator();
        while ( iterator.hasNext() ){
            System.out.println( iterator.hasNext() ); // -> 다음 요소(값) 반환.
        }*/
        /*```
             - `.hasNext( )`
             : 다음 요소가 존재하면 이동.

        >***
        >- 집합(SET)과 FOR문 관계
        >   1. 일반 for ***불가능***
        >   2. 향상된 for
        >```
        >for( String str : set1 ){System.out.println(str);}
        >```
        >   3. forEach ⭐
        >```
        >set1.forEach( (str) -> {System.out.println(str);} );
        >```
        >   - 활용처
        >   : JDBC( ResultSet ) (MySql 연동하려고 정보 불려오던 거)
        >***

        2. Set 인터페이스(구현체)
        : 저장된 순서(인덱스) 없이 주소값으로 데이터를 관리한다.
        중복을 허용하지 않는다. (중복 제거!)
           - HashSet 클래스
           : 저장순서(인덱스) 없고 , 중복불가능 구조
           - TreeSet 클래스
           : 저장순서(인덱스) 없고 , 중복불가능 구조 , + 자동 정렬
        ``` */
        Set< Integer > set ;
        set = new HashSet<>();

        TreeSet< Integer > set2 = new TreeSet<>();
        set2.add( 50 );  set2.add( 30 );  set2.add( 45 );
        System.out.println("set2 = " + set2); // -> 'set = [30, 45, 50]'
        /*```
        - 이진트리
        : 각각의 노드/가지(값)이 최대 2개의 노드/가지(값)을 연결하는 구조.
          정렬 용도로 사용한다.
          Set 인터페이스의 중복 금지 규칙을 구현하기 위해 사용하는 도구.
           - 특징
             - 현재 노드/가지 보다
             작은 값이 추가되면 왼쪽 노드/가지에 추가,
             큰값이 추가되면 오른쪽 노드/가지에 추가하는 구조.
             - 기본값: 오름차순
               -`.descendingSet()`
                 : 내림차순으로 바꿔준다. 순서 바꾸려면 사용.
           - 활용처 : 정렬( 검색 최적화 )
        ``` */
        System.out.println( set2.descendingSet() ); // -> '[50, 45, 30]'


    }
}
