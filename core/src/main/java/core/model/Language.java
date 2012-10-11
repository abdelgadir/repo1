package core.model;

import core.model.enums.I18nToken;
import net.vz.mongodb.jackson.MongoCollection;

/**
 * Date: 03/09/12
 * Time: 12:31
 */
@MongoCollection(name = "languages")
public class Language extends BaseNonEmbeddableEntity implements Ii18n {
    private String languageCode;
    private String description;

    public String getLanguageCode() {
        return languageCode;
    }

    public void setLanguageCode(String languageCode) {
        this.languageCode = languageCode;
    }

    public I18nToken getI18nToken(){
        return I18nToken.i18nLanguageToken;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
