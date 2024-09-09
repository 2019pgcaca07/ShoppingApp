package com.ecommerce.shopping.model;

public class Cotegoery {
    private Long cotegoeryId;
    private String cotegoeryName;

    public Cotegoery(Long cotegoeryId, String cotegoeryName) {
        this.cotegoeryId = cotegoeryId;
        this.cotegoeryName = cotegoeryName;
    }

    public Long getCotegoeryId() {
        return cotegoeryId;
    }

    public void setCotegoeryId(Long cotegoeryId) {
        this.cotegoeryId = cotegoeryId;
    }

    public String getCotegoeryName() {
        return cotegoeryName;
    }

    public void setCotegoeryName(String cotegoeryName) {
        this.cotegoeryName = cotegoeryName;
    }

    @Override
    public String toString() {
        return "Cotegoery{" +
                "cotegoeryId=" + cotegoeryId +
                ", cotegoeryName='" + cotegoeryName + '\'' +
                '}';
    }
}
