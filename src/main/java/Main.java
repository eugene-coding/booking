import com.codeborne.selenide.Configuration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args) throws InterruptedException {
//        WebDriver driver = new ChromeDriver();

       // IndexPage indexPage = new IndexPage(driver);
        Configuration.holdBrowserOpen=true;
        IndexPage indexPage = new IndexPage();

        indexPage.get();
        var searchResultPage = indexPage.fillForm("Вашингтон");
        searchResultPage.openMap();
    }
}
