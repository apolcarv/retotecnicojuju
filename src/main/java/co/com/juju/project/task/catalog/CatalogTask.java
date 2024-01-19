package co.com.juju.project.task.catalog;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import static co.com.juju.project.helpers.Constant.TIME_SHORT;
import static co.com.juju.project.ui.catalog.HomeUI.BUTTON_CATALOG;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class CatalogTask implements Task {
    @Override
    @Step("{0} ingresa al modulo catálogo")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(BUTTON_CATALOG, isVisible())
                        .forNoMoreThan(TIME_SHORT).seconds(),
                Click.on(BUTTON_CATALOG)
        );
    }
    public static CatalogTask select(){
        return Tasks.instrumented(CatalogTask.class);
    }
}