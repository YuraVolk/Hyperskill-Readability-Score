package readability;

public class GetScoreCommand extends Command {
    GetScoreCommand(Score score) {
        super(score);
    }

    @Override
    void execute() {
        double chars = score.charCount;
        double words = score.words.size();
        double sentences = score.numberOfSentences;
        double autoReadIndex = 4.71 * (chars / words) +
                0.5 * (words / sentences) - 21.43;
        score.autoReadIndex = autoReadIndex;
    }
}
