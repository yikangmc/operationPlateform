var warnning = $("#warnningId").val();

QuestionList=function(){}
QuestionList.prototype={
		init:function(){
			
		},
		showDeleteQuestionModal:function(questionId){
			var questionTitleId="questionTitle"+questionId;
			var qTitle=$("#"+questionTitleId).text();
			$("#deleteQuestionTitleDiv").text(qTitle);
			$("#deleteQuestionId").val(questionId);
			$("#deleteQuestionModelDialog").modal("show");
		},
		deleteQuestion:function(){
			var paramData=$("#deleteQuestionForm").serialize();
			$.post(basePath+"question/deleteQuestion",paramData,function(data){
				if(null != data && data.status == "000000"){
					alert(data.message);
				}else{
					alert(data.message)
				}
				//questionList.relond();
				parent.location.reload();
			});
		},
		relond:function(){
			window.location.href=basePath+"question/questionList";
		}
}

var questionList=new QuestionList();
$(document).ready(function(){ 
	//alert(warnning);
}); 
