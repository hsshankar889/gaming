package gaming.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import lombok.Data;
@Data
@Entity
public class player {
private String name;
@Id
private String email;
@Column(nullable = false)
private int age;
@Column(nullable = false,unique = true)
private String password;
@Column(length=10)
private long phonenumber;
private double depositeamt;
private double earnedamt;
private double profit;
@Lob
private byte[] image;
@CreationTimestamp
private Date playerTime;
@UpdateTimestamp
private Date updateTime;
}
