package kr.co.happy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class BoardDAO {

	private static BoardDAO dao; //객체 생성

	private BoardDAO() {}	// 기본생성자

	public static BoardDAO getInstance() { //싱글톤 (하나로 돌려쓸려고)
		if (dao == null) {
			dao = new BoardDAO();
		}
		return dao;
	}

	public ArrayList<BoardVO> getList(int intBtype) {
		ArrayList<BoardVO> list = new ArrayList<BoardVO>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			String sql = " select btype, seq, btitle, bcontent, bregdate from a_board where "
					+ " btype = " + intBtype + "ORDER BY seq DESC ";
			conn = DBConnector.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				BoardVO vo = new BoardVO();
				vo.setBtype(rs.getInt("btype"));
				vo.setSeq(rs.getInt("seq"));
				vo.setBtitle(rs.getString("btitle"));
				vo.setBcontent(rs.getString("bcontent"));
				vo.setBregdate(rs.getString("bregdate"));
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnector.close(conn, ps, rs);
		}
		return list;
	}

	public void insert(int btype, String btitle, String bcontent, String pw) {

		Connection conn = null;
		PreparedStatement ps = null;

		try {

			String sql = " INSERT INTO a_board "
					+ " (bid, btype, seq, btitle, bcontent, pw) "
					+ " VALUES "
					+ " ( (SELECT nvl(max(bid),0)+1 from a_board)"
					+ " ,?"
					+ " , (SELECT nvl(max(seq),0)+1 from a_board where btype = ?) "
					+ " , ?, ? ,? ) ";

			conn = DBConnector.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, btype);
			ps.setInt(2, btype);
			ps.setString(3, btitle);
			ps.setString(4, bcontent);
			ps.setString(5, pw);
			ps.executeQuery();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public BoardVO getDetail(int btype, int seq) {

		BoardVO vo = new BoardVO();

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {

			String sql = " SELECT btype, seq, btitle, bcontent, bregdate"
					+ " FROM a_board where btype = ? and seq = ?";
			
			conn = DBConnector.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, btype);
			ps.setInt(2, seq);
			rs = ps.executeQuery();
 
			if (rs.next()) {
				int btype2 = rs.getInt("btype");
				int seq2 = rs.getInt("seq");
				String btitle = rs.getString("btitle");
				String bcontent = rs.getString("bcontent");
				String bregdate = rs.getString("bregdate");
				
				vo.setBtype(btype2);
				vo.setSeq(seq2);
				vo.setBtitle(btitle);
				vo.setBcontent(bcontent);
				vo.setBregdate(bregdate);

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnector.close(conn, ps, rs);
		}

		return vo;

	}
	
	public void update(int btype, int seq, String btitle, String bcontent){
		
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			
			String sql = " update a_board "
					+ " set btitle = ?, bcontent = ? "
					+ " where btype = ? and seq = ? ";
			
			conn = DBConnector.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, btitle);
			ps.setString(2, bcontent);
			ps.setInt(3, btype);
			ps.setInt(4, seq);
			ps.executeQuery();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBConnector.close(conn, ps, null);
		}
		
	}
	
	public void deleteBoard(int btype, int seq){
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			
			String sql = " DELETE FROM a_board "
					+ " WHERE btype = ? and seq = ? ";
			
			conn = DBConnector.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, btype);
			ps.setInt(2, seq);
			
			ps.executeQuery();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBConnector.close(conn, ps, null);
		}
		
	}

}
