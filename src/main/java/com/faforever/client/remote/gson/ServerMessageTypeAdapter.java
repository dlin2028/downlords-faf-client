package com.faforever.client.remote.gson;

import com.faforever.client.fa.relay.GpgServerMessageType;
import com.faforever.client.remote.domain.FafServerMessageType;
import com.faforever.client.remote.domain.MessageTarget;
import com.faforever.client.remote.domain.ServerMessage;
import com.faforever.client.remote.domain.ServerMessageType;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

public class ServerMessageTypeAdapter implements JsonDeserializer<ServerMessage> {

  public static final ServerMessageTypeAdapter INSTANCE = new ServerMessageTypeAdapter();

  @Override
  public ServerMessage deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
    JsonObject jsonObject = json.getAsJsonObject();

    String command = jsonObject.get("command").getAsString();
    JsonElement targetElement = jsonObject.get("target");

    String target = null;
    if (targetElement != null && targetElement != JsonNull.INSTANCE) {
      target = targetElement.getAsString();
    }

    MessageTarget messageTarget = MessageTarget.fromString(target);

    ServerMessageType serverMessageType;
    switch (messageTarget) {
      case GAME:
      case CONNECTIVITY:
        serverMessageType = GpgServerMessageType.fromString(command);
        break;

      case CLIENT:
        serverMessageType = FafServerMessageType.fromString(command);
        break;

      default:
        return null;
    }

    if (serverMessageType == null) {
      return null;
    }
    return context.deserialize(jsonObject, serverMessageType.getType());
  }
}
