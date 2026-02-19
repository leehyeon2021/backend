package day015;

import java.util.ArrayList;

public class Exam1 {
    public static void main(String[] args) {

        /*
        ## 제네릭 타입
        ***
        ### 제네릭 타입 정의

        1. 정의
        : 여러 가지 타입에서 동작할 수 있도록 만든 타입
           - `< >`

        2. 목적
        : 클래스를 정의할 때에 (멤버/매개)변수의 **타입**을 정하지 않고, **인스턴스(객체)를 생성할 때** 타입을 정한다.

        3. 사용법
        : `클래스명< 타입1 , 타입2 > 변수명;`
        ```
        class 클래스명< 제네릭타입1 , 제네릭타입2 >{

            제네릭타입1 멤버변수명;
            void 함수명( 제네릭타입2 매개변수명 ){ }

        }
        ```
           - 제네릭 타입명은 영문 대문자로 한다.
           - 여러 개 가능하다.
           - 함수에도 제네릭 타입이 적용된다.
           - **래퍼 클래스**를 사용해야 한다.
           : 제네릭 타입에 대입되는 타입은 기본 타입이 안 된다.
              - 예) int -> Integer
           1. 제네릭 타입 없는 상황
              - (class Box1,2 만듦)
        ```*/
        Box1 box1 = new Box1();             // 인스턴스란? 미리 설계된 (클래스) 타입. 메모리 생성함. 걍 메모리임
        box1.content = "안녕하세요";          // 멤버변수에 대입
        String content1 = box1.content;     // 멤버변수 값 호출

        Box2 box2 = new Box2();
        box2.content = 100;
        int content2 = box2.content;
        /*```
             - `box2.content2 = "안녕하세요";` : 안 됨. 타입이 다른 멤버변수에는 값 대입 불가능.
           2. 제네릭 타입 사용한 상황
              - (class box3 만듦)
        ```*/
        Box3< String > box3 = new Box3<>();
        box3.content = "안녕하세요";
        String content3 = box3.content;

        Box3< Integer > box33 = new Box3<>();
        box33.content = 100;
        int content33 = box33.content;
        /*```
              - 클래스 만들 때 타입 정한 게 아니라 인스턴스 만들 때 정한 타입으로 결정.
              - 대표 예
                : ArrayList 컬렉션 프레임워크 `ArrayList<>`
        ```*/
        ArrayList< String > list1 = new ArrayList<>();
        /*```
                   - ArrayList 안에서 제네릭타입을 Stirng 타입으로 사용한다는 뜻.
        ```
        ArrayList< Dto > list2 = new ArrayList<>();
        ```
                   - ArrayList 안에서 제네릭타입을 Dto 타입으로 사용한다는 뜻.
           3. 제네릭 타입 여러 개
              - (class Box4 만듦)
        ```
        */
        Box4< String , Integer > box4 = new Box4<>();
        box4.value1 = "안녕하세요";
        box4.value2 = 100;
        /*```
           4. 제네릭 타입 중첩 가능
        ```*/
        Box4< String , ArrayList<String> > box44 = new Box4<>();
        box44.value1 = "안녕하세요";
        box44.value2 = new ArrayList<>();
        /*```
              - 통합할 때 많이 사용한다는데 이해 잘 안 됨
                 - `class responseDto<T>{ T content; }` 응답하는 Dto?
              - +) 복잡할 때는 그냥 Object로 해도 되긴 함. <- 근데 이렇게 하면 복잡해진대
           5. 배열 -> 리스트
        ```*/
        내가만든리스트< String > list2 = new 내가만든리스트<>();

    }
}

// (3. 사용법)
class Box1{ String content; }     // 클래스란? 인스턴스(객체)의 설계도
class Box2{ int content; }
class Box3< 제네릭타입 >{ 제네릭타입 content; }
class Box4< T , E >{ T value1; E value2; }

// 뭐고 이거 엉엉 ㅠㅠㅠㅠ
class 내가만든리스트< E >{
    Object[] content;
    내가만든리스트(){
        content = new Object[10];
    }
}
class 내가만든리스트1< E >{
    E content;
    내가만든리스트1(){
        content = (E)new Object[10];
    }
}