<h1>Shane and Daesy's Bitmap Transformer</h1>

In order to use our Bitmap transformer, simply copy a file path to a .bmp file. You can then open the command 
line at the correct directory and type `./gradlew run` follow by a string. This string accepts a series of arguments
the first of which is the file path you have copied to your clipboard. The second argument is a destination for the
new .bmp file our transformer will create. For the third argument, refer below.

<ul>
<li>greyScale: This will output a new bitmap that is a grey Scale version of the original.</li>
<li>turnGrey: This will output a new bitmap that has had 75% of the color removed from the original.</li>
<li>twoHeads: This will output a new bitmap that is mirrored diagonally. If you use Mario, he appers to
have two heads.</li>
</ul>