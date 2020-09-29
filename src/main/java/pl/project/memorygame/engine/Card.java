package pl.project.memorygame.engine;

public class Card {

    private Picture picture;
    private boolean isRevealed;

    public Card(Integer picVal) {
        picture = new Picture(picVal);
        isRevealed = false;
    }

    public boolean isRevealed() {
        return isRevealed;
    }

    public void turnCard() {
        isRevealed = !isRevealed;
    }

    public Picture getPicture() {
        return picture;
    }

    @Override
    public String toString() {
        return "Card{" +
                "picture=" + picture +
                ", isRevealed=" + isRevealed +
                '}';
    }
}
