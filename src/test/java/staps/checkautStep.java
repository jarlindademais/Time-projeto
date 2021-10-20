package staps;
import org.junit.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.cucumber.java.After;

public class checkautStep {

    WebDriver driver;
    WebDriverWait wait;
    @Before
    public void setup(){

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\enild\\Documents\\Chrome Driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 5);
    }
    @Dado("que o usuario faca login e entre na tela de checkout")
    public void que_o_usuario_faca_login_e_entre_na_tela_de_checkout() {
        String url = "https://www.saucedemo.com/";
        driver.get(url);
        driver.findElement(By.name("user-name")).sendKeys("standard_user");
        driver.findElement(By.name("password")).sendKeys("secret_sauce");
        driver.findElement(By.name("login-button")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.className("shopping_cart_link")));
        driver.findElement(By.className("shopping_cart_link")).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.name("checkout")));
        driver.findElement(By.name("checkout")).click();


}
    @Quando("preenche os campos firstname {string} e lastname {string}")
    public void preenche_os_campos_firstname_e_lastname(String name, String lastName) {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div/div[2]/div/form/div[1]/div[1]/input")));
        driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/form/div[1]/div[1]/input")).sendKeys(name);
        driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/form/div[1]/div[2]/input")).sendKeys(lastName);
    }
    @E("preenche o campo postalcode {string}")
    public void preenche_o_campo_postalcode(String pCode) {
        driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/form/div[1]/div[3]/input")).sendKeys(pCode);
}
    @E("clica no botao Checkout")
    public void clica_no_botao_checkout() {
        driver.findElement(By.name("continue")).click();
    }
    @Entao("deve se ver {string}")
    public void deve_se_ver(String tipoCenario) {

        if (tipoCenario.equals("lastName vazio")) {
            String lastNameVazio = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/form/div[1]/div[4]/h3")).getText();
            Assert.assertEquals("Error: Last Name is required", lastNameVazio);
        }
        if (tipoCenario.equals("pCode vazio")) {
            String pCodeVazio = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/form/div[1]/div[4]/h3")).getText();
            Assert.assertEquals("Error: Postal Code is required", pCodeVazio);

        }


        }

    }

