package pojoClasses;

public class Board {
    private String id;
    private String name;
    private String desc;
    private boolean closed;
    private String idOrganization;
    private Object idEnterprise;
    private boolean pinned;
    private String url;
    private String shortUrl;
    private Prefs prefs;
    private LabelNames labelNames;

    public Board() {
    }

    public Board(String name, String desc, String idOrganization ) {

        this.name = name;
        this.desc = desc;
        this.idOrganization = idOrganization;
    }
    // Getters
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public boolean isClosed() {
        return closed;
    }

    public String getIdOrganization() {
        return idOrganization;
    }

    public Object getIdEnterprise() {
        return idEnterprise;
    }

    public boolean isPinned() {
        return pinned;
    }

    public String getUrl() {
        return url;
    }

    public String getShortUrl() {
        return shortUrl;
    }

    public Prefs getPrefs() {
        return prefs;
    }

    public LabelNames getLabelNames() {
        return labelNames;
    }

    // Setters
    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setClosed(boolean closed) {
        this.closed = closed;
    }

    public void setIdOrganization(String idOrganization) {
        this.idOrganization = idOrganization;
    }

    public void setIdEnterprise(Object idEnterprise) {
        this.idEnterprise = idEnterprise;
    }

    public void setPinned(boolean pinned) {
        this.pinned = pinned;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
    }

    public void setPrefs(Prefs prefs) {
        this.prefs = prefs;
    }

    public void setLabelNames(LabelNames labelNames) {
        this.labelNames = labelNames;
    }
}
