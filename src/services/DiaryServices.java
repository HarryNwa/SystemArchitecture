package services;

import data.model.Diary;

public interface DiaryServices {
    void register(String username, String password);
    Diary findByUserName(String userName);
    void delete(String userName);
    long count();
}
