package crud.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@Entity
@JsonIgnoreProperties
public class Client {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private long id;
	private String SYSTEM,PRIN_NO,agent,client_name,billingdate_codes,duedate_codes;

	public String getSystem() {
		return system;
	}

	public void setSystem(String system) {
		this.system = system;
	}

	public String getPrin_no() {
		return prin_no;
	}

	public void setPrin_no(String prin_no) {
		this.prin_no = prin_no;
	}

	public String getAgent() {
		return agent;
	}

	public void setAgent(String agent) {
		this.agent = agent;
	}

	public String getClient_name() {
		return client_name;
	}

	public void setClient_name(String client_name) {
		this.client_name = client_name;
	}

	public String getBillingdate_codes() {
		return billingdate_codes;
	}

	public void setBillingdate_codes(String billingdate_codes) {
		this.billingdate_codes = billingdate_codes;
	}

	public String getDuedate_codes() {
		return duedate_codes;
	}

	public void setDuedate_codes(String duedate_codes) {
		this.duedate_codes = duedate_codes;
	}

	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}

