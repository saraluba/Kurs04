package annotation;

import java.util.List;

public class Book {
    protected String name;
    protected int pages;
    public static List<Book> bookList;
    int numberOfPages = 0;

    public Book(String name, int pages){
        this.name = name;
        this.pages = pages;
    }

    @Execute(times = 2)
    public void readOnePage(){
        if(numberOfPages < pages){
            numberOfPages +=1;
            System.out.printf("%s: you read %d pages", name, numberOfPages);
        } else{
            System.out.printf("%s has no more pages!", name);
        }
    }

    public static void addBook(Book book){
        bookList.add(book);
    }

    @Execute(times = 3)
    public String getName() {
        return name;
    }

    @Execute
    public int getPages() {
        return pages;
    }

    @Execute
    public static List<Book> getBookList() {
        return bookList;
    }
}
