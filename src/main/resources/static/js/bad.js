console.log("ouch");
document.getElementById("yeet").addEventListener("click", function() {
    alert("javascript is best girl");
});
var canvas = document.getElementById("canvas");
var ctx = canvas.getContext("2d");
var width = 800;
var height = 600;
canvas.width = width;
canvas.height = height;

ctx.fillStyle = "45F9C3";
ctx.beginPath();
ctx.fillRect( 0, 0, width, height );

canvas.addEventListener("click", function(){
    alert("ouch");
});