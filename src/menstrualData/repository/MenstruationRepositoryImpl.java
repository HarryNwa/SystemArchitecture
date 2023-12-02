package menstrualData.repository;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.*;
import java.text.SimpleDateFormat;

public class MenstruationRepositoryImpl implements MenstruationRepository {
    private final List<LocalDate> periodStartDates = new ArrayList<>();
    private Scanner keyBoard = new Scanner(System.in);
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public String register(int age, String username, String password) {
        return null;
    }

    @Override
    public Date findSafePeriodStart(Date checkDate) {
        long checkStart = checkDate.getTime() - (4 * 24 * 60 * 60 * 1000L);
        return new Date(checkStart);
    }

    @Override
    public Date calculatePeriod(Date checkDate) {
        long checkPeriod = checkDate.getTime() + (14 * 24 * 60 * 60 * 1000L);
        return new Date(checkPeriod);
    }

    @Override
    public Date findSafePeriodEnd(Date checkDate) {
        long checkEnd = checkDate.getTime() + (4 * 24 * 60 * 60 * 1000L);
        return new Date(checkEnd);
    }

    @Override
    public Date checkOvulation(Date cycleLength) {
        if (cycleLength.getTime() < 0) {
            throw new InputMismatchException("Date does not align");
        } else {
            long checkOvulation = cycleLength.getTime() + (11 * 24 * 60 * 60 * 1000L);
            return new Date(checkOvulation);
        }
    }

    @Override
    public Date findStartFlow(Date checkFlow) {
        long checkEnd = checkFlow.getTime() + (28 * 24 * 60 * 60 * 1000L);
        return new Date(checkEnd);
    }

    @Override
    public Date findEndFlow(Date checkFlow) {
//        checkFlowEnd = null;
        long checkEnd = checkFlow.getTime() + (28 * 24 * 60 * 60 * 1000L);
        return new Date(checkEnd);
    }
}
