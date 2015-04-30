var mytab = null;
currentRow = 0;
currentCell = 0;
var cTrue;
var wrong;
var place;
var win;
var notWord;
var dataArray = jQuery.parseJSON("[[1,1,1,0,-1,1,1,1]]");
var disableW = false;
var trueChars = new Array('','','','','','','','');
removeHr=function(elem){
	$(elem).find("div").find("hr").remove();
}
removeAllHr=function()
{
	$(mytab).find("hr").remove();
}
addHr=function(elem){
	removeAllHr();
	mydiv = $(elem).find("div");
	myclass= "notemptyhr";
	if ($(mydiv).is(':empty')){
		myclass="emptyhr";
	}
	$(mydiv).append("<hr>");
	$(mydiv).find("hr").addClass(myclass);
}
addChar=function(ch)
{
	addCharAt(ch,currentCell);
}
addCharAt=function(ch,cell)
{
	mydiv = $(mytab.rows[currentRow].cells[cell]).find("div");
	$(mydiv).empty();
	$(mydiv).append(ch);	
}
moveCurr=function()
{
	addHr($(mytab.rows[currentRow].cells[currentCell]));
}
getWord=function()
{
	text = "";
	for(i = 0; i < 7; i++)
	{
		text+=""+$(mytab.rows[currentRow].cells[i]).text();
	}
	return text;
}
nextLinePlay=function()
{
	currentRow++;
	currentCell = 0;
	for(i = 0; i < 7; i++)
		addCharAt(trueChars[i],i);
	moveCurr();
	disableW = false;
}
verfiWord=function(arr)
{
	disableW = true;
	word = getWord();
	if(word.length < 7)
	{
		notWord.play();
		nextLinePlay();
	}
	else
	{
		animResp(dataArray,word);
	}
		
}
animResp=function(arr,word)
{
	if(arr[0][0]==0)
	{
		notWord.play();
		nextLinePlay();
		return;
	}
	var allTrue = true;
	indice = 1;
	var timer = setInterval(
		function() 
		{
			if(arr[0][indice] >=0)
			{
				myClass = "place"
				if(arr[0][indice] == 1)
				{
					myClass = "true"
					cTrue.play();
					trueChars[indice-1] = word.charAt(indice-1)
				}
				else
				{
					place.play();
					allTrue = false;
				}
				$(mytab.rows[currentRow].cells[indice-1]).find("div").addClass(myClass);
			}
			else
			{
				wrong.play();
				allTrue = false;
			}
			indice++;
			if(indice > 7)
			{
				if(allTrue)
				{
					win.play();
				}
				else
					nextLinePlay();					
				clearInterval(timer);
			}
		}, 500
	);
}
$( document ).ready(function() {
	//document.onkeypress =  zx;
	cTrue = document.createElement('audio');
	cTrue.setAttribute('src', 'javax.faces.resource/true.mp3.jsf?ln=sound');
	wrong = document.createElement('audio');
	wrong.setAttribute('src', 'javax.faces.resource/wrong.mp3.jsf?ln=sound');
	place = document.createElement('audio');
	place.setAttribute('src', 'javax.faces.resource/place.mp3.jsf?ln=sound');
	win = document.createElement('audio');
	win.setAttribute('src', 'javax.faces.resource/win.mp3.jsf?ln=sound');
	notWord = document.createElement('audio');
	notWord.setAttribute('src', 'javax.faces.resource/notword.mp3.jsf?ln=sound');
	mytab = document.getElementById("lettresTable");
	$('html').keydown(function(e){
		if(disableW)
			return;
		var charCode = (typeof e.which == "number") ? e.which : e.keyCode
		if ((charCode >= 97 && charCode <= 122) || (charCode >= 65 && charCode <= 90) && currentCell < 7)
		{
			addChar(String.fromCharCode(charCode).toUpperCase());
			removeAllHr();
			if(currentCell<7)
			{
				currentCell++;
				moveCurr();
			}
		}
		else if(charCode == 8 && currentCell > 0)
		{
			if(currentCell<7)
			{
				addChar("");
				removeAllHr();
			}
			if(currentCell >1)
			{
				//console.log("moved");
				currentCell--;
				moveCurr();
			}
		}
		else if(charCode == 13 && currentRow < 4)
		{
			removeAllHr();
			verfiWord(dataArray);
		}
	});
	addHr(mytab.rows[currentRow].cells[currentCell]);
});