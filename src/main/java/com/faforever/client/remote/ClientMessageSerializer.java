package com.faforever.client.remote;

import com.faforever.client.game.Faction;
import com.faforever.client.game.GameVisibility;
import com.faforever.client.remote.domain.ClientMessage;
import com.faforever.client.remote.domain.ClientMessageType;
import com.faforever.client.remote.domain.GameAccess;
import com.faforever.client.remote.domain.GameState;
import com.faforever.client.remote.domain.MessageTarget;
import com.faforever.client.remote.domain.VictoryCondition;
import com.faforever.client.remote.gson.ClientMessageTypeTypeAdapter;
import com.faforever.client.remote.gson.FactionTypeAdapter;
import com.faforever.client.remote.gson.GameAccessTypeAdapter;
import com.faforever.client.remote.gson.GameStateTypeAdapter;
import com.faforever.client.remote.gson.GameVisibilityTypeAdapter;
import com.faforever.client.remote.gson.InetSocketAddressTypeAdapter;
import com.faforever.client.remote.gson.MessageTargetTypeAdapter;
import com.faforever.client.remote.gson.VictoryConditionTypeAdapter;
import com.faforever.client.remote.io.QDataWriter;
import com.google.gson.GsonBuilder;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.net.InetSocketAddress;

public class ClientMessageSerializer extends JsonMessageSerializer<ClientMessage> {

  private StringProperty username;
  private ObjectProperty<Long> sessionId;

  /**
   * Creates a message serializer that does not append username and session ID to sent messages.
   */
  public ClientMessageSerializer() {
    this(new SimpleStringProperty(), new SimpleObjectProperty<>());
  }

  /**
   * Creates a message serializer that appends username and session ID to sent messages.
   *
   * @param username the username property, so that this serializer can be initialized before the session ID
   * @param sessionId the session ID property, so that this serializer can be initialized before the session ID
   */
  public ClientMessageSerializer(StringProperty username, ObjectProperty<Long> sessionId) {
    this.username = username;
    this.sessionId = sessionId;
  }

  @Override
  protected void appendMore(QDataWriter qDataWriter) throws IOException {
    qDataWriter.append(StringUtils.defaultString(username.get()));
    if (sessionId.get() == null) {
      qDataWriter.append("");
    } else {
      qDataWriter.append(sessionId.get().toString());
    }
  }

  @Override
  protected void addTypeAdapters(GsonBuilder gsonBuilder) {
    gsonBuilder.registerTypeAdapter(GameAccess.class, GameAccessTypeAdapter.INSTANCE)
        .registerTypeAdapter(GameState.class, GameStateTypeAdapter.INSTANCE)
        .registerTypeAdapter(ClientMessageType.class, ClientMessageTypeTypeAdapter.INSTANCE)
        .registerTypeAdapter(VictoryCondition.class, VictoryConditionTypeAdapter.INSTANCE)
        .registerTypeAdapter(Faction.class, FactionTypeAdapter.INSTANCE)
        .registerTypeAdapter(GameVisibility.class, GameVisibilityTypeAdapter.INSTANCE)
        .registerTypeAdapter(MessageTarget.class, MessageTargetTypeAdapter.INSTANCE)
        .registerTypeAdapter(InetSocketAddress.class, InetSocketAddressTypeAdapter.INSTANCE);
  }
}
