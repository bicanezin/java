package testes;

import org.junit.Test;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.chrome.ChromeDriver;

public class Saucelabs {

    @Test
    public void preencheTextos() throws Exception {
        Boolean linkFuncionou = false;
        Boolean dadosPreenchidos = false;
        Boolean checkBox = false;
        Boolean dadosEnviados = false;
        Boolean inteiroConvertido = false;
        int clientTimeInteiro = -1;


        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

        driver.get("https://saucelabs.com/test/guinea-pig");

        WebElement textBoxPreenchido = driver.findElement(By.id("i_am_a_textbox"));
        WebElement textFieldEmail = driver.findElement(By.id("fbemail"));
        WebElement textAreaComentario = driver.findElement(By.id("comments"));
        WebElement clientTime = driver.findElement(By.id("clienttime"));
        WebElement checkboxDesmarcado = driver.findElement(By.id("unchecked_checkbox"));
        WebElement checkboxMarcado = driver.findElement(By.id("checked_checkbox"));
        WebElement botaoEnviar = driver.findElement(By.id("submit"));

        try {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            WebElement novaPagina = wait.until(ExpectedConditions.elementToBeClickable(By.id("i am a link")));

            novaPagina.findElement(By.xpath("//*[@id=\"i_am_an_id\"]"));

            linkFuncionou = true;

        } catch (Exception e) {
            System.out.println("Erro ao abrir o link");
        }

        try {
            textBoxPreenchido.clear();
            textBoxPreenchido.sendKeys("Testeeeee");

            textFieldEmail.sendKeys("teste@gmail.com");

            textAreaComentario.sendKeys("Comentário teste");

            dadosPreenchidos = true;

        } catch (Exception e) {
            System.out.println("Erro ao preencher os campos de texto");
        }

        try {
            clientTimeInteiro = Integer.parseInt(clientTime.getText());
            inteiroConvertido = true;

        } catch (Exception e) {
            System.out.println("Erro ao obter e/ou converter para inteiro");
        }

        try {
            if ((inteiroConvertido == true) && (clientTimeInteiro % 2 == 0)) {
                checkboxMarcado.click();
                checkBox = true;
            } else if ((inteiroConvertido == true) && (clientTimeInteiro % 2 != 0)) {
                checkboxDesmarcado.click();
                checkBox = true;
            } else {
                System.out.println("CheckBox não alterado");
            }
        } catch (Exception e) {
            System.out.println("Erro ao marcar/desmarcar os checkboxes");
        }

        try {
            botaoEnviar.click();
            dadosEnviados = true;

        } catch (Exception e) {
            System.out.println("Erro ao enviar os dados");
        }

        assertEquals("O link não direcionou adequadamente para a outra página", true, linkFuncionou);
        assertEquals("Os campos de texto não foram preenchidos corretamente", true, dadosPreenchidos);
        assertEquals("Os checkboxes não foram marcados/desmarcados corretamente", true, checkBox);
        assertEquals("Os dados foram enviados corretamente", true, dadosEnviados);
        driver.quit();
    }
}
