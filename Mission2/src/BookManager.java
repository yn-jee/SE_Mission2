import java.util.ArrayList;

public class BookManager {
	// edit
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
}
