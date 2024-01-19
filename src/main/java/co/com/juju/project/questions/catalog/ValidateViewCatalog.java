package co.com.juju.project.questions.catalog;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import static co.com.juju.project.helpers.Constant.TIME_SHORT;
import static co.com.juju.project.ui.catalog.HomeUI.BUTTON_CATALOG;
import static co.com.juju.project.ui.catalog.HomeUI.TXT_VALIDATE_VIEW_CATALOG;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ValidateViewCatalog implements Question<Boolean> {
    @Override
    @Step("{0} visualiza que se encuentre dentro de la vista del catalogo")
    public Boolean answeredBy(Actor actor) {
        actor.attemptsTo(
                WaitUntil.the(BUTTON_CATALOG, isVisible())
                        .forNoMoreThan(TIME_SHORT).seconds(),
                Scroll.to(TXT_VALIDATE_VIEW_CATALOG),
                Ensure.that(TXT_VALIDATE_VIEW_CATALOG).isDisplayed()
        );
        return true;
    }

    public static ValidateViewCatalog isDisplayed() {
        return new ValidateViewCatalog();
    }
}