console.log("main.js loaded.");

//이메일, 비밀번호 미작성시 로그인 막기
const loginForm = document.querySelector("#loginForm"); //form태그
const loginEmail = document.querySelector("#loginForm input[name='memberEmail']"); //이메일 input 태그
const loginPw = document.querySelector("#loginForm input[name='memberPw']"); //비밀번호 input 태그

//#loginForm이 화면에 존재할때 (== 로그인 상태 아닐때)
//->타임리프에 의해 로그인되었다면 #loginForm 요소는 화면에 노출되지 않음
//->로그인 상태일때 loginForm을 이용한 코드가 수행된다면
//->콘솔창에 error 발생

if(loginForm != null) {

  //제출 이벤트 발생시
  loginForm.addEventListener("submit", e => {

    //이메일 미작성
    if(loginEmail.value.trim().length === 0) {
      alert("이메일을 작성해주세요!");
      e.preventDefault(); //소괄호 꼭 붙여주기 기본이벤트(제출) 막는것
      loginEmail.focus(); //초점 이동
      return;
    }
    //비밀번호 미작성
    if(loginPw.value.trim().length === 0) {
      alert("비밀번호를 작성해주세요!");
      e.preventDefault(); //소괄호 꼭 붙여주기 기본이벤트(제출) 막는것
      loginPw.focus(); //초점 이동
      return;
    }
  });

}