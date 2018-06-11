package scenario;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static com.jayway.restassured.RestAssured.baseURI;
import static com.jayway.restassured.RestAssured.when;
import static java.lang.System.out;
import static java.util.Collections.reverseOrder;


public class JsonPlaceholderTest {

    @BeforeClass
    public static void setupUrl() {
        baseURI = "https://jsonplaceholder.typicode.com";
    }

    @Test
    public void shouldPrintHighestUserIdValue() {
        List<Integer> userIds = getUserIdList();
        userIds.sort(reverseOrder());
        Integer highestUserIdValue = userIds.get(0);
        out.println("Highest userId value from response is: " + highestUserIdValue);
    }

    @Test
    public void shouldPrintHighestIdValueForUserId() {
        List<Integer> userIds = getUserIdList();
        Integer userId = userIds.get(0);
        List<Integer> idsForUserId = getIdListForUserId(userId);
        idsForUserId.sort(reverseOrder());
        Integer highestIdValueForUserId = idsForUserId.get(0);
        out.println("Highest id value for userId " + userId + " is: " + highestIdValueForUserId);
    }

    @Test
    public void shouldAddNewCommentForPostId() {
    }

    private List<Integer> getIdListForUserId(Integer userId) {
        return when().get("/posts?userId=" + userId)
                .then().statusCode(200)
                .extract().response()
                .jsonPath().get("id");
    }

    private List<Integer> getUserIdList() {
        return when().get("/posts")
                .then().statusCode(200)
                .extract().response()
                .jsonPath().get("userId");
    }

}
