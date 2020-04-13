package com.gs.tour.shxt.base.util;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.util.Streams;
import org.apache.commons.io.FilenameUtils;

public class UpLoadUtil {
	public static Map<String,Object> upload(HttpServletRequest request,String realPath,String localPath){
		Map<String,Object> map=new HashMap<String,Object>();
		//1判断当前请求是否为上传
		Boolean flg=ServletFileUpload.isMultipartContent(request);
		if(flg){//当前是上传
			//2.获取服务器上传路径
			String path=request.getSession().getServletContext().getRealPath(realPath);
			//3.建立联系，判断是否具有相应的文件夹
			File file=new File(path);
			if(!file.isDirectory()){
				file.mkdirs();//补全路径
			}
			//4.建立磁盘工厂
			DiskFileItemFactory factory=new DiskFileItemFactory();
			//5.创建ServletFileUpload
			ServletFileUpload upload=new ServletFileUpload(factory);
			try {
				//6.解析请求
				List<FileItem> fileItems=upload.parseRequest(request);
				//7.迭代器
				Iterator<FileItem> iterator=fileItems.iterator();
				InputStream is=null;
				while(iterator.hasNext()){
					//8.获取控件对象
					FileItem fileItem=iterator.next();
					//获取表单控件名
					String fieldName=fileItem.getFieldName();
					//9.获取流
					is=fileItem.getInputStream();
					//10.判断是否为普通控件
					if(fileItem.isFormField()){//11.这是普通控件
						String value=Streams.asString(is, "UTF-8");
						map.put(fieldName, value);
					}else{
						//12.获取原文件名
						String fileName=fileItem.getName();
						//13.判断文件名是否存在
						if(fileName!=null&&fileName.trim().length()>0){
							//14.获取后缀名
							String ext=FilenameUtils.getExtension(fileName);
							//15.创建新的文件名称
							String newName=UUID.randomUUID().toString()+"."+ext;
							//16.构建输出通道
							File out_File=new File(path+"/"+newName);//服务器的
							File out_File1=new File(localPath+"/"+newName);//本地
							FileOutputStream os=new FileOutputStream(out_File);
							FileOutputStream os1=new FileOutputStream(out_File1);
							//17.读和写
							byte[] b=new byte[1024];
							int len=-1;
							while((len=is.read(b))!=-1){
								os.write(b, 0, len);
								os1.write(b, 0, len);
							}
							//18.关闭流
							is.close();
							os.flush();
							os.close();	
							os1.flush();
							os1.close();
							map.put(fieldName, request.getContextPath()+realPath+"/"+newName);
						}
					}
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return map;
	}
}
