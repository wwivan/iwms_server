package server.entity.system;

import lombok.Data;

@Data
public class FactoryUserTypeMap {
    private String fid;
    private String utid;

    public String getFid() {
        return fid;
    }

    public void setFid(String fid) {
        this.fid = fid;
    }

    public String getUtid() {
        return utid;
    }

    public void setUtid(String utid) {
        this.utid = utid;
    }
}
