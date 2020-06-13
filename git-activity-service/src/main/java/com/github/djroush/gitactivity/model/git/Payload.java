//package com.github.djroush.gitactivity.model.git;
//
//import com.fasterxml.jackson.annotation.*;
//import java.util.List;
//
//public class Payload {
//    private Long pushID;
//    private Long size;
//    private Long distinctSize;
//    private String ref;
//    private String head;
//    private String before;
//    private List<Commit> commits;
//    private String refType;
//    private String masterBranch;
//    private String description;
//    private String pusherType;
//
//    @JsonProperty("push_id")
//    public Long getPushID() { return pushID; }
//    @JsonProperty("push_id")
//    public void setPushID(Long value) { this.pushID = value; }
//
//    @JsonProperty("size")
//    public Long getSize() { return size; }
//    @JsonProperty("size")
//    public void setSize(Long value) { this.size = value; }
//
//    @JsonProperty("distinct_size")
//    public Long getDistinctSize() { return distinctSize; }
//    @JsonProperty("distinct_size")
//    public void setDistinctSize(Long value) { this.distinctSize = value; }
//
//    @JsonProperty("ref")
//    public String getRef() { return ref; }
//    @JsonProperty("ref")
//    public void setRef(String value) { this.ref = value; }
//
//    @JsonProperty("head")
//    public String getHead() { return head; }
//    @JsonProperty("head")
//    public void setHead(String value) { this.head = value; }
//
//    @JsonProperty("before")
//    public String getBefore() { return before; }
//    @JsonProperty("before")
//    public void setBefore(String value) { this.before = value; }
//
//    @JsonProperty("commits")
//    public List<Commit> getCommits() { return commits; }
//    @JsonProperty("commits")
//    public void setCommits(List<Commit> value) { this.commits = value; }
//
//    @JsonProperty("ref_type")
//    public String getRefType() { return refType; }
//    @JsonProperty("ref_type")
//    public void setRefType(String value) { this.refType = value; }
//
//    @JsonProperty("master_branch")
//    public String getMasterBranch() { return masterBranch; }
//    @JsonProperty("master_branch")
//    public void setMasterBranch(String value) { this.masterBranch = value; }
//
//    @JsonProperty("description")
//    public String getDescription() { return description; }
//    @JsonProperty("description")
//    public void setDescription(String value) { this.description = value; }
//
//    @JsonProperty("pusher_type")
//    public String getPusherType() { return pusherType; }
//    @JsonProperty("pusher_type")
//    public void setPusherType(String value) { this.pusherType = value; }
//}
