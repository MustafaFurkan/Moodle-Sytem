package tr.edu.gtu.furkanaksoy.hw1;

/**
 * white board impelements interface of document.
 * It has name as a description.
 * @author MUSTAFA
 * Created by MUSTAFA on 24.02.2016.
 */
public class WhiteboardDescription implements Document {

    private String name;

    /**
     * set name of white board.
     * @param board
     */
    public void setName(String board){
        name = board;
    }

    /**
     * get name of white board.
     * @return
     */
    public String getName(){
        return(name);
    }

    /**
     * constructer to declare white board.
     */
    WhiteboardDescription(){
        name = "";
    }

    /**
     * constructer to set name of white board.
     * @param put
     */
    WhiteboardDescription(String put){
        name = put;
    }
}
