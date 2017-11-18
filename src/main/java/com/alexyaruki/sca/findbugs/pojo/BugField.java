package com.alexyaruki.sca.findbugs.pojo;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class BugField {

    @JacksonXmlProperty(isAttribute = true)
    private boolean isStatic;

    @JacksonXmlProperty(localName = "classname", isAttribute = true)
    private String className;

    @JacksonXmlProperty(isAttribute = true)
    private String signature;

    @JacksonXmlProperty(isAttribute = true)
    private String name;

    @JacksonXmlProperty(localName = "SourceLine")
    private SourceLine sourceLine;

    @JacksonXmlProperty(localName = "Message")
    private String message;

    public boolean isStatic() {
        return isStatic;
    }

    public void setStatic(boolean aStatic) {
        isStatic = aStatic;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

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
