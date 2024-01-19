package co.com.juju.project.questions.login;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.thucydides.core.annotations.Step;

import static co.com.juju.project.ui.login.LoginUI.TXT_FAILD_CREDENTIALS;


@AllArgsConstructor
@Slf4j
public class ValidateErrorCredentials implements Question<Boolean> {

    private final String errorText;

    @Override
    @Step("{0} valida el texto #errorText")
    public Boolean answeredBy(Actor actor) {
        boolean result;
        String txtValidate = TXT_FAILD_CREDENTIALS.resolveFor(actor).getText();
        if (txtValidate != null && txtValidate.equals(errorText)) {
            log.info(txtValidate);
            result = true;
        } else {
            result = false;
        }
        return result;
    }

    public static ValidateErrorCredentials faild(String errorText) {
        return new ValidateErrorCredentials(errorText);
    }
}