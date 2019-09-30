package com.djac21.haystax.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class IncidentDetailModel {
    @SerializedName("id")
    private String id;

    @SerializedName("security")
    private Security security;

    @SerializedName("details")
    private Details details;

    @SerializedName("$visibility_writable")
    private boolean $visibility_writable;

    @SerializedName("location")
    private Location location;

    @SerializedName("primary")
    private String primary;

    @SerializedName("overview")
    private Overview overview;

    @SerializedName("title")
    private String title;

    @SerializedName("documents")
    private List<String> documents;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Security getSecurity() {
        return security;
    }

    public void setSecurity(Security security) {
        this.security = security;
    }

    public Details getDetails() {
        return details;
    }

    public void setDetails(Details details) {
        this.details = details;
    }

    public boolean get$visibility_writable() {
        return $visibility_writable;
    }

    public void set$visibility_writable(boolean $visibility_writable) {
        this.$visibility_writable = $visibility_writable;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getPrimary() {
        return primary;
    }

    public void setPrimary(String primary) {
        this.primary = primary;
    }

    public Overview getOverview() {
        return overview;
    }

    public void setOverview(Overview overview) {
        this.overview = overview;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getDocuments() {
        return documents;
    }

    public void setDocuments(List<String> documents) {
        this.documents = documents;
    }

    public static class Security {
        @SerializedName("tenant")
        private String tenant;

        @SerializedName("createddate")
        private String createddate;

        @SerializedName("modifieddate")
        private String modifieddate;

        @SerializedName("modifiedby")
        private String modifiedby;

        @SerializedName("writers")
        private List<String> writers;

        @SerializedName("creator")
        private String creator;

        @SerializedName("readers")
        private List<String> readers;

        public String getTenant() {
            return tenant;
        }

        public void setTenant(String tenant) {
            this.tenant = tenant;
        }

        public String getCreateddate() {
            return createddate;
        }

        public void setCreateddate(String createddate) {
            this.createddate = createddate;
        }

        public String getModifieddate() {
            return modifieddate;
        }

        public void setModifieddate(String modifieddate) {
            this.modifieddate = modifieddate;
        }

        public String getModifiedby() {
            return modifiedby;
        }

        public void setModifiedby(String modifiedby) {
            this.modifiedby = modifiedby;
        }

        public List<String> getWriters() {
            return writers;
        }

        public void setWriters(List<String> writers) {
            this.writers = writers;
        }

        public String getCreator() {
            return creator;
        }

        public void setCreator(String creator) {
            this.creator = creator;
        }

        public List<String> getReaders() {
            return readers;
        }

        public void setReaders(List<String> readers) {
            this.readers = readers;
        }
    }

    public static class Details {
        @SerializedName("summary")
        private String summary;

        @SerializedName("source")
        private String source;

        @SerializedName("url")
        private String url;

        public String getSummary() {
            return summary;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

    public static class Location {
    }

    public static class Overview {
        @SerializedName("title")
        private String title;

        @SerializedName("type")
        private String type;

        @SerializedName("date")
        private String date;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }
    }
}