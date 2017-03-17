function space(text)
{
	if(text.value.match(/\s/))
	{
		text.value=text.value.replace(/\s/,'');
	}
//	if(document.myform.fname.value==' '){
//		document.myform.fname.value.replace(/\s/,'');}
}
function nodigit(text)
{
	if(text.value.match(/[0-9]/))
	{
		text.value=text.value.replace(/[0-9]/,'');
	}
}
function onlydigit(text)
{
	if(text.value.match(/[^0-9]/))
	{
		text.value=text.value.replace(/[^0-9]/,'');
	}
}
function onlytext(text)
{
	if(text.value.match(/[^A-Z+a-z]/))
	{
		text.value=text.value.replace(/[^A-Z+a-z]/,'');
	}
}