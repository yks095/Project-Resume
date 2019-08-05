$(function() {
    $('#introduction_growth').keyup(function (e){
        var introduction_growth = $(this).val();
        $(this).height(((introduction_growth.split('\n').length + 1) * 1.5) + 'em');
        $('#growth_counter').html(introduction_growth.length + '/5000');
    });
    $('#introduction_growth').keyup();
});

$(function() {
    $('#introduction_reason').keyup(function (e){
        var introduction_reason = $(this).val();
        $(this).height(((introduction_reason.split('\n').length + 1) * 1.5) + 'em');
        $('#reason_counter').html(introduction_reason.length + '/5000');
    });
    $('#introduction_reason').keyup();
});

$(function() {
    $('#introduction_strength').keyup(function (e){
        var introduction_strength = $(this).val();
        $(this).height(((introduction_strength.split('\n').length + 1) * 1.5) + 'em');
        $('#strength_counter').html(introduction_strength.length + '/5000');
    });
    $('#introduction_strength').keyup();
});

$(function() {
    $('#introduction_weakness').keyup(function (e){
        var introduction_weakness = $(this).val();
        $(this).height(((introduction_weakness.split('\n').length + 1) * 1.5) + 'em');
        $('#weakness_counter').html(introduction_weakness.length + '/5000');
    });
    $('#introduction_weakness').keyup();
});

$(function() {
    $('#introduction_aspiration').keyup(function (e){
        var introduction_aspiration = $(this).val();
        $(this).height(((introduction_aspiration.split('\n').length + 1) * 1.5) + 'em');
        $('#aspiration_counter').html(introduction_aspiration.length + '/5000');
    });
    $('#introduction_aspiration').keyup();
});







$(function() {
    $('#show_growth').keyup(function (e){
        var show_growth = $(this).val();
        $(this).height(((show_growth.split('\n').length + 1) * 1.5) + 'em');
        $('#growth_counter2').html(show_growth.length + '/5000');
    });
    $('#show_growth').keyup();
});

$(function() {
    $('#show_reason').keyup(function (e){
        var show_reason = $(this).val();
        $(this).height(((show_reason.split('\n').length + 1) * 1.5) + 'em');
        $('#reason_counter2').html(show_reason.length + '/5000');
    });
    $('#show_reason').keyup();
});

$(function() {
    $('#show_strength').keyup(function (e){
        var show_strength = $(this).val();
        $(this).height(((show_strength.split('\n').length + 1) * 1.5) + 'em');
        $('#strength_counter2').html(show_strength.length + '/5000');
    });
    $('#show_strength').keyup();
});

$(function() {
    $('#show_weakness').keyup(function (e){
        var show_weakness = $(this).val();
        $(this).height(((show_weakness.split('\n').length + 1) * 1.5) + 'em');
        $('#weakness_counter2').html(show_weakness.length + '/5000');
    });
    $('#show_weakness').keyup();
});

$(function() {
    $('#show_aspiration').keyup(function (e){
        var show_aspiration = $(this).val();
        $(this).height(((show_aspiration.split('\n').length + 1) * 1.5) + 'em');
        $('#aspiration_counter2').html(show_aspiration.length + '/5000');
    });
    $('#show_aspiration').keyup();
});