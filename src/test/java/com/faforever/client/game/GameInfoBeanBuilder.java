package com.faforever.client.game;

import com.faforever.client.remote.domain.GameState;
import com.faforever.client.remote.domain.VictoryCondition;
import javafx.collections.FXCollections;

public class GameInfoBeanBuilder {

  private final GameInfoBean gameInfoBean;

  public GameInfoBeanBuilder() {
    gameInfoBean = new GameInfoBean();
  }

  public static GameInfoBeanBuilder create() {
    return new GameInfoBeanBuilder();
  }

  public GameInfoBeanBuilder defaultValues() {
    gameInfoBean.setFeaturedMod("faf");
    gameInfoBean.setFeaturedModVersions(FXCollections.emptyObservableMap());
    gameInfoBean.setVictoryCondition(VictoryCondition.DEMORALIZATION);
    gameInfoBean.setHost("Host");
    gameInfoBean.setFolderName("mapName");
    gameInfoBean.setNumPlayers(1);
    gameInfoBean.setNumPlayers(2);
    gameInfoBean.setSimMods(FXCollections.emptyObservableMap());
    gameInfoBean.setStatus(GameState.OPEN);
    gameInfoBean.setTitle("Title");
    gameInfoBean.setTeams(FXCollections.emptyObservableMap());
    gameInfoBean.setUid(1);
    return this;
  }

  public GameInfoBean get() {
    return gameInfoBean;
  }
}
