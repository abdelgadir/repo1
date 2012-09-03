package core.model;

/**
 * Date: 03/09/12
 * Time: 12:39
 */
public class BaseIdentifiableEmbeddableEntity extends BaseEmbeddableEntity{
    private String guid;

    public BaseIdentifiableEmbeddableEntity(String guid) {
        this.guid = guid;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }
}
