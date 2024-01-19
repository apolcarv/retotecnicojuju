package co.com.juju.project.questions.login;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.thucydides.core.annotations.Step;

import static co.com.juju.project.ui.login.HomeUI.TXT_USER;

@AllArgsConstructor
@Slf4j
public class ValidateTxtHome implements Question<Boolean> {

    private final String confirmText;

    @Override
    @Step("{0} valida el texto #confirmText")
    public Boolean answeredBy(Actor actor) {
        boolean result;
        String txtValidate = TXT_USER.resolveFor(actor).getText();
        if (txtValidate != null && txtValidate.equals(confirmText)) {
            log.info(txtValidate);
            result = true;
        } else {
            result = false;
        }
        return result;

    }

    public static ValidateTxtHome success(String confirmText) {
        return new ValidateTxtHome(confirmText);
    }
}