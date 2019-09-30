package com.djac21.haystax.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class LoginModel {
    @SerializedName("fullname")
    private String fullname;

    @SerializedName("default_app")
    private String default_app;

    @SerializedName("previous_login")
    private String previous_login;

    @SerializedName("custom_icons")
    private Custom_icons custom_icons;

    @SerializedName("clientcode")
    private String clientcode;

    @SerializedName("expires")
    private String expires;

    @SerializedName("redaction_groups")
    private List<String> redaction_groups;

    @SerializedName("enabled_apps")
    private List<String> enabled_apps;

    @SerializedName("data_groups")
    private List<String> data_groups;

    @SerializedName("username")
    private String username;

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getDefault_app() {
        return default_app;
    }

    public void setDefault_app(String default_app) {
        this.default_app = default_app;
    }

    public String getPrevious_login() {
        return previous_login;
    }

    public void setPrevious_login(String previous_login) {
        this.previous_login = previous_login;
    }

    public Custom_icons getCustom_icons() {
        return custom_icons;
    }

    public void setCustom_icons(Custom_icons custom_icons) {
        this.custom_icons = custom_icons;
    }

    public String getClientcode() {
        return clientcode;
    }

    public void setClientcode(String clientcode) {
        this.clientcode = clientcode;
    }

    public String getExpires() {
        return expires;
    }

    public void setExpires(String expires) {
        this.expires = expires;
    }

    public List<String> getRedaction_groups() {
        return redaction_groups;
    }

    public void setRedaction_groups(List<String> redaction_groups) {
        this.redaction_groups = redaction_groups;
    }

    public List<String> getEnabled_apps() {
        return enabled_apps;
    }

    public void setEnabled_apps(List<String> enabled_apps) {
        this.enabled_apps = enabled_apps;
    }

    public List<String> getData_groups() {
        return data_groups;
    }

    public void setData_groups(List<String> data_groups) {
        this.data_groups = data_groups;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public static class Custom_icons {
    }
}