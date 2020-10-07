package com.example.tesy.egBabyBean;

import java.util.List;

public class BabyItemBean {

    /**
     * success : true
     * data : [{"id":276,"name":"巴塔木儿歌","count":79,"image":"http://img5g22.ergedd.com/audio_playlist/77294775510_1493795959461.jpg","description":"打造学习英语新途径，最萌动感儿歌，最完美英汉结合，宝宝轻松磨耳朵。","square_image_url":"http://img5g22.ergedd.com/audio_playlist/46991113358_1565692098349.jpg","sensitive":0,"watch_areas":["1"],"free":5,"cost":0,"price":0,"expires_at":null,"vip_price":0},{"id":344,"name":"睡前故事会","count":965,"image":"http://img5g22.ergedd.com/audio_playlist/68916250841_1548419395337.jpg","description":"童话森林里每天都有好玩的事情在发生，听熊猫天天来给你讲故事，伴你好梦吧~","square_image_url":"http://img5g22.ergedd.com/audio_playlist/47085372589_1565691505511.jpg","sensitive":0,"watch_areas":["1"],"free":5,"cost":0,"price":0,"expires_at":null,"vip_price":0},{"id":438,"name":"中国年","count":6,"image":"http://img5g22.ergedd.com/audio_playlist/51596491546_1578908268007.jpg","description":"讲述中国人过年的风俗习惯以及关于过年的古老传说和故事。","square_image_url":"http://img5g22.ergedd.com/audio_playlist/46603053889_1578908271810.jpg","sensitive":0,"watch_areas":["1"],"free":5,"cost":0,"price":0,"expires_at":null,"vip_price":0},{"id":340,"name":"经典英文儿歌","count":119,"image":"http://img5g22.ergedd.com/audio_playlist/87767684431_1547542738458.jpg","description":"磨耳朵的经典英文儿歌，宝宝英文启蒙的好伙伴。","square_image_url":"http://img5g22.ergedd.com/audio_playlist/46435836743_1547542742955.jpg","sensitive":0,"watch_areas":["1"],"free":5,"cost":0,"price":0,"expires_at":null,"vip_price":0},{"id":337,"name":"365夜故事","count":121,"image":"http://img5g22.ergedd.com/audio_playlist/12739586922_1574231988369.jpg","description":"故事岛上故事多，故事超人讲故事。","square_image_url":"http://img5g22.ergedd.com/audio_playlist/21928708772_1574231994059.jpg","sensitive":0,"watch_areas":["1"],"free":5,"cost":0,"price":0,"expires_at":null,"vip_price":0},{"id":273,"name":"唐诗精选","count":100,"image":"http://img5g22.ergedd.com/audio_playlist/40980976259_1493794865605.jpg","description":"带宝宝一起感受优美而又韵味无穷的唐诗，陶冶情操，温故知新。","square_image_url":"http://img5g22.ergedd.com/audio_playlist/10263042927_1565692204502.jpg","sensitive":0,"watch_areas":["1"],"free":5,"cost":0,"price":0,"expires_at":null,"vip_price":0},{"id":351,"name":"声律启蒙","count":18,"image":"http://img5g22.ergedd.com/audio_playlist/88675429760_1550912226049.jpg","description":"最具中国风的启蒙读物，让宝宝在诵读中掌握声韵格律！","square_image_url":"http://img5g22.ergedd.com/audio_playlist/65934784565_1574233825613.jpg","sensitive":0,"watch_areas":["1"],"free":5,"cost":0,"price":0,"expires_at":null,"vip_price":0},{"id":353,"name":"百变马丁","count":26,"image":"http://img5g22.ergedd.com/audio_playlist/92677582105_1552974615290.jpg","description":"7岁的小男孩马丁，每天早上醒来后，都会化身一个新的角色，从而开展一段完全不同的奇幻冒险的故事。","square_image_url":"http://img5g22.ergedd.com/audio_playlist/5858489635_1552974618547.jpg","sensitive":0,"watch_areas":["1"],"free":5,"cost":0,"price":0,"expires_at":null,"vip_price":0}]
     * message : Get excellent audio playlist successfully.
     */

    /**
         * id : 276
         * name : 巴塔木儿歌
         * count : 79
         * image : http://img5g22.ergedd.com/audio_playlist/77294775510_1493795959461.jpg
         * description : 打造学习英语新途径，最萌动感儿歌，最完美英汉结合，宝宝轻松磨耳朵。
         * square_image_url : http://img5g22.ergedd.com/audio_playlist/46991113358_1565692098349.jpg
         * sensitive : 0
         * watch_areas : ["1"]
         * free : 5
         * cost : 0
         * price : 0
         * expires_at : null
         * vip_price : 0
         */

        private int id;
        private String name;
        private int count;
        private String image;
        private String description;
        private String square_image_url;
        private int sensitive;
        private int free;
        private int cost;
        private int price;
        private Object expires_at;
        private int vip_price;
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

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getSquare_image_url() {
            return square_image_url;
        }

        public void setSquare_image_url(String square_image_url) {
            this.square_image_url = square_image_url;
        }

        public int getSensitive() {
            return sensitive;
        }

        public void setSensitive(int sensitive) {
            this.sensitive = sensitive;
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

        public List<String> getWatch_areas() {
            return watch_areas;
        }

        public void setWatch_areas(List<String> watch_areas) {
            this.watch_areas = watch_areas;
        }
    }

