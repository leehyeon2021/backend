package 종합.과제3.controller;

import 종합.과제3.model.dao.BookDao;
import 종합.과제3.model.dto.BookDto;

import java.util.ArrayList;

public class BookController {
    private BookController(){}
    private static final BookController instance = new BookController();
    public static BookController getInstance(){
        return instance;
    }

    private BookDao bd = BookDao.getInstance();

    // 도서 추가
    public boolean add(String bname , String bw , String bp, int mno){
        BookDto bookDto = new BookDto();
        if(mno==0){boolean result = bd.add(bname , bw , bp, mno);}
        else if (mno>0) {return false;}
        return true;
    }

    // 전체 검색
    public ArrayList<BookDto> findAll(){
        ArrayList<BookDto> result = bd.findAll();
        return result;
    }


}
