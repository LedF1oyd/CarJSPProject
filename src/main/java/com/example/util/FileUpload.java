package com.example.util;

import com.example.bean.CarVO;
import com.example.dao.CarDAO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

public class FileUpload {
    public CarVO uploadPhoto(HttpServletRequest request){
        String filename="";
        int sizeLimit = 50*1024*1024;

        String realPath = request.getServletContext().getRealPath("upload");

        File dir=new File(realPath);
        if(!dir.exists()) {dir.mkdirs();System.out.println("디렉토리 생성");}
        else{
            System.out.println("디렉토리 존재");
        }
        System.out.println(realPath);
        System.out.println(filename);

        CarVO one = null;
        MultipartRequest multipartRequest =null;
        try{
            multipartRequest = new MultipartRequest(request, realPath,sizeLimit, "utf-8",new DefaultFileRenamePolicy());
            filename=multipartRequest.getFilesystemName("photo");
            System.out.println(filename);
            one = new CarVO();
            String carid=multipartRequest.getParameter("carid");

            if(carid!=null&&!carid.equals("")) {
                one.setCarid(Integer.parseInt(carid));
            }
            one.setBrand(multipartRequest.getParameter("brand"));
            one.setCarType(multipartRequest.getParameter("carType"));
            one.setCarName(multipartRequest.getParameter("carName"));
            one.setColor(multipartRequest.getParameter("color"));
            one.setPhoto(multipartRequest.getParameter("photo"));
            one.setManufacturedDay(multipartRequest.getParameter("manufacturedDay"));
            one.setMileage(multipartRequest.getParameter("mileage"));
            one.setWarranty(multipartRequest.getParameter("warranty"));
            one.setOptions(multipartRequest.getParameter("options"));
            one.setDescription(multipartRequest.getParameter("description"));
            one.setPrice(multipartRequest.getParameter("price"));
            if(carid!=null&&!carid.equals("")) {
                CarDAO dao = new CarDAO();
                String oldfilename = dao.getPhotoFilename(Integer.parseInt(carid));
                if(filename!=null&& oldfilename!=null){
                    FileUpload.deleteFile(request, oldfilename);
                }
                else if(filename==null && oldfilename!=null){
                    filename=oldfilename;
                }


            }
            one.setPhoto(filename);
            System.out.println(one.getPhoto());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("파일명:"+filename);


        return one;

    }
    public static void deleteFile(HttpServletRequest request, String filename){
        String filePath = request.getServletContext().getRealPath("upload");
        File f = new File(filePath + "/"+ filename);
        if(f.exists()) f.delete();
    }

}
