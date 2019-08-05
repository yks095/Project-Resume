$('#save_introduction').click(function () {

    var jsonData = JSON.stringify({
        title: $('#introduction_title').val(),
        growth: $('#introduction_growth').val(),
        reason: $('#introduction_reason').val(),
        strength: $('#introduction_strength').val(),
        weakness: $('#introduction_weakness').val(),
        aspiration: $('#introduction_aspiration').val()
    });
    $.ajax({
        url: "http://localhost:8080/introduction/save",
        type: "POST",
        data: jsonData,
        contentType: "application/json",
        dataType: "json",
        success: function () {
            location.href = '/introduction';
        },
        error: function () {
            alert('저장 실패!');
        }
    });
});

$('.deleteButton').click(function () {
    $.ajax({
        url: "http://localhost:8080/introduction/delete/" + $(this).val(),
        type: "DELETE",
        contentType: "application/json",
        success: function () {
            alert('삭제 성공!');
            location.reload();
        },
        error: function () {
            alert('삭제 실패!');
        }
    });
});

$('.lookButton').click(function () {

    location.href = "/introduction/look/" + $(this).val();

});

$('.modifyButton').click(function () {

    var jsonData = JSON.stringify({
        title: $(this).parent().parent().find('.show_title').text(),
        growth: $(this).parent().parent().find('.show_growth').text(),
        reason: $(this).parent().parent().find('.show_reason').text(),
        strength: $(this).parent().parent().find('.show_strength').text(),
        weakness: $(this).parent().parent().find('.show_weakness').text(),
        aspiration: $(this).parent().parent().find('.show_aspiration').text()
    });

    $.ajax({
        url: "http://localhost:8080/introduction/modify/" + $(this).val(),
        type: "PUT",
        data: jsonData,
        contentType: "application/json",
        dataType: "json",
        success: function () {
            alert('수정 성공!');
            location.reload();
        },
        error: function () {
            alert('수정 실패!');
        }
    });
});

$('.completeButton').click(function () {

    location.href = "/introduction";

});
