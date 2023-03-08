package app;

import com.google.gson.annotations.SerializedName;

public class SentinelData {
    @SerializedName("Id")
    private String id;

    @SerializedName("Name")
    private String name;

    @SerializedName("ContentLength")
    private String contentLength;

    @SerializedName("ContentGeometry")
    private String contentGeometry;

    // додані нові поля
    @SerializedName("Start")
    private String start;

    @SerializedName("End")
    private String end;

    public SentinelData() {}

    // додані нові методи getter/setter
    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    // додані нові методи toString та equals
    @Override
    public String toString() {
        return "SentinelData{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", contentLength='" + contentLength + '\'' +
                ", contentGeometry='" + contentGeometry + '\'' +
                ", start='" + start + '\'' +
                ", end='" + end + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SentinelData that = (SentinelData) o;

        if (!id.equals(that.id)) return false;
        if (!name.equals(that.name)) return false;
        if (!contentLength.equals(that.contentLength)) return false;
        if (!contentGeometry.equals(that.contentGeometry)) return false;
        if (!start.equals(that.start)) return false;
        return end.equals(that.end);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + contentLength.hashCode();
        result = 31 * result + contentGeometry.hashCode();
        result = 31 * result + start.hashCode();
        result = 31 * result + end.hashCode();
        return result;
    }
}
