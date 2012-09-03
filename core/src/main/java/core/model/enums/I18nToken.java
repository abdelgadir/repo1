package core.model.enums;

/**
 * Date: 03/09/12
 * Time: 12:44
 */
public enum I18nToken {
    i18nLanguageToken("i18nLanguageToken"),
    i18nCountryToken("i18nCountryToken");

    private String token;
    private I18nToken(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}
