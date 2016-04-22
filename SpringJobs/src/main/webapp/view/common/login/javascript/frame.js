//로그인 체크
$(document).ready(function() {
	$.ajax({
		url : contextRoot + "/loginCheck",
		method : "POST",
		dataType : "json",
		headers : {
			"Accept" : "application/json",
			"Content-Type" : "application/json"
		},
		beforeSend : addLoading,
		complete : removeLoading,
		success : function(data, status) {
			console.log(data.user);
			if (data.user) {
				$('#loginTable').load('/view/common/login/loginSucess.html', function() {
					$('#uem').text(data.user.uem);
					if(!data.user.upho){//사진이 없을때
						$( "#upho" ).attr( "src", "/view/resources/img/unknown.jpg");
					}else{//사진이 있을때
						$( "#upho" ).attr( "src", data.user.upho);
					}
				});
				user=data.user;
			}else{
				user=null;
			}
		},
		error:function(req,status,error){
			callModal('경고','알수없는 에러');
			user=null;
		}
	});
	
	if ($('.main').height() > $('.sidenav').height()) {
		$('.sidenav').height($('.main').height());
	}
});
// 로그인 체크 끝

// sub 상단바 시작
$('.dropdown').hover(function() {
	$(this).find('.dropdown-menu').stop(true, true).delay(50).fadeIn();
}, function() {
	$(this).find('.dropdown-menu').stop(true, true).delay(50).fadeOut();
});
// sub 상단바 끝

// 로그인 이벤트
$('#loginButton').click(
		function() {
			$.ajax({
				url : contextRoot + "/login",
				method : "POST",
				dataType : "json",
				data : '{"uem":"' + $("#uem").val() + '","upw":"'
						+ $("#upw").val() + '"}',
				headers : {
					"Accept" : "application/json",
					"Content-Type" : "application/json"
				},
				//로딩 이미지 추가 필수부분 시작
				beforeSend : addLoading,
				complete : removeLoading,
				//로딩 이미지 추가 필수부분 끝
				success : function(data, status) {
					console.log(data);
					if (data.user) {
						alert("로그인 완료");
						location.reload();
					} else {
						user=null;
						callModal('경고','아이디, 비밀번호가 맞지 않습니다.');
					}
				},
				error:function(req,status,error){
					callModal('경고','알수없는 에러');
					user=null;
				}
			});
		});

redirect($('#signUp'),'/view/common/addUser/addUser.html');
redirect($('#addJob'),'/view/company/addJob/addJob.html');
redirect($('#projectList'),'/view/developer/projectList/projectList.html');
redirect($('#addProject'),'/view/company/addProject/addProject.html');
redirect($('#frame'),'/view/common/login/frame.html');