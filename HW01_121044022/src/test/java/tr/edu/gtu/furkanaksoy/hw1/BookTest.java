package tr.edu.gtu.furkanaksoy.hw1;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by MUSTAFA on 25.02.2016.
 */
public class BookTest {

    @Test
    public void testGetName() throws Exception {
        Book name = new Book();
        name.setName("Cpp");
        assertEquals("Cpp",name.getName());
    }
}