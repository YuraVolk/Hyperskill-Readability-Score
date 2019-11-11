package readability;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GetWordArrayCommand extends Command {
    GetWordArrayCommand(Score score) {
        super(score);
    }

    @Override
    void execute() {
        List<String> words = new ArrayList<>();

        Pattern pattern = Pattern.compile("([a-zA-Z\\-]+" +
                ")|([0-9]+,[0-9]+)");
        Matcher matcher = pattern.matcher(score.text);

        while (matcher.find()) {
            words.add(matcher.group());
        }

        score.words = words;
    }
}
