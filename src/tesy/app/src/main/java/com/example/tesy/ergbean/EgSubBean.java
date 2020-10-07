package com.example.tesy.ergbean;

import java.io.Serializable;
import java.util.List;

public class EgSubBean implements Serializable {

        private int id;
        private String name;
        private String image_url;
        private String image_gif;
        private String image_ver;
        private ExtBean ext;
        private String description;
        private int status;
        private int video_count;
        private int play_count;
        private String icon_url;
        private String icon_gif;
        private int index_recommend;
        private int copyright_sensitive;
        private int is_vip;
        private int type;
        private int sensitive;
        private String erge_img_url;
        private int free;
        private int cost;
        private int price;
        private Object expires_at;
        private int vip_price;
        private String publisher_name;
        private List<String> watch_areas;

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

        public String getImage_url() {
            return image_url;
        }

        public void setImage_url(String image_url) {
            this.image_url = image_url;
        }

        public String getImage_gif() {
            return image_gif;
        }

        public void setImage_gif(String image_gif) {
            this.image_gif = image_gif;
        }

        public String getImage_ver() {
            return image_ver;
        }

        public void setImage_ver(String image_ver) {
            this.image_ver = image_ver;
        }

        public ExtBean getExt() {
            return ext;
        }

        public void setExt(ExtBean ext) {
            this.ext = ext;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public int getVideo_count() {
            return video_count;
        }

        public void setVideo_count(int video_count) {
            this.video_count = video_count;
        }

        public int getPlay_count() {
            return play_count;
        }

        public void setPlay_count(int play_count) {
            this.play_count = play_count;
        }

        public String getIcon_url() {
            return icon_url;
        }

        public void setIcon_url(String icon_url) {
            this.icon_url = icon_url;
        }

        public String getIcon_gif() {
            return icon_gif;
        }

        public void setIcon_gif(String icon_gif) {
            this.icon_gif = icon_gif;
        }

        public int getIndex_recommend() {
            return index_recommend;
        }

        public void setIndex_recommend(int index_recommend) {
            this.index_recommend = index_recommend;
        }

        public int getCopyright_sensitive() {
            return copyright_sensitive;
        }

        public void setCopyright_sensitive(int copyright_sensitive) {
            this.copyright_sensitive = copyright_sensitive;
        }

        public int getIs_vip() {
            return is_vip;
        }

        public void setIs_vip(int is_vip) {
            this.is_vip = is_vip;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getSensitive() {
            return sensitive;
        }

        public void setSensitive(int sensitive) {
            this.sensitive = sensitive;
        }

        public String getErge_img_url() {
            return erge_img_url;
        }

        public void setErge_img_url(String erge_img_url) {
            this.erge_img_url = erge_img_url;
        }

        public int getFree() {
            return free;
        }

        public void setFree(int free) {
            this.free = free;
        }

        public int getCost() {
            return cost;
        }

        public void setCost(int cost) {
            this.cost = cost;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public Object getExpires_at() {
            return expires_at;
        }

        public void setExpires_at(Object expires_at) {
            this.expires_at = expires_at;
        }

        public int getVip_price() {
            return vip_price;
        }

        public void setVip_price(int vip_price) {
            this.vip_price = vip_price;
        }

        public String getPublisher_name() {
            return publisher_name;
        }

        public void setPublisher_name(String publisher_name) {
            this.publisher_name = publisher_name;
        }

    @Override
    public String toString() {
        return "EgSubBean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", image_url='" + image_url + '\'' +
                ", image_gif='" + image_gif + '\'' +
                ", image_ver='" + image_ver + '\'' +
                ", ext=" + ext +
                ", description='" + description + '\'' +
                ", status=" + status +
                ", video_count=" + video_count +
                ", play_count=" + play_count +
                ", icon_url='" + icon_url + '\'' +
                ", icon_gif='" + icon_gif + '\'' +
                ", index_recommend=" + index_recommend +
                ", copyright_sensitive=" + copyright_sensitive +
                ", is_vip=" + is_vip +
                ", type=" + type +
                ", sensitive=" + sensitive +
                ", erge_img_url='" + erge_img_url + '\'' +
                ", free=" + free +
                ", cost=" + cost +
                ", price=" + price +
                ", expires_at=" + expires_at +
                ", vip_price=" + vip_price +
                ", publisher_name='" + publisher_name + '\'' +
                ", watch_areas=" + watch_areas +
                '}';
    }

    public List<String> getWatch_areas() {
            return watch_areas;
        }

        public void setWatch_areas(List<String> watch_areas) {
            this.watch_areas = watch_areas;
        }

        public static class ExtBean implements Serializable{
            /**
             * banner_left : http://img5g22.ergedd.com/album/563_1597921829585.png
             * banner_right : http://img5g22.ergedd.com/album/563_1568795664178.jpg
             * icons : http://img5g22.ergedd.com/album/563_1597921834897.png
             */

            private String banner_left;
            private String banner_right;
            private String icons;

            public String getBanner_left() {
                return banner_left;
            }

            public void setBanner_left(String banner_left) {
                this.banner_left = banner_left;
            }

            public String getBanner_right() {
                return banner_right;
            }

            public void setBanner_right(String banner_right) {
                this.banner_right = banner_right;
            }

            public String getIcons() {
                return icons;
            }

            public void setIcons(String icons) {
                this.icons = icons;
            }
        }
    }
