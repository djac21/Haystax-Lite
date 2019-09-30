package com.djac21.haystax.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class IncidentImageModel {
    @SerializedName("files")
    private List<Files> files;

    public List<Files> getFiles() {
        return files;
    }

    public void setFiles(List<Files> files) {
        this.files = files;
    }

    public static class Files {
        @SerializedName("id")
        private String id;

        @SerializedName("security")
        private Security security;

        @SerializedName("file_original_id")
        private String file_original_id;

        @SerializedName("content_type")
        private String content_type;

        @SerializedName("stored_location")
        private String stored_location;

        @SerializedName("parent_id")
        private String parent_id;

        @SerializedName("link_id")
        private String link_id;

        @SerializedName("file_name")
        private String file_name;

        @SerializedName("stored_filename")
        private String stored_filename;

        @SerializedName("caption")
        private String caption;

        @SerializedName("file_small")
        private String file_small;

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

        public String getFile_original_id() {
            return file_original_id;
        }

        public void setFile_original_id(String file_original_id) {
            this.file_original_id = file_original_id;
        }

        public String getContent_type() {
            return content_type;
        }

        public void setContent_type(String content_type) {
            this.content_type = content_type;
        }

        public String getStored_location() {
            return stored_location;
        }

        public void setStored_location(String stored_location) {
            this.stored_location = stored_location;
        }

        public String getParent_id() {
            return parent_id;
        }

        public void setParent_id(String parent_id) {
            this.parent_id = parent_id;
        }

        public String getLink_id() {
            return link_id;
        }

        public void setLink_id(String link_id) {
            this.link_id = link_id;
        }

        public String getFile_name() {
            return file_name;
        }

        public void setFile_name(String file_name) {
            this.file_name = file_name;
        }

        public String getStored_filename() {
            return stored_filename;
        }

        public void setStored_filename(String stored_filename) {
            this.stored_filename = stored_filename;
        }

        public String getCaption() {
            return caption;
        }

        public void setCaption(String caption) {
            this.caption = caption;
        }

        public String getFile_small() {
            return file_small;
        }

        public void setFile_small(String file_small) {
            this.file_small = file_small;
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

}