import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;


@Slf4j
public class DateCalendarTest {

    @Test
    @DisplayName("Calendar -> Date 테스트")
    public void toDate() {
        Calendar calendar = Calendar.getInstance(); //기본적으로 현재 시간으로 설정 됨
        int year = calendar.get(Calendar.YEAR);
        log.info(String.valueOf(year));

        int month = calendar.get(Calendar.MONTH); // 0~11 로 월을 표현한다
        log.info(String.valueOf(month));

        Date date = calendar.getTime();
        log.info(date.toString());
        Date date2 = new Date(calendar.getTimeInMillis());
        log.info(date2.toString());
    }

    @Test
    @DisplayName("Date -> Calendar 테스트")
    public void toCalendar() {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        log.info("date : {}, calendar : {}", date, calendar.getTime());
    }

    @Test
    @DisplayName("두 날짜간의 차이 구하기")
    public void getDifference() {
        Calendar time1 = Calendar.getInstance();
        Calendar time2 = Calendar.getInstance();
        time1.set(Calendar.HOUR_OF_DAY, 10);
        time1.set(Calendar.MINUTE, 30);
        time1.set(Calendar.SECOND, 30);

        time2.set(Calendar.HOUR_OF_DAY, 20);
        time2.set(Calendar.MINUTE, 10);
        time2.set(Calendar.SECOND, 48);

        long difference = (time2.getTimeInMillis() - time1.getTimeInMillis())/1000;
        log.info("둘의 시간 차이는 {} 초 입니다. ", difference);

        //단 순히 전, 후를 알고 싶을 때
        log.info(String.valueOf(time1.after(time2)));
        log.info(String.valueOf(time1.before(time2)));
    }

    @Test
    @DisplayName("날짜 더하기, 빼기")
    public void addDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2024, 7, 31);
        log.info("original : {}", calendar.getTime());
        calendar.roll(Calendar.DATE, 1);
        log.info("after 31 roll() : {}", calendar.getTime());

        Calendar calendar2 = Calendar.getInstance();
        calendar2.set(2024, 7, 31);
        calendar2.add(Calendar.DATE, 1);
        log.info("after 31 add() : {}", calendar2.getTime());

        Calendar calendar4 = Calendar.getInstance();
        calendar4.set(2024, 7, 17);
        calendar4.roll(Calendar.DATE, 15);
        log.info("after roll() : {}", calendar4.getTime());

        Calendar calendar3 = Calendar.getInstance();
        calendar3.set(2024, 7, 17);
        calendar3.add(Calendar.DATE, 15);
        log.info("after add() : {}", calendar3.getTime());

        //다음달의 1일에서 하루를 빼면 이번 달의 마지막 일을 알 수 있다.
        Calendar calendar5 = Calendar.getInstance();
        calendar5.set(2024, 7, 1);
        calendar5.add(Calendar.DATE, -1);
        log.info("after - add() : {}", calendar5.getTime());
    }
}
