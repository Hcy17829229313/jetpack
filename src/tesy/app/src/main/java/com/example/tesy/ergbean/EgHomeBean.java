package com.example.tesy.ergbean;

import java.util.List;

public class EgHomeBean {
    /**
     * success : true
     * data : [{"id":514,"copyright_sensitive":0,"sensitive":0,"description":"海底世界大冒险","name":"海底小纵队","icon_url":"http://img5g22.ergedd.com/album/514_1597929488765.png","icon_gif":"","image_url":"http://img5g22.ergedd.com/album/514_1566546123288.jpg","erge_img_url":"","is_vip":2,"free":5,"price":0,"vip_price":0,"play_count":0,"status":1,"type":1,"video_count":26,"icon_b":"http://img5g22.ergedd.com/album/514_1561968449725.png","index_name":"","publisher_name":"万达儿童-海底小纵队"},{"id":659,"copyright_sensitive":0,"sensitive":0,"description":"风靡全球的英语教学片","name":"爱探险的朵拉","icon_url":"http://img5g22.ergedd.com/album/659_1597929813448.png","icon_gif":"","image_url":"http://img5g22.ergedd.com/album/659_1568795866817.jpg","erge_img_url":"","is_vip":2,"free":5,"price":0,"vip_price":0,"play_count":0,"status":1,"type":1,"video_count":40,"icon_b":"http://img5g22.ergedd.com/album/659_1561968553602.png","index_name":"","publisher_name":"戎音广告"},{"id":562,"copyright_sensitive":0,"sensitive":0,"description":"跟着乐迪环游世界","name":"超级飞侠","icon_url":"http://img5g22.ergedd.com/album/562_1595549996290.png","icon_gif":"","image_url":"http://img5g22.ergedd.com/album/562_1566468342138.jpg","erge_img_url":"http://img5g22.ergedd.com/album/562_1544176901596.png","is_vip":2,"free":5,"price":0,"vip_price":0,"play_count":0,"status":1,"type":1,"video_count":26,"icon_b":"http://img5g22.ergedd.com/album/659_1561968593635.png","index_name":"","publisher_name":"奥飞文化-奥飞"},{"id":28,"copyright_sensitive":0,"sensitive":0,"description":"中外经典绘本故事","name":"哈利讲故事","icon_url":"http://img5g22.ergedd.com/album/28_1597929698648.png","icon_gif":"","image_url":"http://img5g22.ergedd.com/album/28_1566789629762.jpg","erge_img_url":"","is_vip":2,"free":5,"price":0,"vip_price":0,"play_count":27951527,"status":1,"type":1,"video_count":118,"icon_b":"http://img5g22.ergedd.com/album/659_1561968625130.png","index_name":"","publisher_name":"上海臻材-哈利儿歌"},{"id":601,"copyright_sensitive":0,"sensitive":0,"description":"玩玩具 学英语","name":"大眼兔乐园","icon_url":"http://img5g22.ergedd.com/album/601_1597929605830.png","icon_gif":"","image_url":"http://img5g22.ergedd.com/album/601_1567065420297.jpg","erge_img_url":"","is_vip":2,"free":5,"price":0,"vip_price":0,"play_count":0,"status":1,"type":1,"video_count":277,"icon_b":"http://img5g22.ergedd.com/album/659_1561968651660.png","index_name":"大眼兔乐园","publisher_name":"萌宝教育"},{"id":677,"copyright_sensitive":0,"sensitive":0,"description":"家喻户晓的明星娃娃","name":"天线宝宝","icon_url":"http://img5g22.ergedd.com/album/677_1597929743140.png","icon_gif":"","image_url":"http://img5g22.ergedd.com/album/677_1554865452832.jpg","erge_img_url":"","is_vip":2,"free":5,"price":0,"vip_price":0,"play_count":0,"status":1,"type":1,"video_count":120,"icon_b":"http://img5g22.ergedd.com/album/659_1561968673417.png","index_name":"","publisher_name":"DHX"},{"id":233,"copyright_sensitive":0,"sensitive":0,"description":"友谊的魔法","name":"小马宝莉","icon_url":"http://img5g22.ergedd.com/album/233_1597929580805.png","icon_gif":"","image_url":"http://img5g22.ergedd.com/album/233_1566466034826.jpg","erge_img_url":"","is_vip":2,"free":5,"price":0,"vip_price":0,"play_count":0,"status":1,"type":1,"video_count":65,"icon_b":"http://img5g22.ergedd.com/album/659_1561968698961.png","index_name":"","publisher_name":"孩之宝"},{"id":663,"copyright_sensitive":0,"sensitive":0,"description":"关于成长和友谊的故事","name":"嗨！道奇","icon_url":"http://img5g22.ergedd.com/album/663_1597929762300.png","icon_gif":"","image_url":"http://img5g22.ergedd.com/album/663_1566466227255.jpg","erge_img_url":"","is_vip":2,"free":5,"price":0,"vip_price":0,"play_count":0,"status":1,"type":1,"video_count":51,"icon_b":"http://img5g22.ergedd.com/album/659_1561968723701.png","index_name":"","publisher_name":"BBC"}]
     * message : Get albums for index recommendation successfully
     */

    public static class DataBean {
        /**
         * id : 514
         * copyright_sensitive : 0
         * sensitive : 0
         * description : 海底世界大冒险
         * name : 海底小纵队
         * icon_url : http://img5g22.ergedd.com/album/514_1597929488765.png
         * icon_gif :
         * image_url : http://img5g22.ergedd.com/album/514_1566546123288.jpg
         * erge_img_url :
         * is_vip : 2
         * free : 5
         * price : 0
         * vip_price : 0
         * play_count : 0
         * status : 1
         * type : 1
         * video_count : 26
         * icon_b : http://img5g22.ergedd.com/album/514_1561968449725.png
         * index_name :
         * publisher_name : 万达儿童-海底小纵队
         */

        private int id;
        private int copyright_sensitive;
        private int sensitive;
        private String description;
        private String name;
        private String icon_url;
        private String icon_gif;
        private String image_url;
        private String erge_img_url;
        private int is_vip;
        private int free;
        private int price;
        private int vip_price;
        private int play_count;
        private int status;
        private int type;
        private int video_count;
        private String icon_b;
        private String index_name;
        private String publisher_name;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getCopyright_sensitive() {
            return copyright_sensitive;
        }

        public void setCopyright_sensitive(int copyright_sensitive) {
            this.copyright_sensitive = copyright_sensitive;
        }

        public int getSensitive() {
            return sensitive;
        }

        public void setSensitive(int sensitive) {
            this.sensitive = sensitive;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
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

        public String getImage_url() {
            return image_url;
        }

        public void setImage_url(String image_url) {
            this.image_url = image_url;
        }

        public String getErge_img_url() {
            return erge_img_url;
        }

        public void setErge_img_url(String erge_img_url) {
            this.erge_img_url = erge_img_url;
        }

        public int getIs_vip() {
            return is_vip;
        }

        public void setIs_vip(int is_vip) {
            this.is_vip = is_vip;
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

        public int getPlay_count() {
            return play_count;
        }

        public void setPlay_count(int play_count) {
            this.play_count = play_count;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getVideo_count() {
            return video_count;
        }

        public void setVideo_count(int video_count) {
            this.video_count = video_count;
        }

        public String getIcon_b() {
            return icon_b;
        }

        public void setIcon_b(String icon_b) {
            this.icon_b = icon_b;
        }

        public String getIndex_name() {
            return index_name;
        }

        public void setIndex_name(String index_name) {
            this.index_name = index_name;
        }

        public String getPublisher_name() {
            return publisher_name;
        }

        public void setPublisher_name(String publisher_name) {
            this.publisher_name = publisher_name;
        }
    }
}
