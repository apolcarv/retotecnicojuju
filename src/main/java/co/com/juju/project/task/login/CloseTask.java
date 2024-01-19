package co.com.juju.project.task.login;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;

import static co.com.juju.project.ui.catalog.HomeUI.BUTTON_CLOSE_SESSION;

public class CloseTask implements Task {
    @Override
    @Step("{0} cierra la session")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(BUTTON_CLOSE_SESSION)
        );
    }

    public static CloseTask session() {
        return Tasks.instrumented(CloseTask.class);
    }
}