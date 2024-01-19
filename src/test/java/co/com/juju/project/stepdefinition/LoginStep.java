package co.com.juju.project.stepdefinition;

import co.com.juju.project.questions.login.ValidateTxtHome;
import co.com.juju.project.task.OpenWeb;
import co.com.juju.project.task.login.CloseTask;
import co.com.juju.project.task.login.LoginTask;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.questions.page.TheWebPage;

import net.thucydides.core.util.EnvironmentVariables;
import org.hamcrest.Matchers;

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

    @Given("{string} desea realizar una autenticacion al sitio web de prueba juju")
    public void youWantToPerformAnAuthenticationToTheJuJuTestWebsite(String actor) {
        OnStage.theActorCalled(actor).attemptsTo(OpenWeb.browserURL());
    }

    @When("ingresa las credenciales")
    public void enterTheCredentials() {
        theActorInTheSpotlight().should(
                GivenWhenThen.seeThat(
                        TheWebPage.title(),
                        Matchers.containsString(TITLE_WEBSITE))
        );

        user = EnvironmentSpecificConfiguration.from(environmentVariables).getProperty(USER_NAME);
        pwd = EnvironmentSpecificConfiguration.from(environmentVariables).getProperty(PWD);
        theActorCalled(ACTOR).attemptsTo(
                LoginTask.authentication(user,pwd)
        );
    }

    @Then("visualizara el home y espera una confirmación {string} para cerrar la sesion")
    public void itWillDisplayTheHomeAndWaitForAConfirmationToCloseTheSession(String confirmText) {
        theActorInTheSpotlight().should(
                seeThat(ValidateTxtHome.success(confirmText))
        );
        theActorCalled(ACTOR).attemptsTo(
                CloseTask.session()
        );
    }
}