package au.edu.unsw;


import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class User implements Serializable {
    /**
     * url : https://www.mixcloud.com/Iain/
     * username : Iain
     * name : Iain
     * key : /Iain/
     * pictures : {"medium":"https://thumbnailer.mixcloud.com/unsafe/100x100/defaults/users/4.png","320wx320h":"https://thumbnailer.mixcloud.com/unsafe/320x320/defaults/users/4.png","extra_large":"https://thumbnailer.mixcloud.com/unsafe/600x600/defaults/users/4.png","large":"https://thumbnailer.mixcloud.com/unsafe/300x300/defaults/users/4.png","640wx640h":"https://thumbnailer.mixcloud.com/unsafe/640x640/defaults/users/4.png","medium_mobile":"https://thumbnailer.mixcloud.com/unsafe/80x80/defaults/users/4.png","small":"https://thumbnailer.mixcloud.com/unsafe/25x25/defaults/users/4.png","thumbnail":"https://thumbnailer.mixcloud.com/unsafe/50x50/defaults/users/4.png"}
     */

    private String url;
    private String username;
    private String name;
    private String key;
    private PicturesEntity pictures;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public PicturesEntity getPictures() {
        return pictures;
    }

    public void setPictures(PicturesEntity pictures) {
        this.pictures = pictures;
    }

    public static class PicturesEntity implements Serializable{
        /**
         * medium : https://thumbnailer.mixcloud.com/unsafe/100x100/defaults/users/4.png
         * 320wx320h : https://thumbnailer.mixcloud.com/unsafe/320x320/defaults/users/4.png
         * extra_large : https://thumbnailer.mixcloud.com/unsafe/600x600/defaults/users/4.png
         * large : https://thumbnailer.mixcloud.com/unsafe/300x300/defaults/users/4.png
         * 640wx640h : https://thumbnailer.mixcloud.com/unsafe/640x640/defaults/users/4.png
         * medium_mobile : https://thumbnailer.mixcloud.com/unsafe/80x80/defaults/users/4.png
         * small : https://thumbnailer.mixcloud.com/unsafe/25x25/defaults/users/4.png
         * thumbnail : https://thumbnailer.mixcloud.com/unsafe/50x50/defaults/users/4.png
         */

        private String medium;
        @SerializedName("320wx320h")
        private String _$320wx320h;
        private String extra_large;
        private String large;
        @SerializedName("640wx640h")
        private String _$640wx640h;
        private String medium_mobile;
        private String small;
        private String thumbnail;

        public String getMedium() {
            return medium;
        }

        public void setMedium(String medium) {
            this.medium = medium;
        }

        public String get_$320wx320h() {
            return _$320wx320h;
        }

        public void set_$320wx320h(String _$320wx320h) {
            this._$320wx320h = _$320wx320h;
        }

        public String getExtra_large() {
            return extra_large;
        }

        public void setExtra_large(String extra_large) {
            this.extra_large = extra_large;
        }

        public String getLarge() {
            return large;
        }

        public void setLarge(String large) {
            this.large = large;
        }

        public String get_$640wx640h() {
            return _$640wx640h;
        }

        public void set_$640wx640h(String _$640wx640h) {
            this._$640wx640h = _$640wx640h;
        }

        public String getMedium_mobile() {
            return medium_mobile;
        }

        public void setMedium_mobile(String medium_mobile) {
            this.medium_mobile = medium_mobile;
        }

        public String getSmall() {
            return small;
        }

        public void setSmall(String small) {
            this.small = small;
        }

        public String getThumbnail() {
            return thumbnail;
        }

        public void setThumbnail(String thumbnail) {
            this.thumbnail = thumbnail;
        }
    }
}
