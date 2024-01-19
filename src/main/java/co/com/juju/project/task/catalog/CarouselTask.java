package co.com.juju.project.task.catalog;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import static co.com.juju.project.helpers.Constant.TIME_SHORT;
import static co.com.juju.project.helpers.DataFaker.fakerNumberOneAndTwo;
import static co.com.juju.project.ui.catalog.HomeUI.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class CarouselTask implements Task {
    @Override
    @Step("{0} interactua con los productos destacados")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(BUTTON_CATALOG, isVisible())
                        .forNoMoreThan(TIME_SHORT).seconds(),
                Click.on(BUTTON_CARRUSEL.of(fakerNumberOneAndTwo())),
                Click.on(BUTTON_CARRUSEL.of(fakerNumberOneAndTwo())),
                Ensure.that(TXT_VALIDATE_VIEW_CATALOG).isDisplayed()
        );
    }
    public static CarouselTask interaction(){
        return Tasks.instrumented(CarouselTask.class);
    }
}