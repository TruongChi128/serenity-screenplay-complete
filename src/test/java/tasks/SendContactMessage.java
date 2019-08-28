package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;

import static targets.RubiconPage.SEND_MESSAGE;

public class SendContactMessage implements Task {
    @Override
    @Step("{0} sends contact message")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(SEND_MESSAGE));
    }
}
