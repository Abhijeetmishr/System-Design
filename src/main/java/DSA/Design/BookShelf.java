package DSA.Design;
import java.util.*;

class Bookshelf {
    HashMap<String, Book> books;
    PriorityQueue<Book> priorityQueue;

    public Bookshelf() {
        books = new HashMap<>();
        priorityQueue = new PriorityQueue<>((a, b) -> {
            if (a.frequency != b.frequency) {
                return b.frequency - a.frequency; // Higher frequency first
            } else {
                return Long.compare(b.lastUsedTimestamp, a.lastUsedTimestamp); // More recent used first
            }
        });
    }

    public void addBook(String title) {
        if (books.containsKey(title)) {
            Book book = books.get(title);
            book.frequency++;
            book.lastUsedTimestamp = System.currentTimeMillis();
            priorityQueue.remove(book);
            priorityQueue.offer(book);
        } else {
            Book book = new Book(title, 1, System.currentTimeMillis());
            books.put(title, book);
            priorityQueue.offer(book);
        }
    }

    public String getTopBook() {
        if (priorityQueue.isEmpty()) {
            return "No books available.";
        }
        return priorityQueue.peek().title;
    }

    class Book {
        String title;
        int frequency;
        long lastUsedTimestamp;
    
        public Book(String title, int frequency, long lastUsedTimestamp) {
            this.title = title;
            this.frequency = frequency;
            this.lastUsedTimestamp = lastUsedTimestamp;
        }
    }
    public static void main(String[] args) {
        Bookshelf bookshelf = new Bookshelf();
        bookshelf.addBook("Java Programming");
        bookshelf.addBook("Data Structures and Algorithms");
        bookshelf.addBook("Java Programming");
        bookshelf.addBook("Machine Learning");
        bookshelf.addBook("Data Structures and Algorithms");
        
        System.out.println("Top book: " + bookshelf.getTopBook());
    }
}