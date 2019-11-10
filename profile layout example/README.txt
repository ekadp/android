This is a layout for Programmer Profile.

You can design your own layout similar to this layout, to make your own Profile Page in Android.

For example about how the layout would look like, please see the picture in "result-example.jpg".



--- WHAT IS THIS EXAMPLE ---
This layout example is for usage in Android Studio IDE (Integrated Development Environment).

This layout example is an activity form.



--- HOW TO USE ---
(1) Install newest Android Studio IDE, if you haven't installed it at all.

(2) Open Android Studio, and make New Project.

(3) Make new Empty Activity, and name it "Activity_AboutProgrammer".

(4) Using Windows Explorer, open "yourapp\app\src\main\res\layout".

(5) Copy-paste folder "layout" content there.

(6) Using Windows Explorer, open "yourapp\app\src\main\res\drawable".

(7) Copy-paste folder "drawable" contents there.

(8) Try to see the change in your Android Studio Activity, or try to run it using "Run > Run App".



--- MORE EXPLANATION ---
I am using Card View there to make rounded image, by using "app:cardCornerRadius" property.

To make circle, what you should do is just to set "app:cardCornerRadius" property to half of 
the image. For example, if your image is 90dp x 90 dp in width and height, so all you need
to do is set app:cardCornerRadius = "45dp". Here 45dp is meant half the size of the image.

More over, to make the background more beautiful, I put texture image 
in my "android:background" property. By using this way, you can put any image to
a layout background to beautify your interface design.



--- MORE SUGGESTION ---
If you want to make the drawables in this layout more responsive to any screen resolution
for any smartphone, the you should using the Vector Drawable format.

Vector Drawable format is a xml file consist of image data.

Unlike bitmap format file like *.jpg or *.png, Vector Drawable is a vector image. So it
can be scaled to any resolution, without loss of quality. 

By using Vector Drawable, user of your app will see clearer image, whatever their
smartphone resolution is. It increase your app UI and UX.


--- DISCLAIMER FOR THE IMAGE ---
I am using free picture from Freepik for this app. If you like the images in this layout,
please come visit the web below:

https://www.freepik.com/free-photos-vectors/background

https://www.freepik.com/free-photos-vectors/background-texture

https://www.freepik.com/collection/advanced-social-media/

Freepik is the one of ones that provide good pictures and icons for any professional works.

