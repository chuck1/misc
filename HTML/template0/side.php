<?php
echo "side<br>";

$xmlfilename = 'pages';

If (file_exists($xmlfilename . '.xml'))
{
	$xmlobj = simplexml_load_file($xmlfilename . '.xml');
}
else
{
	die('Failed to open ' . $xmlfilename . '.xml.');
}

$html = process_folder($xmlobj,0,"","");

$side = <<<_END
	<div class="col">
{$html}
	</div>
_END;



?>
