User=function(){}
User.prototype={
		init:function(){
//			$("#buttonSubmit").onClick(this.saveUser());
		},
		saveUser:function(){
			var paramData=$("#userForm").serialize();
			$.post(basePath+"user/saveUser",paramData,function(data){
				
			});
		},
		validateUserInfo:function(){
			
		}
}
var user=new User();
user.init();
$().ready(function(){
	
	 	var windowsArr = [];
	    var marker = [];
	    var mapObj = new AMap.Map("mapContainer", {
	            resizeEnable: true,
	            center: [116.397428, 39.90923],//地图中心点
	            zoom: 13,//地图显示的缩放级别
	            keyboardEnable: false
	    });
	    AMap.plugin(['AMap.Autocomplete','AMap.PlaceSearch'],function(){
	      var autoOptions = {
	        city: "北京", //城市，默认全国
	        input: "inputMapPositionAddress"//使用联想输入的input的id
	      };
	      autocomplete= new AMap.Autocomplete(autoOptions);
	      var placeSearch = new AMap.PlaceSearch({
	            city:'北京',
	            map:mapObj
	      })
	      AMap.event.addListener(autocomplete, "select", function(e){
	         //TODO 针对选中的poi实现自己的功能
	         placeSearch.search(e.poi.name);
	         
	         //设置模糊搜索地址
	         $("#inputMapPositionAddress").val(e.poi.name);
	         $("#districtCode").val(e.poi.adcode);
	         
	      });
	    });
});