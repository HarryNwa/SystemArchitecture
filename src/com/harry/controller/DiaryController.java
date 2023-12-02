package controller;

import DTO.Request;
import data.model.Diary;
import data.model.Entry;
import services.DiaryServicesImpl;
import services.EntryServicesImpl;


public class DiaryController {
    Diary diary = new Diary();
    Request request = new Request();
    DiaryServicesImpl diaryServices = new DiaryServicesImpl();
    EntryServicesImpl entryServices = new EntryServicesImpl();

    public void createDiary(String username, String password) {
        try {
            diaryServices.register(request.getUsername(), request.getPassword());
        } catch (Exception error) {
            error.getMessage();
//            createDiary(register.getUsername(), register.getPassword());
        }
    }
    public String findByUserName(String username){
        try {
            diaryServices.findByUserName(username);
        } catch (Exception error) {
            error.getMessage();
//            findByUserName(username);
        }
        return username;
    }
    public void getDiary(){

        diary.getDiaryId();
    }
    public Entry findEntryById(String ownerName, String title){
        return entryServices.findEntry(ownerName, title);
    }
    public void delete(String username){

        diaryServices.delete(username);
    }
    public void deleteEntry(String ownerName, String title){

        entryServices.delete(ownerName, title);
    }
    public long count(){
       return diaryServices.count();
    }
    public long countEntry(){
       return entryServices.count();
    }
    public Entry addEntry(String userName, String title, String body){
        return entryServices.addEntry(userName, title, body);
    }
    public void addEntryForEntry(String userName, String title, String body){
        entryServices.addEntry(userName, title, body);
    }
    public Entry findEntry(String userName, String title){

        return diaryServices.findEntry(userName, title);
    }
    public Entry findEntryForEntry(String userName, String title) {
        try {
            return entryServices.findEntry(userName, title);
        } catch (Exception error) {
            error.getMessage();
//            findEntryForEntry(userName, title);
        }
        return null;
    }
    public void lock(String userName){

        diaryServices.lock(userName);
    }

    public void unlock(String username, String password){
        try {
            diaryServices.unlock(username, password);
        }catch (Exception error){
            error.getMessage();
//            unlock(username, password);
        }
    }

}
