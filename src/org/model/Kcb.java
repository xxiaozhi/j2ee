package org.model;

/**
 * Kcb entity. @author MyEclipse Persistence Tools
 */

public class Kcb implements java.io.Serializable {

	// Fields

	private String kch;
	private String kcm;
	private Integer kxxq;
	private Integer xs;
	private Integer xf;

	// Constructors

	/** default constructor */
	public Kcb() {
	}

	/** full constructor */
	public Kcb(String kcm, Integer kxxq, Integer xs, Integer xf) {
		this.kcm = kcm;
		this.kxxq = kxxq;
		this.xs = xs;
		this.xf = xf;
	}

	// Property accessors

	public String getKch() {
		return this.kch;
	}

	public void setKch(String kch) {
		this.kch = kch;
	}

	public String getKcm() {
		return this.kcm;
	}

	public void setKcm(String kcm) {
		this.kcm = kcm;
	}

	public Integer getKxxq() {
		return this.kxxq;
	}

	public void setKxxq(Integer kxxq) {
		this.kxxq = kxxq;
	}

	public Integer getXs() {
		return this.xs;
	}

	public void setXs(Integer xs) {
		this.xs = xs;
	}

	public Integer getXf() {
		return this.xf;
	}

	public void setXf(Integer xf) {
		this.xf = xf;
	}

}