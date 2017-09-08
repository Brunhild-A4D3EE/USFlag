# USFlag                                  flag README

Introduction
--------------------

This program produces an Applet which displays the United States flag to scale 
Using Java’s built-in graphics libraries and trigonometry.

Specification
--------------------

This program successfully draw a US flag which match the proportions of “standard
Proportions for the United States flag” and color code. This flag is resizable
by dragging the window.


Errors
--------------------

No notable errors exist in the program. However, because the proportion of the flag
is depended on the width of the window, therefore, if window’s height is too small,
Part of the flag would not show on the window but exist beyond the window.

Overview of Code
--------------------

There are one class in this program. The USFlag class extends the JFrame class
And contain a JPanel. The stripe and union is draw with fillRect method, while
Stars are draw with fillPolygon method with calculation of xy coordinate 
Based on unit circle and trigonometry. The scale variable is calculated based on
Width of the window. JPanel is added to USFlag frame when it is draw, then main 
function initialize the USFlag.

Major Challenge
--------------------

The major challenge is drawing the stars. After receiving hints from teacher,
I realize the trigonometry function can be used to find the point of star.
Hence, I use Math package, draw two polygons(spike of star and inner polygon) 
to composed a star.

Acknowledgements
--------------------

I would like to thank my teacher for talking and giving me hint about this project.
