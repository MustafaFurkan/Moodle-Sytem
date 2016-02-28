package tr.edu.gtu.furkanaksoy.hw1;

/**
 * Url impelements interface of document.
 * It has name as a description.
 * @author MUSTAFA
 * Created by MUSTAFA on 24.02.2016.
 */
public class Url implements Document {

    private String name;

    /**
     * set name of url.
     * @param url
     */
    public void setName(String url){
        name = url;
    }

    /**
     * get name of url.
     * @return
     */
    public String getName(){
        return(name);
    }

    /**
     * constructer of url.
     */
    Url(){
        name = "";
    }

    /**
     * set name of url in constructer.
     * @param put
     */
    Url(String put){
        name = put;
    }
}
