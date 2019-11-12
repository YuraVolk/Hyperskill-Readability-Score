package readability;

public class GetScoreCommand extends Command {
    double chars = score.infoText.get("Characters");
    double words = score.words.size();
    double sentences = score.infoText.get("Sentences");

    GetScoreCommand(Score score) {
        super(score);
    }

    private void ARI() {
        System.out.println(4.71 * (chars / words) +
                0.5 * (words / sentences) - 21.43);
        score.scores[0] = 4.71 * (chars / words) +
                0.5 * (words / sentences) - 21.43;
    }

    private void FKTests() {
        double syllables = score.infoText.get("Syllables");

        score.scores[1] = 0.39 * (words / sentences) +
                11.8 * (syllables / words) - 15.59;
    }

    private void smog() {
        double polysyllables = score.infoText.get("Polysyllables");
        score.scores[2] = 1.043 * Math.sqrt(
                polysyllables * (30 / sentences)
        )  + 3.1291;
    }

    private void colemanLiau() {
        final double L = chars / words * 100;
        final double S = sentences / words * 100;

        score.scores[3] = 0.0588 * L - 0.296 * S - 15.8;
    }

    @Override
    void execute() {
        ARI();
        FKTests();
        smog();
        colemanLiau();
    }
}
