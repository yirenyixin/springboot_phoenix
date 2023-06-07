package net.educoder.entity;

public class User {
    private String id;
    private String trueName;
    private String monitoringTime;
    private String monitoringRange;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTrueName() {
        return trueName;
    }

    public void setTrueName(String trueName) {
        this.trueName = trueName;
    }

    public String getMonitoringTime() {
        return monitoringTime;
    }

    public void setMonitoringTime(String monitoringTime) {
        this.monitoringTime = monitoringTime;
    }

    public String getMonitoringRange() {
        return monitoringRange;
    }

    public void setMonitoringRange(String monitoringRange) {
        this.monitoringRange = monitoringRange;
    }
}
