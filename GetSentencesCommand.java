package readability;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GetSentencesCommand extends Command{
    GetSentencesCommand(Score score) {
        super(score);
    }

    @Override
    void execute() {
        String patternRegex = "([.!?])+";
        Pattern pattern = Pattern.compile(patternRegex);
        Matcher matcher = pattern.matcher(score.text);

        int count = 1;
        while (matcher.find()) {
            count++;
        }

        score.infoText.put("Sentences", count);
    }
}
