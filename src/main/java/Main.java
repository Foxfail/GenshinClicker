import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;

public class Main {

    public static Form form = new Form();

    public static void main(String[] args) {
        keyboardListeningOn();
    }

    private static void keyboardListeningOn() {
        try {
            GlobalScreen.registerNativeHook();
            GlobalScreen.addNativeKeyListener(new SystemKeyListener());
        } catch (NativeHookException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}
