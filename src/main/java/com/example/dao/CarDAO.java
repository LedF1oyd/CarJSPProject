package com.example.dao;

import com.example.bean.CarVO;
import com.example.util.JDBCUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarDAO {
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;

    private final String CAR_INSERT = "insert into secondHandCar (brand,carType,carName,color, photo, manufacturedDay, mileage, warranty, options, description, price ) values (?,?,?,?,?,?,?,?,?,?,?)";

    public int insertCar(CarVO vo) {
        System.out.println("===> JDBC로 insertCar() 기능 처리");
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(CAR_INSERT);
            stmt.setString(1, vo.getBrand());
            stmt.setString(2, vo.getCarType());
            stmt.setString(3, vo.getCarName());
            stmt.setString(4, vo.getColor());
            stmt.setString(5, vo.getPhoto());
            stmt.setString(6, vo.getManufacturedDay());
            stmt.setString(7, vo.getMileage());
            stmt.setString(8, vo.getWarranty());
            stmt.setString(9, vo.getOptions());
            stmt.setString(10, vo.getDescription());
            stmt.setString(11, vo.getPrice());
            stmt.executeUpdate();
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(vo.getBrand() + "-" + vo.getCarType() + "-" + vo.getCarName() + "-" + vo.getColor()+ "-"
                + vo.getPhoto() + "-" + vo.getManufacturedDay() + "-" + vo.getMileage()+ "-" + vo.getWarranty() + "-"
                + vo.getOptions() + "-" + vo.getDescription()+ "-" + vo.getPrice());
        return 0;
    }
    private final String CAR_UPDATE = "update secondHandCar set brand=?, carType=?, carName=?, color=?, photo=?, manufacturedDay=?, mileage=?, warranty=?, options=?, description=?, price=? where carId=?";

    public int updateCar(CarVO vo) {
        System.out.println("===> JDBC로 updateCar() 기능 처리");
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(CAR_UPDATE);
            stmt.setString(1, vo.getBrand());
            stmt.setString(2, vo.getCarType());
            stmt.setString(3, vo.getCarName());
            stmt.setString(4, vo.getColor());
            stmt.setString(5, vo.getPhoto());
            stmt.setString(6, vo.getManufacturedDay());
            stmt.setString(7, vo.getMileage());
            stmt.setString(8, vo.getWarranty());
            stmt.setString(9, vo.getOptions());
            stmt.setString(10, vo.getDescription());
            stmt.setString(11, vo.getPrice());
            stmt.setInt(12, vo.getCarid());


            System.out.println(vo.getBrand() + "-" + vo.getCarType() + "-" + vo.getCarName() + "-" + vo.getColor()+ "-"
                    + vo.getPhoto() + "-" + vo.getManufacturedDay() + "-" + vo.getMileage()+ "-" + vo.getWarranty() + "-"
                    + vo.getOptions() + "-" + vo.getDescription()+ "-" + vo.getPrice());
            stmt.executeUpdate();
            return 1;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
    private final String CAR_DELETE = "delete from secondHandCar  where carid=?";

    public void deleteCar(CarVO vo) {
        System.out.println("===> JDBC로 deleteCar() 기능 처리");
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(CAR_DELETE);
            stmt.setInt(1, vo.getCarid());
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private final String CAR_GET = "select * from secondHandCar  where carid=?";
    public CarVO getCar(int carid) {
        CarVO one = new CarVO();
        System.out.println("===> JDBC로 getCar() 기능 처리");
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(CAR_GET);
            stmt.setInt(1, carid);
            rs = stmt.executeQuery();
            if(rs.next()) {
                one.setCarid(rs.getInt("carid"));
                one.setBrand(rs.getString("brand"));
                one.setCarType(rs.getString("carType"));
                one.setCarName(rs.getString("carName"));
                one.setColor(rs.getString("color"));
                one.setPhoto(rs.getString("photo"));
                one.setManufacturedDay(rs.getString("manufacturedDay"));
                one.setMileage(rs.getString("mileage"));
                one.setWarranty(rs.getString("warranty"));
                one.setOptions(rs.getString("options"));
                one.setDescription(rs.getString("description"));
                one.setPrice(rs.getString("price"));


            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return one;
    }
    private final String CAR_LIST = "select * from secondHandCar order by carid desc";

    public List<CarVO> getCarList(){
        List<CarVO> list = new ArrayList<CarVO>();
        System.out.println("===> JDBC로 getCarList() 기능 처리");
        try {
            conn = JDBCUtil.getConnection();
            stmt = conn.prepareStatement(CAR_LIST);
            rs = stmt.executeQuery();
            while(rs.next()) {
                CarVO one = new CarVO();
                one.setCarid(rs.getInt("carid"));
                one.setBrand(rs.getString("brand"));
                one.setCarType(rs.getString("carType"));
                one.setCarName(rs.getString("carName"));
                one.setColor(rs.getString("color"));
                one.setPhoto(rs.getString("photo"));
                one.setManufacturedDay(rs.getString("manufacturedDay"));
                one.setMileage(rs.getString("mileage"));
                one.setWarranty(rs.getString("warranty"));
                one.setOptions(rs.getString("options"));
                one.setDescription(rs.getString("description"));
                one.setPrice(rs.getString("price"));
                one.setRegDate(rs.getDate("regDate"));
                list.add(one);
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    private final String C_SELECT ="select * from secondHandCar  where carid=?";
    public CarVO getOne(int carid){
        CarVO one=null;
        conn=JDBCUtil.getConnection();
        try{
            stmt=conn.prepareStatement(C_SELECT);
            stmt.setInt(1,carid);
            rs=stmt.executeQuery();
            if(rs.next()) {
                one=new CarVO();
                one.setCarid(rs.getInt("carid"));
                one.setBrand(rs.getString("brand"));
                one.setCarType(rs.getString("carType"));
                one.setCarName(rs.getString("carName"));
                one.setColor(rs.getString("color"));
                one.setPhoto(rs.getString("photo"));
                one.setManufacturedDay(rs.getString("manufacturedDay"));
                one.setMileage(rs.getString("mileage"));
                one.setWarranty(rs.getString("warranty"));
                one.setOptions(rs.getString("options"));
                one.setDescription(rs.getString("description"));
                one.setPrice(rs.getString("price"));

            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return one;
    }
    public String getPhotoFilename(int carid){
        String filename =null;
        try{
            conn =JDBCUtil.getConnection();
            stmt = conn.prepareStatement(C_SELECT);
            stmt.setInt(1, carid);
            rs = stmt.executeQuery();
            if(rs.next()){
                filename = rs.getString("photo");
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("===> JEBC로 getPhotoFilename() 기능 처리");
        return filename;
    }
}
