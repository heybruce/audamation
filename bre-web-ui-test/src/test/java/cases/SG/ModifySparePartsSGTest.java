package cases.SG;

import cases.TestBase;
import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageobjects.processstep.DamageCapturingPO;
import pageobjects.processstep.ModifySparePartsPO;
import pageobjects.processstep.ReportsPO;
import pageobjects.processstep.processstep.ProcessStepSGPO;
import steps.*;
import utils.UtilitiesManager;

import java.math.BigDecimal;
import java.text.DecimalFormat;

import static utils.webdrivers.WebDriverFactory.getDriver;

public class ModifySparePartsSGTest extends TestBase{
    private DamageCapturingPO damageCapturingPO;
    private ModifySparePartsPO modifySparePartsPO;
    private ProcessStepSGPO processStepSGPO;
    private ReportsPO reportsPO;

    @BeforeClass
    @Parameters(value = {"dataFile", "vehicleElement"})
    public void setup(String dataFile, String vehicleElement) {
        vehicleElementData = UtilitiesManager.setPropertiesFile(vehicleElement);
        testData = UtilitiesManager.setPropertiesFile(dataFile);
    }

    @BeforeMethod
    public void methodSetup() {
        processStepSGPO = (ProcessStepSGPO) context.getBean("ProcessStepSGPO");
        processStepSGPO.setWebDriver(getDriver());
        modifySparePartsPO = (ModifySparePartsPO)context.getBean("ModifySparePartsPO");
        modifySparePartsPO.setWebDriver(getDriver());
        damageCapturingPO = (DamageCapturingPO)context.getBean("DamageCapturingPO");
        damageCapturingPO.setWebDriver(getDriver());
        reportsPO = (ReportsPO)context.getBean("ReportsPO");
        reportsPO.setWebDriver(getDriver());
    }

    @Test(description = "Repair parts which added from Qapter should display in the list")
    public void repairPartsFromQapterDisplayInModifyPart(){
        //Launch browser
        getDriver().get(testData.getString("test_url"));
        testCase.get().log(Status.INFO, "Browser launched successfully");

        //Login
        Login login = new Login();
        login.LoginBRE(testData.getString("rep_username"), testData.getString("password"));

        //Create a new case
        CreateNewCaseSG createNewCase = new CreateNewCaseSG();
        createNewCase.createNewCaseWithVehicleIdentificationBySearchTree(testData.getString("bmw320_vehicle"));

        //Switch to Labour Rate page
        processStepSGPO.clickLaborRateSG();
        testCase.get().log(Status.INFO, "Switch to Labour Rate page");

        //Select labour rate
        SetLaborRate setLaborRate = new SetLaborRate();
        setLaborRate.SelectPartnership();
        testCase.get().log(Status.INFO, "Select the first of partnership value");

        //Switch to Damage Capturing page
        processStepSGPO.clickDamageCaptureSG();
        damageCapturingPO.switchToQapterIframe();
        testCase.get().log(Status.INFO, "Switch to Damage Capturing page");

        //Damage Capturing - add standard part
        DamageCapturing damageCapturing = new DamageCapturing();
        damageCapturing.selectDoorsNumberIfModelOptionPopup();
        damageCapturing.addStandardPartToReplaceWithOem(
                vehicleElementData.getString("bmw320_zone_frontOuter"),vehicleElementData.getString("bmw320_position_0471_Bonnet"));
        damageCapturingPO.navigationChecklist();
        //Get part details in check list
        String partDescription, partPrice, partNumber, partGuideNumber;
        partDescription = damageCapturingPO.getChecklistPartDescription(1);
        partPrice = damageCapturingPO.getChecklistPrice(1).replaceAll("\\pP","");
        partNumber = damageCapturingPO.getChecklistPartNumber(1).replaceAll(" ", "");
        partGuideNumber = damageCapturingPO.getChecklistGuideNumber(1);

        //Check calculation preview before exit Qapter
        damageCapturing.waitForCalcPreviewGenerated();
        testCase.get().log(Status.INFO, "Calculation preview success");

        //Switch to Modify Parts page and verify
        getDriver().switchTo().defaultContent();
        processStepSGPO.clickModifySparePartsSG();
        testCase.get().log(Status.INFO, "Switch to Modify Parts page");

        Assert.assertEquals(modifySparePartsPO.getAddedPartsNum(), 1);
        testCase.get().log(Status.PASS, "There is a added part in the list");
        String mspPartDescription, mspPartPrice, mspPartNumber, mspPartGuideNumber;
        mspPartDescription = modifySparePartsPO.getPartDescription(0);
        mspPartGuideNumber = modifySparePartsPO.getGuideNumber(0);
        mspPartNumber = modifySparePartsPO.getPartNumber(0).replaceAll(" ", "");
        mspPartPrice = modifySparePartsPO.getPartPrice(0).replaceAll("\\pP","");

        Assert.assertEquals(mspPartGuideNumber, partGuideNumber);
        testCase.get().log(Status.PASS, "Part guide number (" + mspPartGuideNumber + ") are the same in Qapter and Modify parts");
        Assert.assertEquals(mspPartDescription, partDescription);
        testCase.get().log(Status.PASS, "Part description (" + mspPartDescription + ") are the same in Qapter and Modify parts");
        Assert.assertEquals(mspPartNumber, partNumber);
        testCase.get().log(Status.PASS, "Part number (" + mspPartNumber + ") are the same in Qapter and Modify parts");
        Assert.assertEquals(mspPartPrice, partPrice);
        testCase.get().log(Status.PASS, "Part price (" + mspPartPrice + ") are the same in Qapter and Modify parts");
        Assert.assertEquals("", modifySparePartsPO.getPartSupplier(0));
        testCase.get().log(Status.PASS, "Part supplier is empty");
        Assert.assertEquals(testData.getString("PartType_OEM"), modifySparePartsPO.getPartType(0).substring(0, 3));
        testCase.get().log(Status.PASS, "Part type is OEM parts as default value");
    }

    @Test(description = "Modify the price less than original price")
    public void modifyThePriceLessThanOriginalPrice(){
        //Launch browser
        getDriver().get(testData.getString("test_url"));
        testCase.get().log(Status.INFO, "Browser launched successfully");

        //Login
        Login login = new Login();
        login.LoginBRE(testData.getString("rep_username"), testData.getString("password"));

        //Create a new case
        CreateNewCaseSG createNewCase = new CreateNewCaseSG();
        createNewCase.createNewCaseWithVehicleIdentificationBySearchTree(testData.getString("bmw320_vehicle"));

        //Switch to Labour Rate page
        processStepSGPO.clickLaborRateSG();
        testCase.get().log(Status.INFO, "Switch to Labour Rate page");

        //Select labour rate
        SetLaborRate setLaborRate = new SetLaborRate();
        setLaborRate.SelectPartnership();
        testCase.get().log(Status.INFO, "Select the first of partnership value");

        //Switch to Damage Capturing page
        processStepSGPO.clickDamageCaptureSG();
        damageCapturingPO.switchToQapterIframe();
        testCase.get().log(Status.INFO, "Switch to Damage Capturing page");

        //Damage Capturing - add standard part
        DamageCapturing damageCapturing = new DamageCapturing();
        damageCapturing.selectDoorsNumberIfModelOptionPopup();
        damageCapturing.addStandardPartToReplaceWithOem(
                vehicleElementData.getString("bmw320_zone_frontOuter"),vehicleElementData.getString("bmw320_position_0471_Bonnet"));

        damageCapturingPO.navigationChecklist();
        //Get part details in check list
        String partPrice;
        partPrice = damageCapturingPO.getChecklistPrice(1).replaceAll(",","");
        double PartPriceOriginal = Double.parseDouble(partPrice);
        int PartPriceNew = Integer.parseInt(testData.getString("Entered_New_Price"));

        //Check calculation preview before exit Qapter
        damageCapturing.waitForCalcPreviewGenerated();
        testCase.get().log(Status.INFO, "Calculation preview success");

        //Switch to Modify Parts page and edit the price
        getDriver().switchTo().defaultContent();
        processStepSGPO.clickModifySparePartsSG();
        testCase.get().log(Status.INFO, "Switch to Modify Parts page");

        modifySparePartsPO.setEnteredPrice(0, testData.getString("Entered_New_Price"));
        modifySparePartsPO.clickSupplier(0);
        testCase.get().log(Status.INFO, "Entered a new price: " + testData.getString("Entered_New_Price"));
        double totalSavingExpected = PartPriceOriginal - PartPriceNew;
        BigDecimal b = new BigDecimal(totalSavingExpected);
        totalSavingExpected = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        double totalSavingActual = Double.parseDouble(modifySparePartsPO.getTotalSavingAmount(testData.getString("currency")));
        Assert.assertEquals(totalSavingActual, totalSavingExpected);
        testCase.get().log(Status.PASS, "Total saving is show as expected");

        //Switch to Reports page
        processStepSGPO.clickReportsSG();
        testCase.get().log(Status.INFO, "Switch to Reports tab");

        //Do calculation and assertion
        CalculationList calculationList = new CalculationList();
        calculationList.displayAllContentInReportCalculationList();
        reportsPO.clickCalculateAlternative();
        testCase.get().log(Status.INFO, "Do calculation");
        DecimalFormat df = new DecimalFormat("######0.00");
        String partsTotalExpected = df.format(PartPriceNew * 1);
        String partsTotalActual = reportsPO.getPartsTotal(0).replaceAll(",","");
        Assert.assertEquals(partsTotalActual, partsTotalExpected);
        testCase.get().log(Status.PASS, "Parts price is the updated price in calculation");
    }
}
