package 종합.과제2.controller;

// View와 DAO 사이의 중간 제어자

import 종합.과제2.model.dao.WaitingDao;
import 종합.과제2.model.dto.WaitingDto;
import java.util.ArrayList;

public class WaitingController {

    // 싱글톤
    // 1. 잠그기
    private WaitingController(){}
    // 2. 상수 만들기 인스턴스
    private static final WaitingController instance = new WaitingController();
    // 3. 싱글톤 반환
    public static WaitingController getInstance(){
        return instance;
    }

    // DAO 싱글톤 호출
    private WaitingDao wd = WaitingDao.getInstance();

    // 등록 제어 - 전화번호 인원수 영구 저장
    public boolean addWaiting( String phone , int count ){
        boolean saveResult = wd.add( phone , count );
        return saveResult;
    }
    // 전체 목록 반환
    public ArrayList<WaitingDto> getWaitingList(){
        ArrayList<WaitingDto> listAll = wd.findAll();
        return listAll;
    }

}
