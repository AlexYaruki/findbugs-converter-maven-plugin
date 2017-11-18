package com.alexyaruki.sca.findbugs.pojo;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class BugClass {

    @JacksonXmlProperty(localName = "classname", isAttribute = true)
    private String name;

    @JacksonXmlProperty(localName = "SourceLine")
    private SourceLine sourceLine;

    @JacksonXmlProperty(isAttribute = true)
    private boolean primary;

    @JacksonXmlProperty(localName = "Message")
    private String message;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SourceLine getSourceLine() {
        return sourceLine;
    }

    public void setSourceLine(SourceLine sourceLine) {
        this.sourceLine = sourceLine;
    }

    public boolean isPrimary() {
        return primary;
    }

    public void setPrimary(boolean primary) {
        this.primary = primary;
    }

    public String getMessage() {
        if(message.contains("\n")) {
            message = message.replace("\n", " ");
        }
        message = message.replaceAll("( )+"," ");
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
