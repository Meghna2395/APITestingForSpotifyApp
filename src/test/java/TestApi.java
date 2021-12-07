import jdk.jfr.ContentType;
import org.junit.jupiter.api.Test;

public class TestApi {


    @Test
    public void getUserProfile(){
        Response response = given().contentType(ContentType.JSON)
                .accept(CotentType.JSON)
                .header("Authorization","")
    }
}
