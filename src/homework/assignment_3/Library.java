package homework.assignment_3;

import java.util.ArrayList;

public class Library {

    private ArrayList<Book> collection;
    private int capacity;

    private Library (int capacity) {
        this.capacity = capacity;
        this.collection = new ArrayList<>(capacity);
    }

    public void depositBooks (Book ... books) {

        int counter = 0;
        for(Book e:books) counter++;

        if (this.collection.size() + counter > this.capacity) { System.out.println("Cannot take any more books in the collection");
            System.exit(10); }

            else {

                for(Book e:books) {
                System.out.println("I am depositing the books being handed over...");
                this.collection.add(e);

                }
            }

        System.out.println("I have deposited the books handed over...");

    }

    public void checkIfBookThere (Book book) {
        if (this.collection.contains(book)) {
            System.out.println("There is/are an item/s of the requested book in the library ");
        }
    }

    public static void main(String[] args) {

        Book book1 = new Book("The war and peace","Leo Tolstoy", 589);
        Book book2 = new Book("Ulyses", "James Joyce", 896);
        Book book3 = new Book("Lolita", "Nabokov", 452);
        Book book4 = new Book("Brief history of time", "Hawking", 156);

        // Book book5 = new Book("Ulysses", "James Joyce", 800);

        Library afterJoyce = new Library(3);
        afterJoyce.depositBooks(book1, book2, book3, book4);
        afterJoyce.checkIfBookThere(book2);

    }
}

class Book {
        private String title;
        private String author;
        private int pageNum;

        public Book(String title, String author, int pageNum) {
            this.author = author;
            this. title = title;
            if (pageNum > 0) this.pageNum = pageNum;
                else { System.out.println("Please provide a correct number of pages in the book " + this.title + " written by " + this.author);
                System.exit(10); }
    }
}

