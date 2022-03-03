public class Book implements Comparable<Book> {

	private String title;
	private String author;
	private String genre;
	private int numPages;


	public Book(String title, String author, String genre, int numPages) {
		this.title = title;
		this.author = author;
		this.genre = genre;
		this.numPages = numPages;

	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public String getGenre() {
		return genre;
	}

	public int getNumPages() {
		return numPages;
	}

	public boolean equals(Book other) {
		boolean authorMatches = author.equals(other.getAuthor());
		boolean titleMatches = title.equals(other.getTitle());
		return authorMatches && titleMatches;
	}

	// Implement this
	public int compareTo(Book other) {
		if (this.author.compareTo(other.getAuthor()) > 0) {
			return 1;
		} else if (this.author.compareTo(other.getAuthor()) < 0) {
			return -1;
		} else { //the same
			if (this.title.compareTo(other.getTitle()) > 0) {
				return 1;
			} else if (this.title.compareTo(other.getTitle()) < 0) {
				return -1;
			} else { //the same
				return 0;
			}

		}
	}
}