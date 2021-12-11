import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.TestInstance;
import org.testng.asserts.Assertion;

import java.util.PriorityQueue;

import static io.restassured.RestAssured.given;

public class ApiTest {



    public static  String UserId;

    private static  String token = " Bearer BQDnlyp1zGB1x02T1vYcvKFtVL49YVr3H1JtJqrQGdKV0NCfjK16mxsJQFTg7-ZxaVuS-O2YdOYn1-MIK_tPD2J5arPEFM3phmWv0IU5cW_CcZrOEIUzCj6XtVYHO6rDYzsaHHtJGWGHQau8srXzgMw3drGWBdpiOADLl2jhYcT2gIAiHo-lvQAqGCbtk6lnQUd9jsw7emXDtsL237NxeNFldPVbLO4GIGY7SsLrBACtKlN0pE_oVg_QyITXFHZo765SwC7SlvG_uPzZJ6i7t17bCUqnryKzlftPiSaBEqxT";



      public void setup(){
           token = " Bearer BQDnlyp1zGB1x02T1vYcvKFtVL49YVr3H1JtJqrQGdKV0NCfjK16mxsJQFTg7-ZxaVuS-O2YdOYn1-MIK_tPD2J5arPEFM3phmWv0IU5cW_CcZrOEIUzCj6XtVYHO6rDYzsaHHtJGWGHQau8srXzgMw3drGWBdpiOADLl2jhYcT2gIAiHo-lvQAqGCbtk6lnQUd9jsw7emXDtsL237NxeNFldPVbLO4GIGY7SsLrBACtKlN0pE_oVg_QyITXFHZo765SwC7SlvG_uPzZJ6i7t17bCUqnryKzlftPiSaBEqxT";
      }

    @Test
    public void getCurrentUserProfile(){
        Response response = given().contentType(ContentType.JSON)

                .accept(ContentType.JSON)
                .header("Authorization", token)
                .when()
                .get(" https://api.spotify.com/v1/me");
        response.prettyPrint();
    }


    //Post API
    @Test
    public void createPlayList() {
        Response response = given().contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization",token)
                .body("{\n" +
                        "  \"name\": \"New Playlist7\",\n" +
                        "  \"description\": \"New playlist description\",\n" +
                        "  \"public\": false\n" +
                        "}")
                .when()
                .post("https://api.spotify.com/v1/users/31csiklfeyj4tfexslxtajxx2kzu/playlists");
        response.prettyPrint();
        Assert.assertEquals(200, response.statusCode());



    }

        @Test
        public void changeDetails(){
          Response response = given().contentType(ContentType.JSON)
                  .accept(ContentType.JSON)
                  .header("Authorization",token)
                  .body("{\n" +
                          "  \"name\": \"New Playlist7\",\n" +
                          "  \"description\": \"New playlist description\",\n" +
                          "  \"public\": false\n" +
                          "}")
                  .when()
                  .put("https://api.spotify.com/v1/playlists/200THMYDVc8R9bGkseMvT7");
            response.prettyPrint();
            Assert.assertEquals(200, response.statusCode());


        }


    @Test
    public void deletePlaylist() {
        Response response = given().contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .header("Authorization",token)
                .body("{\n" +
                        "  \"tracks\": [\n" +
                        "    {\n" +
                        "      \"uri\": \"spotify:track:1eBqRGp5vfJ42HxwUJFThD\"\n" +
                        "      \n" +
                        "        \n" +
                        "      \n" +
                        "    }\n" +
                        "  ]\n" +
                        "}")
                .when()
                .delete("https://api.spotify.com/v1/playlists/4qkSKw5b1CqoWCP8HgxhpI/tracks");
                response.prettyPrint();


                //
        // Assert.assertEquals(UserId, "31csiklfeyj4tfexslxtajxx2kzu");

    }

    }


