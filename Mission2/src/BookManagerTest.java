import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BookManagerTest {
	
	private BookManager bookManager;
	private BookManager.Book book1;	// 모든 유닛 테스트에서 사용하는 객체이기 때문에 전역 선함 

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
		
		// id가 1인 book1 추가 
		String answer1 = "변수명을 정확히 입력하세요.";
		String result1 = bookManager.AddBook(book2);
		
		assertEquals(answer1, result1, answer1 + "가 출력되지 않았습니다." );
		System.out.println(result1);
	}
}


