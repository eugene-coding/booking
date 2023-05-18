import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.LoadableComponent;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.junit.jupiter.api.Assertions.fail;

/**
 * Represents a search result page
 */
public class SearchResultPage extends LoadableComponent<SearchResultPage> {
    private final SelenideElement openMapButton = $("div[data-testid='map-trigger']");
    private final SelenideElement mapWithList = $(By.className("map_with_list__container"));

    public void openMap() {
        openMapButton.click();
        mapWithList.should(visible);
    }

    @Override
    protected void load() {

    }

    @Override
    protected void isLoaded() throws Error {
        try {
            if (!url().contains("booking.com/searchresults")) {
                fail();
            }
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
            fail();
        }

        try {
            openMapButton.should(visible);
        } catch (TimeoutException e) {
            System.out.println(e.getMessage());
            fail();
        }
    }
}
