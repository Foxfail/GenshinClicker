import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Основная форма с парой методов с помощью которых можно получить настройки указанные на форме
 */
public class Form extends JFrame implements ActionListener {

    private final JTextArea timeMsTextArea;
    private Container c;
    private JLabel title;
    private JButton clickBtn;
    private JComboBox<String> dropdownMainButton;

    public Form() {
        setTitle("Genshin Clicker");
        setBounds(600, 300, 300, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        c = getContentPane();
        c.setLayout(null);

        title = new JLabel("F9 or F12 = start/stop");
        title.setFont(new Font("Arial", Font.PLAIN, 12));
        title.setSize(300, 30);
        title.setLocation(60, 5);
        c.add(title);

        clickBtn = new JButton("ThreadSwitch");
        clickBtn.setFont(new Font("Arial", Font.PLAIN, 12));
        clickBtn.setSize(200, 25);
        clickBtn.setLocation(10, 50);
        clickBtn.addActionListener(this);
        c.add(clickBtn);

        title = new JLabel("Time in Ms:");
        title.setFont(new Font("Arial", Font.PLAIN, 12));
        title.setSize(200, 30);
        title.setLocation(10, 100);
        c.add(title);

        timeMsTextArea = new JTextArea();
        timeMsTextArea.setFont(new Font("Arial", Font.PLAIN, 15));
        timeMsTextArea.setText("100");
        timeMsTextArea.setSize(100, 20);
        timeMsTextArea.setLocation(100, 100);
        timeMsTextArea.setLineWrap(false);
        c.add(timeMsTextArea);

        dropdownMainButton = new JComboBox<>(new String[]{"F", "SPACE", "ЛКМ"});
        dropdownMainButton.setFont(new Font("Arial", Font.PLAIN, 15));
        dropdownMainButton.setSize(100, 20);
        dropdownMainButton.setLocation(100, 130);
        c.add(dropdownMainButton);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source.equals(clickBtn)) {
            if (ClickerThreadManager.isClickerThreadStarted) {
                ClickerThreadManager.stopThread();
            } else {
                ClickerThreadManager.startThread();
            }
        }
    }

    public Integer getTimeFromForm() {
        try {
        String timeMsTextAreaText = timeMsTextArea.getText();
            Integer timeInMs = Integer.valueOf(timeMsTextAreaText);
        return timeInMs;
        } catch (NumberFormatException e) {
            timeMsTextArea.setText("Not a number");
        }
        return 0;
    }

    public int getKeyEventFromForm() {
        switch (dropdownMainButton.getSelectedIndex()) {
            case 0: return KeyEvent.VK_F;
            case 1: return KeyEvent.VK_SPACE;
            case 2: return MouseEvent.BUTTON1;
        }
        throw new IllegalStateException("Ошибка списка " + dropdownMainButton.getSelectedIndex());
    }
}
