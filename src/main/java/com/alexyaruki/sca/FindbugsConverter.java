package com.alexyaruki.sca;

import com.alexyaruki.sca.findbugs.pojo.BugCollection;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;
import org.apache.maven.project.MavenProject;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

@Mojo(name = "convert")
public class FindbugsConverter extends AbstractMojo {

    /**
     * Object representing current Maven project.
     */
    @Parameter(defaultValue = "${project}", readonly = true, required = true)
    protected MavenProject project;


    public void execute() throws MojoExecutionException, MojoFailureException {
        File findbugsXML = Paths.get(project.getBuild().getDirectory(), "findbugsXml.xml").toFile();
        if(!findbugsXML.exists()) {
            throw new MojoExecutionException("findbugsXML.xml not found in \"" + findbugsXML.getAbsolutePath() + "\"");
        }
        XmlMapper mapper = new XmlMapper();
        try {
            mapper.readValue(findbugsXML, BugCollection.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
