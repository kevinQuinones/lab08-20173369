package model.entity;
import java.time.ZoneId;
import java.util.Date;
import java.util.TimeZone;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.IdentityType;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Email;
import com.google.appengine.repackaged.org.joda.time.DateTimeZone;
import com.google.appengine.repackaged.org.joda.time.LocalDateTime;
//????
@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Resource {
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY) private Long id;
	@Persistent String url;
	@Persistent boolean status;
	@Persistent private Date made;
	public Resource(String  nombre){
		this.url= nombre;
		this.status=true;
		 LocalDateTime ldt = LocalDateTime.now(DateTimeZone.forID("America/Lima"));
			this.made=ldt.toDate();
	}
	public Long getId() {
		return id;
	}
	public String getNombre() {
		return url;
	}
	public void setNombre(String nombre) {
		this.url = nombre;
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

	public boolean equals(Resource arg0) {
		if(url.equals(arg0.url))return true;
		else return false;
	}
}
