package com.alexyaruki.sca.findbugs.pojo;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.Optional;

public class BugInstance {

    @JacksonXmlProperty(localName = "ShortMessage")
    private String shortMessage;

    @JacksonXmlProperty(localName = "LongMessage")
    private String longMessage;

    @JacksonXmlProperty(localName = "Class")
    private BugClass bugClass;

    @JacksonXmlProperty(localName = "Method")
    private BugMethod bugMethod;

    @JacksonXmlProperty(localName = "Field")
    private BugField bugField;

    @JacksonXmlProperty(isAttribute = true)
    private String category;

    @JacksonXmlProperty(isAttribute = true)
    private int priority;

    @JacksonXmlProperty(isAttribute = true)
    private int rank;

    @JacksonXmlProperty(isAttribute = true)
    private String type;

    @JacksonXmlProperty(isAttribute = true, localName = "abbrev")
    private String abbreviation;

    @JacksonXmlProperty(localName = "SourceLine")
    private SourceLine sourceLine;

    BugInstance() {
    }


    public String getShortMessage() {
        return shortMessage;
    }

    public void setShortMessage(String shortMessage) {
        this.shortMessage = shortMessage;
    }

    public String getLongMessage() {
        if(longMessage.contains("\n")) {
            longMessage = longMessage.replace("\n","");
        }
        longMessage = longMessage.replaceAll("( )+"," ").trim();
        return longMessage;
    }

    public void setLongMessage(String longMessage) {
        this.longMessage = longMessage;
    }

    public BugClass getBugClass() {
        return bugClass;
    }

    public void setBugClass(BugClass bugClass) {
        this.bugClass = bugClass;
    }

    public Optional<BugMethod> getBugMethod() {
        return Optional.ofNullable(bugMethod);
    }

    public void setBugMethod(BugMethod bugMethod) {
        this.bugMethod = bugMethod;
    }

    public Optional<BugField> getBugField() {
        return Optional.ofNullable(bugField);
    }

    public void setBugField(BugField bugField) {
        this.bugField = bugField;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public SourceLine getSourceLine() {
        return sourceLine;
    }

    public void setSourceLine(SourceLine sourceLine) {
        this.sourceLine = sourceLine;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }
}
