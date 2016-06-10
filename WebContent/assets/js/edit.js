function editinfo(){
    var $form = $("form:last");
    var $postdata = $form.serializeArray();
    $.post('editinfo.html', $postdata, function(data){
        if(data == '0'){
            alert('插入成功');
        }else{
            alert('有点问题,再试试');
        }
    });
}

function editschool(){
    var $tbody = $("#mainbody");
    var $postdata = serializeTable($tbody);
    $.post('editschool.html', JSON.stringify($postdata), function(data){
        if(data == '0'){
            alert('插入成功');
        }else{
            alert('有点问题,再试试');
        }
    });
}

function editjob(){
    var $tbody = $("#mainbody");
    var $postdata = serializejobTable($tbody);
    $.post('editjob.html', JSON.stringify($postdata), function(data){
        if(data == '0'){
            alert('插入成功');
        }else{
            alert('有点问题,再试试');
        }
    });
}

function serializeTable($tbody){
    var $robjs = [];
    var $trows = $tbody.find("tr");
    for(var k=0; k < $trows.length; k++){
        var $robj = {};
        if($trows[k].style.display == 'none') continue;
        var $tcols = $trows[k].getElementsByTagName("td");
        for(var i = 1; i < $tcols.length; i++){
            $robj[$tcols[i].getAttribute('data-field')] = $tcols[i].innerHTML;
        }
        if(!isEmptyObject($robj)) $robjs.push($robj);
    }
    return $robjs;
}

function serializejobTable($tbody){
    var $robjs = [];
    var $trows = $tbody.find("tr");
    for(var k = 0; k < $trows.length; k++){
        if($trows[k].style.display == 'none') continue;
        var $robj = {};
        var $tcols = $trows[k].getElementsByTagName("td");
        for(var i = 1; i < $tcols.length; i++){
            if($tcols[i].getElementsByTagName("select").length > 0){
                $robj[$tcols[i].getAttribute('data-field')] = $($tcols[i].getElementsByTagName("select")[0]).val();
            }else $robj[$tcols[i].getAttribute('data-field')] = $tcols[i].innerHTML;
        }
        if(!isEmptyObject($robj)) $robjs.push($robj);
    }
    return $robjs;
}

$("#logoutbtn").click(function(){
	$.get("logout.html?state=0");
	window.location.href="index.html";
});

function isEmptyObject(e){
    var t
    for(t in e)
        return !1;
    return !0;
}