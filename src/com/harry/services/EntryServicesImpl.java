package services;

import data.model.Entry;
import data.repository.EntryRepository;
import data.repository.EntryRepositoryImpl;

public class EntryServicesImpl implements EntryServices{
    private EntryRepository entryRepository = new EntryRepositoryImpl();
    @Override
    public long count() {
        return entryRepository.count();
    }

    @Override
    public Entry addEntry(String ownerName, String title, String body) {
        Entry newEntry = new Entry();
        newEntry.setOwner(ownerName);
        newEntry.setTitle(title);
        newEntry.setBody(body);
        entryRepository.createEntry(newEntry);
        return newEntry;
    }

    @Override
    public void delete(String ownerName, String title) {
        Entry entry = findEntry(ownerName, title);
        entryRepository.delete(entry);

    }

    @Override
    public Entry findEntry(String ownerName, String title) {
        Entry entry = entryRepository.findEntryByTitle(ownerName, title);
        boolean entryIsNotFound = entry == null;
        if (entryIsNotFound){
            throw new IllegalArgumentException("Entry not found");
        }
        return entry;
    }

}
