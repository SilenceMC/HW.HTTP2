import com.fasterxml.jackson.annotation.JsonProperty;

import java.net.URL;
import java.util.Date;

public class NasaResponse {

    private final String copyright;
    private final Date date;
    private final String explanation;
    private final URL hdurl;
    private final String mediaType;
    private final String serviceVersion;
    private final String title;
    private final URL url;


    public NasaResponse(
            @JsonProperty("copyright") String copyright,
            @JsonProperty("date") Date date,
            @JsonProperty("explanation") String explanation,
            @JsonProperty("hdurl") URL hdurl,
            @JsonProperty("media_type") String mediaType,
            @JsonProperty("service_version") String serviceVersion,
            @JsonProperty("title") String title,
            @JsonProperty("url") URL url
    )
    {
        this.copyright = copyright;
        this.date = date;
        this.explanation = explanation;
        this.hdurl = hdurl;
        this.mediaType = mediaType;
        this.serviceVersion = serviceVersion;
        this.title = title;
        this.url = url;
    }

    public URL getHdurl() {
        return hdurl;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "NasaResponse{" +
                "copyright='" + copyright + '\'' +
                ", date=" + date +
                ", explanation='" + explanation + '\'' +
                ", hdurl=" + hdurl +
                ", mediaType='" + mediaType + '\'' +
                ", serviceVersion='" + serviceVersion + '\'' +
                ", title='" + title + '\'' +
                ", url=" + url +
                '}';
    }
}
