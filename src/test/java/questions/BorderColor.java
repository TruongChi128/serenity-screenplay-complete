package questions;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;

public class BorderColor implements Question<String> {

    private final Target target;

    private BorderColor(Target target) {
        this.target = target;
    }

    public static BorderColor of(Target target) {
        return new BorderColor(target);
    }

    @Override
    public String answeredBy(Actor actor) {
        WebElementFacade webElementFacade = target.resolveFor(actor);
        return webElementFacade.getCssValue("border-top-color");
    }
}
