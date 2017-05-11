import javafx.scene.image.Image;
import java.util.ArrayList;
public class ElementLoader {
    private ArrayList<String> input = new ArrayList<>();
    public Image getAppIcon() {
        return new Image(ElementLoader.class.getResourceAsStream("Ponoc_Icon.png"));
    }
    public Image getFightBackground() {
        return new Image(ElementLoader.class.getResourceAsStream("Game_Background.jpg"));
    }
    public Image getAdinLeft() {
        return new Image(ElementLoader.class.getResourceAsStream("adinleft.png"));
    }
    public Image getAdinRight() {
        return new Image(ElementLoader.class.getResourceAsStream("adinright.png"));
    }
    public Image getAdinSwordLeft() {
        return new Image(ElementLoader.class.getResourceAsStream("adin_swordleft.png"));
    }
    public Image getAdinSwordRight() {
        return new Image(ElementLoader.class.getResourceAsStream("adin_swordright.png"));
    }
    public Image getEnemyLeft() {
        return new Image(ElementLoader.class.getResourceAsStream("enemyleft.png"));
    }
    public Image getEnemyRight() {
        return new Image(ElementLoader.class.getResourceAsStream("enemyright.png"));
    }
    public void addToInput(String code) {
        input.add(code);
    }
    public void removeInput(String code) {
        input.remove(code);
    }
    public boolean isContaining(String test) {
        if(input.contains(test)) {
            return true;
        }
        else {
            return false;
        }
    }
}