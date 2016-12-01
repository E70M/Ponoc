import java.util.*;
/**
 * Created by domin on 12/1/2016.
 */
public class Themesong {
    public static void main(String args []) {
        try{
            AudioInputStream audioInputStream =
                    AudioSystem.getAudioInputStream(
                            this.getClass().getResource("Ponoc_Themesong"));
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        }
        catch(Exception ex)
        {
        }
    }
}
