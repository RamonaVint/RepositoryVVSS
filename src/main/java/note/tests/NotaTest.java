import note.model.Nota;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

/**
 * Created by Ramo on 31.03.2018.
 */
public class NotaTest {
    @Before
    public void setUp() throws Exception{
        System.out.println("Tests for grades.");
    }

    @Test
    public void test() {
        Nota nota = new Nota(1,"biologie",10);
        try{
            assertTrue(nota.getNota() == 10);
            assertFalse(nota.getNota() != 10);
            assertTrue(nota.getNota() >= 1 && nota.getNota() <=10);
            assertFalse(nota.getNota() < 1);
            assertFalse(nota.getNota() >10);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @After
    public void afterTest() {
        System.out.println("Tests for grades done.");
    }
}
