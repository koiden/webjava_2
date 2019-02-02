package jp.co.systena.tigerscave.blackjack.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

  String[] mark = {"♠","♥","♧","♦"};
  String[] num = {"1","2","3","4","5","6","7","8","9","10","11","12","13"};
  List<String> deck = new ArrayList<String>();
  List<String> card;

  public Deck() {

      for(int i = 0;  i < mark.length; i++){
          for(int j = 0; j < num.length; j++){
              deck.add(mark[i] + num[j]);
          }
      }
  }

  public void initDeck() {
      this.deck = (List<String>) new Deck();
  }

  public List<String> GetShuffleDeck() {

      Collections.shuffle(deck);
      card = deck;


      return card;
  }


}
