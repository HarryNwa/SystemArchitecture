package data.repository;

import data.model.Diary;

import java.util.ArrayList;
import java.util.List;

public class DiaryRepositoryImpl implements DiaryRepository{
    private int ID;
    private String username;
    private String password;
    private boolean isLocked;
    private int count;
    List<Diary> diaries = new ArrayList<>();

    @Override
    public Diary save(Diary diary) {
        boolean diaryDoesNotExist = diary.getDiaryId() == 0 || findById(diary.getDiaryId()) == null;
        if (diaryDoesNotExist) saveNewDiary(diary);

        else {
            updateDiary(diary);
        }
        return diary;
    }

    public void saveNewDiary(Diary diary) {
        diary.setId(generateId());
        diaries.add(diary);
    }

    public int  generateId() {
        return diaries.size() + 1;
    }

    public void updateDiary(Diary diary) {
        Diary newDiary = findById(diary.getDiaryId());
        newDiary.setUsername(diary.getUsername());
    }

    @Override
    public void delete(Diary diary) {
        Diary diary1 = findById(diary.getDiaryId());
        diaries.remove(diary1);
    }

    @Override
    public long count() {
        return diaries.size();
    }

    @Override
    public Diary findById(int id) {
        for (Diary diary : diaries) {
            if (diary.getDiaryId() == id) {
                return diary;
            }
        }
        throw new NullPointerException("Invalid ID");
    }

    @Override
    public Iterable<Diary> findAll() {
        return diaries;
    }

    @Override
    public void clear() {
        diaries.clear();
    }

    @Override
    public String getDiaryUsername() {
        return username;
    }
}

