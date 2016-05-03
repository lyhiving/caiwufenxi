package com.post.model;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Tauth entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tauth", catalog = "cwfx")
public class Tauth implements java.io.Serializable {

	// Fields

	private String cid;
	private Tauth tauth;
	private String cdesc;
	private String cname;
	private BigDecimal cseq;
	private String curl;
	private Set<TroleTauth> troleTauths = new HashSet<TroleTauth>(0);
	private Set<Tauth> tauths = new HashSet<Tauth>(0);

	// Constructors

	/** default constructor */
	public Tauth() {
	}

	/** minimal constructor */
	public Tauth(String cid, String cname) {
		this.cid = cid;
		this.cname = cname;
	}

	/** full constructor */
	public Tauth(String cid, Tauth tauth, String cdesc, String cname, BigDecimal cseq, String curl, Set<TroleTauth> troleTauths, Set<Tauth> tauths) {
		this.cid = cid;
		this.tauth = tauth;
		this.cdesc = cdesc;
		this.cname = cname;
		this.cseq = cseq;
		this.curl = curl;
		this.troleTauths = troleTauths;
		this.tauths = tauths;
	}

	// Property accessors
	@Id
	@Column(name = "CID", unique = true, nullable = false, length = 36)
	public String getCid() {
		return this.cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CPID")
	public Tauth getTauth() {
		return this.tauth;
	}

	public void setTauth(Tauth tauth) {
		this.tauth = tauth;
	}

	@Column(name = "CDESC", length = 200)
	public String getCdesc() {
		return this.cdesc;
	}

	public void setCdesc(String cdesc) {
		this.cdesc = cdesc;
	}

	@Column(name = "CNAME", nullable = false, length = 100)
	public String getCname() {
		return this.cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	@Column(name = "CSEQ", precision = 22, scale = 0)
	public BigDecimal getCseq() {
		return this.cseq;
	}

	public void setCseq(BigDecimal cseq) {
		this.cseq = cseq;
	}

	@Column(name = "CURL", length = 5000)
	public String getCurl() {
		return this.curl;
	}

	public void setCurl(String curl) {
		this.curl = curl;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "tauth")
	public Set<TroleTauth> getTroleTauths() {
		return this.troleTauths;
	}

	public void setTroleTauths(Set<TroleTauth> troleTauths) {
		this.troleTauths = troleTauths;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "tauth")
	public Set<Tauth> getTauths() {
		return this.tauths;
	}

	public void setTauths(Set<Tauth> tauths) {
		this.tauths = tauths;
	}

}