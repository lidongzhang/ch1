package app.mybatis.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Users {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column users.id
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column users.nick_name
     *
     * @mbg.generated
     */
    private String nick_name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column users.password
     *
     * @mbg.generated
     */
    private String password;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column users.name
     *
     * @mbg.generated
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table users
     *
     * @mbg.generated
     */
    private boolean id_changed;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table users
     *
     * @mbg.generated
     */
    private boolean nick_name_changed;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table users
     *
     * @mbg.generated
     */
    private boolean password_changed;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table users
     *
     * @mbg.generated
     */
    private boolean name_changed;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column users.id
     *
     * @return the value of users.id
     *
     * @mbg.generated
     */
    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column users.id
     *
     * @param id the value for users.id
     *
     * @mbg.generated
     */
    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
        this.id_changed = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column users.nick_name
     *
     * @return the value of users.nick_name
     *
     * @mbg.generated
     */
    @JsonProperty("nick_name")
    public String getNick_name() {
        return nick_name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column users.nick_name
     *
     * @param nick_name the value for users.nick_name
     *
     * @mbg.generated
     */
    @JsonProperty("nick_name")
    public void setNick_name(String nick_name) {
        this.nick_name = nick_name == null ? null : nick_name.trim();
        this.nick_name_changed = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column users.password
     *
     * @return the value of users.password
     *
     * @mbg.generated
     */
    @JsonProperty("password")
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column users.password
     *
     * @param password the value for users.password
     *
     * @mbg.generated
     */
    @JsonProperty("password")
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
        this.password_changed = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column users.name
     *
     * @return the value of users.name
     *
     * @mbg.generated
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column users.name
     *
     * @param name the value for users.name
     *
     * @mbg.generated
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
        this.name_changed = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table users
     *
     * @mbg.generated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", nick_name=").append(nick_name);
        sb.append(", password=").append(password);
        sb.append(", name=").append(name);
        sb.append("]");
        return sb.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table users
     *
     * @mbg.generated
     */
    public boolean getId_changed() {
        return this.id_changed;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table users
     *
     * @mbg.generated
     */
    public boolean getNick_name_changed() {
        return this.nick_name_changed;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table users
     *
     * @mbg.generated
     */
    public boolean getPassword_changed() {
        return this.password_changed;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table users
     *
     * @mbg.generated
     */
    public boolean getName_changed() {
        return this.name_changed;
    }
}