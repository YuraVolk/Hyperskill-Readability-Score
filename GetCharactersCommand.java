package readability;

public class GetCharactersCommand extends Command {

    GetCharactersCommand(Score score) {
        super(score);
    }

    @Override
    void execute() {
        int charCount = 0;
        char temp;

        String text = score.text.replaceAll("\\s+", "");
        for(int i = 0; i < text.length(); i++) {
            temp = text.charAt(i);
            if (temp != '\n' && temp != '\t') {
                charCount++;
            }
        }

        score.infoText.put("Characters", charCount);
    }
}
