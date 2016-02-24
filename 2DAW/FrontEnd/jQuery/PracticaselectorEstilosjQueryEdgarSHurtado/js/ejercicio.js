/**
 * Created by Edgar S. Hurtado on 23/02/16.
 */

$('#btn_aplicar').click(function(){
    var $classToApply = $('#estilo-aplicar').val();

    var domSeleccionado = $('[name="elementosSeleccion"]:checked');

    domSeleccionado.each(function(){
        var elementos = $($(this).val());
        elementos.each(function(){
            $(this).addClass($classToApply);
        })
    })
});

$('#btn_nomalidad').click(function(){
    $('.red').removeClass('red');
    $('.blue').removeClass('blue');
    $('.green').removeClass('green');
})
