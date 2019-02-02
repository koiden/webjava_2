package jp.co.systena.tigerscave.blackjack.model;

import java.util.List;

public class GameForm {

  private String moveflg;

  private List<String> deck;

  private int index;

  public String getMoveFlg() {
      return moveflg;
  }

  public void setMoveFlg(String moveflg) {
      this.moveflg = moveflg;
  }

  public List<String> getDeck() {
      return deck;
  }

  public void setDeck(List<String> deck) {
      this.deck = deck;
  }

  public int getIndex() {
      return index;
  }

  public void setIndex(int index) {
      this.index = index;
  }
}