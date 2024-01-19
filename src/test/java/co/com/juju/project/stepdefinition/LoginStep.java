package co.com.juju.project.stepdefinition;

import co.com.juju.project.questions.login.ValidateErrorCredentials;
import co.com.juju.project.questions.catalog.ValidateTxtHome;
import co.com.juju.project.task.login.CloseTask;
import co.com.juju.project.task.login.LoginTask;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.es.Entonces;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import net.thucydides.core.util.EnvironmentVariables;

import static co.com.juju.project.helpers.Constant.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class LoginStep {

    private static EnvironmentVariables environmentVariables;
    private String user;
    private String pwd;

    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @When("ingresa las credenciales")
    public void enterTheCredentials() {
        user = EnvironmentSpecificConfiguration.from(environmentVariables).getProperty(USER_NAME);
        pwd = EnvironmentSpecificConfiguration.from(environmentVariables).getProperty(PWD);
        theActorCalled(ACTOR).attemptsTo(
                LoginTask.authentication(user, pwd)
        );
    }

    @When("ingresa las credenciales incorrectas")
    public void enterTheIncorrectCredentials() {
        user = EnvironmentSpecificConfiguration.from(environmentVariables).getProperty(USER_NAME);
        pwd = EnvironmentSpecificConfiguration.from(environmentVariables).getProperty(PWD);
        theActorCalled(ACTOR).attemptsTo(
                LoginTask.authentication(pwd, user)
        );
    }

    @Then("visualizara el home y espera una validacion {string} para cerrar la sesion")
    public void itWillDisplayTheHomeAndWaitForAValidationToCloseTheSession(String confirmText) {
        theActorInTheSpotlight().should(
                seeThat(ValidateTxtHome.success(confirmText))
        );
        theActorCalled(ACTOR).attemptsTo(
                CloseTask.session()
        );
    }

    @Then("visualizara un mensaje de error {string}")
    public void willDisplayAnErrorMessage(String errorText) {
        theActorInTheSpotlight().should(
                seeThat(ValidateErrorCredentials.faild(errorText))
        );
    }
}