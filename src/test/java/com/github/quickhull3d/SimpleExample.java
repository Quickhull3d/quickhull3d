package com.github.quickhull3d;

import com.github.quickhull3d.Point3d;
import com.github.quickhull3d.QuickHull3D;

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
 * Simple example usage of QuickHull3D. Run as the command
 * 
 * <pre>
 *   java com.github.quickhull3d.SimpleExample
 * </pre>
 */
public class SimpleExample {

    /**
     * Run for a simple demonstration of QuickHull3D.
     */
    public static void main(String[] args) {
        // x y z coordinates of 6 points
        Point3d[] points = new Point3d[]{
            new Point3d(0.0, 0.0, 0.0),
            new Point3d(1.0, 0.5, 0.0),
            new Point3d(2.0, 0.0, 0.0),
            new Point3d(0.5, 0.5, 0.5),
            new Point3d(0.0, 0.0, 2.0),
            new Point3d(0.1, 0.2, 0.3),
            new Point3d(0.0, 2.0, 0.0),
        };

        QuickHull3D hull = new QuickHull3D();
        hull.build(points);

        System.out.println("Vertices:");
        Point3d[] vertices = hull.getVertices();
        for (int i = 0; i < vertices.length; i++) {
            Point3d pnt = vertices[i];
            System.out.println(pnt.x + " " + pnt.y + " " + pnt.z);
        }

        System.out.println("Faces:");
        int[][] faceIndices = hull.getFaces();
        for (int i = 0; i < vertices.length; i++) {
            for (int k = 0; k < faceIndices[i].length; k++) {
                System.out.print(faceIndices[i][k] + " ");
            }
            System.out.println("");
        }
    }
}
