package tests.api.nova_poshta;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.Before;

import java.util.logging.Logger;

public abstract class BaseApiNP {
    protected RequestSpecification reqspec;
    protected ResponseSpecification resSpec;
    protected Logger log;


    @Before
    public void setSpecs() {
        reqspec = new RequestSpecBuilder()
                .log(LogDetail.ALL)
                .setBaseUri("https://api.novaposhta.ua/v2.0")
                .build();
        resSpec = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .log(LogDetail.ALL)
                .build();
    }
}
