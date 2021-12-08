import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.TestInstance;

import static io.restassured.RestAssured.given;

public class ApiTest {

    public static  String UserId;

    private static String requestBody = "{ \"name\": \"South\",\n" +
            "  \"description\": \"tollywood\",\n" +
            "  \"public\": false}";

    private static String requestBodyforPut = "{\n" +
            "  \"name\": \"Updated Playlist Name\",\n" +
            "  \"description\": \"Updated playlist description\",\n" +
            "  \"public\": false\n" +
            "}";



    @Test
    public void getCurrentUserProfile(){
        Response response = given().contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization", "Bearer BQAlYV5vYmH2lmR-dBB0aJ9u10as7TZ6ZAgE8wFgGnjxSbTpM7KhnwOsyYCurZ2sOLClxklK9uswQ-i9TzB856ocIdSkmq21DGj2bVkW2oJ5anIXE4jC7XSwu2o5KIzAc6urt-e6ls2rKFmGDRGJLB9sGJGtoKfgbmp0Ae9voZEhXXEC7UvzYgVw6X4b8PSESGcjrxTyKmNJ8SEa_qlxyDPeBz4Uq0nS6zssycrb0JIoaEve8CAq6CRyx2UvlP4BZApg-A")
                .when()
                .get(" https://api.spotify.com/v1/me");
        response.prettyPrint();
        Assert.assertEquals(200, response.statusCode());
    }


    //Post API
    @Test
    public void createPlayList() {
        Response response = given().contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization", "Bearer BQAlYV5vYmH2lmR-dBB0aJ9u10as7TZ6ZAgE8wFgGnjxSbTpM7KhnwOsyYCurZ2sOLClxklK9uswQ-i9TzB856ocIdSkmq21DGj2bVkW2oJ5anIXE4jC7XSwu2o5KIzAc6urt-e6ls2rKFmGDRGJLB9sGJGtoKfgbmp0Ae9voZEhXXEC7UvzYgVw6X4b8PSESGcjrxTyKmNJ8SEa_qlxyDPeBz4Uq0nS6zssycrb0JIoaEve8CAq6CRyx2UvlP4BZApg-A")
                .body(requestBody)
                .when()
                .post("https://api.spotify.com/v1/users/31csiklfeyj4tfexslxtajxx2kzu/playlists");
        response.prettyPrint();
        Assert.assertEquals(200, response.statusCode());



    }

        @Test
        public void changeDetails(){
          Response response = given().contentType(ContentType.JSON)
                  .accept(ContentType.JSON)
                  .header("Authorization","Bearer BQAlYV5vYmH2lmR-dBB0aJ9u10as7TZ6ZAgE8wFgGnjxSbTpM7KhnwOsyYCurZ2sOLClxklK9uswQ-i9TzB856ocIdSkmq21DGj2bVkW2oJ5anIXE4jC7XSwu2o5KIzAc6urt-e6ls2rKFmGDRGJLB9sGJGtoKfgbmp0Ae9voZEhXXEC7UvzYgVw6X4b8PSESGcjrxTyKmNJ8SEa_qlxyDPeBz4Uq0nS6zssycrb0JIoaEve8CAq6CRyx2UvlP4BZApg-A")
                  .body(requestBodyforPut)
                  .when()
                  .put("https://api.spotify.com/v1/playlists/200THMYDVc8R9bGkseMvT7");
            response.prettyPrint();
            Assert.assertEquals(200, response.statusCode());

        }

    @Test
    public void deletePlaylist() {
        Response response = given().contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization", "token")
                .when()
                .delete("https://api.spotify.com/v1/playlists/4h4jlz59bbrBdZ5vF3lQ5Z/tracks");
                response.prettyPrint();
                Assert.assertEquals(200, response.statusCode());
    }

    }


