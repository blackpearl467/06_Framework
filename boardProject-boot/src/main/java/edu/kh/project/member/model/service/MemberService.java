package edu.kh.project.member.model.service;

import java.util.List;

import edu.kh.project.member.model.dto.Member;

public interface MemberService {

	/** 로그인 서비스
	 * @param inputMember
	 * @return 
	 */
	Member login(Member inputMember);

	/** 이메일 중복검사 서비스
	 * @param memberEmail
	 * @return
	 * @author 김보경
	 */
	int checkEmail(String memberEmail);

	/**닉네임 중복 검사 서비스
	 * @param memberNickname
	 * @return
	 */
	int checkNickname(String memberNickname);

	/**회원가입 서비스
	 * @param inputMember
	 * @param memberAddress
	 * @return result
	 */
	int signup(Member inputMember, String[] memberAddress);

	/**회원 목록 조회(비동기)
	 * @return
	 */
	List<Member> selectMemberList();

	/**특정회원 비밀번호 초기화(pass01!)(비동기)
	 * @param inputNo
	 * @return
	 */
	int resetPw(int inputNo);

	/**회원 탈퇴 복구(비동기)
	 * @param inputNo
	 * @return
	 */
	int restoreMember(int inputNo);

}
