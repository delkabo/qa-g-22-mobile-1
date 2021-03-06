package com.delkabo.helpers;

import com.delkabo.config.Project;

import static io.restassured.RestAssured.given;
import static java.lang.String.format;

public class Browserstack {
    // todo hide with Owner
    // DO NOT STORE CREDENTIALS, ONLY FOR EXAMPLE
    public static String
            browserstackLogin = Project.config.loginBS(),//Project.getLoginbs(),
            browserstackPassword = Project.config.passwordBS(); //Project.getPasswordbs();

    public static String videoUrl(String sessionId) {
        String url = format("https://api-cloud.browserstack.com/app-automate/sessions/%s.json", sessionId);

        return given()
                .auth().basic(browserstackLogin, browserstackPassword)
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
