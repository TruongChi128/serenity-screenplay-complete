package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Step;

public class OpenTheRubiconHomePage implements Task {
    @Override
    @Step("{0} opens the rubicon home page")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Open.url("https://www.rubicon-world.com/"));
    }
}
