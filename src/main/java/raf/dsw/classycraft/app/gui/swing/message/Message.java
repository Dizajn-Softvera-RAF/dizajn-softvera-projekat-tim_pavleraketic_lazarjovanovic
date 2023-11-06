package raf.dsw.classycraft.app.gui.swing.message;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter

public class Message {
    private String text;
    private EventType eventType;
    private LocalDateTime localDateTime;

    public Message(String text, EventType eventType) {
        this.text = text;
        this.eventType = eventType;
        this.localDateTime = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "["+eventType+"]" + " ["+localDateTime+"] " + text;
    }
}
