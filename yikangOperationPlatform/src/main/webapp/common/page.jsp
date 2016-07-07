<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" 		prefix="c"%>
	
	<div class="row">
		<div class="col-sm-12">
			<div class="col-sm-5">
				<div class="dataTables_length" id="example1_length">
					<input type="hidden" name="currentPage" value="${page.currentPage }">
					<label>显示 
						<select name="pageSize" onchange="submitPage()"  aria-controls="example1" class="form-control input-sm">
								<option value="10" ${page.pageSize==10?"selected":""}>10</option>
								<option value="25" ${page.pageSize==25?"selected":""}>25</option>
								<option value="50" ${page.pageSize==50?"selected":""}>50</option>
								<option value="100" ${page.pageSize==100?"selected":""}>100</option>
						</select> 条
					</label>
				</div>
				<div class="dataTables_info" id="example1_info" role="status"
					aria-live="polite">显示 ${(page.currentPage-1)*page.pageSize+1} to ${(page.currentPage-1)*page.pageSize+page.pageSize} 共 ${page.totalPage } 页
				</div>
			</div>
			<div class="col-sm-7">
				<div class="dataTables_paginate paging_simple_numbers"
					id="example1_paginate">
					<ul class="pagination">
						<li class="paginate_button previous disabled" id="example1_previous">
							<a href="#" aria-controls="example1" data-dt-idx="0" tabindex="0">上一页</a>
						</li>
						
						<c:if test="${page.currentPage != 1  }">
							<li class="paginate_button active">
								<a href="#" aria-controls="example1" data-dt-idx="1" tabindex="0">1</a>
							</li>
						</c:if>
						
						<c:if test="${page.currentPage-2 >0 }">
							<li class="paginate_button ">
								<a href="#" aria-controls="example1" data-dt-idx="${page.currentPage-2 }" tabindex="0">${page.currentPage-2 }</a>
							</li>
						</c:if>
						<c:if test="${page.currentPage-1 >0}">
							<li class="paginate_button ">
								<a href="#" aria-controls="example1" data-dt-idx="${page.currentPage-1 }" tabindex="0">${page.currentPage-1 }</a>
							</li>
						</c:if>
						<li class="paginate_button ">
							<a href="#" aria-controls="example1" data-dt-idx="${page.currentPage }" tabindex="0">${page.currentPage }</a>
						</li>
						<c:if test="${page.currentPage+1<page.totalPage  }">
							<li class="paginate_button ">
								<a href="#" aria-controls="example1" data-dt-idx="${page.currentPage+1 }" tabindex="0">${page.currentPage+1 }</a>
							</li>
						</c:if>
						<c:if test="${page.currentPage+2<page.totalPage  }">
							<li class="paginate_button ">
								<a href="#" aria-controls="example1" data-dt-idx="${page.currentPage+2 }" tabindex="0">${page.currentPage+2 }</a>
							</li>
						</c:if>
						<c:if test="${page.currentPage != page.totalPage  }">
							<li class="paginate_button ">
								<a href="#" aria-controls="example1" data-dt-idx="${page.totalPage}" tabindex="0">${page.totalPage }</a>
							</li>
						</c:if>
						<li class="paginate_button next" >
							<a href="javascript:lastPage()" id="page_next" aria-controls="example1" data-dt-idx="${page.currentPage+1 }" tabindex="0" onclick="lastPage()">下一页</a>
						</li>
					</ul>
				</div>
			</div>
		</div>
	</div>

<script type="text/javascript">
	function prePage(){
		submitPage();
	}
	
	function lastPage(){
		$("input[name='currentPage']").val($("#page_next").attr("data-dt-idx"));
		submitPage();
	}
	
	function submitPage(){
		document.forms['paramForm'].submit();
	}
	
</script>