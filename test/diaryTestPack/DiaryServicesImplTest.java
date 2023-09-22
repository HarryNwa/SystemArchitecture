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
        assertThrows(IllegalArgumentException.class, ()-> diaryServices.validate("Username"));
    }


}