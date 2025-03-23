import java.awt.*;
import java.awt.event.MouseEvent;

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
                //todo убрать этот if костыль, введённый для события мыши.
                // Мышь и клавиатура идут под разными id и по разным методам Robot'a
                // 1. Из вариантов думал насчёт общего класа InputEvent и тут использовать instanceof
                // 2. Ввести свой класс/энум/адаптер для единого хранения и доступа к кнопкам, которые надо тыкать
                // эти варианты мне не нравятся, поэтому костылю if'ом пока не придумаю что-то лучше
                if(keyEventForm != 1) {
                    robot.keyPress(keyEventForm);
                    robot.keyRelease(keyEventForm);
                } else {
                    robot.mousePress(MouseEvent.BUTTON1_DOWN_MASK);
                    robot.mouseRelease(MouseEvent.BUTTON1_DOWN_MASK);
                }
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
