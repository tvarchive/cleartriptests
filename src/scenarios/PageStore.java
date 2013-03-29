package scenarios;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Sukeshk
 * Date: 25/03/13
 * Time: 10:04 AM
 * To change this template use File | Settings | File Templates.
 */
public class PageStore {

    WebDriver webDriver;
    List<Object> pages;

    public PageStore() {
        webDriver = new FirefoxDriver();
        pages = new ArrayList<Object>();
    }

    public <T> T get(Class<T> clazz) {
        for (Object page : pages) {
            if (page.getClass() == clazz)
                return (T) page;
        }
        T page = PageFactory.initElements(webDriver, clazz);
        pages.add(page);
        return page;
    }

    public void destroy() {
        pages.clear();
        webDriver.quit();
    }

    public WebDriver getDriver() {
        return webDriver;
    }
}
