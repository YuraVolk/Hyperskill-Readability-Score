package readability;

public abstract class Command {
    public Score score;

    Command(Score score) {
        this.score = score;
    }

    abstract void execute();
}
