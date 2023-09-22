package diaryTestPack;

import data.model.Entry;
import data.repository.EntryRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
}
//    @Test
//    public void testThatEntry
//    }

