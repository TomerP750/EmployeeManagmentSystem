package app.emsserverside.Security;

import java.sql.Date;

public class TokenProperties {
    private Date lastUpdated;

    public TokenProperties(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
}
