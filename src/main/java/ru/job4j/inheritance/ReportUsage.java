package ru.job4j.inheritance;

public class ReportUsage {

    public static void main(String[] args) {
        HtmlReport htmlReport = new HtmlReport();
        TextReport report = new TextReport();
        JSONReport jsonReport = new JSONReport();
        String text = report.generate("Report's name", "Report's body");
        System.out.println(text);
        text = htmlReport.generate("Report's name", "Report's body");
        System.out.println(text);
        text = jsonReport.generate("name", "body");
        System.out.println(text);
    }
}
