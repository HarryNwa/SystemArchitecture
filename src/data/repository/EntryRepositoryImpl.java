package data.repository;

import data.model.Diary;
import data.model.Entry;

import java.util.ArrayList;
import java.util.List;

public class EntryRepositoryImpl implements EntryRepository{
    List<Entry> entries = new ArrayList<>();

    public Entry createEntry(Entry entry) {
        boolean diaryDoesNotExist = entry.getEntryId() == 0 || findEntryById(entry.getEntryId()) == null;
        if (diaryDoesNotExist) saveNewEntry(entry);

        else {
            updateEntry(entry);
        }
        return entry;
    }

    public void updateEntry(Entry entry) {
        Entry newEntry = findEntryById(entry.getEntryId());
        newEntry.setTitle(entry.getTitle());
        newEntry.setBody(entry.getBody());

    }

    public void saveNewEntry(Entry entry) {
        entry.setId(generateId());
        entries.add(entry);
    }

    public int generateId() {
        return entries.size() + 1;
    }
    @Override
    public void delete(Entry entry) {
        Entry entry1 = findEntryById(entry.getEntryId());
        entries.remove(entry1);
    }

    @Override
    public long count() {
        return entries.size();
    }

    @Override
    public Entry findEntryById(int entryId) {
        for (Entry entry : entries) {
            if (entry.getEntryId() == entryId) {
                return entry;
            }
        }
        throw new NullPointerException("Invalid ID");
//        return null;
    }

    @Override
    public Iterable<Entry> findAll () {
        return entries;
    }

    @Override
    public void clear () {
        entries.clear();
    }
}
