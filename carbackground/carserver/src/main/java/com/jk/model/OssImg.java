/**
 * 此处不是注释
 * <p>
 * 业务描述
 *
 * @author 刘军谊
 * @create new Date();
 * @since 1.0.0
 */

package com.jk.model;

import lombok.Data;

@Data
public class OssImg {


    private Integer oid;
    private String hrefname;
    private String url;
    private String href;

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public String getHrefname() {
        return hrefname;
    }

    public void setHrefname(String hrefname) {
        this.hrefname = hrefname;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
