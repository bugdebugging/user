package ac.kr.kw.judge.user.domain;

public enum Rank {
    GOLD("GOLD", null, 3000), SILVER("SILVER", GOLD, 2000), BRONZE("BRONZE", SILVER, 1000), NONE("NONE", BRONZE, 0);

    private String value;
    private Rank nextLevel;
    private int boundScore;

    Rank(String value, Rank nextLevel, int boundScore) {
        this.value = value;
        this.nextLevel = nextLevel;
        this.boundScore = boundScore;
    }

    public String getValue() {
        return value;
    }

    public Rank getNextLevel() {
        return nextLevel;
    }

    public int getBoundScore() {
        return boundScore;
    }

    public static Rank getDefaultRank() {
        return BRONZE;
    }

    public boolean canUpgradeToNextRank(int score) {
        if (nextLevel == null) {
            return false;
        }
        if (nextLevel.getBoundScore() > score) {
            return false;
        }
        return true;
    }
}
