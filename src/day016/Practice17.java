package day016;

import java.util.*;

public class Practice17 {
    public static void main(String[] args) {

        // [1]
        Box<String> box1 = new Box<>();
        box1.content = "안녕하세요";
        String content1 = box1.content;
        Box<Integer> box2 = new Box<>();
        box2.content = 100;
        int content2 = box2.content;
        System.out.println("[문자] "+content1);
        System.out.println("[숫자] "+content2);

        // [2]
        List<String> list = new ArrayList<>();
        list.add("유재석");
        list.add("강호동");
        list.add("서장훈");
        list.add("신동엽");
        list.add("유재석");
        System.out.println("[contains] "+list.contains("서장훈"));
        System.out.println("[indexOf] "+list.indexOf("서장훈"));
        list.remove( list.indexOf("서장훈"));
        System.out.println("[삭제 후] " + list);

        // [3]
        int[] draw = {1,3,3,7,9,9,2,10,10,8,4,4,6,6,5};
        Set<Integer> lottoSet = new HashSet<>(); // Set 컬렉션. 자동 중복 제거됨!
        for(int i=0;i<draw.length;i++){
            lottoSet.add(draw[i]);
        }
        System.out.println("[추첨결과] "+lottoSet);
        System.out.println("[개수] "+lottoSet.size());
        System.out.println("[contains] "+lottoSet.contains(7));

        // [4]
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.addAll(lottoSet); // `.addAll(집합객체)`:  다른 집합의 요소들을 새로운 요소에 대입. 다른 집합에 있는 걸 한 번에 대입할 수 있다.
        System.out.println("[정렬된 추첨번호] "+treeSet.descendingSet()); // `.descendingSet()`: 내림차순 자동 정렬

        // [5]
        Map<String,Integer> map = new HashMap<>();
        map.put("유재석",95); map.put("유재석",67); // 나중에 입력된 67이 남음
        map.put("강호동",100); map.put("신동엽",78); map.put("서장훈",100);
        System.out.println("[get 유재석] "+map.get("유재석"));
        System.out.println("[size] "+map.size());
        map.remove("유재석");
        System.out.println("[remove 후 map] "+map);

        // [6]
        System.out.println("[containsKey 강호동] "+map.containsKey("강호동"));
        System.out.println("[containsValue 65] "+map.containsValue(65));
        System.out.println("[all]");
        // for(int i=0;i<map.size();i++){}  인덱스 없어서 일반 FOR문은 못 함.
        for(String key : map.keySet()){ // 향상된 FOR문
            System.out.println(key+"="+map.get(key));
        }
        System.out.println("[all]");
        map.keySet().forEach( (key) -> { // forEach문
            System.out.println(key+" = "+map.get(key));
        } );

        // [7]
        // -> 자바 외 다른 곳에서 데이터를 받아올 때 정리 필요!
        // - '데이터 전처리': 현재 상황에 맞게 데이터를 수정하는 것.
        String json = "{\"name\":\"유재석\",\"age\":45,\"city\":\"서울\"}"; // localStorage 같은 거.
        Map<String, String> jsonMap = new HashMap<>();
        // { } 제거: `문자열.replace( "기존문자" , "새로운문자");`
        json = json.replace("{",""); json = json.replace("}","");
        // `문자열.split( "기준문자" )`: 문자열 내 "기준문자"기준으로 분리하여 split.
        String[] jsonAry = json.split(",");        System.out.println( Arrays.toString( jsonAry ));
        // 위에서 세 덩어리로 쪼개졌으니 하나씩 확인하려고 for문 사용.
        for(int i=0;i<jsonAry.length;i++){
            String str = jsonAry[i];   //System.out.println("str = " + str);
            String[] strAry = str.split(":");   //System.out.println(Arrays.toString(strAry));
            // 예) strAry[0] = "name" , strAry[1] = "유재석".
            // 즉, 0번 인덱스는 key(속성) , 1번 인덱스는 value(값). 이렇게 두 개 넣어줘야 함
            jsonMap.put( strAry[0].replaceAll("\"","") , strAry[1].replaceAll("\"","") );
                // - 큰따옴표 제거.
        }
        System.out.println("[name] "+jsonMap.get("name"));
        System.out.println("[age] "+jsonMap.get("age"));
        System.out.println("[all]");
        jsonMap.keySet().forEach(key -> {
            System.out.println(key+" = "+jsonMap.get(key));
        });
        /*
        [all]
        city = 서울
        name = 유재석
        age = 45
        왜 이렇게 나오지?!??????
         */


        // [8] Dto보다는 Map을 사용한다.
        ArrayList< Map< String, Object > > stockList = new ArrayList<>();
        // ⚠️ 주의: Dto 1개가 Map 1개이다. put 1개가 속성 1개이다. new Dto == new Map.
        Map< String , Object > map1 = new HashMap<>();
        map1.put("name", "삼성전자");        map1.put("price", 72000);        map1.put("volume", 1500000);
        stockList.add(map1);
        Map< String , Object > map2 = new HashMap<>();
        map2.put("name","카카오");        map2.put("price",52000);        map2.put("volume",800000);
        stockList.add(map2);
        Map< String , Object > map3 = new HashMap<>();
        map3.put("name","네이버");        map3.put("price",210000);        map3.put("volume",300000);
        stockList.add(map3);
        System.out.println("[stockList] " + stockList); //stockList = [{volume=1500000, price=72000, name=삼성전자}, {volume=800000, price=52000, name=카카오}, {volume=300000, price=210000, name=네이버}]
        stockList.forEach((stock) -> {
            System.out.printf("종목명: %s / 가격: %d / 거래량: %d\n", stock.get("name"), stock.get("price"), stock.get("volume"));
        });
    }
}
    /*[실습] 제출용 */
    /*-------------------------------------------
    [문제 1] 제네릭 Box<T> 기본 활용
    상황: 타입별 클래스(Box1, Box2)를 하나의 제네릭 클래스로 통합한다.
    요구사항(구현):
    - Box<T> 클래스 생성 (public T content)
    - Box<String> → "안녕하세요" 저장 후 출력
    - Box<Integer> → 100 저장 후 출력
    출력 예시:
    [문자] 안녕하세요
    [숫자] 100
    -------------------------------------------*/
class Box< T >{
    public T content;
}
    /*-------------------------------------------
    [문제 2] List 검색 + 삭제 (contains / indexOf / remove)
    상황: 명단 리스트에서 특정 이름이 존재하는지 확인하고,
    위치를 찾아 삭제한 뒤 결과를 확인한다.
    요구사항(구현):
    1) List<String> list = new ArrayList<>();
    2) 아래 데이터를 순서대로 add 한다.
       "유재석"  "강호동"  "서장훈"  "신동엽"  "유재석"
    3) "서장훈"에 대해 아래 작업 수행:
       - contains("서장훈") 결과 출력
       - indexOf("서장훈") 결과 출력
    4) remove( indexOf("서장훈") ) 를 사용하여 삭제
    5) 삭제 후 list 전체 출력
    출력 예시:
    [contains] true
    [index] 2
    [삭제후] [유재석, 강호동, 신동엽, 유재석]
    -------------------------------------------*/

    /*-------------------------------------------
    [문제 3] 추첨번호 생성: 중복 제거 Set (HashSet)
    상황: 1~10 사이 번호를 15번 뽑았더니 중복이 생겼다.
    중복을 제거하고 최종 번호 목록을 확인해야 한다.
    고정 데이터: int[] draw = {1,3,3,7,9,9,2,10,10,8,4,4,6,6,5};
    요구사항(구현):
    - Set<Integer> lottoSet = new HashSet<>();
    - draw 배열을 Set에 add하여 중복 제거
    - Set 전체 출력
    - size() 출력
    - contains(7) 출력
    출력 예시(순서는 달라도 됨):
    [추첨결과] [1,2,3,4,5,6,7,8,9,10]
    [개수] 10
    [contains 7] true
    -------------------------------------------*/

    /*-------------------------------------------
    [문제 4] 추첨번호 정렬 출력: TreeSet 활용
    상황: 추첨번호를 “중복 제거 + 자동 정렬”해서 보기 좋게 출력해야 한다.
    요구사항(구현):
    - 문제4의 draw 배열을 그대로 사용
    - TreeSet<Integer> treeSet에 add
    - treeSet 전체 출력(오름차순 확인)
    출력 예시:
    [정렬된 추첨번호] [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
    -------------------------------------------*/

    /*-------------------------------------------
    [문제 5] Map 점수 관리 CRUD (put/get/remove/size)
    상황: 학생 이름(key)과 점수(value)를 Map으로 관리한다.
    요구사항(구현):
    - Map<String,Integer> map = new HashMap<>();
    - put:
      유재석=95, 강호동=100, 신동엽=78, 유재석=67(키 중복 시 값 변경 확인), 서장훈=100
    - get("유재석") 출력
    - size() 출력
    - remove("유재석") 후 map 전체 출력
    출력 예시(순서는 달라도 됨):
    [get 유재석] 67
    [size] 4
    [remove 후 map] {서장훈=100, 강호동=100, 신동엽=78}
    -------------------------------------------*/

    /*-------------------------------------------
    [문제 6] Map 검색 + 전체 출력 (containsKey/containsValue + keySet 반복)
    상황: Map에서 key 존재 여부를 확인하고, 전체 데이터를 출력해야 한다.
    요구사항(구현):
    - 문제6 map을 그대로 사용
    - containsKey("강호동") 결과 출력
    - containsValue(65) 결과 출력
    - keySet() 반복문으로 key=value 전체 출력
    출력 예시:
    [containsKey 강호동] true
    [containsValue 65] false
    [all]
    서장훈=100
    강호동=100
    신동엽=78
    -------------------------------------------*/

    /*-------------------------------------------
    [문제 7] JSON 문자열(단순) → Map 변환 + 조회/반복 출력
    상황: API에서 온 JSON 문자열을 파싱해서 Map으로 저장하고 사용해야 한다.
    입력 JSON (고정):
    String json = "{\"name\":\"유재석\",\"age\":45,\"city\":\"서울\"}";
    요구사항(구현):
    - Map<String, String> map = new HashMap<>();
    - 파싱 규칙:
     - { } 제거
     - , 기준 split
     - : 기준 split(2개로만)
     - 큰따옴표 " 제거
     - value도 전부 String으로 저장 (age도 "45")
    - 저장 후
     - map.get("name") 출력
     - map.get("age") 출력
     - keySet 반복문으로 key=value 전체 출력
    출력 예시(순서는 달라도 됨):
    [name] 유재석
    [age] 45
    [all]
    name=유재석
    age=45
    city=서울
    -------------------------------------------*/

    /*-------------------------------------------
    [문제 8] ArrayList<StockDto> → ArrayList<Map<String,Object>> 구조로 구현
    상황: 기존에는 StockDto 클래스를 만들어 주식 데이터를 저장했지만, 이번에는 DTO 없이 Map 구조로 데이터를 관리한다.
    기존 DTO 개념 (참고):
    class StockDto {
        String name;
        int price;
        int volume;
    }
    변경 목표: ArrayList<Map<String,Object>> 구조로 동일 데이터 표현
    요구사항(구현):
    1) ArrayList<Map<String,Object>> stockList 생성
    2) 아래 3개의 주식 데이터를 Map으로 생성 후 stockList에 add
       (1)
       name = "삼성전자"
       price = 72000
       volume = 1500000
       (2)
       name = "카카오"
       price = 52000
       volume = 800000
       (3)
       name = "네이버"
       price = 210000
       volume = 300000
    3) 전체 리스트 출력
    4) 반복문을 사용하여 아래 형식으로 출력:
       종목명: 삼성전자 / 가격: 72000 / 거래량: 150000
       종목명: 카카오 / 가격: 52000 / 거래량: 800000
       종목명: 네이버 / 가격: 210000 / 거래량: 300000
    출력 예시:
    [stockList] [{...},{...},{...}]
    종목명: 삼성전자 / 가격: 72000 / 거래량: 1500000
    종목명: 카카오 / 가격: 52000 / 거래량: 800000
    종목명: 네이버 / 가격: 210000 / 거래량: 300000  */