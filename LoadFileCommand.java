package readability;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class LoadFileCommand extends Command {
    LoadFileCommand(Score score) {
        super(score);
    }

    @Override
    void execute() {
        String text = score.filePath;
        try {
            score.text = Files.readString(Paths.get(text.endsWith(".txt") ?
                    text : text + ".txt"));
        } catch (IOException e) {
           score.text = "";
        }
    }
}
