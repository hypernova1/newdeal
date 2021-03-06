<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/public.jsp"%>
<c:if test="${article eq null}">
<script>
alert('잘못된 접근');
location.href = "${root}/index.jsp";
</script>
</c:if>
<c:if test="${article ne null}">

	<!-- title -->
	<table width="100%" cellpadding="0" cellspacing="0" border="0">
		<tr>
			<td><img src="${root}/img/board/m_icon_board.gif" width="9"
				height="9" border="0" align="absmiddle" style="margin-top: -2px">
				<b>자유게시판</b> &nbsp;<font style="font-size: 8pt">|</font>&nbsp; 자유로운
				글을 올리는 공간입니다<br>
			</td>
			<td align="right"></td>
		</tr>
		<tr>
			<td colspan="2" height="19"></td>
		</tr>
	</table>

	<table border="0" cellpadding="0" cellspacing="0" width="100%">
		<form name="bbsForm" id="bbsbbs" method="post">
			<input type="hidden" name="" value="">
			<tr>
				<td valign="bottom" nowrap>
				  <img src="${root}/img/board/btn_write_01.gif" class="writeBtn"
					 width="64" height="22" border="0" align="absmiddle" alt="글쓰기">
					<img src="${root}/img/board/btn_reply.gif" class="replyBtn"
					 width="40" height="22" border="0" align="absmiddle" alt="답글">

					<c:if test="${userInfo.id == article.id}">
						<img src="${root}/img/board/btn_modify.gif" class="modifyBtn"
							border="0" align="absmiddle" alt="글수정">
						<img src="${root}/img/board/btn_delete.gif" class="deleteBtn"
							border="0" align="absmiddle" alt="글삭제">
					</c:if></td>
				<td valign="bottom" width="100%" style="padding-left: 4px"></td>
				<td align="right" nowrap valign="bottom">
				  <label class="newPage">최신목록</label>
				  <font color="#c5c5c5">|</font>
				  <label class="movePage">목록</label>
				  <font color="#c5c5c5">|</font>
				  <a href="javascript:goBbsRead();">
				    <img src="${root}/img/board/icon_up.gif" border="0" align="absmiddle" hspace="3">윗글
				  </a>
				  <font color="#c5c5c5">|</font>
				  <a href="javascript:goBbsRead();">아랫글
				    <img src="${root}/img/board/icon_down.gif" border="0" align="absmiddle" hspace="3">
				  </a>
			  </td>
			</tr>
			<tr>
				<td colspan="3" height="5" style="padding: 0px"></td>
			</tr>
		</form>
	</table>

	<table border="0" cellpadding="5" cellspacing="0" width="100%">
		<tr>
			<td class="bg_board_title_02" colspan="2" height="2"
				style="overflow: hidden; padding: 0px"></td>
		</tr>
		<tr height="28">
			<td class="bg_board_title" colspan="2" style="padding-left: 14px">
				<b><font class="text"> ${article.subject} </font></b>
			</td>
		</tr>
		<tr>
			<td class="bg_board_title_02" colspan="2" height="1" style="overflow: hidden; padding: 0px"></td>
		</tr>
		<tr height="26">
			<td width="100%" style="padding-left: 14px"><font class="stext">번호:</font>
				<font class="text_commentnum">${article.seq}</font> &nbsp;
				<font class="stext">글쓴이 :</font>
				<a href="javascript:;" onClick="showSideView();" class="link_board_02">${article.name}</a>
				<br>
			</td>
			<td style="padding-right: 14px" nowrap class="stext">조회 :
		    <font class="text_commentnum">${article.hit}</font> &nbsp; 스크랩 :
		    <font class="text_commentnum">0</font> &nbsp; 날짜 :
		    <font class="text_commentnum">${article.logtime}</font>
			</td>
		</tr>
		<tr>
			<td class="bg_board_title_02" colspan="2" height="1" style="overflow: hidden; padding: 0px"></td>
		</tr>
	</table>

	<table border="0" cellpadding="15" cellspacing="0" width="100%">
		<tr valign="top">
			<td bgcolor="#ffffff" width="100%" class="text"
				style="padding-bottom: 8px; line-height: 1.3" id="clix_content">
				<P>${article.content}</P>
			</td>
			<td nowrap valign="top" align="right" style="padding-left: 0px">
			</td>
		</tr>
	</table>

	<table width="100%" cellpadding="0" cellspacing="0" border="0">
		<tr>
			<td class="bg_board_title_02" height="1"
				style="overflow: hidden; padding: 0px"></td>
		</tr>
	</table>

	<!-- 하단 페이징 -->
	<table cellpadding="0" cellspacing="0" border="0" width="100%">
		<tr>
			<td colspan="3" height="5" style="padding: 0px"></td>
		</tr>
		<tr valign="top">
			<td valign="bottom" nowrap>
			  <img src="${root}/img/board/btn_write_01.gif" class="writeBtn" width="64"
				  height="22" border="0" align="absmiddle" alt="글쓰기">
			  <img src="${root}/img/board/btn_reply.gif" width="40" height="22"
				  border="0" align="absmiddle" alt="답글" class="replyBtn">
			</td>
			<td style="padding-left: 4px" width="100%"><a href=""
				target="new"><img src="${root}/img/board/btn_print.gif"
					width="30" height="18" border="0" align="absmiddle" alt="인쇄"></a></td>

			<td align="right" nowrap><label class="newPage">최신목록</label> <font
				color="#c5c5c5">|</font> <label class="movePage">목록</label> <font
				color="#c5c5c5">|</font> <img src="${root}/img/board/icon_up.gif"
				border="0" align="absmiddle" hspace="3">윗글 <font
				color="#c5c5c5">|</font> <a href="javascript:goBbsRead();">아랫글<img
					src="${root}/img/board/icon_down.gif" border="0" align="absmiddle"
					hspace="3"></a></td>
		</tr>
	</table>
	<br>
	<table cellpadding="5" cellspacing="5" border="0" width="100%">
		<tr>
			<td colspan="4"><textarea id="mcontent" style="resize: none;"
					rows="3" cols="200"></textarea>
				<button type="button" id="memoBtn">작성</button></td>
		</tr>
		<tbody id="memoview"></tbody>
	</table>
</c:if>
<script>

$('#seq').val(${article.seq});
initVars("${root}/reboard");

(function(){
  $.ajax({
    url: '${root}/memo/${article.seq}',
    type: 'GET',
    contentType: 'application/json;charset=utf-8',
    dataType: 'json',
    success: function(data){
      makeList(data);
    }
   })
})();

$('.newPage').click(function(){
	$('#page').val(1);
	$('#key').val("");
	$('#word').val("");
  $('#commonForm').attr('method', 'get').attr('action', listpath).submit();
});

$('.movePage').click(function(){
  $('#commonForm').attr('method', 'get').attr('action', listpath).submit();
});

$(".posting").click(function(){
  //alert($(this).children().first().text());
  $('#seq').val($(this).children().first().text());
  $('#commonForm').attr('method', 'get').attr('action', viewpath).submit();
});

$('.replyBtn').click(function(){
  $('#commonForm').attr('method', 'get').attr('action', replypath).submit();
});

$(document).on('click', '.viewMemoModifyBtn', function() {
  const mseq = $(this).parent('td').attr('memo-mseq');
  $('#div' + mseq).css('display', '');
})

$(document).on('click', '.memoDeleteBtn', function() {
  const mseq = $(this).parent('td').attr('memo-mseq');
  if(confirm('삭제??')){
		const mseq = $(this).parent('td').attr('memo-mseq');
		$.ajax({
       url: '${root}/memo/' + mseq + "/" + ${article.seq},
       type: 'DELETE',
       contentType: 'application/json;charset=utf-8',
       dataType: 'json',
       success: function(data){
         makeList(data);
       }
     });
  }
})

$(document).on('click', '.memoCancelBtn', function() {
  const mseq = $(this).parent('td').attr('memo-mseq');
  $('#div' + mseq).css('display', 'none');
})

$(document).on('click', '.memoModifyBtn', function() {
  const mseq = $(this).parents('td').attr('memo-mseq');
  $('#div' + mseq).css('display', 'none');
  const seq = '${article.seq}';
  const mcontent = $('#mcontent'+mseq).val();
  const param = JSON.stringify({mseq: mseq, seq: seq, mcontent: mcontent});
  
  if(mcontent.trim().length != 0){
    $.ajax({
      url: '${root}/memo/',
      type: 'PUT',
      contentType: 'application/json;charset=utf-8',
      dataType: 'json',
      data: param,
      success: function(data){
        makeList(data);
      }
    })
  }
})

$("#memoBtn").click(function(){
	const seq = "${article.seq}";
	const mcontent = $("#mcontent").val();
	$('#mcontent').val("");
	const param = JSON.stringify({seq: seq, mcontent: mcontent});
	
	if(mcontent.trim().length != 0){
		$.ajax({
			url: '${root}/memo',
			type: 'POST',
			contentType: 'application/json;charset=utf-8',
			dataType: 'json',
			data: param,
			success: function(data){
			    makeList(data);
			}
		})
	}
});

function makeList(memos){
   $('#memoview').empty();
   let output = '';
   const memolist = memos.memolist;
   memolist.forEach((memo, i) => {
     output += `<tr>
                 <td width='150' height='70'>`+memo.name+`</td>
                 <td>` + memo.mcontent + `</td>
                 <td width='200'>` + memo.mtime + `</td>`
     
     if(memo.id =='${userInfo.id}'){
       output +=
       `<td width='120' memo-mseq='` + memo.mseq + `'>
          <label class='viewMemoModifyBtn'>수정</label>
          <label class='memoDeleteBtn'>삭제</label>
        </td>
        </tr>
        <tr>
          <td colspan='4' memo-mseq='` + memo.mseq + `'>
            <div id='div` + memo.mseq + `' style="display:none">
              <textarea id='mcontent` + memo.mseq + `' style='resize: none;' rows='3' cols='200'>` + memo.mcontent + `</textarea>
              <button class='memoModifyBtn'>수정</button>
              <button class='memoCancelBtn'>취소</button>
            </div>
          </tr>
        </tr>`
     }
     output += `</tr>
                <tr>
                 <td class='bg_board_title_02' height='2' colspan='11'
                   style='overflow: hidden; padding: 0px'>
                 </td>
                </tr>`
   });
   $('#memoview').append(output);
 }

</script>
</body>
</html>