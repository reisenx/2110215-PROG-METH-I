package logic;

import java.util.Objects;

public class Message {
	private String text;
	private User sender;
	
	public Message(String text, User sender) {
		setText(text);
		setSender(sender);
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		if (text.isBlank()) {
			this.text = "<blank>";
		} else {
			this.text = text;
		}
	}

	public User getSender() {
		return sender;
	}

	public void setSender(User sender) {
		this.sender = sender;
	}

	
}
