package data.repository;

import data.model.Entry;

public interface EntryRepository {
        Entry createEntry(Entry entry);
        void delete(Entry entry);
        long count();
        Entry findEntryById(int entryId);
        Entry findEntryByTitle(String ownerName, String title);
        Iterable<Entry> findAll();
        void clear();

    }

