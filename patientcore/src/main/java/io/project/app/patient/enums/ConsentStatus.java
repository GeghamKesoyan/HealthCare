package io.project.app.patient.enums;

/**
 *
 * @author lilith
 */
public enum ConsentStatus {

    draft("draft", "draft"),
    proposed("proposed", "proposed"),
    active("active", "active"),
    rejected("rejected", "rejected"),
    inactive("inactive", "inactive");
   
    private final String key;
    private final String value;

    ConsentStatus(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

}
