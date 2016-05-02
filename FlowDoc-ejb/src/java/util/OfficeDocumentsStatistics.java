package util;

public class OfficeDocumentsStatistics {
    private String officeName;
    private long approved;
    private long rejected;
    private long onApprove;

    public String getOfficeName() {
        return officeName;
    }

    public void setOfficeName(String officeName) {
        this.officeName = officeName;
    }

    public long getApproved() {
        return approved;
    }

    public void setApproved(long approved) {
        this.approved = approved;
    }

    public long getRejected() {
        return rejected;
    }

    public void setRejected(long rejected) {
        this.rejected = rejected;
    }

    public long getOnApprove() {
        return onApprove;
    }

    public void setOnApprove(long onApprove) {
        this.onApprove = onApprove;
    }
}
