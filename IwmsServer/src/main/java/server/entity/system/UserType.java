package server.entity.system;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class UserType {
    @Id
    private String id;
    private String type;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
