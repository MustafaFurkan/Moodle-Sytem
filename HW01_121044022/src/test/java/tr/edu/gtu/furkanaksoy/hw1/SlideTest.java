package tr.edu.gtu.furkanaksoy.hw1;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by MUSTAFA on 25.02.2016.
 */
public class SlideTest {

    @Test
    public void testGetName() throws Exception {
        Slide name = new Slide();
        name.setName("Cpp-Slide");
        assertEquals("Cpp-Slide",name.getName());
    }
}