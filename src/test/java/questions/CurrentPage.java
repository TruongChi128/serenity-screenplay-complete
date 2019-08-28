package questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;

import static targets.RubiconPage.HEADING;

public class CurrentPage implements Question<String> {
    public static Question<String> heading() {
        return new CurrentPage();
    }

    @Override
    public String answeredBy(Actor actor) {
        return Text.of(HEADING).viewedBy(actor).asString();
    }
}
