package co.com.juju.project.ui.login;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class HomeUI extends PageObject {

    /*
    Mapeo de localozadores vista HOME
    Los comentarios de cada localizador se deben dejar en español, para el tema de los reportes
    esto depende de nuestro cliente
    */

    public static final Target TXT_USER = Target.the("valida que este la vista del home")
            .located(By.xpath("//*[@class='name-menu']//span[contains(text(),'User')]"));

    public static final Target BUTTON_CLOSE_SESSION = Target.the("cierra la session")
            .located(By.xpath("//*[@class='icon-close-s']"));

}