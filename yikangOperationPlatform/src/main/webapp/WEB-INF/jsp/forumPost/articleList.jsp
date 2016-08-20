<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<%@ include file="/common/head.jsp"%>
<title>帖子列表</title>
</head>
<body>
<script type="text/javascript" src="<%=path%>/js/views/forumPost/forumPost-upload.js"></script>
<script type="text/javascript" src="<%=path%>/js/views/forumPost/article.js"></script>
<div class="row">
		<div class="col-sm-12">
			<div class="box">

				<div class="box-header">
					<h3 class="box-title">帖子列表</h3>
				</div>
				<form id="paramForm" action="<%=basePath%>forumArticleMange/getAllArticleList" method="post" class="form-horizontal">
					<div class="row">
					<div class="col-sm-12">
						<div class="box box-info">
							<div class="box-header with-border">
								<h3 class="box-title">搜索</h3>
								<div class="box-tools pull-right">
									<button class="btn btn-box-tool" data-widget="collapse">
										<i class="fa fa-minus"></i>
									</button>
									<button class="btn btn-box-tool" data-widget="remove">
										<i class="fa fa-times"></i>
									</button>
								</div>
							</div>
							<div class="box-body" style="display: block;">
								<div class="box-body">
									<div for="operatorType" class="form-group">
										<label class="col-sm-2 control-label">帖子内容</label>
										<div class="col-sm-2">
											<input type="text" id="content" name="content" class="form-control"/>
										</div>
									</div>
								</div>
							</div>
							<div class="box-footer clearfix" style="display: block;">
								<button type="submit" class="btn btn-sm btn-info btn-flat pull-right">查询</button>
								<button type="reset"  class="btn btn-sm btn-default btn-flat pull-right">重置</button>
							</div>
						</div>
					</div>
				</div>
					<div class="box-body">
						<div id="example1_wrapper"
							class="dataTables_wrapper form-inline dt-bootstrap">
							<div class="row">
								<div class="col-sm-12">
									<table id="example1"
										class="table table-bordered table-striped dataTable"
										role="grid" aria-describedby="example1_info">
										<thead>
											<tr role="row">
												<!-- <th class="sorting_asc col-sm-1" tabindex="0" aria-controls="example1"
													rowspan="1" colspan="1" aria-sort="ascending"
													aria-label="Rendering engine: activate to sort column descending"
													>标题</th> -->
													<th class="sorting" tabindex="0" aria-controls="example1"
													rowspan="1" colspan="1"
													aria-label="Platform(s): activate to sort column ascending"
													>内容</th>
												<th class="sorting" tabindex="0" aria-controls="example1"
													rowspan="1" colspan="1"
													aria-label="Platform(s): activate to sort column ascending"
													>分类</th>
												<th class="sorting" tabindex="0" aria-controls="example1"
													rowspan="1" colspan="1"
													aria-label="Browser: activate to sort column ascending"
													>精华</th>
												<th class="sorting" tabindex="0" aria-controls="example1"
													rowspan="1" colspan="1"
													aria-label="Platform(s): activate to sort column ascending"
													>创建时间</th>
												<th class="sorting" tabindex="0" aria-controls="example1"
													rowspan="1" colspan="1"
													aria-label="Platform(s): activate to sort column ascending"
													>更新时间</th>
												<th class="sorting" tabindex="0" aria-controls="example1"
													rowspan="1" colspan="1"
													aria-label="Platform(s): activate to sort column ascending"
													>点赞数量</th>
												<th class="sorting" tabindex="0" aria-controls="example1"
													rowspan="1" colspan="1"
													aria-label="Platform(s): activate to sort column ascending"
													>分享次数</th>
												<th class="sorting" tabindex="0" aria-controls="example1"
													rowspan="1" colspan="1"
													aria-label="Platform(s): activate to sort column ascending"
													>分享链接</th>
												<th class="sorting" tabindex="0" aria-controls="example1"
													rowspan="1" colspan="1"
													aria-label="Platform(s): activate to sort column ascending"
													>推荐图片地址</th>
												
												<th class="sorting" tabindex="0" aria-controls="example1"
													rowspan="1" colspan="1"
													aria-label="Engine version: activate to sort column ascending"
													>用户信息</th>
												<th class="sorting" tabindex="0" aria-controls="example1"
													rowspan="1" colspan="1"
													aria-label="Engine version: activate to sort column ascending"
													>操作</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${articleList }" var="formPosts" varStatus="varIndex">
		<!-- 								 odd	even -->
												<tr role="row" class="${ varIndex.index % 2 eq 0 ? 'odd':'even' }">
													<td class="sorting_1">${formPosts.content }</td>
													<td>	
														<c:if test="${formPosts.forumPostGroup==1 }">文章</c:if>
														<c:if test="${formPosts.forumPostGroup==0 }">帖子</c:if>
													</td>
													<td>
														<c:if test="${formPosts.isEssence==1 }">是</c:if>
														<c:if test="${formPosts.isEssence==0 }">否</c:if>
													</td>
													<td><fmt:formatDate value="${formPosts.createTime }" type="both"/></td>
													<td><fmt:formatDate value="${formPosts.updateTime }" type="both"/></td>
													<td>${formPosts.stars }</td>
													<td>${formPosts.shareNum}</td>
													<td><a href = "${formPosts.shareUrl}">连接</a></td>
													<td>	
														${formPosts.recommendPicUrl}
														<%-- <c:if test="${formPosts.recommendPicUrl!=null && formPosts.recommendPicUrl !=''}">
															<img src="${formPosts.recommendPicUrl}" height="80" width="160"/>
														</c:if> --%>
													</td>
													<td>
														${formPosts.userName }
														<%-- <c:if test="${formPosts.photoUrl!=null && formPosts.photoUrl!=''}">
														<img src="${formPosts.photoUrl}" width="50" height="50"/><br /></c:if>
															${formPosts.userName } --%>
													</td>
													<td>
														<button class="btn btn-info" type="button" onclick="article.del(${formPosts.forumPostId},'<%=basePath%>')">删除</button>
													</td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>
							</div>
							
							<%@ include file="/common/page.jsp" %>
							
						</div>
					</div>
					<!-- /.box-body -->
				</form>
			</div>
		</div>
	</div>
	
</body>
</html>