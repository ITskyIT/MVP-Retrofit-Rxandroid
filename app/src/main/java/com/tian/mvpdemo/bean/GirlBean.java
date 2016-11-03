package com.tian.mvpdemo.bean;

/**
 * Girl数据实体类
 */
public class GirlBean {
    private String imgPath;
    private String introduction;
    private String stars;

    public GirlBean(String imgPath, String introduction, String stars) {
        this.imgPath = imgPath;
        this.introduction = introduction;
        this.stars = stars;
    }

    public String getImgPath() {
        return imgPath;
    }

    public String getIntroduction() {
        return introduction;
    }

    public String getStars() {
        return stars;
    }
}
