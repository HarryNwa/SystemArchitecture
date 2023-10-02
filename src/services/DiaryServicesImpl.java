package services;

import data.model.Diary;
import data.repository.DiaryRepositoryImpl;

public class DiaryServicesImpl implements DiaryServices {
    DiaryRepositoryImpl diaryRepository = new DiaryRepositoryImpl();

    @Override
    public void register(String username, String password) {
        Diary diary = new Diary();
        diary.setUsername(validate(username));
        diary.setPassword(password);
        diaryRepository.saveNewDiary(diary);

    }

    @Override
    public Diary findByUserName(String userName) {
        for (Diary diary : diaryRepository.findAll()) {
            if (diary.getUsername().equals(userName)) {
                return diary;
            }
        }
        throw new IllegalArgumentException("Diary not found");
    }

    @Override
    public void delete(String userName) {
        validate(userName);
        Diary diaryRepository1 = findByUserName(userName);
        diaryRepository.delete(diaryRepository1);
    }

    @Override
    public long count() {
        return diaryRepository.count();
    }

    private String validate(String userName){
        for (Diary diary: diaryRepository.findAll()){
            if (diary.getUsername().equals(userName))
                throw new IllegalArgumentException("Username already used");
        }
        return userName;
    }
}
