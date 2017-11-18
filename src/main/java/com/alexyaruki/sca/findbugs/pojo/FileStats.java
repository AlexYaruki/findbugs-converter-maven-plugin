package com.alexyaruki.sca.findbugs.pojo;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class FileStats {

    @JacksonXmlProperty(isAttribute = true)
    private String path;

    @JacksonXmlProperty(isAttribute = true)
    private int size;

    @JacksonXmlProperty(isAttribute = true)
    private int bugCount;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getBugsCount() {
        return bugCount;
    }

    public void setBugCount(int bugCount) {
        this.bugCount = bugCount;
    }
}
