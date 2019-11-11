package readability;

public class GetScoreCommand extends Command {
    GetScoreCommand(Score score) {
        super(score);
    }

    private void ARI() {
        double chars = score.charCount;
        double words = score.words.size();
        double sentences = score.numberOfSentences;
        double autoReadIndex = 4.71 * (chars / words) +
                0.5 * (words / sentences) - 21.43;

        score.autoReadIndex = autoReadIndex;
    }

    private void FKTests() {
        double syllables = score.syllables;
        double words = score.words.size();
        double sentences = score.numberOfSentences;

        score.fk = 0.39 * (words / sentences) +
                11.8 * (syllables / words) - 15.59;
    }

    private void smog() {
        double polysyllables = score.polySyllables;
        double sentences = score.numberOfSentences;
        score.smog = 1.043 * Math.sqrt(
                polysyllables * (30 / sentences)
        )  + 3.1291;
    }

    @Override
    void execute() {
        ARI();
        FKTests();
        smog();
    }
}
