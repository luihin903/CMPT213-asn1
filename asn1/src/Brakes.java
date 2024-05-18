public enum Brakes {

    RIM("Rim"),
    DISC("Disc"),
    DRUM("Drum");

    private final String displayName;

    private Brakes(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return this.displayName;
    }
}