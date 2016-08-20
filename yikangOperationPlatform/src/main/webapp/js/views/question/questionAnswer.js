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
		}
}

var questionAnswer=new QuestionAnswer();
questionAnswer.init();