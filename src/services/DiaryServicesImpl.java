package services;

import data.model.Diary;
import data.repository.DiaryRepositoryImpl;

public class DiaryServicesImpl implements DiaryServices {
    DiaryRepositoryImpl diaryRepository = new DiaryRepositoryImpl();

    @Override
    public void register(String username, String password) {
        Diary diary = new Diary();
        diary.setUsername(username);
        diary.setPassword(password);
        diaryRepository.saveNewDiary(diary);
    }

    public void validate(String userName){
        for (Diary diary: diaryRepository.findAll()){
            if (diary.getUsername().equals(userName))
                throw new IllegalArgumentException("Username already used");
        }
    }

    public Diary findByUserName(String userName) {
        for (Diary diary : diaryRepository.findAll()) {
            if (diary.getUsername().equals(userName)) {
                return diary;
            }
        }
        throw new IllegalArgumentException("Diary not found");
    }

    public  void delete(String userName){
        validate(userName);
        Diary diaryRepository1 = findByUserName(userName);
        diaryRepository.delete(diaryRepository1);
    }
    public long count(){
        return diaryRepository.count();
    }
}
