public abstract class VideoGame {
    protected String title, publisher;

    public VideoGame(String gameTitle, String gamePublisher) {
        title = gameTitle;
        publisher = gamePublisher;
    }

    public String getTitle() {
        return title;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setTitle(String gameTitle) {
        title = gameTitle;
    }

    public void setPublisher(String gamePublisher) {
        publisher = gamePublisher;
    }

    public String toString() {
        return title + ", Published by: " + publisher;
    }

    // Two games are equal if they have the same publisher and title.
    public boolean equals(Object other) {
        VideoGame casted = (VideoGame) other;
        return casted != null && casted.publisher.equals(publisher) && casted.getTitle().equals(title);
    }

    // All subclasses must have a concise string representation that can be saved
    // to a file in a way where the original data can be reconstructed.
    public abstract String serialize();
}