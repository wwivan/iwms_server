package server.entity.material;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Data
public class MaterialCategory {
    @Id
    private String id;
    private String code;// 编码
    private String fid;// 所属工厂
    private String name;// 名称
    private MaterialCategory parent;// 上级类型
    private String status;// 状态 0：禁止 1：正常
    private Date createTime;// 创建时间
    private Date lastTime;// 更新时间
    private Long taxRate;//税率

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getFid() {
        return fid;
    }

    public void setFid(String fid) {
        this.fid = fid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MaterialCategory getParent() {
        return parent;
    }

    public void setParent(MaterialCategory parent) {
        this.parent = parent;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastTime() {
        return lastTime;
    }

    public void setLastTime(Date lastTime) {
        this.lastTime = lastTime;
    }

    public Long getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(Long taxRate) {
        this.taxRate = taxRate;
    }
}
