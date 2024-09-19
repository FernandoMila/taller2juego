package presentacion;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Sonidos {
    private static Clip clip;

    public static void reproducir(String rutaSonido) {
        try {
            if (clip != null && clip.isRunning()) {
                clip.stop();
            }
            File soundFile = new File(rutaSonido);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(soundFile);
            clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    public static void detener() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
        }
    }

    public static void toggleSonido(boolean activar) {
        if (activar) {
            clip.start();
        } else {
            detener();
        }
    }
    public static void reproducirSonidoMaquinaEscribir() {
    reproducir("ruta/del/sonido/maquina_escribir.wav"); // Asegúrate de cambiar la ruta por la correcta
}

public static void detenerSonidoMaquinaEscribir() {
    detener();
}

}
