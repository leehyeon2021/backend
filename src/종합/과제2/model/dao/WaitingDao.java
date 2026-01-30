package 종합.과제2.model.dao;

// 대기 명단을 실제로 저장/관리하는 저장소
// ArrayList를 사용하여 대기 목록 관리 (DB역할)

import 종합.과제2.model.dto.WaitingDto;
import java.util.ArrayList;

public class WaitingDao {

    // 싱글톤 만들기
    // 1. 잠그기
    private WaitingDao(){}
    // 2. 상수 이용한 인스턴스 만들기
    private static final WaitingDao instance = new WaitingDao();
    // 3. 싱글톤 반환
    public static WaitingDao getInstance(){
        return instance;
    }

    // 저장소 생성
    private static final ArrayList<WaitingDto> waitingList = new ArrayList<>();
    // 번호 (자동 부여)
    private static int no = 1;

    // 전화번호 인원수 영구 저장
    public boolean add( String phone , int count ){
        WaitingDto boardDto = new WaitingDto( no , phone , count );
        boolean saveResult = waitingList.add(boardDto);
        no++;
        return saveResult;
    }

    // 전체 목록 반환
    public ArrayList<WaitingDto> findAll(){
        return waitingList;
    }


}
