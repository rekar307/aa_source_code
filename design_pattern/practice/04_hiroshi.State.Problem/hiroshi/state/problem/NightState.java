package hiroshi.state.problem;

public class NightState implements State {
    private static final NightState singleton = new NightState();
    private NightState() {                              // 생성자는 private
    }
    public static State getInstance() {                 // 유일한 인스턴스를 얻는다
        return singleton;
    }
    public void doClock(Context context, int hour) {    // 시간설정
        if (9 <= hour && hour < 17) {
            context.changeState(DayState.getInstance());
        }
    }
    public void doUse(Context context) {                // 금고사용
        context.callSecurityCenter("Use(NightState) - Urgent situation");
    }
    public void doAlarm(Context context) {              // 비상벨
        context.callSecurityCenter("Alarm(NightState)");
        context.changeState(UrgentState.getInstance());
    }
    public void doPhone(Context context) {              // 일반통화
        context.recordLog("Phone(NightState)");
    }
    public String toString() {                          // 문자열 표현
        return "[NightState]";
    }
}
