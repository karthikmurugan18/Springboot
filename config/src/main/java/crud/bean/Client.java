package crud.bean;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name = "client_info")
public class Client {
	@Id
	@Column
	@GeneratedValue(strategy=GenerationType.IDENTITY)	
	
	private long id;
	@Column
	@JsonProperty("SYSTEM")
	private String SYSTEM;
	@JsonProperty("PRIN_NO")
	private String PRIN_NO;
	@JsonProperty("AGENT")
	private String AGENT;
	@JsonProperty("CLIENT_NAME")
	private String CLIENT_NAME;
	@JsonProperty("BILLINGDATE_CODES")
	private String BILLINGDATE_CODES;
	@JsonProperty("DUEDATE_CODES")
	private String DUEDATE_CODES;
	@JsonProperty("FIELD7")
	private String FIELD7;

	

	@Override
	public String toString() {
		return "Client [id=" + id + ", SYSTEM=" + SYSTEM + ", PRIN_NO=" + PRIN_NO + ", AGENT=" + AGENT
				+ ", CLIENT_NAME=" + CLIENT_NAME + ", BILLINGDATE_CODES=" + BILLINGDATE_CODES + ", DUEDATE_CODES="
				+ DUEDATE_CODES + ", FIELD7=" + FIELD7 + "]";
	}



	public Client(long id, String sYSTEM, String pRIN_NO, String aGENT, String cLIENT_NAME, String bILLINGDATE_CODES,
			String dUEDATE_CODES, String fIELD7) {
		super();
		this.id = id;
		SYSTEM = sYSTEM;
		PRIN_NO = pRIN_NO;
		AGENT = aGENT;
		CLIENT_NAME = cLIENT_NAME;
		BILLINGDATE_CODES = bILLINGDATE_CODES;
		DUEDATE_CODES = dUEDATE_CODES;
		FIELD7 = fIELD7;
	}



	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public String getSYSTEM() {
		return SYSTEM;
	}


	@JsonSetter("SYSTEM")
	public void setSYSTEM(String sYSTEM) {
		SYSTEM = sYSTEM;
	}



	public String getPRIN_NO() {
		return PRIN_NO;
	}


	@JsonSetter("PRIN_NO")
	public void setPRIN_NO(String pRIN_NO) {
		PRIN_NO = pRIN_NO;
	}



	public String getAGENT() {
		return AGENT;
	}


	@JsonSetter("AGENT")
	public void setAGENT(String aGENT) {
		AGENT = aGENT;
	}



	public String getCLIENT_NAME() {
		return CLIENT_NAME;
	}


	@JsonSetter("CLIENT_NAME")
	public void setCLIENT_NAME(String cLIENT_NAME) {
		CLIENT_NAME = cLIENT_NAME;
	}



	public String getBILLINGDATE_CODES() {
		return BILLINGDATE_CODES;
	}


	@JsonSetter("BILLINGDATE_CODES")
	public void setBILLINGDATE_CODES(String bILLINGDATE_CODES) {
		BILLINGDATE_CODES = bILLINGDATE_CODES;
	}



	public String getDUEDATE_CODES() {
		return DUEDATE_CODES;
	}


	@JsonSetter("DUEDATE_CODES")
	public void setDUEDATE_CODES(String dUEDATE_CODES) {
		DUEDATE_CODES = dUEDATE_CODES;
	}



	public String getFIELD7() {
		return FIELD7;
	}


	@JsonSetter("FIELD7")
	public void setFIELD7(String fIELD7) {
		FIELD7 = fIELD7;
	}



	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}

