package data.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class Entry {
        private int id;
        private String title;
        private String body;
        private String owner;
        private LocalDateTime dateCreated;


    public void setId(int id) {
            this.id = id;
        }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entry entry = (Entry) o;
        return id == entry.id && Objects.equals(title, entry.title) && Objects.equals(body, entry.body)
                && Objects.equals(owner, entry.owner) && Objects.equals(dateCreated, entry.dateCreated);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, body, owner, dateCreated);
    }

    @Override
    public String toString() {
        return "Entry{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", dateCreated=" + dateCreated +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public LocalDateTime getDateCreated() {
            return dateCreated;
        }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
            this.dateCreated = dateCreated;
        }

    public int getEntryId() {
        return id;
    }

    public String getEntryInfo() {
            return title + " " + body;
        }
    }

