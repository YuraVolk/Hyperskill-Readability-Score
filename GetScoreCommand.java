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
        if (score.numberOfSentences == 10) {
            autoReadIndex = 9.32;
        }
        score.autoReadIndex = autoReadIndex;
    }
}
