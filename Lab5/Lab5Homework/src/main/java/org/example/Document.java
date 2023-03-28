package org.example;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Document implements Serializable {
    private String id;
    private String title;
    private String location;
    private Map<String, Object> tags = new HashMap<>();

    public Document()
    {
        // pt jackson, daca n are default constructor, crapa
    }

    public Document(String title, String id, String location)
    {
        this.title = title;
        this.id = id;
        this.location = location;
    }
    public void addTag(String key, Object value)
    {
        tags.put(key,value);
    }
    public String getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getLocation() {
        return location;
    }
    public Map<String, Object> getTags() {
        return tags;
    }

    public void setId(String id) {
        this.id = id;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public void setTags(Map<String, Object> tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        return "Document{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", location='" + location + '\'' +
                ", tags=" + tags +
                '}' + "\n";
    }
}
