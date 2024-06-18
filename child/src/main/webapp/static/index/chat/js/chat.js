$('.conLeft li').on('click',function(){
		$(this).addClass('bg').siblings().removeClass('bg');
		var intername=$(this).children('.liRight').children('.intername').text();
		$('.headName').text(intername);
		$('.newsList').html('');
	})
	$('.sendBtn').on('click',function(){
		var news=$('#dope').val();
		if(news==''){
			alert('不能为空');
		}else{
			$('#dope').val('');
		var str='';
		str+='<li>'+'<div class="nesHead">';
		str+='<img src="'+path+'img/6.jpg"/>';
		str+='</div>'+'<div class="news"><img class="jiao" src="'+path+'img/20170926103645_03_02.jpg">'+news+'</div>'+
			'</li>';
		$('.newsList').append(str);
		$('.conLeft').find('li.bg').children('.liRight').children('.infor').text(news);
		$('.RightCont').scrollTop($('.RightCont')[0].scrollHeight );
	}
	
	})
	function answers(msg,sendImg){
		var answer='';
		answer+='<li><div class="answerHead">';
		answer+='<img src="'+sendImg+'"/>';
		answer+='</div>'+'<div class="answers"><img class="jiao" src="'+path+'img/jiao.jpg">'+msg+'</div>'+
				'</li>';
		$('.newsList').append(answer);	
		$('.RightCont').scrollTop($('.RightCont')[0].scrollHeight );
	}
	$('.ExP').on('click',function(){
		var isShow = $($(".emjon")[0]).css("display");
		if(isShow=='none'){
			$('.emjon').show();	
		}else{
			$('.emjon').hide();
		}
		
	})
	$('.emjon').on('mouseleave',function(){
		$('.emjon').hide();
	})
	$('.emjon li').on('click',function(){
		var imgSrc=$(this).children('img').attr('src');
		var str="";
		str+='<li>'+
				'<div class="nesHead"><img src="img/6.jpg"/></div>'+
				'<div class="news"><img class="jiao" src="img/20170926103645_03_02.jpg"><img class="Expr" src="'+imgSrc+'"></div>'+
			'</li>';
		$('.newsList').append(str);
		$('.emjon').hide();
		$('.RightCont').scrollTop($('.RightCont')[0].scrollHeight );
	})