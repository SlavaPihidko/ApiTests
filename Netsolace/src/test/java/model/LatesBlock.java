package model;

public class LatesBlock {

    private String latest_url;

    public String getLatest_url() {
        return latest_url;
    }

    public LatesBlock withLatest_url(String latest_url) {
        this.latest_url = latest_url;
        return this;
    }

    @Override
    public String toString() {
        return "LatesBlock{" +
                "latest_url='" + latest_url + '\'' +
                '}';
    }

}
