// Library Book Tracking System
// Concepts: HashMap, File handling (optional), Input handling, Classes

// Requirements: Add, issue, return, and search books. Use ISBN as key.

import java.util.HashMap;
import java.util.Scanner;

public class LibrarySystem {

    private static final Scanner sc = new Scanner(System.in);
    private static final HashMap<String, Book> books=new HashMap<>();


    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n--- Library Book Management ---");
            System.out.println("1. Add Book");
            System.out.println("2. Issue Book");
            System.out.println("3. Return Book");
            System.out.println("4. Search Book by ISBN");
            System.out.println("5. Display All Books");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            try {
                choice = Integer.parseInt(sc.nextLine());
                switch (choice) {
                    case 1 -> addBook();
                    case 2 -> issueBook();
                    case 3 -> returnBook();
                    case 4 -> SearchBook();
                    case 5 -> listAllBooks();
                    case 6 -> System.out.println("Exiting... Bye!");
                    default -> System.out.println("Invalid choice. Try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Enter a number.");
                choice = 0;
            }

        } while (choice != 6);
    }

    private static void addBook(){
        System.out.println("Enter ISBN Number of book : ");
        String isbn = sc.nextLine();

        if(books.containsKey(isbn)){
            System.out.println("Book already present,\nDo you want add copies? (Y/N)");
            char choice = sc.nextLine().charAt(0);
            if(choice=='Y'){
                System.out.println("How many copies?");
                int copies = sc.nextInt();
                books.get(isbn).addCopies(copies);
            }
        }
        else{
            System.out.println("Book Name : ");
            String name = sc.nextLine();

            System.out.print("Enter Author: ");
            String author = sc.nextLine();

            Book book = new Book(isbn,name, author);
            books.put(isbn,book);

        }
    }

    private static void issueBook(){
        System.out.println("Enter ISBN Number of book : ");
        String isbn = sc.nextLine();
        if(books.containsKey(isbn)){
            books.get(isbn).issueBook();
        }
        else{
            System.out.println("Book Not Found");
        }
    }


    private static void returnBook(){
        System.out.println("Enter ISBN Number of book : ");
        String isbn = sc.nextLine();
        if(books.containsKey(isbn)){
            books.get(isbn).returnBook();
        }
        else{
            System.out.println("Book Not Found");
        }
    }

    private static void SearchBook(){
        System.out.println("Enter ISBN Number of book : ");
        String isbn = sc.nextLine();
        if(books.containsKey(isbn)){
            Book book = books.get(isbn);
            System.out.println(book);
        }
        else{
            System.out.println("Book Not Found");
        }
    }


    private static void listAllBooks(){
        if(books.isEmpty()){
            System.out.println("No Book Present");
        }
        else{
            for(Book book:books.values()){
                System.out.println(book + "\n-----------------------------");
            }
        }
    }


    
}

class Book {
    private String isbn;
    private String title;
    private String author;
    private int totalCopies = 0;
    private int issuedCopies = 0;

    public Book(String isbn,String title,String author){
        this.isbn = isbn;
        this.author = author;
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getAvailableCopies() {
        return totalCopies - issuedCopies;
    }

    public void addCopies(int count) {
        totalCopies += count;
    }

    public boolean issueBook() {
        if (getAvailableCopies() > 0) {
            issuedCopies++;
            return true;
        } else {
            return false;
        }
    }

    public void returnBook() {
        if (issuedCopies > 0) {
            issuedCopies--;
        }
    }

    @Override
    public String toString(){
        return "ISBN: " + isbn +
                ", Title: " + title +
                ", Author: " + author +
                ", Total: " + totalCopies +
                ", Issued: " + issuedCopies +
                ", Available: " + getAvailableCopies();
    }
}

