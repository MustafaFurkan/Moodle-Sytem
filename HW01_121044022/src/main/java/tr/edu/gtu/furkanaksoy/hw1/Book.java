package tr.edu.gtu.furkanaksoy.hw1;

/**
 * Book impelements interface of document.
 * It has name as a description.
 * @author MUSTAFA
 * Created by MUSTAFA on 24.02.2016.
 */
public class Book implements Document {

    private String name;

    /**
     * @param book to setting name of book.
     */
    public void setName(String book){
        name = book;
    }

    /**
     * @return book return value of name.
     */
    public String getName(){
        return(name);
    }

    /**
     * constructer to set default value.
     */
    Book(){
        name = "";
    }

    /**
     * constructer
     * @param put uses to set name of book
     */
    Book(String put){
        name = put;
    }
}
