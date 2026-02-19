package day015;

import java.util.*;

public class Exam4 {
    public static void main(String[] args) {
        /*
        ### 4️⃣ Map 인터페이스
        : 저장된 순서(인덱스) 없이 key와 value로 구성된 entry(한 쌍)을 저장하는 구조.
           - `Map< KeyType , ValueType >`
           : 제네릭 타입이 두 개.
              - `Map< KeyType , Object >`
              : 통계 처럼 처리할 데이터가 많을 때는 이렇게 Map으로 사용.
        + key는 집합을 사용. value는 리스트를 사용.
          그래서 key는 중복 불가능, value는 중복 가능.
          key는 pk라고 생각하면 편할 듯
        ``` */
        Map< String , Integer > map1 = new HashMap<>();
        /*```
        - 주요 메소드
           1. `.put( key , value )`
           : 엔트리( key , value ) 추가. key는 중복 불가능. (.add() 안 씀.)
        ``` */
        map1.put( "가나다" , 95);  map1.put( "가나다" , 100); // -> key 중복 불가능.
        map1.put ( "라마바" , 100 ); // -> value 중복 가능
        System.out.println("map1 = " + map1);
        /*```
           2. `.get( key )`
           : 특정한 key의 value 반환
        ``` */
        System.out.println("map1.get( \"라마바\" ) = " + map1.get("라마바"));
        /*```
           3. `.size( )`
           : 전체 엔트리 개수 반환
        ``` */
        System.out.println("map1.size() = " + map1.size());
        /*```
           4. `containsKey( 찾을키 )` , `containsValue( 찾을값 )`
           : 카/값이 존재하면 true, 아니면 false.
        ``` */
        boolean result1 = map1.containsKey( "가나다" );
        boolean result2 = map1.containsValue( "가나다" );
        System.out.println("result1 , result2 = " + result1 + result2);
        /*```
           5. `.remove( 삭제할키 )`
           : 특정한 키가 존재하면 엔트리 삭제.
        ``` */
        map1.remove( "라마바" );
        /*```
           6. `.clear( )`
           : 전체 엔트리 삭제
        ``` */
        map1.clear();
        /*```
           7. `.isEmpty( )`
           : 엔트리가 하나도 없으면 true, 없으면 false
        ``` */
        boolean result3 = map1.isEmpty();
        /*```
           8. `.entrySet( )`
           : 모든 엔트리를 집합(SET)으로 반환.
        ``` */
        Set< Map.Entry< String , Integer > > set = map1.entrySet();
        /*```
           9. `.keySet()`
           : 모든 키를 집합(SET)으로 반환.
        ``` */
        Set< String > keys = map1.keySet();
        /*```
           10. `.values( )`
           : 모든 값을 컬렉션 ㅇ
        ``` */
        Collection< Integer > values = map1.values(); // -> 오류 나서 Collection으로 타입 바꾸셨는데 이건 또 뭐야 으아아아악
        /*```

        >***
        >- Map 타입과 반복문 관계
        >   1. 일반 for문 불가능
        >   2. 향상된 for문
        >```
        >for( String key : map1.keySet() ){
        >    System.out.println( map1.get(key) );
        >}
        >```
        >   3. forEach 문
        >      - 꺼낼 엔트리 쌍이 없음. 그래서 키를 꺼냄.
        >```
        >map1.keySet().forEach( (key) -> {
        >    System.out.println(map1.get(key));
        >});
        >```
        >***
        - Map 사용처
        : 정해지지 않은 데이터를 받아서 처리해야 할 때.
        비정형(정리 안 된, 규칙 없는) 데이터 처리에서 Dto 대신 사용됨.
           - Dto는 정해진(설계된) 데이터를 받음.
           - JSON/XML 호환.

        - Map 구현체
        ```*/
        Map< String , Object > map;
        map = new HashMap<>();      // + 싱글 스레드
        map = new Hashtable<>();    // + 멀테스레드 , 동기화
        map = new TreeMap<>();      // + 이진트리(정렬)
        Properties properties = new Properties(); // + Map 구현체는 아니지만 Map 구조를 사용한다. (프로젝트 설정값 파일에서 사용.)
                                                  /* + Hashtable 상속 받은 애
        ```
        미리 Dto 클래스 안 만들고 자료 sql에 저장 가능
         */




    }
}
