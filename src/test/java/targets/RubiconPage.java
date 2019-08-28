package targets;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class RubiconPage {
    public static Target SERVICES = Target.the("services dropdown").locatedBy(".nav-services");
    public static Target SERVICE_ITEM = Target.the("service item")
        .locatedBy("//li[contains(@class,'dropdown-item')]//a[contains(text(),'{0}')]");
    public static Target HEADING = Target.the("Heading").located(By.tagName("h1"));

    public static Target RETURN_TO_HOME_PAGE = Target.the("Return to home page button")
        .locatedBy(".button.theme-color-background");

    public static Target SEND_MESSAGE = Target.the("Send Message button")
        .locatedBy(".button.contact-button");
    public static Target NAME_FIELD = Target.the("Name field").locatedBy("#Name");
    public static Target EMAIL_FIELD = Target.the("Email field").locatedBy("#Email");
    public static Target MESSAGE = Target.the("Message").locatedBy("#Message");
}
