import java.util.Scanner;

class Book{
    String title;
    String author;
    boolean isIssued;
    int bookId;

    Book(int bookId,String title, String author){ // constructor is created
    this.author = author;
    this.bookId = bookId;
    this.title = title;
    this.isIssued = false;
    }

    void displaybooks(){    //this function will display the books
        System.out.println("The book id is:" + bookId);
        System.out.println("the author is: " + author);
        System.out.println("the title of the book" + title);
        if(isIssued){
            System.out.println("THE BOOK IS ISSUED");
        }else{
            System.out.println("THE BOOK IS AVAILABLE");
        }
    }
}

class Library{
    Book [] books = new Book[100];//we created array of books here
    int BookCount = 0;  //keeps track of how many books we have

    void addBook(int bookId , String title , String author){
    if(BookCount<100){
        books[BookCount] = new Book(bookId ,title,author);
        BookCount++;
    }else{
        System.out.println("The library is fulll");
    }

    }

    //method to show all books
    void showBooks(){
        System.out.println("       ALL BOOKS       ");
        if(BookCount==0) {
            System.out.println("There are no books in the library yet");
            return;
        }

        for(int i = 0 ; i<BookCount ; i++){
            books[i].displaybooks();
        }
    }

    //method to issue a book to someone
    void issueBook(int bookId){
        boolean found = false;

        for(int i = 0;i<BookCount ; i++) {
            if (books[i].bookId == bookId) {

                if (books[i].isIssued) {
                    System.out.println("Sorry this book is already issued");
                } else {
                    books[i].isIssued = true;
                    System.out.println("The book is now successfully issued");
                    System.out.println("Book:" + books[i].title);
                }
                return;
            }
        }
        System.out.println("no book is found" + bookId);
    }

    void returnBook(int bookId) {
        for (int i = 0; i < BookCount; i++) {
            if (books[i].bookId == bookId) {
                if (!books[i].isIssued){
                    System.out.println("The book wasnt issued");
            } else {
                books[i].isIssued = false;
                System.out.println("The book is returned successfully");
                System.out.println("Books: " + books[i].title);
            }
            return;
        }
    }
        System.out.println("Book not found id: " + bookId);

    }

    void showAvailablebooks(){
        System.out.println("Available books");
        boolean anyavailable = false;

        for(int i =0 ;i<BookCount ; i++){
            if(!books[i].isIssued){
                books[i].displaybooks();
                anyavailable = true;
            }
        }
        if(!anyavailable){
            System.out.println("No books are available right now");
        }
    }

    }


public class Libraryy {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Library l = new Library();

        l.addBook(101, "J.K rowling", "Harry potter");
        l.addBook(102, "Herbert Schildt", "Java Programming");
        l.addBook(103, "J.R.R. Tolkien", "The Hobbit");
          while(true){
              System.out.println(" Online Library System ");
              System.out.println("1.Add new book");
              System.out.println("2. Show the books");
              System.out.println("3. Show available books");
              System.out.println("4 Issue a book");
              System.out.println("5 Return a book");
              System.out.println("6.exit");
              System.out.println("ENTER YOUR CHOICE 1 TO 6");

              int choice =sc.nextInt();
              sc.nextLine();

              if(choice == 1){
                  System.out.println("Enter id:");
                  int id = sc.nextInt();
                  sc.nextLine();


                  System.out.println("Enter book title");
                  String title = sc.nextLine();

                  System.out.println("Enter the author");
                  String author = sc.nextLine();

                  l.addBook(id , title ,author);

              }else if(choice == 2){
                  l.showBooks();

              }else if(choice == 3){
                  l.showAvailablebooks();
              }else if(choice == 4){
                  System.out.println("Enter the issued book id");
                  int id = sc.nextInt();
                  l.issueBook(id);
              }else if(choice == 5){
                  System.out.println("Enter thr book to return id");
                  int id = sc.nextInt();
                  l.returnBook(id);
              }else if (choice == 6){
                  System.out.println("Thankyou for using library system");
                  break;

              }else{
                  System.out.println("invalid choice");
              }
          }
          sc.close();
    }
}
