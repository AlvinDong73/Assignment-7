public class SinglePlayerGame extends VideoGame {
    int releaseYear;

    public SinglePlayerGame(String gameTitle, String gamePublisher, int gameReleaseYear) {
        super(gameTitle, gamePublisher);
        releaseYear = gameReleaseYear;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int gameReleaseYear) {
        releaseYear = gameReleaseYear;
    }

    public String toString() {
        return super.toString() + " (" + releaseYear + ")";
    }

    @Override
    public String serialize() {
        return "S,%s,%s,%d".formatted(getTitle(), getPublisher(), releaseYear);
    }
}
