package com.alexyaruki.sca.findbugs.pojo;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class ClassStats {

    @JacksonXmlProperty(isAttribute = true)
    private String className;

    @JacksonXmlProperty(isAttribute = true)
    private String sourceFile;

    @JacksonXmlProperty(isAttribute = true)
    private int size;

    @JacksonXmlProperty(isAttribute = true)
    private int bugs;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getSourceFile() {
        return sourceFile;
    }

    public void setSourceFile(String sourceFile) {
        this.sourceFile = sourceFile;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getBugs() {
        return bugs;
    }

    public void setBugs(int bugs) {
        this.bugs = bugs;
    }
}
