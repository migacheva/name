package util;

import java.io.Serializable;

public class UserDocumentsStatistics implements Serializable{
    private long approved;
    private long rejected;
    private long created;
    private long onApprove;

    public long getTotal() {
        return approved + rejected + created + onApprove;
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
