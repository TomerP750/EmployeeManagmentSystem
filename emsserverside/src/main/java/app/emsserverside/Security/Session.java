package app.emsserverside.Security;

import java.sql.Date;

public class Session {
    private Date lastUpdated;

    public Session(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
}
