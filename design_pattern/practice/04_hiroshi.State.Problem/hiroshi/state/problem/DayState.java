package hiroshi.state.problem;

public class DayState implements State {
    private static final DayState singleton = new DayState();
    private DayState() {                               // 생성자는 private
    }
    public static State getInstance() {                 // 유일한 인스턴스를 얻는다
        return singleton;
    }
    public void doClock(Context context, int hour) {    // 시간설정
        if (hour < 9 || 17 <= hour) {
            context.changeState(NightState.getInstance());
        }
    }
    public void doUse(Context context) {                // 금고사용
        context.recordLog("Use(DayState)");
    }
    public void doAlarm(Context context) {              // 비상벨
        context.callSecurityCenter("Alarm(DayState)");
    }
    public void doPhone(Context context) {              // 일반통화
        context.callSecurityCenter("Phone(DayState)");
    }
    public String toString() {                          // 문자열 표현
        return "[DayState]";
    }
}

