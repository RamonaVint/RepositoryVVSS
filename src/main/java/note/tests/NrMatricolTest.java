import note.model.Nota;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

/**
 * Created by Ramo on 31.03.2018.
 */
public class NrMatricolTest {
    @Before
    public void setUp() throws Exception{
        System.out.println("Tests for ids.");
    }

    @Test
    public void test() {
        Nota nota = new Nota(1,"biologie",10);
        try {
            assertTrue(nota.getNrmatricol() == 1);
            assertTrue (nota.getNrmatricol() >= 1 && nota.getNrmatricol() <= 1000);
            assertFalse(nota.getNrmatricol() != 1);


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @After
    public void afterTest() {
        System.out.println("Tests for ids done.");
    }
}
