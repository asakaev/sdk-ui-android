package ru.livetex.sdkui.chat.db;

import ru.livetex.sdk.entity.FileMessage;
import ru.livetex.sdk.entity.TextMessage;
import ru.livetex.sdk.entity.Visitor;
import ru.livetex.sdkui.chat.db.entity.ChatMessage;

/**
 * Transform server entities to DB variants
 */
public class Mapper {

	public static ChatMessage toChatMessage(TextMessage textMessage) {
		ChatMessage chatMessage = new ChatMessage(textMessage.id,
				textMessage.content,
				textMessage.createdAt,
				!(textMessage.creator instanceof Visitor),
				textMessage.creator,
				textMessage.keyboard
				);
		return chatMessage;
	}

	public static ChatMessage toChatMessage(FileMessage fileMessage) {
		ChatMessage chatMessage = new ChatMessage(fileMessage.id,
				fileMessage.name,
				fileMessage.createdAt,
				!(fileMessage.creator instanceof Visitor),
				fileMessage.url,
				fileMessage.creator,
				null
		);
		return chatMessage;
	}
}
