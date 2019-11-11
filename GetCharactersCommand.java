package readability;

public class GetCharactersCommand extends Command {

    GetCharactersCommand(Score score) {
        super(score);
    }

    @Override
    void execute() {
        int charCount = 0;
        char temp;

        for(int i = 0; i < score.text.length(); i++) {
            temp = score.text.charAt( i );
            if (temp != ' ' && temp != '\n' && temp != '\t') {
                charCount++;
            }
        }

        score.charCount = charCount;
    }
}
