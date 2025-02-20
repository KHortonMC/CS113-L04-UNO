package UNO;

public class Card {
    public enum Values {
        One,
        Two,
        Three,
        Four,
        Five,
        Reverse
    };

    public enum Colors {
        Red,
        Green,
        Blue
    };
    
    Values value;
    Colors color;

    public Values getValue() { return this.value; }
    public Colors getColor() { return this.color; }

    public Card(Values value, Colors color) {
        this.value = value;
        this.color = color;
    }

    public boolean canPlay(Card other) {
        if (other == null) return false;
        return this.color == other.color || this.value == other.value;
    }

    public String toString() {
        return this.color.name() + " " + this.value.name();
    }
}
