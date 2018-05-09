import note.controller.NoteController;
import note.model.Nota;
import note.repository.NoteRepository;
import note.repository.NoteRepositoryMock;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class AdaugaNotaTest {
    private NoteController ctrl;
    private NoteRepositoryMock repo;
    @Before
    public void setUp() throws Exception{
        repo = new NoteRepositoryMock();
        ctrl=new NoteController();
    }
    @Test
    public void TC1_ECP() throws Exception {
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
    public void TC2_ECP() throws Exception{
        //materie invalid
        int initialSize = ctrl.getNote().size();

        Nota c = new Nota(1, "bio", 1);
        try{
            ctrl.addNota(c);System.out.println("Nota adaugata!");}
        catch(Exception ex){
            System.out.println("TC2: "+ex.getMessage());
        }
        int newSize = ctrl.getNote().size();
        int actual_result = newSize;
        int expected_size = initialSize;
        assertEquals(expected_size,actual_result);
    }
    @Test
    public void TC3_ECP() throws Exception{
        //materie valida
        int initialSize = ctrl.getNote().size();

        Nota c = new Nota(1, "biologie", 1);
        try{
            ctrl.addNota(c);System.out.println("Nota adaugata!");}
        catch(Exception ex){
            System.out.println("TC2: "+ex.getMessage());
        }
        int newSize = ctrl.getNote().size();
        int actual_result = newSize;
        int expected_size = initialSize;
        assertNotEquals(expected_size,actual_result);
    }
    @Test
    public void TC4_ECP() throws Exception{
        //valid
        //nr matricol valid
        int initialSize = ctrl.getNote().size();

        Nota c = new Nota(1, "biologie", 1);
        try{
            ctrl.addNota(c);System.out.println("Nota adaugata!");}
        catch(Exception ex){
            System.out.println("TC2: "+ex.getMessage());
        }
        int newSize = ctrl.getNote().size();
        int actual_result = newSize;
        int expected_size = initialSize;
        assertNotEquals(expected_size,actual_result);
    }
    @Test
    public void TC5_ECP() throws Exception{
        //nr matricol invalid
        int initialSize = ctrl.getNote().size();

        Nota c = new Nota(-1, "bio", 1);
        try{
            ctrl.addNota(c);System.out.println("Nota adaugata!");}
        catch(Exception ex){
            System.out.println("TC2: "+ex.getMessage());
        }
        int newSize = ctrl.getNote().size();
        int actual_result = newSize;
        int expected_size = initialSize;
        assertEquals(expected_size,actual_result);
    }
    @Test
    public void TC6_BVA() throws Exception{
        //nota valid
        int initialSize = ctrl.getNote().size();

        Nota c = new Nota(1, "biologie", 1);
        try{
            ctrl.addNota(c);System.out.println("Nota adaugata!");}
        catch(Exception ex){
            System.out.println("TC2: "+ex.getMessage());
        }
        int newSize = ctrl.getNote().size();
        int actual_result = newSize;
        int expected_size = initialSize;
        assertNotEquals(expected_size,actual_result);
    }
    @Test
    public void TC7_BVA() throws Exception{
        //
        //nota invalid
        int initialSize = ctrl.getNote().size();

        Nota c = new Nota(1, "biologie", 11);
        try{
            ctrl.addNota(c);System.out.println("Nota adaugata!");}
        catch(Exception ex){
            System.out.println("TC2: "+ex.getMessage());
        }
        int newSize = ctrl.getNote().size();
        int actual_result = newSize;
        int expected_size = initialSize;
        assertEquals(expected_size,actual_result);
    }
    @Test
    public void TC8_BVA() throws Exception{
        //
        //nota invalid
        int initialSize = ctrl.getNote().size();

        Nota c = new Nota(1, "biologie", 0);
        try{
            ctrl.addNota(c);System.out.println("Nota adaugata!");}
        catch(Exception ex){
            System.out.println("TC2: "+ex.getMessage());
        }
        int newSize = ctrl.getNote().size();
        int actual_result = newSize;
        int expected_size = initialSize;
        assertEquals(expected_size,actual_result);
    }
    @Test
    public void TC9_BVA() throws Exception{
        //nr atricol invalid
        int initialSize = ctrl.getNote().size();

        Nota c = new Nota(1001, "bio", 1);
        try{
            ctrl.addNota(c);System.out.println("Nota adaugata!");}
        catch(Exception ex){
            System.out.println("TC2: "+ex.getMessage());
        }
        int newSize = ctrl.getNote().size();
        int actual_result = newSize;
        int expected_size = initialSize;
        assertEquals(expected_size,actual_result);
    }
    @Test
    public void TC10_BVA() throws Exception{
        //titlu invalid -> 3 stringuri
        //materie invalid
        int initialSize = ctrl.getNote().size();

        Nota c = new Nota(1, "bio", 1);
        try{
            ctrl.addNota(c);System.out.println("Nota adaugata!");}
        catch(Exception ex){
            System.out.println("TC2: "+ex.getMessage());
        }
        int newSize = ctrl.getNote().size();
        int actual_result = newSize;
        int expected_size = initialSize;
        assertEquals(expected_size,actual_result);
    }
}
