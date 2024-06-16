import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BookManagerTest {
	
	private BookManager bookManager;
	private BookManager.Book book1;	// 모든 유닛 테스트에서 사용하는 객체이기 때문에 전역 선언함 

    @BeforeEach
    void setUp() {
        bookManager = new BookManager();
        book1 = bookManager.new Book("1", "자바 기초", "Jane", 2021);
    }

	@Test
	void testAddBook() {
		System.out.println("testAddBook() 실행");
		// book1 추가 
		// 정답 문자열 
		String answer1 = "Book{id: '1', 제목: '자바 기초', 저자: 'Jane', 출판년도: 2021}도서가 추가되었습니다.";
		// 결과 문자열 
		String result1 = bookManager.AddBook(book1);
		
		// 두 문자열 비교 
		assertEquals(answer1, result1, answer1 + "가 출력되지 않았습니다." );
		System.out.println(result1);
		
		
		// 중복 추가 테스트 
		String answer2 = "해당 ID(1) 는 이미 존재합니다.";
		String result2 = bookManager.AddBook(book1);
		
		assertEquals(answer2, result2, answer2 + "가 출력되지 않았습니다." );
		System.out.println(result2);
		
		
		// 검색 테스트 
		String answer3 = "검색 결과:" + System.lineSeparator() + "Book{id: '1', 제목: '자바 기초', 저자: 'Jane', 출판년도: 2021}";
		String result3 = bookManager.SearchBook("1");
		
		assertEquals(answer3, result3, answer3 + "가 출력되지 않았습니다." );
		System.out.println(result3);
	}

	@Test
	void testSearchBook() {
		System.out.println("testSearchBook() 실행");
		// book1 추가 
		String answer1 = "Book{id: '1', 제목: '자바 기초', 저자: 'Jane', 출판년도: 2021}도서가 추가되었습니다.";
		String result1 = bookManager.AddBook(book1);
		
		assertEquals(answer1, result1, answer1 + "가 출력되지 않았습니다." );
		System.out.println(result1);
		
		
		// book2 추가 
	    BookManager.Book book2;
		book2 = bookManager.new Book("2", "소프트웨어 공학", "Tom", 2014);

		String answer2 = "Book{id: '2', 제목: '소프트웨어 공학', 저자: 'Tom', 출판년도: 2014}도서가 추가되었습니다.";
		String result2 = bookManager.AddBook(book2);

		assertEquals(answer2, result2, answer2 + "가 출력되지 않았습니다." );
		System.out.println(result2);
		
		
		// book3 추가 
	    BookManager.Book book3;
		book3 = bookManager.new Book("3", "분산 컴퓨팅", "Yoon", 2024);

		String answer3 = "Book{id: '3', 제목: '분산 컴퓨팅', 저자: 'Yoon', 출판년도: 2024}도서가 추가되었습니다.";
		String result3 = bookManager.AddBook(book3);

		assertEquals(answer3, result3, answer3 + "가 출력되지 않았습니다." );
		System.out.println(result3);
		
		
		// id가 각각 1, 2, 3, 4일 때의 검색  
		String answer4 = "검색 결과:" + System.lineSeparator() + "Book{id: '1', 제목: '자바 기초', 저자: 'Jane', 출판년도: 2021}";
		String result4 = bookManager.SearchBook("1");
		assertEquals(answer4, result4, answer4 + "가 출력되지 않았습니다." );
		System.out.println(result4);
		

		String answer5 = "검색 결과:" + System.lineSeparator() + "Book{id: '2', 제목: '소프트웨어 공학', 저자: 'Tom', 출판년도: 2014}";
		String result5 = bookManager.SearchBook("2");
		assertEquals(answer5, result5, answer5 + "가 출력되지 않았습니다." );
		System.out.println(result5);
		

		String answer6 = "검색 결과:" + System.lineSeparator() + "Book{id: '3', 제목: '분산 컴퓨팅', 저자: 'Yoon', 출판년도: 2024}";
		String result6 = bookManager.SearchBook("3");
		assertEquals(answer6, result6, answer6 + "가 출력되지 않았습니다." );
		System.out.println(result6);
	

		String answer7 = "검색된 도서가 없습니다.";
		String result7 = bookManager.SearchBook("4");
		assertEquals(answer7, result7, answer7 + "가 출력되지 않았습니다." );
		System.out.println(result7);
		
	}
	
	@Test
	void testRemoveBook() {
		System.out.println("testRemoveBook() 실행");
		// book1 추가 
		String answer1 = "Book{id: '1', 제목: '자바 기초', 저자: 'Jane', 출판년도: 2021}도서가 추가되었습니다.";
		String result1 = bookManager.AddBook(book1);
		
		assertEquals(answer1, result1, answer1 + "가 출력되지 않았습니다." );
		System.out.println(result1);
		
		
		// book2 추가 
	    BookManager.Book book2;
		book2 = bookManager.new Book("2", "소프트웨어 공학", "Tom", 2014);

		String answer2 = "Book{id: '2', 제목: '소프트웨어 공학', 저자: 'Tom', 출판년도: 2014}도서가 추가되었습니다.";
		String result2 = bookManager.AddBook(book2);

		assertEquals(answer2, result2, answer2 + "가 출력되지 않았습니다." );
		System.out.println(result2);
		
		
		// id가 1인 책 삭제
		String answer3 = "Book{id: '1', 제목: '자바 기초', 저자: 'Jane', 출판년도: 2021}도서를 삭제하였습니다.";
		String result3 = bookManager.RemoveBook("1");
		
		assertEquals(answer3, result3, answer3 + "가 출력되지 않았습니다." );
		System.out.println(result3);

		
		// id가 1인 책 다시 삭제
		String answer4 = "해당 ID(1)의 도서를 찾을 수 없습니다.";
		String result4 = bookManager.RemoveBook("1");
		
		assertEquals(answer4, result4, answer4 + "가 출력되지 않았습니다." );
		System.out.println(result4);
		
		// id가 1인 책 검색 
		String answer5 = "검색된 도서가 없습니다.";
		String result5 = bookManager.SearchBook("1");
		assertEquals(answer5, result5, answer5 + "가 출력되지 않았습니다." );
		System.out.println(result5);
	}
	
	@Test
	void testRemoveThenAddBook() {
		System.out.println("testRemoveThenAddBook() 실행");
		// id가 1인 book1 추가 
		String answer1 = "Book{id: '1', 제목: '자바 기초', 저자: 'Jane', 출판년도: 2021}도서가 추가되었습니다.";
		String result1 = bookManager.AddBook(book1);
		
		assertEquals(answer1, result1, answer1 + "가 출력되지 않았습니다." );
		System.out.println(result1);
		

		// id가 1인 책 검색 
		String answer2 = "검색 결과:" + System.lineSeparator() + "Book{id: '1', 제목: '자바 기초', 저자: 'Jane', 출판년도: 2021}";
		String result2 = bookManager.SearchBook("1");

		assertEquals(answer2, result2, answer2 + "가 출력되지 않았습니다." );
		System.out.println(result2);
		
		// id가 1인 책 삭제
		String answer3 = "Book{id: '1', 제목: '자바 기초', 저자: 'Jane', 출판년도: 2021}도서를 삭제하였습니다.";
		String result3 = bookManager.RemoveBook("1");
		
		assertEquals(answer3, result3, answer3 + "가 출력되지 않았습니다." );
		System.out.println(result3);

		
		// id가 1인 책 검색 
		String answer4 = "검색된 도서가 없습니다.";
		String result4 = bookManager.SearchBook("1");
		
		assertEquals(answer4, result4, answer4 + "가 출력되지 않았습니다." );
		System.out.println(result4);
		
		
		// id가 1인 책 다시 추가 
		String answer5 = "Book{id: '1', 제목: '자바 기초', 저자: 'Jane', 출판년도: 2021}도서가 추가되었습니다.";
		String result5 = bookManager.AddBook(book1);

		assertEquals(answer5, result5, answer5 + "가 출력되지 않았습니다." );
		System.out.println(result5);
		
		// id가 1인 책 다시 검색 

		String answer6 = "검색 결과:" + System.lineSeparator() + "Book{id: '1', 제목: '자바 기초', 저자: 'Jane', 출판년도: 2021}";
		String result6 = bookManager.SearchBook("1");

		assertEquals(answer6, result6, answer6 + "가 출력되지 않았습니다." );
		System.out.println(result6);
		
	}
	
	@Test
	void testAddInvalidBook() {
		System.out.println("testAddInvalidBook() 실행");

	    BookManager.Book book2;
		book2 = bookManager.new Book("", "소프트웨어 공학", "Tom", 2014);
		
		// id가 없는(invalid한) book2 추가 
		String answer1 = "변수명을 정확히 입력하세요.";
		String result1 = bookManager.AddBook(book2);
		
		assertEquals(answer1, result1, answer1 + "가 출력되지 않았습니다." );
		System.out.println(result1);
	}
	
	// 이진 탐색 함수 테스트
	
	// 찾는 책이 리스트에 있는 경우 
    @Test
    void testSearchBS_BookExists() {
        System.out.println("testSearchBS_BookExists() 실행");
        BookManager.Book book2 = bookManager.new Book("2", "소프트웨어 공학", "Tom", 2014);
        BookManager.Book book3 = bookManager.new Book("3", "분산 컴퓨팅", "Yoon", 2024);
        BookManager.Book book4 = bookManager.new Book("4", "한국사", "Lee", 2018);
        BookManager.Book book5 = bookManager.new Book("5", "세계사", "Kim", 2020);
        BookManager.Book book6 = bookManager.new Book("6", "과학사", "Park", 2019);
        BookManager.Book book7 = bookManager.new Book("7", "미술사", "Choi", 2015);
        
        bookManager.AddBook(book1);
        bookManager.AddBook(book2);
        bookManager.AddBook(book3);
        bookManager.AddBook(book4);
        bookManager.AddBook(book5);
        bookManager.AddBook(book6);
        bookManager.AddBook(book7);

        // 초기 상태에 책 리스트가 정렬되어 있지 않도록 shuffle 
        Collections.shuffle(bookManager.books);

        String answer = "검색 결과:" + System.lineSeparator() + "Book{id: '4', 제목: '한국사', 저자: 'Lee', 출판년도: 2018}";
        String result = bookManager.search_bs("4");

        assertEquals(answer, result, answer + "가 출력되지 않았습니다.");
        System.out.println(result);
    }

    @Test
    void testSearchBS_BookNotExists() {
        System.out.println("testSearchBS_BookNotExists() 실행");
        BookManager.Book book2 = bookManager.new Book("2", "소프트웨어 공학", "Tom", 2014);
        BookManager.Book book3 = bookManager.new Book("3", "분산 컴퓨팅", "Yoon", 2024);
        // id가 4인 객체는 생성하지 않음 
        BookManager.Book book5 = bookManager.new Book("5", "세계사", "Kim", 2020);
        BookManager.Book book6 = bookManager.new Book("6", "과학사", "Park", 2019);
        BookManager.Book book7 = bookManager.new Book("7", "미술사", "Choi", 2015);
        
        bookManager.AddBook(book1);
        bookManager.AddBook(book2);
        bookManager.AddBook(book3);
        bookManager.AddBook(book5);
        bookManager.AddBook(book6);
        bookManager.AddBook(book7);
        
        // 초기 상태에 책 리스트가 정렬되어 있지 않도록 shuffle 
        Collections.shuffle(bookManager.books);

        String answer = "검색된 도서가 없습니다.";
        String result = bookManager.search_bs("4");

        assertEquals(answer, result, answer + "가 출력되지 않았습니다.");
        System.out.println(result);
    }

    @Test
    void testSearchBS_InvalidBookID() {
        System.out.println("testSearchBS_InvalidBookID() 실행");
        BookManager.Book book2 = bookManager.new Book("2", "소프트웨어 공학", "Tom", 2014);
        BookManager.Book book3 = bookManager.new Book("3", "분산 컴퓨팅", "Yoon", 2024);

        bookManager.AddBook(book1);
        bookManager.AddBook(book2); 
        bookManager.AddBook(book3);

		String answer = "ID 값을 정확히 입력하세요.";
        String result = bookManager.search_bs("0");

        assertEquals(answer, result, answer + "가 출력되지 않았습니다.");
        System.out.println(result);
    }
    
    @Test
    void testSearchPerformance() {
		// 탐색을 위한 1000개 Book 객체 생성
        bookManager = new BookManager();
        for (int i = 1; i <= 1000; i++) {
            bookManager.AddBook(bookManager.new Book(String.valueOf(i), "temp", "temp", 1));
        }

        // 초기 상태에 책 리스트가 정렬되어 있지 않도록 shuffle 
        Collections.shuffle(bookManager.books);
        // 두 메서드를 동일한 shuffle 결과로 비교하기 위해, books의 순서가 동일한 shuffledBookManager 객체 생성
        BookManager shuffledBookManager = new BookManager();
        shuffledBookManager.books = new ArrayList<>(bookManager.books);
        
        
        // ---- 기본 search 메서드 성능 테스트 ----
        long startTime = System.nanoTime();
        for (int i = 1; i <= 1000; i++) {
            bookManager.SearchBook(String.valueOf(i));  // id가 i인 책 찾기
        }
        long endTime = System.nanoTime();
        long durationSearch = endTime - startTime;
        System.out.println("1000번의 SearchBook 함수 실행 시간: " + durationSearch + " ns");

        
        // ---- 이진 탐색 search_bs 메서드 성능 테스트 ----
        startTime = System.nanoTime();
        for (int i = 1; i <= 1000; i++) {
        	shuffledBookManager.SearchBook(String.valueOf(i));  // id가 i인 책 찾기
            // shuffledBookManager 객체에서 탐색함으로 동일한 shuffle 결과로 비교 
        }
        endTime = System.nanoTime();
        long durationSearchBS = endTime - startTime;
        System.out.println("1000번의 search_bs 함수 실행 시간: " + durationSearchBS + " ns");

        assertTrue(durationSearch > durationSearchBS, "search_bs 함수가 SearchBook 함수보다 빨라야 합니다.");
    }
}


