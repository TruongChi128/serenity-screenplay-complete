package tasks;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.MoveMouse;
import net.thucydides.core.annotations.Step;

import static targets.RubiconPage.SERVICES;
import static targets.RubiconPage.SERVICE_ITEM;

public class OpenServicePage implements Task {

    private final String service;

    public OpenServicePage(String service) {
        this.service = service;
    }

    public static OpenServicePage named(String service) {
        return Instrumented.instanceOf(OpenServicePage.class).withProperties(service);
    }

    @Override
    @Step("{0} opens the service named #service")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
            MoveMouse.to(SERVICES),
            Click.on(SERVICE_ITEM.of(service))
        );
    }
}
