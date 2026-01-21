package day003;

// if문

public class Exam1 {
    public static void main(String[] args) {
        // [1] 조건문 if : 만약에~ / 경우의 수 등장 시 사용.
        // (1) 사용1:   if( 조건문 ) 실행문;
        int 온도 = 5;
        if(온도 <= 10) System.out.println("외투 입는다. ");

        // (2) 사용2:  if( 조건문 ) { 실행문; 실행문; }
        int 나이 = 10;
        if( 나이 >= 19 ){
            System.out.println("성인 입니다.");
            System.out.println("성인이 아닙니다.");
        }

        // (3) 사용3:  if( 조건문 ) { 실행문; } else{ 실행문; }
        boolean 회원검사 = false;
        if( 회원검사 == true ){
            System.out.println("안녕하세요 회원님.");}
        else {
            System.out.println("비회원입니다.");
        }

        // (4) 사용4:  if( 조건문 ){ 실행문; } else if( 조건문 ){ 실행문; }   다수 조건에 하나 실행문
            // 쓰다 안 보여서 놓침

        // (5) 사용5:  if( 조건문 ){ 실행문; } if( 조건문 ){ 실행문; }        다수 조건에 다수 실행문

        // (6) if 중첩
        int age = 25;
        char gender = 'w';
        if(age >= 19){
            System.out.println("성인");
            if(gender == 'w'){
                System.out.println("[여자]");
            }else{
                System.out.println("[남자]");
            }
        }else {
            System.out.println("[미성년자]");
        }

        // (7) switch문: 논리 검사 보다는 값에 따른 흐름 제어할 때 사용한다. 중첩 가능하다.
        //               breck: switch{} 탈출. 해당 case 실행 후 멈춤. break 필수. 위에서부터 모두 사용하려면 switch가 나음.
//        switch ( 값 ){
//            case 비교값:
//                실행문;
//            case 비교값:
//                실행문;
//            default:
//                실행문;
//        }
          char grade = 'B';
          switch ( grade ){ // switch에 '등급'을 대입하고   (소괄호 안에 논리 불가능.)
              case 'A': //만일 'A'등급이면    (*case가 일치하면 실행된다. 아래 case도 일치하기 때문에 모두 실행된다!!) -> break; 해주기.
                  System.out.println("우수 학생");
                  break;    // switch 탈출한다.
              case 'B':
                  System.out.println("장려 학생");
                  break;
              default:
                  System.out.println("그 외");
          }
        // (8) switch 중첩
            int adult = 1; //성인
            char gender1 = 'w';
            switch (adult){
                case 1:
                System.out.println("[성인]");
                switch (gender1){
                    case 'w':
                        System.out.println("[여자]");
                        break;
                    default:
                        System.out.println("[남자]");
                }
                break;
                default:
                    System.out.println("[미성년자]");
            }


        // if와 switch
        // if: 값이 정해져있지 않고 논리에 따라 실행        (범위 경우의 수)
        // switch: 정해진 어떤 값에 흐름 제어가 필요할 때   (정해진 경우의 수)










    }
}
