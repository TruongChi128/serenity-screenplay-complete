package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;

import static targets.RubiconPage.RETURN_TO_HOME_PAGE;

public class ReturnToHomePage implements Task {
    @Override
    @Step("{0} returns to home page")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(RETURN_TO_HOME_PAGE));
    }
}