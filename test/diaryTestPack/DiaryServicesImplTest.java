package diaryTestPack;

import org.junit.jupiter.api.Test;
import services.DiaryServicesImpl;

import static org.junit.jupiter.api.Assertions.*;

class DiaryServicesImplTest {
    @Test
    public void testThatDiaryCanRegister(){
        DiaryServicesImpl diaryServices = new DiaryServicesImpl();
        diaryServices.register("Username", "Password");
        assertNotNull(diaryServices.findByUserName("Username"));
        assertThrows(IllegalArgumentException.class, ()-> diaryServices.register("Username", "Password"));
    }
    @Test
    public void testThatDiaryCanBeFoundByUserName(){
        DiaryServicesImpl diaryServices = new DiaryServicesImpl();
        diaryServices.register("HarryNwa", "9090");
        assertNotNull(diaryServices.findByUserName("HarryNwa"));
    }
//    @Test
//    public void testThatDiaryCanBeDeleted(){
//        DiaryServicesImpl diaryServices = new DiaryServicesImpl();
//        diaryServices.register("HarryNwa", "9090");
//        diaryServices.delete("HarryNwa");
//        assertNotNull(diaryServices.findByUserName("HarryNwa"));
//
//        DiaryServicesImpl diary = new DiaryServicesImpl();
//        diary.register("Alpha", "8888");
//        diary.delete("Alpha");
//        assertNotNull(diary.findByUserName("Alpha"));

    }
