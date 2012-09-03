package core.model;

import core.model.enums.I18nToken;
import org.codehaus.jackson.annotate.JsonIgnore;

/**
 * Date: 03/09/12
 * Time: 12:51
 */
public interface I18nIF {
    @JsonIgnore
    public I18nToken getI18nToken();
}
