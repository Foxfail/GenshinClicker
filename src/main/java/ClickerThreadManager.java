
public class ClickerThreadManager {
    private static ClickerThread clickerThread;
    public static boolean isClickerThreadStarted = false;


    public static void startThread() {
        Integer timeFromForm = Main.form.getTimeFromForm();
        if (timeFromForm != 0) {
            clickerThread = new ClickerThread(timeFromForm);
            clickerThread.start();
            isClickerThreadStarted = true;
        }
    }

    public static void stopThread() {
        clickerThread.interrupt();
        isClickerThreadStarted = false;
    }
}
