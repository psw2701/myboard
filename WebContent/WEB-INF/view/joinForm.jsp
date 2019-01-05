<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
   label{
      width:120px;
      float:left;
   }
   .error, .error2{
      color:red;
      font-size: 12px;
      display:none;      
   }
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
   $(function(){
      $("#f1").submit(function(){
         $(".error").css("display","none");
         $(".error2").css("display","none");
         
         var id = $("input[name='memberid']").val();
         if(id == ""){
            $("input[name='memberid']").nextAll(".error").css("display","inline");
            return false;/*submit을 막음*/
         }
         var regId = /^[a-z0-9]{6,15}$/i;
         if(regId.test(id) == false){
            $("input[name='memberid']").nextAll(".error2").css("display","inline");
            return false;
         }
         
         var name = $("input[name='name']").val();
         if(name == ""){
            $("input[name='name']").next().css("display","inline");
            return false;/*submit을 막음*/
         }
         var regName = /^[가-힣]{2,5}$/;
         if(regName.test(name) == false){
            $("input[name='name']").nextAll(".error2").css("display","inline");
            return false;
         }         
         
         var password = $("input[name='password']").val();
         if(password == ""){
            $("input[name='password']").next().css("display","inline");
            return false;/*submit을 막음*/
         }
         var regPassword = /^[a-z0-9!@#$%]{6,20}$/i;
         if(regPassword.test(password) == false){
            $("input[name='password']").nextAll(".error2").css("display", "inline");
            return false;
         }
         
         var confirmPassword = $("input[name='confirmPassword']").val();
         if(confirmPassword == ""){
            $("input[name='confirmPassword']").next().css("display","inline");
            return false;/*submit을 막음*/
         }
         if(password != confirmPassword){
            $("input[name='confirmPassword']").nextAll(".error2").css("display","inline");
            return false;
         }
         
         
         return true;
      });
      
      $("#duplicatedIdBtn").click(function(){
         var id = $("input[name='memberid']").val();
         
         $.ajax({
            url:"duplicatedId.do",
            type:"get",
            data:{"id":id},
            dataType:"json",
            success:function(data){
               console.log(data);
               if(data.result == true){
                  alert("사용중인 ID입니다.");
               }else{
                  alert("ID를 사용할 수 있습니다.");
               }
            }
         })
      })
      
   })
   
</script>
</head>
<body>
   <form action="join.do" method="post" id="f1">
      <p>
         <label>아이디</label>
         <input type="text" name="memberid" > 
         <button type="button" id="duplicatedIdBtn">중복체크</button>
         <span class="error">ID를 입력하세요</span>
         <span class="error2">영어, 숫자 (6~15)</span>
      </p>
      <p>
         <label>이름</label>
         <input type="text" name="name"> 
         <span class="error">이름을 입력하세요</span>
         <span class="error2">한글 (2~5)</span>
      </p>
      <p>
         <label>비밀번호</label>
         <input type="password" name="password"> 
         <span class="error">비밀번호를 입력하세요</span>
         <span class="error2">영어,숫자, 특수문자 (6~20)</span>
      </p>
      <p>
         <label>비밀번호 확인</label>
         <input type="password" name="confirmPassword"> 
         <span class="error">비밀번호 확인을 입력하세요</span>
         <span class="error2">비밀번호 일치하지 않습니다</span>
      </p>
      <p>         
         <input type="submit" value="회원가입"> 
      </p>
   </form>
</body>
</html>


