/**
 * Класс управляет запуском, остановкой и хранит состояние потока ClickerThread
 */
public class ClickerThreadManager {
    private static ClickerThread clickerThread;
    public static boolean isClickerThreadStarted = false;


    public static void startThread() {
        Integer timeFromForm = Main.form.getTimeFromForm();
        int keyEventForm = Main.form.getKeyEventForm();
        if (timeFromForm != 0) {
            clickerThread = new ClickerThread(timeFromForm, keyEventForm);
            clickerThread.start();
            isClickerThreadStarted = true;
        }
    }

    public static void stopThread() {
        clickerThread.interrupt();
        isClickerThreadStarted = false;
    }
}
