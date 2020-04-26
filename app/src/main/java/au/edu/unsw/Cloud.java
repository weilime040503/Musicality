package au.edu.unsw;


import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;
// the object that mixcloud returns
public class Cloud  implements Serializable {
    private int play_count;
    private User user;
    private String key;
    private String created_time;
    private int audio_length;
    private String slug;
    private int favorite_count;
    private int listener_count;
    private String name;
    private String url;
    private PicturesEntityX pictures;
    private int repost_count;
    private String updated_time;
    private int comment_count;
    private boolean hidden_stats;
    private List<Tag> tags;

    public int getPlay_count() {
        return play_count;
    }

    public void setPlay_count(int play_count) {
        this.play_count = play_count;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getCreated_time() {
        return created_time;
    }

    public void setCreated_time(String created_time) {
        this.created_time = created_time;
    }

    public int getAudio_length() {
        return audio_length;
    }

    public void setAudio_length(int audio_length) {
        this.audio_length = audio_length;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public int getFavorite_count() {
        return favorite_count;
    }

    public void setFavorite_count(int favorite_count) {
        this.favorite_count = favorite_count;
    }

    public int getListener_count() {
        return listener_count;
    }

    public void setListener_count(int listener_count) {
        this.listener_count = listener_count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public PicturesEntityX getPictures() {
        return pictures;
    }

    public void setPictures(PicturesEntityX pictures) {
        this.pictures = pictures;
    }

    public int getRepost_count() {
        return repost_count;
    }

    public void setRepost_count(int repost_count) {
        this.repost_count = repost_count;
    }

    public String getUpdated_time() {
        return updated_time;
    }

    public void setUpdated_time(String updated_time) {
        this.updated_time = updated_time;
    }

    public int getComment_count() {
        return comment_count;
    }

    public void setComment_count(int comment_count) {
        this.comment_count = comment_count;
    }

    public boolean isHidden_stats() {
        return hidden_stats;
    }

    public void setHidden_stats(boolean hidden_stats) {
        this.hidden_stats = hidden_stats;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }



    public static class PicturesEntityX {
        /**
         * medium : https://thumbnailer.mixcloud.com/unsafe/100x100/extaudio/4/6/c/5/4dde-b34a-4fb4-9184-7768e600e553.jpg
         * 768wx768h : https://thumbnailer.mixcloud.com/unsafe/768x768/extaudio/4/6/c/5/4dde-b34a-4fb4-9184-7768e600e553.jpg
         * 320wx320h : https://thumbnailer.mixcloud.com/unsafe/320x320/extaudio/4/6/c/5/4dde-b34a-4fb4-9184-7768e600e553.jpg
         * extra_large : https://thumbnailer.mixcloud.com/unsafe/600x600/extaudio/4/6/c/5/4dde-b34a-4fb4-9184-7768e600e553.jpg
         * large : https://thumbnailer.mixcloud.com/unsafe/300x300/extaudio/4/6/c/5/4dde-b34a-4fb4-9184-7768e600e553.jpg
         * 640wx640h : https://thumbnailer.mixcloud.com/unsafe/640x640/extaudio/4/6/c/5/4dde-b34a-4fb4-9184-7768e600e553.jpg
         * medium_mobile : https://thumbnailer.mixcloud.com/unsafe/80x80/extaudio/4/6/c/5/4dde-b34a-4fb4-9184-7768e600e553.jpg
         * small : https://thumbnailer.mixcloud.com/unsafe/25x25/extaudio/4/6/c/5/4dde-b34a-4fb4-9184-7768e600e553.jpg
         * 1024wx1024h : https://thumbnailer.mixcloud.com/unsafe/1024x1024/extaudio/4/6/c/5/4dde-b34a-4fb4-9184-7768e600e553.jpg
         * thumbnail : https://thumbnailer.mixcloud.com/unsafe/50x50/extaudio/4/6/c/5/4dde-b34a-4fb4-9184-7768e600e553.jpg
         */

        private String medium;
        @SerializedName("768wx768h")
        private String _$768wx768h;
        @SerializedName("320wx320h")
        private String _$320wx320h;
        private String extra_large;
        private String large;
        @SerializedName("640wx640h")
        private String _$640wx640h;
        private String medium_mobile;
        private String small;
        @SerializedName("1024wx1024h")
        private String _$1024wx1024h;
        private String thumbnail;

        public String getMedium() {
            return medium;
        }

        public void setMedium(String medium) {
            this.medium = medium;
        }

        public String get_$768wx768h() {
            return _$768wx768h;
        }

        public void set_$768wx768h(String _$768wx768h) {
            this._$768wx768h = _$768wx768h;
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

        public String get_$1024wx1024h() {
            return _$1024wx1024h;
        }

        public void set_$1024wx1024h(String _$1024wx1024h) {
            this._$1024wx1024h = _$1024wx1024h;
        }

        public String getThumbnail() {
            return thumbnail;
        }

        public void setThumbnail(String thumbnail) {
            this.thumbnail = thumbnail;
        }
    }


}
