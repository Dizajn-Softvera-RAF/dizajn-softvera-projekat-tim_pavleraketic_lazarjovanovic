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

    public Message(String text, EventType eventType,LocalDateTime localDateTime) {
        this.text = text;
        this.eventType = eventType;
        this.localDateTime = localDateTime;
    }

    @Override
    public String toString() {
        return text+" ["+eventType+"]";
    }
}
