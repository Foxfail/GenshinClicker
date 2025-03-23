import com.github.kwhat.jnativehook.keyboard.NativeKeyEvent;
import com.github.kwhat.jnativehook.keyboard.NativeKeyListener;

/**
 * Слушатель клавиатуры.
 * Ожидает события нажатия клавиши F9 или F12
 * и запускает/останавливает кликер
 */
public class SystemKeyListener implements NativeKeyListener {

    @Override
    public void nativeKeyPressed(NativeKeyEvent nativeEvent) {
        NativeKeyListener.super.nativeKeyPressed(nativeEvent);
        if (nativeEvent.getKeyCode() == NativeKeyEvent.VC_F9 ||
                nativeEvent.getKeyCode() == (NativeKeyEvent.VC_F12)) {
            if (ClickerThreadManager.isClickerThreadStarted) {
                ClickerThreadManager.stopThread();
            } else {
                ClickerThreadManager.startThread();
            }
        }
    }
}
