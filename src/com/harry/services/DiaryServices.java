package services;

import data.model.Diary;
import data.model.Entry;

public interface DiaryServices {
    void register(String username, String password);

    Diary findByUserName(String userName);

    void delete(String userName);

    long count();

    Entry addEntry(String userName, String title, String body);
    Entry findEntry(String userName, String title);

    void lock(String userName);

    void unlock(String username, String password);
}