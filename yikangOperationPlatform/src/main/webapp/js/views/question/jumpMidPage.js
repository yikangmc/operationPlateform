function answerSubmit(){
	// var se = $("#paramForm").serialize();
	var userName = $("input[name='userName']").val();
	var content = $("textarea[name='content']").val();
	var reContent = content.replace("\t","").replace("\n","");
	if(userName.length==0){
		alert("用户名不可以为空!!!");
		return;
	}
	/*alert(reContent);
	if(reContent.length<=10){
		alert("回答内容不允许少于十个字！！！");
		return;
	}*/
	document.getElementById("paramForm").submit();
	/*$.ajax({
			type:'GET',
			url:'addAnswer',
			data:se,
			success:function(msg){
				if(true){
					
				}else{
					
				}
			}
		}
	)*/
}