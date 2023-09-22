package menstrualData.repository;

import java.util.Date;

public interface MenstruationRepository {
    String register(int age, String username, String password);
    Date findSafePeriodStart(Date checkDate);
    Date calculatePeriod(Date checkDate);
    Date findSafePeriodEnd(Date checkDate);
    Date checkOvulation(Date checkDate);
    Date findStartFlow(Date checkFlow);
    Date findEndFlow(Date checkFlow);

}
