package kr.co.happy;

public class BoardVO {
	private int bid;
	private String btitle;
	private String bcontent;
	private int btype;
	private int seq;
	private String pw;
	private String bregdate;
	
	public BoardVO() {}
	
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getBtitle() {
		return btitle;
	}
	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}
	public String getBcontent() {
		return bcontent;
	}
	public void setBcontent(String bcontent) {
		this.bcontent = bcontent;
	}
	public int getBtype() {
		return btype;
	}
	public void setBtype(int btype) {
		this.btype = btype;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getBregdate() {
		return bregdate;
	}
	public void setBregdate(String bregdate) {
		this.bregdate = bregdate;
	}
	
	
	
}
