package day008;

import java.util.ArrayList;

public class Exam1 {
    public static void main(String[] args) {

        // [1] ArrayList 클래스: 컬렉션(수집)프레임(틀)워크(일). 수집 관련 클래스/기능 제공하는 애.
        // [2] 정의: 컬렉션프레임워크 중 리스트(배열) 자료형 클래스/타입
        // [3] 목적: 가변(변하는요소들의수)길이의 배열, 기능/메소드를 제공해서 편하다.
        // [4] 사용법
            // 1. 선언/정의하기 : ArrayList<항목타입> 변수명 = new ArrayList<>
                            // <>꺽쇠 : 제네릭 타입. 리스트 안에 저장할 항목들의 타입. (제네릭 타입은 뒤에서 배움)
                                // 제네릭타입: 기본타입 불가능. int -> Integer 클래스로 변경(대문자)해서 작성(String처럼). (8개 타입) 자동완성 됨!
        ArrayList< String > 리스트변수명 = new ArrayList<>(); // 여러개 String 객체를 저장하는 리스트
        // vs. String[] 변수명 = new String[100];
            // 2. 요소 추가: .add( 새로운값 ); for문 안 써도 빈칸에 대입 가능. (push랑 같음.) 마지막 요소에 자료 추가!
        리스트변수명.add( "유재석" );
            // 3. 요소들 전체 출력 : 리스트변수명
        System.out.println( 리스트변수명 ); // [유재석] <-이렇게 나옴
        리스트변수명.add("강호동"); 리스트변수명.add("신사임당"); 리스트변수명.add("홍길동");
        System.out.println( 리스트변수명 ); // [ 유재석, 강호동, 심사임당, 홍길동 ]
            // 4. 요소 중간 삽입 : .add( 인덱스 , 새로운값 ) : 특정한 인덱스에 자료 추가
                // 인덱스란? 배열/리스트에 요소/값들이 저장된 순서 번호. 0번부터 시작.
        리스트변수명.add( 1 , "남도일");
        System.out.println("리스트변수명: " + 리스트변수명); // [ 유재석 , 남도일 , 강호동, 심사임당 , 홍길동]
            // 5. 요소 수정 : .set( 인덱스 , 새로운값 ); : 특정한 인덱스의 자료 수정
        리스트변수명.set( 1, "박명수");        System.out.println("리스트변수명"+리스트변수명);
            // 6. 요소 총 개수: .size(): 리스트 내 항목/요소/값(일리먼트)들의 총 개수를 반환한다. length(배열) 대신 size(리스트).
        System.out.println( 리스트변수명.size() );
            // 7. 요소 값 호출: .get( 인덱스 ) : 특정한 인덱스의 요소값 반환. 배열명[인덱스]는 안 씀. getter(호출) setter(저장) 사용함.
        System.out.println( 리스트변수명.get(0) ); // 유재석
        System.out.println( 리스트변수명.get(2) ); // 강호동
            // 8. 요소 삭제 : .remove( 인덱스 ) : 특정한 인덱스의 요소 삭제
        리스트변수명.remove( 1 ); // 1번 인덱스의 요소 삭제
        System.out.println("리스트변수명 = " + 리스트변수명); // [ 유재석, 강호동, 심사임당 , 홍길동 ]
            // 9. 요소 찾기 : .indexOf( 찾을값 ) : 찾을값이 존재하면 인덱스 반환 , 없으면 -1. (==반환 타입 1)
        int 찾은결과 = 리스트변수명.indexOf( "강호동" );  System.out.println( "강호동 인덱스: " + 찾은결과 ); // 1
            // 10. 요소 찾기2: .contains( 찾을값 ) : 찾을값이 존재하면 true , 없으면 false 반환한다.
        boolean 찾은결과2 = 리스트변수명.contains( "강호동" );
        System.out.println("찾은결과2 = " + 찾은결과2); // 강호동은 존재하므로 true이다.
            // 11. 요소 전체 삭제: .clear()
        리스트변수명.clear();
            // 12. 요소 존재 여부: .isEmpty() : 리스트 내 요소가 하나도 없으면 true 있으면 false.
        리스트변수명.isEmpty(); // .clear() 했으므로 true 출력.

        // [5] 반복문과 리스트의 활용
            // 1. 일반 for문
        for( int index = 0 ; index <= 리스트변수명.size() -1 ; index++){ // 리스트는 .length 아니고 .size()
            System.out.println("리스트변수명.get(index) = " + 리스트변수명.get(index));
        }
            // 2. 향상된 for문
        for( String str : 리스트변수명){
            System.out.println("str = " + str);
        }

    }// main end
}// class end
