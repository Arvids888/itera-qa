package model.survey;

import org.apache.commons.lang3.RandomStringUtils;

public class Survey {
    private String name;
    private String mobilenumber;
    private String email;
    private String password;
    private String address;

    public String getName() {
        return name;
    }

    public String setName() {
         return this.name = RandomStringUtils.randomAlphabetic(10);
    }

    public String getMobilenumber() {
        return mobilenumber;
    }

    public String setMobilenumber() {
        String randomMobilenumber = RandomStringUtils.randomNumeric(10);
        StringBuilder sb = new StringBuilder(randomMobilenumber);
        String mobilenumber = String.valueOf(sb.insert((sb.length()-10), '+'));
        return this.mobilenumber = mobilenumber;

    }

    public String getEmail() {
        return email;
    }

    public String setEmail() {
        return this.name = RandomStringUtils.randomAlphabetic(10);
    }

    public String getPassword() {
        return password;
    }

    public String setPassword() {
        return this.name = RandomStringUtils.randomAlphanumeric(10);
    }

    public String getAddress() {
        return address;
    }

    public String setAddress() {
        return this.name = RandomStringUtils.randomAlphabetic(10);
    }
}
