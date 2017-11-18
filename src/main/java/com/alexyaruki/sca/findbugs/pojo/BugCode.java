package com.alexyaruki.sca.findbugs.pojo;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class BugCode {

    @JacksonXmlProperty(localName = "abbrev", isAttribute = true)
    private String abbreviation;
    @JacksonXmlProperty(localName = "Description")
    private String description;

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
