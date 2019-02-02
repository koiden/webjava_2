package jp.co.systena.tigerscave.blackjack.model;

import org.springframework.beans.factory.annotation.Value;

public class SelectGame {

  @Value("${value:bj}")
  private String selectGame;

  public String getSelectGame() {
      return selectGame;
  }

  public void setSelectGame(String selectGame) {
      this.selectGame = selectGame;
  }
}
