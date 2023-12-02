package services;

import data.model.Entry;

public interface EntryServices {
    long count();
    Entry addEntry(String ownerName, String title, String body);

    void delete(String ownerName, String title);

    Entry findEntry(String ownerName, String title);
}
