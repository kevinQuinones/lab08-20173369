package model.entity;
import java.time.ZoneId;
import java.util.Date;
import java.util.TimeZone;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.repackaged.org.joda.time.DateTimeZone;
import com.google.appengine.repackaged.org.joda.time.LocalDateTime;

@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Role {
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY) private Long id;
	@Persistent private String nombre;
	@Persistent private  boolean status;
  @Persistent private Date made;
	public Role(String nombre){
		 this.nombre=nombre;
		 status=true; 
		 LocalDateTime ldt = LocalDateTime.now(DateTimeZone.forID("America/Lima"));
			this.made=ldt.toDate();
	}
	
public Long getId(){
	return this.id;
}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
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
	public boolean equals(Role x) {
if(this.nombre.equals(x.nombre))return true;
else return false;
	}
}
