(function() {
    var requestAnimationFrame = window.requestAnimationFrame || window.mozRequestAnimationFrame || window.webkitRequestAnimationFrame || window.msRequestAnimationFrame;
    window.requestAnimationFrame = requestAnimationFrame;
})();
document.getElementById("yeet").addEventListener("click", function() {
    alert("javascript is best girl");
});
//dont look at me like that
var canvas = document.getElementById("canvas");
var ctx = canvas.getContext("2d");
var width = 800;
var height = 600;
canvas.width = width;
canvas.height = height;

var cursor = {
    x: 0,
    y: 0
};

ctx.fillStyle = "#45F9C3";
ctx.fillRect( 0, 0, width, height );
var start = {
    x : width / 2 - 200,
    y : height * 3 / 5,
    width : 400,
    height : 50
}

function update(){
    console.log( 'ran' );
    function game(){

    }

    function title(){
        ctx.fillStyle = '#FFFF33';
        ctx.fillRect( start.x, start.y, start.width, start.height );
        //dont look at me
    }

    function win(){
        console.log( 'fword' );
    }

    title();
    requestAnimationFrame(update);
}

canvas.addEventListener("click", function(){

});
window.addEventListener("load", function(){
    console.log( 'death grips is online');
    update();
});
canvas.addEventListener("mousemove", function(e){
    cursor.x = e.x - canvas.offsetLeft;
    cursor.y = e.y - canvas.offsetTop + 1;
    console.log( cursor.x + " " + cursor.y );
});
