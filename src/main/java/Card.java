package main.java;

public class Card {
    private int id;
    private Name name;
    private State state;

    public Card(int id) {
        this.id = id;

        state = State.hidden;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

}
