package tr.edu.gtu.furkanaksoy.hw1;

/**
 * Slide impelements interface of document.
 * It has name as a description.
 * @author MUSTAFA
 * Created by MUSTAFA on 24.02.2016.
 */
public class Slide implements Document {
    private String name;

    /**
     * set name of slide
     * @param slide
     */
    public void setName(String slide){
        name = slide;
    }

    /**
     * return name of slide.
     * @return
     */
    public String getName(){
        return(name);
    }

    /**
     * default constructer of slide.
     */
    Slide(){
        name = null;
    }

    /**
     * set name of slide in constructer.
     * @param put
     */
    Slide(String put){
        name = put;
    }
}
