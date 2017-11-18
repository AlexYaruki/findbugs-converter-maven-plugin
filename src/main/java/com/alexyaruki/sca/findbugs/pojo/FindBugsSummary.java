package com.alexyaruki.sca.findbugs.pojo;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.List;

public class FindBugsSummary {

    private int packageCount;
    private int classCount;

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "FileStats")
    private List<FileStats> filesStats;

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "PackageStats")
    private List<PackageStats> packagesStats;

    public int getPackageCount() {
        return packageCount;
    }

    public void setPackageCount(int packageCount) {
        this.packageCount = packageCount;
    }

    public int getClassCount() {
        return classCount;
    }

    public void setClassCount(int classCount) {
        this.classCount = classCount;
    }

    public List<FileStats> getFilesStats() {
        return filesStats;
    }

    public void setFilesStats(List<FileStats> filesStats) {
        this.filesStats = filesStats;
    }

    public List<PackageStats> getPackagesStats() {
        return packagesStats;
    }

    public void setPackagesStats(List<PackageStats> packagesStats) {
        this.packagesStats = packagesStats;
    }
}
