package hiroshi.state.problem;
import java.awt.Frame;
import java.awt.Color;
import java.awt.Button;
import java.awt.TextField;
import java.awt.TextArea;
import java.awt.Panel;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SafeFrame extends Frame implements ActionListener, Context {
    private final TextField textClock = new TextField(60);        // 현재시간 표시
    private final TextArea textScreen = new TextArea(10, 60);    // 경비센터 출력
    private final Button btnUse = new Button("Use");   // 금고사용 버튼
    private final Button btnAlarm = new Button("Alarm");    // 비상벨 버튼
    private final Button btnPhone = new Button("Phone");  // 일반통화 버튼
    private final Button btnExit = new Button("Exit");        // 종료 버튼

    private State state = DayState.getInstance();           // 현재의 상태

    // 생성자
    public SafeFrame(String title) {
        super(title);
        setBackground(Color.lightGray);
        setLayout(new BorderLayout());
        // textClock을 배치
        add(textClock, BorderLayout.NORTH);
        textClock.setEditable(false);
        // textScreen을 배치
        add(textScreen, BorderLayout.CENTER);
        textScreen.setEditable(false);
        // 패널에 버튼을 저장
        Panel panel = new Panel();
        panel.add(btnUse);
        panel.add(btnAlarm);
        panel.add(btnPhone);
        panel.add(btnExit);
        // 그 패널을 배치
        add(panel, BorderLayout.SOUTH);
        // 표시
        pack();
        show();
        // listener의 설정
        btnUse.addActionListener(this);
        btnAlarm.addActionListener(this);
        btnPhone.addActionListener(this);
        btnExit.addActionListener(this);
    }
    // 버튼이 눌려졌을 때 여기로 온다
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.toString());
        if (e.getSource() == btnUse) {           // doUse
            state.doUse(this);
        } else if (e.getSource() == btnAlarm) {  // doAlarm
            state.doAlarm(this);
        } else if (e.getSource() == btnPhone) {  // doPhone
            state.doPhone(this);
        } else if (e.getSource() == btnExit) {   // Exit
            System.exit(0);
        } else {
            System.out.println("?");
        }
    }
    // 시간설정
    public void setClock(int hour) {
        String clockstring = "Current time is ";
        if (hour < 10) {
            clockstring += "0" + hour + ":00";
        } else {
            clockstring += hour + ":00";
        }
        System.out.println(clockstring);
        textClock.setText(clockstring);
        state.doClock(this, hour);
    }
    // 상태전환
    public void changeState(State state) {
        System.out.println("State changed - from: " + this.state + " to: " + state + ".");
        this.state = state;
    }
    // 경비센터의 호출
    public void callSecurityCenter(String msg) {
        textScreen.append("call! " + msg + "\n");
    }
    // 경비센터의 기록
    public void recordLog(String msg) {
        textScreen.append("record ... " + msg + "\n");
    }
}
