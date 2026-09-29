public class OnlineGame extends VideoGame {
    double versionNumber;

    public OnlineGame(String gameTitle, String gamePublisher, double gameVersionNumber) {
        super(gameTitle, gamePublisher);
        versionNumber = gameVersionNumber;
    }

    public OnlineGame(String gameTitle, String gamePublisher, double hours, double gameVersionNumber) {
        super(gameTitle, gamePublisher, hours);
        versionNumber = gameVersionNumber;
    }

    public double getVersionNumber() {
        return versionNumber;
    }

    public void setVersionNumber(double gameVersionNumber) {
        versionNumber = gameVersionNumber;
    }

    public String toString() {
        return super.toString() + ", Version: " + versionNumber;
    }

    @Override
    public String serialize() {
        return "O,%s,%s,%f,%f".formatted(getTitle(), getPublisher(), getHoursPlayed(), versionNumber);
    }
}