package cz.bern.planer.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Represents
 */
@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", unique = true)
    private String username;

    @Column(name = "avatar_uri")
    private String avatarUri;



    protected Member() {
        // No-arg constructor required by JPA
    }

    /**
     * Constructor.
     *
     * @param username member's username
     */
    public Member(String username) {
        this.username = username;
    }



    /**
     * Get ID.
     *
     * @return ID
     */
    public long getId() {
        return id;
    }

    /**
     * Get username.
     *
     * @return username
     */
    public String getUsername() {
        return username;
    }


    /**
     * Get user's avatar image.
     *
     * @return avatar image URI
     */
    public Optional<String> getAvatarUri() {
        return Optional.ofNullable(avatarUri);
    }

    /**
     * Sets user's avatar image.
     *
     * @param avatarUri image URI
     */
    public void setAvatarUri(String avatarUri) {
        this.avatarUri = avatarUri;
    }
}
