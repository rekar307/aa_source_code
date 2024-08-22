package hiroshi.state.problem;

public class UrgentState implements State {
    private static final UrgentState singleton = new UrgentState();
    private UrgentState() {                               // 생성자는 private
    }
    public static State getInstance() {                 // 유일한 인스턴스를 얻는다
        return singleton;
    }
    public void doClock(Context context, int hour) {    // 시간설정
//        context.callSecurityCenter("Alarm(DayState)");
    }
    public void doUse(Context context) {                // 금고사용
        context.callSecurityCenter("Use(UrgentState)");
    }
    public void doAlarm(Context context) {              // 비상벨
        context.callSecurityCenter("Alarm(UrgentState)");
    }
    public void doPhone(Context context) {              // 일반통화
        context.callSecurityCenter("Phone(UrgentState)");
    }
    public String toString() {                          // 문자열 표현
        return "[UrgentState]";
    }
}

