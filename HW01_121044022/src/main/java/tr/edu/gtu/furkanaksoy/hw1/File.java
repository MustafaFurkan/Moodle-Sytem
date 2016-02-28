package tr.edu.gtu.furkanaksoy.hw1;

/**
 * File impelements interface of document.
 * It has name as a description.
 * @author MUSTAFA
 * Created by MUSTAFA on 24.02.2016.
 */
public class File implements Document{

    private String name;

    /**
     * set name of file.
     * @param book
     */
    public void setName(String book){
        name = book;
    }

    /**
     * return name of file.
     * @return
     */
    public String getName(){
        return(name);
    }

    /**
     * default constructer to set name.
     */
    File(){
        name = "";
    }

    /**
     * set name of file.
     * @param put
     */

    File(String put){
        name = put;
    }
}
