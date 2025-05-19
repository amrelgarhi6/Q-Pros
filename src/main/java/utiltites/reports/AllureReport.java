package utiltites.reports;

import utiltites.cli.CLI;

public class AllureReport {
    public static void deleteOutDatedAllureReport() {
        CLI.executeCommandLine("cd allure-results");
        CLI.executeCommandLine("DEL /S /Q *.json");
    }

    public static void generateAllureReport() {
        CLI.executeCommandLine("allure serve allure-results");
    }
}