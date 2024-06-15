import java.util.ArrayList;

// Collections.sort를 사용하기 위해 java.util.Collections 클래스 import
import java.util.Collections;
// Book 객체의 id 값 비교를 위해 java.util.Comparator 클래스 import, Comparator를 Override  
import java.util.Comparator;
// OCP 원리를 위반하지 않기 위해, id 값 비교 시 String 타입을 int 타입으로 변환하는 java.lang.Integer 클래스 import
import java.lang.Integer;

public class BookManager {
	public class Book {
		protected String id;
		protected String title;
		protected String author;
		protected int publishedIn;
		
		// 생성자 
		public Book(String id, String title, String author, int publishedIn) {
			this.id = id;
			this.title = title;
			this.author = author;
			this.publishedIn = publishedIn;
		}
		
		// Book 객체의 정보로 문자열을 반환하는 함수 
	    public String GetString() {
	    	String id = this.id;
	    	String title = this.title;
	    	String author = this.author;
	    	int publishedIn = this.publishedIn;
	    	
	    	String result = "Book{id: '" + id + "', 제목: '" + title 
					+ "', 저자: '" + author + "', 출판년도: " + publishedIn + "}";
			return result;
	    }
	}

	
    ArrayList<Book> books = new ArrayList<>();	// BookManager 객체 내에 Book 리스트 생성 
    
	public String AddBook(Book newBook) {
		// 결과 반환용 문자열 
		String result;
		
		// 이미 존재하는 id인지 탐색 
		for (Book iterBook : books) {
			if (iterBook.id == newBook.id) {
				// 존재하는 id라면 이미 존재하는 id라는 문자열을 즉시 반환 
				result = "해당 ID(" + newBook.id + ") 는 이미 존재합니다.";
				return result;
			}
		}
		
		if (newBook.id == null || newBook.id.isEmpty() || newBook.title == null || newBook.title.isEmpty()
				|| newBook.author == null || newBook.author.isEmpty()|| newBook.publishedIn <= 0) {
			result = "변수명을 정확히 입력하세요.";
			return result;
		}
		
		// 존재하지 않는 id라면 Book 리스트에 추가 
		books.add(newBook);
		
		// 결과 문자열 출력하기 
		result = newBook.GetString() + "도서가 추가되었습니다.";
		return result;
	}
	
	public String SearchBook(String targetId) {
		// 결과 반환용 문자열 
		String result;
		
		// 이미 존재하는 id인지 탐색 
		for (Book iterBook : books) {
			if (iterBook.id == targetId) {
				// 존재하는 id라면 해당 id의 Book 정보 즉시 반환 
				result = "검색 결과:" + System.lineSeparator() + iterBook.GetString();
				return result;
			}
		}
		
		// 존재하지 않는 id인 경우
		result = "검색된 도서가 없습니다.";
		return result;
	}
	
	public String RemoveBook(String targetId) {
		// 결과 반환용 문자열 
		String result;
		
		// 이미 존재하는 id인지 탐색 
		for (Book iterBook : books) {
			if (iterBook.id == targetId) {
				// 존재하는 id라면 해당 id의 Book 객체 삭제 및 정보 즉시 반환
				result = iterBook.GetString() + "도서를 삭제하였습니다.";
				books.remove(iterBook);
				return result;
			}
		}
		
		// 존재하지 않는 id인 경우
		result = "해당 ID(" + targetId + ")의 도서를 찾을 수 없습니다.";
		return result;
	}
	
	// 이진 탐색 함수 추가
    public String search_bs(String targetId) {
		// 결과 반환용 문자열 
		String result;
		
		// targetId가 invalid할 경우 
		int targetIdInt = Integer.parseInt(targetId);
        if (targetIdInt <= 0) {
			result = "ID 값을 정확히 입력하세요.";
			return result;
		}
    	// Book 객체 비교를 위한 BookIdComparator 객체 생성  
        BookIdComparator comparator = new BookIdComparator();
        
        // targetId를 id로 갖는 targetBook 객체 생성
        Book targetBook = new Book(targetId, "temp", "temp", 1);

        // 책 리스트를 id 기준으로 정렬
        Collections.sort(books, comparator);
        
        // 이진 탐색을 위한 변수 설정
        Book left = books.get(0);
        Book right = books.get(books.size() - 1);

        while (comparator.compare(left, right) <= 0) {
            int leftIndex = books.indexOf(left);
            int rightIndex = books.indexOf(right);
            int midIndex = (leftIndex + rightIndex) / 2;
            Book midBook = books.get(midIndex);

            if (comparator.compare(midBook, targetBook) == 0) {
                // 찾고자 하는 책을 발견한 경우
                result =  "검색 결과:" + System.lineSeparator() + midBook.GetString();
                return result;
            } else if (comparator.compare(midBook, targetBook) < 0) {
                left = books.get(midIndex + 1); // 오른쪽 반으로 탐색 범위를 좁힘
            } else {
                right = books.get(midIndex - 1); // 왼쪽 반으로 탐색 범위를 좁힘
            }
        }

        // 찾고자 하는 책이 없는 경우
        result =  "검색된 도서가 없습니다.";
        return result;
    }
    
    // Book 객체의 크기를 비교할 수 있도록 하는 Comparator 작성 
    class BookIdComparator implements Comparator<Book> {    
    	@Override    
    	public int compare(Book b1, Book b2) { 
    		// id가 String 타입이기 때문에 int로 변환 필요 
    		int id1 = Integer.parseInt(b1.id); 
    		int id2 = Integer.parseInt(b2.id);
    		if (id1 > id2) {            
    			return 1;        
    		} else if (id1 < id2) {            
    			return -1;        
    		}        
    		return 0;    
    	}
    }
}
