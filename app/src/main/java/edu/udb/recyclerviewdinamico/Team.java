package edu.udb.recyclerviewdinamico;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class Team implements Serializable {

    private int id;

    @SerializedName("team_name")
    private String teamName;

    private String address;

    @SerializedName("video_url")
    private String videoUrl;

    @SerializedName("website")
    private String webSite;

    @SerializedName("img_logo")
    private String imgLogo;

    @SerializedName("img_stadium")
    private String imgStadium;

    @SerializedName("description")
    private String description;

    public Team(int id, String teamName, String address, String videoUrl, String webSite, String imgLogo, String imgStadium, String description) {
        this.setId(id);
        this.setTeamName(teamName);
        this.setAddress(address);
        this.setVideoUrl(videoUrl);
        this.setWebSite(webSite);
        this.setImgLogo(imgLogo);
        this.setImgStadium(imgStadium);
        this.setDescription(description);
    }

    public Team(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

    public String getImgLogo() {
        return imgLogo;
    }

    public void setImgLogo(String imgLogo) {
        this.imgLogo = imgLogo;
    }

    public String getImgStadium() {
        return imgStadium;
    }

    public void setImgStadium(String imgStadium) {
        this.imgStadium = imgStadium;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
