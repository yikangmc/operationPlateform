var QuestionAnswer=function(){}
QuestionAnswer.prototype={
		init:function(){
			
		},
		del:function(questionAnswerId,basePath){
			if(confirm("确定要删除吗？")){
			$.post(basePath+"/questionAnswer/deleteQuestionAnswer", { "questionAnswerId": questionAnswerId }, function (data,status) {
              if (status == "success") {
                  alert("删除成功！");
                  window.location.reload();
              }
          });
			}
		},
		updateEssencea:function(questionAnswerId,basePath){
			if(confirm("确定要设为精华吗？")){
				$.post(basePath+"/questionAnswer/isEssenceQuestionAnswer", { "questionAnswerId": questionAnswerId}, function (data,status) {
					if(null != data && data.status == "000000"){
						alert(data.message);
					}else{
						alert(data.message);
					}
					questionAnswer.relond();
				});		        
			}
		},		
		cancelEssencea:function(questionAnswerId,basePath){
			if(confirm("确定要取消精华吗？")){
				$.post(basePath+"/questionAnswer/cancelEssenceQuestionAnswer", { "questionAnswerId": questionAnswerId}, function (data,status) {
					if(null != data && data.status == "000000"){
						alert(data.message);
					}else{
						alert(data.message);
					}
					questionAnswer.relond();
				});		        
			}
		},
		relond:function(){
			window.location.href=basePath+"questionAnswer/questionAnswerList";
		}
}

var questionAnswer=new QuestionAnswer();
questionAnswer.init();