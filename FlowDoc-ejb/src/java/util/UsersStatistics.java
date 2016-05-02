package util;

public class UsersStatistics {

    private long adminsCount;
    private long aproversCount;
    private long usersCount;

    public long getAdminsCount() {
        return adminsCount;
    }

    public void setAdminsCount(long adminsCount) {
        this.adminsCount = adminsCount;
    }

    public long getAproversCount() {
        return aproversCount;
    }

    public void setAproversCount(long aproversCount) {
        this.aproversCount = aproversCount;
    }

    public long getUsersCount() {
        return usersCount;
    }

    public void setUsersCount(long usersCount) {
        this.usersCount = usersCount;
    }
    
    public long  getTotal() {
        return adminsCount + aproversCount + usersCount;
    }
}
