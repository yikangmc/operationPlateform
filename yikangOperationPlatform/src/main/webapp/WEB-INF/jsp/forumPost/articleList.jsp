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
<div class="row">
		<div class="col-sm-12">
			<div class="box">

				<div class="box-header">
					<h3 class="box-title">帖子列表</h3>
				</div>

				<form id="paramForm" action="<%=basePath%>forumArticleMange/getAllArticleList" method="post">
					<!-- /.box-header -->
					<div class="box-body">
						<div id="example1_wrapper"
							class="dataTables_wrapper form-inline dt-bootstrap">
							<div class="row">
								<div class="col-sm-6">
									<div id="example1_filter" class="dataTables_filter">
										<label>Search:
										<input type="search" class="form-control input-sm" placeholder="搜索" aria-controls="example1"></label>
										<input type="search" class="" placeholder="搜索" aria-controls="example1"></label>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-sm-12">
									<table id="example1"
										class="table table-bordered table-striped dataTable"
										role="grid" aria-describedby="example1_info">
										<thead>
											<tr role="row">
												<th class="sorting_asc" tabindex="0" aria-controls="example1"
													rowspan="1" colspan="1" aria-sort="ascending"
													aria-label="Rendering engine: activate to sort column descending"
													style="width: 144px;">帖子标题</th>
												<th class="sorting" tabindex="0" aria-controls="example1"
													rowspan="1" colspan="1"
													aria-label="Browser: activate to sort column ascending"
													style="width: 180px;">是否精华</th>
												<th class="sorting" tabindex="0" aria-controls="example1"
													rowspan="1" colspan="1"
													aria-label="Platform(s): activate to sort column ascending"
													style="width: 158px;">创建时间</th>
												<th class="sorting" tabindex="0" aria-controls="example1"
													rowspan="1" colspan="1"
													aria-label="Platform(s): activate to sort column ascending"
													style="width: 158px;">更新时间</th>
												<th class="sorting" tabindex="0" aria-controls="example1"
													rowspan="1" colspan="1"
													aria-label="Platform(s): activate to sort column ascending"
													style="width: 158px;">点赞数量</th>
												<th class="sorting" tabindex="0" aria-controls="example1"
													rowspan="1" colspan="1"
													aria-label="Platform(s): activate to sort column ascending"
													style="width: 158px;">分享次数</th>
												<th class="sorting" tabindex="0" aria-controls="example1"
													rowspan="1" colspan="1"
													aria-label="Platform(s): activate to sort column ascending"
													style="width: 158px;">分享链接</th>
												<th class="sorting" tabindex="0" aria-controls="example1"
													rowspan="1" colspan="1"
													aria-label="Platform(s): activate to sort column ascending"
													style="width: 158px;">推荐图片地址</th>
												<th class="sorting" tabindex="0" aria-controls="example1"
													rowspan="1" colspan="1"
													aria-label="Platform(s): activate to sort column ascending"
													style="width: 158px;">帖子类型</th>
												<th class="sorting" tabindex="0" aria-controls="example1"
													rowspan="1" colspan="1"
													aria-label="Engine version: activate to sort column ascending"
													style="width: 123px;">文章唯一标识</th>
												<th class="sorting" tabindex="0" aria-controls="example1"
													rowspan="1" colspan="1"
													aria-label="Engine version: activate to sort column ascending"
													style="width: 123px;">用户信息</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${articleList }" var="formPosts" varStatus="varIndex">
		<!-- 								 odd	even -->
												<tr role="row" class="${ varIndex.index % 2 eq 0 ? 'odd':'even' }">
													<td class="sorting_1">${formPosts.title }</td>
													<td><c:if test="${formPosts.isEssence==1 }">是</c:if>
														<c:if test="${formPosts.isEssence==0 }">否</c:if>
													</td>
													<td><fmt:formatDate value="${formPosts.createTime }" type="both"/></td>
													<td><fmt:formatDate value="${formPosts.updateTime }" type="both"/></td>
													<td>${formPosts.stars }</td>
													<td>${formPosts.shareNum}</td>
													<td><a href = "${formPosts.shareUrl}">${formPosts.shareUrl}</a></td>
													<td>	<c:if test="${formPosts.recommendPicUrl!=null && formPosts.recommendPicUrl !=''}">
															<img src="${formPosts.recommendPicUrl}" height="100" width="200"/>
														</c:if>
													</td>
													<td>${formPosts.forumPostGroup}</td>
													<td>${formPosts.forumPostsUuid}</td>
													<td>
														<c:if test="${formPosts.photoUrl!=null && formPosts.photoUrl!=''}">
														<img src="${formPosts.photoUrl}" width="50" height="50"/><br /></c:if>
															${formPosts.userName }
													</td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>
							</div>
							
							<%@ include file="/common/page.jsp"%>
							
						</div>
					</div>
					<!-- /.box-body -->
				</form>
			</div>
		</div>
	</div>
	
</body>
</html>