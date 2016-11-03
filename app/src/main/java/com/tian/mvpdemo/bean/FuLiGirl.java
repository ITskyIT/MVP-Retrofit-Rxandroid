package com.tian.mvpdemo.bean;

import java.util.List;

/**
 * Created by jiujiu on 2016/11/2.
 */
public class FuLiGirl {
    private String error;
    private List<FuLi> results;
    public static class FuLi{
       /* "_id": "58193781421aa90e6f21b49f",
                "createdAt": "2016-11-02T08:46:57.726Z",
                "desc": "11-2",
                "publishedAt": "2016-11-02T11:49:08.835Z",
                "source": "chrome",
                "type": "\u798f\u5229",
                "url": "http://ww4.sinaimg.cn/large/610dc034jw1f9dh2ohx2vj20u011hn0r.jpg",
                "used": true,
                "who": "daimajia"*/
        private String id;
        private String createdAt;
        private String desc;
        private String publishedAt;
        private String source;
        private String type;
        private String url;
        private String used;
        private String who;

        public String getId() {
            return id;
        }

        public String getCreatedAt() {
            return createdAt;
        }

        public String getDesc() {
            return desc;
        }

        public String getPublishedAt() {
            return publishedAt;
        }

        public String getSource() {
            return source;
        }

        public String getType() {
            return type;
        }

        public String getUrl() {
            return url;
        }

        public String getUsed() {
            return used;
        }

        public String getWho() {
            return who;
        }
    }

    public String getError() {
        return error;
    }

    public List<FuLi> getResults() {
        return results;
    }
}
