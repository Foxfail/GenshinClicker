import java.awt.*;
import java.awt.event.KeyEvent;

public class ClickerThread extends Thread{

    Integer sleepMs = 1000;

    public ClickerThread(Integer sleepMs) {
        this.sleepMs = sleepMs;
    }

    @Override
    public void run() {
        System.out.println("Поток запущен");
        while (true) {
            try {
                Robot robot = new Robot();
//                robot.keyPress(KeyEvent.VK_SPACE);
                robot.keyPress(KeyEvent.VK_SPACE);
                robot.keyRelease(KeyEvent.VK_SPACE);
            } catch (AWTException e) {
                e.printStackTrace();
            }

            try {
                sleep(sleepMs);
            } catch (InterruptedException e) {
                break;
            }
        }
    }

    @Override
    public void interrupt() {
        super.interrupt();
        System.out.println("Поток остановлен");
    }
}
