package model.entity;
import java.time.ZoneId;
import java.util.Date;
import java.util.TimeZone;

import javax.jdo.PersistenceManager;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import controller.PMF;
import com.google.appengine.api.datastore.Email;//?????????'
import com.google.appengine.repackaged.org.joda.time.DateTimeZone;
import com.google.appengine.repackaged.org.joda.time.LocalDateTime;
@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Usuario {
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY) private Long id;
	@Persistent private String 	email;
	@Persistent long  idRole;//????????
	@Persistent private Date birth;
	@Persistent private boolean gender;
	@Persistent private boolean status;
	@Persistent private Date made;
	
	public Usuario( long idRole, String email, Date birth, boolean gender ) {
		this.idRole=idRole;
		this.email=email;
		this.birth=birth;
		this.gender=gender;
		this.status=true;
		LocalDateTime ldt = LocalDateTime.now(DateTimeZone.forID("America/Lima"));
		this.made=ldt.toDate();
	}
	public Long getId() {
		return id;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String  getRole() {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Role role=pm.getObjectById(Role.class,idRole);
		pm.close();
		return role.getNombre();
	}
	public long getIdRole(){
		return idRole;
	}
	
	public void setIdRole(long role) {
		this.idRole = role;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	public boolean isGender() {
		return gender;
	}
	public void setGender(boolean gender) {
		this.gender = gender;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public Date getMade() {
		return made;
	}
	public void setMade(Date made) {
		this.made = made;
	}
	public boolean isAdministrador(){
		return this.getRole().equalsIgnoreCase("Administrador");
	}
}
