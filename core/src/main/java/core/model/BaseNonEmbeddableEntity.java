package core.model;

import org.bson.types.ObjectId;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.io.Serializable;

/**
 * Date: 03/09/12
 * Time: 12:32
 */
public abstract class BaseNonEmbeddableEntity extends BaseEntity{
    @JsonProperty("_id")
    private ObjectId id;

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }
}
