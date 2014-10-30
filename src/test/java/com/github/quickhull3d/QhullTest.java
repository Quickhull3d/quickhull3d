package com.github.quickhull3d;

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

class QhullTest {

    static double[] coords = new double[]{};

    static int[][] faces = new int[][]{};

    public static void main(String[] args) {
        QuickHull3D hull = new QuickHull3D();
        QuickHull3DTest tester = new QuickHull3DTest();

        hull = new QuickHull3D();

        for (int i = 0; i < 100; i++) {
            double[] pnts = tester.randomCubedPoints(100, 1.0, 0.5);

            hull.setFromQhull(pnts, pnts.length / 3, /* triangulated= */false);

            pnts = tester.addDegeneracy(QuickHull3DTest.VERTEX_DEGENERACY, pnts, hull);

            // hull = new QuickHull3D ();
            hull.setFromQhull(pnts, pnts.length / 3, /* triangulated= */true);

            if (!hull.check(System.out)) {
                System.out.println("failed for qhull triangulated");
            }

            // hull = new QuickHull3D ();
            hull.setFromQhull(pnts, pnts.length / 3, /* triangulated= */false);

            if (!hull.check(System.out)) {
                System.out.println("failed for qhull regular");
            }

            // hull = new QuickHull3D ();
            hull.build(pnts, pnts.length / 3);
            hull.triangulate();

            if (!hull.check(System.out)) {
                System.out.println("failed for QuickHull3D triangulated");
            }

            // hull = new QuickHull3D ();
            hull.build(pnts, pnts.length / 3);

            if (!hull.check(System.out)) {
                System.out.println("failed for QuickHull3D regular");
            }
        }
    }
}
