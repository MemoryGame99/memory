package MemoryGameMateusz;

public class Card {

    boolean showing;
    String back;
    int front;

    public Card(String back, int front) {
        this.back = back;
        this.front = front;
        showing = false;
    }

    public void showCard(){
        if(showing){
            System.out.printf("%10s", back);
        } else {
            System.out.printf("%10s", front);
        }
    }

    public void setShowing(){
        if(showing){
            showing = false;
        } else {
            showing = true;
        }
    }


}
