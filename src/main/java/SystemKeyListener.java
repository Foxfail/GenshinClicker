import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;


public class SystemKeyListener implements NativeKeyListener {

    @Override
    public void nativeKeyPressed(NativeKeyEvent nativeEvent) {
        NativeKeyListener.super.nativeKeyPressed(nativeEvent);
        if (nativeEvent.getKeyCode() == 88) {
            if (ClickerThreadManager.isClickerThreadStarted) {
                ClickerThreadManager.stopThread();
            } else {
                ClickerThreadManager.startThread();
            }
        }
    }
}
