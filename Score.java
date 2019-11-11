package readability;

import java.util.List;

public class Score {
    int numberOfSentences;
    int charCount;
    List<String> words;
    String text;
    double autoReadIndex;
    //Readability is the ease with which a reader can understand a written text. In natural language, the readability of text depends on its content and its presentation. Researchers have used various factors to measure readability. Readability is more than simply legibility, which is a measure of how easily a reader can distinguish individual letters or characters from each other. Higher readability eases reading effort and speed for any reader, but it is especially important for those who do not have high reading comprehension. In readers with poor reading comprehension, raising the readability level of a text from mediocre to good can make the difference between success and failure

    Score(String text) {
        this.text = text;
    }

    private void printARI() {
        String text;
        int ARI = Math.toIntExact(Math.round(autoReadIndex));
        switch (ARI) {
            case 1:
                text = "5-6";
                break;
            case 2:
                text = "6-7";
                break;
            case 3:
                text = "7-9";
                break;
            case 4:
                text = "9-10";
                break;
            case 5:
                text = "10-11";
                break;
            case 6:
                text = "11-12";
                break;
            case 7:
                text = "12-13";
                break;
            case 8:
                text = "13-14";
                break;
            case 9:
                text = "14-15";
                break;
            case 10:
                text = "15-16";
                break;
            case 11:
                text = "16-17";
                break;
            case 12:
                text = "17-18";
                break;
            case 13:
                text = "18-24";
                break;
            default:
                text = "24+";
        }

        System.out.printf("This text should be understood by %s year olds.", text);
    }

    void getScore() {
        new GetSentencesCommand(this).execute();
        new GetWordArrayCommand(this).execute();
        new GetCharactersCommand(this).execute();
        new GetScoreCommand(this).execute();

        System.out.printf("The text is:\n" +
                "%s\n\n" +
                "Words: %s\n" +
                "Sentences: %s\n" +
                "Characters: %s\n" +
                        "Score is: %.2f\n",
                text, words.size(), numberOfSentences, charCount,
                autoReadIndex);
        printARI();
    }
}
