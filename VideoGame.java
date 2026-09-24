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

    public boolean equals(Object other) {
        VideoGame casted = (VideoGame) other;
        return casted != null && casted.publisher.equals(publisher) && casted.getTitle().equals(title);
    }

    public abstract String serialize();
}