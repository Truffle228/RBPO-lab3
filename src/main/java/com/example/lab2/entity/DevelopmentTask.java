package com.example.lab2.entity;
public class DevelopmentTask {
    private Long id;
    private SoftwareProduct product;
    private User assignee;
    private String version;
    private String status;
    public DevelopmentTask() {}
    public DevelopmentTask(Long id, SoftwareProduct product, User assignee, String version, String status) { this.id = id; this.product = product; this.assignee = assignee; this.version = version; this.status = status; }
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public SoftwareProduct getProduct() { return product; }
    public void setProduct(SoftwareProduct product) { this.product = product; }
    public User getAssignee() { return assignee; }
    public void setAssignee(User assignee) { this.assignee = assignee; }
    public String getVersion() { return version; }
    public void setVersion(String version) { this.version = version; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
