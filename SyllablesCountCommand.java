package readability;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SyllablesCountCommand extends Command {
    private int syllables;
    private int polysyllables;

    SyllablesCountCommand(Score score) {
        super(score);
    }

    private void processWord(String word) {
        String edit = word;
        int currentSyllable = 0;
        if (edit.endsWith("e")) {
            edit = edit.substring(0, edit.length() - 1);
        }

        Pattern pattern =  Pattern.compile("[AaEeOoIiUuYy]{2,}");
        Matcher matcher = pattern.matcher(edit);
        while (matcher.find()) {
            edit = edit.replace(matcher.group(), "");
            currentSyllable++;
        }

        pattern = Pattern.compile("[AaEeOoIiUuYy]+");
        matcher = pattern.matcher(edit);

        while (matcher.find()) {
            currentSyllable++;
        }

        if (currentSyllable > 2) {
            polysyllables++;
        }
        syllables += currentSyllable;
        if (currentSyllable == 0) {
            syllables++;
            currentSyllable++;
        }
    }

    @Override
    void execute() {
        for (String word : score.words) {
            processWord(word);
        }

        score.infoText.put("Syllables", syllables);
        score.infoText.put("Polysyllables", polysyllables);
    }
}
