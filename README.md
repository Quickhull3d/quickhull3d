com.github.quickhull3d - A Robust 3D Convex Hull Algorithm in Java
===========

This is a 3D implementation of QuickHull for Java, based on the original paper by Barber, Dobkin, and Huhdanpaa and the C implementation known as qhull. The algorithm has O(n log(n)) complexity, works with double precision numbers, is fairly robust with respect to degenerate situations, and allows the merging of co-planar faces.

A tutorial on the QuickHull algorithm by Dirk Gregorius (Valve Software) was given at the 2014 Game Developers Conference in San Francisco.

There are some other 3D convex hull implementations available in netland, but I didn't find any that satisfied all the above criteria, so I created my own. The principal class is QuickHull3D, which is contained within the package com.github.quickhull3d. It is actually a reimplementaion of an earlier piece of work, ConvexHull3D, which was based on an insertion algorithm and had a complexity of O(n^2).

Mark Newbold has used this package to create a very picturesque applet that creates and displays Waterman polyhedra 

See the maven project site here: [quickhull3d](http://quickhull3d.github.io/quickhull3d/)
