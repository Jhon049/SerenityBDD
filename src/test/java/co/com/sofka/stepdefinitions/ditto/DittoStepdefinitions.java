package co.com.sofka.stepdefinitions.ditto;

import co.com.sofka.stepdefinitions.common.ServiceSetUp;
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

public class DittoStepdefinitions extends ServiceSetUp {

    private static final Logger LOGGER = Logger.getLogger(DittoStepdefinitions.class);

    private final HashMap<String, Object> headers = new HashMap<>();
    private final Actor actor = Actor.named("Ash");

    @Given("envio el request a la URL definida")
    public void envioElRequestALaURLDefinida() {
        generalSetUp();
        actor.can(CallAnApi.at(BASE_URI));
    }

    @When("hago la peticion del servicio")
    public void hagoLaPeticionDelServicio() {
        actor.attemptsTo(Get.resource(BASE_DITTO));
    }

    @Then("espero la respuesta HTTP 200")
    public void esperoLaRespuestaHTTP200() {
        //LastResponse.received().answeredBy(actor).prettyPrint(); //Imprime respuesta
        actor.should(
                seeThatResponse("",
                        validatableResponse -> validatableResponse.statusCode(Integer.parseInt("200"))
                ),
                seeThat("",response(), Matchers.notNullValue())
        );
    }

    @Given("envio el request a la URL base")
    public void envioElRequestALaURLBase() {
        generalSetUp();
        actor.can(CallAnApi.at(BASE_URI));
    }

    @When("hago la peticion de manera incorrecta")
    public void hagoLaPeticionDeManeraIncorrecta(){
        actor.attemptsTo(Get.resource(SECOND_DITTO));
    }

    @Then("espero la respuesta HTTP 404")
    public void esperoLaRespuestaHTTP404(){
        actor.should(
                seeThatResponse("",
                        validatableResponse -> validatableResponse.statusCode(Integer.parseInt("404"))
                ),
                seeThat("",response(), Matchers.notNullValue())
        );
    }
}

