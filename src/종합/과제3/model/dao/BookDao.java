package 종합.과제3.model.dao;

import 종합.과제3.model.dto.BookDto;

import java.util.ArrayList;

public class BookDao {
    private BookDao(){}
    private static final BookDao instance = new BookDao();
    public static BookDao getInstance(){
        return instance;
    }

    private ArrayList<BookDto> bookList = new ArrayList<>();
    private int currentBno = 1;

    // 제품 등록
    public boolean add(String bname , String bw , String bp , int mno){ // mno는 대출 기능 만들어야 함
        BookDto bookDto = new BookDto(currentBno , bname , bw , bp, mno);
        boolean result = bookList.add(bookDto);
        if(result){currentBno++;}
        return result;
    }

    // 전체 반환
    public ArrayList<BookDto> findAll(){
        return bookList;
    }
}
