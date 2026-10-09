package com.example.lab2.entity;
import java.time.LocalDateTime;
public class Release {
    private Long id;
    private SoftwareProduct product;
    private String number;
    private String status;
    private LocalDateTime releaseDate;
    public Release() {}
    public Release(Long id, SoftwareProduct product, String number, String status, LocalDateTime releaseDate) { this.id = id; this.product = product; this.number = number; this.status = status; this.releaseDate = releaseDate; }
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public SoftwareProduct getProduct() { return product; }
    public void setProduct(SoftwareProduct product) { this.product = product; }
    public String getNumber() { return number; }
    public void setNumber(String number) { this.number = number; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public LocalDateTime getReleaseDate() { return releaseDate; }
    public void setReleaseDate(LocalDateTime releaseDate) { this.releaseDate = releaseDate; }
}
