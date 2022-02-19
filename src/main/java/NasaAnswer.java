import com.fasterxml.jackson.annotation.JsonProperty;

public class NasaAnswer {

    private final String copyright;
    private final String date;
    private final String explanation;
    private final String hdurl;
    private final String mediaType;
    private final String serviceVersion;
    private final String title;
    private final String url;

    public NasaAnswer(
            @JsonProperty("copyright") String copyright,
            @JsonProperty("date") String date,
            @JsonProperty("explanation") String explanation,
            @JsonProperty("hdurl") String hdurl,
            @JsonProperty("media_type") String mediaType,
            @JsonProperty("service_version") String serviceVersion,
            @JsonProperty("title") String title,
            @JsonProperty("url") String url
    ) {
        this.copyright = copyright;
        this.date = date;
        this.explanation = explanation;
        this.hdurl = hdurl;
        this.mediaType = mediaType;
        this.serviceVersion = serviceVersion;
        this.title = title;
        this.url = url;
    }

    public String getCopyright() {
        return copyright;
    }

    public String getDate() {
        return date;
    }

    public String getExplanation() {
        return explanation;
    }

    public String getHdurl() {
        return hdurl;
    }

    public String getMediaType() {
        return mediaType;
    }

    public String getServiceVersion() {
        return serviceVersion;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("NasaAnswer:");
        sb.append("\n\tCpyright: ").append(copyright);
        sb.append("\n\tDate: ").append(date);
        sb.append("\n\tExplanation: ").append(explanation);
        sb.append("\n\tHD URL: ").append(hdurl);
        sb.append("\n\tMedia type: ").append(mediaType);
        sb.append("\n\tService version: ").append(serviceVersion);
        sb.append("\n\tTitle: ").append(title);
        sb.append("\n\tURL: ").append(url);
        return sb.toString();
    }
}