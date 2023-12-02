package services;

import data.model.Diary;
import data.model.Entry;
import data.repository.DiaryRepository;
import data.repository.DiaryRepositoryImpl;

public class DiaryServicesImpl implements DiaryServices {
    private EntryServices entryServices;
    private DiaryRepository diaryRepository;

    public DiaryServicesImpl() {
        diaryRepository = new DiaryRepositoryImpl();
        entryServices = new EntryServicesImpl();
    }

    @Override
    public void register(String username, String password) {
        Diary diary = new Diary();
        if (validate(username)) {
            diary.setUsername(username);
            diary.setPassword(password);
            diaryRepository.save(diary);
        }else {
            throw new IllegalArgumentException("Username taken");
        }

    }

    @Override
    public Diary findByUserName(String userName) {
        for (Diary diary : diaryRepository.findAll()) {
            if (diary.getUsername().equalsIgnoreCase(userName)) {
                return diary;
            }
        }
        throw new IllegalArgumentException("Diary not found");
    }

    @Override
    public void delete(String userName) {
//        validate(userName);
        if (findByUserName(userName).getDiaryUsername().equals(userName)) {
            diaryRepository.delete(findByUserName(userName));
        }
    }

    @Override
    public long count() {
        return diaryRepository.count();
    }

    @Override
    public Entry addEntry(String userName, String title, String body) {
        validateUserName(userName);
        return entryServices.addEntry(userName, title, body);
    }

    @Override
    public Entry findEntry(String userName, String title) {
        Entry entry = entryServices.findEntry(userName, title);
        return entry;
    }

    @Override
    public void lock(String userName) {
        Diary foundDiary = findByUserName(userName);
        if (foundDiary.getUsername().equals(userName))
            foundDiary.setLocked(true);
            diaryRepository.save(foundDiary);
//        return foundDiary;
//        if (foundDiary.getPassword().equals(userName)) foundDiary.setLocked(true);
    }

    private boolean validate(String userName) {
        for (Diary diary : diaryRepository.findAll()) {
            if (diary.getUsername().equals(userName)) {
                throw new IllegalArgumentException("Username already used");
            }
        }
        return true;
    }
    private void validateUserName(String userName) {
        Diary diary = diaryRepository.findByUsername(userName);
        if (diary == null) {
            throw new IllegalArgumentException("Username already used");
        }
        if (diary.isLocked()) {
            throw new IllegalArgumentException("Diary is locked");
        }
    }

    public void unlock(String username, String password) {
        Diary diary = findByUserName(username);
        if (diary.getPassword().equals(password))
            diary.setLocked(false);
        else
            throw new IllegalArgumentException("Incorrect password");
        diaryRepository.save(diary);
    }
}
