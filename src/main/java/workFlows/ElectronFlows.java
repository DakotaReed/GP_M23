package workFlows;

import extensions.UIActions;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utilities.CommonOps;
import java.time.LocalDate;

public class ElectronFlows extends CommonOps {

    @Step("Business Flow: Getting Present Date")
    public static void getPresentDate() {
        localDate = LocalDate.now();
        presentDate = localDate.toString();
    }

    @Step("Business Flow: Add New Task")
    public static void addNewTask(String text) {
        UIActions.updateText(ToDoList_MainPage.txt_createTask, text);
        UIActions.sendKeyboardButton(ToDoList_MainPage.txt_createTask, Keys.RETURN);
    }

    @Step("Business Flow: Getting Amount of Tasks")
    public static int getAmountOfTasks() {
        UIActions.getListSize(ToDoList_MainPage.list_tasks);
        return listSize;
    }

    @Step("Business Flow: Create Three Example Tasks")
    public static void createThreeExampleTasks() {
        ElectronFlows.addNewTask(getData("TaskName_1"));
        ElectronFlows.addNewTask(getData("TaskName_2"));
        ElectronFlows.addNewTask(getData("TaskName_3"));
    }

    @Step("Business Flow: Delete Task")
    public static void deleteTask(int index) {
        UIActions.mouseHover(ToDoList_MainPage.list_btnDelete.get(index));
        UIActions.click(ToDoList_MainPage.list_btnDelete.get(index));
//        try {
//            ToDoList_MainPage.list_tasks.get(0).isDisplayed();
//        } catch (Exception e) {
//            wait.until(ExpectedConditions.visibilityOf(ToDoList_MainPage.staticElem_noTasks));
//        }
    }

    @Step("Business Flow: Change Task Name")
    public static void changeTaskName(int index, String newName) {
        UIActions.doubleClick(ToDoList_MainPage.list_tasks.get(index));
        UIActions.clearingInputArea(ToDoList_MainPage.list_inputExistsTask.get(index));
        UIActions.updateText(ToDoList_MainPage.list_inputExistsTask.get(index), newName);
        UIActions.sendKeyboardButton(ToDoList_MainPage.list_inputExistsTask.get(index), Keys.RETURN);
    }

    @Step("Business Flow: Complete Task")
    public static void completeTask(int index) {
        wait.until(ExpectedConditions.visibilityOfAllElements(ToDoList_MainPage.list_btnComplete));
        UIActions.click(ToDoList_MainPage.list_btnComplete.get(index));
        wait.until(ExpectedConditions.visibilityOfAllElements(ToDoList_MainPage.list_tasks));
    }

    @Step("Business Flow: Complete All Tasks")
    public static void completeAllTasks() {
        UIActions.click(ToDoList_MainPage.span_completeAll);
    }

    @Step("Business Flow: Convert String to Int")
    public static void convertStringToInt(String text) {
        indexOfElement = Integer.parseInt(text);
    }

    @Step("Business Flow: Choose Tasks to Visibility by Status: 'All', 'Todo', 'Completed'")
    public static void selectStatusTasks(String status) {
        UIActions.click(ToDoList_MainPage.btn_rightMenu);
        wait.until(ExpectedConditions.visibilityOfAllElements(ToDoList_RightMenu.list_btnsStatus));
        for (WebElement btn_status : ToDoList_RightMenu.list_btnsStatus) {
            UIActions.getText(btn_status);
            if (textOfElement.equalsIgnoreCase(status))
                UIActions.click(btn_status);
        }
    }

}
