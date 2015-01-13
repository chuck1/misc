<?php


$root = "/nfs/stak/students/r/rymalc/public_html/";
$home = $root . "doc/";

echo $home . "<br>";

// post
if ( isset($_POST["title"]) )
{
	$title = $_POST["title"];
}
else
{
	$title = "untitled";
}


if ( isset($_POST["page"]) )
{
	$page = $_POST["page"];
}
else
{
	$page = "pages/index.php";
}

$page = $home . $page;

if (file_exists($page))
{
	require_once $page;
}
else
{
	die("page not found: " . $page);
}


if (file_exists($root . 'head.php'))
{
	//echo "file found!";
}
else
{
	die("file not found: ");
}
if (file_exists($home . 'side.php'))
{
	//echo "file found!";
}
else
{
	die("file not found: ");
}
if (file_exists($root . 'page.php'))
{
	//echo "file found!";
}
else
{
	die("file not found: ");
}

echo "pages found";

require_once $root . 'head.php';
require_once $home . 'side.php';
require_once $root . 'page.php';




?>
