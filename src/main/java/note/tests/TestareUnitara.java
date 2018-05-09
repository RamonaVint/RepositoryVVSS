import note.controller.NoteController;
import note.model.Corigent;
import note.model.Elev;
import note.model.Medie;
import note.model.Nota;
import note.repository.ClasaRepositoryMock;
import note.repository.NoteRepositoryMock;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by Ramo on 08.05.2018.
 */
public class TestareUnitara {

    private NoteController ctrl;
    private NoteRepositoryMock repo;
    @Before
    public void setUp() throws Exception{
        repo = new NoteRepositoryMock();
        ctrl=new NoteController();
    }

    @Test
    public void adaugareNota_unitar() {
        int initialSize = ctrl.getNote().size();
        Nota nota = new Nota(1, "biologie", 1);
        try{
            ctrl.addNota(nota);
            System.out.println("Nota adaugata!");}
        catch(Exception ex){
            System.out.println("TC1: "+ex.getMessage());
        }
        int newSize = ctrl.getNote().size();
        int actual_result = newSize;
        int expected_size = initialSize+1;

        assertEquals(expected_size,actual_result);
    }

    @Test
    public void calculeazaMedii_unitar() {
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
    public void eleviCorigenti_TC2_unitar() {
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

    @Test
    public void testareIntegrare() {

        System.out.println("Integrare");

        Elev ana = new Elev(1, "Ana");
        Elev mariA = new Elev(2, "Maria");
        Elev ion = new Elev (3, "Ion");

        Nota nota = new Nota(1, "biologie", 5);
        Nota nota2 = new Nota (2, "matematica", 4);
        Nota nota3 = new Nota (3, "romana", 6);
        Nota nota4 = new Nota(1,"matematica", 6);
        Nota nota5 = new Nota(2, "biologie", 3);
        Nota nota6 = new Nota (3, "biologie", 4);



        ClasaRepositoryMock repo = new ClasaRepositoryMock();
        HashMap<Elev, HashMap<String, List<Double>>> clasa = new HashMap<Elev, HashMap<String, List<Double>>>();
        List<Elev> clasaElevi = new LinkedList<Elev>() ;

        clasaElevi.add(ana);
        clasaElevi.add(mariA);
        //clasaElevi.add(ion);

        List<Nota> note = new LinkedList<Nota>();
        note.add(nota);
        note.add(nota2);
        //note.add(nota3);
        note.add(nota4);
        note.add(nota5);
        //note.add(nota6);

        int initialSize = ctrl.getNote().size();
        try{
            ctrl.addNota(nota);
            System.out.println("Nota adaugata!");}
        catch(Exception ex){
            System.out.println("TC1: "+ex.getMessage());
        }
        int newSize = ctrl.getNote().size();
        int actual_result = newSize;
        int expected_size = initialSize+1;

        assertEquals(expected_size,actual_result);


        repo.creazaClasa(clasaElevi, note);
        try {
            repo.getClasa();
            List<Medie> medii = repo.calculeazaMedii();
            System.out.println("Medii:");
            for (Medie m : medii) {
                System.out.print(m.getElev().getNume());
                System.out.println(m.getMedie());
            }
        } catch (Exception e) {
            System.out.println("Succes");
        }

        List<Corigent> corigenti = repo.getCorigenti();
        System.out.println("Corigenti:");
        for (Corigent c : corigenti) {
            System.out.println(c.getNumeElev());
        }


    }
}
