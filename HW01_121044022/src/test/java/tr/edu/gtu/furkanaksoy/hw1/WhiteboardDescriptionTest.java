package tr.edu.gtu.furkanaksoy.hw1;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by MUSTAFA on 25.02.2016.
 */
public class WhiteboardDescriptionTest {

    @Test
    public void testGetName() throws Exception {
        WhiteboardDescription name = new WhiteboardDescription();
        name.setName("Not1");
        assertEquals("Not1",name.getName());
    }
}