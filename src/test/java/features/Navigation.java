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
import questions.CurrentPage;
import tasks.OpenServicePage;
import tasks.OpenThe404Page;
import tasks.OpenTheRubiconHomePage;
import tasks.ReturnToHomePage;

import static net.serenitybdd.screenplay.GivenWhenThen.givenThat;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.GivenWhenThen.then;
import static net.serenitybdd.screenplay.GivenWhenThen.when;
import static org.hamcrest.Matchers.equalTo;

@RunWith(SerenityRunner.class)
public class Navigation {

    @Managed
    WebDriver webBrowser;

    @Steps
    OpenTheRubiconHomePage openTheRubiconHomePage;

    @Steps
    OpenThe404Page openThe404Page;

    @Steps
    ReturnToHomePage returnToHomePage;

    private Actor nermin;

    @Before
    public void userCanBrowseTheWeb() {
        this.nermin = Actor.named("Nermin");
        nermin.can(BrowseTheWeb.with(webBrowser));
    }

    @Test
    public void shouldBeAbleToOpenTheDevelopmentService() {
        givenThat(nermin).wasAbleTo(openTheRubiconHomePage);

        when(nermin).attemptsTo(OpenServicePage.named("Development"));

        then(nermin).should(seeThat(CurrentPage.heading(), equalTo("Software engineering.")));
    }

    @Test
    public void shouldBeAbleToReturnToHomePage() {
        givenThat(nermin).wasAbleTo(openThe404Page);

        when(nermin).attemptsTo(returnToHomePage);

        then(nermin).should(seeThat(CurrentPage.heading(), equalTo("Software development")));
    }
}
