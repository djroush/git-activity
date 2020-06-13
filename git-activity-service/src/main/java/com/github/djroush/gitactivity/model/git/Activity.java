package com.github.djroush.gitactivity.model.git;

import com.fasterxml.jackson.annotation.*;
import java.time.OffsetDateTime;



public class Activity {
    private String id;
    private String type;
    private Actor actor;
//    private Repo repo;
//    private Payload payload;
    private boolean welcomePublic;
    private OffsetDateTime createdAt;

    @JsonProperty("id")
    public String getID() { return id; }
    @JsonProperty("id")
    public void setID(String value) { this.id = value; }

    @JsonProperty("type")
    public String getType() { return type; }
    @JsonProperty("type")
    public void setType(String value) { this.type = value; }

    @JsonProperty("actor")
    public Actor getActor() { return actor; }
    @JsonProperty("actor")
    public void setActor(Actor value) { this.actor = value; }

//    @JsonProperty("repo")
//    public Repo getRepo() { return repo; }
//    @JsonProperty("repo")
//    public void setRepo(Repo value) { this.repo = value; }
//
//    @JsonProperty("payload")
//    public Payload getPayload() { return payload; }
//    @JsonProperty("payload")
//    public void setPayload(Payload value) { this.payload = value; }
//
    @JsonProperty("public")
    public boolean getWelcomePublic() { return welcomePublic; }
    @JsonProperty("public")
    public void setWelcomePublic(boolean value) { this.welcomePublic = value; }

    @JsonProperty("created_at")
    public OffsetDateTime getCreatedAt() { return createdAt; }
    @JsonProperty("created_at")
    public void setCreatedAt(OffsetDateTime value) { this.createdAt = value; }
}
