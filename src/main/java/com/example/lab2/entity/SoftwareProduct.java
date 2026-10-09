package com.example.lab2.entity;
public class SoftwareProduct {
    private Long id;
    private String name;
    private User responsible;
    private Release currentVersion;
    public SoftwareProduct() {}
    public SoftwareProduct(Long id, String name, User responsible, Release currentVersion) { this.id = id; this.name = name; this.responsible = responsible; this.currentVersion = currentVersion; }
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public User getResponsible() { return responsible; }
    public void setResponsible(User responsible) { this.responsible = responsible; }
    public Release getCurrentVersion() { return currentVersion; }
    public void setCurrentVersion(Release currentVersion) { this.currentVersion = currentVersion; }
}
