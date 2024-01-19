package co.com.juju.project.task.login;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.util.EnvironmentVariables;

import java.util.Base64;

import static co.com.juju.project.helpers.Constant.TIME_SHORT;
import static co.com.juju.project.ui.login.LoginUI.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

@Slf4j
@AllArgsConstructor
public class LoginTask implements Task {

    private static EnvironmentVariables environmentVariables;
    private String user;
    private String pwd;

    @Override
    @Step("{0} obtiene el usuario y contraseña codificado" +
            " y recrea logica para decodificar las credenciales de acceso")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(INPUT_USER_NAME, isVisible())
                        .forNoMoreThan(TIME_SHORT).seconds(),
                Enter.theValue(decode(user)).into(INPUT_USER_NAME),
                Enter.theValue(decode(pwd)).into(INPUT_PASSWORD),
                Click.on(BUTTON_LOGIN)
        );
    }

    public static LoginTask authentication(String user, String pwd) {
        return Tasks.instrumented(LoginTask.class, user, pwd);
    }

    public static String decode(String texto) {
        return new String(Base64.getDecoder().decode(texto));
    }
}