package board;


import javax.swing.*;
import java.awt.image.BufferedImage;

public class Card extends JButton {

    private String name;
    private boolean hidden;
    private boolean viewing;
    private boolean matched;
    private ImageIcon icon;


    public Card() {
        this.hidden = true;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isHidden() {
        return hidden;
    }

    public boolean isViewing() {
        return viewing;
    }

    public boolean isMatched() {
        return matched;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    public void setViewing(boolean viewing) {
        this.viewing = viewing;
    }

    public void setMatched(boolean matched) {
        this.matched = matched;
    }

    public void setCardIcon(ImageIcon cardIcon) {
        this.icon = icon;
    }

    public ImageIcon getCardIcon() {
        return icon;
    }


}

