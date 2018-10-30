package main;

public class Card {
    private int id;
    private String name;
    private boolean hidden;
    private boolean viewing;
    private boolean matched;
    private State state;

    public Card() {
        state = State.hidden;
        this.hidden = true;

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void setHidden(boolean state){
        this.hidden = state;
    }

    public void setViewing(boolean state){
        this.viewing = state;
    }

    public void setMatched(boolean state){
        this.matched = state;
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


}
