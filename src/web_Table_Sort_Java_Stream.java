import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;

public class web_Table_Sort_Java_Stream {

    public static void main(String[] args) {

        // Launch Chrome Browser
        WebDriver driver = new ChromeDriver();

        // Open website
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

        // Click on first column header for sorting
        driver.findElement(By.xpath("//tr/th[1]")).click();

        // Capture all veggie names from first column
        List<WebElement> elementList =
                driver.findElements(By.xpath("//tr/td[1]"));

        // Store veggie names into original list
        List<String> originalList =
                elementList.stream()
                        .map(WebElement::getText)
                        .collect(Collectors.toList());

        // Create sorted list using Java Streams
        List<String> sortedList =
                originalList.stream()
                        .sorted()
                        .collect(Collectors.toList());

        // Compare UI sorting with Java sorting
        Assert.assertEquals(originalList, sortedList);

        // Print success message
        System.out.println("Table sorting validated successfully");

        // Get price of Rice
        List<String> price;

        do {

            // Capture all veggie names again after page refresh
            elementList =
                    driver.findElements(By.xpath("//tr/td[1]"));

            // Filter Rice and get price
            price = elementList.stream()
                    .filter(s -> s.getText().contains("Rice"))
                    .map(s -> getPriceVeggie(s))
                    .collect(Collectors.toList());

            // If Rice not found, click Next button
            if (price.size() < 1) {

                driver.findElement(By.cssSelector("[aria-label='Next']")).click();
            }

        } while (price.size() < 1);

        // Print Rice price
        price.forEach(a -> System.out.println(a));

        // Close browser
        //driver.quit();


        driver.findElement(By.xpath("//input[@id='search-field']")).click();
        driver.findElement(By.xpath("//input[@id='search-field']")).sendKeys("Rice");

        List<WebElement> veggies = driver.findElements(By.xpath("//tr//td[1]"));

        List<WebElement> filteredVeggies = veggies.stream()
                .filter(veggie -> veggie.getText().contains("Rice"))
                .collect(Collectors.toList());

    }

    // Method to fetch price from next column
    private static String getPriceVeggie(WebElement s) {

        // Get price text
        String pricevalue =
                s.findElement(By.xpath("following-sibling::td[1]")).getText();

        // Return price
        return pricevalue;
    }




}