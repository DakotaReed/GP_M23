package sanity;

import extensions.UIActions;
import extensions.Verifications;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workFlows.ElectronFlows;

@Listeners(utilities.ListenersAuto.class)
public class ToDoList_Electron extends CommonOps {

    @Test(description = "Test 01: Verify Present Date")
    @Description("Verify Present Date")
    public static void test01_verifyPresentDate() {
        ElectronFlows.getPresentDate();
        UIActions.getText(ToDoList_MainPage.static_date);
        Verifications.verifyPresentDate(textOfElement, presentDate);
    }

    @Test(description = "Test 02: Verify Adding Task")
    @Description("Verify Adding Task")
    public static void test02_verifyAddingTask() {
        ElectronFlows.addNewTask(getData("TaskName_1"));
        Verifications.verifyAmountOfTasks(ElectronFlows.getAmountOfTasks(), 1);
    }

    @Test(description = "Test 03: Verify Deleting Task")
    @Description("Verify Deleting Task")
    public static void test03_verifyDeletingTask() {
        ElectronFlows.createThreeExampleTasks();
        ElectronFlows.deleteTask(1);
        Verifications.verifyAmountOfTasks(ElectronFlows.getAmountOfTasks(), 2);
    }

    @Test(description = "Test 04: Verify Changing Name of Task")
    @Description("Verify Changing Name of Task")
    public static void test04_verifyChangingNameOfTask() {
        ElectronFlows.addNewTask(getData("TaskName_2"));
        ElectronFlows.changeTaskName(0, getData("TaskName_3"));
        UIActions.getText(ToDoList_MainPage.list_tasks.get(0));
        Verifications.verifyNameOfTasks(textOfElement, getData("TaskName_3"));
    }

    @Test(description = "Test 05: Verify Task Completed", dataProvider = "data-provider-indexOfTask", dataProviderClass = utilities.ManageDDT.class)
    @Description("Verify Task Completed (using SoftAssert) & (using DDT)")
    public static void test05_verifyTaskCompleted(String index) {
        ElectronFlows.createThreeExampleTasks();
        ElectronFlows.convertStringToInt(index);
        ElectronFlows.completeTask(indexOfElement);
        UIActions.getClassName(ToDoList_MainPage.list_tasks.get(indexOfElement));
        Verifications.verifyTaskCompleted(textOfElement);
    }

    @Test(description = "Test 06: Verify Completing All Tasks")
    @Description("Verify Completing All Tasks (using SoftAssert)")
    public static void test06_verifyCompletingAllTasks() {
        ElectronFlows.createThreeExampleTasks();
        ElectronFlows.completeAllTasks();
        Verifications.verifyAllTasksCompleted();
    }

    @Test(description = "Test 07: Verify Visibility of ONLY NOT Completed Tasks")
    @Description("Verify Visibility of ONLY NOT Completed Tasks (using SoftAssert)")
    public static void test07_verifyOnlyNoCompTasks() {
        ElectronFlows.createThreeExampleTasks();
        ElectronFlows.completeTask(1);
        ElectronFlows.selectStatusTasks(getData("TaskStatusTODO"));
        Verifications.verifyAllTasksNoCompleted();
    }

    @Test(description = "Test 08: Verify Visibility of ONLY Completed Tasks")
    @Description("Verify Visibility of ONLY Completed Tasks")
    public static void test08_verifyOnlyCompTasks() {
        ElectronFlows.createThreeExampleTasks();
        ElectronFlows.completeTask(1);
        ElectronFlows.selectStatusTasks(getData("TaskStatusDONE"));
        Verifications.verifyAllTasksCompleted();
    }

}
