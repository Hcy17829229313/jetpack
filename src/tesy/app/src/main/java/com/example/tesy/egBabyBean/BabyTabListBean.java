package com.example.tesy.egBabyBean;

import java.io.Serializable;
import java.util.List;

public class BabyTabListBean implements Serializable {


    private List<AudiosBean> audios;

    public List<AudiosBean> getAudios() {
        return audios;
    }

    public void setAudios(List<AudiosBean> audios) {
        this.audios = audios;
    }


    public static class AudiosBean implements Serializable{
        /**
         * id : 9430
         * name : Monkey
         * image : http://img5g22.ergedd.com/audio/33688002763_1547461438423.jpg
         * resource : http://aud3ip5.ergedd.com/audios/9430_1547461457_mmuv.mp3
         * lrc_file_url :
         * play_count : 21664706
         * age_type : 1
         * copyright_type : 0
         * copyright_name : 网友上传
         * singer :
         * authorize : 2
         * status : 1
         * sensitive : 0
         * playlists : {"id":338,"name":"手指家族","count":31,"free":5,"price":0,"vip_price":0,"aids":[]}
         * min_age : 0
         * max_age : 8
         * duration : 76.232
         * download_type : 1
         */

        private int id;
        private String name;
        private String image;
        private String resource;
        private String lrc_file_url;
        private int play_count;
        private int age_type;
        private int copyright_type;
        private String copyright_name;
        private String singer;
        private int authorize;
        private int status;
        private int sensitive;
        private PlaylistsBean playlists;
        private int min_age;
        private int max_age;
        private double duration;
        private int download_type;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getResource() {
            return resource;
        }

        public void setResource(String resource) {
            this.resource = resource;
        }

        public String getLrc_file_url() {
            return lrc_file_url;
        }

        public void setLrc_file_url(String lrc_file_url) {
            this.lrc_file_url = lrc_file_url;
        }

        public int getPlay_count() {
            return play_count;
        }

        public void setPlay_count(int play_count) {
            this.play_count = play_count;
        }

        public int getAge_type() {
            return age_type;
        }

        public void setAge_type(int age_type) {
            this.age_type = age_type;
        }

        public int getCopyright_type() {
            return copyright_type;
        }

        public void setCopyright_type(int copyright_type) {
            this.copyright_type = copyright_type;
        }

        public String getCopyright_name() {
            return copyright_name;
        }

        public void setCopyright_name(String copyright_name) {
            this.copyright_name = copyright_name;
        }

        public String getSinger() {
            return singer;
        }

        public void setSinger(String singer) {
            this.singer = singer;
        }

        public int getAuthorize() {
            return authorize;
        }

        public void setAuthorize(int authorize) {
            this.authorize = authorize;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public int getSensitive() {
            return sensitive;
        }

        public void setSensitive(int sensitive) {
            this.sensitive = sensitive;
        }

        public PlaylistsBean getPlaylists() {
            return playlists;
        }

        public void setPlaylists(PlaylistsBean playlists) {
            this.playlists = playlists;
        }

        public int getMin_age() {
            return min_age;
        }

        public void setMin_age(int min_age) {
            this.min_age = min_age;
        }

        public int getMax_age() {
            return max_age;
        }

        public void setMax_age(int max_age) {
            this.max_age = max_age;
        }

        public double getDuration() {
            return duration;
        }

        public void setDuration(double duration) {
            this.duration = duration;
        }

        public int getDownload_type() {
            return download_type;
        }

        public void setDownload_type(int download_type) {
            this.download_type = download_type;
        }

        public static class PlaylistsBean implements Serializable{
            /**
             * id : 338
             * name : 手指家族
             * count : 31
             * free : 5
             * price : 0
             * vip_price : 0
             * aids : []
             */

            private int id;
            private String name;
            private int count;
            private int free;
            private int price;
            private int vip_price;
            private List<?> aids;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getCount() {
                return count;
            }

            public void setCount(int count) {
                this.count = count;
            }

            public int getFree() {
                return free;
            }

            public void setFree(int free) {
                this.free = free;
            }

            public int getPrice() {
                return price;
            }

            public void setPrice(int price) {
                this.price = price;
            }

            public int getVip_price() {
                return vip_price;
            }

            public void setVip_price(int vip_price) {
                this.vip_price = vip_price;
            }

            public List<?> getAids() {
                return aids;
            }

            public void setAids(List<?> aids) {
                this.aids = aids;
            }
        }
    }


    public static class MessagesBean implements Serializable{
        private List<String> succeed;

        public List<String> getSucceed() {
            return succeed;
        }

        public void setSucceed(List<String> succeed) {
            this.succeed = succeed;
        }
    }
}
