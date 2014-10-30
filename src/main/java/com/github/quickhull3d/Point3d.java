package com.github.quickhull3d;

/*
 * #%L
 * A Robust 3D Convex Hull Algorithm in Java
 * %%
 * Copyright (C) 2004 - 2014 John E. Lloyd
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Lesser Public License for more details.
 * 
 * You should have received a copy of the GNU General Lesser Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/lgpl-3.0.html>.
 * #L%
 */

/**
 * A three-element spatial point. The only difference between a point and a
 * vector is in the the way it is transformed by an affine transformation. Since
 * the transform method is not included in this reduced implementation for
 * QuickHull3D, the difference is purely academic.
 * 
 * @author John E. Lloyd, Fall 2004
 */
public class Point3d extends Vector3d {

    /**
     * Creates a Point3d and initializes it to zero.
     */
    public Point3d() {
    }

    /**
     * Creates a Point3d by copying a vector
     * 
     * @param v
     *            vector to be copied
     */
    public Point3d(Vector3d v) {
        set(v);
    }

    /**
     * Creates a Point3d with the supplied element values.
     * 
     * @param x
     *            first element
     * @param y
     *            second element
     * @param z
     *            third element
     */
    public Point3d(double x, double y, double z) {
        set(x, y, z);
    }
}
