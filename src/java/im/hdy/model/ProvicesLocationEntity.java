package im.hdy.model;

import javax.persistence.*;

/**
 * Created by hdy on 2017/7/3.
 */
@Entity
@Table(name = "PROVICES_LOCATION", schema = "campus_travle", catalog = "")
public class ProvicesLocationEntity {
    private long id;
    private long pid;
    private String name;
    private int type;

    @Id
    @Column(name = "id", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "pid", nullable = false)
    public long getPid() {
        return pid;
    }

    public void setPid(long pid) {
        this.pid = pid;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 100)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "type", nullable = false)
    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProvicesLocationEntity that = (ProvicesLocationEntity) o;

        if (id != that.id) return false;
        if (pid != that.pid) return false;
        if (type != that.type) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (int) (pid ^ (pid >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + type;
        return result;
    }
}
