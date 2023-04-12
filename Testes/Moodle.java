package testes;

import org.junit.Test;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Moodle {

    @Test
    public void aluno() {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

        driver.get("https://moodle.utfpr.edu.br/login/index.php");

        String ra = "ra";
        String senha = "senha";

        WebElement txtFieldRa = driver.findElement(By.id("username"));
        txtFieldRa.sendKeys(ra);

        WebElement txtFieldSenha = driver.findElement(By.id("password"));
        txtFieldSenha.sendKeys(senha);

        WebElement checkboxLembrar = driver.findElement(By.id("rememberusername"));
        checkboxLembrar.click();

        WebElement botaoAcessar = driver.findElement(By.id("loginbtn"));
        botaoAcessar.click();

        WebElement menu = driver.findElement(By.id("action-menu-toggle-0"));
        menu.click();

        WebElement botaoSair = driver.findElement(By.id("actionmenuaction-6"));
        botaoSair.click();

        WebElement txtFieldRaRetorno = driver.findElement(By.id("username"));
        String retorno = txtFieldRaRetorno.getAttribute("value");

        assertEquals("O RA não foi lembrado corretamente", ra, retorno);
        driver.quit();
    }
}
