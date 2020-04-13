package com.gs.tour.shxt.a.web.login.service;
import com.gs.tour.shxt.a.web.login.dao.WebMemberDao;
import com.gs.tour.shxt.a.web.login.model.Member;
public class WebMemberService {
	WebMemberDao webMemberDao=new WebMemberDao();
	/**登录验证
	 * @throws Exception */
	public Member login(String account,String password) throws Exception{
		Member member=this.webMemberDao.login(account, password);
		if(member!=null){
			Integer member_status=member.getMember_status();
			if(member_status==0){
				throw new Exception("会员已经禁用，请联系客服");
			}else{
				return member;
			}
		}else{
			throw new Exception("账号密码不匹配，请重新输入");
		}
	}
	/**更新*/
	public Member load(Integer member_id){
		Member member;
		try {
			member=this.webMemberDao.load(member_id);
			return member;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	/**修改密码
	 * @throws Exception */
	public void updatePassword(Integer member_id,String password) throws Exception{
		try {
			this.webMemberDao.updatePassword(member_id, password);
		}catch (Exception e) {
			throw new Exception("密码修改失败！");
		}
	}
}
