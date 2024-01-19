package co.com.juju.project.ui.catalog;

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

    public static final Target BUTTON_CATALOG = Target.the("boton de catálogo")
            .located(By.xpath("//*[@id='nav-m-c']/li[2]/a"));

    public static final Target TXT_VALIDATE_VIEW_CATALOG = Target.the("texto productos destacados")
            .located(By.xpath("//app-product-carousel/div[1]/div/h2"));

    /* Este elemento BUTTON_CARRUSEL se dejo parametrizado **/
    public static final Target BUTTON_CARRUSEL = Target.the("boton carrusel")
            .locatedBy("//div[2]/mat-card/carousel/div/a[{0}]/span[1]");

}