package test.com.myemployee.pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Employee {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("last_name")
    @Expose
    private String lastName;
    @SerializedName("birthday")
    @Expose
    private String birthday;
    @SerializedName("avatar_url")
    @Expose
    private String avatarUrl;
    @SerializedName("specialty")
    @Expose
    private List<Specialty> specialty = null;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public List<Specialty> getSpecialty() {
        return specialty;
    }

    public void setSpecialty(List<Specialty> specialty) {
        this.specialty = specialty;
    }
}
