package com.yikang.protal.controller;

import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import com.yikang.protal.entity.UserRecordNumber;
import com.yikang.protal.base.BaseController;
import com.yikang.protal.common.page.PageParameter;
import com.yikang.protal.entity.FormPosts;
import com.yikang.protal.service.UserRecordNumberService;

@Controller
public class UserRecordNumberController extends BaseController {

	@Autowired
	private UserRecordNumberService userRecordNumberService;

	/**
	 * 按账号查询任意日期区间个人的记录条数（ a.提出的问题 b.回答过的问题数量 c.发过的帖子数量 d.发过的专家说数量 ）
	 * 
	 * @author bry
	 * @time 2016.10.26 15:16
	 * @param modelMap
	 * @return
	 */
	@RequestMapping
	public String userRecordNumber(String userName, String reservation, ModelMap modelMap, PageParameter page,
			HttpServletRequest req) {
		if (null != reservation && (!(reservation.equals("")))) {

			String[] time = reservation.split("-");
			String[] first = time[0].split("/");
			String[] last = time[time.length - 1].split("/");

			String firstTime = first[first.length - 1].trim() + "-" + first[0].trim() + "-"
					+ first[first.length - 2].trim() + " 00:00:00";
			String lastTime = last[last.length - 1].trim() + "-" + last[0].trim() + "-" + last[last.length - 2].trim()
					+ " 23:59:59";
			modelMap.put("firstTime", firstTime);
			modelMap.put("lastTime", lastTime);
		}
		modelMap.put("userName", userName);
		modelMap.put("reservation", reservation);
		UserRecordNumber userRecordNumber = userRecordNumberService.userRecordNumber(modelMap);
		modelMap.put("userRecordNumber", userRecordNumber);
		return "user/userRecordNumber";
	}

}
