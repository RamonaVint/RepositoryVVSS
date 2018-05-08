
import note.model.Nota;
        import org.junit.After;
        import org.junit.Before;
        import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

/**
 * Created by Ramo on 31.03.2018.
 */
public class MaterieTest {
    @Before
    public void setUp() throws Exception{
        System.out.println("Tests for lectures.");
    }

    @Test
    public void test() {
        Nota nota = new Nota(1,"biologie",10);
        try{
            assertTrue(nota.getMaterie() == "biologie");
            assertTrue(nota.getMaterie().length() >= 5);
            assertTrue(nota.getMaterie().length() >= 5 && nota.getMaterie().length()<=20);
            assertFalse(nota.getMaterie().length() < 5);
            assertFalse(nota.getMaterie().length() >20);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @After
    public void afterTest() {
        System.out.println("Tests for lectures done.");
    }
}
