package com.springjobs.domain;

public class Ctags {
	private int cexno;
	private String cextg;
	private int cno;
	
	public int getCexno() {
		return cexno;
	}
	public void setCexno(int cexno) {
		this.cexno = cexno;
	}
	public String getCextg() {
		return cextg;
	}
	public void setCextg(String cextg) {
		this.cextg = cextg;
	}
	public int getCno() {
		return cno;
	}
	public void setCno(int cno) {
		this.cno = cno;
	}
	@Override
	public String toString() {
		return "Ctags [cexno=" + cexno + ", cextg=" + cextg + ", cno=" + cno + "]";
	}


	
}
