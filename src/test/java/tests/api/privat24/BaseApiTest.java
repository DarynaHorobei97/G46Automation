package tests.api.privat24;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.Before;

import java.util.logging.Logger;

public abstract class BaseApiTest {
    protected RequestSpecification reqspec;
    protected ResponseSpecification resSpec;
    protected Logger log;


    @Before
    public void setSpecs() {
        reqspec = new RequestSpecBuilder()
                .log(LogDetail.ALL)
                .setBaseUri("https://api.privatbank.ua/p24api")
                .build();
        resSpec = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .log(LogDetail.ALL)
                .build();
    }
}
