<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<%@ include file="/common/head.jsp"%>
<title>文章列表</title>
</head>
<body>
	<script type="text/javascript"
		src="<%=path%>/js/views/forumPost/forumPost-upload.js"></script>
	<script type="text/javascript"
		src="<%=path%>/js/views/forumPost/forumPost.js"></script>

	<div class="row">
		<div class="col-sm-12">
			<div class="box">
				<div class="box-header">
					<h3 class="box-title">文章列表</h3>
				</div>
				<form id="paramForm" action="<%=basePath%>forumPosts/formPostList"
					method="post" class="form-horizontal">

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
										<div class="form-group">
											<label for="content" class="col-sm-2 control-label">文章标题</label>
											<div class="col-sm-3">
												<input type="text" id="title" name="title"
													class="form-control" value="${title}"> </input>
											</div>
											<label class="col-sm-2 control-label">文章内容</label>
											<div class="col-sm-3">
												<input type="text" id="content" name="content"
													class="form-control" value="${content }" />
											</div>
										</div>
										<div for="operatorType" class="form-group">
											<label class="col-sm-2 control-label">是否精华</label>
											<div class="col-sm-3">
												<select class="form-control" name="isEssence">
													<option value="" ${isEssence== null?"selected":"" }>全部</option>
													<option value="0" ${isEssence==0?"selected":"" }>非精华</option>
													<option value="1" ${isEssence==1?"selected":"" }>精华</option>
												</select>
											</div>

											<label class="col-sm-2 control-label">审核状态</label>
											<div class="col-sm-3">
												<select class="form-control" name="dataStatus">
													<option value="4" ${dataStatus== 4?"selected":"" }>全部</option>
													<option value="1" ${dataStatus==1?"selected":"" }>未处理</option>
													<option value="2" ${dataStatus==2?"selected":"" }>不通过</option>
													<option value="3" ${dataStatus==3?"selected":"" }>通过</option>
												</select>
											</div>

										</div>
										<div class="form-group">
											<label class="col-sm-2 control-label">用户名字</label>
											<div class="col-sm-3">
												<input type="text" id="userName" name="userName"
													class="form-control" value="${userName}"> </input>
											</div>
											<label class="col-sm-2 control-label">日期选择</label>
											<div class="input-group col-sm-3">
												<div class="input-group-addon">
													<i class="fa fa-calendar"></i>
												</div>
												<input type="text" class="form-control pull-right "
													id="reservation" name="reservation" value="${reservation }">
											</div>
										</div>
										<div class="form-group">
											<label class="col-sm-2 control-label">用户名字</label>
											<div class="col-sm-3">
												<input type="text" id="userNameOther" name="userNameOther"
													class="form-control" value="${userNameOther}"> </input>
											</div>
										</div>
										
									</div>
									<div class="box-footer clearfix" style="display: block;">
										<button type="submit"
											class="btn btn-sm btn-info btn-flat pull-right">查询</button>
										<button type="reset"
											class="btn btn-sm btn-default btn-flat pull-right">重置</button>
									</div>
								</div>
							</div>
						</div>
						</div>
						<div id="example1_wrapper"
							class="dataTables_wrapper form-inline dt-bootstrap">
							<div class="row">
								<div class="col-sm-12">
									<table id="example1"
										class="table table-bordered table-striped dataTable"
										role="grid" aria-describedby="example1_info">
										<thead>
											<tr role="row">
												<th class="sorting_asc col-sm-1" tabindex="0"
													aria-controls="example1" aria-sort="ascending"
													aria-label="Rendering engine: activate to sort column descending">标题</th>
												<th class="sorting" tabindex="0" aria-controls="example1"
													aria-label="Platform(s): activate to sort column ascending">分类</th>
												<th class="sorting" tabindex="0" aria-controls="example1"
													aria-label="Browser: activate to sort column ascending">精华</th>
												<th class="sorting" tabindex="0" aria-controls="example1"
													aria-label="Platform(s): activate to sort column ascending">创建时间</th>
												<th class="sorting" tabindex="0" aria-controls="example1"
													aria-label="Platform(s): activate to sort column ascending">更新时间</th>
												<th class="sorting" tabindex="0" aria-controls="example1"
													aria-label="Platform(s): activate to sort column ascending">点赞数量</th>
												<th class="sorting" tabindex="0" aria-controls="example1"
													aria-label="Platform(s): activate to sort column ascending">分享次数</th>
												<th class="sorting" tabindex="0" aria-controls="example1"
													aria-label="Platform(s): activate to sort column ascending">分享链接</th>
												<th class="sorting" tabindex="0" aria-controls="example1"
													aria-label="Platform(s): activate to sort column ascending">推荐图片地址</th>

												<th class="sorting" tabindex="0" aria-controls="example1"
													aria-label="Engine version: activate to sort column ascending">用户信息</th>
												<th class="sorting_asc col-sm-1" tabindex="0"
													aria-controls="example1"
													aria-label="Engine version: activate to sort column ascending">审核状态</th>
												<th class="sorting" tabindex="0" aria-controls="example1"
													aria-label="Engine version: activate to sort column ascending">操作</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${formPostsList }" var="formPosts"
												varStatus="varIndex">
												<!-- 								 odd	even -->
												<tr role="row"
													class="${ varIndex.index % 2 eq 0 ? 'odd':'even' }">
													<td class="sorting_1">${formPosts.title }</td>
													<td><c:if test="${formPosts.forumPostGroup==1 }">文章</c:if>
														<c:if test="${formPosts.forumPostGroup==0 }">帖子</c:if></td>
													<td><c:if test="${formPosts.isEssence==1 }">是</c:if> <c:if
															test="${formPosts.isEssence==0 }">否</c:if></td>
													<td><fmt:formatDate value="${formPosts.createTime }"
															type="both" /></td>
													<td><fmt:formatDate value="${formPosts.updateTime }"
															type="both" /></td>
													<td>${formPosts.stars }</td>
													<td>${formPosts.shareNum}</td>
													<td><a target="_blank" href="${formPosts.shareUrl}">连接</a></td>
													<td>${formPosts.recommendPicUrl}<%-- <c:if test="${formPosts.recommendPicUrl!=null && formPosts.recommendPicUrl !=''}">
															<img src="${formPosts.recommendPicUrl}" height="80" width="160"/>
														</c:if> --%>
													</td>
													<td>
														<%-- <c:if test="${formPosts.photoUrl!=null && formPosts.photoUrl!=''}">
														<img src="${formPosts.photoUrl}" width="50" height="50"/><br /></c:if> --%>
														${formPosts.userName }
													</td>
													<td><c:if test="${formPosts.dataStatus==1 }">未处理</c:if>
														<c:if test="${formPosts.dataStatus==2 }">不通过</c:if> <c:if
															test="${formPosts.dataStatus==3 }">通过 </c:if></td>
													<td><c:if test="${formPosts.isEssence==0 }">
															<button class="btn btn-info "
																onclick="forumPost.updateEssence(${formPosts.forumPostId},'<%=basePath%>')">设为精华</button>
														</c:if> <c:if test="${formPosts.isEssence==1 }">
															<button class="btn batn-info "
																onclick="forumPost.cancelEssence(${formPosts.forumPostId},'<%=basePath%>')">取消精华</button>
														</c:if> <a
														href="<%=basePath%>forumPosts/updateForumPosts?forumPostsId=${formPosts.forumPostId}"
														class="btn btn-info ">修改</a> <c:if
															test="${formPosts.dataStatus==3 }">
															<button class="btn btn-info "
																onclick="forumPost.noStatus(${formPosts.forumPostId},'<%=basePath%>')">不通过</button>
														</c:if> <c:if test="${formPosts.dataStatus==2 }">
															<button class="btn btn-info "
																onclick="forumPost.del(${formPosts.forumPostId},'<%=basePath%>')">删除</button>
															<button class="btn btn-info "
																onclick="forumPost.okStatus(${formPosts.forumPostId},'<%=basePath%>')">通过</button>
														</c:if> <c:if test="${formPosts.dataStatus==1 }">
															<button class="btn btn-info "
																onclick="forumPost.del(${formPosts.forumPostId},'<%=basePath%>')">删除</button>
															<button class="btn btn-info "
																onclick="forumPost.okStatus(${formPosts.forumPostId},'<%=basePath%>')">通过</button>
															<button class="btn btn-info "
																onclick="forumPost.noStatus(${formPosts.forumPostId},'<%=basePath%>')">不通过</button>
														</c:if></td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>
							</div>

							<%@ include file="/common/page.jsp"%>

						</div>
				</form>
			</div>
		</div>
	</div>
	<script>
		$(document).ready(function() {
		       $('#reservation').daterangepicker();

		});
	</script>
</body>
</html>