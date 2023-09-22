package data.model;

import java.util.ArrayList;
import java.util.List;

public class Diary {
        private String username;
        private String password;
        private boolean isLocked;
        private int id;
        List<Entry> entries = new ArrayList<>();

        public List<Entry> getEntries() {
            return entries;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public boolean isLocked() {
            return isLocked;
        }

        public void setLocked(boolean locked) {
            isLocked = locked;
        }

        public void setEntries(List<Entry> entries) {
            this.entries = entries;
        }

        public int getDiaryId() {
            return id;
        }
        @Override
        public String toString() {
            return "Diary{" +
                    "username='" + username + '\'' +
                    ", password='" + password + '\'' +
                    ", isLocked=" + isLocked +
                    ", entries=" + entries +
                    '}';
        }

    public String getDiaryUsername() {
            return username;
    }
}

