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
import com.google.appengine.repackaged.org.joda.time.DateTimeZone;
import com.google.appengine.repackaged.org.joda.time.LocalDateTime;

import controller.PMF;
@PersistenceCapable(identityType = IdentityType.APPLICATION)
public class Access {
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY) private Long id;
	@Persistent long idRole;
	@Persistent long idResource;
	@Persistent boolean status;
	@Persistent Date made;
	public Access(long role, long resource, boolean status){
		this.idRole= role;
		this.idResource=resource;
		this.status= status;
		 LocalDateTime ldt = LocalDateTime.now(DateTimeZone.forID("America/Lima"));
			this.made=ldt.toDate();
	}
	public Long getId() {
		return id;
	}
	public long getIdRole() {
		return idRole;
	}
	public void setIdRole(long role) {
		this.idRole = role;
	}
	public long getIdResource() {
		return idResource;
	}
	public void setIdResource(long resource) {
		this.idResource = resource;
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
	public String  getRole() {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Role role=pm.getObjectById(Role.class,idRole);
		pm.close();
		return role.getNombre();
	}
	public String  getResource() {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Resource resource=pm.getObjectById(Resource.class,idResource);
		pm.close();
		return resource.getNombre();
	}
	
}
