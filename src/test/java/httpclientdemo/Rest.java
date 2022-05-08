package httpclientdemo;

/**
 * @param:${param}
 * @Author: Wzw
 * @Date: 2021/8/1 15:38
 */
public class Rest {

    private String apiId;
    private String apiName;
    private String Type;
    private String url;

    public String getApiId() {
        return apiId;
    }

    public void setApiId(String apiId) {
        this.apiId = apiId;
    }

    public String getApiName() {
        return apiName;
    }

    public void setApiName(String apiName) {
        this.apiName = apiName;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Rest{" + "apiId='" + apiId + '\'' + ", apiName='" + apiName + '\'' + ", Type='" + Type + '\'' + ", url='" + url + '\'' + '}';
    }
}
