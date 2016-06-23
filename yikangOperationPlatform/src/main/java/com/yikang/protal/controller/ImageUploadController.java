package com.yikang.protal.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.yikang.common.utils.FileUtil;
import com.yikang.common.utils.SystemProperties;

@Controller
public class ImageUploadController {

	@RequestMapping
	public void uplodaImg(@RequestParam("upload") MultipartFile file, //
			HttpServletRequest request, //
			HttpServletResponse response, //
			@RequestParam("CKEditorFuncNum") String CKEditorFuncNum)//
			throws IllegalStateException, IOException {

		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		String fileName = file.getOriginalFilename();
		String uploadContentType = file.getContentType();
		String expandedName = "";
		if (uploadContentType.equals("image/pjpeg") || uploadContentType.equals("image/jpeg")) {
			// IE6上传jpg图片的headimageContentType是image/pjpeg，而IE9以及火狐上传的jpg图片是image/jpeg
			expandedName = ".jpg";
		} else if (uploadContentType.equals("image/png") || uploadContentType.equals("image/x-png")) {
			// IE6上传的png图片的headimageContentType是"image/x-png"
			expandedName = ".png";
		} else if (uploadContentType.equals("image/gif")) {
			expandedName = ".gif";
		} else if (uploadContentType.equals("image/bmp")) {
			expandedName = ".bmp";
		} else {
			out.println("<script type=\"text/javascript\">");
			out.println("window.parent.CKEDITOR.tools.callFunction(" + CKEditorFuncNum + ",'',"
					+ "'文件格式不正确（必须为.jpg/.gif/.bmp/.png文件）');");
			out.println("</script>");
			return;
		}
		if (file.getSize() > 600 * 1024) {
			out.println("<script type=\"text/javascript\">");
			out.println("window.parent.CKEDITOR.tools.callFunction(" + CKEditorFuncNum + ",''," + "'文件大小不得大于600k');");
			out.println("</script>");
			return;
		}
//		DateFormat df = new SimpleDateFormat(DEFAULT_SUB_FOLDER_FORMAT_AUTO);
//		fileName = df.format(new Date()) + expandedName;
//		file.transferTo(new File(PROJECT_PATH + UPLOAD_PATH + fileName));
		// 返回"图像"选项卡并显示图片 request.getContextPath()为web项目名
		String url= SystemProperties.getPropertieValue("fileManageUrl");
		String res=FileUtil.uploadFile(url,file.getBytes(),file.getOriginalFilename());
		String resUrl=new ObjectMapper().readTree(res).get("data").get("fileUrl").toString().replace("\"","");
		out.println("<script type=\"text/javascript\">");
		out.println("window.parent.CKEDITOR.tools.callFunction(" + CKEditorFuncNum + ",'"  + resUrl + "','')");
		out.println("</script>");
		return;
	}

}
