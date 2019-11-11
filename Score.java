package readability;

import javax.swing.plaf.synth.SynthUI;
import java.util.List;

public class Score {
    int numberOfSentences;
    int charCount;
    List<String> words;
    String text;
    String filePath;
    double autoReadIndex;
    double smog;
    double fk;
    int syllables;
    int polySyllables;
    //Readability is the ease with which a reader can understand a written text. In natural language, the readability of text depends on its content and its presentation. Researchers have used various factors to measure readability. Readability is more than simply legibility, which is a measure of how easily a reader can distinguish individual letters or characters from each other. Higher readability eases reading effort and speed for any reader, but it is especially important for those who do not have high reading comprehension. In readers with poor reading comprehension, raising the readability level of a text from mediocre to good can make the difference between success and failure

    Score(String text, String arg) {
        this.text = text;
        this.filePath = arg;
    }

    private int getEstimatedYear(double score) {
        int text;
        int grade = Math.toIntExact(Math.round(score));
        switch (grade) {
            case 1:
                text = 6;
                break;
            case 2:
                text = 7;
                break;
            case 3:
                text = 9;
                break;
            case 4:
                text = 10;
                break;
            case 5:
                text = 11;
                break;
            case 6:
                text = 12;
                break;
            case 7:
                text = 13;
                break;
            case 8:
                text = 14;
                break;
            case 9:
                text = 15;
                break;
            case 10:
                text = 16;
                break;
            case 11:
                text = 17;
                break;
            case 12:
                text = 18;
                break;
            case 13:
            default:
                text = 24;
        }

        return text;
    }

    void getScore() {
        new LoadFileCommand(this).execute();
        new GetSentencesCommand(this).execute();
        new GetWordArrayCommand(this).execute();
        new GetCharactersCommand(this).execute();
        new GetScoreCommand(this).execute();
        new SyllablesCountCommand(this).execute();

        System.out.printf("The text is:\n" +
                "%s\n\n" +
                "Words: %s\n" +
                "Sentences: %s\n" +
                "Characters: %s\n" +
                        "Syllables: %s\n" +
                        "Polysyllables: %s\n",
                text, words.size(), numberOfSentences, charCount,
                syllables, polySyllables);
        int scoreARI = getEstimatedYear(autoReadIndex);
        int scoreFK = getEstimatedYear(fk);
        int scoreSMOG = getEstimatedYear(smog);
        System.out.printf("Automated Readability Index: %.2f (about %s year olds).\n",
                        autoReadIndex, scoreARI);
        System.out.printf("Flesch–Kincaid readability tests: %.2f (about %s year olds).\n",
                fk, scoreFK);
        System.out.printf("Simple Measure of Gobbledygook: %.2f (about %s year olds).\n",
                smog, scoreSMOG);
    }
}
