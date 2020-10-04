package pl.project.memorygame.engine;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Game {

    private UUID uuid;
    private List<Card> cards;
    private Integer previousCardIdx;
    private Integer selectedCardIdx;
    private Integer moveCounter;
    private Integer gameSize;
    private boolean newTurn;

    public Game(Integer gameSize) {
        newTurn = false;
        moveCounter = 0;
        previousCardIdx = -1;
        selectedCardIdx = -1;
        this.gameSize = gameSize;
        this.uuid = UUID.randomUUID();
        cards = GameService.createCards(gameSize);
    }

    public Integer getMoveCounter() {
        return moveCounter;
    }

    public Integer getPreviousCardIdx() {
        return previousCardIdx;
    }

    public void setPreviousCardIdx(Integer index) {
        previousCardIdx = index;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void incrementMoveCounter() {
        moveCounter++;
    }

    public boolean isCardAsLast() {
        return cards.get(previousCardIdx).getPicture().getPicId().equals(cards.get(selectedCardIdx).getPicture().getPicId());
    }

    public void setNewTurn(boolean newTurn) {
        this.newTurn = newTurn;
    }

    public boolean getNewTurn() {
        return newTurn;
    }

    public Integer getSelectedCardIdx() {
        return selectedCardIdx;
    }

    public void setSelectedCardIdx(Integer selectedCardIdx) {
        this.selectedCardIdx = selectedCardIdx;
    }

    public boolean isEnded() {
        return cards.stream().allMatch(Card::isRevealed);
    }

    public Integer getTourCounter() {
        return moveCounter / 2;
    }
}
