package com.csx.springtest.example9.domain;

import org.apache.commons.lang.builder.ToStringBuilder;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 *
 * @Description: TODO
 * @Author: csx
 * @Date: 2018/02/22
 */
public class Forum implements Serializable{
    private int forumId;
    private String forumName;
    private String forumDesc;
    public String getForumDesc() {
        return forumDesc;
    }
    public void setForumDesc(String forumDesc) {
        this.forumDesc = forumDesc;
    }
    public int getForumId() {
        return forumId;
    }
    public void setForumId(int forumId) {
        this.forumId = forumId;
    }
    public String getForumName() {
        return forumName;
    }
    public void setForumName(String forumName) {
        this.forumName = forumName;
    }
    public String toString(){
        return ToStringBuilder.reflectionToString(this);
    }
}
