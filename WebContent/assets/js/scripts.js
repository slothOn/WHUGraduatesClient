
jQuery(document).ready(function() {
	
    /*
        Fullscreen background
    */
    $.backstretch([
                    "assets/img/backgrounds/2.jpg"
	              , "assets/img/backgrounds/3.jpg"
	              , "assets/img/backgrounds/1.jpg"
	             ], {duration: 3000, fade: 750});
    
    /*
        Form validation
    */
    $('.login-form input[type="text"], .login-form input[type="password"], .login-form textarea').on('focus', function() {
    	$(this).removeClass('input-error');
    });   
    $('.login-form').on('submit', function(e) {
    	$(this).find('input[type="text"], input[type="password"], textarea').each(function(){
    		if( $(this).val() == "" ) {
    			e.preventDefault();
    			$(this).addClass('input-error');
    		}
    		else {
    			$(this).removeClass('input-error');
    		}
    	});
    });
});
function checkform(){
	if($("#signform :password").get(0).value != $("#signform :password").get(1).value){
		alert("两次密码不一致重新注册");
		return;
	};
    var $inputs = $("#signform input");
	var $postobj = {};
    $postobj['sid'] = $inputs[0].value;
    $postobj['sname'] = $inputs[1].value;
    $postobj['password'] = $inputs[2].value;
    $postobj['captcha'] = $inputs[4].value;
	$.post('logup.html', JSON.stringify($postobj), function(data){
		if(data == '0'){
			alert('注册成功');
			$(".modal").modal('hide');
		}else if(data == '1'){
			alert('该账号已存在');
		}else{
			alert('验证码错误');
		}
	})
}
function refreshcap(){
	$(".capimg").attr("src","captcha.html");
}
