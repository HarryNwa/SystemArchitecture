package diaryTestPack;

import data.model.Entry;
import data.repository.EntryRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class EntryRepositoryImplTest {

    EntryRepositoryImpl entryRepository;

    @BeforeEach
    public void setEntryRepository() {
        entryRepository = new EntryRepositoryImpl();
    }

    @Test
    public void testThatEntryCanBeCreated() {
        Entry entry = new Entry();
        entry.setTitle("Big Men Don't Lack\n");
        entry.setBody("They always have surplus.");
        entryRepository.createEntry(entry);
        assertEquals(1, entry.getEntryId(), entryRepository.findEntryById(1).getEntryId());
        System.out.println(entry.getEntryInfo());
    }
    @Test
    public void testThatEntryCanBeFoundById(){
        Entry entry = new Entry();
        entry.setTitle("Big Men Don't Lack\n");
        entry.setBody("They always have surplus.");
        entryRepository.createEntry(entry);
        assertEquals(1, entry.getEntryId(), entryRepository.findEntryById(1).getEntryId());
    }
    @Test
    public void testThatEntryCanBeDeleted(){
        Entry entry = new Entry();
        entry.setTitle("Big Men Don't Lack\n");
        entry.setBody("They always have surplus.");
        entryRepository.createEntry(entry);
        assertEquals(1, entry.getEntryId(), entryRepository.findEntryById(1).getEntryId());

        Entry entry1 = new Entry();
        entry.setTitle("Life is kind\n");
        entry.setBody("Human misunderstand it.");
        entryRepository.createEntry(entry1);
        assertEquals(2, entry.getEntryId(), entryRepository.findEntryById(2).getEntryId());
        entryRepository.delete(entry1);
        assertThrows(NullPointerException.class, ()-> entryRepository.findEntryById(2));
    }
    @Test
    public void testThatEntryCanBeFoundByAll(){
        Entry entry = new Entry();
        entry.setTitle("Big Men Don't Lack\n");
        entry.setBody("They always have surplus.");
        entryRepository.createEntry(entry);
        assertEquals(1, entry.getEntryId(), entryRepository.findEntryById(1).getEntryId());

        Entry entry1 = new Entry();
        entry.setTitle("Life is kind\n");
        entry.setBody("Human misunderstand it.");
        entryRepository.createEntry(entry1);
        assertEquals(2, entry.getEntryId(), entryRepository.findEntryById(2).getEntryId());
        Iterable<Entry> entries = entryRepository.findAll();
        assertEquals(entries, entryRepository.findAll());
    }
    @Test
    public void testThatEntryCanBeCleared(){
        Entry entry = new Entry();
        entry.setTitle("Big Men Don't Lack\n");
        entry.setBody("They always have surplus.");
        entryRepository.createEntry(entry);
        assertEquals(1, entry.getEntryId(), entryRepository.findEntryById(1).getEntryId());

        Entry entry1 = new Entry();
        entry.setTitle("Life is kind\n");
        entry.setBody("Human misunderstand it.");
        entryRepository.createEntry(entry1);
        assertEquals(2, entry.getEntryId(), entryRepository.findEntryById(2).getEntryId());
        entryRepository.clear();
        assertThrows(NullPointerException.class, ()-> entryRepository.findEntryById(1));
        assertThrows(NullPointerException.class, ()-> entryRepository.findEntryById(2));
    }
}

