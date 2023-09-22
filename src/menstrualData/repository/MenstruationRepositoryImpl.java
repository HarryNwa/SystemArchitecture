package menstrualData.repository;

import java.util.Date;
import java.util.InputMismatchException;

public class MenstruationRepositoryImpl implements MenstruationRepository {
    @Override
    public String register(int age, String username, String password) {
        return null;
    }

    @Override
    public Date findSafePeriodStart(Date checkDate) {
        long checkStart = checkDate.getTime() - (10 * 24 * 60 * 60 * 1000L);
        return new Date(checkStart);
    }

    @Override
    public Date calculatePeriod(Date checkDate) {
        long checkPeriod = checkDate.getTime() + (14 * 24 * 60 * 60 * 1000L);
        return new Date(checkPeriod);
    }

    @Override
    public Date findSafePeriodEnd(Date checkDate) {
        long checkEnd = checkDate.getTime() + (10 * 24 * 60 * 60 * 1000L);
        return new Date(checkEnd);
    }

    @Override
    public Date checkOvulation(Date cycleLength) {
        if (cycleLength.getTime() < 0 ) {
            throw new InputMismatchException("Date does not align");
        }else {long checkOvulation = cycleLength.getTime() + (11 * 24 * 60 * 60 * 1000L);
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
        long checkEnd = checkFlow.getTime() + (28  * 24 * 60 * 60 * 1000L);
        return new Date(checkEnd);
    }
}
