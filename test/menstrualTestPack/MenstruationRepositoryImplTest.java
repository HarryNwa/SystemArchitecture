package menstrualTestPack;

import menstrualData.repository.MenstruationRepositoryImpl;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MenstruationRepositoryImplTest {

    @Test
    public void testThatMenstrualPeriodCanBeChecked(){
        MenstruationRepositoryImpl menstruationRepository = new MenstruationRepositoryImpl();
        Date checkDate = new Date(2023 - 1900, 9, 15);
        Date calculate = menstruationRepository.calculatePeriod(checkDate);
        Date result = new Date(2023 - 1900, 9, 29);
        assertEquals(result, calculate);
    }
    @Test
    public void testThatMenstrual_SafePeriodStarting_CanBeChecked(){
        MenstruationRepositoryImpl menstruationRepository = new MenstruationRepositoryImpl();
        Date checkDate = new Date(2023 - 1900, 9, 15);
        Date calculate = menstruationRepository.findSafePeriodStart(checkDate);
        Date result = new Date(2023 - 1900, 9, 5);
        assertEquals(result, calculate);
    }
    @Test
    public void testThatMenstrual_SafePeriodEnding_CanBeChecked(){
        MenstruationRepositoryImpl menstrualPeriod = new MenstruationRepositoryImpl();
        Date checkDate = new Date(2023 - 1900, 9, 15);
        Date calculate = menstrualPeriod.findSafePeriodEnd(checkDate);
        Date result = new Date(2023 - 1900, 9, 25);
        assertEquals(result, calculate);
        System.out.println(result);
    }
    @Test
    public void testThatMenstrual_Ovulation_CanBeChecked(){
        MenstruationRepositoryImpl menstrualPeriod = new MenstruationRepositoryImpl();
        Date checkDate = new Date(2023 - 1900, 9, 25);
        Date calculate = menstrualPeriod.checkOvulation(checkDate);
        Date result = new Date(2023 - 1900, 10, 5);
        assertEquals(result, calculate);
    }
    @Test
    public void testThatMenstrual_FlowStart_CanBeCalculated(){
        MenstruationRepositoryImpl menstrualPeriod = new MenstruationRepositoryImpl();
        Date checkDate = new Date(2023 - 1900, 9, 25);
        Date calculate = menstrualPeriod.findStartFlow(checkDate);
        Date result = new Date(2023 - 1900, 10, 22);
        assertEquals(result, calculate);
    }

}
