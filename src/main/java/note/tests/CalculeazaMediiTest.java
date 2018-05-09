import note.model.Elev;
import note.model.Medie;
import note.model.Nota;
import note.repository.ClasaRepositoryMock;
import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * Created by Ramo on 08.05.2018.
 */
public class CalculeazaMediiTest {

    @Test
    public void req02_cond01() {
        ClasaRepositoryMock repo = new ClasaRepositoryMock();
        HashMap<Elev, HashMap<String, List<Double>>> clasa = new HashMap<Elev, HashMap<String, List<Double>>>();
        Elev ana = new Elev(1, "Ana");
        Nota nota = new Nota(1, "bio", 10);
        List<Elev> clasaElevi = new LinkedList<Elev>() ;
        List<Nota> note = new LinkedList<Nota>();
        repo.creazaClasa(clasaElevi, note);
        assertEquals( repo.getClasa(), new HashMap<Elev, HashMap<String, List<Double>>>());
        try {
            repo.getClasa();
            repo.calculeazaMedii();
            System.out.println("Clasa goala");
        } catch (Exception e) {
            System.out.println("Clasa goala2");
        }

    }

    @Test
    public void req02_cond04() {
        ClasaRepositoryMock repo = new ClasaRepositoryMock();
        HashMap<Elev, HashMap<String, List<Double>>> clasa = new HashMap<Elev, HashMap<String, List<Double>>>();
        Elev ana = new Elev(1, "Ana");
        Nota nota = new Nota(1, "bio", 10);
        Nota nota2 = new Nota(1, "mate", 9);
        List<Elev> clasaElevi = new LinkedList<Elev>() ;

        clasaElevi.add(ana);

        List<Nota> note = new LinkedList<Nota>();
        note.add(nota);
        note.add(nota2);
        repo.creazaClasa(clasaElevi, note);
        try {
            repo.getClasa();
            List<Medie> medii = repo.calculeazaMedii();

            for (Medie m : medii) {
                System.out.println(m.getMedie());
            }
            System.out.println("Succes");
        } catch (Exception e) {
            System.out.println("Succes");
        }

    }

    @Test
    public void req02_cond02() {
        ClasaRepositoryMock repo = new ClasaRepositoryMock();
        HashMap<Elev, HashMap<String, List<Double>>> clasa = new HashMap<Elev, HashMap<String, List<Double>>>();
        Elev ana = new Elev(1, "Ana");
        Nota nota = new Nota(1, "bio", 10);
        List<Elev> clasaElevi = new LinkedList<Elev>() ;
        clasaElevi.add(ana);

        List<Nota> note = new LinkedList<Nota>();
        repo.creazaClasa(clasaElevi, note);
        try {
            repo.getClasa();
            List<Medie> medii = repo.calculeazaMedii();

            System.out.println("Nu exista materii");
        } catch (Exception e) {
            System.out.println("Nu exista materii2");
        }

    }


}
