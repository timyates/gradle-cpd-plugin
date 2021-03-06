package de.aaschmid.gradle.plugins.cpd.internal;

import de.aaschmid.gradle.plugins.cpd.Cpd;
import de.aaschmid.gradle.plugins.cpd.CpdCsvFileReport;
import de.aaschmid.gradle.plugins.cpd.CpdReports;
import de.aaschmid.gradle.plugins.cpd.CpdTextFileReport;
import de.aaschmid.gradle.plugins.cpd.CpdXmlFileReport;
import org.gradle.api.reporting.SingleFileReport;
import org.gradle.api.reporting.internal.TaskReportContainer;

class CpdReportsImpl extends TaskReportContainer<SingleFileReport> implements CpdReports {

    CpdReportsImpl(Cpd task) {
        super(SingleFileReport.class, task);

        add(CpdCsvFileReportImpl.class, "csv", task);
        add(CpdTextFileReportImpl.class, "text", task);
        add(CpdXmlFileReportImpl.class, "xml", task);
    }

    @Override
    CpdCsvFileReport getCsv() {
        return (CpdCsvFileReport) getByName("csv");
    }

    @Override
    CpdTextFileReport getText() {
        return (CpdTextFileReport) getByName("text");
    }

    @Override
    CpdXmlFileReport getXml() {
        return (CpdXmlFileReport) getByName("xml");
    }
}
