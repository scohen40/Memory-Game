import java.util.Arrays;
import java.util.List;

public enum CardName {

    airplane("airplane"),
    backpack("backpack"),
    bicycle("bicycle"),
    book("book"),
    chocolate("chocolate"),
    clock("clock"),
    coffee("coffee"),
    dog("dog"),
    donut("donut"),
    flower("flower"),
    glasses("glasses"),
    popcorn("popcorn"),
    paint("paint"),
    pencil("pencil"),
    rainbow("rainbow"),
    soda("soda"),
    snowman("snowman"),
    umbrella("umbrella");

    public String cardName;

    CardName(String cardName) {
        this.cardName = cardName;
    }

    public static List<CardName> getList() {
        return Arrays.asList(CardName.values());
    }


}
