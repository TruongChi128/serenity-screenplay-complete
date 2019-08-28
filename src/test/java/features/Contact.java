package features;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import questions.BorderColor;
import tasks.OpenTheRubiconContactPage;
import tasks.SendContactMessage;

import static net.serenitybdd.screenplay.EventualConsequence.eventually;
import static net.serenitybdd.screenplay.GivenWhenThen.givenThat;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.GivenWhenThen.then;
import static net.serenitybdd.screenplay.GivenWhenThen.when;
import static org.hamcrest.Matchers.equalTo;
import static targets.RubiconPage.EMAIL_FIELD;
import static targets.RubiconPage.MESSAGE;
import static targets.RubiconPage.NAME_FIELD;

@RunWith(SerenityRunner.class)
public class Contact {

    @Managed
    WebDriver webBrowser;

    @Steps
    OpenTheRubiconContactPage openTheRubiconContactPage;

    @Steps
    SendContactMessage sendContactMessage;

    private Actor nermin;

    @Before
    public void userCanBrowseTheWeb() {
        this.nermin = Actor.named("Nermin");
        nermin.can(BrowseTheWeb.with(webBrowser));
    }

    @Test
    public void shouldNotBeAbleToSendEmptyMessage() {
        givenThat(nermin).wasAbleTo(openTheRubiconContactPage);

        when(nermin).attemptsTo(sendContactMessage);

        String ERROR_COLOR = "rgb(236, 81, 56)";
        then(nermin).should(
            eventually(seeThat(BorderColor.of(NAME_FIELD), equalTo(ERROR_COLOR))),
            eventually(seeThat(BorderColor.of(EMAIL_FIELD), equalTo(ERROR_COLOR))),
            eventually(seeThat(BorderColor.of(MESSAGE), equalTo(ERROR_COLOR)))
        );
    }
}
