package diaryTestPack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import services.EntryServices;
import services.EntryServicesImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class EntryServicesImplTest {
    private EntryServices entryService;
    @BeforeEach
    public void startWith(){
        entryService = new EntryServicesImpl();
    }
    @Test
    public void entriesCanBeAddedTest(){
        entryService.addEntry("Moyin", "Code", "While alive");
        assertEquals(1, entryService.count());
    }
    @Test
    public void entriesBelongingToUserCanBeDeletedByTitleTest(){
        entryService.addEntry("Moyin", "Code", "While alive");
        entryService.addEntry("Harry", "Clean Code", "While alive, live");
        assertEquals(2, entryService.count());

        entryService.delete("Harry", "Clean Code");
        assertEquals(1, entryService.count());

    }
    @Test
    public void testThatDeleteEntryCanThrowExceptionIfEntryIsNotFound(){
        entryService.addEntry("Moyin", "Code", "While alive");
        entryService.addEntry("Harry", "Clean Code", "While alive, live");
        assertEquals(2, entryService.count());

        assertThrows(IllegalArgumentException.class, ()-> entryService.delete("Harry","CleanserCode"));
    }
    @Test
    public void testThatDeleteEntryServicesCanThrowExceptionIfEntryIsNotFound(){
        entryService.addEntry("Moyin", "Code", "While alive");
        entryService.addEntry("Harry", "Clean Code", "While alive, live");
        assertEquals(2, entryService.count());

        assertThrows(IllegalArgumentException.class, ()-> entryService.findEntry("Harry","CleanCoder"));

    }

    }
