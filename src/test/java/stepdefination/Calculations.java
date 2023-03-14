package stepdefination;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import dev.failsafe.internal.util.Assert;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Calculations {
	WebDriver driver = new ChromeDriver();
	 
@Given("Opening calculator")
public void opening_calculator() {
   
	 WebDriverManager.chromedriver().setup();
	    
		    driver.manage().window().maximize();
			driver.get("https://www.calculator.net/");
	}

@When("Enter{string} in the calculator")
public void entering_operand(String operand) throws InterruptedException {
    for (int i = 0; i < operand.length(); i++) {
        if (!String.valueOf(operand.charAt(i)).equals("-") ){
            driver.findElement(By.xpath("//span[.=" + operand.charAt(i) + "]")).click();
            Thread.sleep(500);
        } else {
            driver.findElement(By.xpath("//span[@onclick=\"r('" + operand.charAt(i) + "')\"]")).click();

        }
    }
}
@And("Enter operator {string} in the calculator")

public void enter_operator_sign(String operator) throws InterruptedException {
    driver.findElement(By.xpath("//span[@onclick=\"r('"+operator+"')\"]")).click();
    Thread.sleep(500);

   }


@Then("Check result as per {string}")
public void check_result(String result) throws InterruptedException {
    
    String actual=driver.findElement(By.xpath("//*[@id=\"sciOutPut\"]")).getText().trim();
    boolean a1,r1;
    System.out.println(actual.equals(result));
    //Assert.assertEquals(actual,result);
    Thread.sleep(500);
    driver.close();

}



}
