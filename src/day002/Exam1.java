package day002; // 클래스가 위치한 폴더/패키지명 <식별>
                // 같은 패키지에서는 동일한 이름의 클래스가 존재할 수 없다.

public class Exam1 {
    public static void main(String[] args) {

    // ⭐ [1] 타입 = 자료형 = 분류 = 자료들을 분류/나누는 방법 ⭐
        // (1) 자동 타입 변환('캐스팅') (묵시적: 개발자가 따로 (명시)할 게 없다.(자동!!)), 손실 없다.
        // byte  -> short -> int -> long -> float -> double (작은상자 -> 큰상자 : 손실 없음!)
        byte byteValue = 10;                 // 10 자료를 byte 타입으로 분류했다.
        short shortValue = byteValue;        // byte 타입 -> short 타입 변환
        int intValue = shortValue;            // short 타입 -> int 타입 변환
        long longValue = intValue;            // int 타입 -> long 타입 변환
        float floatValue = longValue;        // long 타입 -> float 타입 변환
        double doubleValue = floatValue;     // float 타입 -> double 타입 변환

        // (2) 연산중 (자동) 타입변환
        // byte + byte = int , byte + short = int , int + int = int , int 이하 피연산자들은 연산하면 int로 결과
        // long / float / double 들은 피연사자 중에 더 큰 타입으로 결과나옴.
        byte b1 = 10;   byte b2 = 20;   short s1 = 30;   int i1 = 40;   long l1 = 50L;   float f1 = 3.13F;   double d1 = 41.24;
        int result1 = b1 + b2;      // byte + byte = int
        int result2 = b1 + s1;      // byte + short = int
        int result3 = i1 + i1;      // int + int = int
        long result4 = i1 + l1;     // int + long = long
        float result5 = i1 + f1;    // int + float = float
        double result6 = i1 + d1;   // int + double = double
        // int result7 = i1 + d1;   <- 이런 식으로 하면 오류 남.

                // ⭐⭐ 중요!! 자바는 !! 다형성 !! 이라는 특징을 가진다. (나중에 배운다고 하심)
                // 다형성: 다양한 형태/모양을 갖는다. 하나의 자료값을 내용물은 그대로인데 껍질을 바꾸는 것.
                // 자료 10은 그대로이지만, 껍데기(타입/형식) 바꿀 수 있는 것.
                // -> 다형성은 상속과 연결되고 상속은 인터페이스와 연관됨.
                    // 본질: tv , 껍데기: lg리모컨, 삼성리모컨...
                        // 리모컨 호완 바꾸면서 본질은 해치지 않는 것이 다형성이다.

        // (3) 강제 타입 변환/캐스팅 (명시적: 개발자가 변환할 타입 작성) , 손실 있다.
        // double -> float -> long -> int -> short -> byte , (큰 상자 -> 작은 상자: 거꾸로 가니 손실 발생.)
        // (새로운타입)기존값
        double dValue = 3.14;
        float fValue = (float)dValue;   // (새로운타입)기존값
        long lValue = (long)fValue;
        int iValue = (int)lValue;
        short sValue = (short)iValue;
        byte bValue = (byte)sValue;     // bValue에는 3 자료가 들어있다. 손실이 발생한 것.



    }
}
