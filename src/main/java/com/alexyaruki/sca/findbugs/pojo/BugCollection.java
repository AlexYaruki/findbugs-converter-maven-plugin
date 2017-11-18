package com.alexyaruki.sca.findbugs.pojo;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.ArrayList;
import java.util.List;

@JacksonXmlRootElement
public class BugCollection {

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "BugInstance")
    private List<BugInstance> bugs;

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "BugPattern")
    private List<BugPattern> patterns;

    @JacksonXmlElementWrapper(useWrapping = false)
    @JacksonXmlProperty(localName = "BugCode")
    private List<BugCode> codes;

    @JacksonXmlProperty(localName = "FindBugsSummary")
    private FindBugsSummary findBugsSummary;

    public BugCollection() {
        bugs = new ArrayList<>();
    }

    public List<BugInstance> getBugs() {
        return bugs;
    }

    public void setBugs(List<BugInstance> bugs) {
        this.bugs = bugs;
    }

    public List<BugPattern> getPatterns() {
        return patterns;
    }

    public void setPatterns(List<BugPattern> patterns) {
        this.patterns = patterns;
    }

    public List<BugCode> getCodes() {
        return codes;
    }

    public void setCodes(List<BugCode> codes) {
        this.codes = codes;
    }

    public FindBugsSummary getFindBugsSummary() {
        return findBugsSummary;
    }

    public void setFindBugsSummary(FindBugsSummary findBugsSummary) {
        this.findBugsSummary = findBugsSummary;
    }
}
