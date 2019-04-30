package studio.tay.reporting.model;

public class Client {
    String id,name,website,email,phone,password,address,created_at;

    public Client(String id, String name, String website, String email, String phone, String password, String address, String created_at) {
        this.id = id;
        this.name = name;
        this.website = website;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.address = address;
        this.created_at = created_at;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getWebsite() {
        return website;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getPassword() {
        return password;
    }

    public String getAddress() {
        return address;
    }

    public String getCreated_at() {
        return created_at;
    }
}
