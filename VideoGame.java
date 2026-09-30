public abstract class VideoGame {
    private String title, publisher;
    private double hoursPlayed;

    public VideoGame(String gameTitle, String gamePublisher) {
        title = gameTitle;
        publisher = gamePublisher;
        hoursPlayed = 0;
    }

    public VideoGame(String gameTitle, String gamePublisher, double hours) {
        title = gameTitle;
        publisher = gamePublisher;
        hoursPlayed = hours;
    }

    public String getTitle() {
        return title;
    }

    public double getHoursPlayed() {
        return hoursPlayed;
    }

    public void play(double hours) {
        hoursPlayed += hours;
        System.out.printf("Playing %s for %.1f hours", title, hours);
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
        return title + " (played for " + hoursPlayed + " hours), Published by: " + publisher;
    }

    // Two games are equal if they have the same publisher and title.
    public boolean equals(Object other) {
        if (other instanceof VideoGame) {
            VideoGame casted = (VideoGame) other;
            return casted.publisher.equals(publisher) && casted.getTitle().equals(title);
        } else {
            return false;
        }
    }

    // All subclasses must have a concise string representation that can be saved
    // to a file in a way where the original data can be reconstructed.
    public abstract String serialize();
}