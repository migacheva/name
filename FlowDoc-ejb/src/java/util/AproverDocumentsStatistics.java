package util;

import java.util.ArrayList;
import java.util.List;

public class AproverDocumentsStatistics {
    List<OfficeDocumentsStatistics> officeDocumentsStatistics;

    public List<OfficeDocumentsStatistics> getOfficeDocumentsStatistics() {
        return officeDocumentsStatistics;
    }

    public AproverDocumentsStatistics() {
        officeDocumentsStatistics = new ArrayList<>();
    }
    
    public void addDocumentsStatistics(OfficeDocumentsStatistics officeDocumentsStatistics) {
        this.officeDocumentsStatistics.add(officeDocumentsStatistics);
    }
}