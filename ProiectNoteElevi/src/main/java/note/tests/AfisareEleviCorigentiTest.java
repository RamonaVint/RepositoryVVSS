import note.model.Corigent;
import note.model.Elev;
import note.model.Nota;
import note.repository.ClasaRepositoryMock;
import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Ramo on 08.05.2018.
 */
public class AfisareEleviCorigentiTest {

    @Test
    public void eleviCorigenti_TC1() {
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

        List<Corigent> corigenti = repo.getCorigenti();

        assertEquals(corigenti.size(), 0);



    }

    @Test
    public void eleviCorigenti_TC2() {
        ClasaRepositoryMock repo = new ClasaRepositoryMock();
        HashMap<Elev, HashMap<String, List<Double>>> clasa = new HashMap<Elev, HashMap<String, List<Double>>>();
        Elev ana = new Elev(1, "Ana");
        Nota nota = new Nota(1, "bio", 4);
        Nota nota2 = new Nota(1, "mate", 4);
        List<Elev> clasaElevi = new LinkedList<Elev>() ;

        clasaElevi.add(ana);

        List<Nota> note = new LinkedList<Nota>();
        note.add(nota);
        note.add(nota2);
        repo.creazaClasa(clasaElevi, note);

        List<Corigent> corigenti = repo.getCorigenti();

        assertEquals(corigenti.size(), 1);



    }
}
