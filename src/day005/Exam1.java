package day005;

// 배열

import java.util.Arrays;

public class Exam1 {
    public static void main(String[] args) {
        // [1] 배열이란? **동일한 타입**의 여러 자료들을 순서대로 저장하는 자료 타입
            // int[ ] arr1 = new int[3];

        // [2] 선언: 타입[ ] 변수명 = new 타입[ 총개수 ];

        // [3] 특징: (1) 동일한 타입끼리(문자,숫자못섞음!!자바,c언어)  (2) 고정길이  (3) 요소의 초기값 존재

        // [4] 인덱스란? 배열 내 요소(값)들이 저장된 순서 번호, 0번 시작
            //new int [3]; // 배열 선언
            int[] arr1 = new int[3]; // int 저장. { 0, 0, 0 }
            String[ ] arr2 = {"봄" , "여름" , "가을" , "겨울"}; // {초기값1 , 초기값2 , 초기값3 , 초기값4}

        // [5] 배열변수의 출력
        System.out.println( arr1 ); // [I@4c873330 라고 나옴. 이건 _배열의 주소_. _메모리위치 값_이 출력된 것임. *주소값은 개발자가 제어 불가능.
        System.out.println( arr2 ); // [Ljava.lang.String;@119d7047
        // [6] 배열변수의 요소/값 전체 출력: Arrays.toString(배열변수명); -> 확인용, 오류 체크용. JS console.log()처럼 나옴.

        System.out.println(Arrays.toString(arr1));  // [0, 0, 0]
        System.out.println(Arrays.toString(arr2));  // [봄, 여름, 가을, 겨울]

        // [*] 배열의 메모리 주소 상태 간단하게 구조 확인하기

        /* ⭐ 숙지해놔야 할 것 같다!! ⭐
            1. new int[3] 선언하면 int 3칸 생김:  int , int , int
            2. int는 4바이트. 총 12바이트 생성된다.
            3. 바이트는 최소의 (윈도우) 저장 단위를 바이트(위치/주소 값)로 봄. (근데 처리는 bit 단위로 함. 뭐야!!)
                -> 12주소값 생성(12바이트라서.) , 101번지 102번지 103번지 104번지 , 201번지 202번지 203번지 204번지 , 301번지 302번지, 303번지 304번지
                +) 주소값은 16진수... 이상하게 적혀있다.
            4. 배열의 변수는 총 12개의 주소값을 모두 가진게 아니고, 가장 첫번째의 주소값을 가진다("첫 번째 값을 point로 잡는다."). 첫 번째 값의 첫 번째 바이트 저장.
                int arr1 = new int[3];
                arr1 = 101번지 : 변수에는 첫 번째 요소의 주소값이 저장되어있다.
                -->> 동일한 타입이어야지만 배열 식별 가능. int(4byte)는 첫 번째 요소에서 4칸씩 띄어쓰기 한다.
            5. 실행 중에 개발자가 배열내 주소값 삭제할 수 없다.
               -> 배열 중간의 주소값을 개발자가 임의로 삭제할 수 없다. 201번지 배열을 중간에 임의로 삭제하기 불가.
               +) JS는 delete(삭제) 대신 splice(접착. 새롭게 붙이다)
            6. 주소값에 초기값이 생략되면 임의의 초기값이 자동으로 들어간다.
               -> 자바에는 가비지컬렉터<GC>(쓰레기 수집기)가 있다. GC는 비어있는 메모리를 삭제한다.
                  그래서 GC가 삭제하지 못하게 (배열의 위치(주소값)을 유지하려고) 임의의 초기값을 자동으로 넣는다. (0이나 0.0 같은 거)
               -> 초기값) 정수: 0. 실수: 0.0. 문자열/객체: Null(진짜 비어있는 게 아님). 논리: false.
               +) 0 vs. null vs. 초기값없는메모리(쓰레기값)(임의) -> 세 개 다 다른 것이다.
        */

        // [7] 배열 사용
        System.out.println(arr1.length); //소괄호없음. 배열변수명.length: 배열의 총길이 (=3)

        // [8] 배열내 요소 값 수정
        arr1[0] = 10;   // 배열변수명[인덱스] = 새로운값;   값만 바뀌지 주소값은 그대로이다.
        System.out.println(arr1[0]);    // 배열변수명[인덱스]
        arr2[1] = "Spring";
        System.out.println(arr2[1]);

        // [9] 배열의 요소 추가
        //arr1[4] = 40;   // 오류 문구:  ··· java.lang.ArrayIndexOutOfBoundsException: Index 4 out of bounds for length 3 ···
        // Index 4 out of bounds(저장) for length 3 -> 저장할 수 있는 인덱스가 넘쳤다.

        // [10] 반복문 활용
        for( int index = 0 ; index <= arr1.length-1 ; index++ ){
            System.out.println(arr1[index]); // [index]번째 요소값 가져오기/출력
        }
        // [11] ⭐ 향상된 for문 : 위와 같이 많이 사용되므로 추가된 반복문. 이터레이터(순회자,반복자)
            // for( 타입 반복변수명 : 배열변수명 ){ }
        // +) iterator(이터레이터/반복자/순회자)가 가능한 배열/객체만 가능하다.
        for(int value : arr1 ){
            System.out.println(value);
        }


    }
}
