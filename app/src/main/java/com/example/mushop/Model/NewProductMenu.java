package com.example.mushop.Model;

public class NewProductMenu {

    int image;
    int heading;
    int subtext;

    public NewProductMenu(int image, int heading, int subtext) {
        this.image = image;
        this.heading = heading;
        this.subtext = subtext;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getHeading() {
        return heading;
    }

    public void setHeading(int heading) {
        this.heading = heading;
    }

    public int getSubtext() {
        return subtext;
    }

    public void setSubtext(int subtext) {
        this.subtext = subtext;
    }


}
