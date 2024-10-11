package sanity;

import extensions.ApiActions;
import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workFlows.ApiFlows;

//    java -jar students.jar --server.port=9000
@Listeners(utilities.ListenersAuto.class)
public class StudentsList_API extends CommonOps {

    @Test(description = "Test 01: Verify Creating New Student", dataProvider = "data-provider-namesOfStudents", dataProviderClass = utilities.ManageDDT.class)
    @Description("Verify Creating New Student (using DDT)")
    public static void test01_verifyCreatingNewStud(String name) {
        ApiFlows.createStudent(name, getData("Programme_QA"));
        Verifications.verifyStatusCode(ApiActions.getStatusCode(), 201);
    }

    @Test(description = "Test 02: Verify Updating Parameters of Student")
    @Description("Verify Updating Parameters of Student")
    public static void test02_verifyUpdatingStudent() {
        ApiFlows.createStudent(getData("Student_2"), getData("Programme_QA"));
        ApiFlows.changeProgramme(getData("Student_2"), getData("Programme_FS"));
        Verifications.verifyStatusCode(ApiActions.getStatusCode(), 200);
    }

    @Test(description = "Test 03: Verify Deleting Student")
    @Description("Verify Deleting Student")
    public static void test03_verifyDeletingStudent() {
        ApiFlows.createStudent(getData("Student_1"), getData("Programme_QA"));
        ApiFlows.deleteStudent(getData("Student_1"));
        Verifications.verifyStatusCode(ApiActions.getStatusCode(), 204);
    }

}
