function onload(bodyStyle,qualification,imgName){
	var result = init(qualification);
	//如果没有抽奖权利，则直接返回
	if(!result){
		return;
	}
	bodyStyle.mozUserSelect = 'none';
	bodyStyle.webkitUserSelect = 'none';
	var img = new Image();
	var canvas = document.getElementById("myCanvas");
	canvas.style.backgroundColor='transparent';         
	canvas.style.position = 'absolute';
	img.addEventListener('load',function(e){
		var ctx;
		var w = img.width, h = img.height;
		var offsetX = canvas.offsetLeft, offsetY = canvas.offsetTop;
		var mousedown = false;
		function layer(ctx){                 
			ctx.fillStyle = 'gray';
			ctx.fillRect(0, 0, w, h);
		}   
		function eventDown(e){                 
			e.preventDefault();
			mousedown=true;
		}   
		function eventUp(e){                 
			e.preventDefault();
			mousedown=false;
		}               
		function eventMove(e){                 
			e.preventDefault();                 
			if(mousedown){                     
				if(e.changedTouches){                         
					e=e.changedTouches[e.changedTouches.length-1];                     
				}                     
				var x = (e.clientX + document.body.scrollLeft || e.pageX) - offsetX || 0,                         
				y = (e.clientY + document.body.scrollTop || e.pageY) - offsetY || 0;                     
				with(ctx){                    
					beginPath();
					arc(x, y, 10, 0, Math.PI * 2);
					fill();                     
				}                
			}             
		}               
		canvas.width=w;             
		canvas.height=h;             
		canvas.style.backgroundImage='url('+img.src+')';             
		ctx=canvas.getContext('2d');             
		ctx.fillStyle='transparent';             
		ctx.fillRect(0, 0, w, h);             
		layer(ctx);               
		ctx.globalCompositeOperation = 'destination-out';               
		canvas.addEventListener('touchstart', eventDown);             
		canvas.addEventListener('touchend', eventUp);             
		canvas.addEventListener('touchmove', eventMove);             
		canvas.addEventListener('mousedown', eventDown);             
		canvas.addEventListener('mouseup', eventUp);             
		canvas.addEventListener('mousemove', eventMove);       
	});
	img.src = imgName;
};

//初始化表格位置
function initPosition(divId,tabId){
	var winningDiv = $("#"+divId);
	var myTable = $("#"+tabId);
	var winningDivWidth = winningDiv.css("width");
	myTable.css("width",winningDivWidth);
	myTable = document.getElementById(tabId);
	winningDiv.css("left",myTable.getBoundingClientRect().left);
}

//初始化数据，表格、以及是否有抽奖资格
function init(qualification){
	var result = false;
	if(qualification){
		$("#winningDiv").css("marginTop",150);
		initPosition("canvasTable_tmp","canvasTable");
		result = true;
	}else{
		var tab = document.getElementById("canvasTable");
		tab.style.display = "none";
	}
	return result;
}

//查看中奖记录
function lookupFun(id){
	var ul = document.getElementById(id);
	if("none" == ul.style.display){
		ul.style.display = "block";
	}else{
		ul.style.display = "none";
	}
}