package core.model;

import core.model.enums.I18nToken;
import net.vz.mongodb.jackson.MongoCollection;

/**
 * Date: 03/09/12
 * Time: 12:49
 */
@MongoCollection(name = "countries")
public class Country extends BaseNonEmbeddableEntity implements I18nIF{
    private String countryCode;
    private String flagImageFilePath;
    private String description;

    public Country(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getFlagImageFilePath() {
        return flagImageFilePath;
    }

    public void setFlagImageFilePath(String flagImageFilePath) {
        this.flagImageFilePath = flagImageFilePath;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public I18nToken getI18nToken() {
        return I18nToken.i18nCountryToken;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
