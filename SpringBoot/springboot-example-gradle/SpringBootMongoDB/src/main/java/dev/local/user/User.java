package dev.local.user;

import dev.local.address.Address;
import org.springframework.data.annotation.Id;

/**
 * Created by xz on 2018-3-27.
 */
public class User {
    @Id private String id;
    private String username;
    private String email;
    private Address address;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
