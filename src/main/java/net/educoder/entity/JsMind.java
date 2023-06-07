package net.educoder.entity;

public class JsMind {
    private String id;
    private String isroot;
    private String parentid;
    private String topic;

    public JsMind() {
    }

    public JsMind(String id, String isroot, String parentid, String topic) {
        this.id = id;
        this.isroot = isroot;
        this.parentid = parentid;
        this.topic = topic;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIsroot() {
        return isroot;
    }

    public void setIsroot(String isroot) {
        this.isroot = isroot;
    }

    public String getParentid() {
        return parentid;
    }

    public void setParentid(String parentid) {
        this.parentid = parentid;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }
}
