/**
 * @author liushuai
 * @date 2016-07-12 14:20
 * @desc 创建问题
 */

var QuestionCreate=function(){}

QuestionCreate.prototype={
		init:function(){
			
		},
		checkParam:function(){
			var userName=$("#userName").val();
			var title=$("#title").val();
			var taglibId=$("input[name='taglibId']:checked").val();
			
			if(null == userName || userName.length < 6){
				alert("用户名不能为空！");
				return false;
			}
			if(null == title || title.length < 10){
				alert("标题不能为空！ 长度要大于10");
				return false;
			}
			
			if(typeof(taglibId) == "undefined" || taglibId == ''){
				alert('请选择标签！');
				return false;
			}
			var formData=$("#paramForm").serialize();
			$.post(basePath+"question/questionSave",formData,function(data){
				if(null != data){
					alert(data.message);
					questionCreate.reload($("#userName").val());
				}
			});
			
		},
		saveQuestion:function(data){
			
		},
		reload:function(userName){
			window.location.href=basePath+"question/questionCreate?userName="+userName;
		}

}
var questionCreate=new QuestionCreate();
questionCreate.init();
