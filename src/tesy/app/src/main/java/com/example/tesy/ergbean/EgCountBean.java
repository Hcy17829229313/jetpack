package com.example.tesy.ergbean;

import java.util.List;

public class EgCountBean {

        private int id;
        private String name;
        private String image;
        private String image_gif;
        private String image_ver;
        private String resource;
        private VsampleBean vsample;
        private int play_count;
        private int age_type;
        private String singer;
        private int rank;
        private int album_id;
        private int status;
        private int min_age;
        private int max_age;
        private String created_at;
        private String updated_at;
        private Object deleted_at;
        private int copyright_sensitive;
        private double duration;
        private int publisher_id;
        private int download_type;
        private int copyright_contract_id;
        private String copyright_contract_start_date;
        private String copyright_contract_end_date;
        private String search_keyword;
        private int is_ad;
        private AdDataBean ad_data;
        private int is_vip;
        private String srt_file_url;
        private int type;
        private int sensitive;
        private AlbumsBean albums;
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

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
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

        public String getResource() {
            return resource;
        }

        public void setResource(String resource) {
            this.resource = resource;
        }

        public VsampleBean getVsample() {
            return vsample;
        }

        public void setVsample(VsampleBean vsample) {
            this.vsample = vsample;
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

        public String getSinger() {
            return singer;
        }

        public void setSinger(String singer) {
            this.singer = singer;
        }

        public int getRank() {
            return rank;
        }

        public void setRank(int rank) {
            this.rank = rank;
        }

        public int getAlbum_id() {
            return album_id;
        }

        public void setAlbum_id(int album_id) {
            this.album_id = album_id;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
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

        public String getCreated_at() {
            return created_at;
        }

        public void setCreated_at(String created_at) {
            this.created_at = created_at;
        }

        public String getUpdated_at() {
            return updated_at;
        }

        public void setUpdated_at(String updated_at) {
            this.updated_at = updated_at;
        }

        public Object getDeleted_at() {
            return deleted_at;
        }

        public void setDeleted_at(Object deleted_at) {
            this.deleted_at = deleted_at;
        }

        public int getCopyright_sensitive() {
            return copyright_sensitive;
        }

        public void setCopyright_sensitive(int copyright_sensitive) {
            this.copyright_sensitive = copyright_sensitive;
        }

        public double getDuration() {
            return duration;
        }

        public void setDuration(double duration) {
            this.duration = duration;
        }

        public int getPublisher_id() {
            return publisher_id;
        }

        public void setPublisher_id(int publisher_id) {
            this.publisher_id = publisher_id;
        }

        public int getDownload_type() {
            return download_type;
        }

        public void setDownload_type(int download_type) {
            this.download_type = download_type;
        }

        public int getCopyright_contract_id() {
            return copyright_contract_id;
        }

        public void setCopyright_contract_id(int copyright_contract_id) {
            this.copyright_contract_id = copyright_contract_id;
        }

        public String getCopyright_contract_start_date() {
            return copyright_contract_start_date;
        }

        public void setCopyright_contract_start_date(String copyright_contract_start_date) {
            this.copyright_contract_start_date = copyright_contract_start_date;
        }

        public String getCopyright_contract_end_date() {
            return copyright_contract_end_date;
        }

        public void setCopyright_contract_end_date(String copyright_contract_end_date) {
            this.copyright_contract_end_date = copyright_contract_end_date;
        }

        public String getSearch_keyword() {
            return search_keyword;
        }

        public void setSearch_keyword(String search_keyword) {
            this.search_keyword = search_keyword;
        }

        public int getIs_ad() {
            return is_ad;
        }

        public void setIs_ad(int is_ad) {
            this.is_ad = is_ad;
        }

        public AdDataBean getAd_data() {
            return ad_data;
        }

        public void setAd_data(AdDataBean ad_data) {
            this.ad_data = ad_data;
        }

        public int getIs_vip() {
            return is_vip;
        }

        public void setIs_vip(int is_vip) {
            this.is_vip = is_vip;
        }

        public String getSrt_file_url() {
            return srt_file_url;
        }

        public void setSrt_file_url(String srt_file_url) {
            this.srt_file_url = srt_file_url;
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

        public AlbumsBean getAlbums() {
            return albums;
        }

        public void setAlbums(AlbumsBean albums) {
            this.albums = albums;
        }

        public List<String> getWatch_areas() {
            return watch_areas;
        }

        public void setWatch_areas(List<String> watch_areas) {
            this.watch_areas = watch_areas;
        }

        public static class VsampleBean {
            /**
             * status : 1
             * item : [{"postion":1,"url":"http://video5lmv.ergedd.com/vsample/22066_20200617121131.jpg"},{"postion":2,"url":"http://video5lmv.ergedd.com/vsample/22066_20200617121148.jpg"},{"postion":3,"url":"http://video5lmv.ergedd.com/vsample/22066_20200617121158.jpg"}]
             */

            private int status;
            private List<ItemBean> item;

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public List<ItemBean> getItem() {
                return item;
            }

            public void setItem(List<ItemBean> item) {
                this.item = item;
            }

            public static class ItemBean {
                /**
                 * postion : 1
                 * url : http://video5lmv.ergedd.com/vsample/22066_20200617121131.jpg
                 */

                private int postion;
                private String url;

                public int getPostion() {
                    return postion;
                }

                public void setPostion(int postion) {
                    this.postion = postion;
                }

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }
            }
        }

        public static class AdDataBean {
            /**
             * name :
             * image :
             * url :
             */

            private String name;
            private String image;
            private String url;

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

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }

        public static class AlbumsBean {
            /**
             * id : 645
             * name : 超级飞侠 第五季
             * video_count : 20
             * play_count : 0
             * free : 5
             * price : 0
             * vip_price : 0
             * vids : []
             */

            private int id;
            private String name;
            private int video_count;
            private int play_count;
            private int free;
            private int price;
            private int vip_price;
            private List<?> vids;

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

            public List<?> getVids() {
                return vids;
            }

            public void setVids(List<?> vids) {
                this.vids = vids;
            }
        }
    }

