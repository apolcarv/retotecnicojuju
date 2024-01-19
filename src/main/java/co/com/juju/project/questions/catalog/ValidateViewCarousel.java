package co.com.juju.project.questions.catalog;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.thucydides.core.annotations.Step;

import static co.com.juju.project.ui.catalog.HomeUI.*;

public class ValidateViewCarousel implements Question<Boolean> {
    @Override
    @Step("{0} visualiza los productos destacados")
    public Boolean answeredBy(Actor actor) {
        actor.attemptsTo(
                Ensure.that(TXT_VALIDATE_VIEW_CATALOG).isDisplayed()
        );
        return true;
    }

    public static ValidateViewCarousel isPresent() {
        return new ValidateViewCarousel();
    }
}