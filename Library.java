import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Книга " + book + " успішно додана!");
    }

    public void deleteBook(String title) {
        boolean found = false;
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                books.remove(book);
                System.out.println("Книга під назвою \"" + title + "\" успішно видалена!");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Книга під назвою \"" + title + "\" не знайдена.");
        }
    }

    public void showBooks() {
        if (books.isEmpty()) {
            System.out.println("В бібліотеці немає книг =(");
        } else {
            System.out.println("Книги в бібліотеці:");
            for (Book book : books) {
                System.out.println(book);
            }
        }
    }

    public boolean findBookForAuthor(String author) {
        boolean found = false;
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                System.out.println("Книга з автором \"" + author + "\" має назву - " + book.getTitle());
                found = true;
            }
        }
        return found;
    }

    public boolean findBookForYear(int year) {
        boolean found = false;
        for (Book book : books) {
            if (book.getYear() == year) {
                System.out.println("Книга з роком видання " + year + " має назву - " + book.getTitle());
                found = true;
            }
        }
        return found;
    }
}
