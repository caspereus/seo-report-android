package studio.tay.reporting.model;

public class Contact {

    String id,email,website,address,phone;

    public Contact(String id, String email, String website, String address, String phone) {
        this.id = id;
        this.email = email;
        this.website = website;
        this.address = address;
        this.phone = phone;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getWebsite() {
        return website;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }
}
