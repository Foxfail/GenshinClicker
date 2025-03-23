import java.awt.*;

/**
 * Класс является отдельным потоком в котором происходит нажатие клавиш
 * согласно переданным в конструктор параметрам
 */
public class ClickerThread extends Thread{

    Integer sleepMs;
    int keyEventForm;

    public ClickerThread(Integer sleepMs, int keyEventForm) {
        this.sleepMs = sleepMs;
        this.keyEventForm = keyEventForm;
    }

    @Override
    public void run() {
        System.out.println("Поток запущен");
        while (true) {
            try {
                Robot robot = new Robot();
                robot.keyPress(keyEventForm);
                robot.keyRelease(keyEventForm);
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
