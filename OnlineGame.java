public class OnlineGame extends VideoGame {
    double versionNumber;

    public OnlineGame(String gameTitle, String gamePublisher, double gameVersionNumber) {
        super(gameTitle, gamePublisher);
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
}