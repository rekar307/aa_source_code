package observer_pattern.example;

import javax.swing.*;

public class SwingObserverExample {
    JFrame frame;

    public static void main(String[] args) {
        SwingObserverExample example = new SwingObserverExample();
        example.go();
    }

    public void go() {
        frame = new JFrame();

        JButton button = new JButton("할까 말까");
        button.addActionListener(event -> System.out.println("하지 마! 아마 후회할 걸?"));
        button.addActionListener(event -> System.out.println("그냥 저질러 버렷!!!"));
//        button.addActionListener(new AngelListner());
//        button.addActionListener(new DevilListner());

        // 프레임에 버튼 추가
        frame.getContentPane().add(button);

        // 프레임 설정
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200); // 프레임 크기 설정
        frame.setVisible(true); // 프레임을 화면에 보이도록 설정
    }
//
//    class AngelListner implements ActionListener {
//        public void actionPerformed(ActionEvent event) {
//            System.out.println("하지 마! 아마 후회할 걸?");
//        }
//    }
//
//    class DevilListner implements ActionListener {
//        public void actionPerformed(ActionEvent event) {
//            System.out.println("그냥 저질러 버렷!");
//        }
//    }
}
