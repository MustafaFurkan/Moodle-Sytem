package tr.edu.gtu.furkanaksoy.hw1;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by MUSTAFA on 25.02.2016.
 */
public class FileTest {

    @Test
    public void testGetName() throws Exception {
        File name = new File();
        name.setName("ali.txt");
        assertEquals("ali.txt",name.getName());
    }
}