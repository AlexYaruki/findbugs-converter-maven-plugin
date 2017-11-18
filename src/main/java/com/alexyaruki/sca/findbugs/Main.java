package com.alexyaruki.sca.findbugs;

import com.alexyaruki.sca.findbugs.pojo.BugCollection;
import com.alexyaruki.sca.findbugs.pojo.BugInstance;
import com.alexyaruki.sca.findbugs.pojo.FileStats;
import com.alexyaruki.sca.findbugs.pojo.FindBugsSummary;
import com.alexyaruki.sca.findbugs.pojo.PackageStats;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    public static void main(String[] args) throws ParserConfigurationException {
        File findbugsXML = Paths.get("findbugsXml.xml").toFile();
        if (!findbugsXML.exists()) {
            System.out.println("File not found");
        }

        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        xmlMapper.registerModule(new Jdk8Module());
        BugCollection bugCollection = null;
        try {
            bugCollection = xmlMapper.readValue(findbugsXML, BugCollection.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        convertToExcel(bugCollection);

    }

    private static void convertToExcel(BugCollection bugCollection) {
        XSSFWorkbook workbook = new XSSFWorkbook();
        fillSummaries(workbook,bugCollection.getFindBugsSummary());
        XSSFSheet bugs = workbook.createSheet("Bugs");
        fillBugs(bugs,bugCollection);
        try (FileOutputStream outputStream = new FileOutputStream("findbugs.xlsx")) {
            workbook.write(outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void fillSummaries(XSSFWorkbook workbook, FindBugsSummary findBugsSummary) {
        XSSFSheet packageSummarySheet = workbook.createSheet("Package Summary");
        fillPackageSummary(packageSummarySheet,findBugsSummary.getPackagesStats());
        XSSFSheet fileSummarySheet = workbook.createSheet("File Summary");
        fillFileSummary(fileSummarySheet,findBugsSummary.getFilesStats());
    }

    private static void fillFileSummary(XSSFSheet fileSummarySheet, List<FileStats> filesStats) {
        XSSFRow header = fileSummarySheet.createRow(0);
        header.createCell(0).setCellValue("File");
        header.createCell(1).setCellValue("Bug count");
        AtomicInteger counter = new AtomicInteger(1);
        filesStats.forEach((fileStats -> {
            XSSFRow row = fileSummarySheet.createRow(counter.getAndIncrement());
            row.createCell(0).setCellValue(fileStats.getPath());
            row.createCell(1).setCellValue(fileStats.getBugsCount());
        }));
    }

    private static void fillPackageSummary(XSSFSheet packageSummarySheet, List<PackageStats> packagesStats) {
        XSSFRow header = packageSummarySheet.createRow(0);
        header.createCell(0).setCellValue("Package");
        header.createCell(1).setCellValue("Bug count");
        AtomicInteger counter = new AtomicInteger(1);
        packagesStats.forEach((packageStats -> {
            XSSFRow row = packageSummarySheet.createRow(counter.getAndIncrement());
            row.createCell(0).setCellValue(packageStats.getPackageName());
            row.createCell(1).setCellValue(packageStats.getBugsCount());
        }));
        packageSummarySheet.autoSizeColumn(0);
        packageSummarySheet.autoSizeColumn(1);
    }

    private static void fillBugs(XSSFSheet bugsSheet, BugCollection bugCollection) {
        XSSFRow header = bugsSheet.createRow(0);
        header.createCell(0).setCellValue("Path");
        header.createCell(1).setCellValue("Line");
        header.createCell(2).setCellValue("Category");
        header.createCell(3).setCellValue("Description");
        header.createCell(4).setCellValue("Note");
        List<BugInstance> bugs = bugCollection.getBugs();
        AtomicInteger counter = new AtomicInteger(1);
        bugs.forEach((bug) -> {
            XSSFRow row = bugsSheet.createRow(counter.getAndIncrement());
            row.createCell(0).setCellValue(bug.getSourceLine().getSourcePath());
            row.createCell(1).setCellValue(bug.getSourceLine().getStart());
            row.createCell(2).setCellValue(bug.getCategory());
            bugCollection
                .getCodes()
                .stream()
                .filter((code) -> code.getAbbreviation().equals(bug.getAbbreviation()))
                .findFirst()
                .ifPresent((code) -> {
                    row.createCell(3).setCellValue(code.getDescription());
                });
            row.createCell(4).setCellValue(bug.getLongMessage());
        });
        bugsSheet.autoSizeColumn(0);
        bugsSheet.autoSizeColumn(1);
        bugsSheet.autoSizeColumn(2);
        bugsSheet.autoSizeColumn(3);
        bugsSheet.autoSizeColumn(4);
    }

}
