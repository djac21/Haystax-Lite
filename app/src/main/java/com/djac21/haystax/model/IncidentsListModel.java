package com.djac21.haystax.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class IncidentsListModel {
    @SerializedName("incidents")
    private List<Incidents> incidents;

    @SerializedName("count")
    private int count;

    public List<Incidents> getIncidents() {
        return incidents;
    }

    public void setIncidents(List<Incidents> incidents) {
        this.incidents = incidents;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public static class Incidents {
        @SerializedName("details")
        private Details details;

        @SerializedName("id")
        private String id;

        @SerializedName("security")
        private Security security;

        @SerializedName("location")
        private Location location;

        @SerializedName("primary")
        private String primary;

        @SerializedName("display_hints")
        private Display_hints display_hints;

        @SerializedName("overview")
        private Overview overview;

        @SerializedName("title")
        private String title;

        @SerializedName("documents")
        private List<String> documents;

        public Details getDetails() {
            return details;
        }

        public void setDetails(Details details) {
            this.details = details;
        }

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

        public Display_hints getDisplay_hints() {
            return display_hints;
        }

        public void setDisplay_hints(Display_hints display_hints) {
            this.display_hints = display_hints;
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
    }

    public static class Details {
        @SerializedName("summary")
        private String summary;

        @SerializedName("comments")
        private String comments;

        @SerializedName("address")
        private Address address;

        public String getSummary() {
            return summary;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }

        public String getComments() {
            return comments;
        }

        public void setComments(String comments) {
            this.comments = comments;
        }

        public Address getAddress() {
            return address;
        }

        public void setAddress(Address address) {
            this.address = address;
        }
    }

    public static class Address {
        @SerializedName("address1")
        private String address1;

        @SerializedName("state")
        private String state;

        @SerializedName("county")
        private String county;

        @SerializedName("country")
        private String country;

        @SerializedName("zip")
        private String zip;

        @SerializedName("city")
        private String city;

        public String getAddress1() {
            return address1;
        }

        public void setAddress1(String address1) {
            this.address1 = address1;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public String getCounty() {
            return county;
        }

        public void setCounty(String county) {
            this.county = county;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public String getZip() {
            return zip;
        }

        public void setZip(String zip) {
            this.zip = zip;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }
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

    public static class Location {
        @SerializedName("longlat")
        private List<Double> longlat;

        public List<Double> getLonglat() {
            return longlat;
        }

        public void setLonglat(List<Double> longlat) {
            this.longlat = longlat;
        }
    }

    public static class Display_hints {
        @SerializedName("zoom")
        private int zoom;

        public int getZoom() {
            return zoom;
        }

        public void setZoom(int zoom) {
            this.zoom = zoom;
        }
    }

    public static class Overview {
        @SerializedName("type")
        private String type;

        @SerializedName("date")
        private String date;

        @SerializedName("tag")
        private List<String> tag;

        @SerializedName("importance")
        private String importance;

        @SerializedName("title")
        private String title;

        @SerializedName("status")
        private String status;

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

        public List<String> getTag() {
            return tag;
        }

        public void setTag(List<String> tag) {
            this.tag = tag;
        }

        public String getImportance() {
            return importance;
        }

        public void setImportance(String importance) {
            this.importance = importance;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
    }
}