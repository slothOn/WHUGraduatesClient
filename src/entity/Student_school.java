package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

//student_school(ssid, sid, activity, honor, startyear, endyear)
@Entity
@Table(name="student_school")
public class Student_school {
	@Id
	@Column(name="ssid")
	@GeneratedValue
	private Integer ssid;
	@Column(name="sid")
	private String sid;
	@Column(name="activity")
	private String activity;
	@Column(name="honor")
	private String honor;
	@Column(name="startyear")
	private String startyear;
	@Column(name="endyear")
	private String endyear;
	@Column(name="sname")
	private String sname;
	
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public Student_school(){}
	public Student_school(Integer ssid, String sid, String sname, String activity, String honor, String startyear, String endyear) {
		super();
		this.ssid = ssid;
		this.sid = sid;
		this.sname = sname;
		this.activity = activity;
		this.honor = honor;
		this.startyear = startyear;
		this.endyear = endyear;
	}
	
	public Integer getSsid() {
		return ssid;
	}
	public void setSsid(Integer ssid) {
		this.ssid = ssid;
	}
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getActivity() {
		return activity;
	}
	public void setActivity(String activity) {
		this.activity = activity;
	}
	public String getHonor() {
		return honor;
	}
	public void setHonor(String honor) {
		this.honor = honor;
	}
	public String getStartyear() {
		return startyear;
	}
	public void setStartyear(String startyear) {
		this.startyear = startyear;
	}
	public String getEndyear() {
		return endyear;
	}
	public void setEndyear(String endyear) {
		this.endyear = endyear;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return ssid + "," + sid + "," + sname + "," + activity + "," + honor + "," + startyear + "," + endyear + ",";
	}
}
