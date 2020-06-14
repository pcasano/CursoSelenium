/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cursoselenium.library.recorder;

/**
 *
 * @author pablo
 */
public class RecorderConfiguration {
    
    private String testCaseName; 
    private int numberOfFailedTests;
    private String pathHtmlReport;

    public String getTestCaseName() {
        return testCaseName;
    }

    public void setTestCaseName(String testCaseName) {
        this.testCaseName = testCaseName;
    }

    public int getNumberOfFailedTests() {
        return numberOfFailedTests;
    }

    public void setNumberOfFailedTests(int numberOfFailedTests) {
        this.numberOfFailedTests = numberOfFailedTests;
    }

    public String getPathHtmlReport() {
        return pathHtmlReport;
    }

    public void setPathHtmlReport(String pathHtmlReport) {
        this.pathHtmlReport = pathHtmlReport;
    }
    
}
