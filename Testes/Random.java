package testes;

import org.junit.Test;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.chrome.ChromeDriver;

public class Random {

    public final int TAM = 5;

    @Test
    public void sorteiaNumeros() throws Exception {
        int[] sorteados = new int[TAM];
        boolean verificaNumero2 = false;
        boolean verificaNumeroPar = false;
        boolean verificaNumeroSorteadoMaisDeUmaVez = false;


        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

        driver.get("https://www.random.org/widgets/integers/iframe");

        WebElement valorMinimo = driver.findElement(By.id("true-random-integer-generator-min"));
        valorMinimo.sendKeys("2");

        WebElement valorMaximo = driver.findElement(By.id("true-random-integer-generator-max"));
        valorMaximo.sendKeys("10");

        WebElement gerarNumero = driver.findElement(By.id("true-random-integer-generator-button"));

        WebElement resultado = driver.findElement(By.id("true-random-integer-generator-result"));

        for (int i = 0; i < TAM; i++) {
            gerarNumero.click();

            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(new ExpectedCondition<Boolean>() {
                @Override
                public Boolean apply(WebDriver numeroGerado) {
                    Boolean gerado = false;
                    try {
                        int tentaConverter = Integer.parseInt(resultado.getText());
                        gerado = true;
                    } catch (Exception e) {

                    }
                    return gerado;
                }
            });

            try {
                int resultadoInteiro = Integer.parseInt(resultado.getText());

                sorteados[i] = resultadoInteiro;
            } catch (Exception e) {
                System.out.println("Erro na conversão!");
            }
        }
        Arrays.sort(sorteados);

        for (int i = 0; i < TAM; i++) {
            if (sorteados[i] == 2) {
                verificaNumero2 = true;
                break;
            }
        }

        for (int i = 0; i < TAM; i++) {
            if (sorteados[i] % 2 == 0) {
                verificaNumeroPar = true;
                break;
            }
        }

        for (int i = 0; i < TAM; i++) {
            if (i + 1 < TAM && sorteados[i] == sorteados[i + 1]) {
                verificaNumeroSorteadoMaisDeUmaVez = true;
                break;
            }
        }

        assertEquals("O número 2 não foi sorteado", true, verificaNumero2);
        assertEquals("Nenhum número par foi sorteado", true, verificaNumeroPar);
        assertEquals("Nenhum número foi sorteado mais de uma vez", true, verificaNumeroSorteadoMaisDeUmaVez);
        driver.quit();
    }
}
