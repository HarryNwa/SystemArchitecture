package diaryTestPack;

import data.model.Diary;
import data.repository.DiaryRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DiaryRepositoryImplTest {
    DiaryRepositoryImpl diaryRepository;
    @BeforeEach
    public void setDiaryRepository() {
        diaryRepository = new DiaryRepositoryImpl();
    }

    @Test
    public void testThatDiaryExists() {
        assertNotNull(diaryRepository);
    }

    @Test
    public void testThatDiaryCanSave() {
        Diary diary = new Diary();
        diaryRepository.save(diary);

        Diary diary1 = new Diary();
        diaryRepository.save(diary1);

        Diary diary2 = new Diary();
        diary2.setId(3);
        diaryRepository.saveNewDiary(diary2);

        assertEquals(3, diaryRepository.count());
    }
    @Test
    public void testThatDiaryCanDelete(){
        Diary diary = new Diary();
        diary.setUsername("Ogbuefi Ogumagala");
        diaryRepository.save(diary);
        assertEquals("Ogbuefi Ogumagala", diaryRepository.findById(1).getUsername());

        Diary diary1 = new Diary();
        diary1.setUsername("Ogumka Ogumaghala");
        diaryRepository.save(diary1);
        assertEquals("Ogumka Ogumaghala", diaryRepository.findById(2).getUsername());

        diaryRepository.delete(diary);
        assertEquals("Ogumka Ogumaghala", diaryRepository.findById(2).getUsername());
        System.out.println(diaryRepository.findAll());

    }
    @Test
    public void testThatDiaryCanSaveNewDiary(){
        Diary diary = new Diary();
        diary.setId(1);
        diaryRepository.saveNewDiary(diary);

        Diary diary1 = new Diary();
        diary1.setId(2);
        diaryRepository.saveNewDiary(diary1);

        Diary diary2 = new Diary();
        diary2.setId(3);
        diaryRepository.saveNewDiary(diary2);
        assertEquals(3, diaryRepository.count());
    }

    @Test
    public void testThatDiaryCanUpdate(){
        Diary diary = new Diary();
        diary.setUsername("Ogbuefi Ogumagala");
        diaryRepository.save(diary);
        assertEquals("Ogbuefi Ogumagala", diaryRepository.findById(1).getUsername());

        diaryRepository.updateDiary(diary);
        diary.setUsername("Ogbuefi Ogumka");
    //        Iterable<Diary> check = diaryRepository.findAll();
        assertEquals("Ogbuefi Ogumka", diaryRepository.findById(1).getUsername());
    }

    @Test
    public void testThatDiaryCanBeFoundById(){
        Diary diary = new Diary();
        diary.setUsername("Ogbuefi Ogumagala");
        diaryRepository.save(diary);

        Diary diary2 = new Diary();
        diary.setUsername("Ogbuagu Adaobi");
        diaryRepository.save(diary2);
        assertEquals(2, diary.getDiaryId(), diary2.getDiaryId(), diaryRepository.findById(2).getUsername());
    }
    @Test
    public void testThatDiaryCanBeCleared(){
        Diary diary = new Diary();
        diary.setUsername("Ogbuefi Ogumagala");
        diary.setPassword("0090");
        diaryRepository.save(diary);

        Diary diary2 = new Diary();
        diary.setPassword("0099");
        diary.setUsername("Ogbuagu Adaobi");
        diaryRepository.clear();
        assertThrows(NullPointerException.class, ()-> diaryRepository.findById(5));
    }
    @Test
    public void testThatDiaryCanFindAll(){
        Diary diary = new Diary();
        diary.setUsername("Ogbuefi Ogumagala");
        diary.setPassword("0090");
        diaryRepository.save(diary);

        Diary diary2 = new Diary();
        diary.setPassword("0099");
        diary.setUsername("Ogbuagu Adaobi");
        diaryRepository.save(diary2);
        Iterable<Diary> diaries = diaryRepository.findAll();
        assertEquals(diaries, diaryRepository.findAll());
    }
    }
