package com.jat.jatumba.domain.main.tracks;
import com.jat.jatumba.data.entity.User;

public class Message {
    private final int id;
    private final User contact;
    private final String content;
    private final long timestamp;

    public Message(int id, User contact, String content, long timestamp) {
        this.id = id;
        this.contact = contact;
        this.content = content;
        this.timestamp = timestamp;
    }

    public Integer getId() {
        return id;
    }

    public User getContact() {
        return contact;
    }

    public String getContent() {
        return content;
    }

    public long getTimestamp() {
        return timestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message = (Message) o;
        return id == message.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
