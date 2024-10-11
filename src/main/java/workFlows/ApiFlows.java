package workFlows;

import extensions.ApiActions;
import io.qameta.allure.Step;
import org.json.simple.JSONObject;
import utilities.CommonOps;
import java.util.Arrays;

public class ApiFlows extends CommonOps {

    @Step("Business Flow: Wrapping Params of Student Dakota Reed")
    public static JSONObject DakotaReed(String programme) {
        params = new JSONObject();
        params.put("firstName", "Dakota");
        params.put("lastName", "Reed");
        params.put("email", "dakota.reed.28@gmail.com");
        params.put("programme", programme);
        return params;
    }

    @Step("Business Flow: Wrapping Params of Student Kuku Lolo")
    public static JSONObject KukuLolo(String programme, String course1, String course2, String course3) {
        params = new JSONObject();
        params.put("firstName", "Kuku");
        params.put("lastName", "Lolo");
        params.put("email", "kuku_lolo@gmail.com");
        params.put("programme", programme);
        params.put("courses", Arrays.asList(course1, course2, course3));
        return params;
    }

    @Step("Business Flow: Create New Student")
    public static void createStudent(String name, String programme) {
        if (name.equalsIgnoreCase("DakotaReed"))
            params = DakotaReed(programme);
        else if (name.equalsIgnoreCase("KukuLolo"))
            params = KukuLolo(programme, getData("Course_1"), getData("Course_2"), getData("Course_3"));
         else
            System.out.println("No parameters of this Student");
        ApiActions.post(params, "/student");
        System.out.println(response.getBody().asString());
        checkStudentNotExist(name, programme);
    }

    @Step("Business Flow: Delete Student")
    public static void deleteStudent(String name) {
        ApiActions.get(getData("UrlAPI") + "student/list");
        ApiActions.extractEmailsFromJSON(response);
        ApiActions.extractIdsFromJSON(response);
        if (name.equalsIgnoreCase("DakotaReed"))
            email = "dakota.reed.28@gmail.com";
        else if (name.equalsIgnoreCase("KukuLolo"))
            email = "kuku_lolo@gmail.com";
        else {
            System.out.println("Invalid Name: " + name);
        }
        for (int i = 0; i < allStudentsEmail.size(); i++) {
            if (allStudentsEmail.get(i).equals(email)) {
                idOfStudent = String.valueOf(allStudentsId.get(i));
                ApiActions.delete(idOfStudent);
                System.out.println("DELETED");
            }
        }
    }

    @Step("Business Flow: Check that Student Does NOT Exist (if FALSE -> Deleting and New Creating)")
    public static void checkStudentNotExist(String name, String programme) {
        if (response.getStatusCode() == 500) {
            if (response.getBody().asString().contains("Email") && response.getBody().asString().contains("already exists")) {
                deleteStudent(name);
                if (email.equalsIgnoreCase("dakota.reed.28@gmail.com"))
                    params = DakotaReed(programme);
                if (email.equalsIgnoreCase("kuku_lolo@gmail.com"))
                    params = KukuLolo(programme, getData("Course_1"), getData("Course_2"), getData("Course_3"));
                ApiActions.post(params, "/student");
                System.out.println(response.getBody().asString());
            }
        }
    }

    @Step("Business Flow: Change Programme for Student")
    public static void changeProgramme(String name, String programme) {
        ApiActions.get(getData("UrlAPI") + "student/list");
        ApiActions.extractEmailsFromJSON(response);
        ApiActions.extractIdsFromJSON(response);
        if (name.contains("DakotaReed"))
            params = DakotaReed(programme);
        if (name.contains("KukuLolo"))
            params = KukuLolo(programme, getData("Course_1"), getData("Course_2"), getData("Course_3"));
        for (int i=0; i < allStudentsEmail.size(); i++) {
            if (allStudentsEmail.get(i).equals("kuku_lolo@gmail.com")) {
                idOfStudent = String.valueOf(allStudentsId.get(i));
                ApiActions.put(params, "/student/"+idOfStudent);
                System.out.println(response.getBody().asString());
            }
        }
    }

}
