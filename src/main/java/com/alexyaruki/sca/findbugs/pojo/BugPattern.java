package com.alexyaruki.sca.findbugs.pojo;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class BugPattern {

    @JacksonXmlProperty(isAttribute = true, localName = "abbrev")
    private String abbrevation;
    @JacksonXmlProperty(isAttribute = true)
    private String category;
    @JacksonXmlProperty(isAttribute = true)
    private String type;

    @JacksonXmlProperty(localName = "ShortDescription")
    private String shortDescription;

    @JacksonXmlProperty(localName = "Details")
    private String details;

    public String getAbbrevation() {
        return abbrevation;
    }

    public void setAbbrevation(String abbrevation) {
        this.abbrevation = abbrevation;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
