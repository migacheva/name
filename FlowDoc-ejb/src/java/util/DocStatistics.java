package util;

import java.io.Serializable;

public class DocStatistics implements Serializable{
    private long total;
    private long approved;
    private long rejected;
    private long created;
    private long onApprove;

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
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

    public long getCreated() {
        return created;
    }

    public void setCreated(long created) {
        this.created = created;
    }

    public long getOnApprove() {
        return onApprove;
    }

    public void setOnApprove(long onApprove) {
        this.onApprove = onApprove;
    }
}
