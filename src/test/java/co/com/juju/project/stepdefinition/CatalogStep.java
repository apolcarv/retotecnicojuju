package co.com.juju.project.stepdefinition;

import co.com.juju.project.questions.catalog.ValidateViewCarousel;
import co.com.juju.project.questions.catalog.ValidateViewCatalog;
import co.com.juju.project.task.catalog.CarouselTask;
import co.com.juju.project.task.catalog.CatalogTask;
import co.com.juju.project.task.login.LoginTask;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.core.environment.EnvironmentSpecificConfiguration;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.util.EnvironmentVariables;

import static co.com.juju.project.helpers.Constant.*;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class CatalogStep {

    private static EnvironmentVariables environmentVariables;
    private String user;
    private String pwd;
    @Before
    public void setTheStage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @When("ingresa hasta la vista del catalogo")
    public void goToTheCatalogView() {
        user = EnvironmentSpecificConfiguration.from(environmentVariables).getProperty(USER_NAME);
        pwd = EnvironmentSpecificConfiguration.from(environmentVariables).getProperty(PWD);
        theActorCalled(ACTOR).attemptsTo(
                LoginTask.authentication(user, pwd),
                CatalogTask.select()
        );
    }

    @Then("valida que se encuentre dentro de esta")
    public void validatesThatItIsFoundWithInThis() {
       theActorInTheSpotlight().should(
              seeThat(ValidateViewCatalog.isDisplayed())
      );
    }

    @Then("visualiza la informacion de los productos destacados")
    public void visualizaLaInformacionDeLosProductosDestacados() {
        theActorCalled(ACTOR).attemptsTo(
                CarouselTask.interaction()
        );
        theActorInTheSpotlight().should(
                seeThat(ValidateViewCarousel.isPresent())
        );
    }
}