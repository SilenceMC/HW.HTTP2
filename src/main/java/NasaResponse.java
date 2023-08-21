import com.fasterxml.jackson.annotation.JsonProperty;

import java.net.URL;
import java.util.Date;

public class NasaResponse {

    String copyright;
    Date date;
    String explanation;
    URL hdurl;
    String media_type;
    String service_version;
    String title;
    URL url;


    public NasaResponse(
            @JsonProperty("copyright") String copyright,
            @JsonProperty("date") Date date,
            @JsonProperty("explanation") String explanation,
            @JsonProperty("hdurl") URL hdurl,
            @JsonProperty("media_type") String media_type,
            @JsonProperty("service_version") String service_version,
            @JsonProperty("title") String title,
            @JsonProperty("url") URL url
    )
    {
        this.copyright = copyright;
        this.date = date;
        this.explanation = explanation;
        this.hdurl = hdurl;
        this.media_type = media_type;
        this.service_version = service_version;
        this.title = title;
        this.url = url;
    }

    public String getCopyright() {
        return copyright;
    }

    public Date getDate() {
        return date;
    }

    public String getExplanation() {
        return explanation;
    }

    public URL getHdurl() {
        return hdurl;
    }

    public String getMedia_type() {
        return media_type;
    }

    public String getService_version() {
        return service_version;
    }

    public String getTitle() {
        return title;
    }

    public URL getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return "NasaResponse{" +
                "copyright='" + copyright + '\'' +
                ", date=" + date +
                ", explanation='" + explanation + '\'' +
                ", hdurl='" + hdurl + '\'' +
                ", media_type='" + media_type + '\'' +
                ", service_version='" + service_version + '\'' +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
