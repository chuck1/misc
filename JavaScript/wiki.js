function load(file,id)
{
	alert("file="+file);
	var client = new XMLHttpRequest();
	client.open('GET', file);
	client.onreadystatechange = function()
	{
		//alert("received");
		document.getElementById(id).innerHTML = client.responseText;
		MathJax.Hub.Queue(["Typeset",MathJax.Hub]);
	}
	client.send();
}
function loadxml(file)
{
	var client = new XMLHttpRequest();
	client.open('GET', file);
	client.onreadystatechange = function()
	{
		xmlDoc=client.responseXML;

		var list = subxml(xmlDoc.firstChild,"");

		document.getElementById("xml").appendChild(list);
	}
	client.send();
}
function subxml(xmlDoc,url)
{
	var list = document.createElement("UL");

	var c = xmlDoc.childNodes;
	for(var i=0;i<c.length;++i)
	{
		//alert(c[i].nodeName)
		if(c[i].nodeName=="folder")
		{
			list.appendChild(loadxmlfolder(c[i],url));
		}
	}

	return list;
}
function loadxmlfolder(xmlEl,url)
{
	//alert(url);
	var name = xmlEl.attributes.getNamedItem("name").value;

	var myurl = url + name + "/";

	var item = document.createElement("LI");
	var list = document.createElement("UL");
	var butn = document.createElement("BUTTON");
	var text = document.createTextNode(name);

	var sublist = subxml(xmlEl,myurl);

	var callback = document.createAttribute("onclick");
	callback.nodeValue = "load\('" + myurl + "index.html','cont'\)";
	//alert(callback.nodeValue);

	butn.appendChild(text);
	butn.attributes.setNamedItem(callback);


	var c = xmlEl.childNodes;
	for (var j = 0; j < c.length; ++j)
	{
		if(c[j].nodeName=="page")
		{
			list.appendChild(loadxmlpage(c[j],myurl));
		}
	}

	item.appendChild(butn);
	item.appendChild(sublist);		
	item.appendChild(list);

	return item;
}
function loadxmlpage(xmlEl,url)
{
	var attr = xmlEl.attributes;
	var nameattr = attr.getNamedItem("name");
	var name = nameattr.value;

	var item = document.createElement("LI");
	var butn = document.createElement("BUTTON");

	var text = document.createTextNode(name);	
	var callback = document.createAttribute("onclick");

	callback.nodeValue = "load('" + url + name + "','cont')";


	butn.appendChild(text);
	butn.attributes.setNamedItem(callback);

	item.appendChild(butn);

	return item;

}

