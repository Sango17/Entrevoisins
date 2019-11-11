package com.openclassrooms.entrevoisins.model;


/**
 * Model object representing a Neighbour
 */
public class Neighbour {

    /**
     * Identifier
     */
    private Integer id;

    /**
     * Full name
     */
    private String name;

    /**
     * Avatar
     */
    private String avatarUrl;

    /**
     * Address
     */
    private String address;

    /**
     * Phone Number
     */
    private String phoneNumber;

    /**
     * Mail
     */
    private String mail;

    /**
     * Favorite
     */
    private Boolean isFavorite;

    /**
     * Constructor
     *
     * @param id
     * @param name
     * @param avatarUrl
     * @param address
     * @param phoneNumber
     * @param mail
     */
    public Neighbour(Integer id, String name, String avatarUrl, String address, String phoneNumber, String mail, Boolean isFavorite) {
        this.id = id;
        this.name = name;
        this.avatarUrl = avatarUrl;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.mail = mail;
        this.isFavorite = isFavorite;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Boolean getFavorite() {
        return isFavorite;
    }

    public void setFavorite(Boolean favorite) {
        this.isFavorite = favorite;
    }
}
