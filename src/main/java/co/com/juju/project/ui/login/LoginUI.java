package co.com.juju.project.ui.login;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginUI extends PageObject {

    /*
    Mapeo de localozadores vista LOGIN
    Los comentarios de cada localizador se deben dejar en español, para el tema de los reportes
    esto depende de nuestro cliente
     */

    public static final Target INPUT_USER_NAME = Target.the("ingresa el nombre de usuario")
            .located(By.id("userName"));

    public static final Target INPUT_PASSWORD = Target.the("ingresa la contraseña")
            .located(By.id("password"));

    public static final Target BUTTON_LOGIN = Target.the("pulsa el boton entrar")
            .located(By.xpath("//*[@class='btn second-btn form-login__btn']"));

    public static final Target TXT_FAILD_CREDENTIALS = Target.the("error!!! usuario o contraseña incorrectos")
            .located(By.xpath("//div//p[@class='first-body' and contains(text(),' Usuario o contraseña incorrectos. ')]"));

}