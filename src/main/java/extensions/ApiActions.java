package extensions;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import utilities.CommonOps;
import java.util.List;

public class ApiActions extends CommonOps {

    @Step("Get Data from Server")
    public static Response get(String paramValues) {
        response = httpRequest.get(paramValues);
        return response;
    }

    @Step("Getting Status Code")
    public static int getStatusCode() {
        return response.getStatusCode();
    }

    @Step("Post Data to Server")
    public static void post(JSONObject params, String resource) {
        httpRequest.body(params.toJSONString());
        response = httpRequest.post(resource);
    }

    @Step("Update Data on Server")
    public static void put(JSONObject params, String resource) {
        httpRequest.body(params.toJSONString());
        response = httpRequest.put(resource);
    }

    @Step("Delete Data from Server")
    public static void delete(String id) {
        response = httpRequest.delete("/student/" + id);
    }

    @Step("Extract List of Email_Value from JSON Format")
    public static List extractEmailsFromJSON(Response response) {
        jp = response.jsonPath();
        allStudentsEmail = jp.getList("email");
        return allStudentsEmail;
    }

    @Step("Extract List of ID_Value from JSON Format")
    public static List extractIdsFromJSON(Response response) {
        jp = response.jsonPath();
        allStudentsId = jp.getList("id");
        return allStudentsId;
    }

}
