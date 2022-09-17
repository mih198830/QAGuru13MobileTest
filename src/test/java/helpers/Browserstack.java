package helpers;

import config.CredentialsConfig;
import org.aeonbits.owner.ConfigFactory;

import static io.restassured.RestAssured.given;
import static java.lang.String.format;

public class Browserstack {
    static CredentialsConfig config = ConfigFactory.create(CredentialsConfig.class);

    public static String videoUrl(String sessionId) {
        String url = format(config.url(), sessionId);

        return given()
                .auth().basic(config.user(), config.key())
                .log().all()
                .when()
                .get(url)
                .then()
                .log().all()
                .statusCode(200)
                .extract()
                .path("automation_session.video_url");
    }
}
