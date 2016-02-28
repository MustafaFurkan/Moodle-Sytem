package tr.edu.gtu.furkanaksoy.hw1;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by MUSTAFA on 25.02.2016.
 */
public class UrlTest {

    @Test
    public void testGetName() throws Exception {
        Url name = new Url();
        name.setName("www.gtu.edu.tr");
        assertEquals("www.gtu.edu.tr",name.getName());
    }
}