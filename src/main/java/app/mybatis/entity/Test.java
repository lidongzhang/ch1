package app.mybatis.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import java.util.Date;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Test {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column Test.Id
     *
     * @mbg.generated
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column Test.C1
     *
     * @mbg.generated
     */
    private String c1;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column Test.C2
     *
     * @mbg.generated
     */
    private Integer c2;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column Test.C3
     *
     * @mbg.generated
     */
    private BigDecimal c3;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column Test.c4
     *
     * @mbg.generated
     */
    @JsonFormat(pattern="yyyy-MM-dd",timezone="GMT+8")
    private Date c4;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column Test.c5
     *
     * @mbg.generated
     */
    @JsonFormat(pattern="hh:mm:ss",timezone="GMT+8")
    private Date c5;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column Test.c6
     *
     * @mbg.generated
     */
    @JsonFormat(pattern="yyyy-MM-dd hh:mm:ss",timezone="GMT+8")
    private Date c6;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table Test
     *
     * @mbg.generated
     */
    private boolean id_changed;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table Test
     *
     * @mbg.generated
     */
    private boolean c1_changed;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table Test
     *
     * @mbg.generated
     */
    private boolean c2_changed;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table Test
     *
     * @mbg.generated
     */
    private boolean c3_changed;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table Test
     *
     * @mbg.generated
     */
    private boolean c4_changed;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table Test
     *
     * @mbg.generated
     */
    private boolean c5_changed;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table Test
     *
     * @mbg.generated
     */
    private boolean c6_changed;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Test.Id
     *
     * @return the value of Test.Id
     *
     * @mbg.generated
     */
    @JsonProperty("id")
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Test.Id
     *
     * @param id the value for Test.Id
     *
     * @mbg.generated
     */
    @JsonProperty("id")
    public void setId(Long id) {
        this.id = id;
        this.id_changed = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Test.C1
     *
     * @return the value of Test.C1
     *
     * @mbg.generated
     */
    @JsonProperty("c1")
    public String getC1() {
        return c1;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Test.C1
     *
     * @param c1 the value for Test.C1
     *
     * @mbg.generated
     */
    @JsonProperty("c1")
    public void setC1(String c1) {
        this.c1 = c1 == null ? null : c1.trim();
        this.c1_changed = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Test.C2
     *
     * @return the value of Test.C2
     *
     * @mbg.generated
     */
    @JsonProperty("c2")
    public Integer getC2() {
        return c2;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Test.C2
     *
     * @param c2 the value for Test.C2
     *
     * @mbg.generated
     */
    @JsonProperty("c2")
    public void setC2(Integer c2) {
        this.c2 = c2;
        this.c2_changed = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Test.C3
     *
     * @return the value of Test.C3
     *
     * @mbg.generated
     */
    @JsonProperty("c3")
    public BigDecimal getC3() {
        return c3;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Test.C3
     *
     * @param c3 the value for Test.C3
     *
     * @mbg.generated
     */
    @JsonProperty("c3")
    public void setC3(BigDecimal c3) {
        this.c3 = c3;
        this.c3_changed = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Test.c4
     *
     * @return the value of Test.c4
     *
     * @mbg.generated
     */
    @JsonProperty("c4")
    public Date getC4() {
        return c4;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Test.c4
     *
     * @param c4 the value for Test.c4
     *
     * @mbg.generated
     */
    @JsonProperty("c4")
    public void setC4(Date c4) {
        this.c4 = c4;
        this.c4_changed = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Test.c5
     *
     * @return the value of Test.c5
     *
     * @mbg.generated
     */
    @JsonProperty("c5")
    public Date getC5() {
        return c5;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Test.c5
     *
     * @param c5 the value for Test.c5
     *
     * @mbg.generated
     */
    @JsonProperty("c5")
    public void setC5(Date c5) {
        this.c5 = c5;
        this.c5_changed = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column Test.c6
     *
     * @return the value of Test.c6
     *
     * @mbg.generated
     */
    @JsonProperty("c6")
    public Date getC6() {
        return c6;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column Test.c6
     *
     * @param c6 the value for Test.c6
     *
     * @mbg.generated
     */
    @JsonProperty("c6")
    public void setC6(Date c6) {
        this.c6 = c6;
        this.c6_changed = true;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Test
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
        sb.append(", c1=").append(c1);
        sb.append(", c2=").append(c2);
        sb.append(", c3=").append(c3);
        sb.append(", c4=").append(c4);
        sb.append(", c5=").append(c5);
        sb.append(", c6=").append(c6);
        sb.append("]");
        return sb.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Test
     *
     * @mbg.generated
     */
    @JsonProperty("c4_fmt_yyyy_MM_dd_HH_mm_ss")
    public String getC4_fmt_yyyy_MM_dd_HH_mm_ss() {
        if ( c4 == null) { return "";}
         return (new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(c4);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Test
     *
     * @mbg.generated
     */
    @JsonProperty("c4_fmt_HH_mm_ss")
    public String getC4_fmt_HH_mm_ss() {
        if ( c4 == null) { return "";}
         return (new java.text.SimpleDateFormat("HH:mm:ss")).format(c4);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Test
     *
     * @mbg.generated
     */
    @JsonProperty("c4_fmt_yyyy_MM_dd")
    public String getC4_fmt_yyyy_MM_dd() {
        if ( c4 == null) { return "";}
         return (new java.text.SimpleDateFormat("yyyy-MM-dd")).format(c4);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Test
     *
     * @mbg.generated
     */
    @JsonProperty("c5_fmt_yyyy_MM_dd_HH_mm_ss")
    public String getC5_fmt_yyyy_MM_dd_HH_mm_ss() {
        if ( c5 == null) { return "";}
         return (new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(c5);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Test
     *
     * @mbg.generated
     */
    @JsonProperty("c5_fmt_HH_mm_ss")
    public String getC5_fmt_HH_mm_ss() {
        if ( c5 == null) { return "";}
         return (new java.text.SimpleDateFormat("HH:mm:ss")).format(c5);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Test
     *
     * @mbg.generated
     */
    @JsonProperty("c5_fmt_yyyy_MM_dd")
    public String getC5_fmt_yyyy_MM_dd() {
        if ( c5 == null) { return "";}
         return (new java.text.SimpleDateFormat("yyyy-MM-dd")).format(c5);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Test
     *
     * @mbg.generated
     */
    @JsonProperty("c6_fmt_yyyy_MM_dd_HH_mm_ss")
    public String getC6_fmt_yyyy_MM_dd_HH_mm_ss() {
        if ( c6 == null) { return "";}
         return (new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(c6);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Test
     *
     * @mbg.generated
     */
    @JsonProperty("c6_fmt_HH_mm_ss")
    public String getC6_fmt_HH_mm_ss() {
        if ( c6 == null) { return "";}
         return (new java.text.SimpleDateFormat("HH:mm:ss")).format(c6);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Test
     *
     * @mbg.generated
     */
    @JsonProperty("c6_fmt_yyyy_MM_dd")
    public String getC6_fmt_yyyy_MM_dd() {
        if ( c6 == null) { return "";}
         return (new java.text.SimpleDateFormat("yyyy-MM-dd")).format(c6);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Test
     *
     * @mbg.generated
     */
    public boolean getId_changed() {
        return this.id_changed;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Test
     *
     * @mbg.generated
     */
    public boolean getC1_changed() {
        return this.c1_changed;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Test
     *
     * @mbg.generated
     */
    public boolean getC2_changed() {
        return this.c2_changed;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Test
     *
     * @mbg.generated
     */
    public boolean getC3_changed() {
        return this.c3_changed;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Test
     *
     * @mbg.generated
     */
    public boolean getC4_changed() {
        return this.c4_changed;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Test
     *
     * @mbg.generated
     */
    public boolean getC5_changed() {
        return this.c5_changed;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table Test
     *
     * @mbg.generated
     */
    public boolean getC6_changed() {
        return this.c6_changed;
    }
}