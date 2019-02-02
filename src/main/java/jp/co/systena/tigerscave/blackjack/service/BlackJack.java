package jp.co.systena.tigerscave.blackjack.service;

import java.util.ArrayList;
import java.util.List;

public class BlackJack {

  public String GetOneCard(List<String> deck,int index) {


      String dealerHand = deck.get(index);

      return dealerHand;
  }

  public List<String> GetTwoCard(List<String> deck,int index) {

      List<String> userHands = new ArrayList<>();

      String Hand1 = deck.get(index++);
      String Hand2 = deck.get(index);
      userHands.add(Hand1);
      userHands.add(Hand2);

      return userHands;
  }
}
