package core.model;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.io.Serializable;

/**
 * Date: 03/09/12
 * Time: 12:33
 */
@JsonSerialize(include = JsonSerialize.Inclusion.ALWAYS)
public abstract class BaseEmbeddableEntity implements Serializable {
}
