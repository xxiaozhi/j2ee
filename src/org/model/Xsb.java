package org.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Xsb entity. @author MyEclipse Persistence Tools
 */

public class Xsb implements java.io.Serializable {

	// Fields

	private String xh;
	private String xm;
	private Short xb;
	private Date cssj;
	//private Integer zyId;
	private Integer zxf;
	private String bz;
	private byte[] zp;
	private Zyb zyb;		//这里是专业的对象
	// Constructors

	/** default constructor */
	public Xsb() {
	}

	/** minimal constructor */
	public Xsb(String xh) {
		this.xh = xh;
	}

	/** full constructor */
	public Xsb(String xh, String xm, Short xb, Date cssj,
			Integer zxf, String bz, byte[] zp,Zyb zyb) {
		this.xh = xh;
		this.xm = xm;
		this.xb = xb;
		this.cssj = cssj;
		//this.zyId = zyId;
		this.zxf = zxf;
		this.bz = bz;
		this.zp = zp;
		this.zyb=zyb;
	}

	// Property accessors

	public String getXh() {
		return this.xh;
	}

	public void setXh(String xh) {
		this.xh = xh;
	}

	public String getXm() {
		return this.xm;
	}

	public void setXm(String xm) {
		this.xm = xm;
	}

	public Short getXb() {
		return this.xb;
	}

	public void setXb(Short xb) {
		this.xb = xb;
	}

	public Date getCssj() {
		return this.cssj;
	}

	public void setCssj(Date cssj) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");//yyyy-mm-dd, 会出现时间不对, 因为小写的mm是代表: 秒
		String str = sdf.format(cssj);
	    Date utilDate = sdf.parse(str);
	    Date date = new java.sql.Date(utilDate.getTime());
		this.cssj = date;
	}

//	public Integer getZyId() {
//		return this.zyId;
//	}
//
//	public void setZyId(Integer zyId) {
//		this.zyId = zyId;
//	}

	public Integer getZxf() {
		return this.zxf;
	}

	public void setZxf(Integer zxf) {
		this.zxf = zxf;
	}

	public String getBz() {
		return this.bz;
	}

	public void setBz(String bz) {
		this.bz = bz;
	}

	public Zyb getZyb() {
		return zyb;
	}

	public void setZyb(Zyb zyb) {
		this.zyb = zyb;
	}

	public byte[] getZp() {
		return this.zp;
	}

	public void setZp(byte[] zp) {
		this.zp = zp;
	}

}