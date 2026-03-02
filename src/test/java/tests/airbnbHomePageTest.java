package tests;

import io.qameta.allure.Allure;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;
import pages.airbnbHomePage;

@Epic("Auth")
@Feature("Airbnb Home Page")

public class airbnbHomePageTest extends BasePageTest {
    @Test(description = "Validate Airbnb Home Page")
    public void validateMenuBar() throws InterruptedException {
        airbnbHomePage airbnb= new airbnbHomePage(driver, wait);
        Allure.step("Open Airbnb Home Page", () -> {;
            airbnb.openPage();
            Thread.sleep(5000);
        });
        Allure.step("Doi xuat hien Menu bar", () -> {
            boolean isMenuBarVisible = airbnb.isMenuBarDisplayed();
            if (!isMenuBarVisible) {
                throw new AssertionError("Menu bar is not displayed");
            }
        });

        Allure.step("Filter options are visible", () -> {
            boolean areFilterOptionsVisible = airbnb.areFilterOptionsDisplayed();
            if (!areFilterOptionsVisible) {
                throw new AssertionError("Filter options are not displayed");
            }
        });
        Allure.step("Destination cards are visible",() -> {
            boolean areDestinationCardsVisible = airbnb.areDestinationCardDisplayed();
            if (!areDestinationCardsVisible) {
                throw new AssertionError("Destination cards are not displayed");
            }
        });

    }
//    @Test(description = "Validate Airbnb Home Page")
//    public void testDestinationCards() throws InterruptedException {
//        airbnbHomePage airbnb= new airbnbHomePage(driver, wait);
//        Allure.step("Open Airbnb Home Page", () -> {;
//            airbnb.openPage();
//        });
//        Allure.step("Doi xuat hien Menu bar", airbnb::isMenuBarDisplayed);
//
//
//    }

}
