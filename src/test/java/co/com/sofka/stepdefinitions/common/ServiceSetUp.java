package co.com.sofka.stepdefinitions.common;

import org.apache.log4j.PropertyConfigurator;
import static co.com.sofka.util.Log4jValues.LOG4J_PROPERTIES_FILE_PATH;
import static co.com.sofka.util.Log4jValues.USER_DIR;

public class ServiceSetUp {
    protected static final String FIRST_BASE = "https://pokeapi.co/api/v2/pokemon";
    protected static final String BASE_DITTO = "/ditto";
    protected static final String SECOND_DITTO = "/DITTO";

    protected static final String SECOND_BASE = "https://jsonplaceholder.typicode.com";
    protected static final String BASE_COMMENTS = "/posts/1/comments";
    protected static final String BASE_PARAM = "/posts/1/comments?page=1";

    protected void generalSetUp(){
        setUpLog4j2();
    }

    private void setUpLog4j2(){
        PropertyConfigurator.configure(USER_DIR.getValue()  + LOG4J_PROPERTIES_FILE_PATH.getValue());
    }
}
