package data.repository;

import data.model.Diary;

public interface DiaryRepository {

        Diary save(Diary diary);
        void delete(Diary diary);
        long count();
        Diary findById(int id);

        Diary findBy(int id);

        Iterable<Diary> findAll();
        void clear();

        String getDiaryUsername();

        Diary findByUsername(String userName);
}

