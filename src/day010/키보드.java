package day010;

public interface 키보드 {
    // 인터페이스의 핵심: 1) 상수 2) 추상메소드.

    // 상수  (public static final은 생략 가능.)
    public static final String 제조사 = "인텔";
    String 제조일 = "2026-02-24";

    // 추상메소드  (public static final은 생략 가능.)
    public abstract void aKey();
    int bKey( int x , int y );
}
