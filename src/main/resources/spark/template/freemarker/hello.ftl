<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
  "http://www.w3.org/TR/html4/loose.dtd">
<html lang="ja">
<head>
  <meta http-equiv="content-type" content="text/html;charset=utf-8"/>
  <title>SparkJava Boilerplate</title>
  <script type="text/javascript" src="http://code.jquery.com/jquery-2.1.1.js"></script>
  <script type="text/javascript" src="./js/md5.js"></script>
</head>
<body>
<script type="text/javascript">
<!--
    $(document).ready(function () {
        $('#poke').click(function () {
            $.ajax({
                type: 'POST',
                url: '/hello',
                dataType: 'json',
                data: JSON.stringify({ value: 'Ping', digit: CybozuLabs.MD5.calc(Math.random()) })
            })
            .done(function (data) { $('#console').append(JSON.stringify(data) + "<br/>") })
            .fail(function (data) { alert('fail') })
            .always(function (data) { });
        })
    })
-->
</script>

<h1>${title}</h1>
<h1>The above text is set using a FreeMarkerEngine</h1>

<input id="poke" value="Ping" type="button"/>
<div id="console"></div>

</body>
</html>