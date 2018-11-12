package kr.co.hk;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BoardDAO {

	public static BoardDAO dao;
	public BoardDAO(){}
	
	public static BoardDAO getInstance(){
		
		if(dao == null){
			dao = new BoardDAO();
		}
		return dao;
		
	}
	
	public List<CarVO> getList(){
		
		List<CarVO> list = new ArrayList<CarVO>();
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			
			String sql = " SELECT "
					+ " c_no, c_name, to_char(C_REGDATE, 'YYYY-MM-DD')as c_regdate, c_price "
					+ " FROM car_info ORDER BY c_no ";
			
			con = DBConnector.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				CarVO vo = new CarVO();
				
				vo.setC_no(rs.getInt("c_no"));
				vo.setC_name(rs.getString("c_name"));
				vo.setC_regdate(rs.getString("c_regdate"));
				vo.setC_price(rs.getInt("c_price"));
				
				list.add(vo);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBConnector.close(con, ps, rs);
		}
		
		return list;
	
	}
	
	public int getIndexC_no(){
		
		System.out.println("getIndex 시작");
		
		int id = 0;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			
			String sql = " SELECT nvl(max(c_no),10000)+1 as c_no from car_info ";
			
			con = DBConnector.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()){
				id = rs.getInt("c_no");
				System.out.println("c_no : " + id);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBConnector.close(con, ps, rs);
		}

		System.out.println("getIndex 끝");
		return id;
		
	}
	
	
	public void insert(int c_no, int com_no, String c_name, String c_type, String c_regdate, int c_price, int c_cc ){
		
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			
			String sql = " insert into car_info "
					+ " (c_no, com_no, c_name, c_type, c_regdate, c_price, c_cc ) "
					+ " VALUES "
					+ " ( (SELECT nvl(max(c_no),10000)+1 from car_info) "
					+ " , ? "
					+ " , ? "
					+ " , ? "
					+ " , ? "
					+ " , ? "
					+ " , ? ) ";
			
			con = DBConnector.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, com_no);
			ps.setString(2, c_name);
			ps.setString(3, c_type);
			ps.setString(4, c_regdate);
			ps.setInt(5, c_price);
			ps.setInt(6, c_cc);
			
			ps.executeQuery();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBConnector.close(con, ps, null);
		}
	}
	
	
	public int getIndexCom_no(){
		
		int com_no = 0;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			
			String sql = " SELECT nvl(max(com_no),70)+1 as com_no from COMPANY_INFO ";
			
			con = DBConnector.getConnection();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()){
				com_no = rs.getInt("com_no");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return com_no;
		
	}
	
	public void companyInsert(int com_no, String com_name, String com_addr){
		
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			
			String sql = " insert into COMPANY_INFO "
					+ " (com_no, com_name, com_addr, com_AMount, com_total) "
					+ " VALUES "
					+ " ((SELECT nvl(max(com_no),70)+1 from COMPANY_INFO)"
					+ " , ? "
					+ " , ?, 0 ,0 ) ";
			
			con = DBConnector.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, com_name);
			ps.setString(2, com_addr);
			ps.executeQuery();

		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBConnector.close(con, ps, null);
		}
		
	}
	
	//회사 list 출력
	public List<CompanyVO> getComList(){
		
		List<CompanyVO> list = new ArrayList<CompanyVO>();
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			
			String sql = " SELECT "
					+ " com_no, com_name "
					+ " FROM COMPANY_INFO ORDER by com_no ";

			con = DBConnector.getConnection();
			ps = con.prepareStatement(sql);
			rs =ps.executeQuery();
			
			while (rs.next()) {
				CompanyVO vo = new CompanyVO();
				
				vo.setCom_no(rs.getInt("com_no"));
				vo.setCom_name(rs.getString("com_name"));
				
				list.add(vo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBConnector.close(con, ps, rs);
		}
		return list;
	}
	
	public CarVO getDetail(int c_no){
		CarVO vo = new CarVO();
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			
			String sql = " SELECT "
					+ " a.c_no,b.com_no, b.com_name, a.c_name, a.c_type, to_char(a.c_regdate,'YYYY-MM-DD') as c_regdate , a.c_price, a.c_cc "
					+ " from car_info a "
					+ " left join COMPANY_INFO b "
					+ " on a.com_no = b.com_no "
					+ " GROUP by a.c_no, b.com_no, b.com_name, a.c_name, a.c_type, a.c_regdate, a.C_PRICE, a.c_cc "
					+ " HAVING a.c_no = ? ";
			
			con = DBConnector.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, c_no);
			rs = ps.executeQuery();
			
			while (rs.next()) {
				
				vo.setC_no(rs.getInt("c_no"));
				vo.setCom_no(rs.getInt("com_no"));
				vo.setCom_name(rs.getString("com_name"));
				vo.setC_name(rs.getString("c_name"));
				vo.setC_type(rs.getString("c_type"));
				vo.setC_regdate(rs.getString("c_regdate"));
				vo.setC_price(rs.getInt("c_price"));
				vo.setC_cc(rs.getInt("c_cc"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBConnector.close(con, ps, rs);
		}
		
		return vo;
		
	}
	
	public int updateCnt(int c_price, int com_no){
		
		int result = -1;
		
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			
			String sql = " UPDATE COMPANY_INFO "
					+ " SET com_amount = com_amount+1 "
					+ " ,com_total = com_total + ? "
					+ " where com_no = ? ";

			con = DBConnector.getConnection();
			ps = con.prepareStatement(sql);
			ps.setInt(1, c_price);
			ps.setInt(2, com_no);
			
			ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBConnector.close(con, ps, null);
		}
		return result;
		
	}
	
	public void carUpdate(CarVO vo){
		
		Connection con = null;
		PreparedStatement ps = null;
	
		try {
		
			String sql = " update CAR_INFO "
					+ " set c_name = ?, c_type = ?, c_regdate = ?, c_price = ?, c_cc = ? "
					+ " where c_no = ? ";
			
			con = DBConnector.getConnection();
			ps = con.prepareStatement(sql);
			ps.setString(1, vo.getC_name());
			ps.setString(2, vo.getC_type());
			ps.setString(3, vo.getC_regdate());
			ps.setInt(4, vo.getC_price());
			ps.setInt(5, vo.getC_cc());
			ps.setInt(6, vo.getC_no());
			
			ps.executeQuery();			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBConnector.close(con, ps, null);
		}
		
	}
	
	
	
	
	
	
}
