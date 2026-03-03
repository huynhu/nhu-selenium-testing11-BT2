package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class airbnbHomePage extends BasePage{

    public airbnbHomePage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
//  URL
    private static final String URL = "https://demo5.cybersoft.edu.vn/";

    public static By menuBar(String text){
        return By.xpath("//a[text()='" + text + "']");
    }

    private static final By CYBERSOFT_LOGO = By.xpath("//span[text()='CyberSoft']");

    private static final By ICON_LOGO = By.xpath("//button/img");
    private static final By USER_DROPDOWN = By.id("user-dropdown");

    private static final By DESTINATION = By.xpath("//p[te xt()='Địa điểm']");
    private static final By SEARCH_DESTINATION = By.xpath("//h1[text()='Tìm kiếm địa điểm']");
//  Date picker
    private static final By DATE_RANGE = By.xpath("(//div[contains(@class,'cursor-pointer')]//p)[3]");
    private static final By DATE_RANGE_PICKER = By.cssSelector(".rdrDateRangePickerWrapper");
//  Add guest
    private static final By ADD_GUEST = By.xpath("//p[text()='Thêm khách']");
    public static final By ADD_ICON = By.xpath("//button/div[text()='+']");
    public static final By MINUS_ICON = By.xpath("//button/div[text()='-']");

    public static By filterOptions(String option){
        return By.xpath("//button[text()='" + option + "']");
    }

//  Destination cards
    public static By destinationCard(String destination){
    return By.xpath("//div[@class='ant-card-body']/div/div/h2[text()='" + destination + "']");
    }
    public static By name_of_destination(String destination){
        return By.xpath("//h2[normalize-space()='" + destination + "']");
    }
    public static By time_to_destination(String destination){
        return By.xpath("//h2[normalize-space()='" + destination + "']/following-sibling::p");
    }
    public static final By HO_CHI_MINH_CARD = By.xpath("(//a[@href='/rooms/ho-chi-minh'])[1]");
    public static final By CAN_THO_CARD = By.xpath("//a[@href='/rooms/can-tho']");
    public static final By NHA_TRANG_CARD = By.xpath("//a[@href='/rooms/nha-trang']");
    public static final By HA_NOI_CARD = By.xpath("//a[@href='/rooms/ha-noi']");
    public static final By PHU_QUOC_CARD = By.xpath("//a[@href='/rooms/phu-quoc']");
    public static final By DA_NANG_CARD = By.xpath("//a[@href='/rooms/da-nang']");
    public static final By DA_LAT_CARD = By.xpath("//a[@href='/rooms/da-lat']");
    public static final By PHAN_THIET_CARD = By.xpath("//a[@href='/rooms/phan-thiet']");

    public void openPage(){
        driver.get(URL);
        wait.until(ExpectedConditions.visibilityOfElementLocated(HO_CHI_MINH_CARD));
    }
    public void clickUserDropdown(){
        WebElement iconLogo = wait.until(ExpectedConditions.elementToBeClickable(ICON_LOGO));
        iconLogo.click();
        WebElement userDropDown = wait.until(ExpectedConditions.visibilityOfElementLocated(USER_DROPDOWN));
    }
    public void selectDestination(){
        WebElement destinationBtn = wait.until(ExpectedConditions.elementToBeClickable(DESTINATION));
        destinationBtn.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(SEARCH_DESTINATION));
    }
    public void clickDateRange(){
        WebElement dateRangeBtn = wait.until(ExpectedConditions.elementToBeClickable(DATE_RANGE));
        dateRangeBtn.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(DATE_RANGE_PICKER));
    }

    public void clickAddGuest(){
        WebElement addGuestBtn = wait.until(ExpectedConditions.elementToBeClickable(ADD_GUEST));
        addGuestBtn.click();
    }
    public void increaseGuestCount(int times){
        for (int i = 0; i < times; i++) {
            WebElement addIcon = wait.until(ExpectedConditions.elementToBeClickable(ADD_ICON));
            addIcon.click();
        }
    }
    public void decreaseGuestCount(int times){
        for (int i = 0; i < times; i++) {
            WebElement minusIcon = wait.until(ExpectedConditions.elementToBeClickable(MINUS_ICON));
            minusIcon.click();
        }
    }

    public boolean isMenuBarDisplayed() {
        String[] menus = {"Home", "About", "Services", "Pricing", "Contact"};
        for (String menu : menus) {
            By locator = menuBar(menu);
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
            if (!element.isDisplayed()) {
                return false;
            }
        }
        return true;
    }
    public boolean areFilterOptionsDisplayed() {
        String[] options = {"Loại nơi ở", "Giá", "Đặt ngay", "Phòng và phòng ngủ", "Bộ lọc khác"};
        for (String option : options) {
            By locator = filterOptions(option);
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
            if (!element.isDisplayed()) {
                return false;
            }
        }
        return true;
    }
    public boolean areDestinationCardDisplayed() {
        String[] destinations = {"Hồ Chí Minh", "Hà Nội", "Đà Nẵng", "Nha Trang", "Phú Quốc"};
        for (String destination : destinations) {
            By locator = destinationCard(destination);
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            WebElement nameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(name_of_destination(destination)));
            WebElement timeElement = wait.until(ExpectedConditions.visibilityOfElementLocated(time_to_destination(destination)));
            if (!element.isDisplayed() || !nameElement.isDisplayed() || !timeElement.isDisplayed()) {
                return false;
            }
        }
        return true;
    }

    public void clickCard(String cardName){
        By cardLocator = destinationCard(cardName);
        switch (cardName) {
            case "Hồ Chí Minh":
                cardLocator = HO_CHI_MINH_CARD;
                break;
            case "Cần Thơ":
                cardLocator = CAN_THO_CARD;
                break;
            case "Nha Trang":
                cardLocator = NHA_TRANG_CARD;
                break;
            case "Hà Nội":
                cardLocator = HA_NOI_CARD;
                break;
            case "Phú Quốc":
                cardLocator = PHU_QUOC_CARD;
                break;
            case "Đà Nẵng":
                cardLocator = DA_NANG_CARD;
                break;
            case "Đà Lạt":
                cardLocator = DA_LAT_CARD;
                break;
            case "Phan Thiết":
                cardLocator = PHAN_THIET_CARD;
                break;
            default:
                throw new IllegalArgumentException("Invalid card name: " + cardName);
        }
        WebElement cardElement = wait.until(ExpectedConditions.elementToBeClickable(cardLocator));
        cardElement.click();
        String currentURL = driver.getCurrentUrl();
        Assert.assertTrue(
                currentURL.contains("/rooms/" + cardName.toLowerCase().replace(" ", "-")),
                "URL phai chua '/rooms/' va ten thanh pho sau khi click vao card " + cardName
        );

    }
}
