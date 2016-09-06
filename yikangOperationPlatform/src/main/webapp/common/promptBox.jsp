<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<div class="modal fade" id="tsDialog" tabindex="-1" role="dialog"
	aria-labelledby="myModalLabel">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
				<h4 class="modal-title" id="deleteSnapDialogLabel">提示：</h4>
			</div>
			<div class="modal-body">
				<div class="container">
					<div class="row" id="prompt">
						<div class="col-sm-12"></div>
					</div>
				</div>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-default" data-dismiss="modal"
					id="confirm">确定</button>
			</div>
		</div>
	</div>
</div>