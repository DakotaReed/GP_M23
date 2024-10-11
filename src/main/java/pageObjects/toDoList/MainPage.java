package pageObjects.toDoList;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;


//    ctrl shift i
public class MainPage {

    @FindBy(css = "span[class*='dateFormatted']")
    public WebElement static_date;

    @FindBy(css = "input[placeholder='Create a task']")
    public WebElement txt_createTask;

    @FindBy(css = "div[class*='taskWrapper']>div>div>div>label")
    public List<WebElement> list_tasks;

    @FindBy(css = "svg[class*='destroy']")
    public List<WebElement> list_btnDelete;

    @FindBy(css = "input[class*='editingTextInput']")
    public List<WebElement> list_inputExistsTask;

    @FindBy(css = "label[class*='toggleIconsWrapper']")
    public List<WebElement> list_btnComplete;

    @FindBy(css = "span[class*='allCompletedText']")
    public WebElement span_completeAll;

    @FindBy(css = "div[class*='toggleVisibilityPanel']")
    public WebElement btn_rightMenu;

    @FindBy(css = "h2[class*='emptyState']")
    public WebElement staticElem_noTasks;
}
