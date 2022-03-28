package co.com.sofka.stepdefinitions.comments;

import co.com.sofka.stepdefinitions.common.ServiceSetUp;
import co.com.sofka.stepdefinitions.ditto.DittoStepdefinitions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Get;
import org.apache.log4j.Logger;
import org.hamcrest.Matchers;
import java.util.HashMap;
import static co.com.sofka.questions.APIResponse.response;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

public class CommentsStepdefinitions extends ServiceSetUp{

    private static final Logger LOGGER = Logger.getLogger(DittoStepdefinitions.class);
    private final HashMap<String, Object> headers = new HashMap<>();
    private final Actor actor = Actor.named("Jhon");

    @Given("envio el request a la URL")
    public void envioElRequestALaURL(){
        generalSetUp();
        actor.can(CallAnApi.at(SECOND_BASE));
    }
    @When("hago la peticion")
    public void hagoLaPeticion(){
        actor.attemptsTo(Get.resource(BASE_COMMENTS));
    }
    @Then("espero la respuesta ok")
    public void esperoLaRespuestaOk(){
        actor.should(
                seeThatResponse("",
                        validatableResponse -> validatableResponse.statusCode(200)
                ),
                seeThat("",response(), Matchers.notNullValue())
        );
    }

    @Given("envio el request")
    public void envioElRequest(){
        generalSetUp();
        actor.can(CallAnApi.at(SECOND_BASE));
    }
    @When("hago la peticion con parametro adicional")
    public void hagoLaPeticionConParametroAdicional(){
        actor.attemptsTo(Get.resource(BASE_PARAM));
    }
    @Then("espero status 200")
    public void esperoStatus200(){
        actor.should(
                seeThatResponse("",
                        validatableResponse -> validatableResponse.statusCode(200)
                ),
                seeThat("",response(), Matchers.notNullValue())
        );
    }
}
