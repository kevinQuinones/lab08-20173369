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
public class Invoice {
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY) private Long id;
	@Persistent private String address;
	@Persistent private String code;
	@Persistent private int quant;
	@Persistent private double cost;
	@Persistent private String RUC;
	@Persistent private String name;
	@Persistent private Date made;
	@Persistent private double total;
	@Persistent private int number;
	
	public Invoice( double cost,int quant, String address, String code, String RUC, String name, int number ) {
		this.cost = cost;
		this.quant=quant;
		this.code = code;
		this.name=name;
		this.address=address;
		this.RUC=RUC;
		this.total=cost*quant;
		this.number=number;
		LocalDateTime ldt = LocalDateTime.now(DateTimeZone.forID("America/Lima"));
		this.made=ldt.toDate();
	}
	public static void main( String []args){
		LocalDateTime ldt = LocalDateTime.now(DateTimeZone.forID("America/Lima"));
		Date made=ldt.toDate();
		System.out.print(made);
	}
	public Long getId() {
		return id;
	}
	
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public int getQuant() {
		return quant;
	}
	public void setQuant(int quant) {
		this.quant = quant;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public String getRUC() {
		return RUC;
	}
	public void setRUC(String rUC) {
		RUC = rUC;
	}
	
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public Date getMade() {
		return made;
	}
	public void setMade(Date made) {
		this.made = made;
	}
}
