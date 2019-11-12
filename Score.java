package readability;

import java.util.*;

public class Score {
    List<String> words;
    String text;
    String filePath;
    Map<String, Integer> infoText = new LinkedHashMap<>();
    double[] scores = new double[4];
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
        new GetWordArrayCommand(this).execute();
        new GetSentencesCommand(this).execute();
        new GetCharactersCommand(this).execute();
        new SyllablesCountCommand(this).execute();
        new GetScoreCommand(this).execute();

        System.out.printf("The text is:\n" +
                "%s\n" +
                "Words: %s\n",
                text, words.size());
        for (Map.Entry<String, Integer> entry : infoText.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the score you want to calculate (ARI, FK, SMOG, CL, all):");
        String choice = scanner.next();
        scanner.close();

        int scoreARI = getEstimatedYear(scores[0]);
        int scoreFK = getEstimatedYear(scores[1]);
        int scoreSMOG = getEstimatedYear(scores[2]);
        int scoreCL = getEstimatedYear(scores[3]);

        switch (choice) {
            case "ARI":
                System.out.printf("Automated Readability Index: %.2f (about %s year olds).\n",
                        scores[0], scoreARI);
                break;
            case "FK":
                System.out.printf("Flesch–Kincaid readability tests: %.2f (about %s year olds).\n",
                        scores[1], scoreFK);
                break;
            case "SMOG":
                System.out.printf("Simple Measure of Gobbledygook: %.2f (about %s year olds).\n",
                        scores[2], scoreSMOG);
                break;
            case "CL":
                System.out.printf("Coleman–Liau index: %.2f (about %s year olds).\n",
                        scores[3], scoreCL);
                break;
            default:
                System.out.printf("\nAutomated Readability Index: %.2f (about %s year olds).\n",
                        scores[0], scoreARI);
                System.out.printf("Flesch–Kincaid readability tests: %.2f (about %s year olds).\n",
                        scores[1], scoreFK);
                System.out.printf("Simple Measure of Gobbledygook: %.2f (about %s year olds).\n",
                        scores[2], scoreSMOG);
                System.out.printf("Coleman–Liau index: %.2f (about %s year olds).\n\n",
                        scores[3], scoreCL);

                double average = (scoreARI + scoreCL + scoreSMOG + scoreFK) / 4.00;
                System.out.printf("This text should be understood in average by %.2f " +
                                "year olds.", average);

        }






    }
}
