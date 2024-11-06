package edu.kh.project.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.kh.project.member.model.dto.Member;
import edu.kh.project.member.model.service.MemberService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

/*
 * @SessionAttributes( {"key", "key", "key" ...} )
 * -Model에 추가된 속성 중
 * 	key값이 일치하는 속성을 session scope로 변경
 * */


@SessionAttributes({"loginMember"})
@Controller
@Slf4j //log 찍을일이 있으면 생성
@RequestMapping("member")
public class MemberController {
	
	@Autowired //의존성 주입(DI)
	private MemberService service;
	
	/*
	 * [로그인]
	 * -특정 사이트에 아이디/비밀번호 등을 입력해서
	 *  해당 정보가 있으면 조회/서비스 이용
	 * 
	 * -로그인한 회원정보를 session에 기록하여
	 *  로그아웃 또는 브라우저 종료시까지
	 *  해당 정보를 계속 이용할 수 있게 함
	 * 
	 * */
	/** alt shift j
	 * @param inputMember : 커맨드 객체 (@ModelAttribute 생략)
	 * 						memberEmail, memberPw 세팅된 상태 -> ModelAttribute의 역할
	 * @param ra : 리다이렉트시 request scope로 데이터 전달하는 객체(request -> session -> request)
	 * @param model : 데이터 전달용 객체 (기본 request scope)
	 * 					/ (@SessionAttributes 어노테이션과 함께 이용시 session scope 이동)												 
	 * @param saveId 
	 * @param resp
	 * @return
	 */
	@PostMapping("login")
	public String login(/* @ModelAttribute 생략가능 */Member inputMember,
						RedirectAttributes ra,
						Model model,
						@RequestParam(value="saveId", required=false) String saveId,
						HttpServletResponse resp ) {
		
		//로그인 서비스 호출
		Member loginMember = service.login(inputMember); //커맨드객체
		
		//로그인 실패시
		if(loginMember == null) {
			ra.addFlashAttribute("message", "아이디 또는 비밀번호가 일치하지않습니다");
		} else {
			//Session scope에 loginMember 추가
			model.addAttribute("loginMember", loginMember);
			//1단계: request scope에 세팅됨
			//2단계: 클래스 위에 @SessionAttribute() 어노테이션 작성하여
			//		 session scope 로 이동
			}
		
		return "redirect:/"; //로그인되면 메인페이지 재요청
	}
	
	
	
	/**로그아웃: session 에 저장된 로그인된 회원정보를 없앰
	 * @param SessionStatus : @SessionAttributes 로 지정된 
	 * 						  특정속성을 세션에서 제거기능 제공 객체
	 * @return
	 */
	@GetMapping("logout")
	public String logout(SessionStatus status) {
			
		status.setComplete(); //세션을 완료시킴 (== 세션에서 @SessionAttributes로 등록된 세션 제거)
		
		return "redirect:/";
	}
}