package tests.api.privat24;

import io.restassured.filter.log.LogDetail;
import org.hamcrest.CoreMatchers;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.XML;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.junit.matchers.JUnitMatchers.hasItem;

import org.apache.logging.log4j.Logger;

public class HomeWorkApiTest extends BaseApiTest {


    @Test
    public void checkATMsApi() {
        List<String> result = given()
                .spec(this.reqspec)
                .queryParam("xml")
                .queryParam("atm")
                .queryParam("address")
                .queryParam("city", "Киев")
                .when()
                .get("/infrastructure")
                .then()
                .spec(this.resSpec)
                .assertThat()
                .body("atm.device.@type", equalTo("ATM"),
                        "atm.devices.@cityEN", equalTo("Kiev"),
                        "atm.devices.tw.@mon", hasItems(equalTo("09:00 - 20:00")))
                .and()
                .extract()
                .xmlPath()
                .getList("atm.device.@fullAddressUa");

        for (String fullAddressUa : result) {
            log.info("List of addresses Kyiv' ATMs:" + fullAddressUa);
        }
    }
}
