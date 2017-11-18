package com.alexyaruki.sca.findbugs.pojo;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class SourceLine {

    @JacksonXmlProperty(localName = "classname", isAttribute = true)
    private String className;

    @JacksonXmlProperty(isAttribute = true)
    private int start;

    @JacksonXmlProperty(isAttribute = true)
    private int end;

    @JacksonXmlProperty(localName = "sourcepath", isAttribute = true)
    private String sourcePath;

    @JacksonXmlProperty(localName = "sourcefile", isAttribute = true)
    private String soureFile;

    @JacksonXmlProperty(isAttribute = true)
    private int startBytecode;

    @JacksonXmlProperty(localName = "message")
    private String message;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public String getSourcePath() {
        return sourcePath;
    }

    public void setSourcePath(String sourcePath) {
        this.sourcePath = sourcePath;
    }

    public String getSoureFile() {
        return soureFile;
    }

    public void setSoureFile(String soureFile) {
        this.soureFile = soureFile;
    }

    public int getStartBytecode() {
        return startBytecode;
    }

    public void setStartBytecode(int startBytecode) {
        this.startBytecode = startBytecode;
    }
}
