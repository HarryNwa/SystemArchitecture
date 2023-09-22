package data.model;

import java.time.LocalDateTime;

public class Entry {
        private int id;
        private String title;
        private String body;
        private String owner;
        private LocalDateTime dateCreated;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
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

