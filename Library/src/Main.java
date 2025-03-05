import java.util.ArrayList;

class Author {
    String name, biography;

    Author(String name, String biography) {
        this.name = name;
        this.biography = biography;
    }

    String getName() {
        return name;
    }

    String getBiography() {
        return biography;
    }
}

class Book {
    String title, isbn;
    Author author;

    Book(String title, String isbn, Author author) {
        this.title = title;
        this.isbn = isbn;
        this.author = author;
    }

    String getTitle() {
        return title;
    }

    String getIsbn() {
        return isbn;
    }

    Author getAuthor() {
        return author;
    }
}

class Borrower {
    String name;
    ArrayList<Book> borrowedBooks = new ArrayList<>();

    Borrower(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }

    void borrowBook(Book book) {
        borrowedBooks.add(book);
        System.out.println(name + " borrowed: " + book.getTitle());
    }

    void returnBook(Book book) {
        borrowedBooks.remove(book);
        System.out.println(name + " returned: " + book.getTitle());
    }

    void displayBorrowedBooks() {
        System.out.println(name + "'s Borrowed Books:");
        for (Book book : borrowedBooks) {
            System.out.println("Title: " + book.getTitle());
            System.out.println("ISBN: " + book.getIsbn());
            System.out.println("Author: " + book.getAuthor().getName());
            System.out.println("Biography: " + book.getAuthor().getBiography());
            System.out.println("------------------------");
        }
    }
}


class Library {
    ArrayList<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added to library: " + book.getTitle());
    }

    public void borrowBook(Borrower borrower, Book book) {
        if (books.remove(book)) {
            borrower.borrowBook(book);
        } else {
            System.out.println("Sorry, the book is not available: " + book.getTitle());
        }
    }

    public void returnBook(Borrower borrower, Book book) {
        books.add(book);
        borrower.returnBook(book);
    }

    public void displayLibraryBooks() {
        System.out.println("Books in Library:");
        for (Book book : books) {
            System.out.println("Title: " + book.getTitle());
            System.out.println("ISBN: " + book.getIsbn());
            System.out.println("Author: " + book.getAuthor().getName());
            System.out.println("Biography: " + book.getAuthor().getBiography());
            System.out.println("------------------------");
        }
    }
}

public class Main {
    public Main(){
        Author author1 = new Author("James Gosling", "Creator of the Java programming language.");
        Author author2 = new Author("Robert C. Martin", "Known for his works on software craftsmanship.");

        Book book1 = new Book("Java Programming", "123456789", author1);
        Book book2 = new Book("Clean Code", "987654321", author2);

        Library library = new Library();
        library.addBook(book1);
        library.addBook(book2);

        Borrower borrower = new Borrower("Alice");
        library.borrowBook(borrower, book1);
        library.borrowBook(borrower, book2);

        borrower.displayBorrowedBooks();

        library.returnBook(borrower, book1);

        borrower.displayBorrowedBooks();

        library.displayLibraryBooks();
    }
    public static void main(String[] args) //throws Exception 
    {
        new Main();
    }
}
