package pageobjects.processstep;

import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobjects.PageObject;
import utils.log.Loggable;

public class DamageDetailsPO extends PageObject {
    private static final String CHECKBOX_ALLAREAS_LOCATOR = "root.task.basicClaimData.vehicle.vehicleDamage.damageAreaAll";
    private static final String CHECKBOX_CENTERLEFT_LOCATOR = "root.task.basicClaimData.vehicle.vehicleDamage.damageAreaCL";
    private static final String CHECKBOX_CENTERMIDDLE_LOCATOR = "root.task.basicClaimData.vehicle.vehicleDamage.damageAreaCM";
    private static final String CHECKBOX_CENTERRIGHT_LOCATOR = "root.task.basicClaimData.vehicle.vehicleDamage.damageAreaCR";
    private static final String CHECKBOX_FRONTLEFT_LOCATOR = "root.task.basicClaimData.vehicle.vehicleDamage.damageAreaFL";
    private static final String CHECKBOX_FRONTMIDDLE_LOCATOR = "root.task.basicClaimData.vehicle.vehicleDamage.damageAreaFM";
    private static final String CHECKBOX_FRONTRIGHT_LOCATOR = "root.task.basicClaimData.vehicle.vehicleDamage.damageAreaFR";
    private static final String CHECKBOX_FRONTWINDOW_LOCATOR = "root.task.basicClaimData.vehicle.vehicleDamage.damageAreaFrontWindow";
    private static final String CHECKBOX_REARLEFT_LOCATOR = "root.task.basicClaimData.vehicle.vehicleDamage.damageAreaRL";
    private static final String CHECKBOX_REARMIDDLE_LOCATOR = "root.task.basicClaimData.vehicle.vehicleDamage.damageAreaRM";
    private static final String CHECKBOX_REARRIGHT_LOCATOR = "root.task.basicClaimData.vehicle.vehicleDamage.damageAreaRR";
    private static final String CHECKBOX_REARWINDOW_LOCATOR = "root.task.basicClaimData.vehicle.vehicleDamage.damageAreaRearWindow";
    private static final String CHECKBOX_SIDEWINDOW_LOCATOR = "root.task.basicClaimData.vehicle.vehicleDamage.damageAreaSideWindow";
    private static final String CHECKBOX_UNDERBODY_LOCATOR = "root.task.basicClaimData.vehicle.vehicleDamage.underbody";

    // Checkbox
    @FindBy(id = CHECKBOX_ALLAREAS_LOCATOR)
    private WebElement checkBoxAllAreas;
    @FindBy(id = CHECKBOX_CENTERLEFT_LOCATOR)
    private WebElement checkBoxCenterLeft;
    @FindBy(id = CHECKBOX_CENTERMIDDLE_LOCATOR)
    private WebElement checkBoxCenterMiddle;
    @FindBy(id = CHECKBOX_CENTERRIGHT_LOCATOR)
    private WebElement checkBoxCenterRight;
    @FindBy(id = CHECKBOX_FRONTLEFT_LOCATOR)
    private WebElement checkBoxFrontLeft;
    @FindBy(id = CHECKBOX_FRONTMIDDLE_LOCATOR)
    private WebElement checkBoxFrontMiddle;
    @FindBy(id = CHECKBOX_FRONTRIGHT_LOCATOR)
    private WebElement checkBoxFrontRight;
    @FindBy(id = CHECKBOX_FRONTWINDOW_LOCATOR)
    private WebElement checkBoxFrontWindow;
    @FindBy(id = CHECKBOX_REARLEFT_LOCATOR)
    private WebElement checkBoxRearLeft;
    @FindBy(id = CHECKBOX_REARMIDDLE_LOCATOR)
    private WebElement checkBoxRearMiddle;
    @FindBy(id = CHECKBOX_REARRIGHT_LOCATOR)
    private WebElement checkBoxRearRight;
    @FindBy(id = CHECKBOX_REARWINDOW_LOCATOR)
    private WebElement checkBoxRearWindow;
    @FindBy(id = CHECKBOX_SIDEWINDOW_LOCATOR)
    private WebElement checkBoxSideWindow;
    @FindBy(id = CHECKBOX_UNDERBODY_LOCATOR)
    private WebElement checkBoxUnderBody;

    // Checkbox Label
    @FindBy(css = "label[for=\"" + CHECKBOX_ALLAREAS_LOCATOR + "\"]")
    private WebElement labelAllAreas;
    @FindBy(css = "label[for=\"" + CHECKBOX_CENTERLEFT_LOCATOR + "\"]")
    private WebElement labelCenterLeft;
    @FindBy(css = "label[for=\"" + CHECKBOX_CENTERMIDDLE_LOCATOR + "\"]")
    private WebElement labelCenterMiddle;
    @FindBy(css = "label[for=\"" + CHECKBOX_CENTERRIGHT_LOCATOR + "\"]")
    private WebElement labelCenterRight;
    @FindBy(css = "label[for=\"" + CHECKBOX_FRONTLEFT_LOCATOR + "\"]")
    private WebElement labelFrontLeft;
    @FindBy(css = "label[for=\"" + CHECKBOX_FRONTMIDDLE_LOCATOR + "\"]")
    private WebElement labelFrontMiddle;
    @FindBy(css = "label[for=\"" + CHECKBOX_FRONTRIGHT_LOCATOR + "\"]")
    private WebElement labelFrontRight;
    @FindBy(css = "label[for=\"" + CHECKBOX_FRONTWINDOW_LOCATOR + "\"]")
    private WebElement labelFrontWindow;
    @FindBy(css = "label[for=\"" + CHECKBOX_REARLEFT_LOCATOR + "\"]")
    private WebElement labelRearLeft;
    @FindBy(css = "label[for=\"" + CHECKBOX_REARMIDDLE_LOCATOR + "\"]")
    private WebElement labelRearMiddle;
    @FindBy(css = "label[for=\"" + CHECKBOX_REARRIGHT_LOCATOR + "\"]")
    private WebElement labelRearRight;
    @FindBy(css = "label[for=\"" + CHECKBOX_REARWINDOW_LOCATOR + "\"]")
    private WebElement labelRearWindow;
    @FindBy(css = "label[for=\"" + CHECKBOX_SIDEWINDOW_LOCATOR + "\"]")
    private WebElement sideWindow;
    @FindBy(css = "label[for=\"" + CHECKBOX_UNDERBODY_LOCATOR + "\"]")
    private WebElement underBody;


    // Vehicle Image
    @FindBy(id = "rearMiddle")
    private WebElement imgRearMiddle;
    @FindBy(id = "rearWindow")
    private WebElement imgRearWindow;
    @FindBy(id = "rearRight")
    private WebElement imgRearRight;
    @FindBy(id = "rearLeft")
    private WebElement imgRearLeft;
    @FindBy(id = "centerLeft")
    private WebElement imgCenterLeft;
    @FindBy(id = "centerMiddle")
    private WebElement imgCenterMiddle;
    @FindBy(id = "centerRight")
    private WebElement imgCenterRight;
    @FindBy(id = "rightSideWindow")
    private WebElement imgRightSideWindow;
    @FindBy(id = "leftSideWindow")
    private WebElement imgLeftSideWindow;
    @FindBy(id = "frontWindow")
    private WebElement imgFrontWindow;
    @FindBy(id = "frontMiddle")
    private WebElement imgFrontMiddle;
    @FindBy(id = "frontRight")
    private WebElement imgFrontRight;
    @FindBy(id = "frontLeft")
    private WebElement imgFrontLeft;

    public DamageDetailsPO() { super(); }

    public DamageDetailsPO(WebDriver webDriver) {
        super(webDriver);
    }

    @Loggable
    public void clickImgBackSide(){
        new WebDriverWait(webDriver, 5).until(ExpectedConditions.visibilityOf(imgRearMiddle));
        new Actions(webDriver).moveToElement(imgRearMiddle).click().perform();
    }
    @Loggable
    public void clickImgRearWindow(){
        new WebDriverWait(webDriver, 5).until(ExpectedConditions.visibilityOf(imgRearWindow));
        new Actions(webDriver).moveToElement(imgRearWindow).click().perform();
    }
    @Loggable
    public void clickImgRearRight(){
        new WebDriverWait(webDriver, 5).until(ExpectedConditions.visibilityOf(imgRearRight));
        new Actions(webDriver).moveToElement(imgRearRight).click().perform();
    }
    @Loggable
    public void clickImgRearLeft(){
        new WebDriverWait(webDriver, 5).until(ExpectedConditions.visibilityOf(imgRearLeft));
        new Actions(webDriver).moveToElement(imgRearLeft).click().perform();
    }
    @Loggable
    public void clickImgCenterLeft() {
        new WebDriverWait(webDriver, 5).until(ExpectedConditions.visibilityOf(imgCenterLeft));
        new Actions(webDriver).moveToElement(imgCenterLeft).click().perform();
    }
    @Loggable
    public void clickImgCenterMiddle(){
        new WebDriverWait(webDriver, 5).until(ExpectedConditions.visibilityOf(imgCenterMiddle));
        new Actions(webDriver).moveToElement(imgCenterMiddle).click().perform();
    }
    @Loggable
    public void clickImgCenterRight() {
        new WebDriverWait(webDriver, 5).until(ExpectedConditions.visibilityOf(imgCenterRight));
        new Actions(webDriver).moveToElement(imgCenterRight).click().perform();
    }
    @Loggable
    public void clickImgRightSideWindow(){
        new WebDriverWait(webDriver, 5).until(ExpectedConditions.visibilityOf(imgRightSideWindow));
        new Actions(webDriver).moveToElement(imgRightSideWindow).click().perform();
    }
    @Loggable
    public void clickImgLeftSideWindow(){
        new WebDriverWait(webDriver, 5).until(ExpectedConditions.visibilityOf(imgLeftSideWindow));
        new Actions(webDriver).moveToElement(imgLeftSideWindow).click().perform();
    }
    @Loggable
    public void clickImgFrontWindow(){
        new WebDriverWait(webDriver, 5).until(ExpectedConditions.visibilityOf(imgFrontWindow));
        new Actions(webDriver).moveToElement(imgFrontWindow).click().perform();
    }
    @Loggable
    public void clickImgFrontMiddle(){
        new WebDriverWait(webDriver, 5).until(ExpectedConditions.visibilityOf(imgFrontMiddle));
        try {
            this.click(imgFrontMiddle);
        } catch (ElementNotInteractableException e) {
            // click on graphic is not working on Firefox so use Actions.click instead
            new Actions(webDriver).moveToElement(imgFrontMiddle).click().perform();
        }
    }
    @Loggable
    public void clickImgFrontRight(){
        new WebDriverWait(webDriver, 5).until(ExpectedConditions.visibilityOf(imgFrontRight));
        new Actions(webDriver).moveToElement(imgFrontRight).click().perform();
    }
    @Loggable
    public void clickImgFrontLeft(){
        new WebDriverWait(webDriver, 5).until(ExpectedConditions.visibilityOf(imgFrontLeft));
        new Actions(webDriver).moveToElement(imgFrontLeft).click().perform();
    }

    @Loggable
    public boolean isImgCenterLeftDamaged(){
        return imgCenterLeft.getAttribute("class").contains("damaged");
    }

    @Loggable
    public void clickCheckboxAllAreas(){ this.click(labelAllAreas); }
    @Loggable
    public void clickCheckboxCenterLeft(){ this.click(labelCenterLeft); }
    @Loggable
    public void clickCheckboxCenterMiddle(){ this.click(labelCenterMiddle); }
    @Loggable
    public void clickCheckboxCenterRight(){ this.click(labelCenterRight); }
    @Loggable
    public void clickCheckboxFrontLeft(){ this.click(labelFrontLeft); }
    @Loggable
    public void clickCheckboxFrontMiddle(){ this.click(labelFrontMiddle); }
    @Loggable
    public void clickCheckboxFrontRight(){ this.click(labelFrontRight); }
    @Loggable
    public void clickCheckboxFrontWindow(){ this.click(labelFrontWindow); }
    @Loggable
    public void clickCheckboxRearLeft(){ this.click(labelRearLeft); }
    @Loggable
    public void clickCheckboxRearMiddle(){ this.click(labelRearMiddle); }
    @Loggable
    public void clickCheckboxRearRight(){ this.click(labelRearRight); }
    @Loggable
    public void clickCheckboxRearWindow(){ this.click(labelRearWindow); }
    @Loggable
    public void clickCheckboxSideWindow(){ this.click(sideWindow); }
    @Loggable
    public void clickCheckboxUnderBody(){ this.click(underBody); }

    @Loggable
    public boolean isCheckboxFrontMiddleChecked(){
        return checkBoxFrontMiddle.getAttribute("data-checked").equals("true");
    }
}