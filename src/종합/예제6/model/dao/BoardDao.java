package 종합.예제6.model.dao;

public class BoardDao {

    // 싱글톤 만들기
    // [1] 잠그기
    private BoardDao(){}
    // [2] 상수 만들기
    private static final BoardDao instance = new BoardDao();
    // [3] 싱글톤
    public static BoardDao getInstance(){
        return instance;
    }
}
