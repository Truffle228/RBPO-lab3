package com.example.lab2.entity;
import java.time.LocalDateTime;
public class ReleaseCheck {
    private Long id;
    private Release release;
    private String checkName;
    private boolean mandatory;
    private String result;
    private LocalDateTime checkedAt;
    public ReleaseCheck() {}
    public ReleaseCheck(Long id, Release release, String checkName, boolean mandatory, String result, LocalDateTime checkedAt) { this.id = id; this.release = release; this.checkName = checkName; this.mandatory = mandatory; this.result = result; this.checkedAt = checkedAt; }
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Release getRelease() { return release; }
    public void setRelease(Release release) { this.release = release; }
    public String getCheckName() { return checkName; }
    public void setCheckName(String checkName) { this.checkName = checkName; }
    public boolean isMandatory() { return mandatory; }
    public void setMandatory(boolean mandatory) { this.mandatory = mandatory; }
    public String getResult() { return result; }
    public void setResult(String result) { this.result = result; }
    public LocalDateTime getCheckedAt() { return checkedAt; }
    public void setCheckedAt(LocalDateTime checkedAt) { this.checkedAt = checkedAt; }
}
