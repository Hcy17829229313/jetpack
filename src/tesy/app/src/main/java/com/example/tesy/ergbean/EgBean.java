package com.example.tesy.ergbean;

import java.util.List;

public class EgBean {


    public static class DataBean {
        /**
         * id : 1072
         * name :
         * image :
         * image_gif :
         * image_ver :
         * detail :
         * rank : 10
         * item_type : videos
         * item_id : 24912
         * target_type : 1
         * video : {"id":24912,"name":"数鸭子","image":"http://img5g22.ergedd.com/video/24912_1559573406033.jpg","image_gif":"","image_ver":"","resource":"http://video5lmv.ergedd.com/videos/24912_480_20190603192816_2dtj.mp4","vsample":{"status":1,"item":[{"postion":1,"url":"http://video5lmv.ergedd.com/vsample/24912_20200615161610.jpg"}]},"play_count":35963567,"age_type":1,"singer":"","rank":1128,"album_id":1,"status":1,"min_age":0,"max_age":8,"created_at":"2019-06-03 19:27:45","updated_at":"2020-08-30 13:09:33","deleted_at":null,"copyright_sensitive":0,"duration":81.294,"publisher_id":13,"download_type":1,"copyright_contract_id":46,"copyright_contract_start_date":"2018-10-17","copyright_contract_end_date":"2020-10-16","search_keyword":"","is_ad":2,"ad_data":{"name":"","image":"","url":""},"is_vip":2,"srt_file_url":"","type":1,"sensitive":0,"watch_areas":["1"],"detail":"","albums":{"id":1,"name":"宝宝认动物","video_count":59,"play_count":18850142,"free":5,"price":0,"vip_price":0,"vids":[]}}
         * item : {"id":24912,"name":"数鸭子","image":"http://img5g22.ergedd.com/video/24912_1559573406033.jpg","image_gif":"","image_ver":"","resource":"http://video5lmv.ergedd.com/videos/24912_480_20190603192816_2dtj.mp4","vsample":{"status":1,"item":[{"postion":1,"url":"http://video5lmv.ergedd.com/vsample/24912_20200615161610.jpg"}]},"play_count":35963567,"age_type":1,"singer":"","rank":1128,"album_id":1,"status":1,"min_age":0,"max_age":8,"created_at":"2019-06-03 19:27:45","updated_at":"2020-08-30 13:09:33","deleted_at":null,"copyright_sensitive":0,"duration":81.294,"publisher_id":13,"download_type":1,"copyright_contract_id":46,"copyright_contract_start_date":"2018-10-17","copyright_contract_end_date":"2020-10-16","search_keyword":"","is_ad":2,"ad_data":{"name":"","image":"","url":""},"is_vip":2,"srt_file_url":"","type":1,"sensitive":0,"watch_areas":["1"],"detail":"","albums":{"id":1,"name":"宝宝认动物","video_count":59,"play_count":18850142,"free":5,"price":0,"vip_price":0,"vids":[]}}
         */

        private int id;
        private String name;
        private String image;
        private String image_gif;
        private String image_ver;
        private String detail;
        private int rank;
        private String item_type;
        private int item_id;
        private int target_type;
        private VideoBean video;
        private ItemBeanXX item;

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

        public String getDetail() {
            return detail;
        }

        public void setDetail(String detail) {
            this.detail = detail;
        }

        public int getRank() {
            return rank;
        }

        public void setRank(int rank) {
            this.rank = rank;
        }

        public String getItem_type() {
            return item_type;
        }

        public void setItem_type(String item_type) {
            this.item_type = item_type;
        }

        public int getItem_id() {
            return item_id;
        }

        public void setItem_id(int item_id) {
            this.item_id = item_id;
        }

        public int getTarget_type() {
            return target_type;
        }

        public void setTarget_type(int target_type) {
            this.target_type = target_type;
        }

        public VideoBean getVideo() {
            return video;
        }

        public void setVideo(VideoBean video) {
            this.video = video;
        }

        public ItemBeanXX getItem() {
            return item;
        }

        public void setItem(ItemBeanXX item) {
            this.item = item;
        }

        public static class VideoBean {
            /**
             * id : 24912
             * name : 数鸭子
             * image : http://img5g22.ergedd.com/video/24912_1559573406033.jpg
             * image_gif :
             * image_ver :
             * resource : http://video5lmv.ergedd.com/videos/24912_480_20190603192816_2dtj.mp4
             * vsample : {"status":1,"item":[{"postion":1,"url":"http://video5lmv.ergedd.com/vsample/24912_20200615161610.jpg"}]}
             * play_count : 35963567
             * age_type : 1
             * singer :
             * rank : 1128
             * album_id : 1
             * status : 1
             * min_age : 0
             * max_age : 8
             * created_at : 2019-06-03 19:27:45
             * updated_at : 2020-08-30 13:09:33
             * deleted_at : null
             * copyright_sensitive : 0
             * duration : 81.294
             * publisher_id : 13
             * download_type : 1
             * copyright_contract_id : 46
             * copyright_contract_start_date : 2018-10-17
             * copyright_contract_end_date : 2020-10-16
             * search_keyword :
             * is_ad : 2
             * ad_data : {"name":"","image":"","url":""}
             * is_vip : 2
             * srt_file_url :
             * type : 1
             * sensitive : 0
             * watch_areas : ["1"]
             * detail :
             * albums : {"id":1,"name":"宝宝认动物","video_count":59,"play_count":18850142,"free":5,"price":0,"vip_price":0,"vids":[]}
             */

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
            private String detail;
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

            public String getDetail() {
                return detail;
            }

            public void setDetail(String detail) {
                this.detail = detail;
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
                 * item : [{"postion":1,"url":"http://video5lmv.ergedd.com/vsample/24912_20200615161610.jpg"}]
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
                     * url : http://video5lmv.ergedd.com/vsample/24912_20200615161610.jpg
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
                 * id : 1
                 * name : 宝宝认动物
                 * video_count : 59
                 * play_count : 18850142
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

        public static class ItemBeanXX {
            /**
             * id : 24912
             * name : 数鸭子
             * image : http://img5g22.ergedd.com/video/24912_1559573406033.jpg
             * image_gif :
             * image_ver :
             * resource : http://video5lmv.ergedd.com/videos/24912_480_20190603192816_2dtj.mp4
             * vsample : {"status":1,"item":[{"postion":1,"url":"http://video5lmv.ergedd.com/vsample/24912_20200615161610.jpg"}]}
             * play_count : 35963567
             * age_type : 1
             * singer :
             * rank : 1128
             * album_id : 1
             * status : 1
             * min_age : 0
             * max_age : 8
             * created_at : 2019-06-03 19:27:45
             * updated_at : 2020-08-30 13:09:33
             * deleted_at : null
             * copyright_sensitive : 0
             * duration : 81.294
             * publisher_id : 13
             * download_type : 1
             * copyright_contract_id : 46
             * copyright_contract_start_date : 2018-10-17
             * copyright_contract_end_date : 2020-10-16
             * search_keyword :
             * is_ad : 2
             * ad_data : {"name":"","image":"","url":""}
             * is_vip : 2
             * srt_file_url :
             * type : 1
             * sensitive : 0
             * watch_areas : ["1"]
             * detail :
             * albums : {"id":1,"name":"宝宝认动物","video_count":59,"play_count":18850142,"free":5,"price":0,"vip_price":0,"vids":[]}
             */

            private int id;
            private String name;
            private String image;
            private String image_gif;
            private String image_ver;
            private String resource;
            private VsampleBeanX vsample;
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
            private AdDataBeanX ad_data;
            private int is_vip;
            private String srt_file_url;
            private int type;
            private int sensitive;
            private String detail;
            private AlbumsBeanX albums;
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

            public VsampleBeanX getVsample() {
                return vsample;
            }

            public void setVsample(VsampleBeanX vsample) {
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

            public AdDataBeanX getAd_data() {
                return ad_data;
            }

            public void setAd_data(AdDataBeanX ad_data) {
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

            public String getDetail() {
                return detail;
            }

            public void setDetail(String detail) {
                this.detail = detail;
            }

            public AlbumsBeanX getAlbums() {
                return albums;
            }

            public void setAlbums(AlbumsBeanX albums) {
                this.albums = albums;
            }

            public List<String> getWatch_areas() {
                return watch_areas;
            }

            public void setWatch_areas(List<String> watch_areas) {
                this.watch_areas = watch_areas;
            }

            public static class VsampleBeanX {
                /**
                 * status : 1
                 * item : [{"postion":1,"url":"http://video5lmv.ergedd.com/vsample/24912_20200615161610.jpg"}]
                 */

                private int status;
                private List<ItemBeanX> item;

                public int getStatus() {
                    return status;
                }

                public void setStatus(int status) {
                    this.status = status;
                }

                public List<ItemBeanX> getItem() {
                    return item;
                }

                public void setItem(List<ItemBeanX> item) {
                    this.item = item;
                }

                public static class ItemBeanX {
                    /**
                     * postion : 1
                     * url : http://video5lmv.ergedd.com/vsample/24912_20200615161610.jpg
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

            public static class AdDataBeanX {
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

            public static class AlbumsBeanX {
                /**
                 * id : 1
                 * name : 宝宝认动物
                 * video_count : 59
                 * play_count : 18850142
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
    }
}
