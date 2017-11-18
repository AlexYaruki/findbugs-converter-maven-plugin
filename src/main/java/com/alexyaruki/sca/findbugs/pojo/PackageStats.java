package com.alexyaruki.sca.findbugs.pojo;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.ArrayList;
import java.util.List;

public class PackageStats {

    @JacksonXmlProperty(isAttribute = true, localName = "package")
    private String packageName;
    @JacksonXmlProperty(isAttribute = true, localName = "total_bugs")
    private int bugsCount;

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "ClassStats")
    private List<ClassStats> classesStats;

    public PackageStats() {
        classesStats = new ArrayList<>();
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public int getBugsCount() {
        return bugsCount;
    }

    public void setBugsCount(int bugsCount) {
        this.bugsCount = bugsCount;
    }

}
