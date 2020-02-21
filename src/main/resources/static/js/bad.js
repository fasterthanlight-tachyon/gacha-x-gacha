(function() {
    var requestAnimationFrame = window.requestAnimationFrame || window.mozRequestAnimationFrame || window.webkitRequestAnimationFrame || window.msRequestAnimationFrame;
    window.requestAnimationFrame = requestAnimationFrame;
})(); // dog balls lmao

//dont look at me like that
var canvas = document.getElementById("canvas");
var ctx = canvas.getContext("2d");
var width = 800;
var height = 600;
canvas.width = width;
canvas.height = height;
var op = true;
var gamer = false;
var cursor = {
    x: 0,
    y: 0,
    width : 10,
    height : 10,
    click : false
};

ctx.fillStyle = "#45F9C3";
ctx.fillRect( 0, 0, width, height );
var start = {
    x : width / 2 - 200,
    y : height * 3 / 5,
    width : 400,
    height : 50
}
console.log( 'test' );
function update() {
    console.log( 'ran' );
    function game() {

    }

    function title() {
        ctx.fillStyle = '#CCFFCC';
        ctx.fillRect( start.x, start.y, start.width, start.height );
        //dont look at me
        if(cursor.click && tag(start, cursor)) {
            alert( 'it has begun' );
            op = false;
            gamer = true;
        }
    }

    function win() {
        console.log( 'fword' );
    }

    if (op) {
        title();
    }
    if (gamer) {
        game();
    }
    requestAnimationFrame(update);
}

window.addEventListener("click", function(){
    cursor.click = true;
    window.setTimeout( function(){
        cursor.click = false;
    }, 10 );
    console.log( 'update' );
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

function tag(one, two){
    var vx = (one.x + (one.width/2) ) - (two.x + (two.width/2) );
    var vy = one.y + (one.height/2) - two.y - two.width/2;

    var hwidths = one.width/2 + two.width/2;
    var hheights = one.height/2 + two.height/2;

    return Math.abs(vx) < hwidths && Math.abs(vy) < hheights;
}