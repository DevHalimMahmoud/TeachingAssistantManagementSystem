package com.example.tamanagmentsystem.ui.about;

public class OurTeam {


    private String name, title, text, url;
    private int team_image, linkedin_image;


    public OurTeam( String name, String title, String text, String url, int team_image, int linkedin_image) {

        this.name = name;
        this.title = title;
        this.text = text;
        this.url = url;
        this.team_image = team_image;
        this.linkedin_image = linkedin_image;
    }




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getTeam_image() {
        return team_image;
    }

    public void setTeam_image(int team_image) {
        this.team_image = team_image;
    }

    public int getLinkedin_image() {
        return linkedin_image;
    }

    public void setLinkedin_image(int linkedin_image) {
        this.linkedin_image = linkedin_image;
    }
}
