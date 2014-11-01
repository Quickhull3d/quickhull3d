package com.github.quickhull3d;

import com.github.quickhull3d.Point3d;
import com.github.quickhull3d.QuickHull3D;

/*
 * #%L
 * A Robust 3D Convex Hull Algorithm in Java
 * %%
 * Copyright (C) 2004 - 2014 John E. Lloyd
 * %%
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * 
 * 1. Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDERS OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
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
