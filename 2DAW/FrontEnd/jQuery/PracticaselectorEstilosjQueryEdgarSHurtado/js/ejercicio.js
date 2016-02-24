/**
 * Created by Edgar S. Hurtado on 23/02/16.
 */

function deleteClasses(){
    $('.red').removeClass('red');
    $('.blue').removeClass('blue');
    $('.green').removeClass('green');
}


$('#btn_aplicar').click(function(){
    deleteClasses();
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
    deleteClasses();
})
