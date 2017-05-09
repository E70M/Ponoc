import javafx.scene.image.Image;
public class ElementLoader {
    public Image getAppIcon() {
        return new Image(ElementLoader.class.getResourceAsStream("Ponoc_Icon.png"));
    }
    public Image getFightBackground() {
        return new Image(ElementLoader.class.getResourceAsStream("fightbackground.png"));
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
}