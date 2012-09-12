package core.model;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.io.Serializable;

/**
 * Date: 12/09/12
 * Time: 12:42
 */
@JsonSerialize(include = JsonSerialize.Inclusion.ALWAYS)
public class BaseEntity implements Serializable {
}
