package com.kosmo.bangdairy.controller;

import java.lang.ProcessBuilder.Redirect;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.kosmo.bangdairy.aop.LoggerAspect;
import com.kosmo.bangdairy.service.AdminService;
import com.kosmo.bangdairy.vo.AccountFormVO;
import com.kosmo.bangdairy.vo.CommentVO;
import com.kosmo.bangdairy.vo.DairyVO;
import com.kosmo.bangdairy.vo.IndieVO;
import com.kosmo.bangdairy.vo.QnaVO;
import com.nexacro17.xapi.data.DataSet;
import com.nexacro17.xapi.data.DataTypes;
import com.nexacro17.xapi.data.PlatformData;
import com.nexacro17.xapi.data.datatype.DataType;
import com.nexacro17.xapi.tx.HttpPlatformResponse;
import com.nexacro17.xapi.tx.PlatformException;
import com.nexacro17.xapi.tx.PlatformType;

@Controller
public class AdminController {
	
	String[] kibanaSrc = {"http://192.168.0.111:5601/app/kibana#/dashboard/993d3740-da31-11ea-845d-b7d4065f2f30?embed=true&_g=(refreshInterval:(pause:!f,value:5000),time:(from:now-1y,mode:quick,to:now))&_a=(description:'%EC%98%81%ED%99%94+%EB%8C%80%EC%89%AC+%EB%B3%B4%EB%93%9C',filters:!(),fullScreenMode:!f,options:(darkTheme:!f,hidePanelTitles:!f,useMargins:!t),panels:!((embeddableConfig:(mapCenter:!(38.548165423046584,0.5273437500000001),mapZoom:2),gridData:(h:19,i:'1',w:35,x:0,y:0),id:b8bb9280-da2f-11ea-845d-b7d4065f2f30,panelIndex:'1',type:visualization,version:'6.4.3'),(embeddableConfig:(),gridData:(h:20,i:'2',w:35,x:0,y:19),id:'59f2c830-da30-11ea-845d-b7d4065f2f30',panelIndex:'2',type:visualization,version:'6.4.3'),(embeddableConfig:(),gridData:(h:11,i:'3',w:13,x:35,y:28),id:'7e505260-da30-11ea-845d-b7d4065f2f30',panelIndex:'3',type:visualization,version:'6.4.3'),(embeddableConfig:(),gridData:(h:16,i:'4',w:13,x:35,y:12),id:'0ef9f8d0-da30-11ea-845d-b7d4065f2f30',panelIndex:'4',type:visualization,version:'6.4.3'),(embeddableConfig:(),gridData:(h:12,i:'6',w:13,x:35,y:0),id:c7241ee0-da30-11ea-845d-b7d4065f2f30,panelIndex:'6',type:visualization,version:'6.4.3')),query:(language:kuery,query:''),timeRestore:!f,title:'%EC%98%81%ED%99%94+%EB%8C%80%EC%89%AC%EB%B3%B4%EB%93%9C',viewMode:view)",
			"http://115.91.88.227:60013/app/kibana#/dashboard/8716c640-da35-11ea-845d-b7d4065f2f30?embed=true&_g=(refreshInterval:(pause:!t,value:0),time:(from:now%2Fy,mode:quick,to:now%2Fy))&_a=(description:'%EB%A6%AC%EB%B7%B0+%EB%8C%80%EC%89%AC%EB%B3%B4%EB%93%9C',filters:!(),fullScreenMode:!f,options:(darkTheme:!f,hidePanelTitles:!f,useMargins:!t),panels:!((embeddableConfig:(),gridData:(h:15,i:'1',w:12,x:0,y:0),id:c17ee400-da32-11ea-845d-b7d4065f2f30,panelIndex:'1',type:visualization,version:'6.4.3'),(embeddableConfig:(),gridData:(h:17,i:'2',w:12,x:36,y:0),id:'5282b860-da32-11ea-845d-b7d4065f2f30',panelIndex:'2',type:visualization,version:'6.4.3'),(embeddableConfig:(),gridData:(h:15,i:'3',w:24,x:12,y:0),id:'7b3a9c00-da32-11ea-845d-b7d4065f2f30',panelIndex:'3',title:'%EB%8D%B0%EC%9D%B4%ED%84%B0+%EB%93%B1%EB%A1%9D%EC%9D%BC',type:visualization,version:'6.4.3'),(embeddableConfig:(),gridData:(h:14,i:'4',w:12,x:36,y:17),id:f685fbd0-da31-11ea-845d-b7d4065f2f30,panelIndex:'4',type:visualization,version:'6.4.3'),(embeddableConfig:(),gridData:(h:16,i:'5',w:36,x:0,y:15),id:'13350da0-da34-11ea-845d-b7d4065f2f30',panelIndex:'5',type:visualization,version:'6.4.3')),query:(language:kuery,query:''),timeRestore:!f,title:'%EB%A6%AC%EB%B7%B0+%EB%8C%80%EC%89%AC%EB%B3%B4%EB%93%9C',viewMode:view)",
			"http://115.91.88.227:60013/app/kibana#/dashboard/f2156ff0-daad-11ea-a819-fd499e3e18c2?embed=true&_g=(refreshInterval:(pause:!t,value:0),time:(from:now%2Fy,mode:quick,to:now%2Fy))&_a=(description:'%EB%8B%A4%EC%9D%B4%EC%96%B4%EB%A6%AC+%EB%B3%B4%EB%93%9C',filters:!(),fullScreenMode:!f,options:(darkTheme:!f,hidePanelTitles:!f,useMargins:!t),panels:!((embeddableConfig:(),gridData:(h:15,i:'1',w:27,x:13,y:0),id:'9bf90600-daac-11ea-a819-fd499e3e18c2',panelIndex:'1',type:visualization,version:'6.4.3'),(embeddableConfig:(),gridData:(h:30,i:'2',w:17,x:12,y:15),id:'9e6defe0-daa7-11ea-a819-fd499e3e18c2',panelIndex:'2',type:visualization,version:'6.4.3'),(embeddableConfig:(),gridData:(h:15,i:'3',w:8,x:40,y:0),id:'682c0390-daa7-11ea-a819-fd499e3e18c2',panelIndex:'3',type:visualization,version:'6.4.3'),(embeddableConfig:(),gridData:(h:15,i:'4',w:12,x:0,y:30),id:bc488200-daac-11ea-a819-fd499e3e18c2,panelIndex:'4',type:visualization,version:'6.4.3'),(embeddableConfig:(),gridData:(h:15,i:'5',w:12,x:0,y:15),id:d902c950-daac-11ea-a819-fd499e3e18c2,panelIndex:'5',type:visualization,version:'6.4.3'),(embeddableConfig:(),gridData:(h:30,i:'6',w:19,x:29,y:15),id:'0e245180-daad-11ea-a819-fd499e3e18c2',panelIndex:'6',type:visualization,version:'6.4.3'),(embeddableConfig:(),gridData:(h:15,i:'7',w:13,x:0,y:0),id:'74f8c800-daad-11ea-a819-fd499e3e18c2',panelIndex:'7',type:visualization,version:'6.4.3')),query:(language:kuery,query:''),timeRestore:!f,title:'%EB%8B%A4%EC%9D%B4%EC%96%B4%EB%A6%AC+%EB%B3%B4%EB%93%9C',viewMode:view)",
			"http://115.91.88.227:60013/app/kibana#/dashboard/b56ced30-dab2-11ea-a819-fd499e3e18c2?embed=true&_g=(refreshInterval:(pause:!t,value:0),time:(from:now%2Fy,mode:quick,to:now%2Fy))&_a=(description:'%EC%BD%94%EB%A7%A8%ED%8A%B8+%EB%8C%80%EC%89%AC%EB%B3%B4%EB%93%9C',filters:!(),fullScreenMode:!f,options:(darkTheme:!f,hidePanelTitles:!f,useMargins:!t),panels:!((embeddableConfig:(),gridData:(h:19,i:'1',w:11,x:12,y:0),id:ab434300-dab1-11ea-a819-fd499e3e18c2,panelIndex:'1',type:visualization,version:'6.4.3'),(embeddableConfig:(),gridData:(h:24,i:'2',w:12,x:0,y:11),id:'3c1feae0-dab2-11ea-a819-fd499e3e18c2',panelIndex:'2',type:visualization,version:'6.4.3'),(embeddableConfig:(),gridData:(h:11,i:'3',w:12,x:0,y:0),id:'7123b1e0-dab2-11ea-a819-fd499e3e18c2',panelIndex:'3',type:visualization,version:'6.4.3'),(embeddableConfig:(),gridData:(h:16,i:'4',w:36,x:12,y:19),id:bf00aae0-dab1-11ea-a819-fd499e3e18c2,panelIndex:'4',type:visualization,version:'6.4.3'),(embeddableConfig:(),gridData:(h:19,i:'5',w:25,x:23,y:0),id:d9388d10-dab1-11ea-a819-fd499e3e18c2,panelIndex:'5',type:visualization,version:'6.4.3')),query:(language:kuery,query:''),timeRestore:!f,title:'%EC%BD%94%EB%A7%A8%ED%8A%B8+%EB%8C%80%EC%89%AC%EB%B3%B4%EB%93%9C',viewMode:view)"};
	@Autowired
	AdminService adminService;
	/*
	 * 메소드 명 		: goAdminPage
	 * 기능			: 세션에서 유저타입이 0인 유저를 adminMain페이지로 이동시킨다
	 * 변수			: session
	 * 작성자			: 박윤태
	 */
	@RequestMapping(value = "/admin",method = RequestMethod.GET)
	public ModelAndView goAdminPage(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		String type = (String) session.getAttribute("userType");
		if(type!=null) {
			if (type.equals("0")) {
				mv.setViewName("admin/adminMain");
			}else {
				mv.setViewName("redirect:/index.jsp");
			}
		}else {
			mv.setViewName("redirect:/index.jsp");
		}
		return mv;
	}
	/*
	 * 메소드 명 		: getList
	 * 기능			: 어드민 페이지에 리스트를 페이지 수에 맞게 띄워준다
	 * 						searchWord가 all이 아니면 들어온 값으로 시작하는 검색조건으로 시작하는
	 * 						리스트를 띄워준다
	 * 						type = movie,user,diary,comment,qna
	 * 변수			: type,searchWord, page
	 * 작성자			: 박윤태
	 */
	@ResponseBody
	@RequestMapping(value = "/admin/{type}/{searchWord}/{page}",method = RequestMethod.POST)
	public ModelAndView getList(@PathVariable(value = "type")String type,
			@PathVariable(value = "searchWord")String searchWord,
			@PathVariable(value = "page")String page) {
		ModelAndView mv = new ModelAndView();
		HashMap hash = new HashMap();
		searchWord = searchWord.replace(" ", "");
		hash.put("page", Integer.parseInt(page)*10);
		if(!searchWord.equals("all")) {
			hash.put("searchWord", searchWord);
			mv.addObject("search",searchWord);
		}
		List list = null;
		switch (type) {
			case "movie":
				list = adminService.getMovie(hash);
				mv.setViewName("admin/adminMovie");
				break;
			case "user":
				list = adminService.getUser(hash);
				mv.setViewName("admin/adminUser");
				break;
			case "diary":
				list = adminService.getDiary(hash);
				mv.setViewName("admin/adminDiary");
				break;
			case "comment":
				list = adminService.getComment(hash);
				mv.setViewName("admin/adminComment");
				break;
			case "qna":
				 list = adminService.getQna(hash);
				mv.setViewName("admin/adminQna");
				break;
			case "indie":
				 list = adminService.getIndieList(hash);
				 LoggerAspect.logger.info("IndieList : "+list);
				mv.setViewName("admin/adminIndie");
				break;
			case "score":
				list = adminService.getUserScore(hash);
				mv.setViewName("admin/adminScore");
				break;
			default:
				break;
		}
		mv.addObject("list", list);
		return mv;
	}
	/*
	 * 메소드명		: updateQnaAnswer
	 * 기능			: 입력한 답변을 db에 update
	 * 변수			: QnaVO
	 * 작성자			: 박윤태
	 */
	@ResponseBody
	@RequestMapping(value = "/admin/qna/answer",method = RequestMethod.POST)
	public int updateQnaAnswer(QnaVO vo) {
		vo.setQnaStatus(1);
		int result =adminService.updateQnaAnswer(vo);
		return result;
	}
	/*
	 * 메소드명		: getQnaAnswer
	 * 기능			: 입력된 답변을 리턴
	 * 변수			: QnaVO
	 * 작성자			: 박윤태
	 */
	@ResponseBody
	@RequestMapping(value = "/admin/qna/answer/get",method = RequestMethod.POST,
			produces = "application/text; charset=utf8")

	public String getQnaAnswer(QnaVO vo) {
		QnaVO qvo =adminService.getQnaAnswer(vo);
		System.out.println(qvo);
		return qvo.getQnaAnswer();
	}
	/*
	 * 메소드명		: getIndieOne
	 * 기능			: 저장된 인디영화의 정보를 html로 띄워줌
	 * 변수			: IndieVO
	 * 작성자			: 박윤태
	 */
	@ResponseBody
	@RequestMapping(value = "/admin/indie/show",method = RequestMethod.POST)
	public ModelAndView getIndieOne(IndieVO vo) {
		IndieVO ivo = adminService.getIndieOne(vo);
		ModelAndView mv = new ModelAndView();
		mv.addObject("vo", ivo);
		mv.setViewName("admin/indieInfo");
		return mv;
	}
	/*
	 * 메소드명		: updateIndieConfirm
	 * 기능			: 인디 영화의 허가 여부를 바꾼다
	 * 변수			: IndieVO
	 * 작성자			: 박윤태
	 */
	@ResponseBody
	@RequestMapping(value = "/admin/indie/confirm",method = RequestMethod.POST)
	public int updateIndieConfirm(IndieVO vo) {
		int result = adminService.updateIndieConfirm(vo);
		return result;
	}
	/*
	 * 메소드명		: getManagePage
	 * 기능			: 통계페이지를 KIBANA와 연동해 띄운다
	 * 변수			: Type
	 * 작성자			: 박윤태
	 */
	@ResponseBody
	@RequestMapping(value = "/admin/manage/{type}",method = RequestMethod.POST)
	public ModelAndView getManagePage(@PathVariable(value = "type")String type) {
		ModelAndView mv = new ModelAndView();
		switch (type) {
		case "movie":
			mv.addObject("src", kibanaSrc[0]);
			break;
		case "review":
			mv.addObject("src", kibanaSrc[1]);
			break;
		case "diary":
			mv.addObject("src", kibanaSrc[2]);
			break;
		case "comment":
			mv.addObject("src", kibanaSrc[3]);
			break;
		default:
			break;
		}
		mv.setViewName("admin/adminManagePage");
		return mv;
	}
	/*
	 * 메소드명		: userBanList
	 * 기능			: 넥사크로 연동
	 * 변수			: Account_FormVO
	 * 작성자			: 이경호
	 */

	@RequestMapping(value = "/adminUserBanList")
	public void userBanList(HttpServletRequest request,HttpServletResponse response) {
		//키워드 받아서 검색하기
		String keyword = request.getParameter("param");
		AccountFormVO avo = new AccountFormVO();
		avo.setUserId(keyword);
		
		//유저 밴목록 DB에서 불러오기
		List<AccountFormVO> list = adminService.getUserBanList(avo);
		//넥사크로와 바인딩 될 데이터셋
		DataSet ds = new DataSet("rename");
		ds.addColumn("user_id",DataTypes.STRING,256);
		ds.addColumn("user_email",DataTypes.STRING,256);
		
		for(AccountFormVO vo : list) {
			int row = ds.newRow();
			ds.set(row, "user_id", vo.getUserId());
			ds.set(row, "user_email", vo.getUserEmail());
			
		}
		
		PlatformData pData = new PlatformData();
		pData.addDataSet(ds);
		HttpPlatformResponse res = 
				new HttpPlatformResponse(response,PlatformType.CONTENT_TYPE_XML,"utf-8");
		res.setData(pData);	
		try {
			res.sendData();
		} catch (PlatformException e) {
			e.printStackTrace();
		}
	}
	/*
	 * 메소드명		: allowUser
	 * 기능			: 넥사크로 연동 / 유저 밴 해제
	 * 변수			: Account_FormVO
	 * 작성자			: 이경호
	 */
	@RequestMapping(value = "/adminAllowUser")
	public void allowUser(HttpServletRequest request, HttpServletResponse response,
							AccountFormVO vo) {
		adminService.allowUser(vo);
	}
	/*
	 * 메소드명		:banUser
	 * 기능			:유저를 벤한다
	 * 변수			:AccountFormVO
	 * 작성자			:박윤태
	 */
	@ResponseBody
	@RequestMapping(value = "/admin/user/ban",method = RequestMethod.POST)
	public int banUser(AccountFormVO vo) {
		int result = adminService.banUser(vo);
		return result;
	}
	/*
	 * 메소드명		:deleteComment
	 * 기능			:코멘트를 삭제한다
	 * 변수			:CommentVO
	 * 작성자			:박윤태
	 */
	@ResponseBody
	@RequestMapping(value = "/admin/comment/delete",method = RequestMethod.POST)
	public int deleteComment(CommentVO vo) {
		int result = adminService.deleteComment(vo);
		return result;
	}
}
